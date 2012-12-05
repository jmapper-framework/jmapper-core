/**
 * Copyright (C) 2012 Alessandro Vurro.
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

package it.avutils.jmapper.mapper.generation.beans;

import java.util.Arrays;

/** 
 * This bean represents the method of a specific class.
 * @author Alessandro Vurro
 *
 */
public class Method {

	/** return type of the method*/
	private Class<?> returnType;
	/** method parameters */
	private Class<?>[] parameters;
	/** original conversione method name */
	private String originalName;
	/** method name */
	private String name;
	/** body of the method */
	private String body;
	/** class to which it belongs */
	private Class<?> clazz;
	
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getBody() {
		return body;
	}
	public Method setBody(String body) {
		this.body = body;
		return this;
	}
	public Class<?> getReturnType() {
		return returnType;
	}
	public Method setReturnType(Class<?> returnType) {
		this.returnType = returnType;
		return this;
	}
	public Class<?>[] getParameters() {
		return parameters;
	}
	public Method setParameters(Class<?>[] parameters) {
		this.parameters = parameters;
		return this;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Class<?> getClazz() {
		return clazz;
	}
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}
	public Method() {}
	public Method(Class<?> returnType, Class<?>[] parameters, String name) {
		super();
		this.returnType = returnType;
		this.parameters = parameters;
		this.name = name;
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
		Method other = (Method) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Method [returnType=" + returnType + ", parameters="
				+ Arrays.toString(parameters) + ", originalName="
				+ originalName + ", name=" + name + ", body=" + body
				+ ", clazz=" + clazz + "]";
	}
}
