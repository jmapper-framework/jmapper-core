package com.googlecode.jmapper.integrationtest.conversions;

import com.googlecode.jmapper.integrationtest.conversions.bean.DExplicitXmlConversion;
import com.googlecode.jmapper.integrationtest.conversions.bean.SExplicitXmlConversion;
import junit.framework.TestCase;
import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;

public class ExplicitXmlConversionTest extends TestCase{
JMapper<DExplicitXmlConversion, SExplicitXmlConversion> mapper;
	
	@Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		mapper  = new JMapper<DExplicitXmlConversion, SExplicitXmlConversion>(DExplicitXmlConversion.class, SExplicitXmlConversion.class,"conversions/conversionTest.xml");
	}
	
	public void testConversion(){
		DExplicitXmlConversion destination = mapper.getDestination(new SExplicitXmlConversion(10, 20, "30"));
		assertEquals("DExplicitXmlConversion: dField(10 sField converted) dField2(dField2  sField2) dField3(dField2  sField2)", destination.toString());
	}
	
}
