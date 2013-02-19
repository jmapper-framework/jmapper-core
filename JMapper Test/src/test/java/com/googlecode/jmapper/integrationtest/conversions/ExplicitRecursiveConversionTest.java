package com.googlecode.jmapper.integrationtest.conversions;

import com.googlecode.jmapper.integrationtest.conversions.bean.DExplicitRecursive;
import com.googlecode.jmapper.integrationtest.conversions.bean.SExplicitConversion;
import com.googlecode.jmapper.integrationtest.conversions.bean.SExplicitRecursive;
import junit.framework.TestCase;
import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;

public class ExplicitRecursiveConversionTest extends TestCase{

JMapper<DExplicitRecursive, SExplicitRecursive> mapper;
	
	@Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		
	}
	
	public void testExplicitConversion(){
		mapper  = new JMapper<DExplicitRecursive, SExplicitRecursive>(DExplicitRecursive.class, SExplicitRecursive.class);
		SExplicitRecursive source = new SExplicitRecursive(new SExplicitConversion(10));
		DExplicitRecursive destination = mapper.getDestination(source);
		assertEquals("10 explicit converted", destination.toString());
	}
	
	public void testExplicitXmlConversion(){
		mapper  = new JMapper<DExplicitRecursive, SExplicitRecursive>(DExplicitRecursive.class, SExplicitRecursive.class,"conversions/recursiveTest.xml");
		SExplicitRecursive source = new SExplicitRecursive(new SExplicitConversion(10));
		DExplicitRecursive destination = mapper.getDestination(source);
		assertEquals("10 explicit XML converted", destination.toString());
	}
}
