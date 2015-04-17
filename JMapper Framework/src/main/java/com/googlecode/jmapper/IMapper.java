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

/**
 * <p>This Interface contains all potential combinations between the enumerations:
 * <ul>
 * <li><code>NullPointerControl</code></li>
 * <li><code>MappingType</code> of &lt;D&gt;</il>
 * <li><code>MappingType</code> of &lt;S&gt;</il>
 * </ul>
 * </p> 
 * @author Alessandro Vurro
 *
 * @param <D> Type of the Destination Class
 * @param <S> Type of Source Class
 */
public interface IMapper<D, S> {

	/**
	 * Method used for all cases where a null values must be returned
	 * @param source instance of &lt;S&gt; class
	 * @return a null value
	 */
	D get(S source);
	
	/**
	 * This Method returns a new instance of &lt;D&gt; type applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.SOURCE</code></td><td>only source is controlled</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param source instance that contains the data
	 * @return a new istance of &lt;D&gt; type
	 */
	D nullVSouAllAll(S source);
	
	/**
	 * This Method returns a new instance of &lt;D&gt; type applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.SOURCE</code></td><td>only source is controlled</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param source instance that contains the data
	 * @return a new istance of &lt;D&gt; type
	 */
	D nullVSouAllValued(S source);
	
	/**
	 * This Method returns a new instance of &lt;D&gt; type applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.NOT_ANY</code></td><td>no instance is controlled</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param source instance that contains the data
	 * @return a new istance of &lt;D&gt; type
	 */
	D nullVNotAllAll(S source);
	
	/**
	 * This Method returns a new instance of &lt;D&gt; type applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.NOT_ANY</code></td><td>no instance is controlled</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param source instance that contains the data
	 * @return a new istance of &lt;D&gt; type
	 */
	D nullVNotAllValued(S source);
	
	
	
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.ALL</code></td><td>both instances are controlled</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVAllAllAll(D destination,S source); 
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.ALL</code></td><td>both instances are controlled</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVAllAllValued(D destination,S source);  
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.ALL</code></td><td>both instances are controlled</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVAllValuedAll(D destination,S source);  
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.ALL</code></td><td>both instances are controlled</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVAllValuedValued(D destination,S source); 
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.ALL</code></td><td>both instances are controlled</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_NULL_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVAllValuedNull(D destination,S source);  
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.ALL</code></td><td>both instances are controlled</td></tr>
	 *<tr><td><code>MappingType.ONLY_NULL_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVAllNullValued(D destination,S source);  
	
	
	
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.DESTINATION</code></td><td>only destination is controlled</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVDesAllAll(D destination,S source);  
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.DESTINATION</code></td><td>only destination is controlled</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVDesAllValued(D destination,S source);  

	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.DESTINATION</code></td><td>only destination is controlled</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVDesValuedAll(D destination,S source);  

	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.DESTINATION</code></td><td>only destination is controlled</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVDesValuedValued(D destination,S source);  

	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.DESTINATION</code></td><td>only destination is controlled</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_NULL_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVDesValuedNull(D destination,S source);  

	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.DESTINATION</code></td><td>only destination is controlled</td></tr>
	 *<tr><td><code>MappingType.ONLY_NULL_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVDesNullValued(D destination,S source);  
	
	
	
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.SOURCE</code></td><td>only source is controlled</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVSouAllAll(D destination,S source);  
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.SOURCE</code></td><td>only source is controlled</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVSouAllValued(D destination,S source);  
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.SOURCE</code></td><td>only source is controlled</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVSouValuedAll(D destination,S source);  
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.SOURCE</code></td><td>only source is controlled</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVSouValuedValued(D destination,S source);  
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.SOURCE</code></td><td>only source is controlled</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_NULL_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVSouValuedNull(D destination,S source);  
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.SOURCE</code></td><td>only source is controlled</td></tr>
	 *<tr><td><code>MappingType.ONLY_NULL_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVSouNullValued(D destination,S source);  
	
	
	
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.NOT_ANY</code></td><td>no instance is controlled</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVNotAllAll(D destination,S source);  
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.NOT_ANY</code></td><td>no instance is controlled</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVNotAllValued(D destination,S source);  
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.NOT_ANY</code></td><td>no instance is controlled</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ALL_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVNotValuedAll(D destination,S source);  
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.NOT_ANY</code></td><td>no instance is controlled</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVNotValuedValued(D destination,S source);  
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.NOT_ANY</code></td><td>no instance is controlled</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_NULL_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVNotValuedNull(D destination,S source);  
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * applying these criteria:
	 * <p>
	 *<table>
	 *<tr><td><code>NullPointerControl.NOT_ANY</code></td><td>no instance is controlled</td></tr>
	 *<tr><td><code>MappingType.ONLY_NULL_FIELDS</code></td><td>mapping type applied to destination</td></tr>
	 *<tr><td><code>MappingType.ONLY_VALUED_FIELDS</code></td><td>mapping type applied to source</td></tr>
	 *</table>
	 * </p>
	 * 
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 */
	D vVNotNullValued(D destination,S source);  
	
}
