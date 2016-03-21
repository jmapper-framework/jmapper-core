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
import com.googlecode.jmapper.xml.beans.XmlClass;
import com.googlecode.jmapper.xml.beans.XmlConversion;

/**
 * MappedClass permits to handle the configuration for a specific class.
 * 
 * @author Alessandro Vurro
 *
 */
public class MappedClass implements Convertible<XmlClass>{

	/** xstream class */
	private XmlClass xmlClass;

	/**
	 * @param clazz class to configure
	 */
	public MappedClass(Class<?> clazz) {
		this(clazz.getName());
	}
	
	/**
	 * @param clazz class to configure
	 */
	public MappedClass(String clazz) {
		this.xmlClass = new XmlClass(clazz);
		this.xmlClass.attributes = new ArrayList<XmlAttribute>();
		this.xmlClass.conversions = new ArrayList<XmlConversion>();
	}
	
	/**
	 * Permits to add a configured attribute.
	 * @param attribute attribute to add
	 * @return this instance of MappedClass
	 */
	public MappedClass add(Attribute attribute){
		this.xmlClass.attributes.add(attribute.toXStream());
		return this;
	}
	
	/**
	 * Permits to add o conversion method.
	 * @param conversion conversion method to add
	 * @return this instance of MappedClass
	 */
	public MappedClass add(Conversion conversion){
		this.xmlClass.conversions.add(conversion.toXStream());
		return this;
	}
		
	/**
	 * Add global mapping.
	 * @param global global mapping
	 * @return this instance of MappedClass
	 */
	public MappedClass add(Global global){
		this.xmlClass.global = global.toXStream();
		return this;
	}
	
	public XmlClass toXStream() {
		return xmlClass;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		MappedClass other = (MappedClass) obj;
		if (xmlClass == null) {
			if (other.xmlClass != null) return false;
		} else 
			if (!xmlClass.equals(other.xmlClass)) return false;
		
		return true;
	}
	
	
}
