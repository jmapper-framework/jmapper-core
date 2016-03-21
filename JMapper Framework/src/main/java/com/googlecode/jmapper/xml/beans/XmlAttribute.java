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
import static com.googlecode.jmapper.util.GeneralUtility.isNull;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.NamedCollectionConverter;

/**
 * This bean represents the attribute node.
 * @author Alessandro Vurro
 *
 */
public class XmlAttribute {

	/** name attribute */
	@XStreamAsAttribute
	public String name;
	/** get attribute */
	@XStreamAsAttribute
	public String get;
	/** set attribute */
	@XStreamAsAttribute
	public String set;
	/** value node */
	public XmlTargetAttribute value;
	/** list of target attributes */
	@XStreamConverter(value=NamedCollectionConverter.class, useImplicitType=false,
		      strings={"attribute"}, types={XmlTargetAttribute.class})
	public List<XmlTargetAttribute> attributes;
	/** list of target classes */
	public List<XmlTargetClass> classes;
	
	public XmlAttribute() {}
	
	public XmlAttribute(String name){
		this.name = name;	
	}
	
	public String attributes(){
		String result = " name= \""+name+"\"";
		
		if(!isNull(get) && !DEFAULT_ACCESSOR_VALUE.equals(get))
			result+=" get =\""+get+"\"";
		
		if(!isNull(set) && !DEFAULT_ACCESSOR_VALUE.equals(set))
			result+=" set =\""+set+"\"";
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XmlAttribute other = (XmlAttribute) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		String result = "";
		if(value != null)
			result += "\n         "+value.toValue();
			
		if(attributes != null){
			result += "\n         <attributes>";
			for (XmlTargetAttribute it : attributes) 
			result += "\n            "+it;
			result += "\n         </attributes>";
		}
		if(classes != null){
			result += "\n         <classes>";
			for (XmlTargetClass it : classes) 
			result += "\n            "+it;
			result += "\n         </classes>";		
		}
		return result;
	}
}
