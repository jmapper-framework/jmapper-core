/**
 * Copyright (C) 2012 - 2013 Alessandro Vurro.
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

import java.util.List;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * This bean represents the class node.
 * @author Alessandro Vurro
 */
public class XmlClass {

	/** name attribute of class node */
	@XStreamAsAttribute
	public String name;
	/** global configuration */
	public XmlGlobal global;
	/** list of attributes node */
	@XStreamImplicit(itemFieldName="attribute")
	public List<XmlAttribute> attributes;
	/** list of conversions node */
	@XStreamImplicit(itemFieldName="conversion")
	public List<XmlConversion> conversions;
	
	public XmlClass() {}
	
	/**
	 * @param name
	 */
	public XmlClass(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		String str = "";
		
		if(global != null)
			str += "\n      <global>"+global+"\n      </global>";
		if(attributes != null) for (XmlAttribute it : attributes) 
			str += "\n      <attribute name=\""+it.name+"\">"+it+"\n      </attribute>";
				
		if(conversions != null) for (XmlConversion it : conversions) 
			str += "\n      <conversion name=\""+it.name+"\" from=\""+it.from+"\" to=\""+it.to+"\" type=\""+it.type+"\">"+it.content+"\n      </conversion>";
		
		return str;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)	 return true;
		if (obj == null)	 return false;
		if (getClass() != obj.getClass())			return false;
		if(((XmlClass) obj).name.equals(this.name)) return true;
		return false;
		
	}

	
	
	
}
