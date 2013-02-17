package com.googlecode.jmapper.integrationtest;


import com.googlecode.jmapper.integrationtest.IntegrationTests;
import com.googlecode.jmapper.integrationtest.application.ApplicationTests;
import com.googlecode.jmapper.integrationtest.configurations.ConfigurationTests;
import com.googlecode.jmapper.integrationtest.conversions.ConversionTests;
import com.googlecode.jmapper.integrationtest.operations.OperationTests;
import com.googlecode.jmapper.integrationtest.xml.XmlTests;
import junit.framework.Test;
import junit.framework.TestSuite;

public class IntegrationTests {
	
	public static Test suite() {
		
		TestSuite suite = new TestSuite(IntegrationTests.class.getName());
		
		suite.addTest(ApplicationTests.suite());
		suite.addTest(OperationTests.suite());
		suite.addTest(ConversionTests.suite());
		suite.addTest(XmlTests.suite());
		suite.addTest(ConfigurationTests.suite());
		
		// performance tests
//		suite.addTest(PerformanceTests.suite());
								
		//$JUnit-END$
		return suite;
	}
}
