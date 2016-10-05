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

import static com.googlecode.jmapper.enums.ConversionType.UNDEFINED;
import static com.googlecode.jmapper.enums.OperationType.*;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;

import com.googlecode.jmapper.operations.IOperationAnalyzer;
import com.googlecode.jmapper.operations.info.InfoOperation;

/**
 * This Class analyzes operations between Date and Calendar types.
 * @author Alessandro Vurro
 *
 */
public class DateCalendarAnalyzer implements IOperationAnalyzer {

	public InfoOperation getInfoOperation(Field destination, Field source) {
		Class<?> dClass = destination.getType();
		Class<?> sClass = source.getType();
		
		InfoOperation operation = new InfoOperation().setConversionType(UNDEFINED);
		
		// String <- StringBuffer case
		if(isDate(dClass) && isCalendar(sClass))
			return operation.setInstructionType(DATE_CALENDAR);
		
		// StringBuffer <- String case
		if(isCalendar(dClass) && isDate(sClass))
			return operation.setInstructionType(CALENDAR_DATE);
				
		return operation;
	}

	public boolean verifyConditions(Field destination, Field source) {
		Class<?> dClass = destination.getType();
		Class<?> sClass = source.getType();
		
		//destination and source must be of type Date or Calendar
		return (isDate(dClass) && isCalendar(sClass)) 
		    || (isDate(sClass) && isCalendar(dClass));
	}

	private boolean isDate(Class<?> clazz){
		return Date.class.isAssignableFrom(clazz);
	}
	
	private boolean isCalendar(Class<?> clazz){
		return Calendar.class.isAssignableFrom(clazz);
	}

}
