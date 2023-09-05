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

package com.googlecode.jmapper.generation.beans;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
 * This bean represents the method of a specific class.
 * @author Alessandro Vurro
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Method {

	/** return type of the method*/
	private Class<?> returnType;
	/** method parameters */
	private Class<?>[] parameters;
	/** original conversion method name */
	private String originalName;
	/** method name */
	private String name;
	/** body of the method */
	private String body;
	/** class to which it belongs */
	private Class<?> clazz;
	
	public Method setBody(String body) {
		this.body = body;
		return this;
	}
			
	public Method(Class<?> returnType, Class<?>[] parameters, String name) {
		super();
		this.returnType = returnType;
		this.parameters = parameters;
		this.name = name;
	}
	
}
