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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.bidimap.DualHashBidiMap;

import com.googlecode.jmapper.xml.SimplyAttribute;

/**
 * Utility class that allows you to identify the type of classes given as input, 
 * to obtain name of methods starting from name of fields and more useful functions.
 * @author Alessandro Vurro
 *
 */
public final class GeneralUtility {
	
	private GeneralUtility() { }

	/** line separator of this operating system */
	public static final String newLine = System.getProperty("line.separator");
	
	/** file separator of this operating system */
	public static final String fileSeparator = System.getProperty("file.separator");

	/** implementationClass contains the interfaces names as key and their implementation  as value */
	public static final DualHashBidiMap implementationClass = 
			
			new DualHashBidiMap(){

					private static final long serialVersionUID = 8337845542097230683L;

					{
						put(Collection.class.getName(),	ArrayList.class);
						put(List.class.getName(),		ArrayList.class);
						put(Set.class.getName(),		HashSet.class);
						put(Queue.class.getName(), 		LinkedList.class);
						put(SortedSet.class.getName(), 	TreeSet.class);
						put(Map.class.getName(), 		HashMap.class);
						put(SortedMap.class.getName(), 	TreeMap.class);
					}
			};
																
	/** basicTypes contains all the names of primitive and wrapper classes */
	private static final ArrayList<String> basicTypes = 
			
			new ArrayList<String>(){

					private static final long serialVersionUID = -5567529960231273742L;

					{
						add(byte.class.getName());
						add(short.class.getName());
						add(int.class.getName());
						add(long.class.getName());
						add(float.class.getName());
						add(double.class.getName());
						add(char.class.getName());
						add(boolean.class.getName());
						add(Byte.class.getName());
						add(Short.class.getName());
						add(Integer.class.getName());
						add(Long.class.getName());
						add(Float.class.getName());
						add(Double.class.getName());
						add(Character.class.getName());
						add(Boolean.class.getName());
						add(String.class.getName());
					}
			};
	
	/**
	 * Returns true if aClass is a wrapper or primitive class, false otherwise.
	 * @param aClass class to check
	 * @return returns true if aClass is a wrapper or primitive class, false otherwise
	 */
	public static boolean isBasic(Class<?> aClass){
		return basicTypes.contains(aClass.getName());
	}

	/**
	 * Returns true if str is an access modifier, false otherwise.
	 * @param str string to check
	 * @return returns true if str is an access modifier, false otherwise
	 */
	public static boolean isAccessModifier(String str){
		return str.equals("static")    || 
			   str.equals("public")    || 
			   str.equals("protected") ||
			   str.equals("private")   ||
			   str.equals("final")     ||
			   str.equals("transient");
	}
	
	/**
	 * Returns a list equivalent to the array given as input.
	 * 
	 * @param anArrayToConvert a generic Array to convert in a List
	 * @param <T> array type
	 * @return a List
	 */
	public static <T> List<T> toList(T[] anArrayToConvert)	{
		
		ArrayList<T> aListToEnrich = new ArrayList<T>();
		enrichList(aListToEnrich, anArrayToConvert);
		return aListToEnrich;
	}

	/**
	 * Enriches the specified aListToEnrich parameter with the specified anArrayToAdd parameter.
	 * 
	 * @param aListToEnrich a List to enrich
	 * @param anArrayToAdd an array to add
	 * @param <T> list and array type
	 */
	public static <T> void enrichList(List<T> aListToEnrich, T[] anArrayToAdd)	{
		if(anArrayToAdd!=null) aListToEnrich.addAll(Arrays.asList(anArrayToAdd));
	}
	
	/**
	 * Returns true if the specified Class parameter is a Collection, Map or Array, false otherwise.
	 * @param aClass class to check
	 * @return returns true if the specified Class parameter is a Collection, Map or Array, false otherwise
	 * @see GeneralUtility#collectionIsAssignableFrom(Class) collectionIsAssignableFrom
	 * @see GeneralUtility#mapIsAssignableFrom(Class) mapIsAssignableFrom
	 * @see GeneralUtility#isArray(Class) isArray
	 */
	public static boolean isStructure(Class<?> aClass){
		return collectionIsAssignableFrom(aClass) || mapIsAssignableFrom(aClass) || isArray(aClass);
	}
	
	/**
	 * Returns true if both classes are of base type, false otherwise.
	 * @param dClass class to analyze
	 * @param sClass class to analyze
	 * @return true if both classes are of base type, false otherwise.
	 */
	public static boolean areBasic(Class<?> dClass,Class<?> sClass){
		return isBasic(dClass) && isBasic(sClass);
	}

	/**
	 * Determines if the Collection interface is either the same as, or is a superinterface of, 
	 * the class or interface represented by the specified Class parameter. 
	 * It returns true if so; otherwise it returns false.
	 *  
	 * @param aClass  the Class to be checked
	 * @return the boolean value indicating whether objects of the type aClass can be assigned to objects of Collection interface
	 */
	public static boolean collectionIsAssignableFrom(Class<?> aClass){
		return Collection.class.isAssignableFrom(aClass);
	}	
	
	/**
	 * Determines if the Map interface is either the same as, or is a superinterface of, 
	 * the class or interface represented by the specified Class parameter. 
	 * It returns true if so; otherwise it returns false.
	 *  
	 * @param aClass  the Class to be checked
	 * @return the boolean value indicating whether objects of the type aClass can be assigned to objects of Map interface
	 */
	public static boolean mapIsAssignableFrom(Class<?> aClass){
		return Map.class.isAssignableFrom(aClass);
	}	
	
	/**
	 * Determines if the List interface is either the same as, or is a superinterface of, 
	 * the class or interface represented by the specified Class parameter. 
	 * It returns true if so; otherwise it returns false.
	 *  
	 * @param aClass  the Class to be checked
	 * @return the boolean value indicating whether objects of the type aClass can be assigned to objects of List interface
	 */
	public static boolean listIsAssignableFrom(Class<?> aClass){
		return List.class.isAssignableFrom(aClass);
	}
	
	/**
	 * Determines if the SortedSet interface is either the same as, or is a superinterface of, 
	 * the class or interface represented by the specified Class parameter. 
	 * It returns true if so; otherwise it returns false.
	 *  
	 * @param aClass  the Class to be checked
	 * @return the boolean value indicating whether objects of the type aClass can be assigned to objects of SortedSet interface
	 */
	public static boolean sortedSetIsAssignableFrom(Class<?> aClass){
		return SortedSet.class.isAssignableFrom(aClass);
	}
	/**
	 * Determines if the specified Class parameter represents an array class.
	 *  
	 * @param aClass  the Class to be checked
	 * @return true if the specified Class parameter represents an array class; false otherwise.
	 */
	private static boolean isArray(Class<?> aClass){
		return aClass.isArray();
	}
	
	/**
	 * @param fieldName field name
	 * @return returns a getMethod name of the string given in input
	 */
	public static String mGet(String fieldName) {
		return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}
	
	/**
	 * @param fieldName field name
	 * @return returns a setMethod name of the string given in input
	 */
	public static String mSet(String fieldName) {
		return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}
	
	/**
	 * @param fieldName field name
	 * @return returns a isMethod name of the string given in input
	 */
	private static String mIs (String fieldName) {
		return "is"  + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}
	
	/**
	 * if clazz is a boolean, this method calls mIs(field), in other cases this method calls the mGet(field)
	 * @param clazz field class
	 * @param field field
	 * @return a get method name of the field
	 * @see GeneralUtility#mIs(String)
	 * @see GeneralUtility#mGet(String)
	 */
	public static String getMethod(Class<?> clazz,String field){
		return isBoolean(clazz) ? mIs(field):mGet(field);
	}	
	
	/**
	 * @param clazz class to check
	 * @return True if clazz is boolean (primitive or wrapper), false otherwise.
	 */
	public static boolean isBoolean(Class<?> clazz){
		return clazz == boolean.class || clazz == Boolean.class;
	}
	
	/**
	 * Add elements to an ArrayList.
	 * @param elements to be added
	 * @param <E> define items type
	 * @return the collection, given in input, enriched
	 */
	public static <E> ArrayList<E>  list(E...elements ){
		ArrayList<E> list = new ArrayList<E>();
		for (E element : elements)	list.add(element);
		return list;
	}
	
	/**
	 * Returns true if collection is empty, false otherwise.
	 * @param collection collection to check
	 * @return true if collection is empty, false otherwise
	 */
	public static boolean isEmpty(Collection<?> collection){
		return isNull(collection) || collection.isEmpty();
	}
	
	/**
	 * Returns true if the str is empty, false otherwise.
	 * @param str string to check
	 * @return true if the str is empty, false otherwise
	 */
	public static boolean isEmpty(String str){
		return isNull(str) || str.length() <= 0;
	}
	
	/**
	 * Returns true if the str is empty, false otherwise.
	 * @param str string to check
	 * @return true if the str is empty, false otherwise
	 */
	public static boolean isEmpty(StringBuilder str){
		return isNull(str) || str.length() <= 0;
	}
	
	/**
	 * Returns true if the array is empty, false otherwise.
	 * @param array array to check
	 * @return true if the string is empty, false otherwise
	 */
	public static boolean isEmpty(Object[] array){
		return isNull(array) || array.length <= 0;
	}
	
	/**
	 * This method verifies that the line contains all elements.
	 * @param line line to check
	 * @param elements elements to check
	 * @return true if line contains all elements
	 */
	public static boolean containsAll(String line,String... elements){
		for (String element : elements) if(!line.contains(element)) return false;
		return true;
	}
	
	/**
	 * Verifies the presence of the element in array.
	 * @param array array to check
	 * @param element element to search
	 * @return true if element exists in array, false otherwise
	 */
	public static boolean isPresent(SimplyAttribute[] array, SimplyAttribute element){
		if(!isNull(array))
			for (SimplyAttribute item : array)
				if(element.getName().matches(item.getName()))
					return true;
		return false;
	}
	
	/**
	 * Verifies the presence of the element in array.
	 * @param array array to check
	 * @param element element to search
	 * @return true if element exists in array, false otherwise
	 */
	public static boolean isPresent(String[] array, String element){
		if(!isNull(array))
			for (String item : array)
				if(element.matches(item))
					return true;
		return false;
	}
	
	/**
	 * Returns true if the input given as input is null, false otherwise.
	 * @param obj object to check
	 * @return true if the input given as input is null, false otherwise
	 */
	public static boolean isNull(Object obj){
		return obj == null;
	}
	
	/**
	 * Replaces the variables present in the text and returns the result.<br>
	 * Each key will be added to the $ prefix.
	 * @param text text to edit
	 * @param vars map with the string to replace as key and the respective value as value
	 * @return the text resultant
	 */
	public static String replace$ (String text, Map<String, String> vars){
		return replace(text, vars, "$");
	}
	
	/**
	 * Replaces the variables present in the text and returns the result.<br>
	 * @param text text to edit
	 * @param vars map with the string to replace as key and the respective value as value
	 * @param prefix prefix
	 * @return the text resultant
	 */
	private  static String replace (String text, Map<String, String> vars, String prefix){
		for (Entry<String, String> var : vars.entrySet())
				text = text.replaceAll(Pattern.quote(prefix+var.getKey()), Matcher.quoteReplacement(var.getValue()));
		
		return text; 
	}
	
	/**
	 * Semplifies the concatenation of strings
	 * @param strings strings to concatenate
	 * @return string result
	 */
	public static String write(String...strings){
		return write(new StringBuilder(), strings);
	}
	
	/**
	 * Semplifies the concatenation of strings
	 * @param sb an existing StringBuilder to use
	 * @param strings strings to concatenate
	 * @return string result
	 */
	public static String write(StringBuilder sb, String... strings){
		for (String string : strings) 
			sb.append(string);
			
		return sb.toString();
	}
}
