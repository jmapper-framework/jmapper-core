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

import java.util.Arrays;

/**
 * This Class is a java bean that represents the JGlobalMap annotation.
 * 
 * @author Alessandro Vurro
 *
 */
public class Global {

	private String value;
	private String get;
	private String set;
	
	private SimplyAttribute[] attributes;
	private Class<?>[] classes;
	private String[] excluded;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
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
	public SimplyAttribute[] getAttributes() {
		return attributes;
	}
	public void setAttributes(SimplyAttribute[] attributes) {
		this.attributes = attributes;
	}
	public Class<?>[] getClasses() {
		return classes;
	}
	public void setClasses(Class<?>[] classes) {
		this.classes = classes;
	}
	public String[] getExcluded() {
		return excluded;
	}
	public void setExcluded(String[] excluded) {
		this.excluded = excluded;
	}
	
	public Global() {}
	
	
	public Global(String value) {
		super();
		this.value = value;
	}
	
	
	public Global(SimplyAttribute[] attributes) {
		super();
		this.attributes = attributes;
	}
	
	
	public Global(SimplyAttribute[] attributes, Class<?>[] classes) {
		this(attributes);
		this.classes = classes;
	}
	
	
	public Global(String value, Class<?>[] classes) {
		this(value);
		this.classes = classes;
	}
	
	public Global(SimplyAttribute[] attributes, Class<?>[] classes, String[] excluded) {
		this(attributes,classes);
		this.excluded = excluded;
	}
	
	public Global(String value, Class<?>[] classes, String[] excluded) {
		this(value,classes);
		this.excluded = excluded;
	}
	
	public Global(String value, SimplyAttribute[] attributes, Class<?>[] classes,
			String[] excluded) {
		this(attributes,classes,excluded);
		this.value = value;
	}
	
	public Global(String value, String get, String set, SimplyAttribute[] attributes,
			Class<?>[] classes, String[] excluded) {
		this(value, attributes, classes, excluded);
		this.get = get;
		this.set = set;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(attributes);
		result = prime * result + Arrays.hashCode(classes);
		result = prime * result + Arrays.hashCode(excluded);
		result = prime * result + ((get == null) ? 0 : get.hashCode());
		result = prime * result + ((set == null) ? 0 : set.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Global other = (Global) obj;
		if (!Arrays.equals(attributes, other.attributes))
			return false;
		if (!Arrays.equals(classes, other.classes))
			return false;
		if (!Arrays.equals(excluded, other.excluded))
			return false;
		if (get == null) {
			if (other.get != null)
				return false;
		} else if (!get.equals(other.get))
			return false;
		if (set == null) {
			if (other.set != null)
				return false;
		} else if (!set.equals(other.set))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
	
}
