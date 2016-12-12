/**
 * Copyright (C) 2012 - 2016 Alessandro Vurro.
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
package com.googlecode.jmapper.operations;

import static com.googlecode.jmapper.api.enums.MappingType.ONLY_NULL_FIELDS;
import static com.googlecode.jmapper.conversions.implicit.ConversionHandler.getConversion;
import static com.googlecode.jmapper.util.ClassesManager.isBoxing;
import static com.googlecode.jmapper.util.ClassesManager.isUnBoxing;
import static com.googlecode.jmapper.util.GeneralUtility.isCastCase;
import static com.googlecode.jmapper.util.GeneralUtility.isNull;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.beans.MappedField;
import com.googlecode.jmapper.operations.info.NestedMappedField;

/**
 * This abstract class represents an abstract operation that adds, 
 * to basic mapping, a mapping type control.
 * 
 * @author Alessandro Vurro
 *
 */
public abstract class AGeneralOperation extends AGeneralOperationAccessor{
	
	/** @return the nested mapping */
	protected StringBuilder getNestedMapping() {
		
		if(isNull(this.nestedMappingInfo)) 
			return null;
		
		return this.nestedMappingInfo.isSource() 
				? calculateSourceNestedMapping() 
				: calculateDestinationNestedMapping();
	}
	
	private StringBuilder calculateSourceNestedMapping(){
		StringBuilder mapping = new StringBuilder();
		
		// this represent the intermediate variables
		String actualField = this.initialSGetPath;
		int index = 0;
		String nestedField = "nestedField"+ ++index;

		//TODO creo un try catch intorno all'operazione
		// se va in errore vedo se era definito un safeOperator
		// se è definito allora vado a vedere che tipo di mapping type
		// del source ho e decido se passare null a destination
		// oppure lasciare il valore originario
		
		for (NestedMappedField nestedMappedField : this.nestedMappingInfo.getNestedFields()) {
			
			tryCatch(mapping, nestedField, actualField, nestedMappedField);

			// in case of last no mapping necessary, but wrote only for checks null field
			if(this.nestedMappingInfo.isLastField(nestedMappedField)) 
				break;
			
			actualField = nestedField;
			nestedField = "nestedField" + ++index;
		}
		
//TODO utilizzare questo spezzone per il try catch esterno sopra descritto
//		write(mapping, "   }catch(",NestedBeanNullException.class.getName(), " e){",
//			newLine,   "      if(!e.isSafeNavigationOperator()){",
//			newLine,   "          throw e;",
//			newLine,   "      }",
//			newLine,   "   }",newLine);
		
		this.initialSGetPath = actualField;
		return mapping;
	}
	
	private void tryCatch(StringBuilder mapping, String nestedField, String actualField, NestedMappedField nestedMappedField){
		MappedField mappedField = nestedMappedField.getField();
		boolean safeNavigationOperatorDefined = nestedMappedField.isSafeNavigationOperatorDefined();
		Class<?> nestedClass = mappedField.getValue().getType();
		
		String getField = mappedField.getMethod();
		String destinationClass = this.nestedMappingInfo.getConfiguredClass().getSimpleName();
		String destinationField = this.nestedMappingInfo.getConfiguredField().getName();
		String sourceClass = this.nestedMappingInfo.getFirstNestedClass().getSimpleName();
		String sourceField = this.nestedMappingInfo.getFirstNestedField().getName();
		
	   write(mapping, "   ",nestedClass.getName()," ",nestedField," = null;", 
			newLine,  "   try{", 
			newLine,  "      ",nestedField," = ",actualField,".",getField,"();",
            newLine,  "   }catch(",NullPointerException.class.getName()," e){",
            newLine,  "      com.googlecode.jmapper.config.Error.nestedBeanNull(\"",mappedField.getName(),"\", \"",destinationClass,"\", \"",destinationField,"\", \"",sourceClass,"\", \"",sourceField,"\", ",safeNavigationOperatorDefined,");",
            newLine,  "   }", newLine);
	}
	
	private StringBuilder calculateDestinationNestedMapping(){
		StringBuilder mapping = new StringBuilder();
		
		// this represent the intermediate variables
		String actualField = this.initialDGetPath;
		int index = 0;
		String nestedField = "nestedField"+ ++index;
		for (NestedMappedField nestedMappedField : this.nestedMappingInfo.getNestedFields()) {
			
			// in case of last no mapping necessary
			if(this.nestedMappingInfo.isLastField(nestedMappedField)) 
				break;
			
			MappedField field = nestedMappedField.getField();
			Class<?> nestedClass = field.getValue().getType();
			nestedMapping(mapping, nestedClass, nestedField, actualField, field);
			
			actualField = nestedField;
			nestedField = "nestedField" + ++index;
		}
		this.initialDSetPath = actualField;
		this.initialDGetPath = actualField;
		
		return mapping;
	}
	
	private void nestedMapping(StringBuilder mapping, Class<?> nestedClass, String nestedField, String actualField, MappedField mappedField){
		String getField = mappedField.getMethod();
		String setField = mappedField.setMethod();
		
	   write(mapping, "   ",nestedClass.getName()," ",nestedField," = ",actualField,".",getField,"();", 
			newLine,  "   if(", nestedField," == null){", 
			newLine,  "      ",nestedField," = new ",nestedClass.getName(),"();",
			newLine,  "      ",actualField,".",setField,"(",nestedField,");", 
			newLine,  "   }", newLine);
	}
	
	/**
	 * @return a StringBuilder calculated at runtime representing the complete set destination path.
	 * <br>for example: destination.setField;
	 */
	protected final StringBuilder setDestination() {
		return write(initialDSetPath,".",destinationField.setMethod());
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
		return write(initialDGetPath,".",destinationField.getMethod(),"()"); 
	}

	/**
	 * @return a StringBuilder calculated at runtime representing the complete get source path.
	 * <br>for example: source.getField()
	 */
	protected final StringBuilder getSource() {
		return write(initialSGetPath,".",sourceField.getMethod(),"()");
	}

	/**
	 * this method adds a mapping type control to the basic mapping.
	 * @param content mapping that will be wrapped with mappingType control
	 * @return a String that contains a single operation
	 */
	@SuppressWarnings("incomplete-switch")
	protected final StringBuilder addMappingTypeControl(StringBuilder content){
		
		StringBuilder sb = new StringBuilder();
		int openBracket = 0;
		
		boolean isDPrimitive = destinationType().isPrimitive();
		boolean isSPrimitive = sourceType().isPrimitive();
		
		
		if(!isDPrimitive && isNullSetting())
			content = avoidSet ? write(newLine)
							   : write(setDestination("null"),newLine);
		
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
		    default: break;
		}
		
		switch (conversion.getParameterNumber()) {
			case ZERO:return setDestination(conversionMethod+"()");
			case ONE: return setDestination(conversionMethod+"("+getSource()+")");
			case TWO: 
				String mapping = conversionMethod+"("+getDestination()+", "+getSource()+")";
				return conversion.isAvoidSet()
						 ? new StringBuilder("   "+mapping+";")
				         : setDestination(mapping);
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

				// add conversion
				if(!conversionType.isUndefined())
					return getConversion(conversionType,sourceContent);
				
				// in case of explicit cast, for example: Integer i = (Integer) object;
				if(isCastCase(dClass, sClass))
					return write("(",dClass.getName(),")",sourceContent);
				
				
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
	
}