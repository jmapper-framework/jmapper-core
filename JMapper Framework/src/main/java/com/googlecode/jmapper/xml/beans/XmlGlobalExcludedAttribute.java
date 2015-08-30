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
package com.googlecode.jmapper.xml.beans;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * This bean represents the name attribute of the attribute node.
 * @author Alessandro Vurro
 */
@XStreamAlias("attribute")
public class XmlGlobalExcludedAttribute {
	/** name attribute of class node */
	@XStreamAsAttribute
	public String name;
	
	public XmlGlobalExcludedAttribute(String name) {this.name = name;}

	@Override
	public String toString() {
		return "<attribute name =\""+name+"\"/>";
	}
}
