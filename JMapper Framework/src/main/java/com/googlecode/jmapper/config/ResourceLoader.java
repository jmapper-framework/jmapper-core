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

package com.googlecode.jmapper.config;

import static com.googlecode.jmapper.util.FilesManager.isPath;
import static com.googlecode.jmapper.util.GeneralUtility.isNull;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * The purpose, of ResourceLoader, is to load from classPath the resource requested.
 * @author Alessandro Vurro
 *
 */
public class ResourceLoader {

	/**
	 * Returns an instance of inputStream if resource exists, null otherwise.
	 * @param resource resource to load
	 * @return an inputStream of resource if exists, null otherwise
	 * @throws MalformedURLException if url is malformed
	 * @throws IOException if is impossible to open the stream
	 */
	public static InputStream loadResource(String resource) throws MalformedURLException, IOException{
		String content = resource.trim();
	    
		// if resource is a content and not a path
		if(!isPath(content))
			return new ByteArrayInputStream(content.getBytes("UTF-8"));
		
	    URL url = Thread.currentThread().getContextClassLoader().getResource(content);

	    // Could not find resource. Try with the classloader that loaded this class.
	    if (isNull(url)) {
	      ClassLoader classLoader = ResourceLoader.class.getClassLoader();
	      if (classLoader != null) 
	        url = classLoader.getResource(content);
	      
	    }

	    // Last ditch attempt searching classpath
	    if (isNull(url)) 
	      url = ClassLoader.getSystemResource(content);
	    
	    // one more time
	    if (isNull(url) && content.contains(":")) 
	        url = new URL(content);
	    
	    if(isNull(url))
	    	Error.xmlNotFound(content);
	    
	    return url.openStream();
	}

}
