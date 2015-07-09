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

import static com.googlecode.jmapper.config.ResourceLoader.loadResource;
import static com.googlecode.jmapper.util.GeneralUtility.containsAll;
import static com.googlecode.jmapper.util.GeneralUtility.fileSeparator;
import static com.googlecode.jmapper.util.GeneralUtility.isEmpty;
import static com.googlecode.jmapper.util.GeneralUtility.list;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.googlecode.jmapper.annotations.JGlobalMap;
import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapAccessor;
import com.googlecode.jmapper.annotations.JMapAccessors;
import com.googlecode.jmapper.config.Error;
import com.googlecode.jmapper.exceptions.JMapperException;
import com.googlecode.jmapper.exceptions.LoadingFileException;
import com.googlecode.jmapper.xml.Attribute;
import com.googlecode.jmapper.xml.Global;
import com.googlecode.jmapper.xml.SimplyAttribute;
import com.googlecode.jmapper.xml.beans.XmlJmapper;
import com.thoughtworks.xstream.XStream;

import static com.googlecode.jmapper.util.GeneralUtility.*;
/**
 * FilesManager provides all the operations that allow the manipulation of files.
 *
 * @author Alessandro Vurro
 *
 */
public class FilesManager {
	
	/** application root */
	private static final String applicationRoot = "."+fileSeparator;
	
	/**
	 * This method adds the configurations present in the xml file in the Class.
	 * @param path path of the file that represents the class
	 * @param global global mapping
	 * @param attributes attributes of this Class
	 * @param aClass class to rewrite
	 * @throws NoSuchFieldException 
	 * @throws IOException  
	 */	
	public static void addConfigurationToClass(String path,Global global,List<Attribute> attributes,Class<?> aClass) throws NoSuchFieldException, IOException {
		writeFile(new File(path),linesToWrite(path, global, attributes, aClass));
	}
	
	/**
	 * This method returns the lines of the file enriched with annotations.
	 * @param path path of the file that represents the class
	 * @param global global mapping
	 * @param attributes attributes of this Class
	 * @param aClass class to rewrite
	 * @return list of liness to write
	 * @throws NoSuchFieldException 
	 * @throws IOException  
	 */	
	private static List<String> linesToWrite(String path,Global global,List<Attribute> attributes,Class<?> aClass) throws NoSuchFieldException, IOException {
		
		// strings used to identify the class
		String[] classIdentifier = new String[]{"class","{",aClass.getSimpleName()};
		
		// true if lines belong to aClass
		boolean classFound = false;
									
		// verifies that all attributes exist in the class
		verifyAttributes(aClass, attributes);
		
		// retrieves the name and type of each configured field
		HashMap<String, String> attributeTypes = getTypes(aClass, attributes);
		
		// lines to write
		List<String> linesToWrite = new ArrayList<String>();
		
		// lines of the file
		List<String> lines = readFile(new File(path));
		
		// adds of the JMap import
		
		if(!isEmpty(attributes)){
			lines = addImport(lines,aClass, JMap.class);
			// adds of the target classes import
			lines = addTargetClassesImport(lines, attributes,aClass);
		}
		
		if(!isNull(global))
			lines = addImport(lines,aClass, JGlobalMap.class);
		
		if(containtsAccessors(global,attributes)){
			lines = addImport(lines,aClass, JMapAccessor.class);
			lines = addImport(lines,aClass, JMapAccessors.class);
		}
		
		for (String line : lines) {
			
			// If the class declaration has been found
			if(containsAll(line, classIdentifier)){
				// adds the annotation to class
				if(global != null)
					linesToWrite.add(toAnnotation(global));
				classFound = true;
			}
			
			
			if(classFound && !isEmpty(attributes)){
				Attribute remove = null;
				for (Attribute attribute : attributes) {
					String name = attribute.getName();
					String type = attributeTypes.get(name);
					if(containsAll(line,name,type) && !line.contains("{")){
						// adds the annotation to variable
						linesToWrite.add(toAnnotation(attribute));
						remove = attribute;
					}
				}
				if(remove != null)
					attributes.remove(remove);
				
			}
			linesToWrite.add(line);
		}
		
		return linesToWrite;
	}
	
	/**
	 * Returns true if global or attributes containts almost one declaration of custom methods accessor
	 * @param global
	 * @param attributes
	 * @return
	 */
	private static boolean containtsAccessors(Global global,
			List<Attribute> attributes) {
		
		if(!isNull(global)){
			if(!isEmpty(global.getGet()) || !isEmpty(global.getSet()))
				return true;
			
			if(!isEmpty(global.getAttributes()))
				for (SimplyAttribute attribute : global.getAttributes()) 
					if(!isEmpty(attribute.getGet()) || !isEmpty(attribute.getSet()))
						return true;
		}
		
		if(!isEmpty(attributes))
			for (Attribute attribute : attributes) {
				
				if(!isEmpty(attribute.getGet()) || !isEmpty(attribute.getSet()))
					return true;
				
				if(!isEmpty(attribute.getAttributes()))
					for (SimplyAttribute targetAttribute : attribute.getAttributes()) 
						if(!isEmpty(targetAttribute.getGet()) || !isEmpty(targetAttribute.getSet()))
							return true;
			}
		
		return false;
	}

	/**
	 * This method transforms an Global in an annotation in String format.
	 * @param global Global mapping to trasform
	 * @return an annotation in String format
	 */
	private static String toAnnotation(Global global){
		
		// accessors definition
		Attribute attribute = new Attribute(global.getValue(), global.getAttributes());
		attribute.setGet(global.getGet());
		attribute.setSet(global.getSet());
		String accessor = toJMapAccessor(attribute);
		StringBuilder str = new StringBuilder();
		if(!isEmpty(accessor))
			str.append(accessor);
		
		str.append("@JGlobalMap(");
		
		boolean before = false;
		if(global.getValue()!=null){
			str.append("value=\""+global.getValue()+"\"");
			before = true;
		}
		
		SimplyAttribute[] attributes = global.getAttributes();
		if(attributes!=null){
			if(before)str.append(", ");
			else before = true;
			str.append("attributes={");
			for (int i = 0; i < attributes.length; i++) {
				str.append("\""+attributes[i].getName()+"\"");
				if(i<attributes.length-1)str.append(", ");
			}
			str.append("}");
		}
					
		Class<?>[] classes = global.getClasses();
		if(classes!=null){
			if(before)str.append(", ");
			else before = true;
			str.append("classes={");
			for (int i = 0; i < classes.length; i++) {
				str.append(classes[i].getSimpleName()+".class");
				if(i<classes.length-1)str.append(", ");
			}
			str.append("}");
		}
		
		String[] excluded = global.getExcluded();
		if(excluded!=null){
			if(before)str.append(", ");
			str.append("excluded={");
			for (int i = 0; i < excluded.length; i++) {
				str.append("\""+excluded[i]+"\"");
				if(i<excluded.length-1)str.append(", ");
			}
			str.append("}");
		}
			
		str.append(")");
		// If the brackets are empty, returns @JGlobalMap
		if("@JGlobalMap()".equals(str.toString()))return "@JGlobalMap";
		return str.toString();
	}
	
	/**
	 * Build @JMap annotation from Attribute.
	 * @param attribute
	 * @return
	 */
	private static String toJMap(Attribute attribute){
		boolean before = false;
		StringBuilder str = new StringBuilder("@JMap(");
		if(attribute.getValue()!=null){
			str.append("value=\""+attribute.getValue().getName()+"\"");
			before = true;
		}
		
		SimplyAttribute[] attributes = attribute.getAttributes();
		if(attributes!=null){
			if(before)str.append(", ");
			else before = true;
			str.append("attributes={");
			for (int i = 0; i < attributes.length; i++) {
				str.append("\""+attributes[i].getName()+"\"");
				if(i<attributes.length-1)str.append(", ");
			}
			str.append("}");
		}
					
		Class<?>[] classes = attribute.getClasses();
		if(classes!=null){
			if(before)str.append(", ");
			str.append("classes={");
			for (int i = 0; i < classes.length; i++) {
				str.append(classes[i].getSimpleName()+".class");
				if(i<classes.length-1)str.append(", ");
			}
			str.append("}");
		}
		str.append(")");
		// If the brackets are empty, returns @JMap
		if("@JMap()".equals(str.toString()))return "@JMap";
		return str.toString();
	}
	
	private static String toJMapAccessor(String get, String set, String name){
		if(isEmpty(get) && isEmpty(set))  return "";
		
		StringBuilder str = new StringBuilder("@JMapAccessor(name=\""+name+"\"");

		if(!isEmpty(get))
			str.append(", get=\""+get+"\"");
		
		if(!isEmpty(set))
			str.append(", set=\""+set+"\"");
		
		str.append(")");
		return str.toString();
	}
	
	/**
	 * From SimplyAttribute to relative Annotation
	 * @param attribute
	 * @return
	 */
	private static String toJMapAccessor(SimplyAttribute attribute){
		String get = attribute.getGet();
		String set = attribute.getSet();
		String name = attribute.getName();
		return toJMapAccessor(get, set, name);
	}
	
	/**
	 * From an Attribute to relative Annotation
	 * @param attribute
	 * @return
	 */
	private static String toJMapAccessor(Attribute attribute){
		String get = attribute.getGet();
		String set = attribute.getSet();
		String name = attribute.getName();
		
		StringBuilder result = new StringBuilder("@JMapAccessors({");
		if(!isNull(attribute.getAttributes()))
			for (SimplyAttribute targetAtr : attribute.getAttributes()){
				String accessor = toJMapAccessor(targetAtr);
				if(!isEmpty(accessor))
					result.append("\n   "+accessor+",");
			}
		
		
		String accessor = toJMapAccessor(get, set, name);
		if(!isEmpty(accessor))
			result.append("\n   "+accessor);
		else
			if(result.toString().equals("@JMapAccessors({")) 
				return "";
			else
				// deleted last comma
				result = new StringBuilder(result.substring(0, result.length()-1));
			
		
		return result.append("\n})\n").toString();
	}
	/**
	 * This method transforms an Attribute in an annotation in String format.
	 * @param attribute Attribute to trasform
	 * @return an annotation in String format
	 */
	private static String toAnnotation(Attribute attribute){
		
		String accessor = toJMapAccessor(attribute);
		String jMap = toJMap(attribute);
		
		StringBuilder result = new StringBuilder();
		
		if(!isEmpty(accessor))
			result.append(accessor);
		
		if(!isEmpty(jMap))
			result.append(jMap);
		
		return result.toString();
		
	}
	
	/**
	 * Returns a Map with name of the attribute as key and type of the attribute as value.
	 * @param clazz Class to analyze
	 * @param attributes attributes to analyze
	 * @return a Map with name of the attribute as key and type of the attribute as value
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	private static HashMap<String, String> getTypes(Class<?> clazz, List<Attribute> attributes) throws SecurityException, NoSuchFieldException{
		HashMap<String, String> result = new HashMap<String, String>(attributes.size());
		for (Attribute attribute : attributes) {
			String attributeName = attribute.getName();
			String attributeType = getType(clazz.getDeclaredField(attributeName));
			result.put(attributeName, attributeType);
		}
		return result;
	}
	
	/**
	 * Returns a String that rappresent the type of the Field given as input.
	 * @param field Field to analyze
	 * @return a type of the field in String format
	 */
	private static String getType(Field field){
		String[] dep = field.getType().toString().split(" ");
		dep = dep[dep.length-1].split("\\.");
		return dep[dep.length-1];
	}
	
	/**
	 * This method verifies that the attributes exist in the Class.
	 * @param clazz Class to analyze
	 * @param attributes attributes to analyzez
	 * @throws NoSuchFieldException
	 */
	private static void verifyAttributes(Class<?> clazz, List<Attribute> attributes) throws NoSuchFieldException {
		for (Attribute attribute : attributes) {
			// ottengo il campo dal nome, se non esiste lancio una exception
			try { clazz.getDeclaredField(attribute.getName());}
			catch (SecurityException e) {throw e;} 
			catch (NoSuchFieldException e) {
				Class<?> superclass = clazz.getSuperclass();
				boolean founded = false;
				while(superclass != Object.class && !founded){
					try {	superclass.getDeclaredField(attribute.getName());
							founded = true;
					} catch (NoSuchFieldException e1) {}
					superclass = superclass.getSuperclass();
				}
				if(!founded)throw e;
			}
		}
	}
	
	/**
	 * This method rewrite the file without annotations.
	 * @param file file to rewrite
	 * @param aClass Class that represent the file
	 * @param cleanAll true if all annotation should be delete, false otherwise
	 * @throws IOException in case of read or write errors
	 */
	public static void cleanClass(File file,Class<?> aClass,boolean cleanAll) throws IOException{
		writeFile(file,linesToWrite(file, aClass, cleanAll));
	}

	/**
	 * This method clean the file from annotations and returns a List with the resultant lines.
	 * @param file File to read and clean
	 * @param aClass Class that rappresents this file
	 * @param cleanAll true if all annotation should be deleted, false otherwise
	 * @return a List with lines to write
	 * @throws IOException
	 */
	private static List<String> linesToWrite(File file,Class<?> aClass,boolean cleanAll) throws IOException{
		
		// strings used to identify the class
		String[] classIdentifier = new String[]{"class","{",aClass.getSimpleName()};
		// lines to write
		List<String> linesToWrite = new ArrayList<String>();
		// previous line
		String previousLine = ":-P";
		// true if lines belong to aClass
		boolean classFound = false;
		// true if a class definition was found
		boolean classDefinitionFound = false;
		// true if annotation is written on more lines
		boolean moreLines = false;
		// number of annotated fields
		int annotatedFields = annotatedFieldsNumber(aClass);
		
		for (String line : readFile(file)) {

			// If the class declaration has been found
			if(containsAll(line, classIdentifier))
				classFound = true;
			
			if(containsAll(line, "class","{") && !containsAll(line,"="))
				classDefinitionFound = true;
			
			// if line contains JGlobalMap configuration or if this annotation is written on more lines
			if(!globalToClean(line) && globalToClean(previousLine)){
				if(moreLines){
					if((cleanAll && classDefinitionFound) || classFound){
						HashMap<String,Object> cleanLine = cleanLine(previousLine,moreLines,JGlobalMap.class);
						boolean newLine = (Boolean) cleanLine.get("newLine");
						String result = (String) cleanLine.get("result");
						
						if(result != null)
							linesToWrite.add(result);
						
						previousLine = line;
						moreLines = newLine;
						if(!newLine){
							linesToWrite.add(line);
						}
						continue;
					}
				}
				if(!classFound || (cleanAll && !classDefinitionFound)){
					linesToWrite.add(previousLine);
					linesToWrite.add(line);
					previousLine = line;
					classDefinitionFound = false;
					continue;
				}
				linesToWrite.add(line);
				previousLine = line;
				continue;
			}
			
			if(globalToClean(line)){
				previousLine = line;
				continue;
			}
			
			// if line contains JMap configuration or if this annotation is written on more lines
			if(attributeToClean(line) || moreLines){
				
				if(cleanAll || (classFound && annotatedFields > 0)){
					
					HashMap<String,Object> cleanLine = cleanLine(line,moreLines,JMapAccessors.class,JMapAccessor.class,JMap.class);
					boolean newLine = (Boolean) cleanLine.get("newLine");
					String result = (String) cleanLine.get("result");
					
					if(result != null)
						linesToWrite.add(result);
					
					moreLines = newLine;
					// countdown is done when we need to clean specific fields
					if(!cleanAll && !moreLines && !newLine)annotatedFields--;
					continue;
				}
			}
			
			if(line.trim().equals("})"))
				continue;

			linesToWrite.add(line);
		}
		
		// delete of JMap import
		linesToWrite = deleteImport(linesToWrite);
		
		return linesToWrite;
	}

	/**
	 * This method clean line from annotation.
	 * @param line line to clean
	 * @param moreLines true if annotation is written on more lines
	 * @annotation annotation to remove
	 * @return an HashMap with two variables: newLine and result
	 */
	private static HashMap<String, Object> cleanLine(String line,boolean moreLines, Class<?>... annotation){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("newLine", moreLines);
		map.put("result", null);
		
		// if the annotation is written on more lines
		// check the closure of the annotation
		if(moreLines){
			String result = verifyLine(line);
			if(!"newLine".equals(result)){
				map.put("newLine", false);
				if(result.trim().length()>0 && !result.trim().equals(","))
					map.put("result", result);
			}
			return map;
		}
		
		// cleans the line from the annotation
		String result = subtractAnnotation(line, annotation);
		// if the line ends with "newLine" the annotation is written on more lines
		if(result.endsWith("newLine")){
			map.put("newLine", true);
			result = result.substring(0,result.length() - "newLine".length());
		}
		
		if(result.trim().length()>0)
			map.put("result", result);
		
		return map;
	}
	
	/**
	 * @param line line to analyze
	 * @return true if the line contains a JMap configuration, false otherwise
	 */
	private static boolean attributeToClean(String line){
		String jmap = "@"+JMap.class.getSimpleName();
		if(!line.contains(jmap))return false;
		return true;
	}

	/**
	 * @param line line to analyze
	 * @return true if the line contains a JGlobalMap configuration, false otherwise
	 */
	private static boolean globalToClean(String line){
		if(!line.contains("@"+JGlobalMap.class.getSimpleName()))return false;
		return true;
	}
	/**
	 * @param line
	 * @return a String that contains "newLine" if annotation is written on more lines
	 */
	private static String verifyLine(String line){
		Integer end = line.indexOf(')');
		if(end == -1)return "newLine";
		if(line.length() > ++end)return	line.substring(end, line.length());
		return "";
	}

	/**
	 * It cleans line from annotation.
	 * @param line line to analyze
	 * @param annotation annotation to remove
	 * @return the line cleaned
	 */
	private static String subtractAnnotation(String line, Class<?>... annotations){
		String jmap = null;
		int jmapBegin = -1;
		String result = "";
		
		for (Class<?> annotation : annotations) {
			jmap = "@"+annotation.getSimpleName();
			jmapBegin = line.indexOf(jmap);
			if(jmapBegin != -1)break;
		}
		
		// if there is something before the annotation, it retrieves
		if(jmapBegin>0)result = line.substring(0,jmapBegin);
				
		jmapBegin+=jmap.length();
		// if there is nothing after the annotation, returns result
		if(line.length() <= jmapBegin) return result;
		
		int apertura = line.indexOf('(',jmapBegin);
		// if there is no opening parenthesis of jmap, it adds the remaining line to result
		if(apertura == -1)
			return result += line.substring(jmapBegin,line.length());
		
		// it verifies that there are only spaces between the brackets and the annotation
		else if(apertura > jmapBegin + 1)
			for (char c : line.substring(jmapBegin, apertura).toCharArray()) 
				if(c != ' ')return result += line.substring(jmapBegin,line.length()); 
		
		// it looks for the closure of the annotation
		Integer jmapEnd = line.indexOf(')', jmapBegin);
		// if the closure does not exist, it means that the annotation is written on several lines
		if(jmapEnd == -1) return result+"newLine";
		
		// if the closure exists, add to the result string remaining
		if(line.length() > ++jmapEnd){
			String afterAnnotation = line.substring(jmapEnd,line.length());
			if(!afterAnnotation.trim().equals(","))
			   return result += afterAnnotation;
		}
		return result;
	}
	
	/**
	 * Returns tha number of annotated fields belong to the Class given in input.
	 * @param aClass Class to analyze
	 * @return  the number of annotated fields
	 */
	private static int	annotatedFieldsNumber(Class<?> aClass){
		int count = 0;
		for (Field it : aClass.getDeclaredFields()) 
			if(it.getAnnotation(JMap.class)!=null)count++;
		return count;
	}

	/**
	 * This method adds to lines the import of target classes.
	 * @param lines lines to enrich
	 * @param attributes attributes to analyze
	 * @param aClass Class in question
	 * @return lines enriched
	 */
	private static List<String> addTargetClassesImport(List<String> lines,List<Attribute> attributes,Class<?> aClass){
		
		List<Class<?>> classes = new ArrayList<Class<?>>();
		
		// get all the classes to import
		for (Attribute attribute : attributes) 
			if(attribute.getClasses() != null && attribute.getClasses().length > 0)
				for (Class<?> clazz : attribute.getClasses())
					if(!classes.contains(clazz) && !aClass.getPackage().getName().equals(clazz.getPackage().getName()))
						classes.add(clazz);
		
		// if there aren't classes, returns the lines
		if(classes.isEmpty()) return lines;
						
		// verifies that the classes aren't already imported
		List<Class<?>> alreadyImported = new ArrayList<Class<?>>();
		for (Class<?> clazz : classes) 
				if(existImport(lines, clazz))
					alreadyImported.add(clazz);
		
		// remove from classes those already imported
		classes.removeAll(alreadyImported);
		
	    // writes imports
		List<String> result = new ArrayList<String>();
		for (String line : lines) {
			result.add(line);
			if(!packageFound(line,aClass))continue;
			for (Class<?> clazz : classes) 
				result.add("import "+clazz.getName()+";");
		}
		
		return result;
	}
	
	/**
	 * Adds JMap import to the lines.
	 * @param lines lines to analyze
	 * @param aClass Class in question
	 * @param classToImport class to import
	 * @return lines enriched
	 */
	private static List<String> addImport(List<String> lines,Class<?> aClass, Class<?> classToImport){

		if(existImport(lines, classToImport)) return lines;
		
		List<String> result = new ArrayList<String>();
		for (String line : lines) {
			result.add(line);
			if(!packageFound(line,aClass))continue;
			result.add("import "+classToImport.getName()+";");
		}
		return result;
	}

	/**
	 * Returns true if import already exist, false otherwise.
	 * @param lines lines to check
	 * @param aClass Class in question
	 * @return true if import already exist, false otherwise.
	 */
	private static boolean existImport(List<String> lines, Class<?> aClass){
		for (String line : lines) 
			if(GeneralUtility.containsAll(line, "import",aClass.getName(),";")) return true;
		return false;
	}

	/**
	 * Cleans lines from the JMap import.
	 * @param lines lines to analyze
	 * @return the resultant lines
	 */
	private static List<String> deleteImport(List<String> lines){
		return deleteSpecificImports(lines, JMap.class,JGlobalMap.class, JMapAccessors.class, JMapAccessor.class);
	}
	
	private static List<String> deleteSpecificImports(List<String> lines, Class<?>... annotations){
		List<String> result = lines;
		for (Class<?> annotation : annotations) 
			result = deleteSpecificImport(result, annotation);
		
		return result;
	}
	
	private static List<String> deleteSpecificImport(List<String> lines, Class<?> annotation){
		
		String[] annImport = {"import", annotation.getName()+";"};
		
		// verifies the annotation presence
		boolean isAnnotated = false;
		for (String line : lines) 
			if(line.contains("@"+annotation.getSimpleName()))
				isAnnotated = true;
				
		// if the class is not annotated, the annotations import will be removed
		if(!isAnnotated){
			List<String> result = new ArrayList<String>();
			for (String line : lines) 
				if(!containsAll(line, annImport)) result.add(line);
					return result;
		}else
			return lines;
	}
	
	/**
	 * Returns true if the line contains the package declaration, false otherwise.
	 * @param line line to check
	 * @param aClass Class in question
	 * @return true if the line contains the package declaration, false otherwise.
	 */
	private static boolean packageFound(String line,Class<?> aClass){
		if(containsAll(line, "package",aClass.getPackage().getName(),";"))return true;
		return false;
	}
	/**
	 * Method used to check the file existence, for test purpose.
	 * @param path Path of the file to check
	 * @return true if exists and it's file
	 */
	public static boolean verifyFileExistence(String path){
		File file = new File(path);
		return file.exists() && file.isFile();
	}
	
	/**
	 * Returns the file that has the name given as input, null otherwise.
	 * @param name file name
	 * @return the File with this name
	 * @throws FileNotFoundException 
	 */
	public static File searchFile(String name) throws FileNotFoundException{
		File file = searchFile(new File(applicationRoot),name);
		if(isNull(file))
			Error.fileNotFound(name);
		
		return file;
	}
	
	private static File searchFile(File file,String name){
		if(file.isDirectory())
			for (File it : file.listFiles())
				if(searchFile(it,name) != null) 
					return searchFile(it,name);
		
		if(file.getName().equals(name)) return file;
		return null;
	}
	
	/**
	 * Returns a list with the paths of all java classes.
	 * @return a List with the paths of all java classes
	 * @throws FileNotFoundException if file not found
	 * @throws LoadingFileException if isn't possible load this file
	 */
	public static List<String> classesPath() throws FileNotFoundException, LoadingFileException {
		List<File> files = getJavaFiles(); 
		List<String> paths = new ArrayList<String>();
		
		for (File file : files) 
			paths.add(file.getPath());
				
		return paths;
	}

	/**
	 * Returns a list with all annotated files.
	 * @return a List with all annotated files 
	 * @throws FileNotFoundException if file not found
	 * @throws LoadingFileException if isn't possible load this file
	 * @throws IOException other cases
	 */
	public static List<File> annotatedFiles() throws FileNotFoundException, LoadingFileException, IOException{
		
		List<File> annotatedFiles = new ArrayList<File>();
		for (File javaFile : getJavaFiles()) 
			if(isFileAnnotated(javaFile))
				annotatedFiles.add(javaFile);
		return annotatedFiles;
	}
	
	/**
	 * Returns a list with all annotated classes
	 * @return a List with all annotated classes 
	 * @throws LoadingFileException if isn't possible load this file
	 * @throws ClassNotFoundException class not found
	 * @throws IOException other cases
	 */
	public static List<Class<?>> annotatedClasses() throws LoadingFileException, IOException, ClassNotFoundException{
		
		List<Class<?>> annotatedClasses = new ArrayList<Class<?>>();
		for (File javaFile : annotatedFiles()){
			String fileName = javaFile.getName().substring(0, javaFile.getName().length() - ".java".length());
			annotatedClasses.add(Class.forName(getPackage(javaFile) + "." + fileName));
		}
		return annotatedClasses;
	}
	
	/**
	 * Returns the package of the class represented by this file.
	 * @param file file to check
	 * @return the package of this class
	 * @throws IOException problems with reading the file
	 */
	private static String getPackage(File file) throws IOException{
		for (String line : readFile(file))
			if(line.contains("package")){
				String packageName = line.split(" ")[1];
				return packageName.substring(0, packageName.length()-1);
			}
		return null;
	}
	
	/**
	 * Returns a list of files that are of *.java type.
	 * @param suffix
	 * @return a list with files that have this suffix
	 * @throws FileNotFoundException if file not found
	 * @throws LoadingFileException if isn't possible load this file
	 */
	private static List<File> getJavaFiles() throws FileNotFoundException, LoadingFileException{
		List<File> files = new ArrayList<File>();
		getFiles(new File(applicationRoot),files,".java");
		return files;
	}
	
	/**
	 * Adds to result all the files that have suffix given in input.
	 * @param file file to check
	 * @param result list to enrich
	 * @param suffix suffix to apply
	 */
	private static void getFiles(File file, List<File> result,String suffix){
		if(file.isDirectory())
			for (File it : file.listFiles())
				getFiles(it,result,suffix);
		else 
			if(file.getName().endsWith(suffix))
				result.add(file);
	}
	
	/**
	 * Returns true if the file, relative to path, containts the @JMap annotation.
	 * @param path file path
	 * @return true if the file, relative to path, contains the @JMap annotation
	 * @throws IOException in case of file manipulation problems
	 */
	public static boolean isFileAnnotated(String path, Class<?> aClass) throws IOException{
		return isFileAnnotated(new File(path), aClass);
	}
	/**
	 * Returns true if the file, containts the @JMap annotation.
	 * @param file file to check
	 * @return true if this file contains the @JMap annotation
	 * @throws IOException in case of file manipulation problems
	 */
	private static boolean isFileAnnotated(File file, Class<?> aClass) throws IOException{
		
		// strings used to identify the class
		String[] classIdentifier = new String[]{"class","{",aClass.getSimpleName()};
		
		// true if lines belong to aClass
		boolean classFound = false;
				
		String previuosLine = "";
		for (String line : readFile(file)){
			// If the class declaration has been found
			if(containsAll(line, classIdentifier))
					classFound = true;

			if(classFound && 
			  (previuosLine.contains("@JGlobalMap") || line.contains("@JMap")))return true;
			previuosLine = line;
		}
		return false;
	}
	
	/**
	 * @param file
	 * @return true if this file contains the @JMap annotation
	 * @throws IOException in case of file manipulation problems
	 */
	private static boolean isFileAnnotated(File file) throws IOException{
		for (String line : readFile(file))
			if(line.contains("@JMap") || line.contains("@JGlobalMap"))
				return true;
		return false;
	}
	
	/**
	 * Returns a list with the file lines.
	 * @param file file to read
	 * @return a List with the file lines
	 * @throws IOException in case of file manipulation problems
	 */
	private static List<String> readFile(File file) throws IOException{
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		List<String> lines = new  ArrayList<String>();
		String line;
		while((line=br.readLine())!=null)lines.add(line);
		fr.close();
		br.close();
		return lines;
	}
	
	/**
	 * Writes the lines given in input in file.
	 * @param file file to write
	 * @param lines lines to write
	 * @throws IOException in case of file manipulation problems
	 */
	private static void writeFile(File file, List<String> lines) throws IOException{
		if (!file.exists()) file.createNewFile();
	                
		FileWriter     fw = new FileWriter(file);
		BufferedWriter Bw = new BufferedWriter(fw);
		PrintWriter    pw = new PrintWriter(Bw);
	
		for (String line : lines)pw.println(line);
	
		Bw.close();
		fw.close();
		pw.close();
	}
	
	/**
	 * This method writes the xml file starting from an XmlJmapper object, following the xmlPath.
	 * @param jmapper XmlJmapper object that will be used for write the xml mapping file
	 * @throws IOException in case of file manipulation problems
	 */
	public static void write(XmlJmapper jmapper, String xmlPath) throws IOException{
		XStream xstream = new XStream();
		xstream.processAnnotations(XmlJmapper.class);
		String encoding = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
		writeFile(new File(xmlPath),list(encoding + xstream.toXML(jmapper)));
	}
	
	/**
	 * This method loads the xml file relative to xmlPath parameter.
	 * Read method is used for the xml manipulation at development time.
	 * 
	 * @param xmlPath path to xml file
	 * @return XmlJmapper object
	 * @throws FileNotFoundException if file not found
	 */
	public static XmlJmapper readAtDevelopmentTime(String xmlPath) throws FileNotFoundException{
		return toXmlJmapper(xmlPath,new FileInputStream(searchFile(xmlPath)));
	}
	
	/**
	 * This method loads the xml file relative to xmlPath parameter.
	 * Read method is used for the xml manipulation at runtime.
	 * 
	 * @param xmlPath path to xml file
	 * @return XmlJmapper object
	 * @throws MalformedURLException in case of malformed url
	 * @throws IOException other cases
	 */
	public static XmlJmapper readAtRuntime(String xmlPath) throws MalformedURLException, IOException{
		return toXmlJmapper(xmlPath,loadResource(xmlPath));
	}
	
	/**
	 * Converts an inputStream in XmlJmapper using XStream library.
	 * @param path file path
	 * @param is stream to convert
	 * @return an enriched XmlJmapper object
	 * @throws FileNotFoundException if file not found
	 */
	private static XmlJmapper toXmlJmapper(String path, InputStream is) throws FileNotFoundException{
		XStream xstream = new XStream();
		xstream.processAnnotations(XmlJmapper.class);
		if(is != null) return (XmlJmapper) xstream.fromXML(is);
		Error.fileNotFound(path);
		return null;
	}
	
	/**
	 * Starting from filename returns its path.
	 * @param fileName file name
	 * @return the absolute path
	 * @throws FileNotFoundException 
	 */
	public static String fullPathOf(String fileName) throws FileNotFoundException{
		return searchFile(fileName).getAbsolutePath();
	}

}
