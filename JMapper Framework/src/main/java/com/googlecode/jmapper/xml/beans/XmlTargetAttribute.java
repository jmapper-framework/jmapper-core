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

import com.googlecode.jmapper.xml.SimplyAttribute;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * This bean represents the name attribute of the attribute node.
 * @author Alessandro Vurro
 */
public class XmlTargetAttribute {

	/** name attribute of attribute node */
	@XStreamAsAttribute
	public String name;
	/** get attribute */
	@XStreamAsAttribute
	public String get;
	/** set attribute */
	@XStreamAsAttribute
	public String set;
	
	/**
	 * @param name name of this attribute
	 */
	public XmlTargetAttribute(String name) {
		this.name = name;
	}
	
	/**
	 * @param name name of this attribute
	 * @param get custom get method
	 * @param set custom set method
	 */
	public XmlTargetAttribute(String name, String get, String set) {
		super();
		this.name = name;
		this.get = get;
		this.set = set;
	}

	/**
	 * @param attribute attribute
	 */
	public XmlTargetAttribute(SimplyAttribute attribute) {
		name = attribute.getName();
		get = attribute.getGet();
		set = attribute.getSet();
	}

	public static final String attributeNode = "attribute";
	public static final String valueNode = "value";
	
	@Override
	public String toString() {
		return toString(attributeNode);
	}
	
	/**
	 * Returns the represention of this node with name "value".
	 * @return string value
	 */
	public String toValue(){
		return toString(valueNode);
	}
	
	private String toString(String nodeName) {
		
		String result = "<"+nodeName+" name =\""+name+"\"";
		if(!isNull(get) && !DEFAULT_ACCESSOR_VALUE.equals(get))
			result+=" get =\""+get+"\"";
		
		if(!isNull(set) && !DEFAULT_ACCESSOR_VALUE.equals(set))
			result+=" set =\""+set+"\"";
		
		return result+=" />";
	}
}
