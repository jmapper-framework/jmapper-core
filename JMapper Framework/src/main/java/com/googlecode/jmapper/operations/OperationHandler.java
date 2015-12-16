/**
 * Copyright (C) 2012 - 2015 Alessandro Vurro.
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
import static com.googlecode.jmapper.operations.NestedMappingHandler.isNestedMapping;
import static com.googlecode.jmapper.operations.NestedMappingHandler.loadNestedMappingInformation;
import static com.googlecode.jmapper.util.ClassesManager.findSetterMethods;
import static com.googlecode.jmapper.util.ClassesManager.getListOfFields;
import static com.googlecode.jmapper.util.ClassesManager.retrieveField;
import static com.googlecode.jmapper.util.ClassesManager.verifiesAccessorMethods;
import static com.googlecode.jmapper.util.ClassesManager.verifyGetterMethods;
import static com.googlecode.jmapper.util.GeneralUtility.implementationClass;
import static com.googlecode.jmapper.util.GeneralUtility.isNull;

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
import com.googlecode.jmapper.exceptions.InvalidNestedMappingException;
import com.googlecode.jmapper.generation.beans.Method;
import com.googlecode.jmapper.operations.beans.MappedField;
import com.googlecode.jmapper.operations.complex.AComplexOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.operations.info.NestedMappingInfo;
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
	/** operation factory */
	
	/**
	 * @param aDestinationClass destination class
	 * @param aSourceClass source class
	 * @param aConfigurationChosen configuration chosen
	 * @param aXml xml configuration
	 */
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
		
		// dependencies initialization
		configReader = new ConfigReader(configuredClass, targetClass, xml);
		conversionHandler = new ConversionHandler(xml,destinationClass,sourceClass);
		conversionAnalyzer = new ConversionAnalyzer(xml,configurationChosen,destinationClass,sourceClass);
		operationAnalyzer = new OperationAnalyzer(xml, conversionAnalyzer);
	}
	
	/**
	 * This method calculates and loads the lists relating to the operations to be performed.
	 * @param dynamicMethodsToWrite methods to generate
	 */
	public void loadStructures(Set<Method> dynamicMethodsToWrite) {
		
	   	for (Field configuredField : getListOfFields(configuredClass)) {
		
	   		String targetFieldName = configReader.retrieveTargetFieldName(configuredField);
			
			if(targetFieldName == THE_FIELD_IS_NOT_CONFIGURED) continue;
				
			boolean isNestedMapping = isNestedMapping(targetFieldName);
			
			Field targetField = null;
			NestedMappingInfo nestedMappingInfo = null;
			if(isNestedMapping)
				try{	
					nestedMappingInfo = loadNestedMappingInformation(xml, targetClass, targetFieldName);
				    targetField = nestedMappingInfo.getLastNestedField();
				}catch(InvalidNestedMappingException e){
				    // catch and rethrown the exception with more information
				    Error.invalidNestedMapping(configuredClass, configuredField, targetClass, e.getMessage(), e.getMessages().get(InvalidNestedMappingException.FIELD));}
			else
				targetField = retrieveField(targetClass,targetFieldName);
			
			
			MappedField configuredMappedField = new MappedField(configuredField);
			MappedField targetMappedField     = new MappedField(targetField);

			MappedField destinationMappedField = isDestConfigured?configuredMappedField:targetMappedField;
			MappedField sourceMappedField = isDestConfigured?targetMappedField:configuredMappedField;

			Field destinationField = isDestConfigured?configuredField:targetField;
			Field sourceField      = isDestConfigured?targetField:configuredField;
			
			//load and check the get/set custom methods of destination and source fields
			if(isNestedMapping)	configReader.loadAccessors(nestedMappingInfo.getLastNestedClass(),configuredMappedField, targetMappedField);
			else				configReader.loadAccessors(configuredMappedField, targetMappedField);
			
			boolean isUndefined = false;
			
			try{
				isUndefined = operationAnalyzer.isUndefined(destinationField, sourceField);
			}catch(Exception e){
				// catch and rethrown the exception with more information
				Error.badConversion(destinationField, destinationClass, sourceField, sourceClass,e.getMessage());
			}
			
			if(isUndefined)	
				Error.undefinedMapping(destinationField, destinationClass, sourceField, sourceClass);
			
			InfoOperation info = operationAnalyzer.getInfo();
			
			OperationType operationType = info.getOperationType();

			AGeneralOperation operation = OperationFactory.getOperation(operationType);
			
			//TODO ottengo l'operazione e ho tutte le informazioni riguardanti il path nell oggetto NestedMappingInfo
			// devo costruire le operazioni con le informazioni del mapping
			
			// in fase di creazione vanno istanziate le classi intermedie
			// in fase di arricchimento basta recuperare quelle esistenti
			// il tutto considerando il mapping type
			
			if(operationType.isBasic())
				simpleOperations.add((ASimpleOperation) operation);	
				
			if(operationType.isComplex())
				complexOperations.add(((AComplexOperation) operation)
						.setDestinationClass(defineStructure(destinationMappedField.getValue(), sourceMappedField.getValue())));
					
			if(operationType.isRecursive())
				((ARecursiveOperation) operation).setDynamicMethodsToWrite(dynamicMethodsToWrite)
				 							     .setXml(xml)
				                                 .setConfigChosen(isNull(info.getConfigChosen()) // if both classes are configured
										                    	  ?configurationChosen		     // returns the configuration chosen
												                  :info.getConfigChosen());      // else returns the configuration retrieved
			// common settings
			operation.setDestinationField(destinationMappedField)
					 .setSourceField(sourceMappedField)
					 .setInfoOperation(info);
			
			boolean isAvoidSet = false;
			boolean isConversion = info.getOperationType().isAConversion();
			
			if(isConversion)
				isAvoidSet = conversionAnalyzer.getMethod().isAvoidSet();
			
			// verifies destination accessors
			if(isAvoidSet)	verifyGetterMethods(destinationClass,destinationMappedField);
			else		verifiesAccessorMethods(destinationClass,destinationMappedField);
			
			// verifies source accessors
			verifyGetterMethods(sourceClass,sourceMappedField);
			findSetterMethods(sourceClass,sourceMappedField);
			
			operation.avoidDestinationSet(isAvoidSet);

			if(isConversion){
				
				conversionHandler.load(conversionAnalyzer)
				                 .from(sourceMappedField).to(destinationMappedField);
				
				// in case of dynamic conversion
				if(conversionHandler.toBeCreated())
					dynamicMethodsToWrite.add(conversionHandler.loadMethod());
				
				operation.setConversionMethod(conversionHandler.getMethod())
						 .setMemberShip      (conversionHandler.getMembership());
			}
				
		}
		
		// checks if there isn't a correspondence between classes
		if(simpleOperations.isEmpty() && complexOperations.isEmpty())
				Error.absentRelationship(configuredClass, targetClass);	
	}
	
	/**
	 * This method defines the destination structure for this operation.
	 * If destination class is an interface, a relative implementation will be found.
	 * 
	 * @param destination destination field
	 * @param source source field
	 */
	private Class<?> defineStructure(Field destination, Field source){
		
		Class<?> destinationClass = destination.getType();
		Class<?> sourceClass = source.getType();
		
		Class<?> result = null;
		
		// if destination is an interface
		if(destinationClass.isInterface())
			// if source is an interface
			if(sourceClass.isInterface())
					// retrieves the implementation of the destination interface
					result = (Class<?>) implementationClass.get(destinationClass.getName());
			// if source is an implementation	
			else{
				// retrieves source interface
				Class<?> sourceInterface = sourceClass.getInterfaces()[0];
				// if the destination and source interfaces are equal
				if(destinationClass == sourceInterface)
					// assigns implementation to destination
					result = sourceClass;
				// if they are different
				else
					// destination gets the implementation of his interface
					result = (Class<?>) implementationClass.get(destinationClass.getName());
			}
		// if destination is an implementation
		else
			result = destinationClass;
		
		return result;
	}		
	/**@return list of simple operations */
	public List<ASimpleOperation> getSimpleOperations()   {	return simpleOperations;	}
	
	/**@return list of complex operations */
	public List<AComplexOperation> getComplexOperations() {	return complexOperations;	}
}