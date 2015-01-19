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
import static com.googlecode.jmapper.util.GeneralUtility.isNotNull;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.jmapper.config.Error;
import com.googlecode.jmapper.conversions.explicit.ConversionMethod;
import com.googlecode.jmapper.exceptions.ConversionParameterException;
import com.googlecode.jmapper.exceptions.DynamicConversionBodyException;
import com.googlecode.jmapper.exceptions.DynamicConversionMethodException;
import com.googlecode.jmapper.exceptions.DynamicConversionParameterException;
import com.googlecode.jmapper.xml.Converter;

/**
 * This is an utility class, the purpose is to centralize annotations handling.
 * @author Alessandro Vurro
 *
 */
public class Annotation {

	
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
			if(isNotNull(method.getAnnotation(JMapConversion.class)))
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
			   it.getAnnotation(JMultiMap.class)!=null ||
			   it.getAnnotation(JMultiMaps.class)!=null) 
				return true;
		
		return false;
	}
}
