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

import java.util.List;

import com.googlecode.jmapper.generation.beans.Constructor;
import com.googlecode.jmapper.generation.beans.Method;

/**
 * Implements this interface if you want define a custom code generation.
 * 
 * @author Alessandro Vurro
 *
 */
public interface ICodeGenerator {
	
	/**
	 * Generates a class with this parameters.
	 * @param clazzName class name
	 * @param constructors list of costructors
	 * @param methods list of methods
	 * @return the generated class
	 * @throws Throwable any error made ​​by the generation of the mapper
	 */
	Class<?> generate(String clazzName,List<Constructor> constructors,List<Method>	methods) throws Throwable;

}
