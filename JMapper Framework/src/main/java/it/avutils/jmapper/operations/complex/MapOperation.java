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

package it.avutils.jmapper.operations.complex;

import static it.avutils.jmapper.util.ClassesManager.getGenericMapKeyItem;
import static it.avutils.jmapper.util.ClassesManager.getGenericMapValueItem;
import static it.avutils.jmapper.util.ClassesManager.isAssignableFrom;
import static it.avutils.jmapper.util.GeneralUtility.newLine;
import it.avutils.jmapper.enums.ConversionType;
import it.avutils.jmapper.enums.OperationType;
import it.avutils.jmapper.operations.info.InfoMapOperation;

/**
 * This Class represents the mappings between Maps.
 * @author Alessandro Vurro
 *
 */
public class MapOperation extends AComplexOperation {
	
	@Override
	protected Object getSourceConverted() {
		return "mapOfDestination"+count;
	}
	
	@Override
	protected StringBuilder existingField() {
		return write("   ",getDestination(),".putAll(",getSourceTreated(),");");
	}

	@Override
	protected StringBuilder fieldToCreate() {
		
		// if it is to be converted
		if(theSourceIsToBeConverted()) 
			return setDestination(getSourceTreated());
		
		// if it is allowed to make a direct assignment
		else if(isAssignableFrom(destinationField,sourceField))
			return  setDestination(getSource());
		
		// in all those cases in which it is necessary to convert the structure
		else{
			String map = "complexMap"+count;
			return write("   ",newInstance(map)
			, newLine  , "   ",map,".putAll(",getSource(),");"
			, newLine  ,       setDestination(map));
		}
	}

	@Override
	protected StringBuilder sharedCode(StringBuilder content) {
		
		if(!theSourceIsToBeConverted()){count++; return content;}
		
		Object destMap 	  = getSourceConverted();
		Object entryList  = "mapOfSource"+count;
		Object i = "index"+count;
		
		Class<?> itemDKClass = getGenericMapKeyItem(destinationField);
		Class<?> itemSKClass = getGenericMapKeyItem(sourceField);
		Class<?> itemDVClass = getGenericMapValueItem(destinationField);
		Class<?> itemSVClass = getGenericMapValueItem(sourceField);
		
		Object itemSKType = itemSKClass.getName();
		Object itemDKType = itemDKClass.getName();
		Object itemSVType = itemSVClass.getName();
		Object itemDVType = itemDVClass.getName();
		
		Object itemSKName = "sourceKeyObj"+count;
		Object itemDKName = "destinationKeyObj"+count;
		Object itemSVName = "sourceValueObj"+count;
		Object itemDVName = "destinationValueObj"+count;		
		Object entryItem  = "entryItem"+count++;

		InfoMapOperation mapInfo      = (InfoMapOperation) info;
		StringBuilder keyConversion   = new StringBuilder();
		StringBuilder valueConversion = new StringBuilder();
		
		OperationType keyInstruction       = mapInfo.getKeyInstructionType();
		ConversionType keyConversionType   = mapInfo.getKeyConversionType();
		OperationType valueInstruction     = mapInfo.getValueInstructionType();
		ConversionType valueConversionType = mapInfo.getValueConversionType();
		
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
