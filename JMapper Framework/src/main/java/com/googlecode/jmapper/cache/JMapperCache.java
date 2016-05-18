/**
 * Copyright (C) 2012 - 2016 Alessandro Vurro.
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
package com.googlecode.jmapper.cache;

import static com.googlecode.jmapper.util.ClassesManager.mapperClassName;
import static com.googlecode.jmapper.util.FilesManager.isPath;
import static com.googlecode.jmapper.util.GeneralUtility.isEmpty;
import static com.googlecode.jmapper.util.GeneralUtility.isNull;
import static com.googlecode.jmapper.util.GeneralUtility.write;

import java.util.HashMap;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.RelationalJMapper;
import com.googlecode.jmapper.api.IJMapper;
import com.googlecode.jmapper.api.IRelationalJMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import com.googlecode.jmapper.enums.ChooseConfig;

/**
 * JMapperCache permits to manage multiple instance of JMapper and RelationalJMapper.
 * 
 * All mappers created are saved in cache, created only if they don't exist.
 * 
 * @author Alessandro Vurro
 *
 */
public class JMapperCache {

	/** cache of JMapper instances */
	private static HashMap<String, IJMapper<?,?>> mapperCache = new HashMap<String, IJMapper<?,?>>();
	
	/** cache of RelationalJMapper instances */
	private static HashMap<String, IRelationalJMapper<?>> relationalMapperCache = new HashMap<String, IRelationalJMapper<?>>();
	
	/**
	 * Returns an instance of JMapper from cache if exists, in alternative a new instance.
	 * 
	 * @param destination the Destination Class
	 * @param source the Source Class
	 * @param <D> Destination class
	 * @param <S> Source Class
	 * @return the mapper instance
	 */
	public static <D,S> IJMapper<D, S> getMapper(final Class<D> destination, final Class<S> source){
		return getMapper(destination,source, undefinedConfig());
	}
	
	/**
	 * Returns an instance of JMapper from cache if exists, in alternative a new instance.
	 * <br>The configuration evaluated is the one received in input.
	 *  
	 * @param destination the Destination Class
	 * @param source the Source Class
	 * @param chooseConfig the configuration to load
	 * @param <D> Destination class
	 * @param <S> Source Class
	 * @return the mapper instance
	 */
	public static <D,S> IJMapper<D, S> getMapper(final Class<D> destination,final Class<S> source,final ChooseConfig chooseConfig) {
		return getMapper(destination,source,chooseConfig,undefinedXML());
	}
	
	/**
	 * Returns an instance of JMapper from cache if exists, in alternative a new instance.
	 * <br>Taking configuration by API.
	 *  
	 * @param destination the Destination Class
	 * @param source the Source Class
	 * @param api JMapperAPI configuration
	 * @param <D> Destination class
	 * @param <S> Source Class
	 * @return the mapper instance
	 */
	public static <D,S> IJMapper<D, S> getMapper(final Class<D> destination,final Class<S> source,final JMapperAPI api) {
		return getMapper(destination,source,api.toXStream().toString());
	}
	
	/**
	 * Returns an instance of JMapper from cache if exists, in alternative a new instance.
	 * <br>Taking configuration by API.
	 *  
	 * @param destination the Destination Class
	 * @param source the Source Class
	 * @param config the configuration to load
	 * @param api JMapperAPI configuration
	 * @param <D> Destination class
	 * @param <S> Source Class
	 * @return the mapper instance
	 */
	public static <D,S> IJMapper<D, S> getMapper(final Class<D> destination,final Class<S> source, final ChooseConfig config, final JMapperAPI api) {
		return getMapper(destination, source, config, api.toXStream().toString());
	}
	/**
	 * Returns an instance of JMapper from cache if exists, in alternative a new instance.
	 * <br>Taking as input the path to the xml file or the content.
	 *  
	 * @param destination the Destination Class
	 * @param source the Source Class
	 * @param xml xml configuration as content or path format
	 * @param <D> Destination class
	 * @param <S> Source Class
	 * @return the mapper instance
	 */
	public static <D,S> IJMapper<D, S> getMapper(final Class<D> destination,final Class<S> source,final String xml) {
		return getMapper(destination,source,null,xml);
	}
	
	/**
	 * Returns an instance of JMapper from cache if exists, in alternative a new instance.
	 * <br>The configuration evaluated is the one received in input present in the xml configuration.
	 *  
	 * @param destination the Destination Class
	 * @param source the Source Class
	 * @param config the configuration to load
	 * @param xml xml configuration as content or path format
	 * @param <D> Destination class
	 * @param <S> Source Class
	 * @return the mapper instance
	 */
	@SuppressWarnings("unchecked")
	public static synchronized <D,S> IJMapper<D, S> getMapper(final Class<D> destination,final Class<S> source,final ChooseConfig config,final String xml) {
		
		String mapperName = mapperClassName(destination, source, xml);
		
		if(mapperCache.containsKey(mapperName)) 
			return (IJMapper<D, S>) mapperCache.get(mapperName);
			
		IJMapper<D, S> jmapper = new JMapper<D, S>(destination, source, config, xml);
		mapperCache.put(mapperName, jmapper);
		return jmapper;
	}
	
	/**
	 * Returns an instance of RelationalJMapper from cache if exists, in alternative a new instance.
	 * <br>Takes in input only the annotated Class
	 * @param configuredClass configured class
	 * @param <T> Mapped class type
	 * @return the mapper instance
	 */
	public static <T> IRelationalJMapper<T> getRelationalMapper(final Class<T> configuredClass){
		return getRelationalMapper(configuredClass, undefinedXML());
	}
	
	/**
	 * Returns an instance of JMapper from cache if exists, in alternative a new instance.
	 * <br>Takes in input the configured Class and the configuration in API format.
	 * @param configuredClass configured class
	 * @param jmapperAPI the configuration
	 * @param <T> Mapped class type
	 * @return the mapper instance
	 */
	public static <T> IRelationalJMapper<T> getRelationalMapper(final Class<T> configuredClass, JMapperAPI jmapperAPI){
		return getRelationalMapper(configuredClass, jmapperAPI.toXStream().toString());
	}
	
	/**
	 * Returns an instance of JMapper from cache if exists, in alternative a new instance.
	 * <br>Takes in input only the configured Class and the xml mapping path or the xml as String format.
	 * @param configuredClass configured class
	 * @param xml XML path or xml as String
	 * @param <T> Mapped class type
	 * @return the mapper instance
	 */
	@SuppressWarnings("unchecked")
	public static synchronized <T> IRelationalJMapper<T> getRelationalMapper(final Class<T> configuredClass, String xml){
		
		String mapperName = relationalMapperName(configuredClass, xml);
		
		if(relationalMapperCache.containsKey(mapperName)) 
			return (IRelationalJMapper<T>) relationalMapperCache.get(mapperName);
			
		IRelationalJMapper<T> relationalJMapper = !isNull(xml) ? new RelationalJMapper<T>(configuredClass, xml)
				                                               : new RelationalJMapper<T>(configuredClass);
		
		relationalMapperCache.put(mapperName, relationalJMapper);
		return relationalJMapper;
	}
	 /**
     * This method is used to call a signature passing a null ChooseConfig instance.
     * @return a ChooseConfig not valorized
     */
    private static ChooseConfig undefinedConfig(){
		return null;
	}

    /**
     * This method is used to call a signature passing a null String instance.
     * @return an XML not valorized
     */
    private static String undefinedXML(){
		return null;
	}
    
    /**
	 * Returns a unique name that identify this relationalMapper.
	 * 
	 * @param configuredClass configured class
	 * @param resource resource to analyze
	 * @return Returns a string that represents the identifier for this relationalMapper instance
	 */
	private static String relationalMapperName(Class<?> configuredClass, String resource){
		
		String className = configuredClass.getName().replaceAll("\\.","");
		
		if(isEmpty(resource)) 
			return className;
		
		if(!isPath(resource))
			return write(className, String.valueOf(resource.hashCode()));
		
		String[]dep = resource.split("\\\\");
		if(dep.length<=1)dep = resource.split("/");
		String xml = dep[dep.length-1];
		return write(className, xml.replaceAll("\\.","").replaceAll(" ",""));
	}
}
