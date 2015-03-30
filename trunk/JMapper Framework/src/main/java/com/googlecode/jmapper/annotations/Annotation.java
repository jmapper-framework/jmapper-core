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
package com.googlecode.jmapper.annotations;

import static com.googlecode.jmapper.util.ClassesManager.getAllMethods;
import static com.googlecode.jmapper.util.GeneralUtility.isNull;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.jmapper.config.Constants;
import com.googlecode.jmapper.config.Error;
import com.googlecode.jmapper.conversions.explicit.ConversionMethod;
import com.googlecode.jmapper.exceptions.ConversionParameterException;
import com.googlecode.jmapper.exceptions.DynamicConversionBodyException;
import com.googlecode.jmapper.exceptions.DynamicConversionMethodException;
import com.googlecode.jmapper.exceptions.DynamicConversionParameterException;
import com.googlecode.jmapper.operations.beans.MappedField;
import com.googlecode.jmapper.xml.Converter;

/**
 * This is an utility class, the purpose is to centralize annotations handling.
 * @author Alessandro Vurro
 *
 */
public class Annotation {

	/**
	 * Fill target field with custom methods if occur all these conditions:<br>
	 * <ul>
	 * <li>It's defined a JMapAccessor by configured field to target</li>
	 * <li>The target of the configuration hasn't the custom methods defined</li>
	 * </ul>
	 * @param configuredClass configured class
	 * @param configuredField configured field
	 * @param targetField target field
	 */
	public static void fillOppositeField(Class<?> configuredClass, MappedField configuredField, MappedField targetField) {
		
		JMapAccessor accessor = getClassAccessors(configuredClass, targetField.getValue().getName());
		
		if(accessor == null)
			accessor = getFieldAccessors(configuredField.getValue(), targetField.getValue().getName());
		
		if(accessor == null) return;
		
		if(    targetField.getMethod().equals(Constants.DEFAULT_ACCESSOR_VALUE) 
			&& !accessor.get().equals(Constants.DEFAULT_ACCESSOR_VALUE))
			targetField.getMethod(accessor.get());
		
		if(    targetField.setMethod().equals(Constants.DEFAULT_ACCESSOR_VALUE) 
			&& !accessor.set().equals(Constants.DEFAULT_ACCESSOR_VALUE))
			targetField.setMethod(accessor.set());
			
	}
	
	/**
	 * Fill the MappedField given as input with the custom accessors (if defined).
	 * @param mappedFields
	 */
	public static void fillMappedField(Class<?> configuredClass, MappedField mappedField){
		
		JMapAccessor accessor = getClassAccessors(configuredClass, mappedField.getValue().getName());
		
		if(accessor == null)
			accessor = getFieldAccessors(mappedField.getValue());
		
		if(accessor == null) return;
			
		if(    mappedField.getMethod().equals(Constants.DEFAULT_ACCESSOR_VALUE)
			&& !accessor.get().equals(Constants.DEFAULT_ACCESSOR_VALUE))
			mappedField.getMethod(accessor.get());
			
		if(     mappedField.setMethod().equals(Constants.DEFAULT_ACCESSOR_VALUE)
			&& !accessor.set().equals(Constants.DEFAULT_ACCESSOR_VALUE))
			mappedField.setMethod(accessor.set());
			
	}
	
	/**
	 * Returns JMapAccessor relative to this field, null if not present.
	 * @param field to check
	 * @return
	 */
	public static JMapAccessor getFieldAccessors(Field field){
		return getFieldAccessors(field, field.getName(),Constants.DEFAULT_FIELD_VALUE);
	}
	
	/**
	 * Checks if this field contains a definition of accessors for the name given as input.
	 * @param clazz class to check
	 * @param fieldName name to find
	 * @return
	 */
	public static JMapAccessor getClassAccessors(Class<?> clazz, String fieldName){
		return getAccessor(clazz.getAnnotations(),fieldName);
	}
	
	/**
	 * Checks if this field contains a definition of accessors for the name given as input.
	 * @param field field to check
	 * @param fieldName name to find
	 * @return
	 */
	private static JMapAccessor getFieldAccessors(Field field, String fieldName){
		return getAccessor(field.getAnnotations(),fieldName);
	}
	
	/**
	 * It finds between annotations if exists a JMapAccessor relative to the field with this name.
	 * @param annotations annotations to check
	 * @param fieldName field name
	 * @return
	 */
	private static JMapAccessor getAccessor(java.lang.annotation.Annotation[] annotations, String fieldName){
		for (java.lang.annotation.Annotation annotation : annotations) {
			if(annotation.annotationType() == JMapAccessors.class){
				JMapAccessors jmapAccessors = (JMapAccessors)annotation;
				for (JMapAccessor jmapAccessor : jmapAccessors.value()) 
					if(jmapAccessor.name().equals(fieldName)) return jmapAccessor;
				
			}
			if(annotation.annotationType() == JMapAccessor.class){
				JMapAccessor jmapAccessor = (JMapAccessor)annotation;
					if(jmapAccessor.name().equals(fieldName)) return jmapAccessor;
			}
		}
		return null;
	}
	/**
	 * Checks if this field contains a definition of accessors for the names given as input.
	 * @param field to check
	 * @param configNames name to find
	 * @return
	 */
	public static JMapAccessor getFieldAccessors(Field field, String... configNames){
		for (String configName : configNames) {
			JMapAccessor accessor = getFieldAccessors(field, configName);
			if(!isNull(accessor)) return accessor;
		}
		
		return null;
	}
	/**
	 * Returns a list of ConversionMethod that belong to the class given as input.
	 * @param clazz class to check
	 * @return a list of conversionMethod
	 */
	public static List<ConversionMethod> getConversionMethods(Class<?> clazz){
		List<ConversionMethod> conversions = new ArrayList<ConversionMethod>();
		
			for(Method method:getAnnotatedMethods(clazz))
				try{   conversions.add(Converter.toConversionMethod(method));
				}catch (ConversionParameterException e) {
					Error.wrongParameterNumber(method.getName(),clazz.getSimpleName());
				}catch (DynamicConversionParameterException e) {
					Error.parametersUsageNotAllowed(method.getName(), clazz.getSimpleName());
				}catch (DynamicConversionMethodException e) {
					Error.incorrectMethodDefinition(method.getName(), clazz.getSimpleName());
				}catch (DynamicConversionBodyException e) {
					Error.incorrectBodyDefinition(method.getName(), clazz.getSimpleName());
				}
		return conversions;
	}
	
	/**
	 * Returns a list with all annotated methods.
	 * @param clazz class to check
	 * @return a list with all annotated methods
	 */
	private static List<Method> getAnnotatedMethods(Class<?> clazz){
		List<Method> methods = new ArrayList<Method>();
		
		for(Method method:getAllMethods(clazz))
			if(!isNull(method.getAnnotation(JMapConversion.class)))
				methods.add(method);
		
		return methods;
	}
	
	/**
	 * Returns true if the class is configured in annotation, false otherwise.
	 * @param aClass a class
	 * @return true if the class is configured in annotation, false otherwise
	 */
	public static boolean isMapped(Class<?> clazz){
		if(clazz.getAnnotation(JGlobalMap.class)!=null) return true;
		for (Field it : clazz.getDeclaredFields()) 
			if(it.getAnnotation(JMap.class)!=null      || 
			   it.getAnnotation(JMultiMap.class)!=null) 
				return true;
		
		return false;
	}
	
}
