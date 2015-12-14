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

import static com.googlecode.jmapper.config.Constants.*;
import static com.googlecode.jmapper.util.ClassesManager.findSetterMethods;
import static com.googlecode.jmapper.util.ClassesManager.getListOfFields;
import static com.googlecode.jmapper.util.ClassesManager.retrieveField;
import static com.googlecode.jmapper.util.ClassesManager.verifiesAccessorMethods;
import static com.googlecode.jmapper.util.ClassesManager.verifyGetterMethods;
import static com.googlecode.jmapper.config.NestedMappingHandler.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.googlecode.jmapper.config.ConfigReader;
import com.googlecode.jmapper.config.Error;
import com.googlecode.jmapper.conversions.explicit.ConversionAnalyzer;
import com.googlecode.jmapper.conversions.explicit.ConversionHandler;
import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.exceptions.InvalidNestedMappingException;
import com.googlecode.jmapper.generation.beans.Method;
import com.googlecode.jmapper.operations.beans.MappedField;
import com.googlecode.jmapper.operations.complex.AComplexOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;
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
	private final OperationFactory operationFactory;
	
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
		operationFactory = new OperationFactory(xml, configurationChosen, simpleOperations, complexOperations);
	}
	
	/**
	 * This method calculates and loads the lists relating to the operations to be performed.
	 * @param dynamicMethodsToWrite methods to generate
	 */
	public void loadStructures(Set<Method> dynamicMethodsToWrite) {
		
	   	for (Field configuredField : getListOfFields(configuredClass)) {
		
	   		String targetFieldName = null;
	   		
	   		try{
	   			targetFieldName = configReader.retrieveTargetFieldName(configuredField);
	   		}catch(InvalidNestedMappingException e){
	   		     // catch and rethrown the exception with more information
				 Error.invalidNestedMapping(configuredClass, configuredField, targetClass, e.getMessage());
			}
			
			if(targetFieldName == THE_FIELD_IS_NOT_CONFIGURED) continue;
				
			boolean isNestedMapping = isNestedMapping(targetFieldName);
			
			Field targetField = isNestedMapping
					 				?getNestedField(targetClass, targetFieldName)
					 				:retrieveField(targetClass,targetFieldName);
			
			MappedField configuredMappedField = new MappedField(configuredField);
			MappedField targetMappedField     = new MappedField(targetField);

			MappedField destinationMappedField = isDestConfigured?configuredMappedField:targetMappedField;
			MappedField sourceMappedField = isDestConfigured?targetMappedField:configuredMappedField;

			Field destinationField = isDestConfigured?configuredField:targetField;
			Field sourceField      = isDestConfigured?targetField:configuredField;
			
			//load and check the get/set custom methods of destination and source fields
			
			if(isNestedMapping)
				configReader.loadAccessors(getNestedClass(targetClass, targetFieldName),configuredMappedField, targetMappedField);
			else
				configReader.loadAccessors(configuredMappedField, targetMappedField);
			
			boolean isUndefined = false;
			
			//TODO NestedMapping -> 
			//
			// il recupero del campo innestato va fatto sulla classe non configurata, ovvero quella target
			//
			//
			// l'ideale è lasciar fare il calcolo dell'operazione per poi aggiungere questa
			// logica con un decorator
			//
			// va trovata l'operazione da effettuare tra i campi
			// quello che va aggiunto il path da invocare per ottenerli
			// la ricerca dell'operazione va mantenuta, va trovato il modo di fare il get del target
			// e quindi l'invocazione dei campi innestati.
			//
			// Il decoretor quindi deve aggiungere solo il path per recuperare i campi
			//
			// il nested mapping deve essere in grado di essere utilizzato in qualsiasi operazione
			//
			// inoltre va considerato il mappingType e se è creazionale o di arricchimento
			// in caso creazionale vanno creati i bean innestati
			// in caso di arricchimento bisogna considerare i MappingType
			//
			
			
			try{
				isUndefined = operationAnalyzer.isUndefined(destinationField, sourceField);
			}catch(Exception e){
				// catch and rethrown the exception with more information
				Error.badConversion(destinationField, destinationClass, sourceField, sourceClass,e.getMessage());
			}
			
			if(isUndefined)	
				Error.undefinedMapping(destinationField, destinationClass, sourceField, sourceClass);
			
			InfoOperation info = operationAnalyzer.getInfo();
			
			AGeneralOperation operation = operationFactory.getOperation(destinationMappedField, sourceMappedField, info, dynamicMethodsToWrite);

			boolean isAvoidSet = false;
			boolean isConversion = info.getOperationType().isAConversion();
			
			if(isConversion)
				isAvoidSet = conversionAnalyzer.getMethod().isAvoidSet();
			
			if(isAvoidSet)	verifyGetterMethods(destinationClass,destinationMappedField);
			else		verifiesAccessorMethods(destinationClass,destinationMappedField);
			
			verifyGetterMethods(sourceClass,sourceMappedField);
			findSetterMethods(sourceClass,sourceMappedField);
			
			operation.avoidDestinationSet(isAvoidSet);

			if(isConversion){
				
				conversionHandler.load(conversionAnalyzer)
				                 .from(sourceMappedField).to(destinationMappedField);
				
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
		
	/**@return list of simple operations */
	public List<ASimpleOperation> getSimpleOperations()   {	return simpleOperations;	}
	
	/**@return list of complex operations */
	public List<AComplexOperation> getComplexOperations() {	return complexOperations;	}
}