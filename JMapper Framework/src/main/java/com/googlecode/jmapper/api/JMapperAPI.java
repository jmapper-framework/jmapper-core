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

import com.googlecode.jmapper.xml.beans.XmlClass;
import com.googlecode.jmapper.xml.beans.XmlJmapper;

/**
 * JMapperAPI permits to define the configuration via API.
 * 
 * @author Alessandro Vurro
 *
 */
public class JMapperAPI implements Convertible<XmlJmapper>{

	/** xstream root */
	private XmlJmapper root;
	
	public JMapperAPI() {
		root = new XmlJmapper();
		root.classes = new ArrayList<XmlClass>();
	}
	
	/**
	 * Permits to add a configured class.
	 * @param mappedClass class to add
	 * @return this instance of JMapperAPI
	 */
	public JMapperAPI add(MappedClass mappedClass){
		root.classes.add(mappedClass.toXStream());
		return this;
	}

	public XmlJmapper toXStream() {
		return root;
	}
	
	/**
	 * Permits to define a MappedClass bean.
	 * @param mappedClass class to configure
	 * @return an instance of MappedClass
	 */
	public static MappedClass mappedClass(Class<?> mappedClass){
		return new MappedClass(mappedClass);
	}

	/**
	 * Permits to define a MappedClass bean.
	 * @param mappedClassName the complete name of the class to configure
	 * @return an instance of MappedClass
	 */
	public static MappedClass mappedClass(String mappedClassName){
		return new MappedClass(mappedClassName);
	}

	/**
	 * Permits to define an attribute to map.
	 * @param name name of this attribute
	 * @return an instance of Attribute
	 */
	public static Attribute attribute(String name){
		return new Attribute(name);
	}
	
	/**
	 * Permits to define an attribute to map.
	 * @param name name of this attribute
	 * @param customGet custom get method
	 * @param customSet custom set method
	 * @return an instance of Attribute
	 */
	public static Attribute attribute(String name, String customGet, String customSet){
		return new Attribute(name, customGet, customSet);
	}
	
	/**
	 * Permits to define a target attribute.
	 * @param name target attribute name
	 * @return an instance of TargetAttribute
	 */
	public static TargetAttribute targetAttribute(String name){
		return new TargetAttribute(name);
	}
	
	/**
	 * Permits to define a target attribute.
	 * @param name target attribute name
	 * @param customGet custom get method
	 * @param customSet custom set method
	 * @return an instance of TargetAttribute
	 */
	public static TargetAttribute targetAttribute(String name, String customGet, String customSet){
		return new TargetAttribute(name, customGet, customSet);
	}
	
	/**
	 * Permits to define a local attribute.
	 * @param name local attribute name
	 * @return an instance of LocalAttribute
	 */
	public static LocalAttribute localAttribute(String name){
		return new LocalAttribute(name);
	}
	
	/**
	 * Permits to define a local attribute.
	 * @param name local attribute name
	 * @param customGet custom get method
	 * @param customSet custom set method
	 * @return an instance of LocalAttribute
	 */
	public static LocalAttribute localAttribute(String name, String customGet, String customSet){
		return new LocalAttribute(name, customGet, customSet);
	}
	
	/**
	 * Permits to define a conversion method.
	 * @param name name of this conversion method
	 * @return an instance of Conversion
	 */
	public static Conversion conversion(String name){
		return new Conversion(name);
	}
	
	/**
	 * @return an instance of Global
	 */
	public static Global global(){
		return new Global();
	}
	
	
}
