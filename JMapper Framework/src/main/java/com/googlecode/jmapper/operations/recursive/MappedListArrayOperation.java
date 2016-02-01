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
package com.googlecode.jmapper.operations.recursive;

import static com.googlecode.jmapper.api.enums.MappingType.ALL_FIELDS;
import static com.googlecode.jmapper.util.ClassesManager.getArrayItemClass;
import static com.googlecode.jmapper.util.ClassesManager.getCollectionItemClass;
import static com.googlecode.jmapper.util.GeneralUtility.*;

import java.util.HashMap;
import java.util.Map;

import com.googlecode.jmapper.generation.MapperConstructor;

/**
 * This Class represents the mappings between mapped Collections.
 * @author Alessandro Vurro
 *
 */
public class MappedListArrayOperation extends ARecursiveOperation{

	@Override
	protected String getSourceConvertedName() {
		return c("listArrayOfDestination");
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
		String sItem = c("objectOfSoure");
		String dItem = c("objectOfDestination");
		
		Class<?> itemDClass = getCollectionItemClass(destinationField);
		Class<?> itemSClass = getArrayItemClass(sourceField);
		
		String mapping = s(new MapperConstructor(itemDClass, itemSClass, dItem, dItem, sItem, configChosen, xml,methodsToGenerate)
						                          .mapping(newInstance, ALL_FIELDS, getMts()));
		
		Map<String, String> vars = new HashMap<String, String>();
		
		vars.put("sClass"				   ,itemSClass.getName());
		vars.put("newInstance(destination)",s(newInstance(getSourceConverted())));
		vars.put("destination"             ,s(getSourceConverted()));
		vars.put("source"                  ,c("collectionOfSource"));
		vars.put("getSource()"             ,s(getSource()));
		vars.put("i"                       ,c("index"));
		vars.put("sItem"				   ,sItem);
		vars.put("dItem"				   ,dItem);
		vars.put("mapping"				   ,mapping);
		
		count++;
		
		return write(replace$("   $newInstance(destination)"
				  + newLine + "   $sClass[] $source = $getSource();"
				  + newLine + "   for(int $i = $source.length-1;$i >=0;$i--){"
				  + newLine + "   $sClass $sItem = $source[$i];"
				  + newLine + 	  "$mapping"
				  + newLine + "   $destination.add($dItem);"
				  + newLine + "   }"
				  + newLine + 	content + newLine,vars));
		
	}
	
	/** the count is used to differentiate local variables in case of recursive mappings.
	 *  Count is shared between all operation of this type, 
	 *  it's static for ensure the uniqueness
	 */ 
	private static int count = 0;
	
	/**
	 * Appends the count to string.
	 * @param str
	 * @return str + count;
	 */
	private String c(String str){
		return str + count;
	}
}
