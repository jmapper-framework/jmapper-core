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

import com.googlecode.jmapper.operations.beans.MappedField;

/**
 * This bean contains all information relative to a specific nested field.
 * @author Alessandro Vurro
 *
 */
public class NestedMappedField {

	private MappedField field;
	private Class<?> fieldClass;
	
	
	public NestedMappedField(MappedField field, Class<?> fieldClass) {
		super();
		this.field = field;
		this.fieldClass = fieldClass;
	}
	
	public MappedField getField() {
		return field;
	}
	public void setField(MappedField field) {
		this.field = field;
	}
	public Class<?> getFieldClass() {
		return fieldClass;
	}
	public void setFieldClass(Class<?> fieldClass) {
		this.fieldClass = fieldClass;
	}
	
	
}
