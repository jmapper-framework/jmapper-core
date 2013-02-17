package com.googlecode.jmapper.integrationtest.conversions;

import com.googlecode.jmapper.integrationtest.conversions.bean.DExplicitDynamicConversion;
import com.googlecode.jmapper.integrationtest.conversions.bean.SExplicitDynamicConversion;
import junit.framework.TestCase;

import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.enums.ChooseConfig;

public class ExplicitDynamicConversionTest extends TestCase{

	JMapper<DExplicitDynamicConversion, SExplicitDynamicConversion> mapper;

    @Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
	}
	
    public void testConversion(){
    	mapper  = new JMapper<DExplicitDynamicConversion, SExplicitDynamicConversion>(DExplicitDynamicConversion.class, SExplicitDynamicConversion.class,ChooseConfig.SOURCE);
		DExplicitDynamicConversion destination = mapper.getDestination(new SExplicitDynamicConversion("INPUT1","INPUT2","INPUT3","INPUT4"));
		assertEquals("DExplicitDynamicConversion: "+
		             "destination(empty INPUT1 converted) destination2(empty INPUT2 converted) "+
				     "destination3(destination3 source3) destination4(destination4 source4)",destination.toString());
		destination = mapper.getDestination(new DExplicitDynamicConversion("DFIELD1","DFIELD2","DFIELD3","DFIELD4"), new SExplicitDynamicConversion("SFIELD1","SFIELD2","SFIELD3","SFIELD4"));
		assertEquals("DExplicitDynamicConversion: "+
		             "destination(DFIELD1 SFIELD1 converted) destination2(DFIELD2 SFIELD2 converted) "+
				     "destination3(destination3 source3) destination4(destination4 source4)", destination.toString());
	}
	
    public void testXmlConversion(){
    	mapper  = new JMapper<DExplicitDynamicConversion, SExplicitDynamicConversion>(DExplicitDynamicConversion.class, SExplicitDynamicConversion.class,ChooseConfig.SOURCE,"conversions/dynamicConversionTest.xml");
		DExplicitDynamicConversion destination = mapper.getDestination(new SExplicitDynamicConversion("INPUT1","INPUT2","INPUT3","INPUT4"));
		assertEquals("DExplicitDynamicConversion: "+
		             "destination(null + INPUT1) destination2(null + INPUT2) "+
				     "destination3(destination3 + source3) destination4(destination4 source4)",destination.toString());
		destination = mapper.getDestination(new DExplicitDynamicConversion("DFIELD1","DFIELD2","DFIELD3","DFIELD4"), new SExplicitDynamicConversion("SFIELD1","SFIELD2","SFIELD3","SFIELD4"));
		assertEquals("DExplicitDynamicConversion: "+
		             "destination(DFIELD1 + SFIELD1) destination2(DFIELD2 + SFIELD2) "+
				     "destination3(destination3 + source3) destination4(destination4 source4)", destination.toString());
	}
}
