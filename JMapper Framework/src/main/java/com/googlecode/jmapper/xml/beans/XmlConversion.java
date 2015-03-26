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
package com.googlecode.jmapper.xml.beans;

import static com.googlecode.jmapper.config.Constants.DEFAULT_ACCESSOR_VALUE;

import com.googlecode.jmapper.annotations.JMapConversion;
import com.googlecode.jmapper.config.Constants;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * XmlConversion rapresents the explicit conversion definition.
 * @author Alessandro Vurro
 *
 */
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"content"})
public class XmlConversion {

	/** conversion method name        */
	@XStreamAsAttribute
	public String name;
	/** conversion method source      */
	@XStreamAsAttribute
	public String from;
	/** conversion method destination */
	@XStreamAsAttribute
	public String to;
	/** conversion method type        */
	@XStreamAsAttribute
	public String type;
	/** conversion method content     */
	public String content;

    public XmlConversion(String name, String from, String to, String type,
			String content) {
		super();
		this.name = name;
		this.from = from;
		this.to = to;
		this.type = type;
		this.content = content;
	}
    
	public XmlConversion() {}
	
	public String attributes(){
		String result = " name= \""+name+"\"";
		
		if(from != null && !JMapConversion.ALL.equalsIgnoreCase(from))
			result+=" from =\""+from+"\"";
		
		if(to != null && !JMapConversion.ALL.equalsIgnoreCase(to))
			result+=" to =\""+to+"\"";
		
		if(type != null && !JMapConversion.Type.STATIC.name().equalsIgnoreCase(type))
			result+=" type =\""+type+"\"";
		
		return result;
	}
	@Override
	public String toString() {
		return content;
	}
}
