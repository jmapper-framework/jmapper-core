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
package com.googlecode.jmapper.operations.complex;


/**
 * This Operation converts Date to Calendar type.
 * @author Alessandro Vurro
 *
 */
public class CalendarDateOperation extends AComplexOperation {

	/** the count is used to differentiate local variables in case of recursive mappings.
	 *  Count is shared between all operation of this type, 
	 *  it's static for ensure the uniqueness
	 */ 
	private static int count = 0;
	
	@Override
	protected String getSourceConvertedName() {
		return c("toDateDestination");
	}
	
	@Override
	protected StringBuilder existingField() {
		return sharedMapping();
	}

	@Override
	protected StringBuilder fieldToCreate() {
		return sharedMapping();
	}

	private StringBuilder sharedMapping(){
		return write(setDestination(getSourceConverted()));
	}
	
	@Override
	protected StringBuilder sharedCode(StringBuilder content) {
		count++;
		
		String result = s(getSourceConverted());
		
		return write("java.util.Calendar ",result," = java.util.Calendar.getInstance(); ",
				      result,".setTime(",getSource(),");", content.toString());
	}
	
	/**
	 * Appends the count to string.
	 * @param str
	 * @return str + count;
	 */
	private String c(String str){
		return str + count;
	}
}
