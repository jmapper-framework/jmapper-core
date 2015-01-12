package com.googlecode.jmapper.conversions.implicit;

import com.googlecode.jmapper.conversions.implicit.ConversionHandler;
import com.googlecode.jmapper.enums.ConversionType;

import junit.framework.TestCase;

public class ConversionsToByteTest extends TestCase {

	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO WRAPPER BYTE
	// -----------------------------------------------------------------------------
	
	public void testFromshortToByte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Byte.class, short.class);
			ConversionType actual = ConversionType.FromshortToByte;
			assertEquals(expected, actual);		}
		
		short s = 127;
	
		{	Byte actual = new Byte((byte) s);
			Byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromshortToByte, "s");
			String expected = "new Byte((byte) s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromintToByte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Byte.class, int.class);
			ConversionType actual = ConversionType.FromintToByte;
			assertEquals(expected, actual);		}
		
		int i = 127;
	
		{	Byte actual = new Byte((byte) i);
			Byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromintToByte, "i");
			String expected = "new Byte((byte) i)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromlongToByte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Byte.class, long.class);
			ConversionType actual = ConversionType.FromlongToByte;
			assertEquals(expected, actual);		}
		
		long l = 127;
	
		{	Byte actual = new Byte((byte) l);
			Byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromlongToByte, "l");
			String expected = "new Byte((byte) l)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromfloatToByte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Byte.class, float.class);
			ConversionType actual = ConversionType.FromfloatToByte;
			assertEquals(expected, actual);		}
		
		float f = (float) 127.2;
	
		{	Byte actual = new Byte((byte) f);
			Byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromfloatToByte, "f");
			String expected = "new Byte((byte) f)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromdoubleToByte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Byte.class, double.class);
			ConversionType actual = ConversionType.FromdoubleToByte;
			assertEquals(expected, actual);		}
		
		double d = 127.2;
	
		{	Byte actual = new Byte((byte) d);
			Byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromdoubleToByte, "d");
			String expected = "new Byte((byte) d)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromcharToByte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Byte.class, char.class);
			ConversionType actual = ConversionType.FromcharToByte;
			assertEquals(expected, actual);		}
		
		char c = 'x';
	
		{	Byte actual = new Byte((byte) c);
			Byte expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromcharToByte, "c");
			String expected = "new Byte((byte) c)";
			assertEquals(expected, actual);		}
	}
	
	public void testFrombooleanToByte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Byte.class, boolean.class);
			ConversionType actual = ConversionType.FrombooleanToByte;
			assertEquals(expected, actual);		}
		
		boolean b = true;
	
		{	Byte actual = new Byte(b?(byte)1:(byte)0);
			Byte expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombooleanToByte, "b");
			String expected = "new Byte(b?(byte)1:(byte)0)";
			assertEquals(expected, actual);		}
	}

	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO WRAPPER BYTE
	// -----------------------------------------------------------------------------
	
	public void testFromStringToByte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Byte.class, String.class);
			ConversionType actual = ConversionType.FromStringToByte;
			assertEquals(expected, actual);		}
		
		String s = "120";
		
		{	Byte actual = new Byte(s);
			Byte expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromStringToByte, "s");
			String expected = "new Byte(s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromShortToByte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Byte.class, Short.class);
			ConversionType actual = ConversionType.FromShortToByte;
			assertEquals(expected, actual);		}
		
		Short s = 127;
	
		{	Byte actual = new Byte(s.byteValue());
			Byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromShortToByte, "s");
			String expected = "new Byte(s.byteValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromIntegerToByte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Byte.class, Integer.class);
			ConversionType actual = ConversionType.FromIntegerToByte;
			assertEquals(expected, actual);		}
		
		Integer i = 127;
	
		{	Byte actual = new Byte(i.byteValue());
			Byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromIntegerToByte, "i");
			String expected = "new Byte(i.byteValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromLongToByte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Byte.class, Long.class);
			ConversionType actual = ConversionType.FromLongToByte;
			assertEquals(expected, actual);		}
		
		Long l = 127L;
	
		{	Byte actual = new Byte(l.byteValue());
			Byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromLongToByte, "l");
			String expected = "new Byte(l.byteValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromFloatToByte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Byte.class, Float.class);
			ConversionType actual = ConversionType.FromFloatToByte;
			assertEquals(expected, actual);		}
		
		Float f = 127.2F;
	
		{	Byte actual = new Byte(f.byteValue());
			Byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromFloatToByte, "f");
			String expected = "new Byte(f.byteValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromDoubleToByte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Byte.class, Double.class);
			ConversionType actual = ConversionType.FromDoubleToByte;
			assertEquals(expected, actual);		}
		
		Double d = 127.2;
	
		{	Byte actual = new Byte(d.byteValue());
			Byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromDoubleToByte, "d");
			String expected = "new Byte(d.byteValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromCharacterToByte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Byte.class, Character.class);
			ConversionType actual = ConversionType.FromCharacterToByte;
			assertEquals(expected, actual);		}
		
		Character c = 'x';
	
		{	Byte actual = new Byte((byte)c.charValue());
			Byte expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromCharacterToByte, "c");
			String expected = "new Byte((byte)c.charValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromBooleanToByte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Byte.class, Boolean.class);
			ConversionType actual = ConversionType.FromBooleanToByte;
			assertEquals(expected, actual);		}
		
		Boolean b = true;
	
		{	Byte actual = new Byte(b.booleanValue()?(byte)1:(byte)0);
			Byte expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromBooleanToByte, "b");
			String expected = "new Byte(b.booleanValue()?(byte)1:(byte)0)";
			assertEquals(expected, actual);		}
	}
	
	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO PRIMITIVE BYTE
	// -----------------------------------------------------------------------------
	
	public void testFromshortTobyte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(byte.class, short.class);
			ConversionType actual = ConversionType.FromshortTobyte;
			assertEquals(expected, actual);		}
		
		short s = 127;
	
		{	byte actual = (byte) s;
			byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromshortTobyte, "s");
			String expected = "(byte) s";
			assertEquals(expected, actual);		}
	}
	
	public void testFromintTobyte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(byte.class, int.class);
			ConversionType actual = ConversionType.FromintTobyte;
			assertEquals(expected, actual);		}
		
		int i = 127;
	
		{	byte actual = (byte) i;
			byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromintTobyte, "i");
			String expected = "(byte) i";
			assertEquals(expected, actual);		}
	}
	
	public void testFromlongTobyte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(byte.class, long.class);
			ConversionType actual = ConversionType.FromlongTobyte;
			assertEquals(expected, actual);		}
		
		long l = 127;
	
		{	byte actual = (byte) l;
			byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromlongTobyte, "l");
			String expected = "(byte) l";
			assertEquals(expected, actual);		}
	}
	
	public void testFromfloatTobyte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(byte.class, float.class);
			ConversionType actual = ConversionType.FromfloatTobyte;
			assertEquals(expected, actual);		}
		
		float f = (float) 127.2;
	
		{	byte actual = (byte) f;
			byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromfloatTobyte, "f");
			String expected = "(byte) f";
			assertEquals(expected, actual);		}
	}
	
	public void testFromdoubleTobyte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(byte.class, double.class);
			ConversionType actual = ConversionType.FromdoubleTobyte;
			assertEquals(expected, actual);		}
		
		double d = 127.2;
	
		{	byte actual = (byte) d;
			byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromdoubleTobyte, "d");
			String expected = "(byte) d";
			assertEquals(expected, actual);		}
	}
	
	public void testFromcharTobyte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(byte.class, char.class);
			ConversionType actual = ConversionType.FromcharTobyte;
			assertEquals(expected, actual);		}
		
		char c = 'x';
	
		{	byte actual = (byte) c;
			byte expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromcharTobyte, "c");
			String expected = "(byte) c";
			assertEquals(expected, actual);		}
	}
	
	public void testFrombooleanTobyte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(byte.class, boolean.class);
			ConversionType actual = ConversionType.FrombooleanTobyte;
			assertEquals(expected, actual);		}
		
		boolean b = true;
	
		{	byte actual = b?(byte)1:(byte)0;
			byte expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombooleanTobyte, "b");
			String expected = "b?(byte)1:(byte)0";
			assertEquals(expected, actual);		}
	}

	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO PRIMITIVE BYTE
	// -----------------------------------------------------------------------------
	
	public void testFromStringTobyte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(byte.class, String.class);
			ConversionType actual = ConversionType.FromStringTobyte;
			assertEquals(expected, actual);		}
		
		String s = "120";
		
		{	byte actual = Byte.parseByte(s);
			byte expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromStringTobyte, "s");
			String expected = "Byte.parseByte(s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromShortTobyte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(byte.class, Short.class);
			ConversionType actual = ConversionType.FromShortTobyte;
			assertEquals(expected, actual);		}
		
		Short s = 127;
	
		{	byte actual = s.byteValue();
			byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromShortTobyte, "s");
			String expected = "s.byteValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromIntegerTobyte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(byte.class, Integer.class);
			ConversionType actual = ConversionType.FromIntegerTobyte;
			assertEquals(expected, actual);		}
		
		Integer i = 127;
	
		{	byte actual = i.byteValue();
			byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromIntegerTobyte, "i");
			String expected = "i.byteValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromLongTobyte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(byte.class, Long.class);
			ConversionType actual = ConversionType.FromLongTobyte;
			assertEquals(expected, actual);		}
		
		Long l = 127L;
	
		{	byte actual = l.byteValue();
			byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromLongTobyte, "l");
			String expected = "l.byteValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromFloatTobyte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(byte.class, Float.class);
			ConversionType actual = ConversionType.FromFloatTobyte;
			assertEquals(expected, actual);		}
		
		Float f = 127.2F;
	
		{	byte actual = f.byteValue();
			byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromFloatTobyte, "f");
			String expected = "f.byteValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromDoubleTobyte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(byte.class, Double.class);
			ConversionType actual = ConversionType.FromDoubleTobyte;
			assertEquals(expected, actual);		}
		
		Double d = 127.2;
	
		{	byte actual = d.byteValue();
			byte expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromDoubleTobyte, "d");
			String expected = "d.byteValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromCharacterTobyte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(byte.class, Character.class);
			ConversionType actual = ConversionType.FromCharacterTobyte;
			assertEquals(expected, actual);		}
		
		Character c = 'x';
	
		{	byte actual = (byte) c.charValue();
			byte expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromCharacterTobyte, "c");
			String expected = "(byte) c.charValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromBooleanTobyte(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(byte.class, Boolean.class);
			ConversionType actual = ConversionType.FromBooleanTobyte;
			assertEquals(expected, actual);		}
		
		Boolean b = true;
	
		{	byte actual = b.booleanValue()?(byte)1:(byte)0;
			byte expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromBooleanTobyte, "b");
			String expected = "b.booleanValue()?(byte)1:(byte)0";
			assertEquals(expected, actual);		}
	}
}
