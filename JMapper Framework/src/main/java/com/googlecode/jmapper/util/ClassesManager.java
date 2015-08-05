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

package com.googlecode.jmapper.util;

import static com.googlecode.jmapper.util.AutoBoxing.boxingOperations;
import static com.googlecode.jmapper.util.AutoBoxing.unBoxingOperations;
import static com.googlecode.jmapper.util.FilesManager.isPath;
import static com.googlecode.jmapper.util.GeneralUtility.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.googlecode.jmapper.annotations.Annotation;
import com.googlecode.jmapper.config.Constants;
import com.googlecode.jmapper.config.Error;
import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.operations.beans.MappedField;
import com.googlecode.jmapper.xml.XML;
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
	 * @param destination destination field
	 * @param source source field
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
	 * @param destination destination field
	 * @param source source field
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
	 * @param destination of type {@link MappedField}
	 * @param source of type {@link MappedField}
	 * @return true if destination is assignable from source
	 */
	public static boolean isAssignableFrom(MappedField destination,MappedField source)  {
		return isAssignableFrom(destination.getValue(), source.getValue());
	}
	
	/**
	 * this method verify that the instruction:
	 * <p><code> destination = source </code>
	 * <p>is permitted, checking their generics also
	 * 
	 * @param destination destination field
	 * @param source source field
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
	 * @param destination destination class
	 * @param source source class
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
		
		// destination class
		String dBeforeBracket = "";
		// source class
		String sBeforeBracket = "";
		// destination class defined in the generic
		String dAfterBracket = "";
		// source class defined in the generic
		String sAfterBracket = "";			
		
		// if generics exists
		if(dStartBracket!=-1 && dEndBracket!=-1){
			// destination class
			dBeforeBracket = genericD.substring(0, dStartBracket).trim();
			// destination class defined in the generic
			dAfterBracket = genericD.substring(dStartBracket+1,dEndBracket);
		}
		
		// if generics exists
		if(sStartBracket!=-1 && sEndBracket!=-1){
			// source class
			sBeforeBracket = genericS.substring(0, sStartBracket).trim();
			// source class defined in the generic
			sAfterBracket = genericS.substring(sStartBracket+1,sEndBracket);
		}
		
		if(isEmpty(dBeforeBracket) && !isEmpty(sBeforeBracket))
			dBeforeBracket = genericD;
		
		if(!isEmpty(dBeforeBracket) && isEmpty(sBeforeBracket))
			sBeforeBracket = genericS;
		
		boolean isAssignableFrom = false;
		
		if(!isEmpty(dBeforeBracket) && !isEmpty(sBeforeBracket))
			isAssignableFrom = isFirst?functionsAreAllowed(isAddAllFunction, isPutAllFunction, classD, classS):
									   isAssignableFrom(Class.forName(dBeforeBracket),Class.forName(sBeforeBracket));
		
			if(!isEmpty(dAfterBracket) && !isEmpty(sAfterBracket)){
				
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
			
			return isAssignableFrom;
	  }catch (Exception e) { return false; }
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
	
	/**
	 * @param str string to split
	 * @return pair split index
	 */
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
	 * Splits the fieldDescription to obtain his class type,generics inclusive.
	 * @param field field to check
	 * @return returns a string that specified the structure of the field, including its generic
	 */
	public static String getGenericString(Field field){
		
		String fieldDescription = field.toGenericString();
		List<String> splitResult = new ArrayList<String>();
		char[] charResult = fieldDescription.toCharArray();
		
		boolean isFinished = false;
		int separatorIndex = fieldDescription.indexOf(" ");
		int previousIndex = 0;
		
		while(!isFinished){
			
			// if previous character is "," don't cut the string
			int position = separatorIndex-1;
			char specialChar = charResult[position];
			boolean isSpecialChar = true;
			if(specialChar!=',' && specialChar != '?'){ 
				
				if(specialChar == 's'){
					String specialString = null;
					try{
						specialString = fieldDescription.substring(position - "extends".length(), position+1);
						if(isNull(specialString) || !specialString.equals(" extends"))
							isSpecialChar = false;
					
					}catch(IndexOutOfBoundsException e){
						isSpecialChar = false;
					}
				
				}else
					isSpecialChar = false;
			}
			
			if(!isSpecialChar){
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
	 * @param destination destination field
	 * @param source source field
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
	 * @param resource a resource that represents an xml path or a content
	 * @return Returns a string containing the names of the classes passed as input
	 */
	public static String mapperClassName(Class<?> destination, Class<?> source, String resource){
		
		String className = destination.getName().replaceAll("\\.","") + source.getName().replaceAll("\\.","");
		
		if(isEmpty(resource)) 
			return className;
		
		// if resource is a content, the mapper must be regenerated, 
		// to ensure this, to the name is appended a random integer
		if(!isPath(resource))
			return write(className, String.valueOf(resource.hashCode()));
		
		String[]dep = resource.split("\\\\");
		if(dep.length<=1)dep = resource.split("/");
		String xml = dep[dep.length-1];
		return write(className, xml.replaceAll("\\.","").replaceAll(" ",""));
	}
	
	/**
	 * Returns the field name if exist a field that match with this name in aClass, null otherwise.
	 * @param aClass a class to control
	 * @param name field to find
	 * @return true if exist a field with this name in aClass, false otherwise
	 */
	public static String existField(Class<?> aClass,String name){
		String result = getField(aClass, name);
		
		if(!isNull(result)) 
			return result;
		
		Class<?> superclass = aClass.getSuperclass();
		while(superclass != Object.class){
			result = getField(superclass, name);
			if(!isNull(result)) 
				return result;
			superclass = superclass.getSuperclass();
		}
		return result;
	}
	
	private static String getField(Class<?> aClass,String regex){
		for (Field field : aClass.getDeclaredFields()) 
			if(field.getName().matches(regex)) return field.getName();
		return null;
	}
	
	/**
	 * returns true if almost one class is configured, false otherwise.
	 * @param dClass class to verify
	 * @param sClass class to verify
	 * @param xml xml to check
	 * @return true if almost one class is configured, false otherwise.
	 */
	public static boolean areMappedObjects(Class<?> dClass,Class<?> sClass,XML xml){
		return isMapped(dClass,xml) || isMapped(sClass,xml);
	}
	
	/**
	 * Returns true if the class is configured in annotation or xml, false otherwise.
	 * @param aClass a class
	 * @param xml xml to check
	 * @return true if the class is configured in annotation or xml, false otherwise
	 */
	private static boolean isMapped(Class<?> aClass,XML xml){
		return xml.isMapped(aClass) || Annotation.isMapped(aClass);
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
	 * Returns a List of aClass fields and all fields of its super classes.
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
		
		return excludeSerialVersionUID(
			      excludeSyntethicFields(listOfFields)
			   );
	}
	
	/**
	 * It exclude from list all synthetic fields.
	 * @param listOfFields list to check
	 * @return filtered list
	 */
	private static List<Field> excludeSyntethicFields(List<Field> listOfFields){
		List<Field> listOfNotSyntethicFields = new ArrayList<Field>();
		for (Field field : listOfFields) 
			if(!field.isSynthetic())
				listOfNotSyntethicFields.add(field);
		
		return listOfNotSyntethicFields;
	}
	
	/**
	 * It exclude from list the serialVersionUID field.
	 * @param listOfFields list to check
	 * @return filtered list
	 */
	private static List<Field> excludeSerialVersionUID(List<Field> listOfFields){
		Field serialVersionUID = null;
		for (Field field : listOfFields) 
			if("serialVersionUID".equals(field.getName())){
				serialVersionUID = field;
				break;
			}
		
		if(!isNull(serialVersionUID))
			listOfFields.remove(serialVersionUID);
		
		return listOfFields;
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
	 */
	public static void verifiesAccessorMethods(Class<?> clazz, MappedField... fields){
		verifyGetterMethods(clazz, fields);
		verifySetterMethods(clazz, fields);
	}
	
	/**
	 * Verifies that the getter methods are compliant with the naming convention.
	 * @param clazz a class to check
	 * @param fields fields to control
	 */
	public static void verifyGetterMethods(Class<?> clazz, MappedField... fields){
		
		for (MappedField field : fields) {
			
			String fieldName = field.getName();
			Class<?> fieldType = field.getType();

			// find custom get first
			String customGet = field.getMethod();
			if(!isNull(customGet) && !customGet.equals(Constants.DEFAULT_ACCESSOR_VALUE))
				
				try{					clazz.getMethod(customGet);
										// store the getMethod name
										field.getMethod(customGet);
										continue;
				}catch(Exception e) {	Error.customMethod("get", customGet, clazz);	}
			
			String methodName = getMethod(fieldType,fieldName);
			
			try{						clazz.getMethod(methodName);  
			}catch(Exception e) {	
					
				if(!isBoolean(fieldType)) Error.method(methodName, fieldName, clazz);   
				
				try {	//in case of boolean field i try to find get method
						methodName = (mGet(fieldName));
						clazz.getMethod(methodName);
				} catch (Exception e1) {  Error.method(methodName, fieldName, clazz);  }

			}
			
			// store the getMethod name
			field.getMethod(methodName);
		}
	}

	/**
	 * Find and store setter methods.
	 * @param clazz a class to check
	 * @param fields fields to control
	 */
	public static void findSetterMethods(Class<?> clazz, MappedField... fields){
		try{verifySetterMethods(clazz, fields);
		}catch(Exception e){}
		
	}
	
	/**
	 * Verifies that the setter methods are compliant with the naming convention.
	 * @param clazz a class to check
	 * @param fields fields to control
	 */
	private static void verifySetterMethods(Class<?> clazz, MappedField... fields){
		String methodName = null;
		String fieldName = null;
		Class<?> fieldType = null;
		
		try{for (MappedField field : fields) {
			
				fieldName = field.getName();
				fieldType = field.getType();
				
				// find custom set first
				String customSet = field.setMethod();
				if(!isNull(customSet) && !customSet.equals(Constants.DEFAULT_ACCESSOR_VALUE))
							
					try{					clazz.getMethod(customSet,fieldType);  
											// store the setMethod name
											field.setMethod(customSet);   
											continue;
					}catch(Exception e) {	Error.customMethod("set", customSet, clazz);	}
						
				
				methodName = mSet(fieldName);
				clazz.getMethod(methodName,fieldType); 
				// store the setMethod name
				field.setMethod(methodName);                  }
		}catch(Exception e) 
			{	Error.method(methodName, fieldName, clazz);   }
	}
	
	/**
	 * returns the location of the configuration, null if both classes are configured. 
	 * @param dItem class to analyze
	 * @param sItem class to analyze
	 * @param xml mapping xml 
	 * @return the location of the configuration, null if both classes are configured. 
	 */
	public static ChooseConfig configChosen(Class<?>dItem,Class<?>sItem,XML xml){
		return  isMapped(dItem,xml) && isMapped(sItem,xml)?null:
				isMapped(dItem,xml)?ChooseConfig.DESTINATION:ChooseConfig.SOURCE;
	}
	
	/**
	 * If the generics written is ? returns the Object class name.
	 * @param structure generics string
	 * @return the content of this generics string
	 */
	private static String obtainGenericContent(String structure){
		String item = structure.substring(structure.indexOf("<")+1, structure.indexOf(">"));
		int internalGeneric = item.indexOf("<");
		if(internalGeneric != -1)
			item = item.substring(0, internalGeneric);
		
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
	 * @param obj used to obtain relative class
	 * @param fieldName field name
	 * @param <T> used to avoid explicit cast
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
	 * Extracts the generic class from the type of Mappedfield given as input.<br>
	 * Example:
	 * <code><br>MyClass {
	 * <br>List&lt;String&gt; aList;
	 * <br> get and set...
	 * <br>}
	 * <br>
	 * <br>Field aField = MyClass.class.getDeclaredField("aList");
	 * <br>Class&lt;?&gt; generic = getCollectionItemClass(aField);
	 * <br>assertEqual(generic,String.class);</code>
	 * @param generic a Field 
	 * @return a Class contained in the class type of the field, returns null if no generics 
	 */
	public static Class<?> getCollectionItemClass(MappedField generic) {
		return getCollectionItemClass(generic.getValue());
	}	
	
	/**
	 * Extracts the generic class from the type of field given as input.<br>
	 * Example:
	 * <code><br>MyClass {
	 * <br>List&lt;String&gt; aList;
	 * <br> get and set...
	 * <br>}
	 * <br>
	 * <br>Field aField = MyClass.class.getDeclaredField("aList");
	 * <br>Class&lt;?&gt; generic = getCollectionItemClass(aField);
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
	 * Extracts the generic class from the type of Mappedfield given as input.<br>
	 * Example:
	 * <code><br>MyClass {
	 * <br>Map&lt;String, Integer&gt; aMap;
	 * <br> get and set...
	 * <br>}
	 * <br>
	 * <br>Field aField = MyClass.class.getDeclaredField("aMap");
	 * <br>Class&lt;?&gt; generic = getGenericMapKeyItem(aField);
	 * <br>assertEqual(generic,String.class);</code>
	 * @param generic a Field 
	 * @return a Class contained in the class type of the field
	 */
	public static Class<?> getGenericMapKeyItem(MappedField generic) {
		return getGenericMapKeyItem(generic.getValue());
	}
	
	/**
	 * Extracts the generic class from the type of Mappedfield given as input.<br>
	 * Example:
	 * <code><br>MyClass {
	 * <br>Map&lt;String, Integer&gt; aMap;
	 * <br> get and set...
	 * <br>}
	 * <br>
	 * <br>Field aField = MyClass.class.getDeclaredField("aMap");
	 * <br>Class&lt;?&gt; generic = getGenericMapKeyItem(aField);
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
	 * Extracts the generic class from the type of Mappedfield given as input.<br>
	 * Example:
	 * <code><br>MyClass {
	 * <br>Map&lt;String, Integer&gt; aMap;
	 * <br> get and set...
	 * <br>}
	 * <br>
	 * <br>Field aField = MyClass.class.getGenericMapValueItem("aMap");
	 * <br>Class&lt;?&gt; generic = getGenericMapKeyItem(aField);
	 * <br>assertEqual(generic,Integer.class);</code>
	 * @param generic a Field 
	 * @return a Class contained in the class type of the field
	 */
	public static Class<?> getGenericMapValueItem(MappedField generic) {
		return getGenericMapValueItem(generic.getValue());
	}
	
	/**
	 * Extracts the generic class from the type of field given as input.<br>
	 * Example:
	 * <code><br>MyClass {
	 * <br>Map&lt;String, Integer&gt; aMap;
	 * <br> get and set...
	 * <br>}
	 * <br>
	 * <br>Field aField = MyClass.class.getGenericMapValueItem("aMap");
	 * <br>Class&lt;?&gt; generic = getGenericMapKeyItem(aField);
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
	 * <br>Class&lt;?&gt; item = getArrayItemClass(aField);
	 * <br>assertEqual(item,MyObj.class);</code>
	 * @param field a Field 
	 * @return a Class contained in the class type of the field
	 */
	public static Class<?> getArrayItemClass(MappedField field) {
		return field.getType().getComponentType();
	}
	
	/**
	 * Retrieves (from a field of map type) the key and value classes.
	 * 
	 * @param field to analyze
	 * @param key key class
	 * @param value value class
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
	
	
}