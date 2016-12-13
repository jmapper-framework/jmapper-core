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

package com.googlecode.jmapper.operations;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import com.googlecode.jmapper.conversions.explicit.ConversionAnalyzer;
import com.googlecode.jmapper.enums.OperationType;
import com.googlecode.jmapper.operations.analyzer.ArrayAnalyzer;
import com.googlecode.jmapper.operations.analyzer.ArrayListAnalyzer;
import com.googlecode.jmapper.operations.analyzer.BasicAnalyzer;
import com.googlecode.jmapper.operations.analyzer.CollectionAnalyzer;
import com.googlecode.jmapper.operations.analyzer.DateCalendarAnalyzer;
import com.googlecode.jmapper.operations.analyzer.EnumEnumAnalyzer;
import com.googlecode.jmapper.operations.analyzer.MapAnalyzer;
import com.googlecode.jmapper.operations.analyzer.MappedObjectAnalyzer;
import com.googlecode.jmapper.operations.analyzer.StringEnumAnalyzer;
import com.googlecode.jmapper.operations.analyzer.StringStringBufferAnalyzer;
import com.googlecode.jmapper.operations.analyzer.StringStringBuilderAnalyzer;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.xml.XML;
import static com.googlecode.jmapper.util.GeneralUtility.isNull;
/**
 * OperationAnalyzer analyzes the fields and returns the informations relating the operation to be performed.
 * @author Alessandro Vurro
 *
 */
public final class OperationAnalyzer {
	
	private List<IOperationAnalyzer> analyzers;
	private ConversionAnalyzer conversionAnalyzer;
	private InfoOperation info;
	
	public OperationAnalyzer(XML xml, ConversionAnalyzer conversionAnalyzer) {
		this.conversionAnalyzer = conversionAnalyzer;

		analyzers = Arrays.<IOperationAnalyzer>asList(
								new BasicAnalyzer(xml),		// 	BASIC OPERATION
								new ArrayAnalyzer(xml),		// ARRAYS OPERATION
								new MappedObjectAnalyzer(xml),// MAPPED OBJECTS OPERATION
								new CollectionAnalyzer(xml),// COLLECTIONS OPERATION
								new MapAnalyzer(xml),		// MAPS OPERATION
								new ArrayListAnalyzer(xml),	// ARRAY <-> LIST OPERATION
								new StringStringBuilderAnalyzer(), // STRING <-> STRINGBUILDER OPERATION
								new StringStringBufferAnalyzer(), // STRING <-> STRINGBUILDER OPERATION
								new StringEnumAnalyzer(), // STRING <-> STRINGBUILDER OPERATION
								new DateCalendarAnalyzer(), // STRING <-> STRINGBUILDER OPERATION
								new EnumEnumAnalyzer()      // ENUM <-> ENUM OPERATION
							);
	}
	
	/**
	 * This method analyzes the fields, calculates the info and returns true if operation is undefined.
	 * @param destination destination field
	 * @param source source field
	 * @return returns true if an operation between fields exists
	 * @see InfoOperation
	 */
	public boolean isUndefined(final Field destination,final Field source) {
		
		info = null;
		
		for (IOperationAnalyzer analyzer : analyzers) 
			if(analyzer.verifyConditions(destination,source))
				info = analyzer.getInfoOperation(destination, source);
		
		// if the operation has not been identified
		if(isNull(info)) info = undefinedOperation();
		
		boolean conversionMethodExists = conversionAnalyzer.fieldsToCheck(destination,source);
		
		OperationType operationType = info.getOperationType(); 
			
		if(operationType.isUndefined() && !conversionMethodExists)return true;
		
		if(conversionMethodExists)                  // explicit conversion between primitive types
			info.setInstructionType(operationType.isBasic()?OperationType.BASIC_CONVERSION
													// explicit conversion between complex types
			                         			   :OperationType.CONVERSION);
		return false;
	}
	
	private InfoOperation undefinedOperation(){
		return new InfoOperation().setInstructionType(OperationType.UNDEFINED);
	}
	
	/**@return the info obtained */
	public InfoOperation getInfo(){
		return info;
	}
}