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
package com.googlecode.jmapper.conversions.explicit;

import static com.googlecode.jmapper.annotations.JMapConversion.Type.STATIC;
import static com.googlecode.jmapper.conversions.explicit.ConversionPlaceholder.*;
import static com.googlecode.jmapper.enums.ConfigurationType.ANNOTATION;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;

import static com.googlecode.jmapper.util.GeneralUtility.isNull;

import com.googlecode.jmapper.enums.ConfigurationType;
import com.googlecode.jmapper.enums.Membership;
import com.googlecode.jmapper.generation.beans.Method;
import com.googlecode.jmapper.operations.beans.MappedField;
import com.googlecode.jmapper.xml.XML;

/**
 * Conversion Handler transforms the defined conversion method in the final method, 
 * which will become a part of the mapping.
 * @author Alessandro Vurro
 *
 */
public class ConversionHandler {

	/** the conversion method defined */
	private ConversionMethod methodDefined;
	/** the conversion method membership */
	private Membership membership;
	/** the location of the conversion method defined */
	private ConfigurationType configurationType;
	/** source field */
	private Field sourceField;
	/** destination field */
	private Field destinationField;
	/** the conversion method to generate */
	private Method methodToGenerate;
	/** the placeholders */
	private HashMap<String, String> placeholders;
	/** the xml object */
	private XML xml;
	/** source class*/
	private Class<?> sourceClass;
	/** destination class*/
	private Class<?> destinationClass;
	/** configured class */
	private Class<?> configClass;
			
	/**@return true if the method is to be created, false otherwise */
	public boolean toBeCreated(){
		return !(configurationType == ANNOTATION && methodDefined.getType() == STATIC);
	}
	
	/**
	 * Loads the method to generate.
	 * @return the method to generate
	 */
	public Method loadMethod(){
		methodToGenerate = new Method();
		
		// the method will be created in the mapper
		membership = Membership.MAPPER;
		// class to which it belongs
		methodToGenerate.setClazz(configClass);
		
		Class<?> destinationClass = destinationField.getType();
		Class<?> sourceClass = sourceField.getType();
		
		// Return Type definition
		methodToGenerate.setReturnType(destinationClass);
		
		// Parameters type definition
		switch (methodDefined.getParameterNumber()) {
			case ZERO:methodToGenerate.setParameters(new Class<?>[]{});				    			break;
			case ONE: methodToGenerate.setParameters(new Class<?>[]{sourceClass});				    break;
			case TWO: methodToGenerate.setParameters(new Class<?>[]{destinationClass,sourceClass}); break;
		}
		
		// setting of conversion method name
		methodToGenerate.setOriginalName(methodDefined.getName());
		
		// Method name definition
		switch (methodDefined.getType()) {
			case STATIC:  methodToGenerate.setName(definedName());break;
			case DYNAMIC: methodToGenerate.setName(dynamicName());break;
		}
		
		// adds the generated name in the defined method
		methodDefined.setName(methodToGenerate.getName());
		
		int count = 1;
		String body = "{try{";
		// Parameters type definition
		switch (methodDefined.getParameterNumber()) {
			case TWO: String dType = placeholders.get(destinationTypePattern);
				  	  String dName = placeholders.get(destinationPattern);
				  	  body += dType+" "+dName+" = ("+dType+") $"+count+++";"+newLine;
			case ONE: String sType = placeholders.get(sourceTypePattern);
		  	  		  String sName = placeholders.get(sourcePattern);
		  	  		  body += sType+" "+sName+" = ("+sType+") $"+count+";"+newLine;
			default: break;
		}
		
		// Method body definition
		body += methodDefined.getContent();
		for (Entry<String, String> pair : placeholders.entrySet())
			// only if the placeholder is used
			if(!isNull(pair.getValue()))
				body = body.replaceAll(pair.getKey(),  Matcher.quoteReplacement(pair.getValue()));
		
		return methodToGenerate.setBody(body+"}catch(java.lang.Exception e){"+error()+"}return "+defaultPrimitiveValue(destinationClass)+";}");
	}
	

	/**
	 * Returns the default values of primitive types in the form of strings.
	 * @param clazz primitive type
	 * @return a string that contains default value
	 */
	private String defaultPrimitiveValue(Class<?> clazz){
		
		return clazz == byte.class  || 
			   clazz == short.class || 
			   clazz == int.class? "0":
			   clazz == long.class? "0L":
			   clazz == float.class? "0.0f":
			   clazz == double.class? "0.0d":
			   clazz == char.class ? "'\u0000'":
			   clazz == boolean.class ? "false":
			   "null";
					   
	}
	/**
	 * This method surrounds the explicit conversion defined with a try-catch, to handle null pointers.
	 * @return the body wrapped
	 */
	private String error(){
		Map<String, List<ConversionMethod>> conversions = xml.conversionsLoad();
		return "com.googlecode.jmapper.config.Error.illegalCode(e,\""+ methodToGenerate.getOriginalName()+"\",\""+configClass.getSimpleName()+"\""
			+ (!conversions.isEmpty() && conversions.get(configClass.getName())!=null?", \"" + xml.getXmlPath()+"\"":"")+");";
	}
	
	/**@return the defined name, if null a random string will be returned */
	private String definedName(){
		return prefix()+methodDefined.getName();
	}
	
	/**
	 * @return the dynamic method name, that follows the convention 
	 * FROM source field's name TO destination field's name 
	 */
	private String dynamicName(){
		return prefix()+"FROM"+sourceField.getName()+"TO"+destinationField.getName();
	}
	
	/**
	 * Adds a prefix to distinguish between methods with the same name but belonging to different classes.
	 * @return a prefix
	 */
	private String prefix(){
		return configClass.getSimpleName()+"$";
	}
	
	/**
	 * Default constructor.
	 * @param xml xml to check
	 * @param destinationClass destination class
	 * @param sourceClass source class
	 */
	public ConversionHandler(XML xml, Class<?> destinationClass, Class<?> sourceClass) {
		super();
		this.xml = xml;
		this.destinationClass = destinationClass;
		this.sourceClass = sourceClass;
		placeholders = new HashMap<String, String>();
		placeholders.put(sourcePattern, sourceValue);
		placeholders.put(destinationPattern, destinationValue);
	}
	
	/**
	 * Loads analyzer configurations 
	 * @param analyzer conversion analyzer
	 * @return this instance of ConversionHandler
	 */
	public ConversionHandler load(ConversionAnalyzer analyzer){
		this.methodDefined = analyzer.getMethod();
		this.membership = analyzer.getMembership();
		this.configClass = membership == Membership.DESTINATION?destinationClass:sourceClass;
		this.configurationType = analyzer.getConfigurationType();
		return this;
	}
	
	/**
	 * Source field definition.
	 * @param sourceMappedField source field
	 * @return this instance of ConversionHandler
	 */
	public ConversionHandler from(MappedField sourceMappedField){
		this.sourceField = sourceMappedField.getValue();
		placeholders.put(sourceTypePattern, sourceField.getType().getName());
		placeholders.put(sourceNamePattern, sourceField.getName());
		placeholders.put(sourceGetPattern, sourceMappedField.getMethod());
		placeholders.put(sourceSetPattern, sourceMappedField.setMethod());
		return this;
	}
	
	/**
	 * Destination field definition.
	 * @param destinationMappedField destination field
	 * @return this instance of ConversionHandler
	 */
	public ConversionHandler to(MappedField destinationMappedField){
		this.destinationField = destinationMappedField.getValue(); 
		placeholders.put(destinationTypePattern, destinationField.getType().getName());
		placeholders.put(destinationNamePattern, destinationField.getName());
		placeholders.put(destinationGetPattern, destinationMappedField.getMethod());
		placeholders.put(destinationSetPattern, destinationMappedField.setMethod());
		return this;
	}

	/** Returns the conversion method
	 * @return method defined */
	public ConversionMethod getMethod(){     	     
		return methodDefined;	                      
	}
	
	/**
	 * Get the conversion method membership.
	 * @return membership
	 */
	public Membership getMembership() {
		return membership;
	}
}