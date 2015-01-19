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

import java.util.List;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * This bean represents the attribute node.
 * @author Alessandro Vurro
 *
 */
public class XmlAttribute {

	/** name attribute */
	@XStreamAsAttribute
	public String name;
	/** value node */
	public XmlValueName value;
	/** list of target attributes */
	public List<XmlAttributeName> attributes;
	/** list of target classes */
	public List<XmlClassName> classes;
	
	@Override
	public String toString() {
		String str = "";
		if(value != null)
			str += "\n         <value name =\""+value.name+"\"/>";
		
		if(attributes != null){
			str += "\n         <attributes>";
			for (XmlAttributeName it : attributes) 
			str += "\n            <attribute name =\""+it.name+"\"/>";
			str += "\n         </attributes>";
		}
		if(classes != null){
			str += "\n         <classes>";
			for (XmlClassName it : classes) 
			str += "\n            <class name =\""+it.name+"\"/>";
			str += "\n         </classes>";		
		}
		return str;
	}
}
