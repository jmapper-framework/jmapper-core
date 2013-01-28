/**
 * Copyright (C) 2012 - 2013 Alessandro Vurro.
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

package com.googlecode.jmapper.xml;

import static com.googlecode.jmapper.util.ClassesManager.isMappedInAnnotation;
import static com.googlecode.jmapper.util.ClassesManager.isMappedInXML;
import static com.googlecode.jmapper.util.GeneralUtility.list;
import static com.googlecode.jmapper.xml.XmlBuilder.loadXml;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.googlecode.jmapper.config.JmapperLog;
import com.googlecode.jmapper.exceptions.LoadingFileException;
import com.googlecode.jmapper.util.FilesManager;
import com.googlecode.jmapper.util.XML;
import com.googlecode.jmapper.xml.beans.XmlClass;

/**
 * XmlHandler handles the XML File Configuration.
 * @author Alessandro Vurro
 *
 */
public class XmlHandler {

	/** xml object */
	private XML xml;
	
	/**
	 * The empty constructor defines a new xml configuration file positioned at the application root.
	 */
	public XmlHandler() {
		xml = new XML().setXmlPath("jmapper.xml");
	}
	
	/**
	 * Xml File is handled at development time from xmlPath.
	 * You must define only the file name, JMapper finds it recursively.
	 * For example: if you have a file situated in the xml folder ("xml/mapper.xml")
	 * you must instantiate XmlHandler as follows: new XmlHandler("mapper.xml");  
	 * @param xmlPath xml path
	 */
	public XmlHandler(String xmlPath) {
		try{xml = loadXml(xmlPath).atDevelopmentTime();}
		catch (Exception e) {JmapperLog.ERROR(e);}
	}
	/**
	 * Cleans up the annotated classes, given as input, from the configuration.<br>
	 * If the class has inner classes and they are mapped, their configuration will be removed.
	 * @param classes 
	 * @return this instance of XmlHandler
	 */
	public XmlHandler cleanAnnotatedClassAll(Class<?>... classes){
		return cleanAnnotatedClass (true,Arrays.asList(classes));
	}
	
	/**
	 * Cleans up the annotated classes, given as input, from the configuration.<br>
	 * If the class has inner classes and they are mapped, their configuration will be not removed.
	 * @param classes 
	 * @return this instance of XmlHandler
	 */
	public XmlHandler cleanAnnotatedClass(Class<?>... classes){
		return cleanAnnotatedClass (false,list(classes));
	}
	/**
	 * Cleans up all annotated classes from the configuration
	 * @return this instance of XmlHandler
	 */
    public XmlHandler cleanAnnotatedClass(){
    	try{ return  cleanAnnotatedClass (false,FilesManager.annotatedClasses());
    	}catch (Exception e) {JmapperLog.ERROR(e);}
    	return this;
    }
    
    private XmlHandler cleanAnnotatedClass(boolean cleanAll,List<Class<?>> classes){
		try{ List<File> annotatedFiles = FilesManager.annotatedFiles();
			 for (Class<?> clazz : classes) {
				String classPath = getClassPath(clazz);
				for (File file : annotatedFiles) 
					if(file.getPath().contains(classPath))
						FilesManager.cleanClass(file,clazz,cleanAll);
			 }
		}catch (Exception e) {JmapperLog.ERROR(e);}
		return this;
	}
    /**
     * Add the annotated classes given as input to Xml Configuration.<br>
     * If the class has inner classes and they are mapped, their configuration will be added too.
	 * @param classes annotated classes to add to Xml Configuration
	 * @return this instance of XmlHandler
	 */
	public XmlHandler addAnnotatedClassAll(Class<?>... classes){
	  try{ addClasses(true,classes);
	  }catch (Exception e) {JmapperLog.ERROR(e);}
	  return this;
	}
	
    /**
     * Add the annotated classes given as input to Xml Configuration.<br>
     * If the class has inner classes and they are mapped, their configuration will be not added too.
	 * @param classes annotated classes to add to Xml Configuration
	 * @return this instance of XmlHandler
	 */
	public XmlHandler addAnnotatedClass(Class<?>... classes){
	  try{ addClasses(false,classes);
	  }catch (Exception e) {JmapperLog.ERROR(e);}
	  return this;
	}
	
	/**
	* Add all Annotated classes to Xml Configuration.
	* @return this instance of XmlHandler
	*/
	public XmlHandler addAnnotatedClass(){
      try{ List<Class<?>> annotatedClasses = FilesManager.annotatedClasses();
	       addClasses(true,annotatedClasses.toArray(new Class[annotatedClasses.size()]));
      }catch (Exception e) {JmapperLog.ERROR(e);}
	  return this;
    }
    
    /**
     * This method rewrite a Xml Configuration of the Annotated Class given as input.<br>
	 * If the class has inner classes and they are mapped, their configuration will be rewritten.
	 * @param classes Classes to rewrite
	 * @return this instance of XmlHandler
	 */
	public XmlHandler overrideAnnotatedClassAll(Class<?>... classes){
		for(Class<?> clazz: classes)
			overrideAnnotatedClass(clazz,true);
		return this;
	}
	
	/**
     * This method rewrites the xml configuration only if the classes, geiven as input, are configured in annotation and xml..<br>
	 * If the class has inner classes and they are mapped, their configuration will be not rewritten.
	 * @param classes Classes to rewrite
	 * @return this instance of XmlHandler
	 */
	public XmlHandler overrideAnnotatedClass(Class<?>... classes){
		try{ for(Class<?> clazz: classes)
			 overrideAnnotatedClass(clazz,false);
		}catch (Exception e) {JmapperLog.ERROR(e);}
		return this;
	}
	
	/**
	 * This method rewrites the xml configuration of only those classes configured in annotation and xml.
	 * @return this instance of XmlHandler
	 */
	public XmlHandler overrideAnnotatedClass(){
		try{ for(Class<?> clazz: FilesManager.annotatedClasses())
			 overrideAnnotatedClass(clazz,true);
		}catch (Exception e) {JmapperLog.ERROR(e);}
		return this;
	}
	
	private void overrideAnnotatedClass(Class<?> clazz,boolean overrideAll){
		
			 if(isMappedInAnnotation(clazz) && isMappedInXML(clazz,xml)){
				 XmlClass xmlClass = XmlConverter.toXmlClass(clazz);
				 Attribute[] attributes = new Attribute[xmlClass.attributes.size()];
				 for (int i = xmlClass.attributes.size(); i --> 0;)
					 attributes[i] = XmlConverter.toAttribute(xmlClass.attributes.get(i));
				
				 overrideClass(clazz, attributes);
			 }
			 if(overrideAll)
				 for (Class<?> it : clazz.getClasses())
						if(it.isMemberClass() && isMappedInAnnotation(clazz) && isMappedInXML(clazz,xml)) 
							overrideAnnotatedClass(it,true);
	}
	
	/**
	* Eliminates all classes annotated, from Xml configuration.
	* @return this instance of XmlHandler
	*/
	public XmlHandler deleteAnnotatedClasses(){
	  for (String className : xml.getClasses()){
		 try {	 
			 deleteAnnotatedClass(Class.forName(className));
		 } catch (ClassNotFoundException e) {
			 try{com.googlecode.jmapper.config.Error.xmlMappingClassDoesNotExist(className);
			 }catch (Exception e2) {JmapperLog.ERROR(e2);}
		 } catch (LoadingFileException e) {JmapperLog.ERROR(e);
		 } catch (IOException e) {		   JmapperLog.ERROR(e);}
	  }
	  
	  xml.write();
	  return this;
    }
	
	/**
	 * Deletes the Class, given in input, from xml mapping file, only if it's annotated.
	 * @param aClass a Class to delete
	 * @return this instance of XmlHandler
	 * @throws LoadingFileException 
	 * @throws IOException 
	 */
	private XmlHandler deleteAnnotatedClass(Class<?> aClass) throws LoadingFileException, IOException{
		
		String path = getElement(FilesManager.classesPath(),getClassPath(aClass));
		if(FilesManager.isFileAnnotated(path,aClass))  deleteClasses(aClass);
		  for (Class<?> it : aClass.getClasses())
				if(it.isMemberClass()) deleteAnnotatedClass(it);
		  return this;
	}
     
    private String getElement(Collection<String> list, String element){
	   for (String file : list) if(file.contains(element))return file;
	   return null;
    }
    
    /**
	 * Adds annotations to classes given as input starting from Xml configuration.<br>
	 * If the class has inner classes and they aren't annotated, annotations will be added to them.
	 * @param classes classes to convert from xml to annotation
	 * @return this instance of XmlHandler
	 */
	public XmlHandler fromXmlToAnnotationAll(Class<?>... classes){
		
		for (Class<?> classe : classes) {
			fromXmlToAnnotation(classe);
			for (Class<?> inner : classe.getClasses())
				if(inner.isMemberClass())
					fromXmlToAnnotation(inner);
		}
		return this;
	}
	
	/**
	 * Adds annotations to classes given as input starting from Xml configuration.<br>
	 * If the class has inner classes and they aren't annotated, annotations will be not added to them.
	 * @param classes classes to convert from xml to annotation
	 * @return this instance of XmlHandler
	 */
	public XmlHandler fromXmlToAnnotation(Class<?>... classes){
		try{ Map<String, List<Attribute>> xmlClasses = xml.attributesLoad();
		     List<String> simplyClasses = FilesManager.classesPath();
		
			for (Class<?> classe : classes) {
				
				// if the file isn't present in the xml configuration file
				if(!xmlClasses.containsKey(classe.getName()))continue;
				
				// recupero il path della classe
				String path = getElement(simplyClasses,getClassPath(classe));
				// if the class isn't annotated
				if(!FilesManager.isFileAnnotated(path,classe))
					FilesManager.addConfigurationToClass(path,xmlClasses.get(classe.getName()),classe);
				
			}
		}catch (Exception e) {JmapperLog.ERROR(e);}
		return this;
	}
	/**
	* Adds annotations to all classes presents in the Xml configuration.
	* @return this instance of XmlHandler
	*/
    public XmlHandler fromXmlToAnnotation(){
	   try{ for (String className : xml.attributesLoad().keySet()) 
	    		fromXmlToAnnotation(Class.forName(className));
	   }catch (Exception e) {JmapperLog.ERROR(e);}
		return this;
	}

	private String getClassPath(Class<?> clazz){
		return getMainClass(clazz).getName().replace('.','\\') + ".java";
	}
	
	private Class<?> getMainClass(Class<?> clazz){
		while(clazz.isMemberClass())
			clazz = clazz.getDeclaringClass();
		return clazz;
	}
	/**
	 * Adds attributes to the existent Class in the Xml configuration.
	 * @param aClass Class of the attributes
	 * @param attributes attributes of the clazz to add in the Xml Configuration File
	 * @return this instance of XmlHandler
	 */
	public XmlHandler addAttributes(Class<?> aClass,Attribute... attributes){
		try{ xml.addAttributes(aClass, attributes);
			 xml.write();
		}catch (Exception e) {JmapperLog.ERROR(e);}
		return this;
	}
	
	/**
	 * Deletes attributes to the existent Class in the Xml configuration.
	 * @param aClass Class of the attributes
	 * @param attributes attributes of the clazz to delete from Xml Configuration File
	 * @return this instance of XmlHandler
	 */
	public XmlHandler deleteAttributes(Class<?> aClass,String... attributes){
		try{ xml.deleteAttributes(aClass, attributes);
			 xml.write();
		}catch (Exception e) {JmapperLog.ERROR(e);}
		return this;
	}	
	
	private XmlHandler addClasses(boolean addAll,Class<?>... classes ){
		
		for (Class<?> clazz : classes){
			if(isMappedInAnnotation(clazz))
				xml.addAnnotatedClass(clazz); 
			
			if(addAll)
				for (Class<?> it : clazz.getClasses())
					if(it.isMemberClass())
						addClasses(true,it); 
			
		}
		xml.write();
		return this;
	}
	
	/**
	 * This method adds a specific Class to Xml Configuration File.<br>
	 * At least one field name must be configured.
	 * @param clazz a Class to add in xml configuration 
	 * @param attributes configured fields of clazz
	 * @return this instance of XmlHandler
	 */
	public XmlHandler addClass(Class<?> clazz,String... attributes){
		Attribute[] listAttributes = new Attribute[attributes.length];
		for (int i = attributes.length; i --> 0;) 
			listAttributes[i] = new Attribute(attributes[i]);
		
		return addClass(clazz, listAttributes);
	}
    /**
	 * This method adds a specific Class to Xml Configuration File.<br>
	 * At least one field must be configured.
	 * @param clazz a Class to add in xml configuration 
	 * @param attributes configured fields of clazz
	 * @return this instance of XmlHandler
	 */
	public XmlHandler addClass(Class<?> clazz,Attribute... attributes){
		try{	xml.addClass(clazz, attributes);
			    xml.write();
		}catch (Exception e) {JmapperLog.ERROR(e);}
		return this;
	}

	private XmlHandler deleteClasses(Class<?>... classes){
		for(Class<?> clazz : classes)
			if(isMappedInXML(clazz,xml)) xml.deleteClass(clazz);
		return this;
	}
	
    /**
	 * This method remove the classes given as input, from xml mapping File.
	 * @param classes classes to delete
	 * @return this instance of XmlHandler
	 */
	public XmlHandler deleteClass(Class<?>... classes){
		try{ for (Class<?> clazz : classes)
			 xml.deleteClass(clazz);
			 xml.write();
		}catch (Exception e) {JmapperLog.ERROR(e);}
		return this;
	}
	
	/**
	 * This method rewrite a configuration of the Class given as input, with this attributes.
	 * @param aClass a Class to override
	 * @param attributes attributes of aClass
	 * @return this instance of XmlHandler
	 */
	public XmlHandler overrideClass(Class<?> aClass,Attribute... attributes){
		try{ xml.deleteClass(aClass);
			 xml.addClass(aClass, attributes);
			 xml.write();
		}catch (Exception e) {JmapperLog.ERROR(e);}
		return this;
	}
	
	/**
	 * For debug porpouse
	 * @return the xml object
	 */
	public XML getXML(){return xml;}
}