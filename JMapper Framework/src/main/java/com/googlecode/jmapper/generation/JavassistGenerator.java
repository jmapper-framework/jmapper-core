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
package com.googlecode.jmapper.generation;

import static com.googlecode.jmapper.util.GeneralUtility.isEmpty;
import static com.googlecode.jmapper.util.GeneralUtility.isNull;

import java.util.List;

import com.googlecode.jmapper.DestinationFactory;
import com.googlecode.jmapper.IMapper;
import com.googlecode.jmapper.Mapper;
import com.googlecode.jmapper.config.Error;
import com.googlecode.jmapper.generation.beans.Method;

import javassist.CannotCompileException;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewConstructor;
import javassist.Modifier;
import javassist.NotFoundException;
/**
 * Javassist implementation.
 * 
 * @author Alessandro Vurro
 *
 */
public class JavassistGenerator implements ICodeGenerator {
	
	static{
		// ClassPool initialization
		ClassPool.getDefault().insertClassPath(new ClassClassPath(DestinationFactory.class));
		ClassPool.getDefault().insertClassPath(new ClassClassPath(IMapper.class));
		ClassPool.getDefault().insertClassPath(new ClassClassPath(Mapper.class));
	}
	
	public Class<?> generate(ClassLoader classLoader, String clazzName, List<Method> methods) throws Throwable {
		
		CtClass cc = null;
		
		try{
			ClassPool cp = ClassPool.getDefault();
			
			// create the class
			cc = cp.makeClass(clazzName);
			
			// adds the superclass
			cc.setSuperclass(cp.get(Mapper.class.getName()));
			
			// adds constructor
			CtNewConstructor.defaultConstructor(cc);
			
			// adds methods
			for (Method method : methods) {
				try{
					
					CtClass[] returnTypes = toCtClass(method.getReturnType());
					CtClass[] parameters = toCtClass(method.getParameters());
					
					CtClass returnType = isEmpty(returnTypes) ? CtClass.voidType : returnTypes[0];
					
					// create method
					CtMethod ctMethod = new CtMethod(returnType, method.getName(), parameters, cc);
					// add method to CtClass
					cc.addMethod(ctMethod); 
					// set body method
					ctMethod.setBody(method.getBody());
				
				} catch (CannotCompileException e) {
					System.out.println(method.getBody());
					Error.bodyContainsIllegalCode(method,e); 
				} 
			}
			
			cc.setModifiers(cc.getModifiers() & ~Modifier.ABSTRACT);
			Class<?> generetedClass = cc.toClass(classLoader, this.getClass().getProtectionDomain());
			return generetedClass;
			
		}catch (NotFoundException e) { 
			Error.notFoundException(e); 
			
		}finally{
			if(!isNull(cc)) 
				cc.defrost();
		}
		
		return null;
	}
	
	/**
	 * This method transforms classes in CtClass[]
	 * @param classes
	 * @return CtClass[] version of classes parameter
	 * @throws Exception in case of not found class
	 */
	private static CtClass[] toCtClass(Class<?>... classes) throws Exception{
		ClassPool cp = ClassPool.getDefault();
		
		if(isEmpty(classes) || isNull(classes[0])) 
			return null;
		
		CtClass[] parameters = new CtClass[classes.length];
		for(int i=0;i<classes.length;i++)
			parameters[i]=cp.get(classes[i].getName());
		
		return parameters;
	}
}
