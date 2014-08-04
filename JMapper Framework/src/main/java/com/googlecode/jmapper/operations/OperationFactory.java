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

import static com.googlecode.jmapper.util.GeneralUtility.implementationClass;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.enums.OperationType;
import com.googlecode.jmapper.generation.beans.Method;
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
	 * Returns an operation relative to operation to perform.
	 * @param operationType operation type
	 * @param sourceField source field
	 * @param destinationField destination field
	 * @param info info operation
	 * @param dynamicMethodsToWrite 
	 * @return a new instance of AGeneralOperation
	 */
	public AGeneralOperation getOperation(Field destinationField, Field sourceField, InfoOperation info, Set<Method> dynamicMethodsToWrite){
		AGeneralOperation operation = null;
		OperationType operationType = info.getInstructionType();
		 
		switch(operationType){
			case BASIC_INSTRUCTION:			   operation = new BasicOperation();			break;
			case BASIC_CONVERSION:             operation = new BasicConversion();			break;
			case OBJECT:					   operation = new ObjectOperation();			break;
			case ARRAY: 					   operation = new ArrayOperation();			break;
			case ARRAY_LIST:				   operation = new ArrayListOperation();		break;
			case LIST_ARRAY:			       operation = new ListArrayOperation();		break;
			case ARRAY_WITH_MAPPED_ITEMS:	   operation = new MappedArrayOperation();		break;
			case ARRAY_LIST_WITH_MAPPED_ITEMS: operation = new MappedArrayListOperation();	break;
			case LIST_ARRAY_WITH_MAPPED_ITEMS: operation = new MappedListArrayOperation();	break;
			case COLLECTION: 				   operation = new CollectionOperation();		break;
			case COLLECTION_WITH_MAPPED_ITEMS: operation = new MappedCollectionOperation();	break;
			case MAP:	     				   operation = new MapOperation();				break;
			case MAP_WITH_MAPPED_ITEMS: 	   operation = new MappedMapOperation();		break;
			case CONVERSION: 				   operation = new ConversionOperation();		break;
			default: break;
		}
		
		if(operationType.isBasic())
			simpleOperations.add((ASimpleOperation) operation);	
			
		if(operationType.isComplex())
			complexOperations.add(((AComplexOperation) operation).setDestinationClass(defineStructure(destinationField, sourceField)));
				
		if(operationType.isRecursive())
			((ARecursiveOperation) operation).setDynamicMethodsToWrite(dynamicMethodsToWrite)
			 							     .setXml(xml)
			                                 .setConfigChosen(info.getConfigChosen()==null // if both classes are configured
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