package com.googlecode.jmapper.integrationtest.conversions;

import com.googlecode.jmapper.integrationtest.conversions.bean.DExplicitConversion2;
import com.googlecode.jmapper.integrationtest.conversions.bean.SExplicitConversion2;
import junit.framework.TestCase;
import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;

public class ExplicitConversionTest2 extends TestCase{
JMapper<DExplicitConversion2, SExplicitConversion2> mapper;
	
	@Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		
		mapper  = new JMapper<DExplicitConversion2, SExplicitConversion2>(DExplicitConversion2.class, SExplicitConversion2.class);
	}
	
	public void testExplicitConversion(){
		SExplicitConversion2 source = new SExplicitConversion2("source field");
		DExplicitConversion2 destination = mapper.getDestination(source);
		assertEquals("source field converted", destination.getField1());
		assertEquals("source field converted", destination.getField2());
		assertEquals("source field", destination.getField3());
	}
}
