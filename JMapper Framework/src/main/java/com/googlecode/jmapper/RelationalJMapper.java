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

package com.googlecode.jmapper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.googlecode.jmapper.annotations.Annotation;
import com.googlecode.jmapper.annotations.JGlobalMap;
import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.api.IRelationalJMapper;
import com.googlecode.jmapper.api.enums.MappingType;
import com.googlecode.jmapper.api.enums.NullPointerControl;
import com.googlecode.jmapper.config.Error;
import com.googlecode.jmapper.config.JmapperLog;
import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.xml.Attribute;
import com.googlecode.jmapper.xml.Global;
import com.googlecode.jmapper.xml.XML;

/**
 * RelationalJMapper takes as input one configured Class.<br>
 * For configured Class, we mean a Class that contains fields configured with annotation or XML.<br>
 * It is mandatory that all fields have defined classes.<br>
 * For example:
 * <pre><code>
 * class Destination {
 * 
 *  &#64;JMap(  attributes={"field1Class1","field1Class2","field1Class3"}, 
 *   	  classes={Class1.class,Class2.class,Class3.class})
 *	 private String field1;
 *  &#64;JMap(  attributes={"field2Class1","field2Class2","field2Class3"}, 
 *   	  classes={Class1.class,Class2.class,Class3.class})
 *	 private String field2;
 *  &#64;JMap(  attributes={"field3Class1","field3Class2","field3Class3"}, 
 *   	  classes={Class1.class,Class2.class,Class3.class})
 *	 private String field3;
 *  
 *  // getter and setter
 * }
 * </code></pre>
 * then invoke the methods manyToOne or oneToMany.<br><br>
 * With manyToOne method, the mapped classes are the source and the configured Class is the destination.<br>
 * manyToOne example:
 * <pre><code>
 *         AnnotatedClass manyToOne = null;
 *	Class1 class1 = new Class1("field1Class1", "field2Class1", "field3Class1");
 *	Class2 class2 = new Class2("field1Class2", "field2Class2", "field3Class2");
 *	Class3 class3 = new Class3("field1Class3", "field2Class3", "field3Class3");
 *		
 *	RelationalJMapper&lt;AnnotatedClass&gt; rm = new RelationalJMapper&lt;AnnotatedClass&gt;(AnnotatedClass.class);
 *		
 *	manyToOne = rm.manyToOne(class1);
 *	manyToOne = rm.manyToOne(class2);
 *	manyToOne = rm.manyToOne(class3);
 *	</code></pre>
 * With oneToMany method, the mapped classes are the destination and the configured Class is the source.<br>
 * oneToMany example:
 * <pre><code>
 *         AnnotatedClass annotatedClass = new AnnotatedClass("field1", "field2", "field3");
 *		
 *	RelationalJMapper&lt;AnnotatedClass&gt; rm = new RelationalJMapper&lt;AnnotatedClass&gt;(AnnotatedClass.class);
 *		
 *	Class1 class1 = rm.setDestinationClass(Class1.class).oneToMany(annotatedClass);
 *	Class2 class2 = rm.setDestinationClass(Class2.class).oneToMany(annotatedClass);
 *	Class3 class3 = rm.setDestinationClass(Class3.class).oneToMany(annotatedClass);
 *  </code></pre>  
 * For more information see {@link RelationalJMapper#manyToOne manyToOne} and {@link RelationalJMapper#oneToMany oneToMany} Methods<br>
 *
 * @author Alessandro Vurro
 *
 * @param <T> Type of Configured Class
 */
@SuppressWarnings({"rawtypes","unchecked"})
public final class RelationalJMapper<T> implements IRelationalJMapper<T>{

	/** Configured Class*/
	private Class<T> configuredClass;
	
	/** map that has the target class names as keys and relative JMapper as values */
	private final HashMap<String,JMapper> relationalOneToManyMapper;
	
	/** map that has the target class names as keys and relative JMapper as values */
	private final HashMap<String,JMapper> relationalManyToOneMapper;

	/**
	 * Takes in input only the annotated Class
	 * @param configuredClass configured class
	 */
	public RelationalJMapper(final Class<T> configuredClass){
		this.relationalOneToManyMapper = new HashMap<String, JMapper>();
		this.relationalManyToOneMapper = new HashMap<String, JMapper>();
		this.configuredClass = configuredClass;
		try{	init();
		}catch (Exception e) {JmapperLog.ERROR(e);}
	}
	
	/**
	 * Takes in input only the configured Class and the xml mapping path.
	 * @param configuredClass configured class
	 * @param xmlPath XML path
	 */
	public RelationalJMapper(final Class<T> configuredClass, String xmlPath){
		this.relationalOneToManyMapper = new HashMap<String, JMapper>();
		this.relationalManyToOneMapper = new HashMap<String, JMapper>();
		this.configuredClass = configuredClass;
		try{	init(xmlPath);
		}catch (Exception e) {JmapperLog.ERROR(e);}
	}
	
	/**
	 * This method initializes relational maps starting from XML.
	 * @param xmlPath xml path
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private void init(String xmlPath) throws MalformedURLException, IOException{
		
		XML xml = new XML(true, xmlPath);
		if(!xml.isMapped(configuredClass))
			Error.classNotMapped(configuredClass);
		
		for (Class<?> classe :getClasses(xml)){
			relationalManyToOneMapper.put(classe.getName(), new JMapper(configuredClass, classe,ChooseConfig.DESTINATION, xmlPath));
			relationalOneToManyMapper.put(classe.getName(), new JMapper(classe, configuredClass,ChooseConfig.SOURCE, xmlPath));
		}
	}
	
	/**
	 * Returns all Target Classes contained in the XML.
	 * @param xml xml to analyze
	 * @return target classes
	 */
	private Set<Class<?>> getClasses(XML xml){
		HashSet<Class<?>> result = new HashSet<Class<?>>();
		Global global = xml.globalsLoad().get(configuredClass.getName());
		if(global != null){
			addClasses(global.getClasses(),result);
			if(global.getExcluded()!=null)
				for (Attribute attribute : xml.attributesLoad().get(configuredClass.getName()))
					for (String fieldName : global.getExcluded())
						if(attribute.getName().equals(fieldName))
							addClasses(attribute.getClasses(),result,attribute.getName());
			return result;
		}
		
		for (Attribute attribute : xml.attributesLoad().get(configuredClass.getName()))
			addClasses(attribute.getClasses(),result,attribute.getName());
				
		return result;
	}
	
	/**
	 * This method initializes relational maps
	 */
	private void init(){
	
		if(!Annotation.isMapped(configuredClass))
			Error.classNotMapped(configuredClass);
		
		for (Class<?> classe :getClasses()){
			relationalManyToOneMapper.put(classe.getName(), new JMapper(configuredClass, classe,ChooseConfig.DESTINATION));
			relationalOneToManyMapper.put(classe.getName(), new JMapper(classe, configuredClass,ChooseConfig.SOURCE));
		}
	}	
	
	/**
	 * Returns all Target Classes
	 * @return a List of Target Classes
	 */
	private Set<Class<?>> getClasses() {
		
		HashSet<Class<?>> result = new HashSet<Class<?>>();
		JGlobalMap jGlobalMap = configuredClass.getAnnotation(JGlobalMap.class);
		if(jGlobalMap != null){
			addClasses(jGlobalMap.classes(),result);
			if(jGlobalMap.excluded() != null)
				for (Field field : configuredClass.getDeclaredFields()){ 
					JMap jMap = field.getAnnotation(JMap.class);
					if(jMap!=null) 
						for (String fieldName : jGlobalMap.excluded()) 
							if(field.getName().equals(fieldName))
								addClasses(jMap.classes(),result,field.getName());
						
				}
			return result;
		}
		
		for (Field field : configuredClass.getDeclaredFields()){ 
			JMap jMap = field.getAnnotation(JMap.class);
			if(jMap!=null) addClasses(jMap.classes(),result,field.getName());
		}	
		
		return result;	
	}

	/**
	 * Adds to the result parameter all classes that aren't present in it
	 * @param classes classes to control
	 * @param result List to enrich
	 * @param fieldName name of file, only for control purpose
	 */
	private void addClasses(Class<?>[] classes, HashSet<Class<?>> result, String fieldName){
		
		if(classes == null || classes.length==0)	
			Error.classesAbsent(fieldName, configuredClass);
		
		for (Class<?> classe : classes)	result.add(classe);
	}
	
	/**
	 * Adds to the result parameter all classes that aren't present in it
	 * @param classes classes to control
	 * @param result List to enrich
	 */
	private void addClasses(Class<?>[] classes, HashSet<Class<?>> result){
		
		if(classes == null || classes.length==0)	
			Error.globalClassesAbsent(configuredClass);
		
		for (Class<?> classe : classes)	result.add(classe);
	}
	/**
	 * Returns a new instance of Class given as input, managing also the exception.
	 * @param exception exception to handle
	 * @param clazz class to instantiate
	 * @return a new instance of Class given as input
	 */
	private <I> I newInstance(Exception exception, Class<I> clazz){
		JmapperLog.ERROR(exception); 
		try                 { return (I) clazz.newInstance(); } 
		catch (Exception e) { return null; }
	}
	
	/**
	 * This method verifies that the destinationClass exists.
	 * @param exception exception to handle
	 * @param clazz class to check
	 * @return a new instance of Class given as input
	 */
	private <I> I destinationClassControl(Exception exception, Class<I> clazz){
		try{
			if(clazz == null)throw new IllegalArgumentException("it's mandatory define the destination class");
		}catch (Exception e) {JmapperLog.ERROR(e);return null;}
		return newInstance(exception,clazz);
	}
	/**
	 * Returns the desired JMapper instance.
	 * @param map the map of relationships
	 * @param source key of the map
	 * @return the instance of JMapper
	 */
	private <D,S> JMapper<D,S> getJMapper(HashMap<String,JMapper> map,Object source){
		Class<?> sourceClass = source instanceof Class?((Class<?>)source):source.getClass();
		JMapper<D,S> jMapper = map.get(sourceClass.getName());
		if(jMapper == null) Error.classNotMapped(source, configuredClass);
		return jMapper;
	}

	/**
	 * This method returns a new instance of Configured Class with this setting:
	 * <table summary ="">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>SOURCE</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS</code></td>
	 * </tr>
	 * </table>
	 * @param source instance of Target Class type that contains the data
	 * @return new instance of Configured Class
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <S> T manyToOne(final S source) {
		try{ return this.<T,S>getJMapper(relationalManyToOneMapper,source).getDestination(source); }
		catch (Exception e) { return newInstance(e,configuredClass);}
	}
	
	/**
	 * This method returns a new instance of Configured Class with this setting:
	 * <table summary ="">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>NOT_ANY</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS</code></td>
	 * </tr>
	 * </table>
	 * @param source instance of Target Class type that contains the data
	 * @return new instance of Configured Class
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <S> T manyToOneWithoutControl(final S source) {
		try{ return this.<T,S>getJMapper(relationalManyToOneMapper,source).getDestinationWithoutControl(source); }
		catch (Exception e) { return newInstance(e,configuredClass); }
	}
	
	/**
	 * This Method returns the configured instance given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table summary ="">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>ALL</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS</code></td>
	 * </tr>
	 * </table>
	 * @param destination instance of Configured Class type to enrich
	 * @param source instance of Target Class type that contains the data
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <S> T manyToOne(T destination,final S source) {
		try{ return this.<T,S>getJMapper(relationalManyToOneMapper,source).getDestination(destination,source); }
		catch (Exception e) { return newInstance(e,configuredClass); }
	}
	
	/**
	 * This Method returns the configured instance given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table summary ="">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>NOT_ANY</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS</code></td>
	 * </tr>
	 * </table>
	 * @param destination instance of Configured Class type to enrich
	 * @param source instance of Target Class type that contains the data
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <S> T manyToOneWithoutControl(T destination,final S source) {
		try{ return this.<T,S>getJMapper(relationalManyToOneMapper,source).getDestinationWithoutControl(destination,source); }
		catch (Exception e) { return newInstance(e,configuredClass); }
	}

	/**
	 * This method returns a new instance of Configured Class with this setting:
	 * <table summary ="">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>SOURCE</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td>mtSource</td>
	 * </tr>
	 * </table>
	 * @param source instance of Target Class type that contains the data
	 * @param mtSource type of mapping of source instance 
	 * @return new instance of Configured Class
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <S> T manyToOne(final S source,final MappingType mtSource) {
		try{ return this.<T,S>getJMapper(relationalManyToOneMapper,source).getDestination(source,mtSource); }
		catch (Exception e) { return newInstance(e,configuredClass); }
	}
	
	/**
	 * This method returns a new instance of Configured Class with this setting:
	 * <table summary ="">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td>nullPointerControl</td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td>mtSource</td>
	 * </tr>
	 * </table>
	 * @param source instance of Target Class type that contains the data
	 * @param nullPointerControl type of null pointer control
	 * @param mtSource type of mapping of source instance 
	 * @return new instance of Configured Class
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <S> T manyToOne(final S source,final NullPointerControl nullPointerControl,final MappingType mtSource) {
		try{ return this.<T,S>getJMapper(relationalManyToOneMapper,source).getDestination(source,nullPointerControl,mtSource); }
		catch (Exception e) { return newInstance(e,configuredClass); }
	}
	
	/**
	 * This Method returns the configured instance given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table summary ="">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>ALL</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td>mtDestination</td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td>mtSource</td>
	 * </tr>
	 * </table>
	 * @param destination instance of Configured Class type to enrich
	 * @param source instance of Target Class type that contains the data
	 * @param mtDestination type of mapping of destination instance
	 * @param mtSource type of mapping of source instance 
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <S> T manyToOne(T destination,final S source,final MappingType mtDestination,final MappingType mtSource) {
		try{ return this.<T,S>getJMapper(relationalManyToOneMapper,source).getDestination(destination, source, mtDestination,mtSource); }
		catch (Exception e) { return newInstance(e,configuredClass); }
	}
	
	/**
	 * This Method returns the configured instance given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table summary ="">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td>nullPointerControl</td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td>mtDestination</td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td>mtSource</td>
	 * </tr>
	 * </table>
	 * @param destination instance of Configured Class type to enrich
	 * @param source instance of Target Class type that contains the data
	 * @param nullPointerControl type of null pointer control
	 * @param mtDestination type of mapping of destination instance
	 * @param mtSource type of mapping of source instance 
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <S> T manyToOne(T destination,final S source,final NullPointerControl nullPointerControl,final MappingType mtDestination,final MappingType mtSource) {
		try{ return this.<T,S>getJMapper(relationalManyToOneMapper,source).getDestination(destination, source, nullPointerControl, mtDestination, mtSource); }
		catch (Exception e) { return newInstance(e,configuredClass); }
	}
	
	/**
	 * This method returns a new instance of Target Class with this setting:
	 * <table summary ="">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>SOURCE</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS</code></td>
	 * </tr>
	 * </table>
	 * @param destinationClass class to create
	 * @param source instance of Configured Class that contains the data
	 * @return new instance of Target Class
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <D> D oneToMany(Class<D> destinationClass, final T source) {
		try{ return this.<D,T>getJMapper(relationalOneToManyMapper,destinationClass).getDestination(source); }
		catch (Exception e) { return (D) this.destinationClassControl(e,destinationClass); }
	}
	
	
	/**
	 * This method returns a new instance of Target Class with this setting:
	 * <table summary ="">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>NOT_ANY</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS</code></td>
	 * </tr>
	 * </table>
	 * @param source instance of Configured Class that contains the data
	 * @return new instance of Target Class
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <D> D oneToManyWithoutControl(Class<D> destinationClass, final T source) {
		try{ return this.<D,T>getJMapper(relationalOneToManyMapper,destinationClass).getDestinationWithoutControl(source); }
		catch (Exception e) { return (D) this.destinationClassControl(e,destinationClass); }
	}
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table summary ="">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>ALL</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS</code></td>
	 * </tr>
	 * </table>
	 * @param destination instance of Target Class to enrich
	 * @param source instance of Configured Class that contains the data
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <D> D oneToMany(D destination,final T source) {
		try{ return this.<D,T>getJMapper(relationalOneToManyMapper,destination.getClass()).getDestination(destination,source); }
		catch (Exception e) { return (D) this.newInstance(e,destination.getClass()); }
	}
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table summary ="">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>NOT_ANY</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS</code></td>
	 * </tr>
	 * </table>
	 * @param destination instance of Target Class to enrich
	 * @param source instance of Configured Class that contains the data
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <D> D oneToManyWithoutControl(D destination,final T source) {
		try{ return this.<D,T>getJMapper(relationalOneToManyMapper,destination.getClass()).getDestinationWithoutControl(destination,source); }
		catch (Exception e) { return (D) this.newInstance(e,destination.getClass()); }
	}

	/**
	 * This method returns a new instance of Target Class with this setting:
	 * <table summary ="">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>SOURCE</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td>mtSource</td>
	 * </tr>
	 * </table>
	 * @param destinationClass class to create
	 * @param source instance of Configured Class that contains the data
	 * @param mtSource type of mapping of source instance
	 * @return new instance of Target Class
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <D> D oneToMany(Class<D> destinationClass, final T source,final MappingType mtSource) {
		try{ return this.<D,T>getJMapper(relationalOneToManyMapper,destinationClass).getDestination(source,mtSource); }
		catch (Exception e) { return (D) this.destinationClassControl(e,destinationClass); }
	}
	
	/**
	 * This method returns a new instance of Target Class with this setting:
	 * <table summary ="">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td>nullPointerControl</td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td>mtSource</td>
	 * </tr>
	 * </table>
	 * @param source instance of Configured Class that contains the data
	 * @param nullPointerControl type of control
	 * @param mtSource type of mapping of source instance
	 * @return new instance of Target Class
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <D> D oneToMany(Class<D> destinationClass, final T source,final NullPointerControl nullPointerControl,final MappingType mtSource) {
		try{ return this.<D,T>getJMapper(relationalOneToManyMapper,destinationClass).getDestination(source,nullPointerControl,mtSource); }
		catch (Exception e) { return (D) this.destinationClassControl(e,destinationClass); }
	}
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table summary ="">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>ALL</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td>mtDestination</td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td>mtSource</td>
	 * </tr>
	 * </table>
	 * @param destination instance of Target Class to enrich
	 * @param source instance of Configured Class that contains the data
	 * @param mtDestination type of mapping of destination instance
	 * @param mtSource type of mapping of source instance 
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <D> D oneToMany(D destination,final T source,final MappingType mtDestination,final MappingType mtSource) {
		try{ return this.<D,T>getJMapper(relationalOneToManyMapper,destination.getClass()).getDestination(destination, source, mtDestination,mtSource); }
		catch (Exception e) { return (D) this.newInstance(e,destination.getClass()); }
	}
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table summary ="">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td>nullPointerControl</td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td>mtDestination</td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td>mtSource</td>
	 * </tr>
	 * </table>
	 * @param destination instance of Target Class to enrich
	 * @param source instance of Configured Class that contains the data
	 * @param nullPointerControl type of null pointer control
	 * @param mtDestination type of mapping of destination instance
	 * @param mtSource type of mapping of source instance 
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <D> D oneToMany(D destination,final T source,final NullPointerControl nullPointerControl,final MappingType mtDestination,final MappingType mtSource) {
		try{ return this.<D,T>getJMapper(relationalOneToManyMapper,destination.getClass()).getDestination(destination, source, nullPointerControl, mtDestination, mtSource);}
		catch (Exception e) { return (D) this.newInstance(e,destination.getClass()); }
	}
}