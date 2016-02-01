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

import static com.googlecode.jmapper.util.ClassesManager.getArrayItemClass;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import static com.googlecode.jmapper.util.GeneralUtility.replace$;
import java.util.HashMap;
import java.util.Map;
import com.googlecode.jmapper.api.enums.MappingType;
import com.googlecode.jmapper.generation.MapperConstructor;

/**
 * This Class represents the mappings between mapped Arrays.
 * @author Alessandro Vurro
 *
 */
public class MappedArrayOperation extends ARecursiveOperation {

	@Override
	protected String getSourceConvertedName() {
		return c("arrayOfDestination");
	}
	
	@Override
	protected StringBuilder existingField() {
		
		Map<String, String> vars = new HashMap<String, String>();
		
		vars.put("dClass"                  ,getArrayItemClass(destinationField).getName());
		vars.put("source"                  ,s(getSourceConverted()));
		vars.put("destination"             ,c("dep"));
		vars.put("i"                       ,c("index"));
		vars.put("counter"                 ,c("counter"));
		vars.put("getDestination()"        ,s(getDestination()));
		vars.put("setDestination(result)"  ,s(setDestination(c("newDestination"))));
		vars.put("result"                  ,c("newDestination"));
		
		return write(replace$("   $dClass[] $destination = $getDestination();"
				  + newLine + "   $dClass[] $result = new $dClass[$destination.length + $source.length];"
				  + newLine + "   int $counter = 0;"
				  + newLine + "   for(int $i = $destination.length-1;$i >=0;$i--){"
				  + newLine + "   $result[$counter++] = $destination[$i];"
				  + newLine + "   }"
				  + newLine + "   for(int $i = $source.length-1;$i >=0;$i--){"
				  + newLine + "   $result[$counter++] = $source[$i];"
				  + newLine + "   }"
				  + newLine +     "$setDestination(result)",vars));
	}

	@Override
	protected StringBuilder fieldToCreate() {
		return setDestination(getSourceConverted());
	}
	
	@Override
	protected StringBuilder sharedCode(StringBuilder content) {
		
		Class<?> itemDClass = getArrayItemClass(destinationField);
		Class<?> itemSClass = getArrayItemClass(sourceField);
		
		String sItem = c("objectOfSoure");
		String dItem   = c("objectOfDestination");
		
		String mapping = s(new MapperConstructor(itemDClass, itemSClass, dItem, dItem, sItem, configChosen, xml,methodsToGenerate)
									    .mapping(newInstance, MappingType.ALL_FIELDS, getMts())); 

		Map<String, String> vars = new HashMap<String, String>();
		
		vars.put("dClass"                  ,itemDClass.getName());
		vars.put("sClass"                  ,itemSClass.getName());
		vars.put("dItem"				   ,dItem);
		vars.put("sItem"				   ,sItem);
		vars.put("source"                  ,c("arrayOfSource"));
		vars.put("destination"             ,s(getSourceConverted()));
		vars.put("i"                       ,c("index"));
		vars.put("getSource()"             ,s(getSource()));
		vars.put("mapping"                 ,mapping);
		
		count++;
		
		return write(replace$("   $sClass[] $source = $getSource();"
				  + newLine + "   $dClass[] $destination = new $dClass[$source.length];"
				  + newLine + "   for(int $i = $source.length-1;$i >=0;$i--){"
				  + newLine + "   $sClass $sItem = ($sClass) $source[$i];"
				  + newLine + 	"$mapping"
				  + newLine + "   $destination[$i] = $dItem;"
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
