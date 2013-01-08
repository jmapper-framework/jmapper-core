/**
 * Copyright (C) 2013 Alessandro Vurro.
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

package it.avutils.jmapper.xml;

import static it.avutils.jmapper.constants.Constants.CONTENT_ALREADY_DEFINED;
import static it.avutils.jmapper.constants.Constants.DEFAULT_FIELD_VALUE;
import static it.avutils.jmapper.conversions.explicit.ConversionMethod.ParameterNumber.ONE;
import static it.avutils.jmapper.conversions.explicit.ConversionMethod.ParameterNumber.TWO;
import static it.avutils.jmapper.conversions.explicit.ConversionMethod.ParameterNumber.ZERO;
import static it.avutils.jmapper.conversions.explicit.ConversionPlaceholder.destination;
import static it.avutils.jmapper.conversions.explicit.ConversionPlaceholder.source;
import static it.avutils.jmapper.annotations.JMapConversion.ALL;
import it.avutils.jmapper.annotations.JMap;
import it.avutils.jmapper.annotations.JMapConversion;
import it.avutils.jmapper.annotations.JMapConversion.Type;
import it.avutils.jmapper.config.Error;
import it.avutils.jmapper.constants.Constants;
import it.avutils.jmapper.conversions.explicit.ConversionMethod;
import it.avutils.jmapper.conversions.explicit.ConversionMethod.ParameterNumber;
import it.avutils.jmapper.exception.ConversionParameterException;
import it.avutils.jmapper.exception.DynamicConversionBodyException;
import it.avutils.jmapper.exception.DynamicConversionMethodException;
import it.avutils.jmapper.exception.DynamicConversionParameterException;
import it.avutils.jmapper.exception.XmlConversionNameException;
import it.avutils.jmapper.exception.XmlConversionParameterException;
import it.avutils.jmapper.exception.XmlConversionTypeException;
import it.avutils.jmapper.xml.beans.XmlAttribute;
import it.avutils.jmapper.xml.beans.XmlAttributeName;
import it.avutils.jmapper.xml.beans.XmlClass;
import it.avutils.jmapper.xml.beans.XmlClassName;
import it.avutils.jmapper.xml.beans.XmlConversion;
import it.avutils.jmapper.xml.beans.XmlValueName;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * XmlConverter simplifies the manipulation of xml mapping file.
 * 
 * @author Alessandro Vurro
 *
 */
public class XmlConverter {
	
	/**
	 * This method transforms a Class given in input, into a XmlClass.
	 * @param aClass Class to trasform in XmlClass
	 * @return a Class converted to XmlClass
	 */
	public static XmlClass toXmlClass(Class<?> aClass){
		XmlClass xmlClass = new XmlClass();
		xmlClass.name = aClass.getName();
		xmlClass.attributes = new ArrayList<XmlAttribute>();
		for (Field field : aClass.getDeclaredFields())
			if(field.getAnnotation(JMap.class) != null)
				xmlClass.attributes.add(toXmlAttribute(field));
			
		return xmlClass;
	}
	
	/**
	 * This method transforms a XmlConversion given in input, into a ConversionMethod.
	 * @param xmlConversion xmlConversion to transform in ConversionMethod
	 * @return a ConversionMethod
	 */
	public static ConversionMethod toConversionMethod(XmlConversion xmlConversion){
		
		if(xmlConversion.name == null || xmlConversion.name.length() == 0){
			xmlConversion.name = "undefinedName";
			throw new XmlConversionNameException("it's mandatory define a name");
		}
		
		String name = xmlConversion.name;
		String conversionType = xmlConversion.type;
											   
		Type type = conversionType == null ? JMapConversion.Type.STATIC // default type value
				   		                   : conversionType.equalsIgnoreCase("STATIC")
				   		                   		 ? Type.STATIC
				   		                   		 : conversionType.equalsIgnoreCase("DYNAMIC") 
				   		                   				? Type.DYNAMIC 
				   		                   				: null;
		
		if(type == null) 
			throw new XmlConversionTypeException("wrong type defined, only STATIC and DYNAMIC options are permitted");
		
		String[] from = xmlConversion.from == null ? new String[]{ALL} // default from value
		                                           : trim(xmlConversion.from.split(","));
		String[] to = xmlConversion.to == null     ? new String[]{ALL} // default to   value
        										   : trim(xmlConversion.to.split(","));
		String content = xmlConversion.content.trim();
		
		if(!content.contains(source) && content.contains(destination))
			throw new XmlConversionParameterException("the use of the destination isn't permitted without the use of the source");
		
		ParameterNumber number = content.contains(source)?content.contains(destination)?TWO:ONE:ZERO;
		
		return new ConversionMethod(name, from, to, type, number,content);
	}
	
	/**
	 * This method transforms a Method given in input, into a ConversionMethod.
	 * @param aMethod Method to transform in ConversionMethod
	 * @return a ConversionMethod
	 */
	public static ConversionMethod toConversionMethod(Method aMethod){
		JMapConversion conversion = aMethod.getAnnotation(JMapConversion.class);
		
		String name = aMethod.getName();
		String[] from = trim(conversion.from());
		String[] to = trim(conversion.to());
		Type type = conversion.type();
		
		ParameterNumber number = null;
		String body = null;
		
		switch(type){
			case STATIC: 
				switch(aMethod.getParameterTypes().length){
					case 1: number = ONE; break;
					case 2: number = TWO; break;
					default: 
						throw new ConversionParameterException("is allowed to use from one to two parameters");
				}
				body = CONTENT_ALREADY_DEFINED;
			break;
			case DYNAMIC: 
				if(aMethod.getParameterTypes().length != 0)
					throw new DynamicConversionParameterException("is not allowed parameters usage in a dynamic method");
				
				try { 
					body = (String) aMethod.invoke(null, new Object[]{});
				} catch (Exception e) {
					throw new DynamicConversionMethodException("the method don't respects the conventions");
				}
				
				if(!body.contains(source) && body.contains(destination))
					throw new DynamicConversionBodyException("the use of the destination isn't permitted without the use of the source");
				
				number = body.contains(source)?body.contains(destination)?TWO:ONE:ZERO;
			break;
		}
			
		return new ConversionMethod(name, from, to, type, number, body);
	}
	
	private static String[] trim(String[] array){
		for (int i = 0; i < array.length; i++)array[i] = array[i].trim();
		return array;
	}
	/**
	 * This method transforms a XmlAttribute into an Attribute.
	 * @param xmlAttribute
	 * @return an instance of Attribute
	 */
	public static Attribute toAttribute(XmlAttribute xmlAttribute) {
		String name = xmlAttribute.name;
		String value = xmlAttribute.value != null? xmlAttribute.value.name:null;
		String[] attributes = null;
		Class<?>[] classes  = null;
		
		if(xmlAttribute.attributes != null && !xmlAttribute.attributes.isEmpty()){
			attributes = new String[xmlAttribute.attributes.size()];
			for (int i = xmlAttribute.attributes.size(); i --> 0;) 
				attributes[i] = xmlAttribute.attributes.get(i).name;
		}

		if(xmlAttribute.classes != null && !xmlAttribute.classes.isEmpty()){
			classes = new Class<?>[xmlAttribute.classes.size()];
			for (int i = xmlAttribute.classes.size(); i --> 0;){
				Class<?> aClass = null;
				try { 	  		      aClass = Class.forName(xmlAttribute.classes.get(i).name); } 
				catch (Exception e) { Error.classInexistent(xmlAttribute.classes.get(i).name);	}
				classes[i] = aClass;
			}
		}
		
		return new Attribute(name, value, attributes, classes);
	}
	
	/**
	 * This method transforms a Field given in input, into a XmlAttribute.
	 * @param aField Field to transform in XmlAttribute
	 * @return a field converted to XmlAttribute
	 */
	public static XmlAttribute toXmlAttribute(Field aField){
		JMap jMap = aField.getAnnotation(JMap.class);
		return toXmlAttribute(aField.getName(),jMap.value(),jMap.attributes(),jMap.classes());
	}
	
	/**
	 * This method transforms a Attribute given in input, into a XmlAttribute.
	 * @param attribute an Attribute to transform in XmlAttribute
	 * @return an Attribute converted to XmlAttribute
	 */
	public static XmlAttribute toXmlAttribute(Attribute attribute){
		return toXmlAttribute(attribute.getName(),attribute.getValue(),attribute.getAttributes(),attribute.getClasses());
	}
	
	/**
	 * Shared method. Starting from general parameters returns an instance of XmlAttribute.
	 * @param name name of the mapped field
	 * @param value name of target field
	 * @param attributes names of target fields
	 * @param classes list of target classes
	 * @return a XmlAttribute instance
	 */
	private static XmlAttribute toXmlAttribute(String name, String value, String[] attributes, Class<?>[] classes){
		
		XmlAttribute xmlAttribute = new XmlAttribute();
		
		xmlAttribute.name = name;
		
		if(value != null && (value.length()>0 || DEFAULT_FIELD_VALUE.equals(value)) ){
			xmlAttribute.value = new XmlValueName();
			xmlAttribute.value.name = getValue(value,name);
		}

		if(attributes != null && attributes.length>0){
			xmlAttribute.attributes = new ArrayList<XmlAttributeName>();
			for (String attribute : attributes)
				xmlAttribute.attributes.add(new XmlAttributeName(getValue(attribute,name)));
		}
		
		if(classes != null && classes.length>0){
			xmlAttribute.classes = new ArrayList<XmlClassName>();
			for (Class<?> clazz : classes) 
				xmlAttribute.classes.add(new XmlClassName(clazz.getName()));
		}
		
		return xmlAttribute;
	}
	
	/**
	 * This method compare the name of the target field with the DEFAULT_FIELD_VALUE, 
	 * if are equals, the name of mapped field will be returned,
	 * otherwise name of target field will be returned.
	 * 
	 * @param value value of the configuration
	 * @param name name of the configured field
	 * @return the name of target field
	 * 
	 * @see Constants#DEFAULT_FIELD_VALUE
	 */
	private static String getValue(final String value,final String name){
		if(value == null) return null;
		return value.equals(DEFAULT_FIELD_VALUE)?name:value;
	}
}
