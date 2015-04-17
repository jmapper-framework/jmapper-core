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
import static com.googlecode.jmapper.util.GeneralUtility.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This Class represents the mappings between Lists as destination fields and Arrays as source fields.
 * @author Alessandro Vurro
 *
 */
public class ListArrayOperation extends AComplexOperation{

	/** @return Returns the name of the object shared between existingField and fieldToCreate methods.*/
	@Override
	protected Object getSourceConverted(){
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
		
		Class<?> dItemType = getCollectionItemClass(destinationField);
		Class<?> sItemType = getArrayItemClass(sourceField);
		Object sItem = c("objectOfSource");
		Object destination = getSourceConverted();
		Object conversion = applyImplicitConversion(info.getConversionType(), dItemType, sItemType, sItem);
		
		Map<String, String> vars = new HashMap<String, String>();
		
		vars.put("dClass"                  ,dItemType.getName());
		vars.put("sClass"                  ,sItemType.getName());
		vars.put("dItem"				   ,c("objectOfDestination"));
		vars.put("sItem"                   ,s(sItem));
		vars.put("source"                  ,c("collectionOfSource"));
		vars.put("destination"             ,s(destination));
		vars.put("i"                       ,c("index"));
		vars.put("getSource()"             ,s(getSource()));
		vars.put("conversion"              ,s(conversion));
		vars.put("newInstance(destination)",s(newInstance(destination)));
		
		count++;
		
		if(conversion.equals(sItem)){
			StringBuilder sb = new StringBuilder();
			
			// optimization applied to class type
			if(         listIsAssignableFrom(getDestinationClass())
		        || sortedSetIsAssignableFrom(getDestinationClass()))
				 
				    write(sb,"   ",newInstance(destination,"java.util.Arrays#asList("+getSource()+")"),newLine);
			 
			 else   write(sb,"   ",newInstance(destination),newLine,
					         "   ",destination,".addAll(java.util.Arrays#asList(",getSource(),"));",newLine);
			 
			 return write(sb,content);
		}
		
		return write(replace$("   $newInstance(destination)"
				  + newLine + "   $sClass[] $source = $getSource();"
				  + newLine + "   for(int $i = $source.length-1;$i >=0;$i--){"
				  + newLine + "   $sClass $sItem = ($sClass) $source[$i];"
				  + newLine + "   $dClass $dItem = $conversion;"
				  + newLine + "   $destination.add($dItem);"
				  + newLine + "   }"
				  + newLine + 	  content + newLine,vars));
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
