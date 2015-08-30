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

package com.googlecode.jmapper.config;

import static com.googlecode.jmapper.config.Constants.MSG_FILE;
import static com.googlecode.jmapper.config.ResourceLoader.loadResource;
import static com.googlecode.jmapper.util.GeneralUtility.isNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class manages the composition of the error message.
 * @author Alessandro Vurro
 *
 */
public enum MSG {
	
	INSTANCE;
	
	private final Properties properties;
	
	private MSG() {
		properties = new Properties();
		try{ InputStream stream = loadResource(MSG_FILE);
			 if(isNull(stream))Error.fileNotFound();
			
			 try                   { properties.load (stream);  } 
			 catch (IOException e) { Error.unableLoadingFile(); }
			
		}catch (Exception e) { JmapperLog.ERROR(e);}
		
	}
			
	/**
	 * Select the key message and replaces the values passed as input with placeholders.
	 * @param key message key
	 * @param values content to replaces
	 * @return returns the resulting string
	 */
	public String message(String key,String... values){
		String value = properties.getProperty(key);
		for (int i = 0; i < values.length; i++) 
			value = value.replace("{"+i+"}", values[i]);
		
		return value;
	}
			
}
