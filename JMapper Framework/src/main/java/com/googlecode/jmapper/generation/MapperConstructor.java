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

package com.googlecode.jmapper.generation;

import static com.googlecode.jmapper.enums.MappingType.ALL_FIELDS;
import static com.googlecode.jmapper.enums.MappingType.ONLY_NULL_FIELDS;
import static com.googlecode.jmapper.enums.MappingType.ONLY_VALUED_FIELDS;
import static com.googlecode.jmapper.enums.NullPointerControl.ALL;
import static com.googlecode.jmapper.enums.NullPointerControl.DESTINATION;
import static com.googlecode.jmapper.enums.NullPointerControl.NOT_ANY;
import static com.googlecode.jmapper.enums.NullPointerControl.SOURCE;
import static com.googlecode.jmapper.util.ClassesManager.isMappedInAnnotation;
import static com.googlecode.jmapper.util.ClassesManager.isMappedInXML;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.googlecode.jmapper.IMapper;
import com.googlecode.jmapper.config.Constants;
import com.googlecode.jmapper.config.Error;
import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.enums.MappingType;
import com.googlecode.jmapper.enums.NullPointerControl;
import com.googlecode.jmapper.generation.beans.Method;
import com.googlecode.jmapper.operations.AGeneralOperation;
import com.googlecode.jmapper.operations.OperationHandler;
import com.googlecode.jmapper.operations.complex.AComplexOperation;
import com.googlecode.jmapper.operations.simple.ASimpleOperation;
import com.googlecode.jmapper.xml.XML;
/**
 * MapperConstructor builds all combinations of possible mappings between classes Source and Destination.<br>
 * 
 * @author Alessandro Vurro
 *
 */
public class MapperConstructor {

	/** List of simple operations */
	private List<ASimpleOperation> simpleOperations = new ArrayList<ASimpleOperation>();
	
	/** List of complex operations */
	private List<AComplexOperation> complexOperations= new ArrayList<AComplexOperation>();
	
	/** List of methods to generate */
	private Set<Method> methodsToGenerate;
	
	/** string used to set the destination instance into mapping */
	private String stringOfSetDestination = Constants.DESTINATION_DEFAULT_NAME;;
	
	/** string used to get the destination instance into mapping */
	private String stringOfGetDestination = Constants.DESTINATION_DEFAULT_NAME;;

	/** string used to get the source instance into mapping */
	private String stringOfGetSource = Constants.SOURCE_DEFAULT_NAME;;
	
	/** class that identifies the Destination Class */
	private Class<?> destination;

	/** class that identifies the Source Class */
	private Class<?> source;

	/** mapper name */
	private String mapperName;
	/**
	 * This method adds the Null Pointer Control to mapping created by the mapping method.
	 * wrappedMapping is used to wrap the mapping returned by mapping method. 
	 * 
	 * @param makeDest true if destination is a new instance, false otherwise
	 * @param npc a NullPointerControl chosen
	 * @param mtd Mapping Type of destination
	 * @param mts Mapping Type of source
	 * @return a String that contains the mapping
	 * @see MapperConstructor#write
	 * @see NullPointerControl
	 * @see MappingType
	 */
	private String wrapMapping(boolean makeDest,NullPointerControl npc,MappingType mtd,MappingType mts){	
		String sClass = source.getName();
		String dClass = destination.getName();
		
		String str = (makeDest?"   "+sClass+" "+stringOfGetSource     +" = ("+sClass+") $1;"
				              :"   "+dClass+" "+stringOfGetDestination+" = ("+dClass+") $1;"+newLine+
				               "   "+sClass+" "+stringOfGetSource     +" = ("+sClass+") $2;")+newLine;

		switch(npc){
		  case SOURCE: 	    str +="if("+stringOfGetSource+"!=null){"     +newLine; break;
		  case DESTINATION: str +="if("+stringOfGetDestination+"!=null){"+newLine; break;
		  case ALL:	        str +="if("+stringOfGetSource+"!=null && "+stringOfGetDestination+"!=null){"+newLine;break;
		  default: break;
		}

		str +=     mapping(makeDest,mtd,mts)          + newLine
			+  "   return "+stringOfSetDestination+";"+ newLine;

		return (npc != NOT_ANY) ? str +=  "}"             + newLine
				                      +   " return null;" + newLine
				                : str;
	}

	/**
	 * This method writes the mapping based on the value of the three parameters taken in input.
	 * 
	 * @param makeDest true if destination is a new instance, false otherwise
	 * @param mtd mapping type of destination
	 * @param mts mapping type of source
	 * @return a String that contains the mapping
	 */
	public StringBuilder mapping(boolean makeDest,MappingType mtd,MappingType mts){
		
		StringBuilder sb = new StringBuilder();
		
		if(isNullSetting(makeDest, mtd, mts, sb)) return sb;
		
		if(makeDest){
			String Destination = destination.getName();
			sb.append("   "+Destination+" "+stringOfSetDestination+" = new "+Destination+"();"+newLine);
		}
		
		for (ASimpleOperation simpleOperation : simpleOperations) 
			sb.append(setOperation(simpleOperation,mtd,mts).write());
		
		for (AComplexOperation complexOperation : complexOperations) 
			sb.append(setOperation(complexOperation,mtd,mts).write(makeDest));
		
		return sb;
	}
	
	/**
	 * Setting common to all operations.
	 * 
	 * @param operation operation to configure
	 * @param mtd mapping type of destination
	 * @param mts mapping type of source
	 * @return operation configured
	 */
	private <T extends AGeneralOperation>T setOperation(T operation,MappingType mtd,MappingType mts){
		operation.setMtd(mtd).setMts(mts)
		         .initialDSetPath(stringOfSetDestination)
			     .initialDGetPath(stringOfGetDestination)
			     .initialSGetPath(stringOfGetSource);
		
		return operation;
	}
	
	/**
	 * Returns a Map where the keys are the mappings names and relative values are the mappings.
	 * @return a Map with all mapping combinations
	 */
	public java.util.Map<String,String> getMappings(){
		
		HashMap<String, String> mappings      = new HashMap<String, String> ();
		HashMap<String, Boolean> destInstance = new HashMap<String, Boolean>();
		
		String s = "V";
		
		destInstance.put("null", true  );
		destInstance.put("v"   , false );
		
		HashMap<String, NullPointerControl> nullPointer = new HashMap<String, NullPointerControl>();
		
		nullPointer.put("Not", NOT_ANY     );
		nullPointer.put("All", ALL         );
		nullPointer.put("Des", DESTINATION );
		nullPointer.put("Sou", SOURCE      );
		
		HashMap<String, MappingType> mapping = new HashMap<String, MappingType>();		
		
		mapping.put("All"   , ALL_FIELDS         );
		mapping.put("Valued", ONLY_VALUED_FIELDS );
		mapping.put("Null"  , ONLY_NULL_FIELDS   );
		
		java.lang.reflect.Method[] methods = IMapper.class.getDeclaredMethods();
		
		for (Entry<String, Boolean> d : destInstance.entrySet()) 
			for (Entry<String, NullPointerControl> npc : nullPointer.entrySet()) 
				for (Entry<String, MappingType> mtd : mapping.entrySet()) 
					for (Entry<String, MappingType> mts : mapping.entrySet()) {
						String methodName = d.getKey()+s+npc.getKey()+mtd.getKey()+mts.getKey();
						for (java.lang.reflect.Method method : methods) 
							if(method.getName().equals(methodName))
								mappings.put(methodName, wrapMapping(d.getValue(),npc.getValue(),mtd.getValue(),mts.getValue()));}
		
		mappings.put("get", "return null;"+newLine);
		return mappings;
	}

	/**@return the list of methods to generate*/
	public Set<com.googlecode.jmapper.generation.beans.Method> methodsToGenerate(){
		return methodsToGenerate;
	}
	
	/**
	 * if it is a null setting returns the null mapping
	 * @param makeDest true if destination is a new instance
	 * @param mtd mapping type of destination
	 * @param mts mapping type of source
	 * @param result StringBuilder used for mapping
	 * @return true if operation is a null setting, false otherwise
	 */
	private boolean isNullSetting(boolean makeDest,MappingType mtd,MappingType mts,StringBuilder result){
		if( 	makeDest  
			&& (mtd == ALL_FIELDS||mtd == ONLY_VALUED_FIELDS) 
			&&	mts == ONLY_NULL_FIELDS){
			result.append("   "+stringOfSetDestination+"(null);"+newLine);
			return true;
		}
		return false;
	}
   /**
	 * MapperConstructor takes in input all informations that need for to write the mappings.
	 *
	 * @param aDestination Type of Destination
	 * @param aSource Type of Source
	 * @param aStringOfSetDestination set destination String
	 * @param aStringOfGetDestination get destination String
	 * @param aStringOfGetSource get source String
	 * @param cc config choosen
	 */
	public MapperConstructor(Class<?> aDestination, Class<?> aSource,String aStringOfSetDestination,String aStringOfGetDestination,String aStringOfGetSource,ChooseConfig cc, XML xml, Set<Method>	methodsToGenerate) {
    		this(aDestination,aSource,cc,xml,methodsToGenerate);
			stringOfSetDestination = aStringOfSetDestination;
			stringOfGetDestination = aStringOfGetDestination;
			stringOfGetSource = aStringOfGetSource;
	}

    /**
	 * MapperConstructor takes in input all informations that need to write the mappings.
	 * 
	 * @param aDestination Type of Destination
	 * @param aSource Type of Source
	 * @param configChoice configuration chosen from user
	 * @param xml xml object
	 */
    public MapperConstructor(Class<?> aDestination, Class<?> aSource,ChooseConfig configChoice, XML xml,Set<Method> methodsToGenerate){
    	
    	// definition of the instance variables
    	destination = aDestination;
    	source = aSource;
    	
    	// configuration chosen, null if not declared
    	ChooseConfig configObtained = searchConfig(configChoice, xml);
    	
    	// if the configuration was not found
    	if(notFound(configObtained)){
    		
    		Class<?> clazz = configChoice == ChooseConfig.SOURCE?source:destination;
    		
    		// and the developer doesn't declared the configuration
    		if(notDeclared(configChoice))
	    		
    			// not found any configuration in the xml file declared 
	    		if(xml.exists()) Error.configNotPresent(destination, source ,xml);
	    	    // xml configuration file doesn't exist
	    		else   			 Error.classesNotConfigured(destination, source);
    			
	    	// or the chosen configuration was not found
	    	if(isDeclared(configChoice))
	    		
	    		// not found the clazz configuration in the xml file declared
	    		if(xml.exists()) Error.configNotPresent(clazz, xml);
	    		// not found the clazz configuration
	    		else             Error.classNotConfigured(clazz);
    	}
    	
    	// creation of the operations handler
		OperationHandler operationHandler = new OperationHandler(destination, source, configObtained, xml);
		
		// Loading structures (simpleOperations and complexOperations) that will be used for writing mapping
		operationHandler.loadStructures(methodsToGenerate);
		
		simpleOperations = operationHandler.getSimpleOperations();
		complexOperations = operationHandler.getComplexOperations();
	}

	
	/**
	 * True if config doesn't exists, false otherwise.
	 * @param cc config to check
	 * @return true if config doesn't exists, false otherwise
	 */
	private boolean notFound(ChooseConfig cc)   { return cc == null; }
	/**
	 * True if config doesn't exists, false otherwise.
	 * @param cc config to check
	 * @return true if config doesn't exists, false otherwise
	 */
	private boolean notDeclared(ChooseConfig cc){ return cc == null; }
	/**
	 * True if config exists, false otherwise.
	 * @param cc config to check
	 * @return true if config exists, false otherwise
	 */
	private boolean isDeclared(ChooseConfig cc) { return cc != null; }
	

    /**
     * This method finds the configuration location, returns null if don't finds it
     * @param cc configuration chosen
     * @param xml xml object
     * @return configuration found
     */
    private ChooseConfig searchConfig(ChooseConfig cc, XML xml){
    	
    	ChooseConfig      config = searchXmlConfig(cc, xml);
    	if(config == null)config = searchAnnotatedConfig(cc);
    	return config;
    }
    
    /**
	 * This method finds the xml configuration, returns null if there are no.
	 * @param cc Configuration to check
	 * @param xml xml object
     * return ChooseConfig configuration found
	 */
	private ChooseConfig searchXmlConfig(ChooseConfig cc, XML xml){
		if(xml.getXmlPath() == null) return null;
		
    	if(cc == null||cc == ChooseConfig.DESTINATION)
			if(isMappedInXML(this.destination,xml))	return ChooseConfig.DESTINATION;
	
		if(cc == null||cc == ChooseConfig.SOURCE)
			if(isMappedInXML(this.source,xml))		return  ChooseConfig.SOURCE;
		
		return null;
    }
    
	/**
	 * This method finds the annotations, returns null if there are no.
	 * @param cc Configuration to check
	 * return ChooseConfig configuration found
	 */
	private ChooseConfig searchAnnotatedConfig(ChooseConfig cc) {
		
		if(cc == null||cc == ChooseConfig.DESTINATION)
			if(isMappedInAnnotation(this.destination))	return ChooseConfig.DESTINATION;
	
		if(cc == null||cc == ChooseConfig.SOURCE)
			if(isMappedInAnnotation(this.source))		return  ChooseConfig.SOURCE;
		
		return null;
	}
	
	/**@return the source class */
	public Class<?> getSource(){	 return source;}
	
	/**@return the destination class */
	public Class<?> getDestination(){return destination;}
	
	/**@return the mapper class name */
	public String   getMapperName() {return mapperName; }
	
	/**@param name the mapper class name */
	public MapperConstructor setMapperName(String name){mapperName = name;return this;}
}