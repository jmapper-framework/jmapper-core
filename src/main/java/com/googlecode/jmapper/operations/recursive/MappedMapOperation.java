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

import static com.googlecode.jmapper.api.enums.MappingType.ALL_FIELDS;
import static com.googlecode.jmapper.util.ClassesManager.getGenericMapKeyItem;
import static com.googlecode.jmapper.util.ClassesManager.getGenericMapValueItem;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import static com.googlecode.jmapper.util.GeneralUtility.replace$;

import java.util.HashMap;
import java.util.Map;

import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.enums.OperationType;
import com.googlecode.jmapper.generation.MapperConstructor;
import com.googlecode.jmapper.operations.info.InfoMapOperation;

/**
 * This Class represents the mappings between mapped Maps.
 * @author Alessandro Vurro
 *
 */
public class MappedMapOperation extends ARecursiveOperation {

	@Override
	protected Object getSourceConverted() {
		return c("mapOfDestination");
	}
	
	@Override
	protected StringBuilder existingField() {
		return write("   ",getDestination(),".putAll(",getSourceConverted(),");");
	}

	@Override
	protected StringBuilder fieldToCreate() {
		return setDestination(getSourceConverted());
	}

	@Override
	protected StringBuilder sharedCode(StringBuilder content) {
		
		Class<?> itemDKClass = getGenericMapKeyItem(destinationField);
		Class<?> itemSKClass = getGenericMapKeyItem(sourceField);
		Class<?> itemDVClass = getGenericMapValueItem(destinationField);
		Class<?> itemSVClass = getGenericMapValueItem(sourceField);
		
		Object skClass = itemSKClass.getName();
		Object dkClass = itemDKClass.getName();
		Object svClass = itemSVClass.getName();
		Object dvClass = itemDVClass.getName();

		String skItem = c("sourceKeyObj");
		String dkItem = c("destinationKeyObj");
		String svItem = c("sourceValueObj");
		String dvItem = c("destinationValueObj");
		Object sItem  = c("entryItem");
				
		InfoMapOperation mapInfo      = (InfoMapOperation) info;
		StringBuilder keyConversion   = new StringBuilder();
		StringBuilder valueConversion = new StringBuilder();
		
		OperationType keyInstruction       = mapInfo.getKeyInstructionType();
		ConversionType keyConversionType   = mapInfo.getKeyConversionType();
		OperationType valueInstruction     = mapInfo.getValueInstructionType();
		ConversionType valueConversionType = mapInfo.getValueConversionType();
		
		if(keyInstruction.isBetweenMappedObjects()){
			MapperConstructor mapper = new MapperConstructor(itemDKClass, itemSKClass, dkItem, dkItem, skItem, mapInfo.getKeyConfigChosen(), xml,methodsToGenerate);
			write(keyConversion,newLine, mapper.mapping(newInstance, ALL_FIELDS, getMts()));
		}
		
		if(valueInstruction.isBetweenMappedObjects()){
			MapperConstructor mapper = new MapperConstructor(itemDVClass, itemSVClass, dvItem, dvItem, svItem, mapInfo.getValueConfigChosen(), xml,methodsToGenerate);
			write(valueConversion,newLine,mapper.mapping(newInstance, ALL_FIELDS, getMts()));
		}
		
		if(keyInstruction.isBasic())
			if(keyConversionType.isAbsent()) dkItem = skItem;
			else{ Object conversion = applyImplicitConversion(keyConversionType, itemDKClass, itemSKClass, skItem);
				  write(keyConversion,newLine,"   ",dkClass," ",dkItem," = ",conversion,";");}
		
		if(valueInstruction.isBasic())
			if(valueConversionType.isAbsent()) dvItem = svItem;
			else{ Object conversion = applyImplicitConversion(valueConversionType, itemDVClass, itemSVClass, svItem);
				  write(valueConversion,newLine,"   ",dvClass," ",dvItem," = ",conversion,";");}
		
		Map<String, String> vars = new HashMap<String, String>();
		
		vars.put("newInstance(destination)",s(newInstance(getSourceConverted())));
		vars.put("destination"             ,s(getSourceConverted()));
		vars.put("source"                  ,c("mapOfSource"));
		vars.put("getSource()"             ,s(getSource()));
		vars.put("i"                       ,c("index"));
		vars.put("sItem"                   ,s(sItem));
		vars.put("skClass"				   ,s(skClass));
		vars.put("svClass"				   ,s(svClass));
		vars.put("skItem"                  ,s(skItem));
		vars.put("svItem"                  ,s(svItem));
		vars.put("dkItem"                  ,s(dkItem));
		vars.put("dvItem"                  ,s(dvItem));
		vars.put("keyConversion"           ,s(keyConversion));
		vars.put("valueConversion"         ,s(valueConversion));
		
		count++;
		
		return write(replace$("   $newInstance(destination)"
				  + newLine + "   Object[] $source = $getSource().entrySet().toArray();"
				  + newLine + "   for(int $i = $source.length-1;$i >=0;$i--){"
				  + newLine + "   java.util.Map.Entry $sItem = (java.util.Map.Entry) $source[$i];"
				  + newLine + "   $skClass $skItem = ($skClass) $sItem.getKey();"
				  + newLine + "   $svClass $svItem = ($svClass) $sItem.getValue();"
				   		    +     "$keyConversion"
				  		    +     "$valueConversion"
				  + newLine + "   $destination.put($dkItem, $dvItem);"
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