package com.googlecode.jmapper.integrationtest.performance;

import com.googlecode.jmapper.integrationtest.IntegrationTests;
import junit.framework.Test;
import junit.framework.TestSuite;

public class PerformanceTests {
	
	public static Test suite() {
		
		TestSuite suite = new TestSuite(IntegrationTests.class.getName());
		//$JUnit-BEGIN$
		
		/*	Tests on primitive and wrapper classes */
		suite.addTestSuite(PrimitivePerformanceTest.class);
			
		/*	Tests on Arrays		       	   		   */
		suite.addTestSuite(ArrayPerformanceTest.class);
		suite.addTestSuite(ArrayConversionPerformanceTest.class);
		
		/*	Tests on collection classes		 	   */
		suite.addTestSuite(CollectionPerformanceTest.class);
		suite.addTestSuite(CollectionConversionPerformanceTest.class);
		
		/*	Tests on collection classes		 	   */
		suite.addTestSuite(MapPerformanceTest.class);
		suite.addTestSuite(MapConversionPerformanceTest.class);
		
		return suite;
	}
	
}
