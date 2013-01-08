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

package it.avutils.jmapper.config;

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
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static InputStream loadResource(String resource) throws MalformedURLException, IOException{
		resource = resource.trim();
	    
	    URL result = Thread.currentThread().getContextClassLoader().getResource(resource);

	    // Could not find resource. Try with the classloader that loaded this class.
	    if (result == null) {
	      ClassLoader classLoader = ResourceLoader.class.getClassLoader();
	      if (classLoader != null) 
	        result = classLoader.getResource(resource);
	      
	    }

	    // Last ditch attempt searching classpath
	    if (result == null) 
	      result = ClassLoader.getSystemResource(resource);
	    
	    // one more time
	    if (result == null && resource.contains(":")) 
	        result = new URL(resource);
	    
	    return result.openStream();
	}

}
