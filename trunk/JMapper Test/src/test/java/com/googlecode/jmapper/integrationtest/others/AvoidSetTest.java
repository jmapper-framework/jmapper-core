package com.googlecode.jmapper.integrationtest.others;

import java.io.ByteArrayOutputStream;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.enums.MappingType;
import com.googlecode.jmapper.integrationtest.others.bean.DestAvoidSet;
import com.googlecode.jmapper.integrationtest.others.bean.SrcAvoidSet;

public class AvoidSetTest extends TestCase {
	ByteArrayOutputStream log;
	
	public AvoidSetTest() {
		log = new ByteArrayOutputStream();
		PropertyConfigurator.configure("log4j.properties");
		Logger.getLogger(JMapper.class).addAppender(new WriterAppender(new SimpleLayout(), log));
	}
	
	
	/**
	 * ANNOTATION:
	 * Test su metodi di conversione di tipo STATIC e DYNAMIC
	 */
	public void testAvoidSetWithAnnotation(){
		JMapper<DestAvoidSet,SrcAvoidSet> mapper = new JMapper<DestAvoidSet, SrcAvoidSet>(DestAvoidSet.class, SrcAvoidSet.class);
		DestAvoidSet destination = mapper.getDestination(new SrcAvoidSet(new StringBuilder("srcField"), new StringBuilder("field2")), MappingType.ONLY_VALUED_FIELDS);
		assertEquals("srcField", destination.getField().toString());
		assertEquals("avoidSetDYNAMICfield2", destination.getField2().get(0).toString());
	}
	
	public void testAvoidSetWithXml(){
		JMapper<DestAvoidSet,SrcAvoidSet> mapper = new JMapper<DestAvoidSet, SrcAvoidSet>(DestAvoidSet.class, SrcAvoidSet.class,"configurations/avoidset.xml");
		DestAvoidSet destination = mapper.getDestination(new SrcAvoidSet(new StringBuilder("srcField"), new StringBuilder("field2")), MappingType.ONLY_VALUED_FIELDS);
		assertEquals("srcField", destination.getField().toString());
		assertEquals("avoidSetDYNAMICXMLfield2", destination.getField2().get(0).toString());
	}
}
