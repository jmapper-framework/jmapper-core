/**
 * Copyright (C) 2012 - 2013 Alessandro Vurro.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.googlecode.jmapper.operations;

import static com.googlecode.jmapper.config.Constants.THE_FIELD_IS_NOT_CONFIGURED;
import static com.googlecode.jmapper.util.ClassesManager.defineStructure;
import static com.googlecode.jmapper.util.ClassesManager.getListOfFields;
import static com.googlecode.jmapper.util.ClassesManager.retrieveField;
import static com.googlecode.jmapper.util.ClassesManager.verifiesAccessorMethods;
import static com.googlecode.jmapper.util.ClassesManager.verifiesGetterMethods;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.googlecode.jmapper.config.ConfigReader;
import com.googlecode.jmapper.config.Error;
import com.googlecode.jmapper.conversions.explicit.ConversionAnalyzer;
import com.googlecode.jmapper.conversions.explicit.ConversionHandler;
import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.enums.OperationType;
import com.googlecode.jmapper.generation.beans.Method;
import com.googlecode.jmapper.operations.complex.AComplexOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.operations.recursive.ARecursiveOperation;
import com.googlecode.jmapper.operations.simple.ASimpleOperation;
import com.googlecode.jmapper.xml.XML;

/**
 * OperationHandler creates the operations necessary to execute the mapping.
 * 
 * @author Alessandro Vurro
 *
 */
public final class OperationHandler {
	
	/** list of simple operations */
	private List<ASimpleOperation> simpleOperations;
	/** list of complex operations */
	private List<AComplexOperation> complexOperations;
	/** Destination class */
	private final Class<?> destinationClass;
	/** Source class */
	private final Class<?> sourceClass;
	/** Destination class */
	private final Class<?> configuredClass;
	/** Source class */
	private final Class<?> targetClass;
	/** configuration chosen */
	private final ChooseConfig configurationChosen;
	/** true if destination is configured, false if source is configured */
	private final boolean isDestConfigured;
	/** XML object */
	private final XML xml;
	/** config reader */
	private final ConfigReader configReader;
	/** operation analyzer */
	private final OperationAnalyzer operationAnalyzer;
	/** explicit conversion reader */
	private final ConversionAnalyzer conversionAnalyzer;
	/** explicit conversion handler */
	private final ConversionHandler conversionHandler;
	
	public OperationHandler(Class<?> aDestinationClass, Class<?> aSourceClass, ChooseConfig aConfigurationChosen, XML aXml) {
		
		// initialization of operation lists and xml
		simpleOperations = new ArrayList<ASimpleOperation>();
		complexOperations = new ArrayList<AComplexOperation>();
		xml = aXml;
		
		// identification of the classes role
		destinationClass = aDestinationClass;
		sourceClass = aSourceClass;
		configurationChosen = aConfigurationChosen;
		isDestConfigured = configurationChosen == ChooseConfig.DESTINATION;  
		configuredClass = isDestConfigured?destinationClass:sourceClass;
		targetClass = isDestConfigured?sourceClass:destinationClass;
		
		// initialization dependencies
		configReader = new ConfigReader(configuredClass, targetClass, xml);
		operationAnalyzer = new OperationAnalyzer(xml);
		conversionHandler = new ConversionHandler(xml,destinationClass,sourceClass);
		conversionAnalyzer = new ConversionAnalyzer(xml,configurationChosen,destinationClass,sourceClass);
	}
	
	/**
	 * This method calculates and loads the lists relating to the operations to be performed.
	 * @param methodsToGenerate methods to generate
	 */
	public void loadStructures(Set<Method> methodsToGenerate) {
		
	   	for (Field configuredField : getListOfFields(configuredClass)) {
		
	   		String targetFieldName = configReader.retrieveTargetFieldName(configuredField);
			
			if(targetFieldName == THE_FIELD_IS_NOT_CONFIGURED) continue;
				
			Field targetField = retrieveField(targetClass,targetFieldName);
				
			Field destinationField = isDestConfigured?configuredField:targetField;
			Field sourceField      = isDestConfigured?targetField:configuredField;
				
			verifiesAccessorMethods(destinationClass,destinationField);
			verifiesGetterMethods(sourceClass,sourceField);
			
			boolean conversionMethodExists = conversionAnalyzer.fieldsToCheck(destinationField,sourceField);
			
			InfoOperation info = operationAnalyzer.getInfoOperation(destinationField, sourceField);
			OperationType operationType = info.getInstructionType(); 
				
			if(operationType.isUndefined() && !conversionMethodExists)
					Error.undefinedMapping(destinationField, destinationClass, sourceField, sourceClass);
			
			if(conversionMethodExists)                  // explicit conversion between primitive types
				operationType = operationType.isBasic()?OperationType.BASIC_CONVERSION
														// explicit conversion between complex types
				                         			   :OperationType.CONVERSION;
			
			AGeneralOperation operation = OperationFactory.getOperation(operationType);

			if(operationType.isBasic())
				simpleOperations.add((ASimpleOperation) operation);	
				
			if(operationType.isComplex())
				complexOperations.add(((AComplexOperation) operation).setDestinationClass(defineStructure(destinationField, sourceField)));
					
			if(operationType.isRecursive())
				((ARecursiveOperation) operation).setMethodsToGenerate(methodsToGenerate)
				 							     .setXml(xml)
				                                 .setConfigChosen(info.getConfigChosen()==null // if both classes are configured
										                    	  ?configurationChosen		   // returns the configuration chosen
												                  :info.getConfigChosen());    // else returns the configuration retrieved
			if(operationType.isConverted()){
				conversionHandler.analyze(conversionAnalyzer.getMethod())
				                 .belongTo(conversionAnalyzer.getMembership())
				                 .withThisConfiguration(conversionAnalyzer.getConfigurationType())
				                 .from(sourceField).to(destinationField);
				
				if(conversionHandler.toBeCreated())
					methodsToGenerate.add(conversionHandler.loadMethod());
				
				operation.setConversionMethod(conversionAnalyzer.getMethod())
						 .setMemberShip      (conversionHandler.getMembership());
			}
			
			// common settings
			operation.setDestinationField(destinationField)
					 .setSourceField(sourceField)
					 .setInfoOperation(info);
		}
		
		// checks if there isn't a correspondence between classes
		if(simpleOperations.isEmpty() && complexOperations.isEmpty())
				Error.absentRelationship(configuredClass, targetClass);	
	}
		
	/**@return list of simple operations */
	public List<ASimpleOperation> getSimpleOperations()   {	return simpleOperations;	}
	
	/**@return list of complex operations */
	public List<AComplexOperation> getComplexOperations() {	return complexOperations;	}
}