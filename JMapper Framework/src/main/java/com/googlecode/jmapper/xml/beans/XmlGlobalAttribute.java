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

package com.googlecode.jmapper.xml.beans;

import static com.googlecode.jmapper.config.Constants.DEFAULT_ACCESSOR_VALUE;

import com.googlecode.jmapper.xml.SimplyAttribute;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * This bean represents the name attribute of the attribute node.
 * @author Alessandro Vurro
 */
@XStreamAlias("attribute")
public class XmlGlobalAttribute {

	/** name attribute of attribute node */
	@XStreamAsAttribute
	public String name;
	/** get attribute */
	@XStreamAsAttribute
	public String get;
	/** set attribute */
	@XStreamAsAttribute
	public String set;
	
	public XmlGlobalAttribute(String name) {
		this.name = name;
	}
	
	
	public XmlGlobalAttribute(String name, String get, String set) {
		super();
		this.name = name;
		this.get = get;
		this.set = set;
	}


	public XmlGlobalAttribute(SimplyAttribute attribute) {
		name = attribute.getName();
		get = attribute.getGet();
		set = attribute.getSet();
	}

	@Override
	public String toString() {
		
		String result = "<attribute name =\""+name+"\"";
		if(get != null && !DEFAULT_ACCESSOR_VALUE.equals(get))
			result+=" get =\""+get+"\"";
		
		if(set != null && !DEFAULT_ACCESSOR_VALUE.equals(set))
			result+=" set =\""+set+"\"";
		
		return result+=" />";
	}
}
