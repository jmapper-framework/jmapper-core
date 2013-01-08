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
import static it.avutils.jmapper.enums.OperationType.BASIC_INSTRUCTION;
import static it.avutils.jmapper.util.ClassesManager.isAssignableFrom;
import static it.avutils.jmapper.util.GeneralUtility.isBasic;
import it.avutils.jmapper.operations.info.InfoOperation;

import java.lang.reflect.Field;
/**
 * This Class analyzes operations between basic types.
 * @author Alessandro Vurro
 *
 */
public final class BasicAnalyzer {

	/**
	 * This method calculates and returns information relating the operation to be performed.
	 * @param destination destination field to be analyzed
	 * @param source source field to be analyzed
	 * @return all information relating the operation to be performed
	 */
	public InfoOperation getInfoOperation(final Field destination, final Field source) {
		
		InfoOperation operation = new InfoOperation().setInstructionType(BASIC_INSTRUCTION)
													 .setConversionType (UNDEFINED);
		
		if(isAssignableFrom(destination,source))
			return operation.setConversionType (ABSENT);
		
		if(isBasic(destination.getType()) && isBasic(source.getType()))
			return operation.setConversionType(getConversionType(destination, source));
		
		return operation;
	}

}
