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

import com.googlecode.jmapper.enums.OperationType;
import com.googlecode.jmapper.operations.complex.ArrayListOperation;
import com.googlecode.jmapper.operations.complex.ArrayOperation;
import com.googlecode.jmapper.operations.complex.CalendarDateOperation;
import com.googlecode.jmapper.operations.complex.CollectionOperation;
import com.googlecode.jmapper.operations.complex.ConversionOperation;
import com.googlecode.jmapper.operations.complex.DateCalendarOperation;
import com.googlecode.jmapper.operations.complex.EnumEnumOperation;
import com.googlecode.jmapper.operations.complex.EnumStringOperation;
import com.googlecode.jmapper.operations.complex.ListArrayOperation;
import com.googlecode.jmapper.operations.complex.MapOperation;
import com.googlecode.jmapper.operations.complex.StringBufferStringOperation;
import com.googlecode.jmapper.operations.complex.StringBuilderStringOperation;
import com.googlecode.jmapper.operations.complex.StringEnumOperation;
import com.googlecode.jmapper.operations.complex.StringStringBufferOperation;
import com.googlecode.jmapper.operations.complex.StringStringBuilderOperation;
import com.googlecode.jmapper.operations.recursive.MappedArrayListOperation;
import com.googlecode.jmapper.operations.recursive.MappedArrayOperation;
import com.googlecode.jmapper.operations.recursive.MappedCollectionOperation;
import com.googlecode.jmapper.operations.recursive.MappedListArrayOperation;
import com.googlecode.jmapper.operations.recursive.MappedMapOperation;
import com.googlecode.jmapper.operations.recursive.ObjectOperation;
import com.googlecode.jmapper.operations.simple.BasicConversion;
import com.googlecode.jmapper.operations.simple.BasicOperation;

/**
 * Operation Factory.
 * @author Alessandro Vurro
 *
 */
public class OperationFactory {
	
	/**
	 * Operation factory.
	 * @param operationType operation type
	 * @return the operation instance relative to this operationType
	 */
	public static AGeneralOperation getOperation(OperationType operationType){
		switch(operationType){
			case BASIC_INSTRUCTION:			   return new BasicOperation();			
			case BASIC_CONVERSION:             return new BasicConversion();			
			case OBJECT:					   return new ObjectOperation();			
			case ARRAY: 					   return new ArrayOperation();			
			case ARRAY_LIST:				   return new ArrayListOperation();		
			case LIST_ARRAY:			       return new ListArrayOperation();		
			case ARRAY_WITH_MAPPED_ITEMS:	   return new MappedArrayOperation();		
			case ARRAY_LIST_WITH_MAPPED_ITEMS: return new MappedArrayListOperation();	
			case LIST_ARRAY_WITH_MAPPED_ITEMS: return new MappedListArrayOperation();	
			case COLLECTION: 				   return new CollectionOperation();		
			case COLLECTION_WITH_MAPPED_ITEMS: return new MappedCollectionOperation();	
			case MAP:	     				   return new MapOperation();				
			case MAP_WITH_MAPPED_ITEMS: 	   return new MappedMapOperation();		
			case CONVERSION: 				   return new ConversionOperation();
			case DATE_CALENDAR:				   return new DateCalendarOperation();
			case STRING_ENUM: 				   return new StringEnumOperation();
			case STRING_STRINGBUFFER:		   return new StringStringBufferOperation();
			case STRING_STRINGBUILDER:		   return new StringStringBuilderOperation();
			case CALENDAR_DATE:				   return new CalendarDateOperation();
			case ENUM_STRING:				   return new EnumStringOperation();
			case STRINGBUILDER_STRING:         return new StringBuilderStringOperation();
			case STRINGBUFFER_STRING:		   return new StringBufferStringOperation();
			case ENUM_ENUM: 				   return new EnumEnumOperation();
			default: return null;
		}
		
	}
	
}