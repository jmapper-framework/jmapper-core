package com.googlecode.jmapper.integrationtest.conversions;

import com.googlecode.jmapper.integrationtest.conversions.bean.ObjFirstD;
import com.googlecode.jmapper.integrationtest.conversions.bean.ObjFirstS;
import com.googlecode.jmapper.integrationtest.conversions.bean.ObjSecondD;
import com.googlecode.jmapper.integrationtest.conversions.bean.ObjSecondS;
import com.googlecode.jmapper.integrationtest.conversions.bean.ObjThirdD;
import com.googlecode.jmapper.integrationtest.conversions.bean.ObjThirdS;
import junit.framework.TestCase;

import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;

public class ExplicitRecursiveConversionTest2 extends TestCase{

JMapper<ObjFirstD, ObjFirstS> mapper;
	
	@Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		
		
	}
	
	public void testExmplicitConversion(){
		mapper  = new JMapper<ObjFirstD, ObjFirstS>(ObjFirstD.class, ObjFirstS.class);
		ObjFirstD destination = mapper.getDestination(new ObjFirstD(new ObjSecondD(new ObjThirdD("DESTINATION"))),new ObjFirstS(new ObjSecondS(new ObjThirdS("SOURCE"))));
		assertEquals("ObjFirstD [fieldFirstD=ObjSecondD [fieldSecondD=ObjThirdD [fieldThirdD=DESTINATION ANNOTATION SOURCE]]]", destination.toString());
	}
	public void testExplicitConversion2(){
		mapper  = new JMapper<ObjFirstD, ObjFirstS>(ObjFirstD.class, ObjFirstS.class,"conversions/recursiveTest2.xml");
		ObjFirstD destination = mapper.getDestination(new ObjFirstD(new ObjSecondD(new ObjThirdD("DESTINATION"))),new ObjFirstS(new ObjSecondS(new ObjThirdS("SOURCE"))));
		assertEquals("ObjFirstD [fieldFirstD=ObjSecondD [fieldSecondD=ObjThirdD [fieldThirdD=DESTINATION XML SOURCE]]]", destination.toString());
	}
}
