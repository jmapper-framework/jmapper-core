package com.googlecode.jmapper;

import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.RelationalJMapper;
import com.googlecode.jmapper.bean.AnnotatedClass;
import com.googlecode.jmapper.bean.Class1;
import com.googlecode.jmapper.bean.Class2;
import com.googlecode.jmapper.bean.Class3;


public class ExplicitOneToMany {

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		
		AnnotatedClass annotatedClass = new AnnotatedClass("field1", "field2", "field3");
		
		RelationalJMapper<AnnotatedClass> rm = new RelationalJMapper<AnnotatedClass>(AnnotatedClass.class);
		
		Class1 class1 = rm.oneToMany(Class1.class,annotatedClass);
		System.out.println(class1);
	
		Class2 class2 = rm.oneToMany(Class2.class,annotatedClass);
		System.out.println(class2);

		Class3 class3 = rm.oneToMany(Class3.class,annotatedClass);
		System.out.println(class3);
	}

}
