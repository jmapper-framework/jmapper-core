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
package it.avutils.jmapper;

import it.avutils.jmapper.enums.MappingType;
import it.avutils.jmapper.enums.NullPointerControl;

/**
 * RelationalJMapper takes as input one configured Class.<br>
 * For configured Class, we mean a Class that contains fields configured with annotation or XML.<br>
 * It is mandatory that all fields have defined classes.<br>
 * For example:<pre><code>class Destination {
 * 
 *   {@code @JMap}(  attributes={"field1Class1","field1Class2","field1Class3"}, 
 *   	  classes={Class1.class,Class2.class,Class3.class})
 *	 private String field1;
 *   {@code @JMap}(  attributes={"field2Class1","field2Class2","field2Class3"}, 
 *   	  classes={Class1.class,Class2.class,Class3.class})
 *	 private String field2;
 *   {@code @JMap}(  attributes={"field3Class1","field3Class2","field3Class3"}, 
 *   	  classes={Class1.class,Class2.class,Class3.class})
 *	 private String field3;
 *  
 *  // getter and setter
 * }</pre></code>
 * then invoke the methods manyToOne or oneToMany.<br><br>
 * With manyToOne method, the mapped classes are the source and the configured Class is the destination.<br>
 * manyToOne example:
 * <pre><code>	AnnotatedClass manyToOne = null;
	Class1 class1 = new Class1("field1Class1", "field2Class1", "field3Class1");
	Class2 class2 = new Class2("field1Class2", "field2Class2", "field3Class2");
	Class3 class3 = new Class3("field1Class3", "field2Class3", "field3Class3");
		
	RelationalJMapper<AnnotatedClass> rm = new RelationalJMapper<AnnotatedClass>(AnnotatedClass.class);
		
	manyToOne = rm.manyToOne(class1);
	manyToOne = rm.manyToOne(class2);
	manyToOne = rm.manyToOne(class3);</code></pre>
 * With oneToMany method, the mapped classes are the destination and the configured Class is the source.<br>
 * oneToMany example:
 * <pre><code>	AnnotatedClass annotatedClass = new AnnotatedClass("field1", "field2", "field3");
		
	RelationalJMapper<AnnotatedClass> rm = new RelationalJMapper<AnnotatedClass>(AnnotatedClass.class);
		
	Class1 class1 = rm.setDestinationClass(Class1.class).oneToMany(annotatedClass);
	Class2 class2 = rm.setDestinationClass(Class2.class).oneToMany(annotatedClass);
	Class3 class3 = rm.setDestinationClass(Class3.class).oneToMany(annotatedClass);</code></pre>  
 * For more information see {@link RelationalJMapper#manyToOne manyToOne} and {@link RelationalJMapper#oneToMany oneToMany} Methods<br>
 *
 * @author Alessandro Vurro
 *
 * @param <T> Type of Configured Class
 */
public interface IRelationalJMapper<T> {

	/**
	 * This method returns a new instance of Configured Class with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>SOURCE</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS<code></td>
	 * </tr>
	 * </table>
	 * @param source instance of Target Class type that contains the data
	 * @return new instance of Configured Class
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <S> T manyToOne(final S source);
	
	/**
	 * This method returns a new instance of Configured Class with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>NOT_ANY</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS<code></td>
	 * </tr>
	 * </table>
	 * @param source instance of Target Class type that contains the data
	 * @return new instance of Configured Class
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <S> T manyToOneWithoutControl(final S source);
	
	/**
	 * This Method returns the configured instance given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>ALL</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS<code></td>
	 * </tr>
	 * </table>
	 * @param destination instance of Configured Class type to enrich
	 * @param source instance of Target Class type that contains the data
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <S> T manyToOne(T destination,final S source);
	
	/**
	 * This Method returns the configured instance given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>NOT_ANY</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS<code></td>
	 * </tr>
	 * </table>
	 * @param destination instance of Configured Class type to enrich
	 * @param source instance of Target Class type that contains the data
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <S> T manyToOneWithoutControl(T destination,final S source);
	
	/**
	 * This method returns a new instance of Configured Class with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>SOURCE</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
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
	public <S> T manyToOne(final S source,final MappingType mtSource);
	
	/**
	 * This method returns a new instance of Configured Class with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td>nullPointerControl</td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
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
	public <S> T manyToOne(final S source,final NullPointerControl nullPointerControl,final MappingType mtSource);
	
	/**
	 * This Method returns the configured instance given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table>
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
	public <S> T manyToOne(T destination,final S source,final MappingType mtDestination,final MappingType mtSource);
	
	/**
	 * This Method returns the configured instance given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table>
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
	public <S> T manyToOne(T destination,final S source,final NullPointerControl nullPointerControl,final MappingType mtDestination,final MappingType mtSource);
	
	/**
	 * This method returns a new instance of Target Class with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>SOURCE</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS<code></td>
	 * </tr>
	 * </table>
	 * @param destinationClass class to create 
	 * @param source instance of Configured Class that contains the data
	 * @return new instance of Target Class
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <D> D oneToMany(Class<D> destinationClass, final T source);
	
	/**
	 * This method returns a new instance of Target Class with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>NOT_ANY</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS<code></td>
	 * </tr>
	 * </table>
	 * @param source instance of Configured Class that contains the data
	 * @return new instance of Target Class
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <D> D oneToManyWithoutControl(Class<D> destinationClass, final T source);
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>ALL</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS<code></td>
	 * </tr>
	 * </table>
	 * @param destination instance of Target Class to enrich
	 * @param source instance of Configured Class that contains the data
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <D> D oneToMany(D destination,final T source);
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>NOT_ANY</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS<code></td>
	 * </tr>
	 * </table>
	 * @param destination instance of Target Class to enrich
	 * @param source instance of Configured Class that contains the data
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <D> D oneToManyWithoutControl(D destination,final T source);
	
	/**
	 * This method returns a new instance of Target Class with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>SOURCE</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td>mtSource</td>
	 * </tr>
	 * </table>
	 * @param source instance of Configured Class that contains the data
	 * @param mtSource type of mapping of source instance
	 * @return new instance of Target Class
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public <D> D oneToMany(Class<D> destinationClass, final T source,final MappingType mtSource);
	
	/**
	 * This method returns a new instance of Target Class with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td>nullPointerControl</td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
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
	public <D> D oneToMany(Class<D> destinationClass, final T source,final NullPointerControl nullPointerControl,final MappingType mtSource);
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table>
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
	public <D> D oneToMany(D destination,final T source,final MappingType mtDestination,final MappingType mtSource);
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table>
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
	public <D> D oneToMany(D destination,final T source,final NullPointerControl nullPointerControl,final MappingType mtDestination,final MappingType mtSource);
	
}
