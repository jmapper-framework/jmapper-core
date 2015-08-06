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

package com.googlecode.jmapper.generation;

import static com.googlecode.jmapper.util.GeneralUtility.list;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.reflections.Reflections;

import com.googlecode.jmapper.IMapper;
import com.googlecode.jmapper.generation.beans.Constructor;
import com.googlecode.jmapper.generation.beans.Method;

/**
 * This Class generates Mapper starting from the mappings.
 * @author Alessandro Vurro
 *
 */
public class MapperGenerator {

	
	/** 
	 * @param mapping parameter that containts the mappings
	 * @param dynamicMethods dynamic methods to add
	 * @return a new instance of IMapper interface, following the mappingBuilder specifications
	 * @throws Throwable 
	 */
	public static Class<?> generateMapperClass(MapperConstructor mapping, Set<Method> dynamicMethods) throws Throwable{
		
		// adds empty constructor
		ArrayList<Constructor> constructors = list(new Constructor());

		// adds methods to generate
		Map<String, String> mappings = mapping.getMappings();

		ArrayList<Method> methods = new ArrayList<Method>(dynamicMethods);
		for (java.lang.reflect.Method method : IMapper.class.getDeclaredMethods())
									// construction of the method signature
			methods.add(new Method(method.getReturnType(), method.getParameterTypes(), method.getName())
									// construction of the method body
									.setBody("{"+mappings.get(method.getName())+"}"));
		
		String className = mapping.getMapperName();
		
		//TODO da gestire in modo statico, evitare il ricalcolo
		// loading of all implementations of ICodeGenerator interface
		Set<Class<? extends ICodeGenerator>> generators = new Reflections("com.googlecode.jmapper.generation.impl").getSubTypesOf(ICodeGenerator.class);
		
		// if no explicit implementation is provided use the dafault generator
		ICodeGenerator generator = generators.isEmpty()? new JavassistGenerator():generators.iterator().next().newInstance();
		
		// manages here all special characters
		for (Method method : methods) 
			method.setBody(replace(method.getBody()));
		
		return generator.generate(className, constructors, methods);
	}
	
	/**
	 * Replacement for special charaters.
	 * @param str string to replace
	 * @return string replaced
	 */
	private static String replace(String str){
		return str.replaceAll(Pattern.quote("$"), "\\$");
	}
}