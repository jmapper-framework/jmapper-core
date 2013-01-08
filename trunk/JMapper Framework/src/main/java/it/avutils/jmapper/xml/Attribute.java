/**
 * Copyright (C) 2013 Alessandro Vurro.
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
package it.avutils.jmapper.xml;

import it.avutils.jmapper.constants.Constants;

import java.util.Arrays;

/**
 * This Class is a java bean that represents the JMap annotation.
 * 
 * @author Alessandro Vurro
 *
 */
public class Attribute {

	private String name;
	private String value;
	private String[] attributes;
	private Class<?>[] classes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String[] getAttributes() {
		return attributes;
	}
	public void setAttributes(String[] attributes) {
		this.attributes = attributes;
	}
	public Class<?>[] getClasses() {
		return classes;
	}
	public void setClasses(Class<?>[] classes) {
		this.classes = classes;
	}
	
	
	/**
	 * Giving only the field name, JMapper assumes that the name of the target field is equal.
	 * @param name
	 */
	public Attribute(String name){
		this(name,Constants.DEFAULT_FIELD_VALUE);
	}

	/**
	 * This constructor allows you to define the configured field name and target field name.
	 * @param name configured field name
	 * @param value target field name
	 */
	public Attribute(String name, String value) {
		this.name = name;
		this.value = value;
	}	

	/**
	 * This constructor allows you to define the configured field name, the attributes and the classes.
	 * @param name configured field name
	 * @param attributes target attributes
	 * @param classes target classes
	 */
	public Attribute(String name,String[] attributes, Class<?>[] classes) {
		this(name,attributes);
		this.classes = classes;
	}
	

	/**
	 * This constructor allows you to define the configured field name, the target field name, the attributes and the classes.
	 * @param name configured field name
	 * @param value target field name
	 * @param attributes target attributes
	 * @param classes target classes
	 */
	public Attribute(String name, String value, String[] attributes,Class<?>[] classes) {
		this(name,attributes,classes);
		this.value = value;
	}

	/**
	 * This constructor allows you to define the configured field name and the attributes. 
	 * @param name configured field name
	 * @param attributes target attributes
	 */
	public Attribute(String name, String[] attributes) {
		this.name = name;
		this.attributes = attributes;
	}
	
	/**
	 * Empty constructor
	 */
	public Attribute() {}
	
	@Override
	public String toString() {
		return "Attribute [name=" + name + ", value=" + value + ", attributes="
				+ Arrays.toString(attributes) + ", classes="
				+ Arrays.toString(classes) + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(attributes);
		result = prime * result + Arrays.hashCode(classes);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Attribute other = (Attribute) obj;
		if (!Arrays.equals(attributes, other.attributes))
			return false;
		if (!Arrays.equals(classes, other.classes))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
}
