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
package com.googlecode.jmapper.exceptions;

import java.util.HashMap;

/**
 * Exception thrown when the nested mapping is invalid.
 * @author Alessandro Vurro
 *
 */
public class InvalidNestedMappingException extends MappingException {

	private HashMap<String, String> messages;
	
	public HashMap<String, String> getMessages() {
		return messages;
	}

	public static String REGEX = "REGEX";
	public static String FIELD = "FIELD";
	
	public InvalidNestedMappingException(String str) {
		super(str);
		messages = new HashMap<String, String>();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1394972573794535662L;

}
