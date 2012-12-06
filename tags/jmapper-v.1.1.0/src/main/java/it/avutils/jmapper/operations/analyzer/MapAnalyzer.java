/**
 * Copyright (C) 2012 Alessandro Vurro.
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
import static it.avutils.jmapper.enums.ConversionType.DEFINED;
import static it.avutils.jmapper.enums.ConversionType.UNDEFINED;
import static it.avutils.jmapper.enums.OperationType.BASIC_INSTRUCTION;
import static it.avutils.jmapper.enums.OperationType.MAP;
import static it.avutils.jmapper.enums.OperationType.MAP_WITH_MAPPED_ITEMS;
import static it.avutils.jmapper.enums.OperationType.OBJECT;
import static it.avutils.jmapper.util.ClassesManager.areMappedObjects;
import static it.avutils.jmapper.util.ClassesManager.configChosen;
import static it.avutils.jmapper.util.ClassesManager.getGenericMapKeyItem;
import static it.avutils.jmapper.util.ClassesManager.getGenericMapValueItem;
import static it.avutils.jmapper.util.ClassesManager.isAssignableFrom;
import static it.avutils.jmapper.util.ClassesManager.isPutAllPermitted;
import static it.avutils.jmapper.util.GeneralUtility.areBasic;
import it.avutils.jmapper.enums.ConversionType;
import it.avutils.jmapper.operations.info.InfoMapOperation;
import it.avutils.jmapper.operations.info.InfoOperation;
import it.avutils.jmapper.util.XML;

import java.lang.reflect.Field;

/**
 * This Class analyzes operations between Maps.
 * @author Alessandro Vurro
 *
 */
public final class MapAnalyzer {

	/** xml object */
	private final XML xml;
	
	/**
	 * Takes as input an xml object that represents the xml configuration.
	 * @param aXml xml object
	 */
	public MapAnalyzer(XML aXml) {
		xml = aXml;
	}
	/**
	 * This method calculates and returns information relating the operation to be performed.
	 * @param destination destination field to be analyzed
	 * @param source source field to be analyzed
	 * @return all information relating the operation to be performed
	 */
	public InfoOperation getInfoOperation(final Field destination,final Field source) {
		
		InfoMapOperation operation = (InfoMapOperation) new InfoMapOperation()
										.setInstructionType(MAP)
										.setConversionType(UNDEFINED);
		
		// if basic mapping is possible
		if(isPutAllPermitted(destination, source))
				return operation.setConversionType(ABSENT);
		
		// from this point we know that the map items are different
		operation.setConversionType(DEFINED);
		
		Class<?> dKItem = getGenericMapKeyItem(destination);
		Class<?> sKItem = getGenericMapKeyItem(source);
		Class<?> dVItem = getGenericMapValueItem(destination);
		Class<?> sVItem = getGenericMapValueItem(source);
		
		operation.keyValueUndefined();
				
		// if keys and/or values are mapped
		if(areMappedObjects(dKItem,sKItem,xml) || areMappedObjects(dVItem,sVItem,xml))
			operation.setInstructionType(MAP_WITH_MAPPED_ITEMS);

		// if destination is assignable from source apply basic mapping
		if(isAssignableFrom(dKItem,sKItem)) operation.setKeyInstructionType(BASIC_INSTRUCTION)
												.setKeyConversionType(ABSENT);
		
		// if destination is assignable from source apply basic mapping
		if(isAssignableFrom(dVItem,sVItem))	operation.setValueInstructionType(BASIC_INSTRUCTION)
												.setValueConversionType(ABSENT);
		
		// if key items are of basic type but different, apply conversion
		if(areBasic(dKItem,sKItem))			operation.setKeyInstructionType(BASIC_INSTRUCTION)
												.setKeyConversionType(getConversion(dKItem,sKItem));
		
		// if key items are of basic type but different, apply conversion
		if(areBasic(dVItem,sVItem))			operation.setValueInstructionType(BASIC_INSTRUCTION)
												.setValueConversionType(getConversion(dVItem,sVItem));
			
		// If key items are mapped objects
		if(areMappedObjects(dKItem,sKItem,xml)) operation.setKeyInstructionType(OBJECT)
				        								.setKeyConfigChosen(configChosen(dKItem,sKItem,xml));
						
		// If value items are mapped objects
		if(areMappedObjects(dVItem,sVItem,xml)) operation.setValueInstructionType(OBJECT)
					    								.setValueConfigChosen(configChosen(dVItem,sVItem,xml));
		
		return operation;
	}

	private static ConversionType getConversion(Class<?> dClass,Class<?> sClass){
		return dClass.isAssignableFrom(sClass)?UNDEFINED:getConversionType(dClass, sClass);
	}

}
