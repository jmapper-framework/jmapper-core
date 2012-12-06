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
import static it.avutils.jmapper.enums.ConversionType.UNDEFINED;
import static it.avutils.jmapper.enums.OperationType.ARRAY;
import static it.avutils.jmapper.enums.OperationType.ARRAY_WITH_MAPPED_ITEMS;
import static it.avutils.jmapper.util.ClassesManager.areMappedObjects;
import static it.avutils.jmapper.util.GeneralUtility.areBasic;
import it.avutils.jmapper.operations.info.InfoOperation;
import it.avutils.jmapper.util.XML;

import java.lang.reflect.Field;
/**
 * This Class analyzes operations between Arrays.
 * 
 * @author Alessandro Vurro
 *
 */
public final class ArrayAnalyzer {

	/** xml object */
	private final XML xml;
	
	/**
	 * Takes as input an xml object that represents the xml configuration.
	 * @param aXml xml object
	 */
	public ArrayAnalyzer(XML aXml) {
		xml = aXml;
	}
	
	/**
	 * This method calculates and returns information relating the operation to be performed.
	 * @param destination destination field to be analyzed
	 * @param source source field to be analyzed
	 * @return all information relating the operation to be performed
	 */
	public InfoOperation getInfoOperation(final Field destination, final Field source) {
		
		InfoOperation operation = new InfoOperation().setInstructionType(ARRAY)
													 .setConversionType(UNDEFINED);
		
		// if components are equal, apply simply mapping
		if(destination.getType().isAssignableFrom(source.getType()))
			return operation.setConversionType (ABSENT);
		
		// obtain array items
		Class<?> dComponentType = destination.getType().getComponentType();
		Class<?> sComponentType = source.getType().getComponentType();
		
		// if components are primitive or wrapper types, apply implicit conversion
		if(areBasic(dComponentType,sComponentType))
			return operation.setConversionType(getConversionType(dComponentType, sComponentType));
				
		// if components are mapped objects
		if(areMappedObjects(dComponentType,sComponentType,xml))
			return operation.setInstructionType(ARRAY_WITH_MAPPED_ITEMS);
		
		return operation;
	}

}
