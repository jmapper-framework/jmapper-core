package com.googlecode.jmapper;

import com.googlecode.jmapper.conversions.explicit.ExplicitComplexConversion2Test;
import com.googlecode.jmapper.conversions.explicit.ExplicitComplexConversionTest;
import com.googlecode.jmapper.conversions.explicit.ExplicitSimpleConversion2Test;
import com.googlecode.jmapper.conversions.explicit.ExplicitSimpleConversionTest;
import com.googlecode.jmapper.conversions.implicit.ConversionsToBooleanTest;
import com.googlecode.jmapper.conversions.implicit.ConversionsToByteTest;
import com.googlecode.jmapper.conversions.implicit.ConversionsToCharacterTest;
import com.googlecode.jmapper.conversions.implicit.ConversionsToDoubleTest;
import com.googlecode.jmapper.conversions.implicit.ConversionsToFloatTest;
import com.googlecode.jmapper.conversions.implicit.ConversionsToIntegerTest;
import com.googlecode.jmapper.conversions.implicit.ConversionsToLongTest;
import com.googlecode.jmapper.conversions.implicit.ConversionsToShortTest;
import com.googlecode.jmapper.conversions.implicit.ConversionsToStringTest;
import com.googlecode.jmapper.operations.OperationAnalyzerTest;
import com.googlecode.jmapper.operations.complex.ArrayConversionTest;
import com.googlecode.jmapper.operations.complex.ArrayListConversionTest;
import com.googlecode.jmapper.operations.complex.ArrayListOperationTest;
import com.googlecode.jmapper.operations.complex.ArrayOperationTest;
import com.googlecode.jmapper.operations.complex.CollectionConversion2Test;
import com.googlecode.jmapper.operations.complex.CollectionConversionTest;
import com.googlecode.jmapper.operations.complex.CollectionOperationTest;
import com.googlecode.jmapper.operations.complex.ListArrayConversionTest;
import com.googlecode.jmapper.operations.complex.ListArrayOperationTest;
import com.googlecode.jmapper.operations.complex.MapConversion2Test;
import com.googlecode.jmapper.operations.complex.MapConversionTest;
import com.googlecode.jmapper.operations.complex.MapOperationTest;
import com.googlecode.jmapper.operations.recursive.MappedArrayOperationTest;
import com.googlecode.jmapper.operations.recursive.MappedCollectionOperationTest;
import com.googlecode.jmapper.operations.recursive.MappedListArrayOperationTest;
import com.googlecode.jmapper.operations.recursive.MappedMapOperation2Test;
import com.googlecode.jmapper.operations.recursive.MappedMapOperationTest;
import com.googlecode.jmapper.operations.recursive.ObjectOperationTest;
import com.googlecode.jmapper.operations.simple.BasicConversion2Test;
import com.googlecode.jmapper.operations.simple.BasicConversion3Test;
import com.googlecode.jmapper.operations.simple.BasicConversion4Test;
import com.googlecode.jmapper.operations.simple.BasicConversionTest;
import com.googlecode.jmapper.operations.simple.BasicOperationTest;
import com.googlecode.jmapper.operations.simple.BoxingOperationTest;
import com.googlecode.jmapper.operations.simple.UnboxingOperationTest;
import com.googlecode.jmapper.xml.XmlConverterTest;
import com.googlecode.jmapper.xml.util.XmlUtilityTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class JUnitTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(JUnitTests.class.getName());
		
		/*	Tests on explicit conversion          */
		
			// test on explicit conversion between complex fields (one parameter)
			suite.addTestSuite(ExplicitComplexConversionTest.class);
			// test on explicit conversion between complex fields (two parameters)
			suite.addTestSuite(ExplicitComplexConversion2Test.class);
			// test on explicit conversion between simple fields
			suite.addTestSuite(ExplicitSimpleConversionTest.class);
			// test on explicit conversion between primitive fields
			suite.addTestSuite(ExplicitSimpleConversion2Test.class);
			
		/*	Tests on implicit conversion          */
			
			// test from primitive/wrapper types to String
			suite.addTestSuite(ConversionsToStringTest.class);
			// test from primitive/wrapper types to primitive/wrapper Byte
			suite.addTestSuite(ConversionsToByteTest.class);	
			// test from primitive/wrapper types to primitive/wrapper Short
			suite.addTestSuite(ConversionsToShortTest.class);	
			// test from primitive/wrapper types to primitive/wrapper Integer
			suite.addTestSuite(ConversionsToIntegerTest.class);	
			// test from primitive/wrapper types to primitive/wrapper Long
			suite.addTestSuite(ConversionsToLongTest.class);
			// test from primitive/wrapper types to primitive/wrapper Float
			suite.addTestSuite(ConversionsToFloatTest.class);
			// test from primitive/wrapper types to primitive/wrapper Double
			suite.addTestSuite(ConversionsToDoubleTest.class);
			// test from primitive/wrapper types to primitive/wrapper Character
			suite.addTestSuite(ConversionsToCharacterTest.class);
			// test from primitive/wrapper types to primitive/wrapper Character
			suite.addTestSuite(ConversionsToBooleanTest.class);
			
		/*	Tests on primitive and wrapper classes */
			
			// test between two Strings
			suite.addTestSuite(BasicOperationTest.class);
			// boxing operation test between: destination Integer and source int
			suite.addTestSuite(BoxingOperationTest.class);
			// unboxing operation test between: destination Int and source Integer
			suite.addTestSuite(UnboxingOperationTest.class);
			// conversion test between: destination Integer and source String
			suite.addTestSuite(BasicConversionTest.class);
			// conversion test between: destination int and source String
			suite.addTestSuite(BasicConversion2Test.class);
			// conversion test between: destination String and source Integer
			suite.addTestSuite(BasicConversion3Test.class);
			// conversion test between: destination String and source int
			suite.addTestSuite(BasicConversion4Test.class);
			
		/*	Tests on Arrays        	       	   	   */
			
			// test between two String[]
			suite.addTestSuite(ArrayOperationTest.class);
			// conversion test between: destination Integer[] and source String[]
			suite.addTestSuite(ArrayConversionTest.class);
			// test between mapped Arrays: destination TargetObject[] and source MappedObject[]
			suite.addTestSuite(MappedArrayOperationTest.class);
			
		/*	Tests on Collections                   */
			
			// test between two ArrayList<String>
			suite.addTestSuite(CollectionOperationTest.class);
			// conversion test between: destination List<String> and source Set<String>  (Structure conversion)
			suite.addTestSuite(CollectionConversionTest.class);
			// conversion test between: destination List<String> and source Set<Integer> (Item conversion)
			suite.addTestSuite(CollectionConversion2Test.class);
			// test between mapped Collections: destination List<TargetObject> and source Set<MappedObject>
			suite.addTestSuite(MappedCollectionOperationTest.class);			
		
		/*	Tests on Array <-> Collections         */	
		
			// test with an array as destination and a list as source
			suite.addTestSuite(ArrayListOperationTest.class);
			// conversion test between: destination String[] and source List<Integer> 
			suite.addTestSuite(ArrayListConversionTest.class);
			// test with a list as destination and an array as source
			suite.addTestSuite(ListArrayOperationTest.class);
			// conversion test between: destination List<Integer> and source String[]
			suite.addTestSuite(ListArrayConversionTest.class);
			// test between a mapped destination List and a mapped source Array
			suite.addTestSuite(MappedListArrayOperationTest.class);
			// test between a mapped destination Array and a mapped source List
			suite.addTestSuite(MappedListArrayOperationTest.class);
						
			
		/*	Tests on Maps                          */
			
			// test between two HashMap<String,String>
			suite.addTestSuite(MapOperationTest.class);
			// conversion test between: destination SortedMap<String, String> and source Map<String,String> (Structure conversion)
			suite.addTestSuite(MapConversionTest.class);
			// conversion test between: destination SortedMap<String, Integer> and source Map<Integer, String> (Items conversion)
			suite.addTestSuite(MapConversion2Test.class);
			// test between mapped Maps: destination Map<MappedObject, TargetObject> and source SortedMap<TargetObject, MappedObject>
			suite.addTestSuite(MappedMapOperationTest.class);
			// test between mapped Maps: destination Map<MappedObject, String> and source SortedMap<TargetObject, String>
			suite.addTestSuite(MappedMapOperation2Test.class);
			
		/*	Tests on Mapped Objects                */
			
			// test between: destination TargetObject and source MappedObject
			suite.addTestSuite(ObjectOperationTest.class);
			
			
		/*	Tests on XML methods    	       */
			
			// verifies JMap presence
			suite.addTestSuite(XmlUtilityTest.class);
			// verifies Convertion between Attribute <-> XmlAttribute and Class <-> XmlClass
			suite.addTestSuite(XmlConverterTest.class);
			
		/*   Tests on general functions            */
			
			// test on operationAnalyzer class
			suite.addTestSuite(OperationAnalyzerTest.class);
			
		return suite;
	}

}
