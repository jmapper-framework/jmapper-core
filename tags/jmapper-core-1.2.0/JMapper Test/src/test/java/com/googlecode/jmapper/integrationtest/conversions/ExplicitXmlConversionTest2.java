package com.googlecode.jmapper.integrationtest.conversions;

import com.googlecode.jmapper.integrationtest.conversions.bean.DExplicitXmlConversion2;
import com.googlecode.jmapper.integrationtest.conversions.bean.SExplicitXmlConversion2;
import junit.framework.TestCase;
import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.enums.ChooseConfig;

public class ExplicitXmlConversionTest2 extends TestCase {
JMapper<DExplicitXmlConversion2, SExplicitXmlConversion2> mapper;

    @Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		mapper  = new JMapper<DExplicitXmlConversion2, SExplicitXmlConversion2>(DExplicitXmlConversion2.class, SExplicitXmlConversion2.class,ChooseConfig.DESTINATION,"conversions/conversionTest2.xml");
	}
	
    /* verificata precedenza della conversion in xml rispetto alla stessa in annotation
     * verificata la possibilità di scrivere la configurazione da una parte e le conversioni dall'altra
     * verificata la ricerca delle conversioni partendo dalla configurazione dichiarata */
	public void testXmlConversion(){
		DExplicitXmlConversion2 destination = mapper.getDestination(new SExplicitXmlConversion2(10));
		assertEquals("DExplicitXmlConversion2 [dField=12]",destination.toString());
		destination = mapper.getDestination(new DExplicitXmlConversion2(5), new SExplicitXmlConversion2(10));
		assertEquals("DExplicitXmlConversion2 [dField=15]", destination.toString());
	}
	
	/* verificata annotated configuration da una parte e annotated conversion dall'altra */
	public void testConversion(){
		mapper  = new JMapper<DExplicitXmlConversion2, SExplicitXmlConversion2>(DExplicitXmlConversion2.class, SExplicitXmlConversion2.class,ChooseConfig.DESTINATION);
		DExplicitXmlConversion2 destination = mapper.getDestination(new SExplicitXmlConversion2(10));
		assertEquals("DExplicitXmlConversion2 [dField=2010]",destination.toString());
		destination = mapper.getDestination(new DExplicitXmlConversion2(500), new SExplicitXmlConversion2(10));
		assertEquals("DExplicitXmlConversion2 [dField=610]", destination.toString());
	}
}
