package com.googlecode.jmapper.integrationtest.xml;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.io.ByteArrayOutputStream;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.exceptions.JMapperException;
import com.googlecode.jmapper.integrationtest.operations.bean.AnnotatedExampleClass2;
import com.googlecode.jmapper.integrationtest.operations.bean.Class1;
import com.googlecode.jmapper.integrationtest.operations.bean.Class2;
import com.googlecode.jmapper.integrationtest.operations.bean.Class3;
import com.googlecode.jmapper.xml.Attribute;
import com.googlecode.jmapper.xml.Converter;
import com.googlecode.jmapper.xml.Global;
import com.googlecode.jmapper.xml.XML;
import com.googlecode.jmapper.xml.XmlHandler;

public class XmlHandler2Test extends TestCase {

	private final static XmlHandler xmlHandler = new XmlHandler();
	private final static XML xml = xmlHandler.getXML();
	ByteArrayOutputStream log;
	
	public XmlHandler2Test(){
		log = new ByteArrayOutputStream();
		PropertyConfigurator.configure("log4j.properties");
		Logger.getLogger(JMapper.class).addAppender(new WriterAppender(new SimpleLayout(), log));
	}
	
	@Override
	protected void setUp() throws Exception {
		log.reset();
	}
	
	public void testAddClass(){
		
		String[] excluded = new String[]{"field1Class1","field1Class2","field1Class3"};
		Class<?>[]  classes = new Class []{Class1.class,Class2.class,Class3.class};
		Global global = new Global("prova", classes, excluded);
		
		xmlHandler.addClass(AnnotatedExampleClass2.class, global);
		
		Global result =  xml.globalsLoad().get(AnnotatedExampleClass2.class.getName());
		assertEquals(global, result);
	}
	
	public void testAddClassException(){
			
    	try{
    		xmlHandler.addClass(AnnotatedExampleClass2.class, new Global("globalMapping"));
		}catch(JMapperException e){}
		
		assertEquals("ERROR - XmlMappingClassExistException: AnnotatedExampleClass2 Class is present in the jmapper.xml configuration file"+newLine, log.toString());
	}
	
	public void testDeleteGlobal(){
    	try{
    		xmlHandler.deleteGlobal(AnnotatedExampleClass2.class);
		}catch(JMapperException e){}
		assertNull(xml.globalsLoad().get(AnnotatedExampleClass2.class));
	}
	
	public void testDeleteGlobalException(){
    	try{
    		xmlHandler.deleteGlobal(AnnotatedExampleClass2.class);
		}catch(JMapperException e){}
		assertEquals("ERROR - XmlMappingClassDoesNotExistException: AnnotatedExampleClass2 Class isn't present in the jmapper.xml configuration file"+newLine, log.toString());
	}
	
	public void testAddGlobal(){
		
		String[] excluded = new String[]{"field1Class1","field1Class2","field1Class3"};
		Class<?>[]  classes = new Class []{Class1.class,Class2.class,Class3.class};
		Global global = new Global("prova", classes, excluded);
		
		String[] attributes = new String[]{"field1Class1","field1Class2","field1Class3"};
		Attribute attribute = new Attribute("field1", Converter.toTargetAttributes(attributes), classes);
				
		xmlHandler.addClass(AnnotatedExampleClass2.class, attribute);
		xmlHandler.addGlobal(AnnotatedExampleClass2.class, global);
		Global result =  xml.globalsLoad().get(AnnotatedExampleClass2.class.getName());
		assertEquals(global, result);
	}
	
	public void testAddGlobalException(){
		
    	try{
    		xmlHandler.addGlobal(AnnotatedExampleClass2.class, new Global("globalMapping"));
		}catch(JMapperException e){}
		assertEquals("ERROR - XmlMappingGlobalExistException: global mapping existent from AnnotatedExampleClass2 Class"+newLine, log.toString());
	}
	
	public void testOverrideGlobal(){
		
		String[] excluded = new String[]{"field1Class1","field1Class2","field1Class3"};
		Class<?>[]  classes = new Class []{Class1.class,Class2.class,Class3.class};
		Global global = new Global("override", classes, excluded);
		
		xmlHandler.overrideGlobal(AnnotatedExampleClass2.class, global);
		
		Global result =  xml.globalsLoad().get(AnnotatedExampleClass2.class.getName());
		assertEquals(global, result);
	}
	
	public void testDeleteClass(){
	
			xmlHandler.deleteClass(AnnotatedExampleClass2.class);
			assertEquals(false,xml.getClasses().contains(AnnotatedExampleClass2.class.getName()));
	}
	
	public void testAddAnnotatedClass(){
		
		xmlHandler.addAnnotatedClassAll(AnnotatedExampleClass2.class);

		Global global = xml.globalsLoad().get(AnnotatedExampleClass2.class.getName());
		
		assertEquals("globalMapping", global.getValue());
		assertEquals(3, global.getClasses().length);
		assertEquals("field2", global.getExcluded()[0]);
		
		global = xml.globalsLoad().get(AnnotatedExampleClass2.Inner.class.getName());
		
		assertEquals(null, global.getValue());
		assertEquals(null, global.getClasses());
		assertEquals(null, global.getExcluded());
		
	}
	
	public void testOverrideAnnotatedClass(){
		
		xmlHandler.overrideAnnotatedClass();

		Global global = xml.globalsLoad().get(AnnotatedExampleClass2.class.getName());

		assertEquals("globalMapping", global.getValue());
		
	}

	public void testCleanAnnotatedClass(){
		
		xmlHandler.cleanAnnotatedClassAll(AnnotatedExampleClass2.class);
				
	}
	
	public void testFromXmlToAnnotation(){
		
		xmlHandler.fromXmlToAnnotationAll(AnnotatedExampleClass2.class);
		
	}
	
	public void testDeleteAnnotatedClasses(){
		
		xmlHandler.deleteAnnotatedClasses();
		
		assertNull(xml.globalsLoad().get(AnnotatedExampleClass2.class.getName()));
	}

}
