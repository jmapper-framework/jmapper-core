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

import static com.googlecode.jmapper.api.enums.MappingType.ALL_FIELDS;
import static com.googlecode.jmapper.api.enums.MappingType.ONLY_NULL_FIELDS;
import static com.googlecode.jmapper.util.GeneralUtility.*;

import org.hamcrest.core.IsNull;

import com.googlecode.jmapper.operations.AGeneralOperation;

/**
 * This class represents an abstract complex operation that adds, 
 * to basic mapping, a generic flow. 
 * 
 * @author Alessandro Vurro
 *
 */
public abstract class AComplexOperation extends AGeneralOperation{

	/** destination class */
	private Class<?> destinationClass;
	
	private String sourceConverted;
	
	/** 
	 * @return Returns the name of the object shared between existingField and fieldToCreate methods.
	 * */
	protected Object getSourceConverted(){
		if(isNull(sourceConverted))
			sourceConverted = getSourceConvertedName();
		return sourceConverted;
	}
	
	/**
	 * @return the name of the source converted
	 */
	protected String getSourceConvertedName(){
		return "defaultName";
	};
	
	/**
	 * @return a StringBuilder containing the mapping for an existing field
	 */
	protected abstract StringBuilder existingField();
	
	/**
	 * @return a StringBuilder containing the mapping for a new instance of the field
	 */
	protected abstract StringBuilder fieldToCreate();
	
	/**
	 * @param content content shared
	 * @return a StringBuilder containing the shared code between fieldToCreate and existingField methods
	 * @see AComplexOperation#fieldToCreate
	 * @see AComplexOperation#existingField
	 */
	protected StringBuilder sharedCode(StringBuilder content){
		return content;
	}
	
	/**
	 * @return the name of treated source
	 */
	protected Object getSourceTreated(){
		return theSourceIsToBeConverted()?getSourceConverted():getSource();
	}
	
	/**
	 * @param isNewInstance true if new instance must be created, false otherwise
	 * @return a StringBuilder containing the mapping operation
	 */
	public final StringBuilder write(boolean isNewInstance) {
		return addMappingTypeControl(genericFlow(isNewInstance));
	}
	
	/**
	 * @param instanceName name of new instance
	 * @return a StringBuilder containing a new Instance of destinationClass with the name given in input
	 */
	protected final StringBuilder newInstance(Object instanceName){
		return newInstance(instanceName,"");
	}
	
	/**
	 * @param instanceName name of new instance
	 * @param constructorArg argument of the constructor
	 * @return a StringBuilder containing a new Instance of destinationClass with the name given in input
	 */
	protected final StringBuilder newInstance(Object instanceName, Object constructorArg){
		String Clazz = destinationClass.getName();
		return write(Clazz," ",instanceName," = new ",Clazz,"(",constructorArg,");");
	}
	
	/**
     * This method specifies the general flow of the complex mapping.
     *  
	 * @param newInstance true if you need to create a new instance, false otherwise
	 * @return a StringBuilder containing the mapping
	 */
	private final StringBuilder genericFlow(boolean newInstance){
		
		// if newInstance is true or mapping type of newField is ONLY_NULL_FIELDS
		// write the mapping for the new field
		if(newInstance || getMtd() == ONLY_NULL_FIELDS) 	
			return sourceControl(fieldToCreate()); 
		
		// if is enrichment case and mapping type of destination is ALL_FIELDS
		if(getMtd() == ALL_FIELDS && !destinationType().isPrimitive())
			return  write(	  "   if(",getDestination(),"!=null){",newLine
							  	   ,sourceControl(existingField()),
							  "   }else{"						  ,newLine
							  	   ,sourceControl(fieldToCreate()),
							  "   }"						  	  ,newLine);
		
		// other cases
		return sourceControl(existingField()); 
	}
	
	/**
	 * This method is used when the MappingType of Source is setting to ALL.
	 * @param mapping
	 * @return a StringBuilder that contains the mapping enriched with source controls
	 */
	private StringBuilder sourceControl(StringBuilder mapping){
		
		if(getMts() == ALL_FIELDS){
			StringBuilder write = write("   if(",getSource(),"!=null){",newLine,
										      sharedCode(mapping)	   ,newLine,
										"   }");
			
			if(!destinationType().isPrimitive() && !avoidSet)
					write.append(write("else{"					   ,newLine,
										 setDestination("null")    ,newLine,
										"   }"					   ,newLine));
			else    write.append(newLine);
			
			return write;
		} 
		else return write(sharedCode(mapping),newLine);
	}

	public final Class<?> getDestinationClass(){	return destinationClass;	}
	
	public final AComplexOperation setDestinationClass(Class<?> aDestinationClass){	
		destinationClass = aDestinationClass;
		return this;	
	}
}