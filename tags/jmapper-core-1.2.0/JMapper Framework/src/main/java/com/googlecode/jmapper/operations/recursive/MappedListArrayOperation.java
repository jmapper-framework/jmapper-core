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
package com.googlecode.jmapper.operations.recursive;

import static com.googlecode.jmapper.enums.MappingType.ALL_FIELDS;
import static com.googlecode.jmapper.util.ClassesManager.getArrayItemClass;
import static com.googlecode.jmapper.util.ClassesManager.getCollectionItemClass;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import com.googlecode.jmapper.generation.MapperConstructor;

/**
 * This Class represents the mappings between mapped Collections.
 * @author Alessandro Vurro
 *
 */
public class MappedListArrayOperation extends ARecursiveOperation{

	@Override
	protected Object getSourceConverted() {
		return "listArrayOfDestination"+count;
	}
	
	@Override
	protected StringBuilder existingField() {
		return write("   ",getDestination(),".addAll(",getSourceConverted(),");");
	}

	@Override
	protected StringBuilder fieldToCreate() {
		return setDestination(getSourceConverted());
	}

	@Override
	protected StringBuilder sharedCode(StringBuilder content) {
		Object destList 	 = getSourceConverted();
		String sourceList    = "collectionOfSource"+count;
		String itemSName = "objectOfSoure"+count;
		String itemDName = "objectOfDestination"+count;
		
		Class<?> itemDClass = getCollectionItemClass(destinationField);
		Class<?> itemSClass = getArrayItemClass(sourceField);
		
		MapperConstructor mapper = new MapperConstructor(itemDClass, itemSClass, itemDName, itemDName, itemSName, configChosen, xml,methodsToGenerate);
		
		String i = "index"+count++;
		String itemSType = itemSClass.getName();
		
		return write(	"   ",newInstance(destList),
			  newLine , "   ",itemSType,"[] ",sourceList," = ",getSource(),";",
			  newLine , "   for(int ",i," = ",sourceList,".length-1;",i," >=0;",i,"--){",
			  newLine , "   ",itemSType," ",itemSName," = ",sourceList,"[",i,"];",
			  newLine , 	mapper.mapping(newInstance, ALL_FIELDS, getMts()),
			  newLine , "   ",destList,".add(",itemDName,");",
			  newLine , "   }",
			  newLine , 	content , newLine);
		
	}
	
	/** the count is used to differentiate local variables in case of recursive mappings.
	 *  Count is shared between all operation of this type, 
	 *  it's static for ensure the uniqueness
	 */ 
	private static int count = 0;}
