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

import java.io.IOException;
import java.net.MalformedURLException;


/**
 * XmlBuilder increases the readability of the code simplifying the XML object creation.
 * <br>For example:<pre><code>loadXml(path).atRuntime();</code></pre> 
 * @author Alessandro Vurro
 *
 */
public class XmlBuilder {

	/**
	 * this method permits to create an instance of XmlBuilder specifying the xml path.
	 * @param path xml path
	 * @return an instance of XmlBuilder
	 */
	public static XmlBuilder loadXml(String path){return new XmlBuilder(path);}

	/**
	 * Returns an XML instance with the purpose to retrieve the xml file at runtime.
	 * @return an xml instance 
	 * @throws MalformedURLException in case of malformed xml path 
	 * @throws IOException other cases
	 */
	public XML atRuntime() throws MalformedURLException, IOException{
		return new XML(true, path);
	}
	
	/**
	 * Returns an XML instance with the purpose to retrieve the xml file at development time.
	 * @return an xml instance
	 * @throws MalformedURLException in case of malformed xml path
	 * @throws IOException other cases
	 */
	public XML atDevelopmentTime() throws MalformedURLException, IOException{
		return new XML(false, path);
	}
	
	/** xml path */
	private String path;
	
	/**
	 * Private constructor to avoid direct creation.
	 * @param path xml path
	 */
	private XmlBuilder(String path){this.path = path;}
}
