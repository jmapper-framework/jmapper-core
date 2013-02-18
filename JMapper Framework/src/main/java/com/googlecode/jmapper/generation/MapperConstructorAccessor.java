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

import static com.googlecode.jmapper.util.GeneralUtility.isNotNull;
import static com.googlecode.jmapper.util.GeneralUtility.isNull;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import com.googlecode.jmapper.annotations.Annotation;
import com.googlecode.jmapper.config.Constants;
import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.generation.beans.Method;
import com.googlecode.jmapper.operations.complex.AComplexOperation;
import com.googlecode.jmapper.operations.simple.ASimpleOperation;
import com.googlecode.jmapper.xml.XML;

/**
 * This Abstract class is a container of data, the purpose is to separate the data from the logic.
 * 
 * @author Alessandro Vurro
 *
 */
public abstract class MapperConstructorAccessor {

	/** List of simple operations */
	protected List<ASimpleOperation> simpleOperations = new ArrayList<ASimpleOperation>();
	
	/** List of complex operations */
	protected List<AComplexOperation> complexOperations= new ArrayList<AComplexOperation>();
	
	/** List of methods to generate */
	protected Set<Method> methodsToGenerate;
	
	/** string used to set the destination instance into mapping */
	protected String stringOfSetDestination = Constants.DESTINATION_DEFAULT_NAME;
	
	/** string used to get the destination instance into mapping */
	protected String stringOfGetDestination = Constants.DESTINATION_DEFAULT_NAME;

	/** string used to get the source instance into mapping */
	protected String stringOfGetSource = Constants.SOURCE_DEFAULT_NAME;
	
	/** class that identifies the Destination Class */
	protected Class<?> destination;

	/** class that identifies the Source Class */
	protected Class<?> source;

	/** mapper name */
	protected String mapperName;
	
	/**
	 * variables used to increase mapping readability
	 */
	protected HashMap<String, String> initVars(){
		HashMap<String, String> vars = new HashMap<String, String>();
		vars.put("sClass"        ,source.getName());
		vars.put("dClass"        ,destination.getName());
		vars.put("source"        ,stringOfGetSource);
		vars.put("destination"   ,stringOfGetDestination);
		vars.put("setDestination",stringOfSetDestination);
		vars.put("nl"            ,newLine);
		return vars;
	}
	

	/**
	 * True if config doesn't exists, false otherwise.
	 * @param cc config to check
	 * @return true if config doesn't exists, false otherwise
	 */
	protected boolean notFound(ChooseConfig cc)   { return isNull(cc); }
	/**
	 * True if config doesn't exists, false otherwise.
	 * @param cc config to check
	 * @return true if config doesn't exists, false otherwise
	 */
	protected boolean notDeclared(ChooseConfig cc){ return isNull(cc); }
	/**
	 * True if config exists, false otherwise.
	 * @param cc config to check
	 * @return true if config exists, false otherwise
	 */
	protected boolean isDeclared(ChooseConfig cc) { return isNotNull(cc); }
	

    /**
     * This method finds the configuration location, returns null if don't finds it
     * @param cc configuration chosen
     * @param xml xml object
     * @return configuration found
     */
	protected ChooseConfig searchConfig(ChooseConfig cc, XML xml){
    	
    	ChooseConfig      config = searchXmlConfig(cc, xml);
    	if(isNull(config))config = searchAnnotatedConfig(cc);
    	return config;
    }
    
    /**
	 * This method finds the xml configuration, returns null if there are no.
	 * @param cc Configuration to check
	 * @param xml xml object
     * return ChooseConfig configuration found
	 */
	private ChooseConfig searchXmlConfig(ChooseConfig cc, XML xml){
		
		if(isNull(xml.getXmlPath())) return null;
		
    	if(isNull(cc)||cc == ChooseConfig.DESTINATION)
			if(xml.isMapped(destination))	return ChooseConfig.DESTINATION;
	
		if(isNull(cc)||cc == ChooseConfig.SOURCE)
			if(xml.isMapped(source))		return  ChooseConfig.SOURCE;
		
		return null;
    }
    
	/**
	 * This method finds the annotations, returns null if there are no.
	 * @param cc Configuration to check
	 * return ChooseConfig configuration found
	 */
	private ChooseConfig searchAnnotatedConfig(ChooseConfig cc) {
		
		if(isNull(cc)||cc == ChooseConfig.DESTINATION)
			if(Annotation.isMapped(destination))	return ChooseConfig.DESTINATION;
	
		if(isNull(cc)||cc == ChooseConfig.SOURCE)
			if(Annotation.isMapped(source))			return  ChooseConfig.SOURCE;
		
		return null;
	}
	
	/**@return the source class */
	public Class<?> getSource(){	 
		return source;
	}
	
	/**@return the destination class */
	public Class<?> getDestination(){
		return destination;
	}
	
	/**@return the mapper class name */
	public String   getMapperName() {
		return mapperName; 
	}
	
	/**@return the list of methods to generate*/
	public Set<com.googlecode.jmapper.generation.beans.Method> methodsToGenerate(){
		return methodsToGenerate;
	}	
}