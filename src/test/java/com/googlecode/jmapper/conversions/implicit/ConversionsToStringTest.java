package com.googlecode.jmapper.conversions.implicit;

import com.googlecode.jmapper.conversions.implicit.ConversionHandler;
import com.googlecode.jmapper.enums.ConversionType;

import junit.framework.TestCase;

public class ConversionsToStringTest extends TestCase {

	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO STRING
	// -----------------------------------------------------------------------------
	
	public void testFrombyteToString(){
		
		{	ConversionType expected = ConversionAnalyzer.getConversionType(String.class, byte.class);
			ConversionType actual = ConversionType.FrombyteToString;
			assertEquals(expected, actual);		}
		
		byte b = 127;
		
		String actual = Byte.toString(b);
		String expected = "127";
		assertEquals(expected, actual);
		
		actual = ConversionHandler.getConversion(ConversionType.FrombyteToString, "b");
		expected = "Byte.toString(b)";
		assertEquals(expected, actual);
	}
	
	public void testFromshortToString(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(String.class, short.class);
			ConversionType actual = ConversionType.FromshortToString;
			assertEquals(expected, actual);		}
		
		short s = 127;
		
		String actual = Short.toString(s);
		String expected = "127";
		assertEquals(expected, actual);
		
		actual = ConversionHandler.getConversion(ConversionType.FromshortToString, "s");
		expected = "Short.toString(s)";
		assertEquals(expected, actual);
	}
	
	public void testFromintToString(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(String.class, int.class);
			ConversionType actual = ConversionType.FromintToString;
			assertEquals(expected, actual);		}
		
		int i = -127;
		
		String actual = Integer.toString(i);
		String expected = "-127";
		assertEquals(expected, actual);
		
		actual = ConversionHandler.getConversion(ConversionType.FromintToString, "i");
		expected = "Integer.toString(i)";
		assertEquals(expected, actual);
	}
	
	public void testFromlongToString(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(String.class, long.class);
			ConversionType actual = ConversionType.FromlongToString;
			assertEquals(expected, actual);		}
		
		long l = 127;
		
		String actual = Long.toString(l);
		String expected = "127";
		assertEquals(expected, actual);
		
		actual = ConversionHandler.getConversion(ConversionType.FromlongToString, "l");
		expected = "Long.toString(l)";
		assertEquals(expected, actual);
	}
	
	public void testFromfloatToString(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(String.class, float.class);
			ConversionType actual = ConversionType.FromfloatToString;
			assertEquals(expected, actual);		}
		
		float f = (float) 127.2;
		
		String actual = Float.toString(f);
		String expected = "127.2";
		assertEquals(expected, actual);
		
		actual = ConversionHandler.getConversion(ConversionType.FromfloatToString, "f");
		expected = "Float.toString(f)";
		assertEquals(expected, actual);
	}
	
	public void testFromdoubleToString(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(String.class, double.class);
			ConversionType actual = ConversionType.FromdoubleToString;
			assertEquals(expected, actual);		}
		
		double d = 127.2;
		
		String actual = Double.toString(d);
		String expected = "127.2";
		assertEquals(expected, actual);
		
		actual = ConversionHandler.getConversion(ConversionType.FromdoubleToString, "d");
		expected = "Double.toString(d)";
		assertEquals(expected, actual);
	}
	
	public void testFromcharToString(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(String.class, char.class);
			ConversionType actual = ConversionType.FromcharToString;
			assertEquals(expected, actual);		}
		
		char c = 'c';
		
		String actual = Character.toString(c);
		String expected = "c";
		assertEquals(expected, actual);
		
		actual = ConversionHandler.getConversion(ConversionType.FromcharToString, "c");
		expected = "Character.toString(c)";
		assertEquals(expected, actual);
	}
	
	public void testFrombooleanToString(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(String.class, boolean.class);
			ConversionType actual = ConversionType.FrombooleanToString;
			assertEquals(expected, actual);		}
		
		boolean b = true;
		
		String actual = Boolean.toString(b);
		String expected = "true";
		assertEquals(expected, actual);
		
		actual = ConversionHandler.getConversion(ConversionType.FrombooleanToString, "b");
		expected = "Boolean.toString(b)";
		assertEquals(expected, actual);
	}	
	
	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO STRING
	// -----------------------------------------------------------------------------
	
	public void testFromByteToString(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(String.class, Byte.class);
			ConversionType actual = ConversionType.FromByteToString;
			assertEquals(expected, actual);		}
		
		Byte b = 127;
		
		String actual = b.toString();
		String expected = "127";
		assertEquals(expected, actual);
		
		actual = ConversionHandler.getConversion(ConversionType.FromByteToString, "b");
		expected = "b.toString()";
		assertEquals(expected, actual);
	}
	
	public void testFromShortToString(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(String.class, Short.class);
			ConversionType actual = ConversionType.FromShortToString;
			assertEquals(expected, actual);		}
		
		Short s = 127;
		
		String actual = s.toString();
		String expected = "127";
		assertEquals(expected, actual);
		
		actual = ConversionHandler.getConversion(ConversionType.FromShortToString, "s");
		expected = "s.toString()";
		assertEquals(expected, actual);
	}
	
	public void testFromIntegerToString(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(String.class, Integer.class);
			ConversionType actual = ConversionType.FromIntegerToString;
			assertEquals(expected, actual);		}
		
		Integer i = -127;
		
		String actual = i.toString();
		String expected = "-127";
		assertEquals(expected, actual);
		
		actual = ConversionHandler.getConversion(ConversionType.FromIntegerToString, "i");
		expected = "i.toString()";
		assertEquals(expected, actual);
	}
	
	public void testFromLongToString(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(String.class, Long.class);
			ConversionType actual = ConversionType.FromLongToString;
			assertEquals(expected, actual);		}
		
		Long l = 127L;
		
		String actual = l.toString();
		String expected = "127";
		assertEquals(expected, actual);
		
		actual = ConversionHandler.getConversion(ConversionType.FromLongToString, "l");
		expected = "l.toString()";
		assertEquals(expected, actual);
	}
	
	public void testFromFloatToString(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(String.class, Float.class);
			ConversionType actual = ConversionType.FromFloatToString;
			assertEquals(expected, actual);		}
		
		Float f = (float) 127.2;
		
		String actual = f.toString();
		String expected = "127.2";
		assertEquals(expected, actual);
		
		actual = ConversionHandler.getConversion(ConversionType.FromFloatToString, "f");
		expected = "f.toString()";
		assertEquals(expected, actual);
	}
	
	public void testFromDoubleToString(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(String.class, Double.class);
			ConversionType actual = ConversionType.FromDoubleToString;
			assertEquals(expected, actual);		}
		
		Double d = 127.2;
		
		String actual = d.toString();
		String expected = "127.2";
		assertEquals(expected, actual);
		
		actual = ConversionHandler.getConversion(ConversionType.FromDoubleToString, "d");
		expected = "d.toString()";
		assertEquals(expected, actual);
	}
	
	public void testFromCharacterToString(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(String.class, Character.class);
			ConversionType actual = ConversionType.FromCharacterToString;
			assertEquals(expected, actual);		}
		
		Character c = 'c';
		
		String actual = c.toString();
		String expected = "c";
		assertEquals(expected, actual);
		
		actual = ConversionHandler.getConversion(ConversionType.FromCharacterToString, "c");
		expected = "c.toString()";
		assertEquals(expected, actual);
	}
	
	public void testFromBooleanToString(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(String.class, Boolean.class);
			ConversionType actual = ConversionType.FromBooleanToString;
			assertEquals(expected, actual);		}
		
		Boolean b = true;
		
		String actual = b.toString();
		String expected = "true";
		assertEquals(expected, actual);
		
		actual = ConversionHandler.getConversion(ConversionType.FromBooleanToString, "b");
		expected = "b.toString()";
		assertEquals(expected, actual);
	}	
}
