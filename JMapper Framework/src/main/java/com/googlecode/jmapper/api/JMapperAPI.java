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
	 * Permits to add one or more configured classes.
	 * @param jmapperClasses classes to add
	 * @return this instance of JMapperAPI
	 */
	public JMapperAPI classes(MappedClass... jmapperClasses){
		for (MappedClass jmapperClass : jmapperClasses)
			root.classes.add(jmapperClass.toXStream());
		return this;
	}

	public XmlJmapper toXStream() {
		return root;
	}
	
}
