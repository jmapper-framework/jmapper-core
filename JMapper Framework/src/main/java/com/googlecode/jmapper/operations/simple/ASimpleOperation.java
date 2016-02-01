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

package com.googlecode.jmapper.operations.simple;

import static com.googlecode.jmapper.util.GeneralUtility.isNull;

import com.googlecode.jmapper.operations.AGeneralOperation;

/**
 * This class represents an abstract simple operation.
 * 
 * @author Alessandro Vurro
 *
 */
public abstract class ASimpleOperation extends AGeneralOperation {

	/**
	 * @return a StringBuilder that contains the mapping operation handling nested field too
	 */
	public StringBuilder write(){
		StringBuilder nestedMapping = getNestedMapping();
		StringBuilder mapping = mapping();
		return isNull(nestedMapping)?mapping:nestedMapping.append(mapping);
	}
	
	/**
	 * @return a StringBuilder containing the mapping operation
	 */
	public abstract StringBuilder mapping();
}
