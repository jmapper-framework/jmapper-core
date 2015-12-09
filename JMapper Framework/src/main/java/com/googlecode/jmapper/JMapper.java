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

import static com.googlecode.jmapper.generation.MapperBuilder.from;
import static com.googlecode.jmapper.util.GeneralUtility.isNull;

import com.googlecode.jmapper.api.IJMapper;
import com.googlecode.jmapper.api.enums.MappingType;
import com.googlecode.jmapper.api.enums.NullPointerControl;
import com.googlecode.jmapper.config.Error;
import com.googlecode.jmapper.config.JmapperLog;
import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.generation.MapperBuilder;

/**
 * JMapper takes as input two classes, Destination and Source.<br>
 * For Destination, we mean the instance that will be created or enhanced.<br>
 * For Source, we mean the instance containing the data.<br>
 * To execute the mapping, we must before configure one class between Destination and Source.<br><br>
 * for example:
 * <pre><code>
 * class Destination {
 * 
 *  &#64;JMap
 *  String id;
 * 
 *  &#64;JMap("sourceField")
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
 * JMapper&lt;Destination,Source&gt; jmapper = new JMapper&lt;Destination,Source&gt;(Destination.class, Source.class);
 * // new instance
 * Destination destination = jmapper.getDestination(source); 
 * // enrichment
 * jmapper.getDestination(destination, source);</code></pre>
 * @author Alessandro Vurro
 * @param <D> Type of the Destination Class
 * @param <S> Type of Source Class
 */
public final class JMapper<D,S> implements IJMapper<D, S>{
	
	/** mapper that contains all mapping combination */
	private IMapper<D,S> mapper;
	
	/**
	 * This method returns a new instance of Destination Class with this setting:
	 * <table summary = "">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>SOURCE</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS</code></td>
	 * </tr>
	 * </table>
	 * @param source instance that contains the data
	 * @return new instance of destination
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestination(final S source){
        try {
            return mapper.nullVSouAllAll(source);
        } catch (Exception e) {
            JmapperLog.ERROR(e);
        }
        return null;
	}
	
	/**
	 * This method returns a new instance of Destination Class with this setting:
	 * <table summary = "">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>NOT_ANY</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS</code></td>
	 * </tr>
	 * </table>
	 * @param source instance that contains the data
	 * @return new instance of destination
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestinationWithoutControl(final S source){
        try {
            return mapper.nullVNotAllAll(source);
        } catch (Exception e) {
            JmapperLog.ERROR(e);
        }
        return null;
	}
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table summary = "">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>ALL</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS</code></td>
	 * </tr>
	 * </table>
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestination(D destination,final S source){
        try {
            return mapper.vVAllAllAll(destination, source);
        }catch (Exception e) { 
        	JmapperLog.ERROR(e); 
        }
        return null;
	}
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table summary = "">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>NOT_ANY</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS</code></td>
	 * </tr>
	 * </table>
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestinationWithoutControl(D destination,final S source){
        try {
            return mapper.vVNotAllAll(destination, source);
        } catch (Exception e) { 
        	JmapperLog.ERROR(e); 
        }
        return null;
	}
		
	/**
	 * This method returns a new instance of Destination Class with this setting:
	 * <table summary = "">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>SOURCE</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
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
	public D getDestination(final S source,final MappingType mtSource){
		return getDestination(source,NullPointerControl.SOURCE,mtSource);
	}
	
	/**
	 * This method returns a new instance of Destination Class with this setting:
	 * <table summary = "">
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td>nullPointerControl</td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS</code></td>
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
	public D getDestination(final S source,final NullPointerControl nullPointerControl,final MappingType mtSource){
	       try{

        		switch(nullPointerControl){
        			case ALL:
        			case DESTINATION:
        			case SOURCE:	switch(mtSource){
        							case ALL_FIELDS: 			return mapper.nullVSouAllAll(source); 
        							case ONLY_VALUED_FIELDS:	return mapper.nullVSouAllValued(source);
        							case ONLY_NULL_FIELDS:		return mapper.get(source);}
        			case NOT_ANY:	switch(mtSource){
        							case ALL_FIELDS: 			return mapper.nullVNotAllAll(source); 
        							case ONLY_VALUED_FIELDS:	return mapper.nullVNotAllValued(source);
        							case ONLY_NULL_FIELDS:		return mapper.get(source);}}
	       
	       }catch (Exception e) { 
	    	   JmapperLog.ERROR(e);
	       }
	       return null;
	}
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table summary = "">
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
	public D getDestination(D destination,final S source,final MappingType mtDestination,final MappingType mtSource){
			return getDestination(destination,source,NullPointerControl.ALL,mtDestination,mtSource);
	}
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table summary = "">
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
	public D getDestination(D destination,final S source,final NullPointerControl nullPointerControl,final MappingType mtDestination,final MappingType mtSource){
	    try{

    		switch(nullPointerControl){
    		case ALL:			switch(mtDestination){
    							case ALL_FIELDS: 			switch(mtSource){
    														case ALL_FIELDS:  			return mapper.vVAllAllAll(destination,source); 
    														case ONLY_VALUED_FIELDS:	return mapper.vVAllAllValued(destination,source); 
    														case ONLY_NULL_FIELDS:		return mapper.vVAllValuedNull(destination,source); }
    							case ONLY_VALUED_FIELDS: 	switch(mtSource){
    														case ALL_FIELDS: 			return mapper.vVAllValuedAll(destination,source); 
    														case ONLY_VALUED_FIELDS: 	return mapper.vVAllValuedValued(destination,source); 
    														case ONLY_NULL_FIELDS:		return mapper.vVAllValuedNull(destination,source); } 
    							case ONLY_NULL_FIELDS:		switch(mtSource){
    														case ALL_FIELDS:			
    														case ONLY_VALUED_FIELDS: 	return mapper.vVAllNullValued(destination,source); 
    														case ONLY_NULL_FIELDS:		return destination;}}
    		case DESTINATION: 	switch(mtDestination){
    							case ALL_FIELDS: 			switch(mtSource){
    														case ALL_FIELDS: 			return mapper.vVDesAllAll(destination,source); 
    														case ONLY_VALUED_FIELDS: 	return mapper.vVDesAllValued(destination,source); 
    														case ONLY_NULL_FIELDS:		return mapper.vVDesValuedNull(destination,source); }
    							case ONLY_VALUED_FIELDS: 	switch(mtSource){
    														case ALL_FIELDS: 			return mapper.vVDesValuedAll(destination,source); 
    														case ONLY_VALUED_FIELDS: 	return mapper.vVDesValuedValued(destination,source); 
    														case ONLY_NULL_FIELDS:		return mapper.vVDesValuedNull(destination,source); }
    							case ONLY_NULL_FIELDS:		switch(mtSource){
    														case ALL_FIELDS: 
    														case ONLY_VALUED_FIELDS: 	return mapper.vVDesNullValued(destination,source); 
    														case ONLY_NULL_FIELDS:		return destination;}}
    		case SOURCE: 		switch(mtDestination){
    							case ALL_FIELDS: 			switch(mtSource){
    														case ALL_FIELDS: 			return mapper.vVSouAllAll(destination,source); 
    														case ONLY_VALUED_FIELDS: 	return mapper.vVSouAllValued(destination,source); 
    														case ONLY_NULL_FIELDS:		return mapper.vVSouValuedNull(destination,source); }
    							case ONLY_VALUED_FIELDS: 	switch(mtSource){
    														case ALL_FIELDS: 			return mapper.vVSouValuedAll(destination,source); 
    														case ONLY_VALUED_FIELDS: 	return mapper.vVSouValuedValued(destination,source); 
    														case ONLY_NULL_FIELDS:		return mapper.vVSouValuedNull(destination,source); }
    							case ONLY_NULL_FIELDS:		switch(mtSource){
    														case ALL_FIELDS: 
    														case ONLY_VALUED_FIELDS: 	return mapper.vVSouNullValued(destination,source); 
    														case ONLY_NULL_FIELDS:		return destination;}}
    		case NOT_ANY:		switch(mtDestination){
    							case ALL_FIELDS: 			switch(mtSource){
    														case ALL_FIELDS: 			return mapper.vVNotAllAll(destination,source); 
    														case ONLY_VALUED_FIELDS: 	return mapper.vVNotAllValued(destination,source); 
    														case ONLY_NULL_FIELDS:		return mapper.vVNotValuedNull(destination,source); }
    							case ONLY_VALUED_FIELDS: 	switch(mtSource){
    														case ALL_FIELDS: 			return mapper.vVNotValuedAll(destination,source); 
    														case ONLY_VALUED_FIELDS: 	return mapper.vVNotValuedValued(destination,source); 
    														case ONLY_NULL_FIELDS:		return mapper.vVNotValuedNull(destination,source); }
    							case ONLY_NULL_FIELDS:		switch(mtSource){
    														case ALL_FIELDS: 
    														case ONLY_VALUED_FIELDS: 	return mapper.vVNotNullValued(destination,source); 
    														case ONLY_NULL_FIELDS:		return destination;}}
    		}
	    }catch (Exception e) { 
	    	JmapperLog.ERROR(e); 
	    }
	    return null;
	}
	
	/**
	 * Constructs a JMapper that handles two classes: the class of destination and the class of source.
	 * <br>Configuration will be searched automatically.
	 * 
	 * @param destination the Destination Class
	 * @param source the Source Class
	 */
	public JMapper(final Class<D> destination,final  Class<S> source) {
		this(destination,source,null,null);
	}
	
	/**
	 * Constructs a JMapper that handles two classes: the class of destination and the class of source.
	 * <br>The configuration evaluated is the one received in input.
	 *  
	 * @param destination the Destination Class
	 * @param source the Source Class
	 * @param chooseConfig the configuration to load
	 * @see ChooseConfig
	 */
	public JMapper(final Class<D> destination,final Class<S> source,final ChooseConfig chooseConfig) {
		this(destination,source,chooseConfig,null);
	}
	
	/**
	 * Constructs a JMapper that handles two classes: the class of destination and the class of source.
	 * <br>Taking as input the path to the xml file.
	 *  
	 * @param destination the Destination Class
	 * @param source the Source Class
	 * @param xmlPath xml configuration path
	 * @see ChooseConfig
	 */
	public JMapper(final Class<D> destination,final Class<S> source,final String xmlPath) {
		this(destination,source,null,xmlPath);
	}
	
	/**
	 * Constructs a JMapper that handles two classes: the class of destination and the class of source.
	 * <br>The configuration evaluated is the one received in input present in the xml configuration file.
	 *  
	 * @param destination the Destination Class
	 * @param source the Source Class
	 * @param config the configuration to load
	 * @param xmlPath xml configuration path
	 * @see ChooseConfig
	 */
	public  JMapper(final Class<D> destination,final Class<S> source,final ChooseConfig config,final String xmlPath) {
		try{
			if(isNull(destination)) 	  Error.nullMappedClass("Destination");
			if(isNull(source))            Error.nullMappedClass("Source");
			if(destination.isInterface()) Error.interfaceClass("Destination");
			if(source.isInterface()) 	  Error.interfaceClass("Source");
			
			try{
			
				// checks if destination is instantiable
				destination.newInstance();	            

			}catch(InstantiationException e){
				Error.emptyConstructorAbsent(destination);
			}
			
			this.mapper = createMapper(from(source).to(destination)
					                        .analyzing(config)
					                        .presentIn(xmlPath));  
			
		}catch (Throwable e) { 
			JmapperLog.ERROR(e); 
		}
	}
	
    /**
     * This method is synchornized to avoid creations of the same instance
     * @param mapper mapper generator
     * @return mapper instance
     * @throws Throwable
     */
    private synchronized IMapper<D,S> createMapper(MapperBuilder mapper) throws Throwable{
	    
		Class<IMapper<D,S>> mapperClass = mapper.exist()?mapper.<D,S>get()
				                                        :mapper.<D,S>generate();
		return mapperClass.newInstance();
	}
}