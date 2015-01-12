package com.googlecode.jmapper.conversions.implicit;

import com.googlecode.jmapper.conversions.implicit.ConversionHandler;
import com.googlecode.jmapper.enums.ConversionType;

import junit.framework.TestCase;

public class ConversionsToBooleanTest extends TestCase{

	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO WRAPPER BOOLEAN
	// -----------------------------------------------------------------------------
	
	public void testFrombyteToBoolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Boolean.class, byte.class);
			ConversionType actual = ConversionType.FrombyteToBoolean;
			assertEquals(expected, actual);		}
		
		byte b = 1;
	
		{	Boolean actual = new Boolean(b==0?false:true);
			Boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombyteToBoolean, "b");
			String expected = "new Boolean(b==0?false:true)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromshortToBoolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Boolean.class, short.class);
			ConversionType actual = ConversionType.FromshortToBoolean;
			assertEquals(expected, actual);		}
		
		short s = 1;
	
		{	Boolean actual = new Boolean(s==0?false:true);
			Boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromshortToBoolean, "s");
			String expected = "new Boolean(s==0?false:true)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromintToBoolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Boolean.class, int.class);
			ConversionType actual = ConversionType.FromintToBoolean;
			assertEquals(expected, actual);		}
		
		int i = 1;
	
		{	Boolean actual = new Boolean(i==0?false:true);
			Boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromintToBoolean, "i");
			String expected = "new Boolean(i==0?false:true)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromlongToBoolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Boolean.class, long.class);
			ConversionType actual = ConversionType.FromlongToBoolean;
			assertEquals(expected, actual);		}
		
		long l = 1L;
	
		{	Boolean actual = new Boolean(l==0?false:true);
			Boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromlongToBoolean, "l");
			String expected = "new Boolean(l==0?false:true)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromfloatToBoolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Boolean.class, float.class);
			ConversionType actual = ConversionType.FromfloatToBoolean;
			assertEquals(expected, actual);		}
		
		float f = 1F;
	
		{	Boolean actual = new Boolean(f==0?false:true);
			Boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromfloatToBoolean, "f");
			String expected = "new Boolean(f==0?false:true)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromdoubleToBoolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Boolean.class, double.class);
			ConversionType actual = ConversionType.FromdoubleToBoolean;
			assertEquals(expected, actual);		}
		
		double d = 1D;
	
		{	Boolean actual = new Boolean(d==0?false:true);
			Boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromdoubleToBoolean, "d");
			String expected = "new Boolean(d==0?false:true)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromcharToBoolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Boolean.class, char.class);
			ConversionType actual = ConversionType.FromcharToBoolean;
			assertEquals(expected, actual);		}
		
		char c = 'F';
	
		{	Boolean actual = new Boolean(c=='T'?true:c=='F'?false:null);
			Boolean expected = false;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromcharToBoolean, "c");
			String expected = "new Boolean(c=='T'?true:c=='F'?false:null)";
			assertEquals(expected, actual);		}
	}

	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO WRAPPER BOOLEAN
	// -----------------------------------------------------------------------------
	
	public void testFromStringToBoolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Boolean.class, String.class);
			ConversionType actual = ConversionType.FromStringToBoolean;
			assertEquals(expected, actual);		}
		
		String s = "true";
		
		{	Boolean actual = new Boolean(s);
			Boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromStringToBoolean, "s");
			String expected = "new Boolean(s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromByteToBoolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Boolean.class, Byte.class);
			ConversionType actual = ConversionType.FromByteToBoolean;
			assertEquals(expected, actual);		}
		
		Byte b = 1;
	
		{	Boolean actual = new Boolean(b.byteValue()==0?false:true);
			Boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromByteToBoolean, "b");
			String expected = "new Boolean(b.byteValue()==0?false:true)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromShortToBoolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Boolean.class, Short.class);
			ConversionType actual = ConversionType.FromShortToBoolean;
			assertEquals(expected, actual);		}
		
		Short s = 1;
	
		{	Boolean actual = new Boolean(s.shortValue()==0?false:true);
			Boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromShortToBoolean, "s");
			String expected = "new Boolean(s.shortValue()==0?false:true)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromIntegerToBoolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Boolean.class, Integer.class);
			ConversionType actual = ConversionType.FromIntegerToBoolean;
			assertEquals(expected, actual);		}
		
		Integer i = 1;
	
		{	Boolean actual = new Boolean(i.intValue()==0?false:true);
			Boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromIntegerToBoolean, "i");
			String expected = "new Boolean(i.intValue()==0?false:true)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromLongToBoolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Boolean.class, Long.class);
			ConversionType actual = ConversionType.FromLongToBoolean;
			assertEquals(expected, actual);		}
		
		Long l = 1L;
	
		{	Boolean actual = new Boolean(l.longValue()==0?false:true);
			Boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromLongToBoolean, "l");
			String expected = "new Boolean(l.longValue()==0?false:true)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromFloatToBoolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Boolean.class, Float.class);
			ConversionType actual = ConversionType.FromFloatToBoolean;
			assertEquals(expected, actual);		}
		
		Float f = 1.2F;
	
		{	Boolean actual = new Boolean(f.floatValue()==0?false:true);
			Boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromFloatToBoolean, "f");
			String expected = "new Boolean(f.floatValue()==0?false:true)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromDoubleToBoolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Boolean.class, Double.class);
			ConversionType actual = ConversionType.FromDoubleToBoolean;
			assertEquals(expected, actual);		}
		
		Double d = 1.2D;
	
		{	Boolean actual = new Boolean(d.doubleValue()==0?false:true);
			Boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromDoubleToBoolean, "d");
			String expected = "new Boolean(d.doubleValue()==0?false:true)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromCharacterToBoolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Boolean.class, Character.class);
			ConversionType actual = ConversionType.FromCharacterToBoolean;
			assertEquals(expected, actual);		}
		
		Character c = 'F';
	
		{	Boolean actual = new Boolean(c.charValue()=='T'?true:c.charValue()=='F'?false:null);
			Boolean expected = false;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromCharacterToBoolean, "c");
			String expected = "new Boolean(c.charValue()=='T'?true:c.charValue()=='F'?false:null)";
			assertEquals(expected, actual);		}
	}
	
	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO PRIMITIVE BOOLEAN
	// -----------------------------------------------------------------------------
	
	public void testFrombyteToboolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(boolean.class, byte.class);
			ConversionType actual = ConversionType.FrombyteToboolean;
			assertEquals(expected, actual);		}
		
		byte b = 1;
	
		{	boolean actual = b==0?false:true;
			boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombyteToboolean, "b");
			String expected = "b==0?false:true";
			assertEquals(expected, actual);		}
	}
	
	public void testFromshortToboolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(boolean.class, short.class);
			ConversionType actual = ConversionType.FromshortToboolean;
			assertEquals(expected, actual);		}
		
		short s = 120;
	
		{	boolean actual = s==0?false:true;
			boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromshortToboolean, "s");
			String expected = "s==0?false:true";
			assertEquals(expected, actual);		}
	}
	
	public void testFromintToboolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(boolean.class, int.class);
			ConversionType actual = ConversionType.FromintToboolean;
			assertEquals(expected, actual);		}
		
		int i = 1;
	
		{	boolean actual = i==0?false:true;
			boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromintToboolean, "i");
			String expected = "i==0?false:true";
			assertEquals(expected, actual);		}
	}
	
	public void testFromlongToboolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(boolean.class, long.class);
			ConversionType actual = ConversionType.FromlongToboolean;
			assertEquals(expected, actual);		}
		
		long l = 1;
	
		{	boolean actual = l==0?false:true;
			boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromlongToboolean, "l");
			String expected = "l==0?false:true";
			assertEquals(expected, actual);		}
	}
	
	public void testFromfloatToboolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(boolean.class, float.class);
			ConversionType actual = ConversionType.FromfloatToboolean;
			assertEquals(expected, actual);		}
		
		float f = 1;
	
		{	boolean actual = f==0?false:true;
			boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromfloatToboolean, "f");
			String expected = "f==0?false:true";
			assertEquals(expected, actual);		}
	}
	
	public void testFromdoubleToboolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(boolean.class, double.class);
			ConversionType actual = ConversionType.FromdoubleToboolean;
			assertEquals(expected, actual);		}
		
		double d = 1;
	
		{	boolean actual = d==0?false:true;
			boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromdoubleToboolean, "d");
			String expected = "d==0?false:true";
			assertEquals(expected, actual);		}
	}
	
	public void testFromcharToboolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(boolean.class, char.class);
			ConversionType actual = ConversionType.FromcharToboolean;
			assertEquals(expected, actual);		}
		
		char c = 'F';
	
		{	boolean actual = c=='T'?true:false;
			boolean expected = false;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromcharToboolean, "c");
			String expected = "c=='T'?true:false";
			assertEquals(expected, actual);		}
	}

	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO PRIMITIVE BOOLEAN
	// -----------------------------------------------------------------------------
	
	public void testFromStringToboolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(boolean.class, String.class);
			ConversionType actual = ConversionType.FromStringToboolean;
			assertEquals(expected, actual);		}
		
		String s = "true";
		
		{	boolean actual = Boolean.parseBoolean(s);
			boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromStringToboolean, "s");
			String expected = "Boolean.parseBoolean(s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromByteToboolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(boolean.class, Byte.class);
			ConversionType actual = ConversionType.FromByteToboolean;
			assertEquals(expected, actual);		}
		
		Byte b = 0;
	
		{	boolean actual = b.byteValue()==0?false:true;
			boolean expected = false;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromByteToboolean, "b");
			String expected = "b.byteValue()==0?false:true";
			assertEquals(expected, actual);		}
	}
	
	public void testFromShortToboolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(boolean.class, Short.class);
			ConversionType actual = ConversionType.FromShortToboolean;
			assertEquals(expected, actual);		}
		
		Short s = 1;
	
		{	boolean actual = s.shortValue()==0?false:true;
			boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromShortToboolean, "s");
			String expected = "s.shortValue()==0?false:true";
			assertEquals(expected, actual);		}
	}
	
	public void testFromIntegerToboolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(boolean.class, Integer.class);
			ConversionType actual = ConversionType.FromIntegerToboolean;
			assertEquals(expected, actual);		}
		
		Integer i = 1;
	
		{	boolean actual = i.intValue()==0?false:true;
			boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromIntegerToboolean, "i");
			String expected = "i.intValue()==0?false:true";
			assertEquals(expected, actual);		}
	}
	
	public void testFromLongToboolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(boolean.class, Long.class);
			ConversionType actual = ConversionType.FromLongToboolean;
			assertEquals(expected, actual);		}
		
		Long l = 1L;
	
		{	boolean actual = l.longValue()==0?false:true;
			boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromLongToboolean, "l");
			String expected = "l.longValue()==0?false:true";
			assertEquals(expected, actual);		}
	}
	
	public void testFromFloatToboolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(boolean.class, Float.class);
			ConversionType actual = ConversionType.FromFloatToboolean;
			assertEquals(expected, actual);		}
		
		Float f = 1F;
	
		{	boolean actual = f.floatValue()==0?false:true;
			boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromFloatToboolean, "f");
			String expected = "f.floatValue()==0?false:true";
			assertEquals(expected, actual);		}
	}
	
	public void testFromDoubleToboolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(boolean.class, Double.class);
			ConversionType actual = ConversionType.FromDoubleToboolean;
			assertEquals(expected, actual);		}
		
		Double d = 1D;
	
		{	boolean actual = d.doubleValue()==0?false:true;
			boolean expected = true;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromDoubleToboolean, "d");
			String expected = "d.doubleValue()==0?false:true";
			assertEquals(expected, actual);		}
	}
	
	public void testFromCharacterToboolean(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(boolean.class, Character.class);
			ConversionType actual = ConversionType.FromCharacterToboolean;
			assertEquals(expected, actual);		}
		
		Character c = 'F';
	
		{	boolean actual = c.charValue()=='T'?true:false;
			boolean expected = false;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromCharacterToboolean, "c");
			String expected = "c.charValue()=='T'?true:false";
			assertEquals(expected, actual);		}
	}
}
