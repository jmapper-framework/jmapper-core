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

import static com.googlecode.jmapper.enums.OperationType.OBJECT;
import static com.googlecode.jmapper.util.ClassesManager.areMappedObjects;
import static com.googlecode.jmapper.util.ClassesManager.configChosen;

import java.lang.reflect.Field;

import com.googlecode.jmapper.operations.IOperationAnalyzer;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.xml.XML;
/**
 *  This Class analyzes operations between complex objects.
 * @author Alessandro Vurro
 *
 */
public final class MappedObjectAnalyzer implements IOperationAnalyzer{

	/** xml object */
	private final XML xml;
	
	/**
	 * Takes as input an xml object that represents the xml configuration.
	 * @param aXml xml object
	 */
	public MappedObjectAnalyzer(XML aXml) {
		xml = aXml;
	}
	
	public InfoOperation getInfoOperation(final Field destination, final Field source) {
		
		return new InfoOperation().setInstructionType(OBJECT)
								  .setConfigChosen(configChosen(destination.getType(),source.getType(),xml)); 
	}

	public boolean verifyConditions(Field destination, Field source) {
		return areMappedObjects(destination.getType(), source.getType(), xml);
	}

}
