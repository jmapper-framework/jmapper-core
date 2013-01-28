package com.googlecode.jmapper.xml;

import com.googlecode.jmapper.conversions.explicit.ConversionMethod;
import com.googlecode.jmapper.xml.Attribute;
import com.googlecode.jmapper.xml.XmlConverter;
import com.googlecode.jmapper.xml.beans.XmlAttribute;
import com.googlecode.jmapper.xml.beans.XmlClass;
import com.googlecode.jmapper.xml.beans.XmlConversion;

import com.googlecode.jmapper.bean.AnnotatedClass;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.bean.MappedObject;
import com.googlecode.jmapper.bean.SimpleClass;
import junit.framework.TestCase;

public class XmlConverterTest extends TestCase{
 
	public void testToConversionMethod() throws SecurityException, NoSuchMethodException{
		ConversionMethod method = XmlConverter.toConversionMethod(AnnotatedClass.class.getDeclaredMethod("get",new Class[]{String.class}));
		assertEquals("get", method.getName());
		assertEquals("source", method.getFrom()[0]);
		assertEquals("destination", method.getTo()[0]);
		assertEquals("STATIC", method.getType().toString());
		assertEquals("not needed", method.getContent());
	}
	
	public void testToConversionMethod2() throws SecurityException, NoSuchMethodException{
		XmlConversion xml = new XmlConversion("get", "source", "destination", "static", "content");
		ConversionMethod method = XmlConverter.toConversionMethod(xml);
		assertEquals("get", method.getName());
		assertEquals("source", method.getFrom()[0]);
		assertEquals("destination", method.getTo()[0]);
		assertEquals("STATIC", method.getType().toString());
		assertEquals("content", method.getContent());
		
		xml = new XmlConversion("get", "source", "destination", null, "content");
		method = XmlConverter.toConversionMethod(xml);
		assertEquals("get", method.getName());
		assertEquals("source", method.getFrom()[0]);
		assertEquals("destination", method.getTo()[0]);
		assertEquals("STATIC", method.getType().toString());
		assertEquals("content", method.getContent());
	}
	
	public void testToXmlClass(){
		XmlClass xmlClass = XmlConverter.toXmlClass(MappedObject.class);
		assertEquals(MappedObject.class.getName(), xmlClass.name);
		assertEquals("field",xmlClass.attributes.get(0).name);
		assertEquals("field",xmlClass.attributes.get(0).value.name);
	}
	
	public void testToXmlAttribute() throws SecurityException, NoSuchFieldException, ClassNotFoundException{
		
		// FROM ANNOTATIONS
		XmlAttribute xmlAttribute = XmlConverter.toXmlAttribute(AnnotatedClass.class.getDeclaredField("field"));
		field1(xmlAttribute);
		
		Attribute attribute = XmlConverter.toAttribute(xmlAttribute);
		field1(attribute);
		
		xmlAttribute = XmlConverter.toXmlAttribute(AnnotatedClass.class.getDeclaredField("field2"));
		field2(xmlAttribute);
		
		attribute = XmlConverter.toAttribute(xmlAttribute);
		field2(attribute);
		
		// FROM ATTRIBUTES
		attribute = new Attribute("field", "", new String[]{"","targetField2"}, new Class[]{SimpleClass.class,ComplexClass.class});
		xmlAttribute = XmlConverter.toXmlAttribute(attribute);
		field1(xmlAttribute);
		
		attribute = XmlConverter.toAttribute(xmlAttribute);
		field1(attribute);
		
		attribute = new Attribute("field2", "targetField1");
		xmlAttribute = XmlConverter.toXmlAttribute(attribute);
		field2(xmlAttribute);
		
		attribute = XmlConverter.toAttribute(xmlAttribute);
		field2(attribute);
		
	}
	
	
	private void field1(XmlAttribute attribute){
		assertEquals("field", attribute.name);
		assertNotNull(attribute.value);
		assertEquals("field",attribute.value.name);
		
		assertEquals("field", attribute.attributes.get(0).name);
		assertEquals(SimpleClass.class.getName(),attribute.classes.get(0).name);
		
		assertEquals("targetField2", attribute.attributes.get(1).name);
		assertEquals(ComplexClass.class.getName(),attribute.classes.get(1).name);
	}
	
	private void field2(XmlAttribute attribute){
		assertEquals("field2", attribute.name);
		
		assertNotNull(attribute.value);
		assertEquals("targetField1", attribute.value.name);
		
		assertNull(attribute.attributes);
		assertNull(attribute.classes);
	}
	
	private void field1(Attribute attribute){
		assertEquals("field", attribute.getName());
		assertNotNull(attribute.getValue());
		assertEquals("field",attribute.getValue());
		
		assertEquals("field", attribute.getAttributes()[0]);
		assertEquals(SimpleClass.class,attribute.getClasses()[0]);
		
		assertEquals("targetField2", attribute.getAttributes()[1]);
		assertEquals(ComplexClass.class,attribute.getClasses()[1]);
	}
	
	private void field2(Attribute attribute){
		assertEquals("field2", attribute.getName());
		
		assertNotNull(attribute.getValue());
		assertEquals("targetField1", attribute.getValue());
		
		assertNull(attribute.getAttributes());
		assertNull(attribute.getClasses());
	}
	
}
