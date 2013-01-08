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

import java.util.Properties;

/**
 * This class manages the composition of the error message.
 * @author Alessandro Vurro
 *
 */
public final class MessageHandler {

	private static Properties msg = MSG.getProperties();
	
	/**
	 * Select the key message and replaces the values passed as input with placeholders.
	 * @param key
	 * @param values
	 * @return returns the resulting string
	 */
	public static String message(String key,String... values){
		String value = (String) msg.get(key);
		for (int i = 0; i < values.length; i++) 
			value = value.replace("{"+i+"}", values[i]);
		
		return value;
	}
	
	/**
	 * Select the key message.
	 * @param key
	 * @return returns the corresponding string 
	 */
	public static String message(String key){
		return (String) msg.get(key);
	}
}
