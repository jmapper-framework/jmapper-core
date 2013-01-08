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
package it.avutils.jmapper.operations;

import static it.avutils.jmapper.conversions.implicit.ConversionHandler.getConversion;
import static it.avutils.jmapper.enums.MappingType.ONLY_NULL_FIELDS;
import static it.avutils.jmapper.util.ClassesManager.isBoxing;
import static it.avutils.jmapper.util.ClassesManager.isUnBoxing;
import static it.avutils.jmapper.util.GeneralUtility.getMethod;
import static it.avutils.jmapper.util.GeneralUtility.mSet;
import static it.avutils.jmapper.util.GeneralUtility.newLine;
import it.avutils.jmapper.enums.ConversionType;

/**
 * This abstract class represents an abstract operation that adds, 
 * to basic mapping, a mapping type control.
 * 
 * @author Alessandro Vurro
 *
 */
public abstract class AGeneralOperation extends AGeneralOperationAccessor{
	
	/**
	 * @return a StringBuilder calculated at runtime representing the complete set destination path.
	 * <br>for example: destination.setField;
	 */
	protected final StringBuilder setDestination() {	
		return write(initialDSetPath,".",mSet(destinationField.getName()));		
	}
	
	/**
	 * Returns a StringBuilder that contains setDestination(content); operation.
	 * @param content content to set
	 * @return a StringBuilder with setDestination(content); operation
	 */
	protected final StringBuilder setDestination(Object content){
		return write("   ",setDestination(),"(",content,");");
	}
	
	/**
	 * @return a StringBuilder calculated at runtime representing the complete get destination path.
	 * <br>for example: destination.getField()
	 */
	protected final StringBuilder getDestination() {	
		return write(initialDGetPath,".",getMethod(destinationField.getType(),destinationField.getName()),"()");
	}

	/**
	 * @return a StringBuilder calculated at runtime representing the complete get source path.
	 * <br>for example: source.getField()
	 */
	protected final StringBuilder getSource() {	
		return write(initialSGetPath,".",getMethod(sourceField.getType(),sourceField.getName()),"()");			
	}

	/**
	 * this method adds a mapping type control to the basic mapping.
	 * @param content mapping that will be wrapped with mappingType control
	 * @return a String that contains a single operation
	 */
	protected final StringBuilder addMappingTypeControl(StringBuilder content){
		
		StringBuilder sb = new StringBuilder();
		int openBracket = 0;
		
		boolean isDPrimitive = destinationType().isPrimitive();
		boolean isSPrimitive = sourceType().isPrimitive();
		
		
		if(!isDPrimitive && isNullSetting())
			content = write(setDestination("null"),newLine);
		
		if(	   ((isDPrimitive || isSPrimitive) && isNullSetting())
			|| ((isDPrimitive && mtd == ONLY_NULL_FIELDS)))
			// it's impossible to apply the mapping type requested
			return write(newLine);
		
		if(!isDPrimitive)
			switch(mtd){case ONLY_VALUED_FIELDS: write(sb,"   if(",getDestination(),"!=null){",newLine); openBracket++;break;
						case ONLY_NULL_FIELDS:	 write(sb,"   if(",getDestination(),"==null){",newLine); openBracket++;break;}
		
		if(!isSPrimitive)
		   if(!isDPrimitive)
				switch(mts){case ONLY_VALUED_FIELDS: write(sb,"   if(",getSource(),"!=null){",newLine); openBracket++;break;
							case ONLY_NULL_FIELDS:	 write(sb,"   if(",getSource(),"==null){",newLine); openBracket++;break;}
		   else switch(mts){case ONLY_VALUED_FIELDS: write(sb,"   if(",getSource(),"!=null){",newLine); openBracket++;break;}
		
		sb.append(content);

		while(openBracket-->0) write(sb,"   }",newLine);

		return sb;
	}
	
	/**
	 * @return a StringBuilder calculated at runtime representing the explicit conversion.
	 */
	protected final StringBuilder applyExplicitConversion(){
		
		// construction of the conversion method path
		String conversionMethod = "";
		switch (conversionMembership) {
			case MAPPER:      conversionMethod = conversion.getName();						 break;
			case DESTINATION: conversionMethod = initialDGetPath +"."+ conversion.getName(); break;
			case SOURCE:      conversionMethod = initialSGetPath +"."+ conversion.getName(); break;
		}
		
		switch (conversion.getParameterNumber()) {
			case ZERO:return setDestination(conversionMethod+"()");
			case ONE: return setDestination(conversionMethod+"("+getSource()+")");
			case TWO: return setDestination(conversionMethod+"("+getDestination()+", "+getSource()+")");
		}
		
		return null;
	}

	/**
	 * This method returns the source content modified, analyzing conversion type, destination and source classes.
	 * 
	 * @param conversionType type of conversion
	 * @param dClass destination Class
	 * @param sClass source Class
	 * @param sourceContent content of source
	 * @return a string that containts literal conversion
	 */
	protected final Object applyImplicitConversion(final ConversionType conversionType,final Class<?> dClass,final Class<?> sClass,final Object sourceContent){
		
			if(!conversionType.isAbsent()){
				if(!conversionType.isUndefined())
					// add conversion
					return getConversion(conversionType,sourceContent);
				
			// if info is undefined, probably is an autoboxing operation
			}else{
				// is a boxing operation
				if(isBoxing(dClass, sClass))
					return write("new ",dClass.getName(),"(",sourceContent,")");
				
				// is an unboxing operation
				if(isUnBoxing(dClass, sClass))
					return write(sourceContent,".",dClass.getName(),"Value()");
			}
	
		return sourceContent;
	}
	
	/**
	 * 
	 * @return true if is a null setting, false otherwise
	 */
	private boolean isNullSetting(){
		return mts == ONLY_NULL_FIELDS;
	}
	
	/**
	 * Returns true if the source is to be converted, false otherwise
	 * @return true if the source is to be converted, false otherwise
	 */
	protected boolean theSourceIsToBeConverted(){
		return !info.getConversionType().isAbsent();
	}

	/**
	 * This method adds to the new StringBuilder the objects.
	 * @param objects objects to be added to a StringBuilder
	 * @return the StringBuilder created
	 */
	protected final StringBuilder write(final Object... objects){
		return write(new StringBuilder(), objects);
	}

	/**
	 * This method adds to the sb the objects.
	 * @param sb StringBuilder to be used
	 * @param objects objects to be added to sb
	 * @return the sb parameter
	 */
	protected final StringBuilder write(StringBuilder sb,final Object... objects){
		for (Object string : objects)sb.append(string);
		return sb;
	}
}
