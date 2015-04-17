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

package com.googlecode.jmapper.operations.analyzer;
import static com.googlecode.jmapper.conversions.implicit.ConversionAnalyzer.getConversionType;
import static com.googlecode.jmapper.enums.ConversionType.ABSENT;
import static com.googlecode.jmapper.enums.ConversionType.UNDEFINED;
import static com.googlecode.jmapper.enums.OperationType.ARRAY;
import static com.googlecode.jmapper.enums.OperationType.ARRAY_WITH_MAPPED_ITEMS;
import static com.googlecode.jmapper.util.ClassesManager.areMappedObjects;
import static com.googlecode.jmapper.util.ClassesManager.configChosen;
import static com.googlecode.jmapper.util.ClassesManager.isAssignableFrom;
import static com.googlecode.jmapper.util.GeneralUtility.areBasic;

import java.lang.reflect.Field;

import com.googlecode.jmapper.operations.IOperationAnalyzer;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.xml.XML;
/**
 * This Class analyzes operations between Arrays.
 * 
 * @author Alessandro Vurro
 *
 */
public final class ArrayAnalyzer implements IOperationAnalyzer{

	/** xml object */
	private final XML xml;
	
	/**
	 * Takes as input an xml object that represents the xml configuration.
	 * @param aXml xml object
	 */
	public ArrayAnalyzer(XML aXml) {
		xml = aXml;
	}
	
	public InfoOperation getInfoOperation(final Field destination, final Field source) {
		
		InfoOperation operation = new InfoOperation().setInstructionType(ARRAY)
													 .setConversionType(UNDEFINED);
		
		// if components are equal, apply simply mapping
		if(destination.getType().isAssignableFrom(source.getType()))
			return operation.setConversionType (ABSENT);
		
		// obtain array items
		Class<?> dComponentType = destination.getType().getComponentType();
		Class<?> sComponentType = source.getType().getComponentType();
		
		if(isAssignableFrom(dComponentType,sComponentType))
			return operation.setConversionType (ABSENT);
		
		// if components are primitive or wrapper types, apply implicit conversion
		if(areBasic(dComponentType,sComponentType))
			return operation.setConversionType(getConversionType(dComponentType, sComponentType));
				
		// if components are mapped objects
		if(areMappedObjects(dComponentType,sComponentType,xml))
			return operation.setInstructionType(ARRAY_WITH_MAPPED_ITEMS)
					        .setConfigChosen(configChosen(dComponentType,sComponentType,xml));

		return operation;
	}

	public boolean verifyConditions(Field destination, Field source) {
		return destination.getType().isArray() && source.getType().isArray();
	}

}
