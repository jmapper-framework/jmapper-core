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
import static com.googlecode.jmapper.util.GeneralUtility.isEmpty;
/**
 * This bean represents the global node.
 * @author Alessandro Vurro
 *
 */
public class XmlGlobal {
	
	/** value node that represents the target attribute */
	public XmlTargetAttribute value;
	
	/** list of attributes in the mapping */
	@XStreamConverter(value=NamedCollectionConverter.class, useImplicitType=false,
		      strings={"attribute"}, types={XmlTargetAttribute.class})
	public List<XmlTargetAttribute> attributes;
	
	/** list of target classes */
	public List<XmlTargetClass> classes;

	/** list of attributes excluded from the mapping */
	@XStreamConverter(value=NamedCollectionConverter.class, useImplicitType=false,
		      strings={"attribute"}, types={XmlExcludedAttribute.class})
	public List<XmlExcludedAttribute> excluded;

	@Override
	public String toString() {
		String result = "";
		if(value != null)
			result += "\n         "+value.toValue();
		
		if(!isEmpty(attributes)){
			result += "\n         <attributes>";
			for (XmlTargetAttribute it : attributes) 
			result += "\n            "+it;
			result += "\n         </attributes>";
		}
		if(!isEmpty(classes)){
			result += "\n         <classes>";
			for (XmlTargetClass it : classes) 
			result += "\n            "+it;
			result += "\n         </classes>";		
		}
		if(!isEmpty(excluded)){
			result += "\n         <excluded>";
			for (XmlExcludedAttribute it : excluded) 
			result += "\n            "+it;
			result += "\n         </excluded>";		
		}
		return result;
	}

}
