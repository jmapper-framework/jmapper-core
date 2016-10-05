/**
 * Copyright (C) 2012 - 2016 Alessandro Vurro.
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
package com.googlecode.jmapper.operations.analyzer;

import static com.googlecode.jmapper.conversions.implicit.ConversionAnalyzer.getConversionType;
import static com.googlecode.jmapper.enums.ConversionType.ABSENT;
import static com.googlecode.jmapper.enums.ConversionType.UNDEFINED;
import static com.googlecode.jmapper.enums.OperationType.ARRAY_LIST;
import static com.googlecode.jmapper.enums.OperationType.ARRAY_LIST_WITH_MAPPED_ITEMS;
import static com.googlecode.jmapper.enums.OperationType.LIST_ARRAY;
import static com.googlecode.jmapper.enums.OperationType.LIST_ARRAY_WITH_MAPPED_ITEMS;
import static com.googlecode.jmapper.util.ClassesManager.areMappedObjects;
import static com.googlecode.jmapper.util.ClassesManager.configChosen;
import static com.googlecode.jmapper.util.ClassesManager.getCollectionItemClass;
import static com.googlecode.jmapper.util.ClassesManager.isAssignableFrom;
import static com.googlecode.jmapper.util.GeneralUtility.areBasic;
import static com.googlecode.jmapper.util.GeneralUtility.collectionIsAssignableFrom;

import java.lang.reflect.Field;

import com.googlecode.jmapper.operations.IOperationAnalyzer;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.xml.XML;

/**
 * This Class analyzes operations between Arrays and Collections..
 * @author Alessandro Vurro
 *
 */
public class ArrayListAnalyzer implements IOperationAnalyzer{

	/** xml object */
	private final XML xml;
	
	/**
	 * Takes as input an xml object that represents the xml configuration.
	 * @param aXml xml object
	 */
	public ArrayListAnalyzer(XML aXml) {
		xml = aXml;
	}

	/**
	 * This method calculates and returns information relating the operation to be performed.
	 * @param destination destination field to be analyzed
	 * @param source source field to be analyzed
	 * @return all information relating the operation to be performed
	 */
	public InfoOperation getInfoOperation(final Field destination, final Field source) {
		
		Class<?> dClass = destination.getType();
		Class<?> sClass = source.getType();
		Class<?> dItem = null;
		Class<?> sItem = null;
		
		InfoOperation operation = new InfoOperation().setConversionType(UNDEFINED);
		
		// Array[] = Collection<>
		if(dClass.isArray() && collectionIsAssignableFrom(sClass)){
			dItem = dClass.getComponentType();
			sItem = getCollectionItemClass(source);
			operation.setInstructionType(ARRAY_LIST);

            if(areMappedObjects(dItem,sItem,xml))
				return operation.setInstructionType(ARRAY_LIST_WITH_MAPPED_ITEMS)
						        .setConfigChosen(configChosen(dItem,sItem,xml));
		}
		
		// Collection<> = Array[]
		if(collectionIsAssignableFrom(dClass) && sClass.isArray()){
			dItem = getCollectionItemClass(destination);
			sItem = sClass.getComponentType();
			operation.setInstructionType(LIST_ARRAY);
			
            if(areMappedObjects(dItem,sItem,xml))
				return operation.setInstructionType(LIST_ARRAY_WITH_MAPPED_ITEMS)
						        .setConfigChosen(configChosen(dItem,sItem,xml));
		}

		if(isAssignableFrom(dItem,sItem))
			return operation.setConversionType(ABSENT);

		// if components are primitive or wrapper types, apply implicit conversion
		if(areBasic(dItem,sItem))
			return operation.setConversionType(getConversionType(dItem, sItem));
				
		return operation;
	}

	public boolean verifyConditions(Field destination, Field source) {
		return (destination.getType().isArray() && collectionIsAssignableFrom(source.getType())) 
				|| (source.getType().isArray() && collectionIsAssignableFrom(destination.getType()));
	}
}
