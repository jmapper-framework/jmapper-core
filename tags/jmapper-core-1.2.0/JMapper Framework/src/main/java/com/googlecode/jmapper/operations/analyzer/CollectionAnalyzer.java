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

package com.googlecode.jmapper.operations.analyzer;

import static com.googlecode.jmapper.conversions.implicit.ConversionAnalyzer.getConversionType;
import static com.googlecode.jmapper.enums.ConversionType.ABSENT;
import static com.googlecode.jmapper.enums.ConversionType.UNDEFINED;
import static com.googlecode.jmapper.enums.OperationType.COLLECTION;
import static com.googlecode.jmapper.enums.OperationType.COLLECTION_WITH_MAPPED_ITEMS;
import static com.googlecode.jmapper.util.ClassesManager.areMappedObjects;
import static com.googlecode.jmapper.util.ClassesManager.configChosen;
import static com.googlecode.jmapper.util.ClassesManager.getCollectionItemClass;
import static com.googlecode.jmapper.util.ClassesManager.isAddAllPermitted;
import static com.googlecode.jmapper.util.GeneralUtility.areBasic;

import java.lang.reflect.Field;

import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.xml.XML;
/**
 * This Class analyzes operations between Collections.
 * @author Alessandro Vurro
 *
 */
public final class CollectionAnalyzer {
	
	/** xml object */
	private final XML xml;
	
	/**
	 * Takes as input an xml object that represents the xml configuration.
	 * @param aXml xml object
	 */
	public CollectionAnalyzer(XML aXml) {
		xml = aXml;
	}
	/**
	 * This method calculates and returns information relating the operation to be performed.
	 * @param destination destination field to be analyzed
	 * @param source source field to be analyzed
	 * @return all information relating the operation to be performed
	 */
	public InfoOperation getInfoOperation(final Field destination, final Field source) {
		
		InfoOperation operation = new InfoOperation().setInstructionType(COLLECTION)
				 									 .setConversionType(UNDEFINED);
		
		// if basic mapping is possible
		if(isAddAllPermitted(destination, source))
			return operation.setConversionType(ABSENT);
		
		// from this point we know that the list items are different
		Class<?> dItem = getCollectionItemClass(destination);
		Class<?> sItem = getCollectionItemClass(source);
		
		// if list items are basic type
		if(areBasic(dItem,sItem))	
			return operation.setConversionType(getConversionType(dItem, sItem));
			
		// If list items are mapped
		if(areMappedObjects(dItem,sItem,xml))
			return operation.setInstructionType(COLLECTION_WITH_MAPPED_ITEMS)
						    .setConfigChosen(configChosen(dItem,sItem,xml));
		
		return operation;
	}

}
