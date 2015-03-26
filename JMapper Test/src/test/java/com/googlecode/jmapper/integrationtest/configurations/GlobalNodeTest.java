package com.googlecode.jmapper.integrationtest.configurations;

import java.io.ByteArrayOutputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.RelationalJMapper;
import com.googlecode.jmapper.exceptions.JMapperException;
import com.googlecode.jmapper.integrationtest.configurations.bean.JGlobalMapD;
import com.googlecode.jmapper.integrationtest.configurations.bean.JGlobalMapD2;
import com.googlecode.jmapper.integrationtest.configurations.bean.JGlobalMapD3;
import com.googlecode.jmapper.integrationtest.configurations.bean.JGlobalMapD6;
import com.googlecode.jmapper.integrationtest.configurations.bean.JGlobalMapS;
import com.googlecode.jmapper.integrationtest.configurations.bean.JGlobalMapS2;
import com.googlecode.jmapper.integrationtest.configurations.bean.JGlobalMapS3;
import com.googlecode.jmapper.util.GeneralUtility;

import junit.framework.TestCase;

public class GlobalNodeTest extends TestCase {
	
	ByteArrayOutputStream log;
	@Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		log = new ByteArrayOutputStream();  
		Logger.getLogger(JMapper.class).addAppender(new WriterAppender(new SimpleLayout(), log));
	}
	
	public void testGlobalNode(){
		JMapper<JGlobalMapD, JGlobalMapS> mapper;
		mapper = new JMapper<JGlobalMapD, JGlobalMapS>(JGlobalMapD.class, JGlobalMapS.class,"configurations/global.xml");
		 
		JGlobalMapD destination = mapper.getDestination(new JGlobalMapS("field1", "field2", "field3"));
		
		assertEquals("field1", destination.getField());
		assertEquals("field2", destination.getField2());
		assertEquals(null, destination.getField3());
		
	}
	
	public void testGlobalNode2(){
		JMapper<JGlobalMapD2, JGlobalMapS2> mapper;
		mapper = new JMapper<JGlobalMapD2, JGlobalMapS2>(JGlobalMapD2.class, JGlobalMapS2.class,"configurations/global.xml");
		 
		JGlobalMapD2 destination = mapper.getDestination(new JGlobalMapS2("field1", "field2", "field3"));
		
		assertEquals("field1", destination.getField());
		assertEquals("field2", destination.getField2());
		assertEquals("field3", destination.getField3());
		
	}
	
	public void testGlobalNode3(){
		JMapper<JGlobalMapD3, JGlobalMapS3> mapper;
		mapper = new JMapper<JGlobalMapD3, JGlobalMapS3>(JGlobalMapD3.class, JGlobalMapS3.class,"configurations/global.xml");
		 
		JGlobalMapD3 destination = mapper.getDestination(new JGlobalMapS3("field1", "field2", "field3"));
		
		assertEquals("field1", destination.getField());
		assertEquals("field2", destination.getField2());
		assertEquals(null, destination.getField3());
		
	}
	
	public void testGlobalNode4(){
		JMapper<JGlobalMapD, JGlobalMapS> mapper;
		mapper = new JMapper<JGlobalMapD, JGlobalMapS>(JGlobalMapD.class, JGlobalMapS.class,"configurations/global2.xml");
		 
		JGlobalMapD destination = mapper.getDestination(new JGlobalMapS("field1", "field2", "field3"));
		
		assertEquals("field2", destination.getField());
		assertEquals("field2", destination.getField2());
		assertEquals("field2", destination.getField3());
		
	}
	
	public void testGlobalNode5(){
		PropertyConfigurator.configure("log4j.properties");
		
		JMapper<JGlobalMapD2, JGlobalMapS2> mapper;
		mapper = new JMapper<JGlobalMapD2, JGlobalMapS2>(JGlobalMapD2.class, JGlobalMapS2.class,"configurations/global2.xml");
		 
		JGlobalMapD2 destination = mapper.getDestination(new JGlobalMapS2("field1", "field2", "field3"));
		
		assertEquals("field1", destination.getField());
		assertEquals("field1", destination.getField2());
		assertEquals("field1", destination.getField3());
		
	}
	
	public void testGlobalNode6(){
		JMapper<JGlobalMapD3, JGlobalMapS3> mapper;
		mapper = new JMapper<JGlobalMapD3, JGlobalMapS3>(JGlobalMapD3.class, JGlobalMapS3.class,"configurations/global2.xml");
		 
		JGlobalMapD3 destination = mapper.getDestination(new JGlobalMapS3("field1", "field2", "field3"));
		
		assertEquals("field2", destination.getField());
		assertEquals("field2", destination.getField2());
		assertEquals("field2", destination.getField3());
		
	}
	
	public void testGlobalNode7(){
		JMapper<JGlobalMapD6, JGlobalMapS> mapper;
		mapper = new JMapper<JGlobalMapD6, JGlobalMapS>(JGlobalMapD6.class, JGlobalMapS.class,"configurations/global.xml");
		 
		JGlobalMapD6 destination = mapper.getDestination(new JGlobalMapS("field1", "field2", "field3"));
		
		assertEquals(null, destination.getField());
		assertEquals("field2", destination.getField2());
		assertEquals(null, destination.getField3());
		
		JMapper<JGlobalMapD6, JGlobalMapS2> mapper2;
		mapper2 = new JMapper<JGlobalMapD6, JGlobalMapS2>(JGlobalMapD6.class, JGlobalMapS2.class,"configurations/global.xml");
		 
		JGlobalMapD6 destination2 = mapper2.getDestination(new JGlobalMapS2("field1", "field2", "field3"));
		
		assertEquals("field1", destination2.getField());
		assertEquals(null, destination2.getField2());
		assertEquals("field3", destination2.getField3());
	}
	
	public void testGlobalNode8(){
		RelationalJMapper<JGlobalMapD6> mapper;
		mapper = new RelationalJMapper<JGlobalMapD6>(JGlobalMapD6.class,"configurations/global.xml");
		 
		JGlobalMapD6 destination = mapper.manyToOne(new JGlobalMapS("field1", "field2", "field3"));
		
		assertEquals(null, destination.getField());
		assertEquals("field2", destination.getField2());
		assertEquals(null, destination.getField3());
		
		JGlobalMapD6 destination2 = mapper.manyToOne(new JGlobalMapS2("field1", "field2", "field3"));
		
		assertEquals("field1", destination2.getField());
		assertEquals(null, destination2.getField2());
		assertEquals("field3", destination2.getField3());
	}
	
	public void testGlobalNode9(){
    	try{
    		new RelationalJMapper<JGlobalMapD3>(JGlobalMapD3.class,"configurations/globalException.xml");
		}catch(JMapperException e){}
		 
		assertEquals("ERROR - MappingErrorException: the global configuration, of the JGlobalMapD3 Class, doesn't contain classes"+GeneralUtility.newLine,log.toString());	
	}
}
