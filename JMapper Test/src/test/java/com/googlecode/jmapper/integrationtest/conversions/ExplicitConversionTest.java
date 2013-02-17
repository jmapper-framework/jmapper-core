package com.googlecode.jmapper.integrationtest.conversions;

import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;

import com.googlecode.jmapper.integrationtest.conversions.bean.DExplicitConversion;
import com.googlecode.jmapper.integrationtest.conversions.bean.SExplicitConversion;
import junit.framework.TestCase;

public class ExplicitConversionTest extends TestCase{

	JMapper<DExplicitConversion, SExplicitConversion> mapper;
	
	@Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		
		mapper  = new JMapper<DExplicitConversion, SExplicitConversion>(DExplicitConversion.class, SExplicitConversion.class);
	}
	
	public void testExplicitConversion(){
		SExplicitConversion source = new SExplicitConversion(10);
		DExplicitConversion destination = mapper.getDestination(source);
		assertEquals("10 explicit converted", destination.toString());
	}
}
