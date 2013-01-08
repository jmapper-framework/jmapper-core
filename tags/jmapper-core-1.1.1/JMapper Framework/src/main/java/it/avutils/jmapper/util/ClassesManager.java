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

package it.avutils.jmapper.util;

import static it.avutils.jmapper.util.AutoBoxing.boxingOperations;
import static it.avutils.jmapper.util.AutoBoxing.unBoxingOperations;
import static it.avutils.jmapper.util.GeneralUtility.collectionIsAssignableFrom;
import static it.avutils.jmapper.util.GeneralUtility.enrichList;
import static it.avutils.jmapper.util.GeneralUtility.getMethod;
import static it.avutils.jmapper.util.GeneralUtility.implementationClass;
import static it.avutils.jmapper.util.GeneralUtility.isAccessModifier;
import static it.avutils.jmapper.util.GeneralUtility.mSet;
import static it.avutils.jmapper.util.GeneralUtility.mapIsAssignableFrom;
import static it.avutils.jmapper.util.GeneralUtility.toList;
import it.avutils.jmapper.annotations.JMap;
import it.avutils.jmapper.config.Error;
import it.avutils.jmapper.conversions.explicit.ConversionMethod;
import it.avutils.jmapper.enums.ChooseConfig;
import it.avutils.jmapper.xml.Attribute;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class that allows you to manage classes.
 * @author Alessandro Vurro
 */
public final class ClassesManager {

	private ClassesManager() { }
	
	/**
	 * this method verify that the istruction: 
	 * <p><code> destination.putAll(source) </code><p>is permitted 
	 * 
	 * @param destination
	 * @param source
	 * @return true if the istruction destination.putAll(source) is permitted
	 */
	public static boolean isPutAllPermitted(Field destination,Field source){
		
		boolean isFirst = true;
		boolean isAddAllFunction = false;
		boolean isPutAllFunction = true;
		return isAssignableFrom(getGenericString(destination), getGenericString(source), destination.getType(), source.getType(), isFirst, isAddAllFunction, isPutAllFunction);
		
	}
	
	/**
	 * this method verify that the istruction: 
	 * <p><code> destination.addAll(source) </code><p>is permitted 
	 * 
	 * @param destination
	 * @param source
	 * @return true if the istruction destination.addAll(source) is permitted
	 */
	public static boolean isAddAllPermitted(Field destination,Field source){
		
		boolean isFirst = true;
		boolean isAddAllFunction = true;
		boolean isPutAllFunction = false;
		return isAssignableFrom(getGenericString(destination), getGenericString(source), destination.getType(), source.getType(), isFirst, isAddAllFunction, isPutAllFunction);
		
	}
	/**
	 * this method verify that the instruction:
	 * <p><code> destination = source </code>
	 * <p>is permitted, checking their generics also
	 * 
	 * @param destination
	 * @param source
	 * @return true if destination is assignable from source
	 */
	public static boolean isAssignableFrom(Field destination,Field source)  {
		
		boolean isFirst = true;
		boolean isAddAllFunction = false;
		boolean isPutAllFunction = false;
		return isAssignableFrom(getGenericString(destination), getGenericString(source), destination.getType(),source.getType(),isFirst, isAddAllFunction, isPutAllFunction);
		
	}
	
	/**
	 * Returns true if destination is assignable from source analyzing autoboxing also.
	 * @param destination
	 * @param source
	 * @return true if destination is assignable from source analyzing autoboxing also.
	 */
	public static boolean isAssignableFrom(Class<?> destination,Class<?> source){
		return destination.isAssignableFrom(source) || isBoxing(destination,source) || isUnBoxing(destination,source);
	}
	
	/**
	 * Method used from {@link ClassesManager#isAssignableFrom(Field, Field)},{@link ClassesManager#isAddAllPermitted(Field, Field)} and
	 * {@link ClassesManager#isPutAllPermitted(Field, Field)} methods 
	 * @param genericD generic item
	 * @param genericS generic item
	 * @param classD class type of Destination
	 * @param classS class type of Source
	 * @param isFirst true if is first interaction, false otherwise
	 * @param isAddAllFunction true if is an addAll operation, false otherwise
	 * @param isPutAllFunction true if is a putAll operation, false otherwise
	 * @return true if destination field is assignable from source field, false otherwise
	 */
	private static boolean isAssignableFrom(String genericD,String genericS,Class<?> classD,Class<?> classS,boolean isFirst, boolean isAddAllFunction,boolean isPutAllFunction){
	  try{
			
		int dStartBracket = genericD.indexOf("<");
		int sStartBracket = genericS.indexOf("<");
		int dEndBracket   = genericD.lastIndexOf(">");
		int sEndBracket   = genericS.lastIndexOf(">");		
		
		// if there aren't generics
		if(dStartBracket==-1 && sStartBracket==-1 && dEndBracket==-1 && sEndBracket==-1)
			if(isFirst)
				return functionsAreAllowed(isAddAllFunction, isPutAllFunction, classD, classS);
				
			else{
				genericD = genericD.equals("?")?"java.lang.Object":genericD;
				genericS = genericS.equals("?")?"java.lang.Object":genericS;
				return isAssignableFrom(Class.forName(genericD),Class.forName(genericS));
			}
		
		// if generics exists
		if(dStartBracket!=-1 && sStartBracket!=-1 && dEndBracket!=-1 && sEndBracket!=-1){
			
			// destination class
			String dBeforeBracket = genericD.substring(0, dStartBracket).trim();
			// source class
			String sBeforeBracket = genericS.substring(0, sStartBracket).trim();
			// destination class defined in the generic
			String dAfterBracket = genericD.substring(dStartBracket+1,dEndBracket);
			// source class defined in the generic
			String sAfterBracket = genericS.substring(sStartBracket+1,sEndBracket);
			
			boolean isAssignableFrom = isFirst?functionsAreAllowed(isAddAllFunction, isPutAllFunction, classD, classS):
											   isAssignableFrom(Class.forName(dBeforeBracket),Class.forName(sBeforeBracket));
			
			if(isAddAllFunction)
				return isAssignableFrom && isAssignableFrom(dAfterBracket, sAfterBracket, null, null, false, false, false);
			
			if(isPutAllFunction){
				
				int dSplitIndex = pairSplitIndex(dAfterBracket);
				String dKey = dAfterBracket.substring(0, dSplitIndex).trim();
				String dValue = dAfterBracket.substring(dSplitIndex+1).trim();
				
				int sSplitIndex = pairSplitIndex(sAfterBracket);
				String sKey = sAfterBracket.substring(0, sSplitIndex).trim();
				String sValue = sAfterBracket.substring(sSplitIndex+1).trim();
				
				return isAssignableFrom 
				   &&  isAssignableFrom(dKey, sKey, null, null, false, false, false)
				   &&  isAssignableFrom(dValue, sValue, null, null, false, false, false);
			}
			
			return  isAssignableFrom && dAfterBracket.equals(sAfterBracket);
		}
	  }catch (Exception e) { return false; }
	  return false;
	}
	
	/**
	 * Returns true if the function to check is allowed.
	 * @param isAddAllFunction true if addAll method is to check
	 * @param isPutAllFunction true if putAll method is to check
	 * @param classD destination class
	 * @param classS source class
	 * @return true if the function to check is allowed
	 */
	private static boolean functionsAreAllowed(boolean isAddAllFunction, boolean isPutAllFunction,Class<?> classD,Class<?> classS)	{
		
		if(isAddAllFunction)
			return collectionIsAssignableFrom(classD) && collectionIsAssignableFrom(classS);
		
		if(isPutAllFunction)
			return mapIsAssignableFrom(classD) && mapIsAssignableFrom(classS);
	
		return isAssignableFrom(classD,classS);
		
	}
	
	/**
	 * Returns true if is an unboxing operation, false otherwise.
	 * @param destination the primitive Class
	 * @param source the Wrapper Class
	 * @return true if is an unboxing operation, false otherwise
	 */
	public static boolean isUnBoxing(Class<?> destination,Class<?> source){
		return isAutoboxingOperation(unBoxingOperations,destination,source);
	}
	
	/**
	 * Returns  true if is a boxing operation, false otherwise.
	 * @param destination the Wrapper Class
	 * @param source the primitive Class
	 * @return true if is a boxing operation, false otherwise
	 */
	public static boolean isBoxing(Class<?> destination,Class<?> source){
		return isAutoboxingOperation(boxingOperations,destination,source);
	}
	
	/**
	 * @param map Map that contains autoboxing operations, see {@link AutoBoxing#unBoxingOperations} and {@link AutoBoxing#boxingOperations}
	 * @param destination class type of Destination
	 * @param source class type of Source
	 * @return true if operation between destination and source rappresents a map operation
	 */
	private static boolean isAutoboxingOperation( HashMap<String, String[]>  map,Class<?> destination,Class<?> source){
		String[] names = map.get(destination.getName());
		if(names != null)
			for (String name : names) 
				if(name.equals(source.getName())) 
					return true;
					
		return false;
	}
	
	private static int pairSplitIndex(String str){
		
		int openBracket = 0;
		int closedBracket = 0;
		char[] array = str.toCharArray();
		 
		for(int i = 0; i < str.length(); i++){
			char it = array[i];
			
			if(it=='<')openBracket++;
			if(it=='>')closedBracket++;
			if(it==',' && (openBracket - closedBracket) == 0)return i;
		}

		return 0;
	}
	/**
	 * @param field
	 * @return returns a string that specified the structure of the field, including its generic
	 */
	public static String getGenericString(Field field){
		return getGenericString(field.toGenericString());
	}
	
	/**
	 * Splits the fieldDescription to obtain his class type,generics inclusive.
	 * @param fieldDescription String to analyze
	 * @return class type, generics inclusive
	 */
	private static String getGenericString(String fieldDescription){
		
		List<String> splitResult = new ArrayList<String>();
		char[] charResult = fieldDescription.toCharArray();
		
		boolean isFinished = false;
		
		int separatorIndex = fieldDescription.indexOf(" ");
		int previousIndex = 0;
		
		while(!isFinished){
			
			// if previous character is "," don't cut the string
			if(charResult[separatorIndex-1]!=','){
				splitResult.add(fieldDescription.substring(previousIndex, separatorIndex));
				previousIndex = separatorIndex+1;
			}
			
			separatorIndex = fieldDescription.indexOf(" ",separatorIndex+1);
			if(separatorIndex == -1)isFinished = true;
		}
		
		for (String description : splitResult) {
			if(isAccessModifier(description)) continue;
			return description;
		}
		
		return null;
	}
	
	/**
	 * Returns true if destination and source have the same structure.
	 * @param destination
	 * @param source
	 * @return returns true if destination and source have the same structure
	 */
	public static boolean areEqual(Field destination,Field source){
		return getGenericString(destination).equals(getGenericString(source));
	}	
	
	/**
	 * Returns the name of mapper that identifies the destination and source classes.
	 * 
	 * @param destination class of Destination
	 * @param source class of Source
	 * @param path xml path
	 * @return Returns a string containing the names of the classes passed as input
	 */
	public static String mapperClassName(Class<?> destination,Class<?> source,String path){
		String className = destination.getName().replaceAll("\\.","") + source.getName().replaceAll("\\.","");
		if(path != null && path.length()>0){
			String[]dep = path.split("\\\\");
			if(dep.length<=1)dep = path.split("/");
			String xml = dep[dep.length-1];
			className += xml.replaceAll("\\.","").replaceAll(" ","");
		}
		return className;
	}
	
	/**
	 * Returns true if exist a field with this name in aClass, false otherwise.
	 * @param aClass a class to control
	 * @param name field to find
	 * @return true if exist a field with this name in aClass, false otherwise
	 */
	public static boolean existField(Class<?> aClass,String name){
		try { aClass.getDeclaredField(name); return true; } 
		catch (NoSuchFieldException e) {
			Class<?> superclass = aClass.getSuperclass();
			while(superclass != Object.class){
				try { superclass.getDeclaredField(name); return true; } 
				catch (NoSuchFieldException e1) {}
				superclass = superclass.getSuperclass();
			}
			return false;
		}
	}
	
	/**
	 * returns true if almost one class is configured, false otherwise.
	 * @param dClass class to verify
	 * @param sClass class to verify
	 * @return true if almost one class is configured, false otherwise.
	 */
	public static boolean areMappedObjects(Class<?> dClass,Class<?> sClass,XML xml){
		return isMapped(dClass,xml) || isMapped(sClass,xml);
	}
	
	/**
	 * Returns true if the class is configured in annotation or xml, false otherwise.
	 * @param aClass a class
	 * @return true if the class is configured in annotation or xml, false otherwise
	 */
	public static boolean isMapped(Class<?> aClass,XML xml){
		return isMappedInXML(aClass,xml) || isMappedInAnnotation(aClass);
	}
	
	/**
	 * Returns true if the class is configured in xml, false otherwise.
	 * @param aClass a class
	 * @param xml object
	 * @return true if the class is configured in xml, false otherwise
	 */
	public static boolean isMappedInXML(Class<?> aClass, XML xml){
		List<Attribute> attributes = xml.attributesLoad().get(aClass.getName());
		return attributes!= null && !attributes.isEmpty();
	}
	
	/**
	 * Returns true if the class is configured in annotation, false otherwise.
	 * @param aClass a class
	 * @return true if the class is configured in annotation, false otherwise
	 */
	public static boolean isMappedInAnnotation(Class<?> aClass){
		for (Field it : aClass.getDeclaredFields()) 
			if(it.getAnnotation(JMap.class)!=null) 
				return true;
		
		return false;
	}
	
	/**
	 * Returns a list with the class passed in input plus his superclasses.
	 * @param aClass class to check
	 * @return a classes list
	 */
	public static List<Class<?>> getAllsuperclasses(Class<?> aClass){
		List<Class<?>> result = new ArrayList<Class<?>>();
		result.add(aClass);
		Class<?> superclass = aClass.getSuperclass();
		while(superclass != Object.class){
			result.add(superclass);
			superclass = superclass.getSuperclass();
		}
		return result;
	}
	
	/**
	 * Returns a List of aClass fields and all of its super classes.
	 * @param aClass class to handle
	 * @return a list of aClass fields
	 */
	public static List<Field> getListOfFields(Class<?> aClass){
		List<Field> listOfFields = toList(aClass.getDeclaredFields());
		
		Class<?> superclass = aClass.getSuperclass();
		while(superclass != Object.class){
			enrichList(listOfFields, superclass.getDeclaredFields());
			superclass = superclass.getSuperclass();
		}
		
		return listOfFields;
	}
	
	/**
	 * Returns the conversions method belonging to clazz.
	 * @param clazz class to check
	 * @param xml xml object
	 * @return the conversion method list
	 */
	public static List<ConversionMethod> getConversionMethods (Class<?> clazz, XML xml){
		List<ConversionMethod> conversions = new ArrayList<ConversionMethod>();
		Map<String, List<ConversionMethod>> conversionsMap = xml.conversionsLoad();
		for (Class<?> classToCheck : getAllsuperclasses(clazz)){
			List<ConversionMethod> methods = conversionsMap.get(classToCheck.getName());
			if(methods != null)conversions.addAll(methods);
		}
		return conversions;
	}
	
	/**
	 * Returns all methods that belongs to aClass.
	 * @param aClass class to check
	 * @return list of methods
	 */
	public static List<Method> getAllMethods(Class<?> aClass){
		List<Method> listOfMethods = toList(aClass.getDeclaredMethods());
		Class<?> superclass = aClass.getSuperclass();
		
		while(superclass != Object.class){
			listOfMethods = getMethods(listOfMethods, superclass);
			superclass = superclass.getSuperclass();
		}
		
		return listOfMethods;
	}
	
	/**
	 * Used in a recursive context, retuns a list with the existingMethod plus eventually classToCheck's methods
	 * @param existingMethods list of existing methods
	 * @param classToCheck class to check
	 * @return an enriched list
	 */
	private static List<Method> getMethods(List<Method> existingMethods, Class<?> classToCheck){
		List<Method> result = new ArrayList<Method>(existingMethods);
		for (Method methodToCheck : classToCheck.getDeclaredMethods()) 
			for (Method method : existingMethods) 
				if(!method.getName().equals(methodToCheck.getName()))
					result.add(methodToCheck);
		return result;
	}
	
	/**
	 * Returns a field with a specific name from class given as input.
	 * 
	 * @param clazz class to handle
	 * @param fieldName name of field to retrieve
	 * @return field if exist, null otherwise
	 */
	public static Field retrieveField(Class<?> clazz, String fieldName){
		
		for (Field field : getListOfFields(clazz))	
			if(field.getName().equals(fieldName)) 
				return field;
				
		return null;
	}
	
	/**
	 * Verifies that the accessor methods are compliant with the naming convention.
	 * @param clazz a class to check
	 * @param fields fields to control
	 * @see <a href="http://en.wikipedia.org/wiki/JavaBean">javaBean conventions</a>
	 */
	public static void verifiesAccessorMethods(Class<?> clazz, Field... fields){
		verifiesGetterMethods(clazz, fields);
		verifySetterMethods(clazz, fields);
	}
	
	/**
	 * Verifies that the getter methods are compliant with the naming convention.
	 * @param clazz a class to check
	 * @param fields fields to control
	 * @see <a href="http://en.wikipedia.org/wiki/JavaBean">javaBean conventions</a>
	 */
	public static void verifiesGetterMethods(Class<?> clazz, Field... fields){
		String methodName = null;
		String fieldName = null;
		Class<?> fieldType = null;
		
		try{for (Field field : fields) {
				fieldName = field.getName();
				fieldType = field.getType();
				
				methodName = getMethod(fieldType,fieldName);
				clazz.getMethod(methodName);                  }
		}catch(Exception e) 
		   {	Error.method(methodName, fieldName, clazz);   }
	}
	
	/**
	 * Verifies that the setter methods are compliant with the naming convention.
	 * @param clazz a class to check
	 * @param fields fields to control
	 * @see <a href="http://en.wikipedia.org/wiki/JavaBean">javaBean conventions</a>
	 */
	public static void verifySetterMethods(Class<?> clazz, Field... fields){
		String methodName = null;
		String fieldName = null;
		Class<?> fieldType = null;
		
		try{for (Field field : fields) {
				fieldName = field.getName();
				fieldType = field.getType();
				
				methodName = mSet(fieldName);
				clazz.getMethod(methodName,fieldType);        }
		}catch(Exception e) 
			{	Error.method(methodName, fieldName, clazz);   }
	}
	
	/**
	 * returns the location of the configuration, null if both classes are configured. 
	 * @param dItem class to analyze
	 * @param sItem class to analyze
	 * @return the location of the configuration, null if both classes are configured. 
	 */
	public static ChooseConfig configChosen(Class<?>dItem,Class<?>sItem,XML xml){
		return  isMapped(dItem,xml) && isMapped(sItem,xml)?null:
				isMapped(dItem,xml)?ChooseConfig.DESTINATION:ChooseConfig.SOURCE;
	}
	
	/**
	 * Returns the getMethod of the field received in input.
	 * @param clazz class of the field
	 * @param field
	 * @return Method
	 */
	public static Method getMethodOf(Class<?> clazz, String field){
		return methodOf(clazz, retrieveField(clazz,field), true);
	}
	
	/**
	 * Returns the setMethod of the field received in input.
	 * @param clazz class of the field
	 * @param field
	 * @return Method
	 */
	public static Method setMethodOf(Class<?> clazz, String field){
		return methodOf(clazz, retrieveField(clazz,field), false);
	}
	
	/**
	 * Returns the getMethod of the field received in input.
	 * @param clazz class of the field
	 * @param field
	 * @return Method
	 */
	public static Method getMethodOf(Class<?> clazz, Field field){
		return methodOf(clazz, field, true);
	}
	
	/**
	 * Returns the setMethod of the field received in input.
	 * @param clazz class of the field
	 * @param field
	 * @return Method
	 */
	public static Method setMethodOf(Class<?> clazz, Field field){
		return methodOf(clazz, field, false);
	}
	
	/**
	 * If isGet is true, returns get method of the field belong to clazz,
	 * if it is false, returns the set method.
	 * @param clazz class to verify
	 * @param field field to check
	 * @param isGet true if is a get method, false if it is a set method
	 * @return Method requested
	 */
	private static Method methodOf(Class<?> clazz,Field field,boolean isGet) {
		String methodName = null;
		String fieldName = null;
		try {
			fieldName = field.getName();
			
			methodName = isGet ? getMethod(field.getType(),fieldName)
					           : mSet(field.getName());
			
			return isGet ? clazz.getMethod(methodName)
					     : clazz.getMethod(methodName,field.getType());
			
		} catch (Exception e) {	Error.method(methodName, fieldName, clazz); }
		return null;
	}
	
	/**
	 * If the generics written is ? returns the Object class name.
	 * @param structure generics string
	 * @return the content of this generics string
	 */
	private static String obtainGenericContent(String structure){
		String item = structure.substring(structure.indexOf("<")+1, structure.indexOf(">"));
		return item.equals("?")?"java.lang.Object":item;
	}
	
	/**
	 * Extracts the value of a field from an object.<br>
	 * Example:
	 * <code><br>MyClass {
	 * <br>private String aField;
	 * <br> get and set...
	 * <br>}
	 * <br>
	 * <br>String aFieldValue = getFieldValue(new MyClass("example"),"aField");
	 * <br>assertEqual("example",aFieldValue);</code>
	 * @param obj
	 * @param fieldName
	 * @return the value of a field from an object
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getFieldValue(Object obj,String fieldName){
		try {	Field field = obj.getClass().getDeclaredField(fieldName);
				field.setAccessible(true);
				return (T) field.get(obj);
		} catch (Exception e) { return null;}
	}
	
	/**
	 * Extracts the generic class from the type of field given as input.<br>
	 * Example:
	 * <code><br>MyClass {
	 * <br>List&ltString&gt aList;
	 * <br> get and set...
	 * <br>}
	 * <br>
	 * <br>Field aField = MyClass.class.getDeclaredField("aList");
	 * <br>Class<?> generic = getCollectionItemClass(aField);
	 * <br>assertEqual(generic,String.class);</code>
	 * @param generic a Field 
	 * @return a Class contained in the class type of the field, returns null if no generics 
	 */
	public static Class<?> getCollectionItemClass(Field generic) {
		
		String item = obtainGenericContent(getGenericString(generic));
		try {				    return Class.forName(item);
		} catch (Exception e) { return null; }
		
	}	
	
	/**
	 * Extracts the generic class from the type of field given as input.<br>
	 * Example:
	 * <code><br>MyClass {
	 * <br>Map&ltString, Integer&gt aMap;
	 * <br> get and set...
	 * <br>}
	 * <br>
	 * <br>Field aField = MyClass.class.getDeclaredField("aMap");
	 * <br>Class<?> generic = getGenericMapKeyItem(aField);
	 * <br>assertEqual(generic,String.class);</code>
	 * @param generic a Field 
	 * @return a Class contained in the class type of the field
	 */
	public static Class<?> getGenericMapKeyItem(Field generic) {
		String item = obtainGenericContent(getGenericString(generic));
		try { return Class.forName(item.split(",")[0].trim());
		} catch (Exception e) { return null; }
		
	}
	
	/**
	 * Extracts the generic class from the type of field given as input.<br>
	 * Example:
	 * <code><br>MyClass {
	 * <br>Map&ltString, Integer&gt aMap;
	 * <br> get and set...
	 * <br>}
	 * <br>
	 * <br>Field aField = MyClass.class.getGenericMapValueItem("aMap");
	 * <br>Class<?> generic = getGenericMapKeyItem(aField);
	 * <br>assertEqual(generic,Integer.class);</code>
	 * @param generic a Field 
	 * @return a Class contained in the class type of the field
	 */
	public static Class<?> getGenericMapValueItem(Field generic) {
		String item = obtainGenericContent(getGenericString(generic));
		try { return Class.forName(item.split(",")[1].trim());
		} catch (Exception e) { return null; }
		
	}
	/**
	 * Extracts the generic class from the type of field given as input.<br>
	 * Example:
	 * <code><br>MyClass {
	 * <br>MyObj[] anArray;
	 * <br> get and set...
	 * <br>}
	 * <br>
	 * <br>Field aField = MyClass.class.getDeclaredField("anArray");
	 * <br>Class<?> item = getArrayItemClass(aField);
	 * <br>assertEqual(item,MyObj.class);</code>
	 * @param field a Field 
	 * @return a Class contained in the class type of the field
	 */
	public static Class<?> getArrayItemClass(Field field) {
		return field.getType().getComponentType();
	}
	
	/**
	 * Classes key and value will be enhanced with the type of classes of the map.
	 * 
	 * @param field of type map
	 * @param key class of the map
	 * @param value class of the map
	 */
	public static void getKeyValueClasses(Field field,Class<?> key, Class<?> value){
		
		if(!mapIsAssignableFrom(field.getType()))
			throw new IllegalArgumentException("the field is not a map");
		
		String generic = field.toGenericString();
		String[] pair = generic.substring(generic.indexOf("<")+1, generic.indexOf(">")).split(", ");
		
		try {
			key = Class.forName(pair[0].trim());
			value = Class.forName(pair[1].trim());
		} catch (ClassNotFoundException e) {
			key = null;
			value = null;
		}
	}
	
	/**
	 * This method defines the destination structure for this operation.
	 * If destination class is an interface, a relative implementation will be found.
	 * 
	 * @param destination destination field
	 * @param source source field
	 */
	public static Class<?> defineStructure(Field destination, Field source){
		
		Class<?> destinationClass = destination.getType();
		Class<?> sourceClass = source.getType();
		
		Class<?> result = null;
		
		// if destination is an interface
		if(destinationClass.isInterface())
			// if source is an interface
			if(sourceClass.isInterface())
					// retrieves the implementation of the destination interface
					result = (Class<?>) implementationClass.get(destinationClass.getName());
			// if source is an implementation	
			else{
				// retrieves source interface
				Class<?> sourceInterface = sourceClass.getInterfaces()[0];
				// if the destination and source interfaces are equal
				if(destinationClass == sourceInterface)
					// assigns implementation to destination
					result = sourceClass;
				// if they are different
				else
					// destination gets the implementation of his interface
					result = (Class<?>) implementationClass.get(destinationClass.getName());
			}
		// if destination is an implementation
		else
			result = destinationClass;
		
		return result;
	}
}