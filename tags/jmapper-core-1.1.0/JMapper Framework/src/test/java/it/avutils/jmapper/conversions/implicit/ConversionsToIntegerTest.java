package it.avutils.jmapper.conversions.implicit;

import junit.framework.TestCase;
import it.avutils.jmapper.conversions.implicit.ConversionHandler;
import it.avutils.jmapper.conversions.implicit.analyzer.ConversionAnalyzer;
import it.avutils.jmapper.enums.ConversionType;

public class ConversionsToIntegerTest extends TestCase{

	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO WRAPPER INTEGER
	// -----------------------------------------------------------------------------
	
	public void testFrombyteToInteger(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Integer.class, byte.class);
			ConversionType actual = ConversionType.FrombyteToInteger;
			assertEquals(expected, actual);		}
		
		byte b = 127;
	
		{	Integer actual = new Integer((int) b);
			Integer expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombyteToInteger, "b");
			String expected = "new Integer((int) b)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromshortToInteger(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Integer.class, short.class);
			ConversionType actual = ConversionType.FromshortToInteger;
			assertEquals(expected, actual);		}
		
		short s = 127;
	
		{	Integer actual = new Integer((int) s);
			Integer expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromshortToInteger, "s");
			String expected = "new Integer((int) s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromlongToInteger(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Integer.class, long.class);
			ConversionType actual = ConversionType.FromlongToInteger;
			assertEquals(expected, actual);		}
		
		long l = 127;
	
		{	Integer actual = new Integer((int) l);
			Integer expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromlongToInteger, "l");
			String expected = "new Integer((int) l)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromfloatToInteger(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Integer.class, float.class);
			ConversionType actual = ConversionType.FromfloatToInteger;
			assertEquals(expected, actual);		}
		
		float f = (float) 127.2;
	
		{	Integer actual = new Integer((int) f);
			Integer expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromfloatToInteger, "f");
			String expected = "new Integer((int) f)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromdoubleToInteger(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Integer.class, double.class);
			ConversionType actual = ConversionType.FromdoubleToInteger;
			assertEquals(expected, actual);		}
		
		double d = 127.2;
	
		{	Integer actual = new Integer((int) d);
			Integer expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromdoubleToInteger, "d");
			String expected = "new Integer((int) d)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromcharToInteger(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Integer.class, char.class);
			ConversionType actual = ConversionType.FromcharToInteger;
			assertEquals(expected, actual);		}
		
		char c = 'x';
	
		{	Integer actual = new Integer((int) c);
			Integer expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromcharToInteger, "c");
			String expected = "new Integer((int) c)";
			assertEquals(expected, actual);		}
	}
	
	public void testFrombooleanToInteger(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Integer.class, boolean.class);
			ConversionType actual = ConversionType.FrombooleanToInteger;
			assertEquals(expected, actual);		}
		
		boolean b = true;
	
		{	Integer actual = new Integer(b?(int)1:(int)0);
			Integer expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombooleanToInteger, "b");
			String expected = "new Integer(b?(int)1:(int)0)";
			assertEquals(expected, actual);		}
	}

	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO WRAPPER INTEGER
	// -----------------------------------------------------------------------------
	
	public void testFromStringToInteger(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Integer.class, String.class);
			ConversionType actual = ConversionType.FromStringToInteger;
			assertEquals(expected, actual);		}
		
		String s = "120";
		
		{	Integer actual = new Integer(s);
			Integer expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromStringToInteger, "s");
			String expected = "new Integer(s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromByteToInteger(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Integer.class, Byte.class);
			ConversionType actual = ConversionType.FromByteToInteger;
			assertEquals(expected, actual);		}
		
		Byte b = 127;
	
		{	Integer actual = new Integer(b.intValue());
			Integer expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromByteToInteger, "b");
			String expected = "new Integer(b.intValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromShortToInteger(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Integer.class, Short.class);
			ConversionType actual = ConversionType.FromShortToInteger;
			assertEquals(expected, actual);		}
		
		Short s = 127;
	
		{	Integer actual = new Integer(s.intValue());
			Integer expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromShortToInteger, "s");
			String expected = "new Integer(s.intValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromLongToInteger(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Integer.class, Long.class);
			ConversionType actual = ConversionType.FromLongToInteger;
			assertEquals(expected, actual);		}
		
		Long l = 127L;
	
		{	Integer actual = new Integer(l.intValue());
			Integer expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromLongToInteger, "l");
			String expected = "new Integer(l.intValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromFloatToInteger(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Integer.class, Float.class);
			ConversionType actual = ConversionType.FromFloatToInteger;
			assertEquals(expected, actual);		}
		
		Float f = 127.2F;
	
		{	Integer actual = new Integer(f.intValue());
			Integer expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromFloatToInteger, "f");
			String expected = "new Integer(f.intValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromDoubleToInteger(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Integer.class, Double.class);
			ConversionType actual = ConversionType.FromDoubleToInteger;
			assertEquals(expected, actual);		}
		
		Double d = 127.2;
	
		{	Integer actual = new Integer(d.intValue());
			Integer expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromDoubleToInteger, "d");
			String expected = "new Integer(d.intValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromCharacterToInteger(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Integer.class, Character.class);
			ConversionType actual = ConversionType.FromCharacterToInteger;
			assertEquals(expected, actual);		}
		
		Character c = 'x';
	
		{	Integer actual = new Integer((int)c.charValue());
			Integer expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromCharacterToInteger, "c");
			String expected = "new Integer((int) c.charValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromBooleanToInteger(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Integer.class, Boolean.class);
			ConversionType actual = ConversionType.FromBooleanToInteger;
			assertEquals(expected, actual);		}
		
		Boolean b = true;
	
		{	Integer actual = new Integer(b.booleanValue()?(int)1:(int)0);
			Integer expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromBooleanToInteger, "b");
			String expected = "new Integer(b.booleanValue()?(int)1:(int)0)";
			assertEquals(expected, actual);		}
	}
	
	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO PRIMITIVE INTEGER
	// -----------------------------------------------------------------------------
	
	public void testFrombyteToint(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(int.class, byte.class);
			ConversionType actual = ConversionType.FrombyteToint;
			assertEquals(expected, actual);		}
		
		byte b = 127;
	
		{	int actual = (int) b;
			int expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombyteToint, "b");
			String expected = "(int) b";
			assertEquals(expected, actual);		}
	}
	
	public void testFromshortToint(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(int.class, short.class);
			ConversionType actual = ConversionType.FromshortToint;
			assertEquals(expected, actual);		}
		
		short s = 127;
	
		{	int actual = (int) s;
			int expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromshortToint, "s");
			String expected = "(int) s";
			assertEquals(expected, actual);		}
	}
	
	public void testFromlongToint(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(int.class, long.class);
			ConversionType actual = ConversionType.FromlongToint;
			assertEquals(expected, actual);		}
		
		long l = 127;
	
		{	int actual = (int) l;
			int expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromlongToint, "l");
			String expected = "(int) l";
			assertEquals(expected, actual);		}
	}
	
	public void testFromfloatToint(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(int.class, float.class);
			ConversionType actual = ConversionType.FromfloatToint;
			assertEquals(expected, actual);		}
		
		float f = (float) 127.2;
	
		{	int actual = (int) f;
			int expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromfloatToint, "f");
			String expected = "(int) f";
			assertEquals(expected, actual);		}
	}
	
	public void testFromdoubleToint(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(int.class, double.class);
			ConversionType actual = ConversionType.FromdoubleToint;
			assertEquals(expected, actual);		}
		
		double d = 127.2;
	
		{	int actual = (int) d;
			int expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromdoubleToint, "d");
			String expected = "(int) d";
			assertEquals(expected, actual);		}
	}
	
	public void testFromcharToint(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(int.class, char.class);
			ConversionType actual = ConversionType.FromcharToint;
			assertEquals(expected, actual);		}
		
		char c = 'x';
	
		{	int actual = (int) c;
			int expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromcharToint, "c");
			String expected = "(int) c";
			assertEquals(expected, actual);		}
	}
	
	public void testFrombooleanToint(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(int.class, boolean.class);
			ConversionType actual = ConversionType.FrombooleanToint;
			assertEquals(expected, actual);		}
		
		boolean b = true;
	
		{	int actual = b?(int)1:(int)0;
			int expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombooleanToint, "b");
			String expected = "b?(int)1:(int)0";
			assertEquals(expected, actual);		}
	}

	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO PRIMITIVE INTEGER
	// -----------------------------------------------------------------------------
	
	public void testFromStringToint(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(int.class, String.class);
			ConversionType actual = ConversionType.FromStringToint;
			assertEquals(expected, actual);		}
		
		String s = "120";
		
		{	int actual = Integer.parseInt(s);
			int expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromStringToint, "s");
			String expected = "Integer.parseInt(s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromByteToint(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(int.class, Byte.class);
			ConversionType actual = ConversionType.FromByteToint;
			assertEquals(expected, actual);		}
		
		Byte s = 127;
	
		{	int actual = s.intValue();
			int expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromByteToint, "b");
			String expected = "b.intValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromShortToint(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(int.class, Short.class);
			ConversionType actual = ConversionType.FromShortToint;
			assertEquals(expected, actual);		}
		
		Short s = 127;
	
		{	int actual = s.intValue();
			int expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromShortToint, "s");
			String expected = "s.intValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromLongToint(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(int.class, Long.class);
			ConversionType actual = ConversionType.FromLongToint;
			assertEquals(expected, actual);		}
		
		Long l = 127L;
	
		{	int actual = l.intValue();
			int expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromLongToint, "l");
			String expected = "l.intValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromFloatToint(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(int.class, Float.class);
			ConversionType actual = ConversionType.FromFloatToint;
			assertEquals(expected, actual);		}
		
		Float f = 127.2F;
	
		{	int actual = f.intValue();
			int expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromFloatToint, "f");
			String expected = "f.intValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromDoubleToint(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(int.class, Double.class);
			ConversionType actual = ConversionType.FromDoubleToint;
			assertEquals(expected, actual);		}
		
		Double d = 127.2;
	
		{	int actual = d.intValue();
			int expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromDoubleToint, "d");
			String expected = "d.intValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromCharacterToint(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(int.class, Character.class);
			ConversionType actual = ConversionType.FromCharacterToint;
			assertEquals(expected, actual);		}
		
		Character c = 'x';
	
		{	int actual = (int) c.charValue();
			int expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromCharacterToint, "c");
			String expected = "(int) c.charValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromBooleanToint(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(int.class, Boolean.class);
			ConversionType actual = ConversionType.FromBooleanToint;
			assertEquals(expected, actual);		}
		
		Boolean b = true;
	
		{	int actual = b.booleanValue()?(int)1:(int)0;
			int expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromBooleanToint, "b");
			String expected = "b.booleanValue()?(int)1:(int)0";
			assertEquals(expected, actual);		}
	}
}
