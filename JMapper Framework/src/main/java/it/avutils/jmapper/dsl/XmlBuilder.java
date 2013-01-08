/**
 * Copyright (C) 2013 Alessandro Vurro.
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
package it.avutils.jmapper.dsl;

import it.avutils.jmapper.util.XML;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * XmlBuilder increases the readability of the code to create the XML object.
 * <br>For example:<pre><code>loadXml(path).atRuntime();</code></pre> 
 * @author Alessandro Vurro
 *
 */
public class XmlBuilder {

	public static XmlBuilder loadXml(String path){return new XmlBuilder(path);}

	public XML atRuntime() throws MalformedURLException, IOException{
		return new XML(true, path);
	}
	
	public XML atDevelopmentTime() throws MalformedURLException, IOException{
		return new XML(false, path);
	}
	
	private String path;
	
	private XmlBuilder(String path){this.path = path;}
}
