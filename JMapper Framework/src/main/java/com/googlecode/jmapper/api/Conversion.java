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
package com.googlecode.jmapper.api;

import com.googlecode.jmapper.annotations.JMapConversion.Type;
import com.googlecode.jmapper.xml.beans.XmlConversion;
import static com.googlecode.jmapper.util.GeneralUtility.join;
/**
 * Permits to define a conversion.
 * 
 * @author Alessandro Vurro
 *
 */
class Conversion implements Convertible<XmlConversion>{

	private XmlConversion conversion;
	
	/**
	 * @param name conversion method name
	 */
	public Conversion(String name) {
		conversion = new XmlConversion(name);
	}
	
	/**
	 * Permits to define the type of this conversion method.
	 * @param type conversion type
	 * @return this instance of Conversion
	 */
	public Conversion type(Type type){
		conversion.type = type.toString();
		return this;
	}
	
	/**
	 * Permits to define source fields.
	 *
	 * @param fields
	 * @return this instance of Conversion
	 */
	public Conversion from(String... fields){
		conversion.from = join(",",fields);
		return this;
	}
	
	/**
	 * Permits to define destination fields.
	 *
	 * @param fields
	 * @return this instance of Conversion
	 */
	public Conversion to(String... fields){
		conversion.to = join(",",fields);
		return this;
	}
	
	/**
	 * True if the set method, of the destination field, should be ignored.
	 * @param avoidSet avoid set
	 * @return this instance of Conversion
	 */
	public Conversion avoidSet(boolean avoidSet){
		conversion.avoidSet = avoidSet;
		return this;
	}
	
	/**
	 * Permits to define the body of this conversion method.
	 * @param body conversion body
	 * @return this instance of Conversion
	 */
	public Conversion body(String body){
		conversion.content = body;
		return this;
	}
	
	public XmlConversion toXStream() {
		return conversion;
	}

}
