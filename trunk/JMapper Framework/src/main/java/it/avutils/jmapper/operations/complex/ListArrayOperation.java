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
package it.avutils.jmapper.operations.complex;

import static it.avutils.jmapper.util.ClassesManager.getArrayItemClass;
import static it.avutils.jmapper.util.ClassesManager.getCollectionItemClass;
import static it.avutils.jmapper.util.GeneralUtility.listIsAssignableFrom;
import static it.avutils.jmapper.util.GeneralUtility.newLine;
import static it.avutils.jmapper.util.GeneralUtility.sortedSetIsAssignableFrom;

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
		
		Object dList = getSourceConverted();
		Object sList = "collectionOfSource"+count;
		Object sName = "objectOfSource"+count;
		Object dName = "objectOfDestination"+count;
		Object i     = "index"+count++;
		
		Object sItem = sItemType.getName();
		Object dItem = dItemType.getName();

		Object conversion = applyImplicitConversion(info.getConversionType(), dItemType, sItemType, sName);
		
		if(conversion.equals(sName)){
			StringBuilder sb = new StringBuilder();
			// optimization applied to class type
			 if(   listIsAssignableFrom(getDestinationClass())
				|| sortedSetIsAssignableFrom(getDestinationClass()))
							write(sb,"   ",newInstance(dList,"java.util.Arrays#asList("+getSource()+")"),newLine);
			 
			 else           write(sb,"   ",newInstance(dList),newLine
					             ,"   ",dList,".addAll(java.util.Arrays#asList(",getSource(),"));" ,newLine);
			 
			 return write(sb,content);
		}
		
		return write(   "   ",newInstance(dList),
			  newLine , "   ",sItem,"[] ",sList," = ",getSource(),";",
			  newLine , "   for(int ",i," = ",sList,".length-1;",i," >=0;",i,"--){",
			  newLine , "   ",sItem," ",sName," = (",sItem,") ",sList,"[",i,"];",
			  newLine , "   ",dItem," ",dName," = ", conversion ,";",
			  newLine , "   ",dList,".add(",dName,");",
			  newLine , "   }",
			  newLine , 	content , newLine);
	}
	/** the count is used to differentiate local variables in case of recursive mappings.
	 *  Count is shared between all operation of this type, 
	 *  it's static for ensure the uniqueness
	 */ 
	private static int count = 0;
}
