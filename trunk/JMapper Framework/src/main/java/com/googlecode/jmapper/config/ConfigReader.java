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

package com.googlecode.jmapper.config;

import static com.googlecode.jmapper.config.Constants.DEFAULT_FIELD_VALUE;
import static com.googlecode.jmapper.config.Constants.THE_FIELD_IS_NOT_CONFIGURED;
import static com.googlecode.jmapper.util.ClassesManager.existField;
import static com.googlecode.jmapper.util.ClassesManager.getAllsuperclasses;
import static com.googlecode.jmapper.util.ClassesManager.isMappedInXML;
import static com.googlecode.jmapper.util.GeneralUtility.isPresent;
import static com.googlecode.jmapper.util.GeneralUtility.toList;

import java.lang.reflect.Field;
import java.util.List;

import com.googlecode.jmapper.annotations.JGlobalMap;
import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.util.XML;
import com.googlecode.jmapper.xml.Attribute;

/**
 * This Class reads the configuration of a specific field (analyzing Annotation AND/OR XML) and finds the target field name.
 * 
 * @author Alessandro Vurro
 *
 */
public final class ConfigReader {

	/** configured class*/
	private final Class<?> configuredClass;
	/** target class */
	private final Class<?> targetClass;
	/** xml object */
	private final XML xml;
	
	public ConfigReader(Class<?> aConfiguredClass, Class<?> aTargetClass, XML aXml) {
		configuredClass = aConfiguredClass;
		targetClass = aTargetClass;
		xml = aXml;
	}
	
	/**
	 * This method compare the name of the target field with the DEFAULT_FIELD_VALUE and returns the final value.
	 * 
	 * @param value value of the configuration
	 * @param name name of the configured field
	 * @return the name of target field
	 * 
	 * @see Constants#DEFAULT_FIELD_VALUE
	 */
	private String getValue(final String value, final String name) {
		
		if (value == null) return null;
		
		return value.equals(DEFAULT_FIELD_VALUE)?name:value;
	}
	
	/**
	 * This method finds the target field name from mapped parameters.
	 * @param attributes target list of field names
	 * @param classes list of target classes
	 * @param value name of target attribute
	 * @param fieldName name of mapped attribute
	 * @param configuredClass configured Class
	 * @param targetClass target Class
	 * @return the name of the target field if exist, null otherwise
	 */
	private String getValue(final List<String> attributes,final List<Class<?>> classes,String value,final String fieldName,final Class<?> configuredClass,final Class<?> targetClass){
		
		String mappedFieldName = fieldName;
		String targetFieldName = getValue(value,fieldName);
		String mappedClassName = configuredClass.getSimpleName();
		String targetClassName = targetClass.getSimpleName();

		/*	
		 * 		IF ATTRIBUTES AND CLASSES ARE EMPTY
		 */ 
		if( attributes.isEmpty() && classes.isEmpty() ){
			if(existField(targetClass,targetFieldName))
				return targetFieldName;

			Error.mapping(mappedFieldName, mappedClassName, targetFieldName, targetClassName);
		}
		
		/*
		 * 		IF ATTRIBUTES IS EMPTY AND CLASSES NOT
		 */
		if( attributes.isEmpty() && !classes.isEmpty() ){
			if(classes.contains(targetClass) && existField(targetClass,targetFieldName)) 
				return targetFieldName;
		
			Error.mapping(mappedFieldName, mappedClassName, targetFieldName, targetClassName);
		}
		
		/*
		 * 		IF  ATTRIBUTES AND CLASSES ARE VALUED AND THEY HAVE THE SAME LENGTH
		 */
		if( !attributes.isEmpty() && !classes.isEmpty() )
			if(attributes.size()==classes.size())
				if(classes.contains(targetClass)){
					// get the attribute from attributes, positioned at the same index of targetClass in classes
					value = attributes.get(classes.indexOf(targetClass));
					targetFieldName = getValue(value,mappedFieldName);
					
					if(existField(targetClass,targetFieldName))	
						return targetFieldName;
					
					Error.mapping(mappedFieldName, mappedClassName, targetFieldName, targetClassName);
				}else
					Error.mapping(mappedFieldName, mappedClassName, targetClassName);
			else
					Error.mapping(mappedFieldName, mappedClassName);
			
		/*
		 * 		IF ATTRIBUTES IS FULL AND CLASSES IS EMPTY
		 */
		if( !attributes.isEmpty() && classes.isEmpty() )
			for (String str : attributes)
				// if exist the target field in targetClass 
				if(existField(targetClass,getValue(str,mappedFieldName))) 
					//returns the corresponding name if it exists, otherwise nulls
					return getValue(str,mappedFieldName);
			
		Error.mapping(mappedFieldName, configuredClass,targetClass);
		
		return "this return is never used";
	}
	
	/**
	 * Returns the target field name of the configured field given in input, null otherwise.
	 * @param field configured field
	 * @return target field name, null otherwise 
	 */
	public String retrieveTargetFieldName(final Field field){
		
		// If configuredClass exists in XML configuration file
		for (Class<?> clazz : getAllsuperclasses(configuredClass)){
		  if(isMappedInXML(clazz, xml)){
			// loads all configured attributes 
			for(Attribute xmlField :xml.attributesLoad().get(clazz.getName())){
				
				// verifies that exists the attribute written in XML in the configured Class
				if(!existField(clazz,xmlField.getName()))	
					Error.attributeAbsent(clazz, xmlField);
				
				// if the field given in input isn't equal to xmlField continue with the cycle
				if(!xmlField.getName().equals(field.getName())) continue;
				
				// get the classes of the xmlField
				List<Class<?>> classes = toList(xmlField.getClasses());
				
				// if mapped field hasn't targetClass in classes parameter
				if(!classes.isEmpty() && !classes.contains(targetClass)) continue;
								
				// get the attributes names of xmlField
				List<String> attributes = toList(xmlField.getAttributes());
				
				// get value of xmlField
				String value = xmlField.getValue();
				
				// If the Value and Attributes parameters are empty, 
				// then the name of the target field is equal to the configuredField name, 
				// therefore we pass the default value we use to indicate equality
				if(value==null&&attributes.isEmpty())value=DEFAULT_FIELD_VALUE;
				
				// loaded all variables, calculates and returns the correspondence
				return getValue(attributes, classes, value, field.getName(), clazz, targetClass);
			}
		  }
		}
		
		// if class is configured in xml the annotated configuration is not searched
		// if it has a configured superclass it's ignored, the priority is valid only for principal class
		if(isMappedInXML(configuredClass, xml))return THE_FIELD_IS_NOT_CONFIGURED;
		
		JGlobalMap jglobalMap = configuredClass.getAnnotation(JGlobalMap.class);
		//if the field configuration is defined in the global map
		if(jglobalMap != null && !isPresent(jglobalMap.excluded(), field.getName())){
			
			//TODO ConfigReader --> testare il globalMap da solo, con excluded, excluded con campo configurato
			// globalMap con campi configurati
			
			// get the list of target classes
			List<Class<?>> classes = toList(jglobalMap.classes());
						
			// if mapped field hasn't targetClass in classes parameter
			if(!classes.isEmpty() && !classes.contains(targetClass)) return THE_FIELD_IS_NOT_CONFIGURED;
			
			// get the list of target attributes
			List<String> attributes = toList(jglobalMap.attributes());
						
		    // get value of configuredField
			String value = jglobalMap.value();
						
			// loaded all variables, calculates and returns the correspondence
			return getValue(attributes, classes, value, field.getName(), configuredClass, targetClass);			
		}
		    
		// if the XML configuration doesn't exist, checks the annotation existence
		JMap jmap = field.getAnnotation(JMap.class);
		if(jmap==null) return THE_FIELD_IS_NOT_CONFIGURED;
			
		// get the list of target classes
		List<Class<?>> classes = toList(jmap.classes());
			
		// if mapped field hasn't targetClass in classes parameter
		if(!classes.isEmpty() && !classes.contains(targetClass)) return THE_FIELD_IS_NOT_CONFIGURED;
			
		// get the list of target attributes
		List<String> attributes = toList(jmap.attributes());
			
		// get value of configuredField
		String value = jmap.value();
			
		// loaded all variables, calculates and returns the correspondence
		return getValue(attributes, classes, value, field.getName(), configuredClass, targetClass);
		
	}
}