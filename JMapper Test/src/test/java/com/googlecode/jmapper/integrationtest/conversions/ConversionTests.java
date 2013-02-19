package com.googlecode.jmapper.integrationtest.conversions;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ConversionTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(ConversionTests.class.getName());
		//$JUnit-BEGIN$
		
		/*	STATIC CASES                           */
			
		    // configuration and static annotated conversion on the same class, with one parameter
		    suite.addTestSuite(ExplicitConversionTest.class);
		    // configuration on the destination, conversion on the source, with one parameter
		    // in this test there are two conversions but only one is used
		    suite.addTestSuite(ExplicitConversionTest2.class);
		    // configuration on the destination, conversion on the source, with two parameters
		    suite.addTestSuite(ExplicitConversionTest3.class);
		    // conversion in xml and annotation between collections
		    suite.addTestSuite(ExplicitConversionTest4.class);
		    // complex variables with internal mapping and conversion, in xml and annotation
		    suite.addTestSuite(ExplicitRecursiveConversionTest.class);
		    // conversion in xml and annotation between complex objects
		    suite.addTestSuite(ExplicitRecursiveConversionTest2.class);
		    // configuration and explicit conversions all in xml
		    suite.addTestSuite(ExplicitXmlConversionTest.class);
		    // configuration separated from conversion methods
		    suite.addTestSuite(ExplicitXmlConversionTest2.class);
		    // exception test
		    suite.addTestSuite(ExplicitConversionExceptionTest.class);
		    
		/*	DYNAMIC CASES                           */
			
		    // dynamic configuration
		    suite.addTestSuite(ExplicitDynamicConversionTest.class);
		    
		//$JUnit-END$
		return suite;
	}

}
