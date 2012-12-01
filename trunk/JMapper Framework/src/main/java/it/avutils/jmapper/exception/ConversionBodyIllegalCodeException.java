/**
 * Copyright (C) 2012 Alessandro Vurro.
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
 * Exception thrown when the conversion method body containts an illegal code.
 * @author Alessandro Vurro
 *
 */
public class ConversionBodyIllegalCodeException extends MappingException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8989661634624957876L;

	public ConversionBodyIllegalCodeException(String str) {
		super(str);
	}

}
