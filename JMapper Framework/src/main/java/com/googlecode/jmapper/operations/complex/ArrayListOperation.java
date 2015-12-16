/**
 * Copyright (C) 2012 - 2015 Alessandro Vurro.
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
package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.ClassesManager.getArrayItemClass;
import static com.googlecode.jmapper.util.ClassesManager.getCollectionItemClass;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import static com.googlecode.jmapper.util.GeneralUtility.replace$;

import java.util.HashMap;
import java.util.Map;

import com.googlecode.jmapper.util.GeneralUtility;

/**
 * This Class represents the mappings between Arrays as destination fields and Lists as source fields.
 * @author Alessandro Vurro
 *
 */
public class ArrayListOperation extends AComplexOperation {

	/** @return Returns the name of the object shared between existingField and fieldToCreate methods.*/
	@Override
	protected String getSourceConvertedName(){
		return c("arrayListOfDestination");
	}
	
	@Override
	protected StringBuilder existingField() {

		Map<String, String> vars = new HashMap<String, String>();
		
		vars.put("dClass"                ,getArrayItemClass(destinationField).getName());
		vars.put("source"                ,s(getSourceConverted()));
		vars.put("result"                ,c("newDestination"));
		vars.put("setDestination(result)",s(setDestination(c("newDestination"))));
		vars.put("destination"           ,c("dep"));
		vars.put("getDestination()"      ,s(getDestination()));

		return write(replace$(GeneralUtility.write("   $dClass[] $destination = $getDestination();"
				  ,newLine, "   $dClass[] $result = ($dClass[])java.util.Arrays.copyOf($destination, $destination.length + $source.length);"
				  ,newLine, "   System.arraycopy($source, 0, $result, $destination.length, $source.length);"
				  ,newLine,     "$setDestination(result)"), vars));
	}

	@Override
	protected StringBuilder fieldToCreate() {
		return setDestination(getSourceConverted());
	}

	@Override
	protected StringBuilder sharedCode(StringBuilder content) {
		
		Class<?> itemDClass = getArrayItemClass(destinationField);
		Class<?> itemSClass = getCollectionItemClass(sourceField);
		Object sItem = c("sourceItem");
		Object conversion = applyImplicitConversion(info.getConversionType(), itemDClass, itemSClass, sItem);
		
		Map<String, String> vars = new HashMap<String, String>();
		
		vars.put("dClass"                ,itemDClass.getName());
		vars.put("sClass"                ,itemSClass.getName());
		vars.put("dItem"				 ,c("destinationItem"));
		vars.put("sItem"                 ,c("sourceItem"));
		vars.put("destination"           ,s(getSourceConverted()));
		vars.put("source"                ,c("sourceArray"));
		vars.put("getSource()"           ,s(getSource()));
		vars.put("i"                     ,c("index"));
		vars.put("nl"                    ,newLine);
		vars.put("content"               ,s(content));
		vars.put("conversion"            ,s(conversion));
		
		count++;

		if(conversion.equals(sItem))
			return write(replace$("   $dClass[] $destination = ($dClass[])$getSource().toArray(new $dClass[$getSource().size()]);$nl$content$nl",vars));
		
		return write(replace$(GeneralUtility.write(
		              "   Object[] $source = $getSource().toArray();"
		    ,newLine, "   $dClass[] $destination = new $dClass[$source.length];"
		    ,newLine, "   for(int $i = $source.length-1;$i >=0;$i--){"
		    ,newLine, "   $sClass $sItem = ($sClass) $source[$i];"
		    ,newLine, "   $dClass $dItem = $conversion;"
		    ,newLine, "   $destination[$i] = $dItem;"
		    ,newLine, "   }"
		    ,newLine, content.toString(), newLine),vars));
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
