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

import com.googlecode.jmapper.xml.beans.XmlExcludedAttribute;
import com.googlecode.jmapper.xml.beans.XmlGlobal;
import com.googlecode.jmapper.xml.beans.XmlTargetAttribute;
import com.googlecode.jmapper.xml.beans.XmlTargetClass;

//TODO XSD aggiustarlo
// onlyNameAttribute -> onlyName
// jmapperExcluded -> excludedAttributes
// jmapperClass -> class
// jmapperGlobal -> global
// jmapperTargetAttributes -> attributes
// targetAttribute -> attribute
// jmapperAttribute -> mappedAttribute

/**
 * Global mapping configuration.
 * 
 * @author Alessandro Vurro
 *
 */
public class Global implements Convertible<XmlGlobal>{

	/** xml global node */
	private XmlGlobal global;
	
	public Global() {
		global = new XmlGlobal();
		global.attributes = new ArrayList<XmlTargetAttribute>();
		global.excluded = new ArrayList<XmlExcludedAttribute>();
		global.classes = new ArrayList<XmlTargetClass>();
	}

	/**
	 * Value setting.
	 * 
	 * @param value target field.
	 * @return this instance JMapperGlobal
	 */
	public Global value(TargetAttribute value){
		global.value = value.toXStream();
		return this;
	}
	
	/**
	 * Attributes to include in mapping.
	 * 
	 * @param attributes included attributes
	 * @return this instance of JMapperGlobal
	 */
	public Global includedAttributes(LocalAttribute... attributes){
		
		for (LocalAttribute attribute : attributes)
			global.attributes.add(attribute.toXStream());
		
		return this;
	}
	
	/**
	 * Attributes to exclude from mapping.
	 * 
	 * @param attributes excluded attributes
	 * @return this instance of JMapperGlobal
	 */
	public Global excludedAttributes(String... attributes){
		
		for (String attribute : attributes)
			global.excluded.add(new XmlExcludedAttribute(attribute));
		
		return this;
	}
	
	/**
	 * Target classes.
	 * @param classes target classes
	 * @return this instance of JMapperGlobal
	 */
	public Global targetClasses(TargetClass... classes){
		
		for (TargetClass targetClass : classes) 
			global.classes.add(targetClass.toXStream());
		
		return this;
	}
	
	public XmlGlobal toXStream() {
		return global;
	}
}
