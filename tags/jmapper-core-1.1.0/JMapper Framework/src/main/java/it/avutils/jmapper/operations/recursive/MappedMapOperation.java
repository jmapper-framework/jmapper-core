/**
 * Copyright (C) 2012 Alessandro Vurro.
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
import static it.avutils.jmapper.util.ClassesManager.getGenericMapKeyItem;
import static it.avutils.jmapper.util.ClassesManager.getGenericMapValueItem;
import static it.avutils.jmapper.util.GeneralUtility.newLine;
import it.avutils.jmapper.enums.ConversionType;
import it.avutils.jmapper.enums.OperationType;
import it.avutils.jmapper.mapper.generation.MappingBuilder;
import it.avutils.jmapper.operations.info.InfoMapOperation;

/**
 * This Class represents the mappings between mapped Maps.
 * @author Alessandro Vurro
 *
 */
public class MappedMapOperation extends ARecursiveOperation {

	@Override
	protected Object getSourceConverted() {
		return "mapOfDestination"+count;
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
		
		Object destMap 	 = getSourceConverted();
		String entryList = "mapOfSource"+count;
		String i = "index"+count;
		
		Class<?> itemDKClass = getGenericMapKeyItem(destinationField);
		Class<?> itemSKClass = getGenericMapKeyItem(sourceField);
		Class<?> itemDVClass = getGenericMapValueItem(destinationField);
		Class<?> itemSVClass = getGenericMapValueItem(sourceField);
		
		Object itemSKType = itemSKClass.getName();
		Object itemDKType = itemDKClass.getName();
		Object itemSVType = itemSVClass.getName();
		Object itemDVType = itemDVClass.getName();

		String itemSKName = "sourceKeyObj"+count;
		String itemDKName = "destinationKeyObj"+count;
		String itemSVName = "sourceValueObj"+count;
		String itemDVName = "destinationValueObj"+count;
		Object entryItem  = "entryItem"+count++;
		
		InfoMapOperation mapInfo      = (InfoMapOperation) info;
		StringBuilder keyConversion   = new StringBuilder();
		StringBuilder valueConversion = new StringBuilder();
		
		OperationType keyInstruction       = mapInfo.getKeyInstructionType();
		ConversionType keyConversionType   = mapInfo.getKeyConversionType();
		OperationType valueInstruction     = mapInfo.getValueInstructionType();
		ConversionType valueConversionType = mapInfo.getValueConversionType();
		
		if(keyInstruction.isBetweenMappedObjects()){
			MappingBuilder mapper = new MappingBuilder(itemDKClass, itemSKClass, itemDKName, itemDKName, itemSKName, mapInfo.getKeyConfigChosen(), xml,methodsToGenerate);
			write(keyConversion,newLine, mapper.mapping(newInstance, ALL_FIELDS, getMts()));
		}
		
		if(valueInstruction.isBetweenMappedObjects()){
			MappingBuilder mapper = new MappingBuilder(itemDVClass, itemSVClass, itemDVName, itemDVName, itemSVName, mapInfo.getValueConfigChosen(), xml,methodsToGenerate);
			write(valueConversion,newLine,mapper.mapping(newInstance, ALL_FIELDS, getMts()));
		}
		
		if(keyInstruction.isBasic())
			if(keyConversionType.isAbsent()) itemDKName = itemSKName;
			else{ Object conversion = applyImplicitConversion(keyConversionType, itemDKClass, itemSKClass, itemSKName);
				  write(keyConversion,newLine,"   ",itemDKType," ",itemDKName," = ",conversion,";");}
		
		if(valueInstruction.isBasic())
			if(valueConversionType.isAbsent()) itemDVName = itemSVName;
			else{ Object conversion = applyImplicitConversion(valueConversionType, itemDVClass, itemSVClass, itemSVName);
				  write(valueConversion,newLine,"   ",itemDVType," ",itemDVName," = ",conversion,";");}
		
		return write(   "   ",newInstance(destMap),
			  newLine , "   Object[] ",entryList," = ",getSource(),".entrySet().toArray();",
			  newLine , "   for(int ",i," = ",entryList,".length-1;",i," >=0;",i,"--){",
			  newLine , "   java.util.Map.Entry ",entryItem," = (java.util.Map.Entry) ",entryList,"[",i,"];",
			  newLine , "   ",itemSKType," ",itemSKName," = (",itemSKType,") ",entryItem,".getKey();",
			  newLine , "   ",itemSVType," ",itemSVName," = (",itemSVType,") ",entryItem,".getValue();",
			  		  	     keyConversion,
			  		  	     valueConversion,
			  newLine , "   ",destMap,".put(",itemDKName,", ",itemDVName,");",
			  newLine , "   }",
			  newLine , 	content , newLine);
			
	}
	
	/** the count is used to differentiate local variables in case of recursive mappings.
	 *  Count is shared between all operation of this type, 
	 *  it's static for ensure the uniqueness
	 */ 
	private static int count = 0;
}
