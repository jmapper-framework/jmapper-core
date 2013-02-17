package com.googlecode.jmapper.integrationtest.configurations;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ConfigurationTests {

	public static Test suite() {
		
		TestSuite suite = new TestSuite(ConfigurationTests.class.getName());
	
		suite.addTestSuite(JGlobalMapTest.class);
		suite.addTestSuite(GlobalNodeTest.class);
		
		return suite;
	}
}
