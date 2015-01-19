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

/**
 * Exception thrown when does not exists configuration for a specific class.
 * @author Alessandro Vurro
 *
 */
public class XmlMappingClassDoesNotExistException extends XmlMappingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6268538037719580382L;

	public XmlMappingClassDoesNotExistException(String str) {
		super(str);
		
	}

}
