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
package it.avutils.jmapper.operations.simple;

import static it.avutils.jmapper.util.GeneralUtility.newLine;

/**
 * This Class represents a basic conversion. 
 * for basic conversion we mean an instruction between primitive types,
 * <br>are excluded Collections, Maps, complex mappedObj and 
 * all that you can not manage with a simple mapping.
 * 
 * @author Alessandro Vurro
 *
 */
public class BasicConversion extends ASimpleOperation {

	@Override
	public StringBuilder write() {
		// add and return a mapping type control
		return this.addMappingTypeControl(write(applyExplicitConversion(),newLine));
	}

}
