package com.googlecode.jmapper.integrationtest.conversions;

import com.googlecode.jmapper.integrationtest.conversions.bean.DExplicitConversion4;
import com.googlecode.jmapper.integrationtest.conversions.bean.SExplicitConversion4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import junit.framework.TestCase;
import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;

public class ExplicitConversionTest4 extends TestCase{
	
JMapper<DExplicitConversion4, SExplicitConversion4> mapper;
	
	@Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public void testExplicitConversion(){
		mapper  = new JMapper<DExplicitConversion4, SExplicitConversion4>(DExplicitConversion4.class, SExplicitConversion4.class);
	Set<String> slist = new HashSet<String>();
	slist.add("SOURCE");
	List<String> dlist = new ArrayList<String>();
	dlist.add("DESTINATION");
	DExplicitConversion4 destination = mapper.getDestination(new DExplicitConversion4(dlist), new SExplicitConversion4(slist));
	assertEquals("DExplicitConversion4 [destList=[DESTINATION, SOURCE, CONVERTED]]", destination.toString());
	}
	
	public void testExplicitXmlConversion(){
		mapper  = new JMapper<DExplicitConversion4, SExplicitConversion4>(DExplicitConversion4.class, SExplicitConversion4.class,"conversions/conversionTest3.xml");
	Set<String> slist = new HashSet<String>();
	slist.add("SOURCE");
	List<String> dlist = new ArrayList<String>();
	dlist.add("DESTINATION");
	DExplicitConversion4 destination = mapper.getDestination(new DExplicitConversion4(dlist), new SExplicitConversion4(slist));
	assertEquals("DExplicitConversion4 [destList=[DESTINATION, SOURCE, CONVERTED IN XML]]", destination.toString());
	}
}
