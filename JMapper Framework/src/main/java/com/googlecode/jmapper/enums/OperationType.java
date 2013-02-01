/**
 * Copyright (C) 2012 - 2013 Alessandro Vurro.
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

package com.googlecode.jmapper.enums;

/**
 * Enumeration that contains types of permitted mappings.
 * 
 * @author Alessandro Vurro
 */
public enum OperationType {

	// basic instructions that can be controlled, this operation provides an instruction of type set(get())
	BASIC_INSTRUCTION,
	
	// collections with basic items
	COLLECTION,
	
	// arrays of primitive or wrapper types
	ARRAY,
	
	// destination field is an array, source field is a list
	ARRAY_LIST,
	
	// destination field is a list, source field is an array
	LIST_ARRAY,
	
	// maps with a basic pairs
	MAP,
	
	// objects that are mapped
	OBJECT,
	
	// arrays with mapped items
	ARRAY_WITH_MAPPED_ITEMS,
	
	// destination field is an array with mapped items, source field is a list with mapped items
	ARRAY_LIST_WITH_MAPPED_ITEMS,
	
	// destination field is a list with mapped items, source field is an array with mapped items
	LIST_ARRAY_WITH_MAPPED_ITEMS,
	
	// collections with mapped items
	COLLECTION_WITH_MAPPED_ITEMS,
	
	// maps with mapped items
	MAP_WITH_MAPPED_ITEMS,
	
	// instruction is undefined
	UNDEFINED, 

	// instruction that contains an explicit basic conversion
	BASIC_CONVERSION,
	
	// instruction that contains an explicit complex conversion
	CONVERSION;
	
	public boolean isUndefined(){return this == UNDEFINED;}
	
	public boolean isRecursive(){ return this == OBJECT 
								   || this == COLLECTION_WITH_MAPPED_ITEMS  
								   || this == ARRAY_WITH_MAPPED_ITEMS 
								   || this == ARRAY_LIST_WITH_MAPPED_ITEMS
								   || this == LIST_ARRAY_WITH_MAPPED_ITEMS
								   || this == MAP_WITH_MAPPED_ITEMS;}
	 
	 public boolean isBetweenMappedObjects(){return this == OBJECT;}
	 
	 public boolean isBasic(){	 return this == BASIC_INSTRUCTION || this == BASIC_CONVERSION; }
	 
	 public boolean isComplex(){ return isRecursive() 
			 						 || this == MAP  
			 						 || this == COLLECTION
			 						 || this == ARRAY
			 						 || this == ARRAY_LIST
			 						 || this == LIST_ARRAY
			 						 || this == CONVERSION;}
	 
	 public boolean isConverted(){ return this == CONVERSION || this == BASIC_CONVERSION; }
}
