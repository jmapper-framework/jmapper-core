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
package com.googlecode.jmapper.operations;

import com.googlecode.jmapper.conversions.explicit.ConversionMethod;
import com.googlecode.jmapper.enums.MappingType;
import com.googlecode.jmapper.enums.Membership;
import com.googlecode.jmapper.operations.beans.MappedField;
import com.googlecode.jmapper.operations.info.InfoOperation;

/**
 * This Abstract class is a container of data, the purpose is to separate the data from the logic.
 * 
 * @author Alessandro Vurro
 *
 */
public abstract class AGeneralOperationAccessor {
	
	/** first part of the getDestination path */
	protected String initialDGetPath;
	/** first part of the setDestination path */
	protected String initialDSetPath;
	/** first part of the getSource path*/
	protected String initialSGetPath;
	/** mapping type of source */
	protected MappingType mts;
	/** mapping type of destination */
	protected MappingType mtd;
	/** information about the operation that will be executed */
	protected InfoOperation info;
	/** destination field */
	protected MappedField destinationField;
	/** source field */
	protected MappedField sourceField;
	/** Name of the method  that defines the conversion */
	protected ConversionMethod conversion;
	/** membership of the conversion method */
	protected Membership conversionMembership = Membership.INEXISTENT;
			
	/**
	 * Setting of the conversion method
	 * @param conversion the method used to convert
	 * @return this instance
	 */
	public final AGeneralOperationAccessor setConversionMethod(ConversionMethod conversion){
		this.conversion = conversion;
		return this;
	}
	
	/**
	 * The conversion method belongs to this membership.
	 * @param membership membership of conversion method
	 * @return this instance
	 */
	public final AGeneralOperationAccessor setMemberShip(Membership membership){
		this.conversionMembership = membership;
		return this;
	}
		
	/**
	 * Setting of the first part of the getDestination path.
	 * @param initialDGetPath
	 * @return this instance
	 */
	public final AGeneralOperationAccessor initialDGetPath(String initialDGetPath) {
		this.initialDGetPath = initialDGetPath; 
		return this;
	}
	
	/**
	 * Setting of the first part of the setDestination path.
	 * @param initialDSetPath
	 * @return this instance
	 */
	public final AGeneralOperationAccessor initialDSetPath(String initialDSetPath) {
		this.initialDSetPath = initialDSetPath; 
		return this;
	}
	
	/**
	 * Setting of the first part of the initialSGetPath path.
	 * @param initialSGetPath
	 * @return this instance
	 */
	public final AGeneralOperationAccessor initialSGetPath(String initialSGetPath) {
		this.initialSGetPath = initialSGetPath;			   
		return this;
	}
	
	
	/**
	 * Setting of destination field.
	 * @param aDestinationField
	 * @return this instance
	 */
	public final AGeneralOperationAccessor setDestinationField(MappedField aDestinationField) {	
		destinationField = aDestinationField;
		return this;	
	}
	
	/**
	 * Setting of source field.
	 * @param aSourceField
	 * @return this instance
	 */
	public final AGeneralOperationAccessor setSourceField(MappedField aSourceField) {	
		sourceField = aSourceField;			 
		return this;	
	}
	
	/**
	 * @return the destination field type
	 */
	protected final Class<?> destinationType(){
		return destinationField.getType();
	}
	
	/**
	 * @return the source field type
	 */
	protected final Class<?> sourceType(){
		return sourceField.getType();
	}	
	
	/**
	 * Invokes toString() method on object.
	 * @param obj 
	 * @return obj.toString()
	 */
	protected String s(Object obj){
		return obj.toString();
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
	
	/** @return mapping type of source */
	public final MappingType getMts() { return mts; }
	
	/** @return mapping type of destination */
	public final MappingType getMtd() { return mtd; }
	
	/**
	 * Setting of destination mapping type. 
	 * @param mappingTypeD
	 * @return this instance
	 */
	public final AGeneralOperationAccessor setMtd(MappingType mappingTypeD) { mtd = mappingTypeD; return this;	}
	
	/**
	 * Setting of source mapping type.
	 * @param mappingTypeS
	 * @return this instance
	 */
	public final AGeneralOperationAccessor setMts(MappingType mappingTypeS) { mts = mappingTypeS; return this;	}
	
	/**
	 * Setting of operation informations.
	 * @param aInfo
	 * @return this instance
	 */
	public final AGeneralOperationAccessor setInfoOperation(InfoOperation aInfo) { info = aInfo;	return this;}
	
}
