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

package com.googlecode.jmapper.generation;

import static com.googlecode.jmapper.util.GeneralUtility.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.googlecode.jmapper.IMapper;
import com.googlecode.jmapper.config.Error;
import com.googlecode.jmapper.generation.beans.Constructor;
import com.googlecode.jmapper.generation.beans.Field;
import com.googlecode.jmapper.generation.beans.Method;

import javassist.CannotCompileException;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * This Class generates Mapper starting from the mappings.
 * @author Alessandro Vurro
 *
 */
public class MapperGenerator {

	static{
		// ClassPool initialization
		ClassPool.getDefault().insertClassPath(new ClassClassPath(IMapper.class));
	}
	
	/** 
	 * @param mapping parameter that containts the mappings
	 * @return a new instance of IMapper interface, following the mappingBuilder specifications
	 * @throws Exception 
	 * @throws NotFoundException 
	 */
	public static Class<?> generateMapperClass(MapperConstructor mapping, Set<Method> methodsToGenerate) throws NotFoundException, Exception{
		
		// adds empty constructor
		ArrayList<Constructor> constructors = list(new Constructor());

		// adds methods to generate
		Map<String, String> mappings = mapping.getMappings();

		ArrayList<Method> methods = new ArrayList<Method>(methodsToGenerate);
		for (java.lang.reflect.Method method : IMapper.class.getDeclaredMethods())
									// construction of the method signature
			methods.add(new Method(method.getReturnType(), method.getParameterTypes(), method.getName())
									// construction of the method body
									.setBody("{"+mappings.get(method.getName())+"}"));
		
		String className = mapping.getMapperName();
		return generateClass(className, constructors, methods, new ArrayList<Field>());
	}
	
	/**
	 * Generates the class starting from some data.
	 * 
	 * @param clazzName The class that will be generated
	 * @param superClazzName superClass of clazzName
	 * @param constructors constructors of the class that will be generated
	 * @param methods methods of the class that will be generated
	 * @param fields fields of the class that will be generated
	 * @return the generated Class
	 * @throws Exception 
	 * @throws NotFoundException 
	 */
	private static Class<?> generateClass(String clazzName,List<Constructor> constructors,List<Method>	methods,List<Field> fields) throws Exception {
		try{
			ClassPool cp = ClassPool.getDefault();
			// create the class
			CtClass cc = cp.makeClass(clazzName);
			
			// adds the interface
			cc.addInterface(cp.get(IMapper.class.getName()));
			
			// adds the fields
			for (Field field : fields)
				cc.addField(new CtField(cp.get(field.getType().getName()), field.getName(), cc));
			
			// adds constructor
			for (Constructor constructor : constructors) {
				// create constructor
				CtConstructor ctConstructor = new CtConstructor(
						toCtClass(constructor.getParameters()), cc);
				// set body constructor
				ctConstructor.setBody(constructor.getBody());
				// add constructor to CtClass
				cc.addConstructor(ctConstructor);	
			}
			// adds methods
			for (Method method : methods) {
				try{// create method
					CtMethod ctMethod = new CtMethod(cp.get(method.getReturnType().getName()),method.getName(), toCtClass(method.getParameters()), cc);
					// set body method
					ctMethod.setBody(method.getBody());
					// add method to CtClass
					cc.addMethod(ctMethod); }
				catch (CannotCompileException e) { Error.bodyContainsIllegalCode(method,e); } 
			}
			return cc.toClass();
		}catch (NotFoundException e) { Error.notFoundException(e); }
		return null;
	}
	
	/**
	 * This method transforms classes in CtClass[]
	 * @param classes
	 * @return CtClass[] version of classes parameter
	 * @throws Exception
	 */
	public static CtClass[] toCtClass(Class<?>... classes) throws Exception{
		ClassPool cp = ClassPool.getDefault();
		CtClass[] parameters = new CtClass[classes.length];
		for(int i=0;i<classes.length;i++)
			parameters[i]=cp.get(classes[i].getName());
		
		return parameters;
	}
}
