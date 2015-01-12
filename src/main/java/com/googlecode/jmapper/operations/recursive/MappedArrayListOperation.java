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

import static com.googlecode.jmapper.util.ClassesManager.getArrayItemClass;
import static com.googlecode.jmapper.util.ClassesManager.getCollectionItemClass;
import static com.googlecode.jmapper.util.GeneralUtility.*;

import java.util.HashMap;
import java.util.Map;

import com.googlecode.jmapper.api.enums.MappingType;
import com.googlecode.jmapper.generation.MapperConstructor;

/**
 * This Class represents the mappings between a mapped/target Array and a mapped/target Collection.
 * @author Alessandro Vurro
 *
 */
public class MappedArrayListOperation extends ARecursiveOperation {

	@Override
	protected Object getSourceConverted() {
		return c("arrayListOfDestination");
	}
	
	@Override
	protected StringBuilder existingField() {
		
		Map<String, String> vars = new HashMap<String, String>();
		
		vars.put("dClass"                  ,getArrayItemClass(destinationField).getName());
		vars.put("source"                  ,s(getSourceConverted()));
		vars.put("destination"             ,c("dep"));
		vars.put("getDestination()"        ,s(getDestination()));
		vars.put("setDestination(result)"  ,s(setDestination(c("newDestination"))));
		vars.put("result"                  ,c("newDestination"));
		
		return write(replace$("   $dClass[] $destination = $getDestination();"
				  + newLine + "   $dClass[] $result = ($dClass[]) java.util.Arrays.copyOf($destination, $destination.length + $source.length);"
				  + newLine + "   System.arraycopy($source, 0, $result, $destination.length, $source.length);"
				  + newLine + "$setDestination(result)",vars));
	}

	@Override
	protected StringBuilder fieldToCreate() {
		return setDestination(getSourceConverted());
	}
	
	@Override
	protected StringBuilder sharedCode(StringBuilder content) {
		
		Class<?> dArrayClass = getArrayItemClass(destinationField);
		Class<?> sCollectionClass = getCollectionItemClass(sourceField);

		String sItem = c("objectOfSoure");
		String dItem = c("objectOfDestination");
		
		String mapping = s(new MapperConstructor(dArrayClass, sCollectionClass, dItem, dItem, sItem, configChosen, xml,methodsToGenerate)
									    .mapping(newInstance, MappingType.ALL_FIELDS, getMts())); 
		
		Map<String, String> vars = new HashMap<String, String>();
		
		vars.put("dClass"                  ,dArrayClass.getName());
		vars.put("sClass"                  ,sCollectionClass.getName());
		vars.put("dItem"                   ,dItem);
		vars.put("sItem"                   ,sItem);
		vars.put("source"                  ,c("arrayListOfSource"));
		vars.put("destination"             ,s(getSourceConverted()));
		vars.put("i"                       ,c("index"));
		vars.put("getSource()"             ,s(getSource()));
		vars.put("mapping"                 , mapping);
		
		count++;
		return write(replace$("   Object[] $source = $getSource().toArray();"
				  + newLine + "   $dClass[] $destination = new $dClass[$source.length];"
				  + newLine + "   for(int $i = $source.length-1;$i >=0;$i--){"
				  + newLine + "   $sClass $sItem = ($sClass) $source[$i];"
				  + newLine + "$mapping"
				  + newLine + "   $destination[$i] = $dItem;"
				  + newLine + "   }"
				  + newLine + content + newLine,vars));	
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
