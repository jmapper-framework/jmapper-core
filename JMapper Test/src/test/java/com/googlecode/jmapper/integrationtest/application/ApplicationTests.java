package com.googlecode.jmapper.integrationtest.application;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ApplicationTests {
	
	public static Test suite() {
		
		TestSuite suite = new TestSuite(ApplicationTests.class.getName());
		//$JUnit-BEGIN$
		
		/*   Tests on general functions            */
		
			// test on jmapper class
			suite.addTestSuite(JMapperTest.class);
			// robustness test: exposure of mistakes
			suite.addTestSuite(JMapperExceptionTest.class);
			// robustness test: exposure of mistakes
			suite.addTestSuite(RelationalJMapperExceptionTest.class);
			// test on oneToMany and manyToOne methods
			suite.addTestSuite(RelationalJMapperTest.class);
			// robustness test: exposure of mistakes
			suite.addTestSuite(ConfigReaderExceptionTest.class);
			// test on retrieveTargetFieldName method
			suite.addTestSuite(ConfigReaderTest.class);
			
		//$JUnit-END$
		return suite;
	}

}
