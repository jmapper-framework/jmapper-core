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

package it.avutils.jmapper.exception;

/**
 * Exception thrown when there is an error in the configuration. 
 * @author Alessandro Vurro
 *
 */
public class MappingErrorException extends MappingException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6361684674804088258L;

	public MappingErrorException(String str) {
		super(str);
	}
}
