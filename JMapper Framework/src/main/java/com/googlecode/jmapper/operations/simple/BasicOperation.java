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

package com.googlecode.jmapper.operations.simple;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

/**
 * This Class represents a basic operation. 
 * for basic operation we mean an instruction of this type:<br>
 * <code>destination.setString(source.getString())</code>
 * <br>are excluded Collections, Maps, complex mappedObj and 
 * all that you can not manage with a simple mapping.
 * 
 * @author Alessandro Vurro
 *
 */
public class BasicOperation extends ASimpleOperation{

	public StringBuilder mapping() {

		System.out.println("");
		Object content = setDestination(applyImplicitConversion(info.getConversionType(), destinationType(), sourceType(), getSource()));
				           
		// add and return a mapping type control
		return this.addMappingTypeControl(write(content,newLine));
						
	}
	
}
