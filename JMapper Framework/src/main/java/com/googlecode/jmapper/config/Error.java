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

import static com.googlecode.jmapper.config.Constants.*;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;

import com.googlecode.jmapper.exceptions.*;
import com.googlecode.jmapper.generation.beans.Method;
import com.googlecode.jmapper.xml.Attribute;
import com.googlecode.jmapper.xml.XML;

import static com.googlecode.jmapper.util.GeneralUtility.*;
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
	 * Thrown when the explicit conversion method defined has a null pointer.<br>
	 * Used in the generated code, in case of dynamic methods defined.
	 * @param className class name
	 */
	public static void illegalCode(Exception e, String methodName, String className){
		throw new IllegalCodeException(MSG.INSTANCE.message(nullPointer,methodName,className,e.getClass().getSimpleName(),""+e.getMessage()));
	}
	/**
	 * Thrown when the explicit conversion method defined has a null pointer.<br>
	 * Used in the generated code, in case of dynamic methods defined.
	 * @param className class name
	 * @param path xml path file
	 */
	public static void illegalCode(Exception e, String methodName, String className, String path){
		throw new IllegalCodeException(MSG.INSTANCE.message(nullPointerPath,methodName,className,path,e.getClass().getSimpleName(),""+e.getMessage()));
	}
	
	/**
	 * Thrown when the code contained in the body method is illegal.
	 * @param method method to adjust
	 * @param additionalInformation additional information relative to the javassist exception
	 */
	public static void bodyContainsIllegalCode(Method method, Exception additionalInformation){
		Class<?> clazz = method.getClazz();
		String originalName = method.getOriginalName();
		String message = isNull(clazz) && isNull(originalName) 
				?	MSG.INSTANCE.message(conversionIllegalSignature)
				:   MSG.INSTANCE.message(conversionBodyIllegalCode,clazz.getSimpleName(),originalName,""+additionalInformation.getMessage());
		
		throw new ConversionBodyIllegalCodeException(message);
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
	  #	  ConversionAnalyzer exceptions  #
	  ####################################
	*/	
	/**
	 * Thrown when the parameters number is incorrect.
	 * @param methodName method name
	 * @param className class name
	 */
	public static void wrongParameterNumber(String methodName, String className){
		throw new ConversionParameterException(MSG.INSTANCE.message(conversionParameterException,methodName,className));
	}
	/**
	 * Thrown when the parameters number is incorrect.
	 * @param methodName method name
	 * @param className class name
	 */
	public static void parametersUsageNotAllowed(String methodName, String className){
		throw new DynamicConversionParameterException(MSG.INSTANCE.message(dynamicConversionParameterException,methodName,className));
	}
	/**
	 * Thrown when the method don't respects the convetions beloging to the dynamic conversion implementation.
	 * @param methodName method name
	 * @param className class name
	 */
	public static void incorrectMethodDefinition(String methodName, String className){
		throw new DynamicConversionMethodException(MSG.INSTANCE.message(dynamicConversionMethodException,methodName,className));
	}
	/**
	 * Thrown when the body method don't respects the convetions beloging to the dynamic conversion implementation.
	 * @param methodName method name
	 * @param className class name
	 */
	public static void incorrectBodyDefinition(String methodName,String className){
		throw new DynamicConversionBodyException(MSG.INSTANCE.message(dynamicConversionBodyException,methodName,className));
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
		throw new XmlMappingClassDoesNotExistException(MSG.INSTANCE.message(xmlMappingClassDoesNotExistException2,aClass));
	}
	/*
	  ####################################
	  #	         XML exceptions          #
	  ####################################
	*/
	
	/**
	 * Thrown when global mapping is absent from XML configuration file.
	 * @param aClass
	 */
	public static void xmlGlobalExistent(Class<?> aClass) {
		throw new XmlMappingGlobalExistException(MSG.INSTANCE.message(xmlMappingGlobalExistException, aClass.getSimpleName()));
	}
	
	/**
	 * Thrown when global mapping is absent from XML configuration file.
	 * @param aClass
	 */
	public static void xmlGlobalInexistent(Class<?> aClass) {
		throw new XmlMappingGlobalDoesNotExistException(MSG.INSTANCE.message(xmlMappingGlobalDoesNotExistException, aClass.getSimpleName()));
	}
	/**
	 * Thrown when class doesn't exist from XML configuration file.
	 * @param className
	 */
	public static void xmlMappingClassDoesNotExist(String className){
		throw new XmlMappingClassDoesNotExistException(MSG.INSTANCE.message(xmlMappingClassDoesNotExistException2,className));
	}
	
	/**Thrown if attributes isn't present in the xml file.
	 * @param attributeName attribute name
	 * @param aClass class analyzed
	 */
	public static void attributeInexistent(String attributeName, Class<?> aClass){
		throw new IllegalArgumentException(MSG.INSTANCE.message(malformedBeanException2,attributeName,aClass.getSimpleName()));
	}
	/**
	 * Thrown when the class has only one attribute.
	 * @param aClass class analyzed
	 */
	public static void xmlWrongMethod(Class<?> aClass){
		throw new WrongMethodException (MSG.INSTANCE.message(wrongMethodException1,aClass.getSimpleName()));
	}
	/**
	 * Thrown if attribute is present in the xml file.
	 * @param path xml path
	 * @param attributeName attribute present
	 * @param aClass attribute's class
	 */
	public static void xmlAttributeInexistent(String path, String attributeName, Class<?> aClass){
		throw new XmlMappingAttributeDoesNotExistException (MSG.INSTANCE.message(xmlMappingAttributeDoesNotExistException2,attributeName,aClass.getSimpleName(),path));
	}
	/**
	 * Thrown if attribute is present in the xml file.
	 * @param path xml path
	 * @param attribute attribute present
	 * @param aClass attribute's class
	 */
	public static void xmlAttributeExistent(String path, Attribute attribute, Class<?> aClass){
		throw new XmlMappingAttributeExistException (MSG.INSTANCE.message(xmlMappingAttributeExistException2,attribute.getName(),aClass.getSimpleName(),path));
	}
	/**
	 * Thrown if class isn't present in xml file.
	 * @param path xml path
	 * @param aClass Class analyzed
	 */
	public static void xmlClassInexistent(String path, Class<?> aClass){
		throw new XmlMappingClassDoesNotExistException (MSG.INSTANCE.message(xmlMappingClassDoesNotExistException1,path,aClass.getSimpleName()));
	}
	/**
	 * Thrown if class is present in xml file.
	 * @param aClass Class analyzed
	 */
	public static void xmlClassExistent(String path, Class<?> aClass){
		throw new XmlMappingClassExistException (MSG.INSTANCE.message(xmlMappingClassExistException1,aClass.getSimpleName(),path));
	}
	
	/**
	 * Thrown when the conversion name is undefined.
	 * @param xmlPath xml path
	 * @param className class name
	 */
	public static void xmlConversionNameUndefined(String xmlPath, String className) {
		throw new XmlConversionNameException(MSG.INSTANCE.message(xmlConversionNameException,xmlPath,className));
	}
	/**
	 * Thrown if conversion type is wrong.
	 * @param conversionName conversion name
	 * @param xmlPath xml path
	 * @param className class name
	 * @param type type
	 */
	public static void xmlConversionTypeIncorrect(String conversionName,String xmlPath,String className,String type){
		throw new XmlConversionTypeException(MSG.INSTANCE.message(xmlConversionTypeException,conversionName,xmlPath,className,type));
	}
	/**
	 * Thrown if the use of the parameters is incorrect.
	 * @param conversionName conversion name
	 * @param xmlPath xml path
	 * @param className class name
	 */
	public static void improperUseOfTheParameter(String conversionName,String xmlPath,String className){
		throw new XmlConversionParameterException(MSG.INSTANCE.message(xmlConversionParameterException,conversionName,xmlPath,className));
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
		throw new LoadingFileException(MSG.INSTANCE.message(loadingFileException2,Constants.MSG_FILE));	
	}
	/**
	 * Thrown when the file isn't found.
	 */
	 public static void fileNotFound() throws FileNotFoundException{
		 throw new FileNotFoundException(MSG.INSTANCE.message(FileNotFoundException2,Constants.MSG_FILE));
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
		throw new FileNotFoundException(MSG.INSTANCE.message(FileNotFoundException1,path));
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
		throw new UndefinedMappingException(MSG.INSTANCE.message(undefinedMappingException,destinationField.getName(),destinationClass.getSimpleName(),sourceField.getName(),sourceClass.getSimpleName()));
	}
		
	/**
	 * Thrown when conversions are badly written.
	 * @param destinationField destination field
	 * @param destinationClass destination class
	 * @param sourceField source field
	 * @param sourceClass source class
	 * @param plus added messages of internal exceptions thrown
	 */
	public static void badConversion(Field destinationField, Class<?> destinationClass, Field sourceField, Class<?> sourceClass,String plus){
		throw new UndefinedMappingException(MSG.INSTANCE.message(undefinedMappingException,destinationField.getName(),destinationClass.getSimpleName(),sourceField.getName(),sourceClass.getSimpleName()) + ". More information: "+plus);
	}
	
	/*
	  ####################################
	  #	    ClassesManager exceptions    #
	  ####################################
	*/
	/**
	 * Thrown when the bean doesn't respect the javabean conventions.
	 * @param methodType method type
	 * @param methodName name of the method doesn't exist
	 * @param clazz class when this method isn't present
	 */
	public static void customMethod(String methodType,String methodName, Class<?> clazz){
		String completeName = clazz.getCanonicalName();
		String packageName = clazz.getPackage().getName();
		String className = completeName.substring(packageName.length()+1);
		throw new MalformedBeanException(MSG.INSTANCE.message(customMethodException, methodType, methodName,className));
	}
	
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
		throw new MalformedBeanException(MSG.INSTANCE.message(malformedBeanException3, methodName,fieldName,className));
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
		throw new MappingErrorException(MSG.INSTANCE.message(mappingErrorException2,mappedFieldName,mappedClass.getSimpleName(),targetClass.getSimpleName()));
	}
	/**
	 * Thrown when the length of classes and attribute parameter isn't the same.
	 * @param mappedFieldName name of the mapped field
	 * @param mappedClassName name of the mapped field's class
	 */
	public static void mapping(String mappedFieldName, String mappedClassName){
		throw new MappingErrorException(MSG.INSTANCE.message(mappingErrorException2length,mappedFieldName,mappedClassName));
	}
	/**
	 * Thrown when the target class doesn't exist in classes parameter.
	 * @param mappedFieldName name of the mapped field
	 * @param mappedClassName name of the mapped field's class
	 * @param targetClassName name of the target field's class
	 */
	public static void mapping(String mappedFieldName, String mappedClassName, String targetClassName){
		throw new MappingErrorException(MSG.INSTANCE.message(mappingErrorException3,mappedFieldName,mappedClassName,targetClassName));
	}
	/**
	 * Thrown when the target field doesn't exist.
	 * @param mappedFieldName name of the mapped field
	 * @param mappedClassName name of the mapped field's class
	 * @param targetFieldName name of the target field
	 * @param targetClassName name of the target field's class
	 */
	public static void mapping(String mappedFieldName, String mappedClassName, String targetFieldName, String targetClassName){
		throw new MappingErrorException(MSG.INSTANCE.message(mappingErrorException4,mappedFieldName,mappedClassName, targetFieldName,targetClassName));
	}
	/**
	 * Thrown if the attribute doesn't exist in aClass.
	 * @param aClass class that not contains aField
	 * @param aField the missing field
	 */
	public static void attributeAbsent(Class<?> aClass,Attribute aField){
		throw new XmlMappingAttributeDoesNotExistException(MSG.INSTANCE.message(xmlMappingAttributeDoesNotExistException2,aClass.getSimpleName(),aField.getName()));
	}
		
	/*
	  ####################################
	  #	   MapperConstructor exceptions	 #
	  ####################################
	*/
	/**
	 * Thrown when the xml configuration doesn't contains the classes configuration.
	 * @param destination destination class name
	 * @param source source class name
	 * @param xml xml path
	 */
	public static void configNotPresent(Class<?> destination,Class<?> source,XML xml){
		throw new MappingNotFoundException(MSG.INSTANCE.message(Constants.mappingNotFoundException2path,destination.getSimpleName(), source.getSimpleName(),xml.getXmlPath()));
	}
	/**
	 * Thrown when missing the configuration belonging to clazz.
	 * @param clazz class without configuration
	 * @param xml xml path
	 */
	public static void configNotPresent(Class<?> clazz,XML xml){
		throw new MappingNotFoundException(MSG.INSTANCE.message(Constants.mappingNotFoundException1path, clazz.getSimpleName(),xml.getXmlPath()));
	}
	/**
	 * Thrown when the xml configuration doesn't exist.
	 * @param destination destination class name
	 * @param source source class name
	 */
	public static void classesNotConfigured(Class<?> destination,Class<?> source){
		throw new MappingNotFoundException(MSG.INSTANCE.message(Constants.mappingNotFoundException2,destination.getSimpleName(), source.getSimpleName()));
	}
	/**
	 * Thrown when the xml configuration of the clazz doesn't exist.
	 * @param clazz class to check
	 */
	public static void classNotConfigured(Class<?> clazz){
		throw new MappingNotFoundException(MSG.INSTANCE.message(Constants.mappingNotFoundException1, clazz.getSimpleName()));
	}
	/*
	  ####################################
	  #	  RelationalJMapper exceptions	 #
	  ####################################
	*/

	/**
	 * Thrown if the configured class hasn't classes parameter.
	 * @param aClass class's field
	 */
	public static void globalClassesAbsent(Class<?> aClass){
		throw new MappingErrorException(MSG.INSTANCE.message(mappingErrorRelationalException3, aClass.getSimpleName()));
	}
	/**
	 * Thrown if the configured field hasn't classes parameter.
	 * @param fieldName name of the field
	 * @param aClass class's field
	 */
	public static void classesAbsent(String fieldName,Class<?> aClass){
		throw new MappingErrorException(MSG.INSTANCE.message(mappingErrorRelationalException2,fieldName, aClass.getSimpleName()));
	}
	/**
	 * Thrown if the class isn't mapped.
	 * @param aClass class to analyze
	 */
	public static void classNotMapped(Class<?> aClass){
		throw new ClassNotMappedException(MSG.INSTANCE.message(classNotMappedException1,aClass.getSimpleName()));
	}
	/**
	 * Thrown if the sourceClass isn't mapped in configuredClass.
	 * @param sourceClass class absent
	 * @param configuredClass class that not contains sourceClass
	 */
	public static void classNotMapped(Object sourceClass, Class<?> configuredClass){
		String sourceName = sourceClass instanceof Class?((Class<?>)sourceClass).getSimpleName():sourceClass.getClass().getSimpleName();
		throw new ClassNotMappedException(MSG.INSTANCE.message(classNotMappedException2,sourceName, configuredClass.getSimpleName()));
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
		throw new IllegalCodeException(MSG.INSTANCE.message(illegalCodePath,destination.getSimpleName(),source.getSimpleName(),path,additionalInformation));
	}
	/** 
	 * Thrown when there is an error in mapper generated class.
	 * @param destination destination class
	 * @param source source class
	 * @param e exception captured
	 */
	public static void illegalCode(Class<?> destination, Class<?> source, Throwable e){
		String additionalInformation = e.getMessage().split(",")[1];
		throw new IllegalCodeException(MSG.INSTANCE.message(illegalCode,destination.getSimpleName(),source.getSimpleName(),additionalInformation));
	}
	/**
	 * Thrown when there isn't correspondence between classes.
	 * @param configuredClass configured class
	 * @param targetClass target class
	 */
	public static void absentRelationship(Class<?> configuredClass, Class<?> targetClass){
		throw new AbsentRelationshipException(MSG.INSTANCE.message(noRelationshipException,configuredClass.getSimpleName(),targetClass.getSimpleName()));
	}
	/**
	 * Thrown if the class is null.
	 * @param className name of the class
	 */
	public static void nullMappedClass(String className){
		throw new NullMappedClassException(MSG.INSTANCE.message(nullMappedClassException1,className));
	}
	
	/**
	 * Thrown if the class is an interface.
	 * @param className name of the class
	 */
	public static void interfaceClass(String className){
		throw new IllegalArgumentException(MSG.INSTANCE.message(illegalArgumentException1,className));
	}
	
	/**
	 * Thrown if the class haven't an empty constructor.
	 * @param aClass class to analyze
	 */
	public static void emptyConstructorAbsent(Class<?> aClass){
		throw new MalformedBeanException(MSG.INSTANCE.message(malformedBeanException1,aClass.getSimpleName()));
	}
	
	
}
