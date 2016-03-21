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

import java.util.ArrayList;

import com.googlecode.jmapper.xml.beans.XmlAttribute;
import com.googlecode.jmapper.xml.beans.XmlTargetAttribute;
import com.googlecode.jmapper.xml.beans.XmlTargetClass;
/**
 * Attribute permits to configure an attribute.
 * 
 * @author Alessandro Vurro
 *
 */
public class Attribute implements Convertible<XmlAttribute>{

	/** represents the value node */
	private XmlAttribute xmlAttribute;
	
	/**
	 * @param name attribute name
	 */
	public Attribute(String name) {
		xmlAttribute = new XmlAttribute(name);
		xmlAttribute.attributes = new ArrayList<XmlTargetAttribute>();
		xmlAttribute.classes = new ArrayList<XmlTargetClass>();
	}
	
	/**
	 * @param name attribute name
	 * @param customGet custom get method of this attribute
	 * @param customSet custom set method of this attribute
	 */
	public Attribute(String name, String customGet, String customSet) {
		this(name);
		customGet(customGet);
		customSet(customSet);
	}
	
	/**
	 * Permits to define a custom get method for this attribute.
	 * @param get get method to use
	 * @return this instance of Attribute
	 */
	public Attribute customGet(String get){
		xmlAttribute.get = get;
		return this;
	}
	
	/**
	 * Permits to define a custom set method for this attribute.
	 * @param set set method to use
	 * @return this instance of Attribute
	 */
	public Attribute customSet(String set){
		xmlAttribute.set = set;
		return this;
	}
	
	/**
	 * Value setting.
	 * 
	 * @param targetAttribute target field.
	 * @return this instance Attribute
	 */
	public Attribute value(TargetAttribute targetAttribute){
		xmlAttribute.value = targetAttribute.toXStream();
		return this;
	}
	
	/**
	 * Permits to define target attributes.
	 * It is recommended to use this method only if you want to define custom methods, otherwise {@link #targetAttributes(String...) targetAttributes} is recommended.
	 * @param attributes target attributes
	 * @return this instance of Attribute
	 */
	public Attribute targetAttributes(TargetAttribute... attributes){
		
		for (TargetAttribute attribute : attributes)
			xmlAttribute.attributes.add(attribute.toXStream());
		
		return this;
	}
	
	/**
	 * Permits to define target attributes passing in input only the names in string format.
	 * @param attributes target attributes
	 * @return this instance of Attribute
	 */
	public Attribute targetAttributes(String... attributes){
		
		for (String attribute : attributes)
			xmlAttribute.attributes.add(new TargetAttribute(attribute).toXStream());
		
		return this;
	}
	
	/**
	 * Target classes.
	 * @param classes target classes
	 * @return this instance of Attribute
	 */
	public Attribute targetClasses(Class<?>... classes){
		
		for (Class<?> targetClass : classes) 
			xmlAttribute.classes.add(new TargetClass(targetClass).toXStream());
		
		return this;
	}
	
	public XmlAttribute toXStream() {
		return xmlAttribute;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attribute other = (Attribute) obj;
		if (xmlAttribute == null) {
			if (other.xmlAttribute != null)
				return false;
		} else if (!xmlAttribute.equals(other.xmlAttribute))
			return false;
		return true;
	}
}
