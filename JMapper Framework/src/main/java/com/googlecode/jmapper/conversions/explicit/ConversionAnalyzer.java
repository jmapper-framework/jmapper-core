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
package com.googlecode.jmapper.conversions.explicit;

import static com.googlecode.jmapper.util.ClassesManager.getAllMethods;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.jmapper.annotations.JMapConversion;
import com.googlecode.jmapper.config.Error;
import com.googlecode.jmapper.config.JmapperLog;
import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.enums.ConfigurationType;
import com.googlecode.jmapper.enums.Membership;
import com.googlecode.jmapper.exceptions.ConversionParameterException;
import com.googlecode.jmapper.exceptions.DynamicConversionBodyException;
import com.googlecode.jmapper.exceptions.DynamicConversionMethodException;
import com.googlecode.jmapper.exceptions.DynamicConversionParameterException;
import com.googlecode.jmapper.util.ClassesManager;
import com.googlecode.jmapper.xml.XML;
import com.googlecode.jmapper.xml.XmlConverter;

/**
 * ConversionAnalyzer analyzes the configuration and returns, if exists, the conversion method found.
 * @author Alessandro Vurro
 */
public class ConversionAnalyzer {

	/** xml configuration */
	private XML xml;
	/** destination field name */
	private String destinationName;
	/** source field name */
	private String sourceName;
	/** destination class */
	private Class<?> destinationClass;
	/** source class */
	private Class<?> sourceClass;
	/** configuration chosen */
	private ChooseConfig config;
	/** bean that contains conversion method informations */
	private ConversionMethod method;
	/** conversion method membership */
	private Membership membership;
	/** configuration type */
	private ConfigurationType configurationType;
	
	/**
	 * Constructor that defines the xml configuration, the configuration chosen, the destination and source classes.
	 * 
	 * @param xml xml configuration
	 * @param config configuration chosen
	 * @param destinationClass destination class
	 * @param sourceClass source class
	 */
	public ConversionAnalyzer(XML xml,ChooseConfig config,Class<?> destinationClass,Class<?> sourceClass){
		this.xml = xml;
		this.config = config;
		this.destinationClass = destinationClass;
		this.sourceClass = sourceClass;
	}
	
	/**
	 * Checks for the existence of a conversion method.
	 * @param destination destination field
	 * @param source source field
	 * @return true if the conversion method exists, false otherwise 
	 * */
	public boolean fieldsToCheck(Field destination, Field source){
		destinationName = destination.getName();
		sourceName = source.getName();
		if(!xml.conversionsLoad().isEmpty()){
			configurationType = ConfigurationType.XML;
			if(config == ChooseConfig.DESTINATION){
				if(existsXml(destinationClass)) { membership = Membership.DESTINATION;  return true;}
				if(existsXml(sourceClass))      { membership = Membership.SOURCE;       return true;}}
			else{
				if(existsXml(sourceClass))      { membership = Membership.SOURCE;       return true;}
				if(existsXml(destinationClass)) { membership = Membership.DESTINATION;  return true;}}
		}
		configurationType = ConfigurationType.ANNOTATION;
		if(config == ChooseConfig.DESTINATION){
			if(existsAnnotation(destinationClass)) { membership = Membership.DESTINATION;  return true;}
			if(existsAnnotation(sourceClass))      { membership = Membership.SOURCE;       return true;}}
		else{
			if(existsAnnotation(sourceClass))      { membership = Membership.SOURCE;       return true;}
			if(existsAnnotation(destinationClass)) { membership = Membership.DESTINATION;  return true;}}
		return false;
	}
	
	/**@return the conversion method */
	public ConversionMethod getMethod(){     	     return method;	                      }
	
	/**@return the membership */
	public Membership getMembership(){		         return membership;	                  }
	
	/**@return the configuration type */
	public ConfigurationType getConfigurationType(){ return configurationType;            }
	
	/**
	 * Verifies the presence of the annotated conversion method in the input class, if found it's returned.
	 * @param clazz class to check
	 * @return true if annotated conversion exists, false otherwise
	 */
	private boolean existsAnnotation(Class<?> clazz){
		List<ConversionMethod> conversions = new ArrayList<ConversionMethod>();
		
		try{
			for(Method method:getAllMethods(clazz))
				if(method.getAnnotation(JMapConversion.class)!=null)
					try{   conversions.add(XmlConverter.toConversionMethod(method));
					}catch (ConversionParameterException e) {
						Error.wrongParameterNumber(method.getName(),clazz.getSimpleName());
					}catch (DynamicConversionParameterException e) {
						Error.parametersUsageNotAllowed(method.getName(), clazz.getSimpleName());
					}catch (DynamicConversionMethodException e) {
						Error.incorrectMethodDefinition(method.getName(), clazz.getSimpleName());
					}catch (DynamicConversionBodyException e) {
						Error.incorrectBodyDefinition(method.getName(), clazz.getSimpleName());
					}
			
		}catch (Exception e) {JmapperLog.ERROR(e);}
		return (method = verifyConversionExistence(conversions)) != null;
	}
	
	/**
	 * Verifies the presence of the xml conversion method in the input class, if found it's returned.
	 * @param clazz class to check
	 * @return true if an xml conversion exists, false otherwise
	 */
	private boolean existsXml(Class<?> clazz){
		List<ConversionMethod> conversions = ClassesManager.getConversionMethods(clazz, xml);
		if(conversions.isEmpty()) return false;
		return (method = verifyConversionExistence(conversions))!= null;
	}
	
	/**
	 * This method finds the conversion method between those loaded.
	 * @param conversions conversion methods list
	 * @return the conversion method if found, null otherwise
	 */
	private ConversionMethod verifyConversionExistence(List<ConversionMethod> conversions){
		for (ConversionMethod method : conversions) 
			if(isPresentIn(method.getFrom(),sourceName) && isPresentIn(method.getTo(),destinationName))
				return method;
				
		return null;
	}
	
	/**
	 * Returns true if the field name is contained in the values array, false otherwise.
	 * @param values array of values
	 * @param field field name to check
	 * @return true if the field name is contained in the values array, false otherwise
	 */
	private boolean isPresentIn(String[] values, String field){
		for (String value : values)if(value.equalsIgnoreCase(JMapConversion.ALL) || value.equals(field))return true;
		return false;
	}
}