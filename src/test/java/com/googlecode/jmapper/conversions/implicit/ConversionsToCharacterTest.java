package com.googlecode.jmapper.conversions.implicit;

import com.googlecode.jmapper.conversions.implicit.ConversionHandler;
import com.googlecode.jmapper.enums.ConversionType;

import junit.framework.TestCase;

public class ConversionsToCharacterTest extends TestCase{

	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO WRAPPER CHARACTER
	// -----------------------------------------------------------------------------
	
	public void testFrombyteToCharacter(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Character.class, byte.class);
			ConversionType actual = ConversionType.FrombyteToCharacter;
			assertEquals(expected, actual);		}
		
		byte b = 120;
	
		{	Character actual = new Character((char) b);
			Character expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombyteToCharacter, "b");
			String expected = "new Character((char) b)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromshortToCharacter(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Character.class, short.class);
			ConversionType actual = ConversionType.FromshortToCharacter;
			assertEquals(expected, actual);		}
		
		short s = 120;
	
		{	Character actual = new Character((char) s);
			Character expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromshortToCharacter, "s");
			String expected = "new Character((char) s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromintToCharacter(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Character.class, int.class);
			ConversionType actual = ConversionType.FromintToCharacter;
			assertEquals(expected, actual);		}
		
		int i = 120;
	
		{	Character actual = new Character((char) i);
			Character expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromintToCharacter, "i");
			String expected = "new Character((char) i)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromlongToCharacter(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Character.class, long.class);
			ConversionType actual = ConversionType.FromlongToCharacter;
			assertEquals(expected, actual);		}
		
		long l = 120L;
	
		{	Character actual = new Character((char) l);
			Character expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromlongToCharacter, "l");
			String expected = "new Character((char) l)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromfloatToCharacter(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Character.class, float.class);
			ConversionType actual = ConversionType.FromfloatToCharacter;
			assertEquals(expected, actual);		}
		
		float f = 120.2F;
	
		{	Character actual = new Character((char) f);
			Character expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromfloatToCharacter, "f");
			String expected = "new Character((char) f)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromdoubleToCharacter(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Character.class, double.class);
			ConversionType actual = ConversionType.FromdoubleToCharacter;
			assertEquals(expected, actual);		}
		
		double d = 120.2D;
	
		{	Character actual = new Character((char) d);
			Character expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromdoubleToCharacter, "d");
			String expected = "new Character((char) d)";
			assertEquals(expected, actual);		}
	}
	
	public void testFrombooleanToCharacter(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Character.class, boolean.class);
			ConversionType actual = ConversionType.FrombooleanToCharacter;
			assertEquals(expected, actual);		}
		
		boolean b = true;
	
		{	Character actual = new Character(b?'T':'F');
			Character expected = 'T';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombooleanToCharacter, "b");
			String expected = "new Character(b?'T':'F')";
			assertEquals(expected, actual);		}
	}

	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO WRAPPER CHARACTER
	// -----------------------------------------------------------------------------
	
	public void testFromStringToCharacter(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Character.class, String.class);
			ConversionType actual = ConversionType.FromStringToCharacter;
			assertEquals(expected, actual);		}
		
		String s = "xyz";
		
		{	Character actual = new Character(s.charAt(0));
			Character expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromStringToCharacter, "s");
			String expected = "new Character(s.charAt(0))";
			assertEquals(expected, actual);		}
	}
	
	public void testFromByteToCharacter(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Character.class, Byte.class);
			ConversionType actual = ConversionType.FromByteToCharacter;
			assertEquals(expected, actual);		}
		
		Byte b = 120;
	
		{	Character actual = new Character((char) b.byteValue());
			Character expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromByteToCharacter, "b");
			String expected = "new Character((char) b.byteValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromShortToCharacter(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Character.class, Short.class);
			ConversionType actual = ConversionType.FromShortToCharacter;
			assertEquals(expected, actual);		}
		
		Short s = 120;
	
		{	Character actual = new Character((char) s.shortValue());
			Character expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromShortToCharacter, "s");
			String expected = "new Character((char) s.shortValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromIntegerToCharacter(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Character.class, Integer.class);
			ConversionType actual = ConversionType.FromIntegerToCharacter;
			assertEquals(expected, actual);		}
		
		Integer i = 120;
	
		{	Character actual = new Character((char) i.intValue());
			Character expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromIntegerToCharacter, "i");
			String expected = "new Character((char) i.intValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromLongToCharacter(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Character.class, Long.class);
			ConversionType actual = ConversionType.FromLongToCharacter;
			assertEquals(expected, actual);		}
		
		Long l = 120L;
	
		{	Character actual = new Character((char) l.longValue());
			Character expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromLongToCharacter, "l");
			String expected = "new Character((char) l.longValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromFloatToCharacter(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Character.class, Float.class);
			ConversionType actual = ConversionType.FromFloatToCharacter;
			assertEquals(expected, actual);		}
		
		Float f = 120.2F;
	
		{	Character actual = new Character((char) f.floatValue());
			Character expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromFloatToCharacter, "f");
			String expected = "new Character((char) f.floatValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromDoubleToCharacter(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Character.class, Double.class);
			ConversionType actual = ConversionType.FromDoubleToCharacter;
			assertEquals(expected, actual);		}
		
		Double d = 120.2D;
	
		{	Character actual = new Character((char) d.doubleValue());
			Character expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromDoubleToCharacter, "d");
			String expected = "new Character((char) d.doubleValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromBooleanToCharacter(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Character.class, Boolean.class);
			ConversionType actual = ConversionType.FromBooleanToCharacter;
			assertEquals(expected, actual);		}
		
		Boolean b = true;
	
		{	Character actual = new Character(b.booleanValue()?'T':'F');
			Character expected = 'T';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromBooleanToCharacter, "b");
			String expected = "new Character(b.booleanValue()?'T':'F')";
			assertEquals(expected, actual);		}
	}
	
	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO PRIMITIVE CHARACTER
	// -----------------------------------------------------------------------------
	
	public void testFrombyteTochar(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(char.class, byte.class);
			ConversionType actual = ConversionType.FrombyteTochar;
			assertEquals(expected, actual);		}
		
		byte b = 120;
	
		{	char actual = (char) b;
			char expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombyteTochar, "b");
			String expected = "(char) b";
			assertEquals(expected, actual);		}
	}
	
	public void testFromshortTochar(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(char.class, short.class);
			ConversionType actual = ConversionType.FromshortTochar;
			assertEquals(expected, actual);		}
		
		short s = 120;
	
		{	char actual = (char) s;
			char expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromshortTochar, "s");
			String expected = "(char) s";
			assertEquals(expected, actual);		}
	}
	
	public void testFromintTochar(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(char.class, int.class);
			ConversionType actual = ConversionType.FromintTochar;
			assertEquals(expected, actual);		}
		
		int i = 120;
	
		{	char actual = (char) i;
			char expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromintTochar, "i");
			String expected = "(char) i";
			assertEquals(expected, actual);		}
	}
	
	public void testFromlongTochar(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(char.class, long.class);
			ConversionType actual = ConversionType.FromlongTochar;
			assertEquals(expected, actual);		}
		
		long l = 127L;
	
		{	char actual = (char) l;
			char expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromlongTochar, "l");
			String expected = "(char) l";
			assertEquals(expected, actual);		}
	}
	
	public void testFromfloatTochar(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(char.class, float.class);
			ConversionType actual = ConversionType.FromfloatTochar;
			assertEquals(expected, actual);		}
		
		float d = 120.2F;
	
		{	char actual = (char) d;
			char expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromfloatTochar, "f");
			String expected = "(char) f";
			assertEquals(expected, actual);		}
	}
	
	public void testFromdoubleTochar(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(char.class, double.class);
			ConversionType actual = ConversionType.FromdoubleTochar;
			assertEquals(expected, actual);		}
		
		double d = 120.2D;
	
		{	char actual = (char) d;
			char expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromdoubleTochar, "d");
			String expected = "(char) d";
			assertEquals(expected, actual);		}
	}
	
	public void testFrombooleanTochar(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(char.class, boolean.class);
			ConversionType actual = ConversionType.FrombooleanTochar;
			assertEquals(expected, actual);		}
		
		boolean b = true;
	
		{	char actual = b?'T':'F';
			char expected = 'T';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombooleanTochar, "b");
			String expected = "b?'T':'F'";
			assertEquals(expected, actual);		}
	}

	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO PRIMITIVE CHARACTER
	// -----------------------------------------------------------------------------
	
	public void testFromStringTochar(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(char.class, String.class);
			ConversionType actual = ConversionType.FromStringTochar;
			assertEquals(expected, actual);		}
		
		String s = "xyz";
		
		{	char actual = s.charAt(0);
			char expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromStringTochar, "s");
			String expected = "s.charAt(0)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromByteTochar(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(char.class, Byte.class);
			ConversionType actual = ConversionType.FromByteTochar;
			assertEquals(expected, actual);		}
		
		Byte b = 120;
	
		{	char actual = (char) b.byteValue();
			char expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromByteTochar, "b");
			String expected = "(char) b.byteValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromShortTochar(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(char.class, Short.class);
			ConversionType actual = ConversionType.FromShortTochar;
			assertEquals(expected, actual);		}
		
		Short s = 120;
	
		{	char actual = (char) s.shortValue();
			char expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromShortTochar, "s");
			String expected = "(char) s.shortValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromIntegerTochar(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(char.class, Integer.class);
			ConversionType actual = ConversionType.FromIntegerTochar;
			assertEquals(expected, actual);		}
		
		Integer i = 120;
	
		{	char actual = (char) i.intValue();
			char expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromIntegerTochar, "i");
			String expected = "(char) i.intValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromLongTochar(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(char.class, Long.class);
			ConversionType actual = ConversionType.FromLongTochar;
			assertEquals(expected, actual);		}
		
		Long l = 120L;
	
		{	char actual = (char) l.longValue();
			char expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromLongTochar, "l");
			String expected = "(char) l.longValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromFloatTochar(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(char.class, Float.class);
			ConversionType actual = ConversionType.FromFloatTochar;
			assertEquals(expected, actual);		}
		
		Float f = 120.2F;
	
		{	char actual = (char) f.floatValue();
			char expected = 'x';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromFloatTochar, "f");
			String expected = "(char) f.floatValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromDoubleTochar(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(char.class, Double.class);
			ConversionType actual = ConversionType.FromDoubleTochar;
			assertEquals(expected, actual);		}
		
		Double d = 120D;
	
		{	char actual = (char) d.doubleValue();
			char expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromDoubleTochar, "d");
			String expected = "(char) d.doubleValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromBooleanTochar(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(char.class, Boolean.class);
			ConversionType actual = ConversionType.FromBooleanTochar;
			assertEquals(expected, actual);		}
		
		Boolean b = true;
	
		{	char actual = b.booleanValue()?'T':'F';
			char expected = 'T';
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromBooleanTochar, "b");
			String expected = "b.booleanValue()?'T':'F'";
			assertEquals(expected, actual);		}
	}
}
