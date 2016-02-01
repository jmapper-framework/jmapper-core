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
package com.googlecode.jmapper.operations.info;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.jmapper.operations.beans.MappedField;

/**
 * Information relative to nested mapping path.
 * 
 * @author Alessandro Vurro
 *
 */
public class NestedMappingInfo {

	/** list of couples of field-class relatives to nested path */
	private List<NestedMappedField> nestedFields;

	/** true if the nested path is relative to the source */
	private final boolean isSource;

	/** configured class */
	private Class<?> configuredClass;
	
	/** configured field */
	private Field configuredField;
	
	public NestedMappingInfo(boolean isSource) {
		nestedFields = new ArrayList<NestedMappedField>();
		this.isSource = isSource;
	}
	
	
	public boolean isSource() {
		return isSource;
	}


	public boolean isLastField(NestedMappedField field){
		return this.nestedFields.get(nestedFields.size()-1) == field;
	}
	
	public List<NestedMappedField> getNestedFields() {
		return nestedFields;
	}

	public void setNestedFields(List<NestedMappedField> nestedFields) {
		this.nestedFields = nestedFields;
	}
	
	public void addNestedField(NestedMappedField nestedField){
		this.nestedFields.add(nestedField);
	}
	
	public Field getFirstNestedField(){
		return nestedFields.get(0).getField().getValue();
	}
	
	public Class<?> getFirstNestedClass(){
		return nestedFields.get(0).getFieldClass();
	}
	
	public MappedField getLastNestedMappedField(){
		return nestedFields.get(nestedFields.size() - 1).getField();
	}
	
	public Field getLastNestedField(){
		return getLastNestedMappedField().getValue();
	}
	
	public Class<?> getLastNestedClass(){
		return nestedFields.get(nestedFields.size() - 1).getFieldClass();
	}

	public Class<?> getConfiguredClass() {
		return configuredClass;
	}

	public void setConfiguredClass(Class<?> targetClass) {
		this.configuredClass = targetClass;
	}

	public Field getConfiguredField() {
		return configuredField;
	}

	public void setConfiguredField(Field configuredField) {
		this.configuredField = configuredField;
	}
}
