package com.googlecode.jmapper;

import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.bean.AnnotatedClass;
import com.googlecode.jmapper.bean.Class1;
import com.googlecode.jmapper.bean.Class2;
import com.googlecode.jmapper.bean.Class3;
import com.googlecode.jmapper.xml.Attribute;
import com.googlecode.jmapper.xml.XmlHandler;


public class XmlHandlerExample {

	public static void main (String[] args){
		PropertyConfigurator.configure("log4j.properties");
		
		XmlHandler xmlHandler = new XmlHandler();

		String[] attributes = new String[]{"field1Class1","field1Class2","field1Class3"};
		Class<?>[]  classes = new Class []{Class1.class,Class2.class,Class3.class};
		Attribute attribute = new Attribute("field1", attributes, classes);
		
		xmlHandler.addClass(AnnotatedClass.class, attribute);
		
		attributes           = new String[]{"field2Class1","field2Class2","field2Class3"};
		classes 			 = new Class []{Class1.class,Class2.class,Class3.class};
		Attribute attribute2 = new Attribute("field2", attributes, classes);
		
		xmlHandler.addAttributes(AnnotatedClass.class, attribute2);
		
		xmlHandler.deleteAttributes(AnnotatedClass.class, "field2");
		
		xmlHandler.overrideClass(AnnotatedClass.class, attribute2);
		
		xmlHandler.deleteClass(AnnotatedClass.class);
		
		xmlHandler.addAnnotatedClass(AnnotatedClass.class);
		
		xmlHandler.overrideAnnotatedClass();
		
		xmlHandler.cleanAnnotatedClass(AnnotatedClass.class);
		
		xmlHandler.fromXmlToAnnotation(AnnotatedClass.class);
	
		xmlHandler.deleteAnnotatedClasses();
		
	}
}
