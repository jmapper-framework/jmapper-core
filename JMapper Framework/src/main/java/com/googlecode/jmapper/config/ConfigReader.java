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

package com.googlecode.jmapper.config;

import static com.googlecode.jmapper.config.Constants.DEFAULT_FIELD_VALUE;
import static com.googlecode.jmapper.config.Constants.THE_FIELD_IS_NOT_CONFIGURED;
import static com.googlecode.jmapper.util.ClassesManager.fieldName;
import static com.googlecode.jmapper.util.ClassesManager.getAllsuperClasses;
import static com.googlecode.jmapper.util.GeneralUtility.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.googlecode.jmapper.annotations.Annotation;
import com.googlecode.jmapper.annotations.JGlobalMap;
import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.operations.beans.MappedField;
import com.googlecode.jmapper.xml.Attribute;
import com.googlecode.jmapper.xml.Global;
import com.googlecode.jmapper.xml.SimplyAttribute;
import com.googlecode.jmapper.xml.XML;

/**
 * This Class reads the configuration of a specific field (analyzing XML or annotation) and finds the target field name.
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
	 * @param value configuration parameter
	 * @param mappedFieldName name of the configured field
	 * @return the name of target field
	 * 
	 * @see Constants#DEFAULT_FIELD_VALUE
	 */
	private String getValue(final String value, final String mappedFieldName) {
		
		if (isNull(value)) return null;
		
		return value.equals(DEFAULT_FIELD_VALUE)?mappedFieldName:value;
	}
	
	/**
	 * This method finds the target field name from mapped parameters.
	 * @param attributes target list of field names
	 * @param classes list of target classes
	 * @param value name of target attribute
	 * @param mappedFieldName name of mapped attribute
	 * @param configuredClass configured Class
	 * @param targetClass target Class
	 * @return the name of the target field if exist, null otherwise
	 */
	private String getValue(final List<String> attributes,final List<Class<?>> classes,String value,final String mappedFieldName,final Class<?> configuredClass,final Class<?> targetClass){
		
		String regex = getValue(value,mappedFieldName);
		String mappedClassName = configuredClass.getSimpleName();
		String targetClassName = targetClass.getSimpleName();

		/* 		IF ATTRIBUTES AND CLASSES ARE EMPTY		 */ 
		if( attributes.isEmpty() && classes.isEmpty() ){
			String targetFieldName = fieldName(targetClass,regex);
			if(!isNull(targetFieldName))
				return targetFieldName;

			Error.mapping(mappedFieldName, mappedClassName, regex, targetClassName);
		}
		
		/* 		IF ATTRIBUTES IS EMPTY AND CLASSES NOT		 */
		if( attributes.isEmpty() && !classes.isEmpty() ){
			if(classes.contains(targetClass)){
				String targetFieldName = fieldName(targetClass,regex);
				if(!isNull(targetFieldName))
					return targetFieldName;
			}
		
			Error.mapping(mappedFieldName, mappedClassName, regex, targetClassName);
		}
		
		/* 		IF  ATTRIBUTES AND CLASSES ARE VALUED AND THEY HAVE THE SAME LENGTH		 */
		if( !attributes.isEmpty() && !classes.isEmpty() )
			if(attributes.size()==classes.size())
				if(classes.contains(targetClass)){
					// get the attribute from attributes, positioned at the same index of targetClass in classes
					value = attributes.get(classes.indexOf(targetClass));
					regex = getValue(value,mappedFieldName);
					
					String targetFieldName = fieldName(targetClass,regex);
					if(!isNull(targetFieldName))
						return targetFieldName;
					
					Error.mapping(mappedFieldName, mappedClassName, regex, targetClassName);
				}else
					Error.mapping(mappedFieldName, mappedClassName, targetClassName);
			else
					Error.mapping(mappedFieldName, mappedClassName);
			
		/* 		IF ATTRIBUTES IS FULL AND CLASSES IS EMPTY		 */
		if( !attributes.isEmpty() && classes.isEmpty() )
			for (String str : attributes){
				regex = getValue(str,mappedFieldName);
				// if exist the target field in targetClass 
				String targetFieldName = fieldName(targetClass,regex);
				if(!isNull(targetFieldName))
					//returns the corresponding name
					return targetFieldName;
			}
			
		Error.mapping(mappedFieldName, configuredClass,targetClass);
		
		return "this return is never used";
	}
	
	/**
	 * Returns the target field name of the configured field given in input, null otherwise.
	 * @param field configured field
	 * @return target field name, null otherwise 
	 */
	public String retrieveTargetFieldName(final Field field){
		
		// this list contains the configuredClass with super classes
		List<Class<?>> classes = getAllsuperClasses(configuredClass);
		
		// in case of override only the last global configuration must be analyzed
		Global global = null; 
		// If configuredClass exists in XML configuration file
		for (Class<?> clazz : classes){
		  
		  if(!xml.isMapped(clazz))continue;

		  // only if global configuration is null will be searched global configuration on super classes
		  if(isNull(global)){
			  
			  global = xml.loadGlobals().get(clazz.getName());
			  if( !isNull(global) 
				  && !isPresent(global.getExcluded(), field.getName())
				  && (	isEmpty(global.getAttributes()) 
					 || isPresent(global.getAttributes(), new SimplyAttribute(field.getName()))
					 )
				 ){
				  // get the classes of the xmlField
				  List<Class<?>> globalClasses = toList(global.getClasses());
				  
				  // if mapped field hasn't targetClass in classes parameter
				  if(!globalClasses.isEmpty() && !globalClasses.contains(targetClass)) continue;
				  
				  // get value of xmlField
				  String value = global.getValue();
				  
				  // If the Value is empty, 
				  // then the name of the target field is equal to the configuredField name, 
				  // therefore we pass the default value we use to indicate equality
				  if(isNull(value)) value = DEFAULT_FIELD_VALUE;
				  
				  // loaded all variables, calculates and returns the correspondence
				  return getValue(Collections.<String>emptyList(), globalClasses, value, field.getName(), clazz, targetClass);
			  }
		  }
			  
		  // loads all configured attributes 
		  for(Attribute attribute :xml.loadAttributes().get(clazz.getName())){
				
			// verifies that exists the attribute written in XML in the configured Class
			if(isNull(fieldName(clazz,attribute.getName())))	
				Error.attributeAbsent(clazz, attribute);
				
			// if the field given in input isn't equal to xmlField continue with the cycle
			if(!attribute.getName().equals(field.getName())) continue;
				
			// get the classes of the xmlField
			List<Class<?>> attributeClasses = toList(attribute.getClasses());
				
			// if mapped field hasn't targetClass in classes parameter
			if(!attributeClasses.isEmpty() && !attributeClasses.contains(targetClass)) continue;
								
			// get the attributes names of xmlField
			List<String> attributes = new ArrayList<String>();
			if(attribute.getAttributes() != null)
				for (SimplyAttribute targetAttribute : attribute.getAttributes()) 
					attributes.add(targetAttribute.getName());
				
			// get value of xmlField
			String value = null;
			if(!isNull(attribute.getValue()))
				value = attribute.getValue().getName();
			
			// If the Value and Attributes parameters are empty, 
			// then the name of the target field is equal to the configuredField name, 
			// therefore we pass the default value we use to indicate equality
			if(isNull(value) && attributes.isEmpty()) value = DEFAULT_FIELD_VALUE;
				
			// loaded all variables, calculates and returns the correspondence
			return getValue(attributes, attributeClasses, value, field.getName(), clazz, targetClass);
		  }
	    }
		
		// if class is configured in xml the annotated configuration is not searched
		// if it has a configured superclass it's ignored, the priority is valid only for principal class
		if(xml.isInheritedMapped(configuredClass))return THE_FIELD_IS_NOT_CONFIGURED;
		
		// if the XML configuration doesn't exist, checks the annotation existence
		for (Class<?> clazz : classes){
			
			JGlobalMap jglobalMap = clazz.getAnnotation(JGlobalMap.class);
			
			//if the field configuration is defined in the global map
			if(  !isNull(jglobalMap)){
				if(!isPresent(jglobalMap.excluded(), field.getName())
						&& (    isEmpty(jglobalMap.attributes()) 
								|| isPresent(jglobalMap.attributes(), field.getName())
								)){
					
					// get the list of target classes
					List<Class<?>> globalClasses = toList(jglobalMap.classes());
					
					// if mapped field hasn't targetClass in classes parameter
					if(!globalClasses.isEmpty() && !globalClasses.contains(targetClass)) return THE_FIELD_IS_NOT_CONFIGURED;
					
					// get value of configuredField
					String value = jglobalMap.value();
					
					// loaded all variables, calculates and returns the correspondence
					return getValue(Collections.<String>emptyList(), globalClasses, value, field.getName(), configuredClass, targetClass);			
				}
				// If global mapping is defined on this level, global mapping of super classes is ignored.
				// This is necessary to apply configuration override.
				break;
			}
		}
			
		JMap jmap = field.getAnnotation(JMap.class);
		if(isNull(jmap)) return THE_FIELD_IS_NOT_CONFIGURED;
			
		// get the list of target classes
		List<Class<?>> targetClasses = toList(jmap.classes());
			
		// if mapped field hasn't targetClass in classes parameter
		if(!targetClasses.isEmpty() && !targetClasses.contains(targetClass)) return THE_FIELD_IS_NOT_CONFIGURED;
			
		// get the list of target attributes
		List<String> attributes = toList(jmap.attributes());
		
		// get value of configuredField
		String value = jmap.value();
			
		// loaded all variables, calculates and returns the correspondence
		return getValue(attributes, targetClasses, value, field.getName(), configuredClass, targetClass);
		
	}

	/**
	 * Fill fields with they custom methods.
	 * 
	 * @param configuredField configured field
	 * @param targetField target field
	 */
	public void loadAccessors(MappedField configuredField, MappedField targetField) {
		loadAccessors(targetClass, configuredField, targetField);
	}
	
	/**
	 * Fill fields with they custom methods.
	 * 
	 * @param targetClass class of the target field
	 * @param configuredField configured field
	 * @param targetField target field
	 */
	private void loadAccessors(Class<?> targetClass, MappedField configuredField, MappedField targetField) {
		
		// First checks xml configuration
		xml.fillMappedField(configuredClass, configuredField)
		   .fillMappedField(targetClass, targetField)
		// fill target field with custom methods defined in the configured field
		   .fillOppositeField(configuredClass, configuredField, targetField);

		// If no present custom methods in XML, it checks annotations
		Annotation.fillMappedField(configuredClass,configuredField);
		Annotation.fillMappedField(targetClass,targetField);
		// fill target field with custom methods defined in the configured field
		Annotation.fillOppositeField(configuredClass,configuredField,targetField);
		
	}
}