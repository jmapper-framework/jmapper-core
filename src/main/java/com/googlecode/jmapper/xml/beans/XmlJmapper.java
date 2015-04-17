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
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
/**
 * This bean represents the xml mapping file.
 * @author Alessandro Vurro
 *
 */
@XStreamAlias("jmapper")
public class XmlJmapper {

	private static String XSD_FILE = "jmapper-1.3.1.xsd";
	
	/** list of classes node */
	@XStreamImplicit(itemFieldName="class")
	public List<XmlClass> classes;

	@Override
	public String toString() {
		if(classes == null)return "<jmapper />";
		
		String str = "";
		for (XmlClass it : classes)
			str+="\n   <class name = \""+it.name+"\">"+it+"\n   </class>";
		
		return 
		    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
			"\n<jmapper\n"+ 
		            "xmlns=\"https://jmapper-framework.googlecode.com\""+
					"xmlns:xsi=\"https://jmapper-framework.googlecode.com/svn\""+
					"xsi:noNamespaceSchemaLocation=\""+XSD_FILE+"\">"+
					
					str+
					
			"\n</jmapper>";
	}
}
