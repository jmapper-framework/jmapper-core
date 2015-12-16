/**
 * Copyright (C) 2012 - 2015 Alessandro Vurro.
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

/**
 * Information relative to nested mapping path.
 * 
 * @author Alessandro Vurro
 *
 */
public class NestedMappingInfo {

	List<NestedMappedField> nestedFields;

	public NestedMappingInfo() {
		nestedFields = new ArrayList<NestedMappedField>();
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
	
	public Field getLastNestedField(){
		return nestedFields.get(nestedFields.size() - 1).getField().getValue();
	}
	
	public Class<?> getLastNestedClass(){
		return nestedFields.get(nestedFields.size() - 1).getFieldClass();
	}
}
