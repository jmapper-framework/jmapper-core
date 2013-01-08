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

package it.avutils.jmapper.config;

import static it.avutils.jmapper.config.MessageHandler.message;
import static it.avutils.jmapper.constants.Constants.*;
import it.avutils.jmapper.constants.Constants;
import it.avutils.jmapper.exception.AbsentRelationshipException;
import it.avutils.jmapper.exception.ClassNotMappedException;
import it.avutils.jmapper.exception.ConversionBodyIllegalCodeException;
import it.avutils.jmapper.exception.ConversionParameterException;
import it.avutils.jmapper.exception.DynamicConversionBodyException;
import it.avutils.jmapper.exception.DynamicConversionMethodException;
import it.avutils.jmapper.exception.DynamicConversionParameterException;
import it.avutils.jmapper.exception.IllegalCodeException;
import it.avutils.jmapper.exception.LoadingFileException;
import it.avutils.jmapper.exception.MalformedBeanException;
import it.avutils.jmapper.exception.MappingErrorException;
import it.avutils.jmapper.exception.MappingException;
import it.avutils.jmapper.exception.MappingNotFoundException;
import it.avutils.jmapper.exception.NullMappedClassException;
import it.avutils.jmapper.exception.UndefinedMappingException;
import it.avutils.jmapper.exception.WrongMethodException;
import it.avutils.jmapper.exception.XmlConversionNameException;
import it.avutils.jmapper.exception.XmlConversionParameterException;
import it.avutils.jmapper.exception.XmlConversionTypeException;
import it.avutils.jmapper.exception.XmlMappingAttributeDoesNotExistException;
import it.avutils.jmapper.exception.XmlMappingAttributeExistException;
import it.avutils.jmapper.exception.XmlMappingClassDoesNotExistException;
import it.avutils.jmapper.exception.XmlMappingClassExistException;
import it.avutils.jmapper.mapper.generation.beans.Method;
import it.avutils.jmapper.util.XML;
import it.avutils.jmapper.xml.Attribute;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
/**
 * This Class exposes all common methods to handle technical errors.
 * <br>The scope is to centralize the management of exceptions
 * and make the code more readable.<br>
 * The constants used are the keys of the "jmapper.msg.properties" file present in this package.
 * 
 * @author Alessandro Vurro
 *
 */
public final class Error {
	/*
	  ####################################
	  #	   MapperGenerator exceptions    #
	  ####################################
	*/
	
	/**
	 * Thrown when the explicit conversion method defined has a null pointer.
	 * @param className class name
	 */
	public static void illegalCode(Exception e, String methodName, String className){
		throw new IllegalCodeException(message(nullPointer,methodName,className,e.getClass().getSimpleName(),""+e.getMessage()));
	}
	/**
	 * Thrown when the explicit conversion method defined has a null pointer.
	 * @param className class name
	 * @param path xml path file
	 */
	public static void illegalCode(Exception e, String methodName, String className, String path){
		throw new IllegalCodeException(message(nullPointerPath,methodName,className,path,e.getClass().getSimpleName(),""+e.getMessage()));
	}
	
	/**
	 * Thrown when the code contained in the body method is illegal.
	 * @param method method to adjust
	 * @param additionalInformation additional information relative to the javassist exception
	 */
	public static void bodyContainsIllegalCode(Method method, Exception additionalInformation){
		throw new ConversionBodyIllegalCodeException(message(conversionBodyIllegalCode,method.getClazz().getSimpleName(),method.getOriginalName(),""+additionalInformation.getMessage()));
	}
	/**
	 * Thrown when javassist don't find classes.
	 * @param e exception to handle
	 */
	public static void notFoundException(Exception e){
		throw new MappingException(e.getMessage());
	}
	
	/*
	  ####################################
	  #	  ConversionReader exceptions    #
	  ####################################
	*/	
	/**
	 * Thrown when the parameters number is incorrect.
	 * @param methodName method name
	 * @param className class name
	 */
	public static void wrongParameterNumber(String methodName, String className){
		throw new ConversionParameterException(message(conversionParameterException,methodName,className));
	}
	/**
	 * Thrown when the parameters number is incorrect.
	 * @param methodName method name
	 * @param className class name
	 */
	public static void parametersUsageNotAllowed(String methodName, String className){
		throw new DynamicConversionParameterException(message(dynamicConversionParameterException,methodName,className));
	}
	/**
	 * Thrown when the method don't respects the convetions beloging to the dynamic conversion implementation.
	 * @param methodName method name
	 * @param className class name
	 */
	public static void incorrectMethodDefinition(String methodName, String className){
		throw new DynamicConversionMethodException(message(dynamicConversionMethodException,methodName,className));
	}
	/**
	 * Thrown when the body method don't respects the convetions beloging to the dynamic conversion implementation.
	 * @param methodName method name
	 * @param className class name
	 */
	public static void incorrectBodyDefinition(String methodName,String className){
		throw new DynamicConversionBodyException(message(dynamicConversionBodyException,methodName,className));
	}
	/*
	  ####################################
	  #	    XmlConverter exceptions      #
	  ####################################
	*/
	/**
	 * Thrown if class is present in the xml configuration file but doesn't exist.
	 * @param aClass Class analyzed
	 */
	public static void classInexistent(String aClass){
		throw new XmlMappingClassDoesNotExistException(message(xmlMappingClassDoesNotExistException2,aClass));
	}
	/*
	  ####################################
	  #	         XML exceptions          #
	  ####################################
	*/
	/**Thrown if attributes isn't present in the xml file.
	 * @param attributeName attribute name
	 * @param aClass class analyzed
	 */
	public static void attributeInexistent(String attributeName, Class<?> aClass){
		throw new IllegalArgumentException(message(malformedBeanException2,attributeName,aClass.getSimpleName()));
	}
	/**
	 * Thrown when the class has only one attribute.
	 * @param aClass class analyzed
	 */
	public static void xmlWrongMethod(Class<?> aClass){
		throw new WrongMethodException (message(wrongMethodException1,aClass.getSimpleName()));
	}
	/**
	 * Thrown if attribute is present in the xml file.
	 * @param path xml path
	 * @param attributeName attribute present
	 * @param aClass attribute's class
	 */
	public static void xmlAttributeInexistent(String path, String attributeName, Class<?> aClass){
		throw new XmlMappingAttributeDoesNotExistException (message(xmlMappingAttributeDoesNotExistException2,attributeName,aClass.getSimpleName(),path));
	}
	/**
	 * Thrown if attribute is present in the xml file.
	 * @param path xml path
	 * @param attribute attribute present
	 * @param aClass attribute's class
	 */
	public static void xmlAttributeExistent(String path, Attribute attribute, Class<?> aClass){
		throw new XmlMappingAttributeExistException (message(xmlMappingAttributeExistException2,attribute.getName(),aClass.getSimpleName(),path));
	}
	/**
	 * Thrown if class isn't present in xml file.
	 * @param path xml path
	 * @param aClass Class analyzed
	 */
	public static void xmlClassInexistent(String path, Class<?> aClass){
		throw new XmlMappingClassDoesNotExistException (message(xmlMappingClassDoesNotExistException1,path,aClass.getSimpleName()));
	}
	/**
	 * Thrown if class is present in xml file.
	 * @param aClass Class analyzed
	 */
	public static void xmlClassExistent(String path, Class<?> aClass){
		throw new XmlMappingClassExistException (message(xmlMappingClassExistException1,aClass.getSimpleName(),path));
	}
	
	/**
	 * Thrown when the conversion name is undefined.
	 * @param xmlPath xml path
	 * @param className class name
	 */
	public static void xmlConversionNameUndefined(String xmlPath, String className) {
		throw new XmlConversionNameException(message(xmlConversionNameException,xmlPath,className));
	}
	/**
	 * Thrown if conversion type is wrong.
	 * @param conversionName conversion name
	 * @param xmlPath xml path
	 * @param className class name
	 * @param type type
	 */
	public static void xmlConversionTypeIncorrect(String conversionName,String xmlPath,String className,String type){
		throw new XmlConversionTypeException(message(xmlConversionTypeException,conversionName,xmlPath,className,type));
	}
	/**
	 * Thrown if the use of the parameters is incorrect.
	 * @param conversionName conversion name
	 * @param xmlPath xml path
	 * @param className class name
	 */
	public static void improperUseOfTheParameter(String conversionName,String xmlPath,String className){
		throw new XmlConversionParameterException(message(xmlConversionParameterException,conversionName,xmlPath,className));
	}
	/*
	  ####################################
	  #	    	  MSG exceptions         #
	  ####################################
	*/
	/**
	 * Thrown when the file can't be loaded.
	 */
	public static void unableLoadingFile() throws LoadingFileException{
		throw new LoadingFileException(message(loadingFileException2,Constants.MSG_FILE));	
	}
	/**
	 * Thrown when the file isn't found.
	 */
	 public static void fileNotFound() throws FileNotFoundException{
		 throw new FileNotFoundException(message(FileNotFoundException2,Constants.MSG_FILE));
	}
	
	/*
	  ####################################
	  #	         XML exceptions          #
	  ####################################
	*/
	
	/**
	 * Thrown when the file isn't found.
	 */
	 public static void fileNotFound(String path) throws FileNotFoundException{
		throw new FileNotFoundException(message(FileNotFoundException1,path));
	}
	
	/*
	  ####################################
	  #	    OperationHandler exceptions  #
	  ####################################
	*/
	
	/**
	 * Thrown when the instruction isn't defined.
	 * @param destinationField destination field
	 * @param destinationClass destination class
	 * @param sourceField source field
	 * @param sourceClass source class
	 */
	public static void undefinedMapping(Field destinationField, Class<?> destinationClass, Field sourceField, Class<?> sourceClass){
		throw new UndefinedMappingException(message(undefinedMappingException,destinationField.getName(),destinationClass.getSimpleName(),sourceField.getName(),sourceClass.getSimpleName()));
	}
	
	/*
	  ####################################
	  #	    ClassesManager exceptions    #
	  ####################################
	*/
	
	/**
	 * Thrown when the bean doesn't respect the javabean conventions.
	 * @param methodName name of the method doesn't exist
	 * @param fieldName name of the field analyze
	 * @param clazz class when this method isn't present
	 */
	public static void method(String methodName, String fieldName, Class<?> clazz){
		String completeName = clazz.getCanonicalName();
		String packageName = clazz.getPackage().getName();
		String className = completeName.substring(packageName.length()+1);
		throw new MalformedBeanException(message(malformedBeanException3, methodName,fieldName,className));
	}
	
	/*
	  ####################################
	  #	    ConfigReader exceptions	     #
	  ####################################
	*/
	
	/**
	 * Thrown when there is an error in the configuration.
	 * @param mappedFieldName name of the mapped field
	 * @param mappedClass mapped field's class
	 * @param targetClass target field's class
	 */
	public static void mapping(String mappedFieldName,Class<?> mappedClass, Class<?> targetClass){
		throw new MappingErrorException(message(mappingErrorException2,mappedFieldName,mappedClass.getSimpleName(),targetClass.getSimpleName()));
	}
	/**
	 * Thrown when the length of classes and attribute parameter isn't the same.
	 * @param mappedFieldName name of the mapped field
	 * @param mappedClassName name of the mapped field's class
	 */
	public static void mapping(String mappedFieldName, String mappedClassName){
		throw new MappingErrorException(message(mappingErrorException2length,mappedFieldName,mappedClassName));
	}
	/**
	 * Thrown when the target class doesn't exist in classes parameter.
	 * @param mappedFieldName name of the mapped field
	 * @param mappedClassName name of the mapped field's class
	 * @param targetClassName name of the target field's class
	 */
	public static void mapping(String mappedFieldName, String mappedClassName, String targetClassName){
		throw new MappingErrorException(message(mappingErrorException3,mappedFieldName,mappedClassName,targetClassName));
	}
	/**
	 * Thrown when the target field doesn't exist.
	 * @param mappedFieldName name of the mapped field
	 * @param mappedClassName name of the mapped field's class
	 * @param targetFieldName name of the target field
	 * @param targetClassName name of the target field's class
	 */
	public static void mapping(String mappedFieldName, String mappedClassName, String targetFieldName, String targetClassName){
		throw new MappingErrorException(message(mappingErrorException4,mappedFieldName,mappedClassName, targetFieldName,targetClassName));
	}
	/**
	 * Thrown if the attribute doesn't exist in aClass.
	 * @param aClass class that not contains aField
	 * @param aField the missing field
	 */
	public static void attributeAbsent(Class<?> aClass,Attribute aField){
		throw new XmlMappingAttributeDoesNotExistException(message(xmlMappingAttributeDoesNotExistException2,aClass.getSimpleName(),aField.getName()));
	}
		
	/*
	  ####################################
	  #	   MappingBuilder exceptions	 #
	  ####################################
	*/
	/**
	 * Thrown when the xml configuration doesn't contains the classes configuration.
	 * @param destination destination class name
	 * @param source source class name
	 * @param xml xml path
	 */
	public static void configNotPresent(Class<?> destination,Class<?> source,XML xml){
		throw new MappingNotFoundException(message(Constants.mappingNotFoundException2path,destination.getSimpleName(), source.getSimpleName(),xml.getXmlPath()));
	}
	/**
	 * Thrown when missing the configuration belonging to clazz.
	 * @param clazz class without configuration
	 * @param xml xml path
	 */
	public static void configNotPresent(Class<?> clazz,XML xml){
		throw new MappingNotFoundException(message(Constants.mappingNotFoundException1path, clazz.getSimpleName(),xml.getXmlPath()));
	}
	/**
	 * Thrown when the xml configuration doesn't exist.
	 * @param destination destination class name
	 * @param source source class name
	 */
	public static void classesNotConfigured(Class<?> destination,Class<?> source){
		throw new MappingNotFoundException(message(Constants.mappingNotFoundException2,destination.getSimpleName(), source.getSimpleName()));
	}
	/**
	 * Thrown when the xml configuration of the clazz doesn't exist.
	 * @param clazz class to check
	 */
	public static void classNotConfigured(Class<?> clazz){
		throw new MappingNotFoundException(message(Constants.mappingNotFoundException1, clazz.getSimpleName()));
	}
	/*
	  ####################################
	  #	  RelationalJMapper exceptions	 #
	  ####################################
	*/

	/**
	 * Thrown if the configured field hasn't classes parameter.
	 * @param fieldName name of the field
	 * @param aClass class's field
	 */
	public static void classesAbsent(String fieldName,Class<?> aClass){
		throw new MappingErrorException(message(mappingErrorRelationalException2,fieldName, aClass.getSimpleName()));
	}
	/**
	 * Thrown if the class isn't mapped.
	 * @param aClass class to analyze
	 */
	public static void classNotMapped(Class<?> aClass){
		throw new ClassNotMappedException(message(classNotMappedException1,aClass.getSimpleName()));
	}
	/**
	 * Thrown if the sourceClass isn't mapped in configuredClass.
	 * @param sourceClass class absent
	 * @param configuredClass class that not contains sourceClass
	 */
	public static void classNotMapped(Object sourceClass, Class<?> configuredClass){
		String sourceName = sourceClass instanceof Class?((Class<?>)sourceClass).getSimpleName():sourceClass.getClass().getSimpleName();
		throw new ClassNotMappedException(message(classNotMappedException2,sourceName, configuredClass.getSimpleName()));
	}
	
	/*
	  ####################################
	  #		JMapper exceptions			 #
	  ####################################
	*/
	/** 
	 * Thrown when there is an error in mapper generated class.
	 * @param destination destination class
	 * @param source source class
	 * @param path xml path configuration
	 * @param e exception captured
	 */
	public static void illegalCode(Class<?> destination, Class<?> source, String path, Throwable e){
		String additionalInformation = e.getMessage().split(",")[1];
		throw new IllegalCodeException(message(illegalCodePath,destination.getSimpleName(),source.getSimpleName(),path,additionalInformation));
	}
	/** 
	 * Thrown when there is an error in mapper generated class.
	 * @param destination destination class
	 * @param source source class
	 * @param e exception captured
	 */
	public static void illegalCode(Class<?> destination, Class<?> source, Throwable e){
		String additionalInformation = e.getMessage().split(",")[1];
		throw new IllegalCodeException(message(illegalCode,destination.getSimpleName(),source.getSimpleName(),additionalInformation));
	}
	/**
	 * Thrown when there isn't correspondence between classes.
	 * @param configuredClass configured class
	 * @param targetClass target class
	 */
	public static void absentRelationship(Class<?> configuredClass, Class<?> targetClass){
		throw new AbsentRelationshipException(message(noRelationshipException,configuredClass.getSimpleName(),targetClass.getSimpleName()));
	}
	/**
	 * Thrown if the class is null.
	 * @param className name of the class
	 */
	public static void nullMappedClass(String className){
		throw new NullMappedClassException(message(nullMappedClassException1,className));
	}
	
	/**
	 * Thrown if the class is an interface.
	 * @param className name of the class
	 */
	public static void interfaceClass(String className){
		throw new IllegalArgumentException(message(illegalArgumentException1,className));
	}
	
	/**
	 * Thrown if the class haven't an empty constructor.
	 * @param aClass class to analyze
	 */
	public static void emptyConstructorAbsent(Class<?> aClass){
		throw new MalformedBeanException(message(malformedBeanException1,aClass.getSimpleName()));
	}
	
}
