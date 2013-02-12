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

package it.avutils.jmapper.operations.recursive;

import static it.avutils.jmapper.enums.MappingType.ALL_FIELDS;
import it.avutils.jmapper.mapper.generation.MappingBuilder;

/**
 * This Class represents the mappings between mapped Objects.
 * @author Alessandro Vurro
 *
 */
public class ObjectOperation extends ARecursiveOperation {

	@Override
	protected StringBuilder existingField() {
		return 	getMapper(getDName()).mapping(enrichment, getMtd(), getMts());
	}

	@Override
	protected StringBuilder fieldToCreate() {
		
		// name of new Object
		String newObj = "obj"+count++;
		return write(getMapper(newObj).mapping(newInstance, ALL_FIELDS, ALL_FIELDS),setDestination(newObj));
	}
	
	/**
	 * Returns a new instance of MappingBuilder
	 * @param dName destination name
	 * @return the mapper
	 */
	private MappingBuilder getMapper(String dName){
		return new MappingBuilder(destinationType(), sourceType(), dName, dName, getSName(), configChosen, xml,methodsToGenerate);
	}
	
	/** the count is used to differentiate local variables in case of recursive mappings.
	 *  Count is shared between all operation of this type, 
	 *  it's static for ensure the uniqueness
	 */ 
	private static int count = 0;

	
}