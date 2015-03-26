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
import com.googlecode.jmapper.integrationtest.configurations.bean.JGlobalMapD4;
import com.googlecode.jmapper.integrationtest.configurations.bean.JGlobalMapD5;
import com.googlecode.jmapper.integrationtest.configurations.bean.JGlobalMapD6;
import com.googlecode.jmapper.integrationtest.configurations.bean.JGlobalMapS;
import com.googlecode.jmapper.integrationtest.configurations.bean.JGlobalMapS2;
import com.googlecode.jmapper.integrationtest.configurations.bean.JGlobalMapS3;
import com.googlecode.jmapper.util.GeneralUtility;

import junit.framework.TestCase;

public class JGlobalMapTest extends TestCase {

	ByteArrayOutputStream log;
	@Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		log = new ByteArrayOutputStream();  
		Logger.getLogger(JMapper.class).addAppender(new WriterAppender(new SimpleLayout(), log));
	}
	
	public void testJGlobalMap(){
		JMapper<JGlobalMapD, JGlobalMapS> mapper;
		mapper = new JMapper<JGlobalMapD, JGlobalMapS>(JGlobalMapD.class, JGlobalMapS.class);
		 
		JGlobalMapD destination = mapper.getDestination(new JGlobalMapS("field1", "field2", "field3"));
		
		assertEquals("field1", destination.getField());
		assertEquals("field2", destination.getField2());
		assertEquals(null, destination.getField3());
		
	}
	
	public void testJGlobalMap2(){
		JMapper<JGlobalMapD2, JGlobalMapS2> mapper;
		mapper = new JMapper<JGlobalMapD2, JGlobalMapS2>(JGlobalMapD2.class, JGlobalMapS2.class);
		 
		JGlobalMapD2 destination = mapper.getDestination(new JGlobalMapS2("field1", "field2", "field3"));
		
		assertEquals("field1", destination.getField());
		assertEquals("field2", destination.getField2());
		assertEquals("field3", destination.getField3());
		
	}
	
	public void testJGlobalMap3(){
		JMapper<JGlobalMapD3, JGlobalMapS3> mapper;
		mapper = new JMapper<JGlobalMapD3, JGlobalMapS3>(JGlobalMapD3.class, JGlobalMapS3.class);
		 
		JGlobalMapD3 destination = mapper.getDestination(new JGlobalMapS3("field1", "field2", "field3"));
		
		assertEquals("field1", destination.getField());
		assertEquals("field2", destination.getField2());
		assertEquals(null, destination.getField3());
		
	}
	
	public void testJGlobalMap4(){
		JMapper<JGlobalMapD4, JGlobalMapS> mapper;
		mapper = new JMapper<JGlobalMapD4, JGlobalMapS>(JGlobalMapD4.class, JGlobalMapS.class);
		 
		JGlobalMapD4 destination = mapper.getDestination(new JGlobalMapS("field1", "field2", "field3"));
		
		assertEquals("field3", destination.getField());
		assertEquals("field3", destination.getField2());
		assertEquals("field3", destination.getField3());
		
	}
	
	public void testJGlobalMap5(){
		JMapper<JGlobalMapD5, JGlobalMapS> mapper;
		mapper = new JMapper<JGlobalMapD5, JGlobalMapS>(JGlobalMapD5.class, JGlobalMapS.class);
		 
		JGlobalMapD5 destination = mapper.getDestination(new JGlobalMapS("field1", "field2", "field3"));
		
		assertEquals("field3", destination.getField());
		assertEquals("field3", destination.getField2());
		assertEquals("field3", destination.getField3());
		
	}
	
	public void testJGlobalMap6(){
		JMapper<JGlobalMapD6, JGlobalMapS> mapper;
		mapper = new JMapper<JGlobalMapD6, JGlobalMapS>(JGlobalMapD6.class, JGlobalMapS.class);
		 
		JGlobalMapD6 destination = mapper.getDestination(new JGlobalMapS("field1", "field2", "field3"));
		
		assertEquals(null, destination.getField());
		assertEquals(null, destination.getField2());
		assertEquals("field3", destination.getField3());
		
		JMapper<JGlobalMapD6, JGlobalMapS2> mapper2;
		mapper2 = new JMapper<JGlobalMapD6, JGlobalMapS2>(JGlobalMapD6.class, JGlobalMapS2.class);
		 
		JGlobalMapD6 destination2 = mapper2.getDestination(new JGlobalMapS2("field1", "field2", "field3"));
		
		assertEquals("field1", destination2.getField());
		assertEquals("field2", destination2.getField2());
		assertEquals(null, destination2.getField3());
	}
	
	public void testJGlobalMap7(){
		RelationalJMapper<JGlobalMapD6> mapper;
		mapper = new RelationalJMapper<JGlobalMapD6>(JGlobalMapD6.class);
		 
		JGlobalMapD6 destination = mapper.manyToOne(new JGlobalMapS("field1", "field2", "field3"));
		
		assertEquals(null, destination.getField());
		assertEquals(null, destination.getField2());
		assertEquals("field3", destination.getField3());
		
		JGlobalMapD6 destination2 = mapper.manyToOne(new JGlobalMapS2("field1", "field2", "field3"));
		
		assertEquals("field1", destination2.getField());
		assertEquals("field2", destination2.getField2());
		assertEquals(null, destination2.getField3());
	}
	
	public void testJGlobalMap8(){
    	try{
    		new RelationalJMapper<JGlobalMapD3>(JGlobalMapD3.class);
		}catch(JMapperException e){}
		 
		assertEquals("ERROR - MappingErrorException: the global configuration, of the JGlobalMapD3 Class, doesn't contain classes"+GeneralUtility.newLine,log.toString());	
	}
}
