/** 
 * Copyright (C) 2012 - 2014 Alessandro Vurro.
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
package com.googlecode.jmapper.api;

import com.googlecode.jmapper.api.enums.MappingType;
import com.googlecode.jmapper.api.enums.NullPointerControl;

/**
 * JMapper takes as input two classes, Destination and Source.<br>
 * For Destination, we mean the instance that will be created or enhanced.<br>
 * For Source, we mean the instance containing the data.<br>
 * To execute the mapping, we must before configure one class beetween Destination and Source.<br><br>
 * for example:
 * <pre><code>
 * class Destination {
 * 
 *  {@code @JMap}
 *  String id;
 * 
 *  {@code @JMap("sourceField")}
 *  String destinationField;
 *  
 *  String other;
 *  
 *  // getter and setter
 * }
 * 
 * class Source {
 * 
 *  String id;
 * 
 *  String sourceField;
 *  
 *  String other;
 *  
 *  // getter and setter
 * }
 * </code></pre>
 * then invoke the method GetDestination.<br><br>
 * For example:
 * <pre><code>	
 * Source source = new Source("id", "sourceField", "other");
 * JMapper<Destination,Source> jmapper = new JMapper<Destination,Source>(Destination.class, Source.class);
 * // new instance
 * Destination destination = jmapper.getDestination(source); 
 * // enrichment
 * jmapper.getDestination(destination, source);</code></pre>
 * @author Alessandro Vurro
 * @param <D> Type of the Destination Class
 * @param <S> Type of Source Class
 */
public interface IJMapper<D,S> {

	/**
	 * This method returns a new instance of Destination Class with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>SOURCE</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS<code></td>
	 * </tr>
	 * </table>
	 * @param source instance that contains the data
	 * @return new instance of destination
	 * @see NullPointerControl
	 * @see MappingType
	 */
	D getDestination(final S source);	
	
	/**
	 * This method returns a new instance of Destination Class with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>NOT_ANY</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS<code></td>
	 * </tr>
	 * </table>
	 * @param source instance that contains the data
	 * @return new instance of destination
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestinationWithoutControl(final S source);
	
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
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestination(D destination,final S source);
	
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
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestinationWithoutControl(D destination,final S source);
	
	/**
	 * This method returns a new instance of Destination Class with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>SOURCE</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td>mtSource</td>
	 * </tr>
	 * </table>
	 * @param source instance that contains the data
	 * @param mtSource type of mapping
	 * @return new instance of destination
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestination(final S source,final MappingType mtSource);
	
	/**
	 * This method returns a new instance of Destination Class with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td>nullPointerControl</td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td>mtSource</td>
	 * </tr>
	 * </table>
	 * @param source instance that contains the data
	 * @param nullPointerControl type of control
	 * @param mtSource type of mapping
	 * @return new instance of destination
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestination(final S source,final NullPointerControl nullPointerControl,final MappingType mtSource);

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
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @param mtDestination type of mapping of destination instance
	 * @param mtSource type of mapping of source instance 
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestination(D destination,final S source,final MappingType mtDestination,final MappingType mtSource);
	
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
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @param nullPointerControl type of control
	 * @param mtDestination type of mapping of destination instance
	 * @param mtSource type of mapping of source instance 
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestination(D destination,final S source,final NullPointerControl nullPointerControl,final MappingType mtDestination,final MappingType mtSource);




}
