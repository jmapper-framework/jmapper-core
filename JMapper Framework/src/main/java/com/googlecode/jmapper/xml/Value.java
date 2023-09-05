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

import com.googlecode.jmapper.xml.beans.XmlTargetAttribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This Class is a java bean that represents the value node.
 * 
 * @author Alessandro Vurro
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Value {

	private String name;
	private String get;
	private String set;
	
	public Value(XmlTargetAttribute value) {
		this.name = value.name;
		this.get = value.get;
		this.set = value.set;
	}
	
	public Value(String name) {
		super();
		this.name = name;
	}


	

	
	
	
}
