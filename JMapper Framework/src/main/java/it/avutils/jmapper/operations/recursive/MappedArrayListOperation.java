/**
 * Copyright (C) 2013 Alessandro Vurro.
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

import static it.avutils.jmapper.util.ClassesManager.getArrayItemClass;
import static it.avutils.jmapper.util.ClassesManager.getCollectionItemClass;
import static it.avutils.jmapper.util.GeneralUtility.newLine;
import it.avutils.jmapper.enums.MappingType;
import it.avutils.jmapper.mapper.generation.MappingBuilder;

/**
 * This Class represents the mappings between a mapped/target Array and a mapped/target Collection.
 * @author Alessandro Vurro
 *
 */
public class MappedArrayListOperation extends ARecursiveOperation {

	@Override
	protected Object getSourceConverted() {
		return "arrayListOfDestination"+count;
	}
	
	@Override
	protected StringBuilder existingField() {
		
		Class<?> itemDClass = getArrayItemClass(destinationField);
		
		Object destinationObjClass = itemDClass.getName();
		Object newArray		  = "newDestination"+count;
		Object depArray 	  = "dep"+count;
		Object destArray 	  = getSourceConverted();
		Object i     = "index"  +count;
		Object index = "counter"+count;
		
		return write(   "   ",destinationObjClass,"[] ",depArray," = ",getDestination(),";",
			  newLine , "   ",destinationObjClass,"[] ",newArray," = new ",destinationObjClass,"[",depArray,".length + ",destArray,".length];",
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
		return setDestination(getSourceConverted());
	}
	
	@Override
	protected StringBuilder sharedCode(StringBuilder content) {
		
		Class<?> itemDClass = getArrayItemClass(destinationField);
		Class<?> itemSClass = getCollectionItemClass(sourceField);
		
		Object destination 	 = getSourceConverted();
		Object source   = "arrayListOfSource"+count;
		String itemSName = "objectOfSoure"+count;
		String itemDName   = "objectOfDestination"+count;
		
		String i = "index"+count++;
		String itemSType = itemSClass.getName();
		String itemDType = itemDClass.getName();
		
		MappingBuilder mapper = new MappingBuilder(itemDClass, itemSClass, itemDName, itemDName, itemSName, configChosen, xml,methodsToGenerate); 
		
		return write(   "   Object[] ",source," = ",getSource(),".toArray();",
			  newLine , "   ",itemDType,"[] ",destination," = new ",itemDType,"[",source,".length];",
			  newLine , "   for(int ",i," = ",source,".length-1;",i," >=0;",i,"--){",
			  newLine , "   ",itemSType," ",itemSName," = (",itemSType,") ",source,"[",i,"];",
			  newLine , 	mapper.mapping(newInstance, MappingType.ALL_FIELDS, getMts()),
			  newLine , "   ",destination,"[",i,"] = ",itemDName,";",
			  newLine , "   }",
			  newLine , 	content, newLine);	
	}

	/** the count is used to differentiate local variables in case of recursive mappings.
	 *  Count is shared between all operation of this type, 
	 *  it's static for ensure the uniqueness
	 */ 
	private static int count = 0;
}
