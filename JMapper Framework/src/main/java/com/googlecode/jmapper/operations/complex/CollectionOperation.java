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

import static com.googlecode.jmapper.util.ClassesManager.getCollectionItemClass;
import static com.googlecode.jmapper.util.ClassesManager.isAssignableFrom;
import static com.googlecode.jmapper.util.GeneralUtility.listIsAssignableFrom;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import static com.googlecode.jmapper.util.GeneralUtility.replace$;
import static com.googlecode.jmapper.util.GeneralUtility.sortedSetIsAssignableFrom;

import java.util.HashMap;
import java.util.Map;
/**
 * This Class represents the mappings between Collections.
 * @author Alessandro Vurro
 *
 */
public class CollectionOperation extends AComplexOperation {
	
	@Override
	protected String getSourceConvertedName() {
		return c("collectionOfDestination");
	}
	
	@Override
	protected StringBuilder existingField() {
		return write("   ",getDestination(),".addAll(",getSourceTreated(),");");
	}

	@Override
	protected StringBuilder fieldToCreate() {
		
		// if it is to be converted
		if(theSourceIsToBeConverted()) 
			  return setDestination(getSourceTreated());
		
		// if it is allowed to make a direct assignment
		else if(isAssignableFrom(destinationField,sourceField))
			  return setDestination(getSource());
		
		// in all those cases in which it is necessary to convert the structure
		else{
			  Object list = c("complexCollection");
			  StringBuilder sb = new StringBuilder();
			  
			  // optimization applied to class type
			 if(   listIsAssignableFrom(getDestinationClass()) 
				|| sortedSetIsAssignableFrom(getDestinationClass()))
				 
							write(sb,"   ",newInstance(list,getSource()),newLine);
			 
			 else           write(sb,"   ",newInstance(list)                ,newLine
					                ,"   ",list,".addAll(",getSource(),");" ,newLine);
			
			 return write(sb,setDestination(list));
		}
	}

	@Override
	protected StringBuilder sharedCode(StringBuilder content) {
		
		if(!theSourceIsToBeConverted()){count++; return content;}
		
		Class<?> itemDClass = getCollectionItemClass(destinationField);
		Class<?> itemSClass = getCollectionItemClass(sourceField);
		Object sItem = c("objectOfSource");
		Object conversion = applyImplicitConversion(info.getConversionType(), itemDClass, itemSClass, sItem);
		
		Map<String, String> vars = new HashMap<String, String>();
		
		vars.put("dClass"                  ,itemDClass.getName());
		vars.put("sClass"                  ,itemSClass.getName());
		vars.put("dItem"				   ,c("objectOfDestination"));
		vars.put("sItem"                   ,s(sItem));
		vars.put("source"                  ,c("collectionOfSource"));
		vars.put("destination"             ,s(getSourceConverted()));
		vars.put("i"                       ,c("index"));
		vars.put("getSource()"             ,s(getSource()));
		vars.put("conversion"              ,s(conversion));
		vars.put("newInstance(destination)",s(newInstance(getSourceConverted())));
		
		count++;
		
		return write(replace$("   $newInstance(destination)"
				  + newLine + "   Object[] $source = $getSource().toArray();"
				  + newLine + "   for(int $i = $source.length-1;$i >=0;$i--){"
				  + newLine + "   $sClass $sItem = ($sClass) $source[$i];"
				  + newLine + "   $dClass $dItem = $conversion;"
				  + newLine + "   $destination.add($dItem);"
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
