package com.googlecode.jmapper.integrationtest.operations;

import junit.framework.Test;
import junit.framework.TestSuite;

public class OperationTests {
	
	public static Test suite() {
		
		TestSuite suite = new TestSuite(OperationTests.class.getName());
		//$JUnit-BEGIN$
		
		/*	Tests on primitive and wrapper classes */
			suite.addTestSuite(PrimitiveDSTest.class);
			suite.addTestSuite(PrimitiveSTest.class);
			suite.addTestSuite(Primitive2STest.class);
			suite.addTestSuite(Primitive2DSTest.class);
			suite.addTestSuite(PrimitiveConversionSTest.class);
			suite.addTestSuite(PrimitiveConversionDSTest.class);
			
		/*	Tests on Arrays		       	   		   */
			suite.addTestSuite(ArrayDSTest.class);
			suite.addTestSuite(ArraySTest.class);
			suite.addTestSuite(ArrayConversionDSTest.class);
			suite.addTestSuite(ArrayConversionSTest.class);
			suite.addTestSuite(MappedArrayDSTest.class);
			suite.addTestSuite(MappedArraySTest.class);
		
		/*	Tests on collection classes		 	   */
			suite.addTestSuite(CollectionDSTest.class);
			suite.addTestSuite(CollectionSTest.class);
			suite.addTestSuite(CollectionConversionSTest.class);
			suite.addTestSuite(CollectionConversionDSTest.class);
			suite.addTestSuite(MappedCollectionSTest.class);
			suite.addTestSuite(MappedCollectionDSTest.class);
		
		/*	Tests on map classes				   */
			suite.addTestSuite(MapDSTest.class);
			suite.addTestSuite(MapSTest.class);
			suite.addTestSuite(MapConversionDSTest.class);
			suite.addTestSuite(MapConversionSTest.class);
			suite.addTestSuite(MapConversion2DSTest.class);
			suite.addTestSuite(MapConversion2STest.class);
			suite.addTestSuite(MappedMapDSTest.class);
			suite.addTestSuite(MappedMapSTest.class);
			
		/*	Tests on array -> list classes		   */
			suite.addTestSuite(ArrayListDSTest.class);
			suite.addTestSuite(ArrayListSTest.class);
			suite.addTestSuite(ArrayListConversionDSTest.class);
			suite.addTestSuite(ArrayListConversionSTest.class);
			suite.addTestSuite(MappedArrayListDSTest.class);
			suite.addTestSuite(MappedArrayListSTest.class);
			
		/*	Tests on list -> array classes		   */
			suite.addTestSuite(ListArrayDSTest.class);
			suite.addTestSuite(ListArraySTest.class);
			suite.addTestSuite(ListArrayConversionDSTest.class);
			suite.addTestSuite(ListArrayConversionSTest.class);
			suite.addTestSuite(MappedListArrayDSTest.class);
			suite.addTestSuite(MappedListArraySTest.class);
			
		/*  Tests on objects		 	       */
			suite.addTestSuite(ObjectDSTest.class);
			suite.addTestSuite(ObjectSTest.class);
			suite.addTestSuite(Object2DSTest.class);
			suite.addTestSuite(Object2STest.class);
		
		/*	Tests on Inner Classes     		       */
			suite.addTestSuite(InnerSTest.class);
			suite.addTestSuite(InnerDSTest.class);
		
		/*	Tests on Raw Types         		       */
			suite.addTestSuite(WithoutGenericsSTest.class);
			suite.addTestSuite(WithoutGenericsDSTest.class);
			
			suite.addTestSuite(OtherTypesTest.class);
		//$JUnit-END$
		return suite;
	}

}
