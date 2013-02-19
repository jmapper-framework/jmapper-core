package com.googlecode.jmapper.integrationtest.conversions;

import com.googlecode.jmapper.integrationtest.conversions.bean.DExplicitConversion3;
import com.googlecode.jmapper.integrationtest.conversions.bean.SExplicitConversion3;
import junit.framework.TestCase;
import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;

public class ExplicitConversionTest3 extends TestCase{
JMapper<DExplicitConversion3, SExplicitConversion3> mapper;
	
	@Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		
		mapper  = new JMapper<DExplicitConversion3, SExplicitConversion3>(DExplicitConversion3.class, SExplicitConversion3.class);
	}
	
	public void testExplicitConversion(){
		SExplicitConversion3 source = new SExplicitConversion3(" a string");
		DExplicitConversion3 destination = new DExplicitConversion3("field1", "field2", "field3");
		
		DExplicitConversion3 result = mapper.getDestination(destination, source);
		assertEquals("field1 a string converted", result.getField1());
		assertEquals("field2 a string converted", result.getField2());
		assertEquals("field3 a string converted", result.getField3());
		
		result = mapper.getDestination(source);
		assertEquals("null a string converted", result.getField1());
		assertEquals("null a string converted", result.getField2());
		assertEquals("null a string converted", result.getField3());
	}
}