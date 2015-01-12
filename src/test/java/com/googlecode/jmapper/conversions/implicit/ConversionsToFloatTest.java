package com.googlecode.jmapper.conversions.implicit;

import com.googlecode.jmapper.conversions.implicit.ConversionHandler;
import com.googlecode.jmapper.enums.ConversionType;

import junit.framework.TestCase;

public class ConversionsToFloatTest extends TestCase {

	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO WRAPPER FLOAT
	// -----------------------------------------------------------------------------
	
	public void testFrombyteToFloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Float.class, byte.class);
			ConversionType actual = ConversionType.FrombyteToFloat;
			assertEquals(expected, actual);		}
		
		byte b = 127;
	
		{	Float actual = new Float((float) b);
			Float expected = 127F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombyteToFloat, "b");
			String expected = "new Float((float) b)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromshortToFloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Float.class, short.class);
			ConversionType actual = ConversionType.FromshortToFloat;
			assertEquals(expected, actual);		}
		
		short s = 127;
	
		{	Float actual = new Float((float) s);
			Float expected = 127F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromshortToFloat, "s");
			String expected = "new Float((float) s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromintToFloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Float.class, int.class);
			ConversionType actual = ConversionType.FromintToFloat;
			assertEquals(expected, actual);		}
		
		int i = 127;
	
		{	Float actual = new Float((float) i);
			Float expected = 127F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromintToFloat, "i");
			String expected = "new Float((float) i)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromlongToFloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Float.class, long.class);
			ConversionType actual = ConversionType.FromlongToFloat;
			assertEquals(expected, actual);		}
		
		long l = 127L;
	
		{	Float actual = new Float((float) l);
			Float expected = 127F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromlongToFloat, "l");
			String expected = "new Float((float) l)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromdoubleToFloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Float.class, double.class);
			ConversionType actual = ConversionType.FromdoubleToFloat;
			assertEquals(expected, actual);		}
		
		double d = 127.2;
	
		{	Float actual = new Float((float) d);
			Float expected = 127.2F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromdoubleToFloat, "d");
			String expected = "new Float((float) d)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromcharToFloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Float.class, char.class);
			ConversionType actual = ConversionType.FromcharToFloat;
			assertEquals(expected, actual);		}
		
		char c = 'x';
	
		{	Float actual = new Float((float) c);
			Float expected = 120F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromcharToFloat, "c");
			String expected = "new Float((float) c)";
			assertEquals(expected, actual);		}
	}
	
	public void testFrombooleanToFloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Float.class, boolean.class);
			ConversionType actual = ConversionType.FrombooleanToFloat;
			assertEquals(expected, actual);		}
		
		boolean b = true;
	
		{	Float actual = new Float(b?1F:0F);
			Float expected = 1F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombooleanToFloat, "b");
			String expected = "new Float(b?1F:0F)";
			assertEquals(expected, actual);		}
	}

	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO WRAPPER FLOAT
	// -----------------------------------------------------------------------------
	
	public void testFromStringToFloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Float.class, String.class);
			ConversionType actual = ConversionType.FromStringToFloat;
			assertEquals(expected, actual);		}
		
		String s = "120";
		
		{	Float actual = new Float(s);
			Float expected = 120F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromStringToFloat, "s");
			String expected = "new Float(s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromByteToFloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Float.class, Byte.class);
			ConversionType actual = ConversionType.FromByteToFloat;
			assertEquals(expected, actual);		}
		
		Byte b = 127;
	
		{	Float actual = new Float(b.floatValue());
			Float expected = 127F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromByteToFloat, "b");
			String expected = "new Float(b.floatValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromShortToFloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Float.class, Short.class);
			ConversionType actual = ConversionType.FromShortToFloat;
			assertEquals(expected, actual);		}
		
		Short s = 127;
	
		{	Float actual = new Float(s.floatValue());
			Float expected = 127F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromShortToFloat, "s");
			String expected = "new Float(s.floatValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromIntegerToFloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Float.class, Integer.class);
			ConversionType actual = ConversionType.FromIntegerToFloat;
			assertEquals(expected, actual);		}
		
		Integer i = 127;
	
		{	Float actual = new Float(i.floatValue());
			Float expected = 127F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromIntegerToFloat, "i");
			String expected = "new Float(i.floatValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromLongToFloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Float.class, Long.class);
			ConversionType actual = ConversionType.FromLongToFloat;
			assertEquals(expected, actual);		}
		
		Long l = 127L;
	
		{	Float actual = new Float(l.floatValue());
			Float expected = 127F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromLongToFloat, "l");
			String expected = "new Float(l.floatValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromDoubleToFloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Float.class, Double.class);
			ConversionType actual = ConversionType.FromDoubleToFloat;
			assertEquals(expected, actual);		}
		
		Double d = 127.2;
	
		{	Float actual = new Float(d.floatValue());
			Float expected = 127.2F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromDoubleToFloat, "d");
			String expected = "new Float(d.floatValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromCharacterToFloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Float.class, Character.class);
			ConversionType actual = ConversionType.FromCharacterToFloat;
			assertEquals(expected, actual);		}
		
		Character c = 'x';
	
		{	Float actual = new Float((float)c.charValue());
			Float expected = 120F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromCharacterToFloat, "c");
			String expected = "new Float((float) c.charValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromBooleanToFloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Float.class, Boolean.class);
			ConversionType actual = ConversionType.FromBooleanToFloat;
			assertEquals(expected, actual);		}
		
		Boolean b = true;
	
		{	Float actual = new Float(b.booleanValue()?1F:0F);
			Float expected = 1F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromBooleanToFloat, "b");
			String expected = "new Float(b.booleanValue()?1F:0F)";
			assertEquals(expected, actual);		}
	}
	
	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO PRIMITIVE FLOAT
	// -----------------------------------------------------------------------------
	
	public void testFrombyteTofloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(float.class, byte.class);
			ConversionType actual = ConversionType.FrombyteTofloat;
			assertEquals(expected, actual);		}
		
		byte b = 127;
	
		{	float actual = (float) b;
			float expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombyteTofloat, "b");
			String expected = "(float) b";
			assertEquals(expected, actual);		}
	}
	
	public void testFromshortTofloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(float.class, short.class);
			ConversionType actual = ConversionType.FromshortTofloat;
			assertEquals(expected, actual);		}
		
		short s = 127;
	
		{	float actual = (float) s;
			float expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromshortTofloat, "s");
			String expected = "(float) s";
			assertEquals(expected, actual);		}
	}
	
	public void testFromintTofloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(float.class, int.class);
			ConversionType actual = ConversionType.FromintTofloat;
			assertEquals(expected, actual);		}
		
		int i = 127;
	
		{	float actual = (float) i;
			float expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromintTofloat, "i");
			String expected = "(float) i";
			assertEquals(expected, actual);		}
	}
	
	public void testFromlongTofloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(float.class, long.class);
			ConversionType actual = ConversionType.FromlongTofloat;
			assertEquals(expected, actual);		}
		
		long l = 127L;
	
		{	float actual = (float) l;
			float expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromlongTofloat, "l");
			String expected = "(float) l";
			assertEquals(expected, actual);		}
	}
	
	public void testFromdoubleTofloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(float.class, double.class);
			ConversionType actual = ConversionType.FromdoubleTofloat;
			assertEquals(expected, actual);		}
		
		double d = 127.2;
	
		{	float actual = (float) d;
			float expected = 127.2F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromdoubleTofloat, "d");
			String expected = "(float) d";
			assertEquals(expected, actual);		}
	}
	
	public void testFromcharTofloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(float.class, char.class);
			ConversionType actual = ConversionType.FromcharTofloat;
			assertEquals(expected, actual);		}
		
		char c = 'x';
	
		{	float actual = (float) c;
			float expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromcharTofloat, "c");
			String expected = "(float) c";
			assertEquals(expected, actual);		}
	}
	
	public void testFrombooleanTofloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(float.class, boolean.class);
			ConversionType actual = ConversionType.FrombooleanTofloat;
			assertEquals(expected, actual);		}
		
		boolean b = true;
	
		{	float actual = b?1F:0F;
			float expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombooleanTofloat, "b");
			String expected = "b?1F:0F";
			assertEquals(expected, actual);		}
	}

	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO PRIMITIVE FLOAT
	// -----------------------------------------------------------------------------
	
	public void testFromStringTofloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(float.class, String.class);
			ConversionType actual = ConversionType.FromStringTofloat;
			assertEquals(expected, actual);		}
		
		String s = "120";
		
		{	float actual = Float.parseFloat(s);
			float expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromStringTofloat, "s");
			String expected = "Float.parseFloat(s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromByteTofloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(float.class, Byte.class);
			ConversionType actual = ConversionType.FromByteTofloat;
			assertEquals(expected, actual);		}
		
		Byte s = 127;
	
		{	float actual = s.floatValue();
			float expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromByteTofloat, "b");
			String expected = "b.floatValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromShortTofloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(float.class, Short.class);
			ConversionType actual = ConversionType.FromShortTofloat;
			assertEquals(expected, actual);		}
		
		Short s = 127;
	
		{	float actual = s.floatValue();
			float expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromShortTofloat, "s");
			String expected = "s.floatValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromIntegerTofloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(float.class, Integer.class);
			ConversionType actual = ConversionType.FromIntegerTofloat;
			assertEquals(expected, actual);		}
		
		Integer i = 127;
	
		{	float actual = i.floatValue();
			float expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromIntegerTofloat, "i");
			String expected = "i.floatValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromLongTofloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(float.class, Long.class);
			ConversionType actual = ConversionType.FromLongTofloat;
			assertEquals(expected, actual);		}
		
		Long l = 127L;
	
		{	float actual = l.floatValue();
			float expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromLongTofloat, "l");
			String expected = "l.floatValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromDoubleTofloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(float.class, Double.class);
			ConversionType actual = ConversionType.FromDoubleTofloat;
			assertEquals(expected, actual);		}
		
		Double d = 127.2;
	
		{	float actual = d.floatValue();
			float expected = 127.2F;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromDoubleTofloat, "d");
			String expected = "d.floatValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromCharacterTofloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(float.class, Character.class);
			ConversionType actual = ConversionType.FromCharacterTofloat;
			assertEquals(expected, actual);		}
		
		Character c = 'x';
	
		{	float actual = (float) c.charValue();
			float expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromCharacterTofloat, "c");
			String expected = "(float) c.charValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromBooleanTofloat(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(float.class, Boolean.class);
			ConversionType actual = ConversionType.FromBooleanTofloat;
			assertEquals(expected, actual);		}
		
		Boolean b = true;
	
		{	float actual = b.booleanValue()?1F:0F;
			float expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromBooleanTofloat, "b");
			String expected = "b.booleanValue()?1F:0F";
			assertEquals(expected, actual);		}
	}
}
