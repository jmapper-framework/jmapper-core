package com.googlecode.jmapper.integrationtest.others;

import junit.framework.Test;
import junit.framework.TestSuite;

public class OthersTests {

	public static Test suite() {

		TestSuite suite = new TestSuite(OthersTests.class.getName());
		// $JUnit-BEGIN$

		/* Tests on primitive and wrapper classes */
		suite.addTestSuite(BooleanGetTest.class);
		/* Tests on avoid set method */
		suite.addTestSuite(AvoidSetTest.class);

		// $JUnit-END$
		return suite;
	}
}
