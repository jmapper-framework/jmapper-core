package it.avutils.jmapper;

import it.avutils.jmapper.conversions.explicit.ExplicitComplexConversion2Test;
import it.avutils.jmapper.conversions.explicit.ExplicitComplexConversionTest;
import it.avutils.jmapper.conversions.explicit.ExplicitSimpleConversion2Test;
import it.avutils.jmapper.conversions.explicit.ExplicitSimpleConversionTest;
import it.avutils.jmapper.conversions.implicit.ConversionsToBooleanTest;
import it.avutils.jmapper.conversions.implicit.ConversionsToByteTest;
import it.avutils.jmapper.conversions.implicit.ConversionsToCharacterTest;
import it.avutils.jmapper.conversions.implicit.ConversionsToDoubleTest;
import it.avutils.jmapper.conversions.implicit.ConversionsToFloatTest;
import it.avutils.jmapper.conversions.implicit.ConversionsToIntegerTest;
import it.avutils.jmapper.conversions.implicit.ConversionsToLongTest;
import it.avutils.jmapper.conversions.implicit.ConversionsToShortTest;
import it.avutils.jmapper.conversions.implicit.ConversionsToStringTest;
import it.avutils.jmapper.operations.OperationAnalyzerTest;
import it.avutils.jmapper.operations.complex.ArrayConversionTest;
import it.avutils.jmapper.operations.complex.ArrayOperationTest;
import it.avutils.jmapper.operations.complex.CollectionConversion2Test;
import it.avutils.jmapper.operations.complex.CollectionConversionTest;
import it.avutils.jmapper.operations.complex.CollectionOperationTest;
import it.avutils.jmapper.operations.complex.MapConversion2Test;
import it.avutils.jmapper.operations.complex.MapConversionTest;
import it.avutils.jmapper.operations.complex.MapOperationTest;
import it.avutils.jmapper.operations.recursive.MappedArrayOperationTest;
import it.avutils.jmapper.operations.recursive.MappedCollectionOperationTest;
import it.avutils.jmapper.operations.recursive.MappedMapOperation2Test;
import it.avutils.jmapper.operations.recursive.MappedMapOperationTest;
import it.avutils.jmapper.operations.recursive.ObjectOperationTest;
import it.avutils.jmapper.operations.simple.BasicConversion2Test;
import it.avutils.jmapper.operations.simple.BasicConversion3Test;
import it.avutils.jmapper.operations.simple.BasicConversion4Test;
import it.avutils.jmapper.operations.simple.BasicConversionTest;
import it.avutils.jmapper.operations.simple.BasicOperationTest;
import it.avutils.jmapper.operations.simple.BoxingOperationTest;
import it.avutils.jmapper.operations.simple.UnboxingOperationTest;
import it.avutils.jmapper.xml.XmlConverterTest;
import it.avutils.jmapper.xml.util.XmlUtilityTest;
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
