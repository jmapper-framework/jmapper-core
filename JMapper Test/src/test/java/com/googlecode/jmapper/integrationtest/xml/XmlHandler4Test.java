package com.googlecode.jmapper.integrationtest.xml;

import java.io.ByteArrayOutputStream;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.integrationtest.operations.bean.AnnotatedExampleClass3;
import com.googlecode.jmapper.xml.XmlHandler;

public class XmlHandler4Test extends TestCase{
	ByteArrayOutputStream log;
	XmlHandler xmlHandler = new XmlHandler("accessor3.xml");
	
	public XmlHandler4Test(){
		log = new ByteArrayOutputStream();
		PropertyConfigurator.configure("log4j.properties");
		Logger.getLogger(JMapper.class).addAppender(new WriterAppender(new SimpleLayout(), log));
	}
	
	@Override
	protected void setUp() throws Exception {
		log.reset();
	}
	
	public void testFromXmlToAnnotationAccessor(){
		xmlHandler.fromXmlToAnnotation(AnnotatedExampleClass3.class);
	}
	
	public void testCleanAnnotatedClass(){
		xmlHandler.cleanAnnotatedClassAll(AnnotatedExampleClass3.class);
	}
}
