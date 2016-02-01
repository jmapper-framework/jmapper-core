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
package com.googlecode.jmapper.xml.beans;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.NamedCollectionConverter;

/**
 * This bean represents the global node.
 * @author Alessandro Vurro
 *
 */
public class XmlGlobal {
	
	/** value node */
	public XmlGlobalValue value;
	/** list of target attributes */
	@XStreamConverter(value=NamedCollectionConverter.class, useImplicitType=false,
		      strings={"attribute"}, types={XmlGlobalAttribute.class})
	public List<XmlGlobalAttribute> attributes;
	/** list of target classes */
	public List<XmlTargetClass> classes;
	/** list of target excluded attributes */
	
	@XStreamConverter(value=NamedCollectionConverter.class, useImplicitType=false,
		      strings={"attribute"}, types={XmlGlobalExcludedAttribute.class})
	public List<XmlGlobalExcludedAttribute> excluded;

	@Override
	public String toString() {
		String result = "";
		if(value != null)
			result += "\n         "+value;
		
		if(attributes != null){
			result += "\n         <attributes>";
			for (XmlGlobalAttribute it : attributes) 
			result += "\n            "+it;
			result += "\n         </attributes>";
		}
		if(classes != null){
			result += "\n         <classes>";
			for (XmlTargetClass it : classes) 
			result += "\n            "+it;
			result += "\n         </classes>";		
		}
		if(excluded != null){
			result += "\n         <excluded>";
			for (XmlGlobalExcludedAttribute it : excluded) 
			result += "\n            "+it;
			result += "\n         </excluded>";		
		}
		return result;
	}

}
