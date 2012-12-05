/**
 * Copyright (C) 2012 Alessandro Vurro.
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
package it.avutils.jmapper.conversions.explicit;

import static it.avutils.jmapper.annotations.JMapConversion.Type.STATIC;
import static it.avutils.jmapper.conversions.explicit.ConversionPlaceholder.destinationNamePattern;
import static it.avutils.jmapper.conversions.explicit.ConversionPlaceholder.destinationPattern;
import static it.avutils.jmapper.conversions.explicit.ConversionPlaceholder.destinationTypePattern;
import static it.avutils.jmapper.conversions.explicit.ConversionPlaceholder.destinationValue;
import static it.avutils.jmapper.conversions.explicit.ConversionPlaceholder.sourceNamePattern;
import static it.avutils.jmapper.conversions.explicit.ConversionPlaceholder.sourcePattern;
import static it.avutils.jmapper.conversions.explicit.ConversionPlaceholder.sourceTypePattern;
import static it.avutils.jmapper.conversions.explicit.ConversionPlaceholder.sourceValue;
import static it.avutils.jmapper.enums.ConfigurationType.ANNOTATION;
import static it.avutils.jmapper.util.GeneralUtility.newLine;
import it.avutils.jmapper.enums.ConfigurationType;
import it.avutils.jmapper.enums.Membership;
import it.avutils.jmapper.mapper.generation.beans.Method;
import it.avutils.jmapper.util.XML;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		methodToGenerate.setOriginalName(definedName());
		
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
		}
		
		// Method body definition
		
		body += methodDefined.getContent();
		for (Entry<String, String> pair : placeholders.entrySet()) 
			body = body.replaceAll(pair.getKey(), pair.getValue());
		
		return methodToGenerate.setBody(body+"}catch(Exception e){"+error()+"}return null;}");
	}
	
	/**
	 * This method surrounds the explicit conversion defined with a try-catch, to handle null pointers.
	 * @return the body wrapped
	 */
	private String error(){
		Map<String, List<ConversionMethod>> conversions = xml.conversionsLoad();
		return "it.avutils.jmapper.config.Error.illegalCode(e,\""+ methodToGenerate.getOriginalName()+"\",\""+configClass.getSimpleName()+"\""
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
	
	/** Default constructor. */
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
	 * ConversionMethod found.
	 * @param method conversion method found
	 * @return this instance of ConversionHandler
	 */
	public ConversionHandler analyze(ConversionMethod method){
		this.methodDefined = method;
		return this;
	}
	
	/**
	 * Definition of the conversion method location.
	 * @param membership 
	 * @return this instance of ConversionHandler
	 */
	public ConversionHandler belongTo(Membership membership){
		this.membership = membership;
		this.configClass = membership == Membership.DESTINATION?destinationClass:sourceClass;
		return this;
	}
	
	/**
	 * ConfigurationType definition.
	 * @param configurationType configuration type
	 * @return this instance of ConversionHandler
	 */
	public ConversionHandler withThisConfiguration(ConfigurationType configurationType){
		this.configurationType = configurationType;
		return this;
	}
	
	/**
	 * Source field definition.
	 * @param field source field
	 * @return this instance of ConversionHandler
	 */
	public ConversionHandler from(Field field){
		this.sourceField = field;
		placeholders.put(sourceTypePattern, sourceField.getType().getName());
		placeholders.put(sourceNamePattern, sourceField.getName());
		return this;
	}
	
	/**
	 * Destination field definition.
	 * @param field destination field
	 * @return this instance of ConversionHandler
	 */
	public ConversionHandler to(Field field){
		this.destinationField = field;
		placeholders.put(destinationTypePattern, destinationField.getType().getName());
		placeholders.put(destinationNamePattern, destinationField.getName());
		return this;
	}

	/**
	 * Get the conversion method membership.
	 * @return membership
	 */
	public Membership getMembership() {
		return membership;
	}
}