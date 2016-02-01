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
package com.googlecode.jmapper.xml;

import com.googlecode.jmapper.xml.beans.XmlGlobalAttribute;

/**
 * This Class is a java bean that represents the attributes mapped to target fields.
 * 
 * @author Alessandro Vurro
 *
 */
public class SimplyAttribute {

	private String name;
	private String get;
	private String set;
	
	public SimplyAttribute(XmlGlobalAttribute xmlTargetAttribute) {
		this.name = xmlTargetAttribute.name;
		this.get = xmlTargetAttribute.get;
		this.set = xmlTargetAttribute.set;
	}
	
	public SimplyAttribute(String name, String get, String set) {
		super();
		this.name = name;
		this.get = get;
		this.set = set;
	}
	public SimplyAttribute(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGet() {
		return get;
	}
	public void setGet(String get) {
		this.get = get;
	}
	public String getSet() {
		return set;
	}
	public void setSet(String set) {
		this.set = set;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		SimplyAttribute other = (SimplyAttribute) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
