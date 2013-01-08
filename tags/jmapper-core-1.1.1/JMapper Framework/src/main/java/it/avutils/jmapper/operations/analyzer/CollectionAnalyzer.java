/**
 * Copyright (C) 2013 Alessandro Vurro.
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

package it.avutils.jmapper.operations.analyzer;

import static it.avutils.jmapper.conversions.implicit.analyzer.ConversionAnalyzer.getConversionType;
import static it.avutils.jmapper.enums.ConversionType.ABSENT;
import static it.avutils.jmapper.enums.ConversionType.UNDEFINED;
import static it.avutils.jmapper.enums.OperationType.COLLECTION;
import static it.avutils.jmapper.enums.OperationType.COLLECTION_WITH_MAPPED_ITEMS;
import static it.avutils.jmapper.util.ClassesManager.areMappedObjects;
import static it.avutils.jmapper.util.ClassesManager.configChosen;
import static it.avutils.jmapper.util.ClassesManager.getCollectionItemClass;
import static it.avutils.jmapper.util.ClassesManager.isAddAllPermitted;
import static it.avutils.jmapper.util.GeneralUtility.areBasic;
import it.avutils.jmapper.operations.info.InfoOperation;
import it.avutils.jmapper.util.XML;

import java.lang.reflect.Field;
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
