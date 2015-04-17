package com.googlecode.jmapper.integrationtest.xml;

import junit.framework.Test;
import junit.framework.TestSuite;

public class XmlTests {

	public static Test suite() {
			
			TestSuite suite = new TestSuite(XmlTests.class.getName());
			//$JUnit-BEGIN$
			
			/*	Tests on utility methods    	       */
				// test on XmlHandler
				suite.addTestSuite(XmlHandlerTest.class);	
				suite.addTestSuite(XmlHandler2Test.class);
				suite.addTestSuite(XmlHandler3Test.class);
				suite.addTestSuite(XmlHandler4Test.class);
			//$JUnit-END$
			return suite;
	}
	
}
