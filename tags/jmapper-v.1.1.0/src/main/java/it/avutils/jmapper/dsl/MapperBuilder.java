/**
 * Copyright (C) 2012 Alessandro Vurro.
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
package it.avutils.jmapper.dsl;

import static it.avutils.jmapper.dsl.XmlBuilder.loadXml;
import static it.avutils.jmapper.mapper.generation.MapperGenerator.generateMapperClass;
import static it.avutils.jmapper.util.ClassesManager.mapperClassName;

import java.util.HashSet;
import java.util.Set;

import it.avutils.jmapper.config.Error;
import it.avutils.jmapper.enums.ChooseConfig;
import it.avutils.jmapper.mapper.IMapper;
import it.avutils.jmapper.mapper.generation.MappingBuilder;
import it.avutils.jmapper.mapper.generation.beans.Method;
import javassist.NotFoundException;

/**
 * MapperBuilder increases the readability of the code to retrieve the parameters necessary 
 * to create or find a new IMapper class.
 * <br>For example:<pre><code>from(source).to(destination)
     .analyzing(config)
     .presentIn(xmlPath)</code></pre> 
 *    
 * @author Alessandro Vurro
 */
@SuppressWarnings("unchecked")
public class MapperBuilder {
	
	/** @return true if the mapper class exists, false otherwise	 */
	public boolean exist(){
		try {  Class.forName(mapperClassName(destination, source,path)); return true;} 
		catch (ClassNotFoundException e) { return false; }
	}
	
	/** @return the existent mapper class */
	public <D,S> Class<IMapper<D,S>> get(){
		try {  return (Class<IMapper<D,S>>) Class.forName(mapperClassName(destination, source,path));} 
		catch (Exception e) { return null; }
	}
	
	/** @return the generated mapper class */
	public <D,S> Class<IMapper<D,S>> generate() throws NotFoundException, Exception{
		
		/* List of methods to generate.
		 * ConversionHandler returns the methods to create, but there is the probability
		 * that a static method is used in different cases. 
		 * In this way the static method will be loaded only one time */
		Set<Method> methodsToGenerate = new HashSet<Method>();
		
		Class<IMapper<D,S>> mapperClass = (Class<IMapper<D,S>>) generateMapperClass
				(new MappingBuilder(destination,source,config,loadXml(path).atRuntime(),methodsToGenerate)
		 		     .setMapperName(mapperClassName(destination, source,path)),methodsToGenerate);
		
		// a new instance is created to check the mapper implementation
		try{ mapperClass.newInstance();}
		catch (Throwable e) { if(path == null)Error.illegalCode(destination, source, e);
							  else            Error.illegalCode(destination,source,path,e);}
		return mapperClass;
	}
	
	/** destination class */
	private Class<?> destination;
	/** source class */
	private Class<?> source;
	/** configuration chosen from user */
	private ChooseConfig config;
	/** path of the xml file */
	private String path;
	
	/**
	 * Starting point for parameters setting. This method set the source instance variable.
	 * @param source source to set
	 * @return a new instance of MapperBuilder
	 */
	public  static MapperBuilder from(Class<?> source)  {return new MapperBuilder(source);	        }
	/**
	 * This method set the destination instance variable.
	 * @param destination destination to set
	 * @return this instance of MapperBuilder
	 */
	public  MapperBuilder to(Class<?> destination)      {this.destination = destination;return this;}
	/**
	 * This method set the config instance variable.
	 * @param config configuration to set
	 * @return this instance of MapperBuilder
	 */
	public  MapperBuilder analyzing(ChooseConfig config){this.config = config;		   return this; }
	/**
	 * This method set the xmlPath instance variable.
	 * @param xmlPath xml path to set
	 * @return this instance of MapperBuilder
	 */
	public  MapperBuilder presentIn(String xmlPath)     {this.path = xmlPath;	       return this; }
	/**
	 * This is the entry point of MapperBuilder.
	 * @param source source to set
	 */
	private MapperBuilder(Class<?> source)              {this.source = source;}
}
