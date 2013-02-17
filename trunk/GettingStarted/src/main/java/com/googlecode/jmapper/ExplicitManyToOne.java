package com.googlecode.jmapper;

import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.RelationalJMapper;
import com.googlecode.jmapper.bean.AnnotatedClass;
import com.googlecode.jmapper.bean.Class1;
import com.googlecode.jmapper.bean.Class2;
import com.googlecode.jmapper.bean.Class3;


public class ExplicitManyToOne {

	public static void main(String[] args){
		PropertyConfigurator.configure("log4j.properties");
		
		AnnotatedClass manyToOne = null;
		
		RelationalJMapper<AnnotatedClass> rm = new RelationalJMapper<AnnotatedClass>(AnnotatedClass.class);
		
		Class3 class3 = new Class3("field1Class3", "field2Class3", "field3Class3");
				
		manyToOne = rm.manyToOne(class3);
		
		System.out.println(manyToOne);
		
		Class2 class2 = new Class2("field1Class2", "field2Class2", "field3Class2");
		
		manyToOne = rm.manyToOne(class2);
		
		System.out.println(manyToOne);
		
		Class1 class1 = new Class1("field1Class1", "field2Class1", "field3Class1");
		
		manyToOne = rm.manyToOne(class1);
		
		System.out.println(manyToOne);
	
	}
}
