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

import static com.googlecode.jmapper.util.GeneralUtility.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.enums.OperationType;
import com.googlecode.jmapper.generation.beans.Method;
import com.googlecode.jmapper.operations.beans.MappedField;
import com.googlecode.jmapper.operations.complex.AComplexOperation;
import com.googlecode.jmapper.operations.complex.ArrayListOperation;
import com.googlecode.jmapper.operations.complex.ArrayOperation;
import com.googlecode.jmapper.operations.complex.CollectionOperation;
import com.googlecode.jmapper.operations.complex.ConversionOperation;
import com.googlecode.jmapper.operations.complex.ListArrayOperation;
import com.googlecode.jmapper.operations.complex.MapOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.operations.recursive.ARecursiveOperation;
import com.googlecode.jmapper.operations.recursive.MappedArrayListOperation;
import com.googlecode.jmapper.operations.recursive.MappedArrayOperation;
import com.googlecode.jmapper.operations.recursive.MappedCollectionOperation;
import com.googlecode.jmapper.operations.recursive.MappedListArrayOperation;
import com.googlecode.jmapper.operations.recursive.MappedMapOperation;
import com.googlecode.jmapper.operations.recursive.ObjectOperation;
import com.googlecode.jmapper.operations.simple.ASimpleOperation;
import com.googlecode.jmapper.operations.simple.BasicConversion;
import com.googlecode.jmapper.operations.simple.BasicOperation;
import com.googlecode.jmapper.xml.XML;

/**
 * Operation Factory.
 * @author Alessandro Vurro
 *
 */
public class OperationFactory {

	private XML xml;
	private ChooseConfig configurationChosen;
	private List<ASimpleOperation> simpleOperations;
	private List<AComplexOperation> complexOperations;
	
	public OperationFactory(XML xml, ChooseConfig configurationChosen, List<ASimpleOperation> simpleOperations, List<AComplexOperation> complexOperations) {
		this.configurationChosen = configurationChosen;
		this.xml = xml;
		this.simpleOperations = simpleOperations;
		this.complexOperations = complexOperations;
	}
	
	/**
	 * Operation factory.
	 * @param operationType
	 * @return
	 */
	private AGeneralOperation getOperation(OperationType operationType){
		switch(operationType){
			case BASIC_INSTRUCTION:			   return new BasicOperation();			
			case BASIC_CONVERSION:             return new BasicConversion();			
			case OBJECT:					   return new ObjectOperation();			
			case ARRAY: 					   return new ArrayOperation();			
			case ARRAY_LIST:				   return new ArrayListOperation();		
			case LIST_ARRAY:			       return new ListArrayOperation();		
			case ARRAY_WITH_MAPPED_ITEMS:	   return new MappedArrayOperation();		
			case ARRAY_LIST_WITH_MAPPED_ITEMS: return new MappedArrayListOperation();	
			case LIST_ARRAY_WITH_MAPPED_ITEMS: return new MappedListArrayOperation();	
			case COLLECTION: 				   return new CollectionOperation();		
			case COLLECTION_WITH_MAPPED_ITEMS: return new MappedCollectionOperation();	
			case MAP:	     				   return new MapOperation();				
			case MAP_WITH_MAPPED_ITEMS: 	   return new MappedMapOperation();		
			case CONVERSION: 				   return new ConversionOperation();		
			default: return null;
		}
	}
	
	/**
	 * Returns an operation relative to operation to perform.
	 * @param destinationField destination field
	 * @param sourceField source field
	 * @param info info operation
	 * @param dynamicMethodsToWrite dynamic methods to write
	 * @return a new instance of AGeneralOperation
	 */
	public AGeneralOperation getOperation(MappedField destinationField, MappedField sourceField, InfoOperation info, Set<Method> dynamicMethodsToWrite){
		OperationType operationType = info.getOperationType();
		AGeneralOperation operation = getOperation(operationType);
		 
		//TODO l'inserimento in lista va spostato da qui, in operation handler va messo
		if(operationType.isBasic())
			simpleOperations.add((ASimpleOperation) operation);	
			
		if(operationType.isComplex())
			complexOperations.add(((AComplexOperation) operation).setDestinationClass(defineStructure(destinationField.getValue(), sourceField.getValue())));
				
		if(operationType.isRecursive())
			((ARecursiveOperation) operation).setDynamicMethodsToWrite(dynamicMethodsToWrite)
			 							     .setXml(xml)
			                                 .setConfigChosen(isNull(info.getConfigChosen()) // if both classes are configured
									                    	  ?configurationChosen		   // returns the configuration chosen
											                  :info.getConfigChosen());    // else returns the configuration retrieved
		// common settings
		operation.setDestinationField(destinationField)
				 .setSourceField(sourceField)
				 .setInfoOperation(info);
		
		return operation;
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
}