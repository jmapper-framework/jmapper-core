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

package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.ClassesManager.getArrayItemClass;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

/**
 * This Class represents the mappings between Arrays.
 * @author Alessandro Vurro
 *
 */
public class ArrayOperation extends AComplexOperation {
	
	/** @return Returns the name of the object shared between existingField and fieldToCreate methods.*/
	@Override
	protected Object getSourceConverted(){
		return "arrayOfDestination"+count;
	}
	
	@Override
	protected StringBuilder existingField() {

		Object destClass = getArrayItemClass(destinationField).getName();
		Object destArray = getSourceTreated();
		Object newArray	 = "newDestination"+count;
		Object depArray  = "dep"+count;
		Object i     = "index"  +count;
		Object index = "counter"+count;

		return write(   "   ",destClass,"[] ",depArray," = ",getDestination(),";",
			  newLine , "   ",destClass,"[] ",newArray," = new ",destClass,"[",depArray,".length + ",destArray,".length];",
			  newLine , "   int ",index," = 0;",
			  newLine , "   for(int ",i," = ",depArray,".length-1;",i," >=0;",i,"--){",
			  newLine , "   ",newArray,"[",index,"++] = ",depArray,"[",i,"];",
			  newLine , "   }",
			  newLine , "   for(int ",i," = ",destArray,".length-1;",i," >=0;",i,"--){",
			  newLine , "   ",newArray,"[",index,"++] = ",destArray,"[",i,"];",
			  newLine , "   }",
			  newLine ,     setDestination(newArray));

	}

	@Override
	protected StringBuilder fieldToCreate() {
		return setDestination(getSourceTreated());
	}

	@Override
	protected StringBuilder sharedCode(StringBuilder content) {

		Class<?> itemDClass = getArrayItemClass(destinationField);
		Class<?> itemSClass = getArrayItemClass(sourceField);

		Object destination 	 = getSourceConverted();
		Object source   = "arrayOfSource"+count;
		Object itemSName = "objectOfSoure"+count;
		Object itemDName   = "objectOfDestination"+count;

		Object i = "index"+count++;
		Object itemS = itemSClass.getName();
		Object itemD = itemDClass.getName();

		Object conversion = applyImplicitConversion(info.getConversionType(), itemDClass, itemSClass, itemSName);

		if(conversion.equals(itemSName))return content;
		

		return write(   "   ",itemS,"[] ",source," = ",getSource(),";",
			  newLine , "   ",itemD,"[] ",destination," = new ",itemD,"[",source,".length];",
			  newLine , "   for(int ",i," = ",source,".length-1;",i," >=0;",i,"--){",
			  newLine , "   ",itemS," ",itemSName," = (",itemS,") ",source,"[",i,"];",
			  newLine , "   ",itemD," ",itemDName," = " ,conversion,";",
			  newLine , "   ",destination,"[",i,"] = ",itemDName,";",
			  newLine , "   }",
			  newLine , 	content , newLine);
	}

	/** the count is used to differentiate local variables in case of recursive mappings.
	 *  Count is shared between all operation of this type, 
	 *  it's static for ensure the uniqueness
	 */ 
	private static int count = 0;
}