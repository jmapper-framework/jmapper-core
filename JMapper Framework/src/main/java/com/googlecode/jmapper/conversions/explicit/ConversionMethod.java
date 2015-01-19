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
package com.googlecode.jmapper.conversions.explicit;


import java.util.Arrays;

import com.googlecode.jmapper.annotations.JMapConversion;
import com.googlecode.jmapper.annotations.JMapConversion.Type;

/**
 * Bean used to centralize all the informations relative to conversion method to perform.
 * @author Alessandro Vurro
 *
 */
public class ConversionMethod {
	
	
	/** Number of the method parameter. */
	public static enum ParameterNumber {ZERO, ONE, TWO};
	
	/** conversion method name */
	private String name;
	/** array of source fields */
	private String[] from;
	/** array of destination fields */
	private String[] to;
	/** identifies the conversion type (STATIC or DYNAMIC) */
	private JMapConversion.Type type;
	/** identifies the number of the method parameter */
	private ParameterNumber parameterNumber;
	/** the body conversion method */
	private String content;
	
	
	public ParameterNumber getParameterNumber() {
		return parameterNumber;
	}
	public void setParameterNumber(ParameterNumber parameterNumber) {
		this.parameterNumber = parameterNumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getFrom() {
		return from;
	}
	public void setFrom(String[] from) {
		this.from = from;
	}
	public String[] getTo() {
		return to;
	}
	public void setTo(String[] to) {
		this.to = to;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	public ConversionMethod() {}
	
	
	/**
	 * @param name
	 * @param from
	 * @param to
	 * @param type
	 * @param parameterNumber
	 * @param content
	 */
	public ConversionMethod(String name, String[] from, String[] to, Type type,
			ParameterNumber parameterNumber, String content) {
		super();
		this.name = name;
		this.from = from;
		this.to = to;
		this.type = type;
		this.parameterNumber = parameterNumber;
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + Arrays.hashCode(from);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((parameterNumber == null) ? 0 : parameterNumber.hashCode());
		result = prime * result + Arrays.hashCode(to);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		ConversionMethod other = (ConversionMethod) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (!Arrays.equals(from, other.from))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parameterNumber != other.parameterNumber)
			return false;
		if (!Arrays.equals(to, other.to))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ConversionMethod [name=" + name + ", from="
				+ Arrays.toString(from) + ", to=" + Arrays.toString(to)
				+ ", type=" + type + ", parameterNumber=" + parameterNumber
				+ ", content=" + content + "]";
	}
	
}
