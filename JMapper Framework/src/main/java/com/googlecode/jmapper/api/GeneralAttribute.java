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

import com.googlecode.jmapper.xml.beans.XmlTargetAttribute;

/**
 * Common representation of an attribute.
 * 
 * @author Alessandro Vurro
 *
 */
class GeneralAttribute {

	/** target attribute */
	private XmlTargetAttribute targetAttribute;
	
	public GeneralAttribute(String name) {
		targetAttribute = new XmlTargetAttribute(name);
	}
	
	/**
	 * This constructor permits a fast attribute definition.
	 * @param name attribute name
	 * @param customGet custom get method
	 * @param customSet custom set method
	 */
	public GeneralAttribute(String name, String customGet, String customSet) {
		this(name);
		customGet(customGet);
		customSet(customSet);
	}
	
	/**
	 * Name of the custom method used to get this variable.
	 * @param get custom get method
	 * @return this instance of TargetAttribute
	 */
	public GeneralAttribute customGet(String get){
		this.targetAttribute.get = get;
		return this;
	}
	
	/**
	 * Name of the custom method used to set this variable.
	 * @param set custom set method
	 * @return this instance of TargetAttribute
	 */
	public GeneralAttribute customSet(String set){
		this.targetAttribute.set = set;
		return this;
	}
	
	public XmlTargetAttribute toXStream() {
		return this.targetAttribute;
	}

}
