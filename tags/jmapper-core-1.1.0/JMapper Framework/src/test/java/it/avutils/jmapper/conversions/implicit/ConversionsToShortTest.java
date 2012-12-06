package it.avutils.jmapper.conversions.implicit;

import it.avutils.jmapper.conversions.implicit.ConversionHandler;
import it.avutils.jmapper.conversions.implicit.analyzer.ConversionAnalyzer;
import it.avutils.jmapper.enums.ConversionType;
import junit.framework.TestCase;

public class ConversionsToShortTest extends TestCase{

	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO WRAPPER SHORT
	// -----------------------------------------------------------------------------
	
	public void testFrombyteToShort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Short.class, byte.class);
			ConversionType actual = ConversionType.FrombyteToShort;
			assertEquals(expected, actual);		}
		
		byte b = 127;
	
		{	Short actual = new Short((short) b);
			Short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombyteToShort, "b");
			String expected = "new Short((short) b)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromintToShort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Short.class, int.class);
			ConversionType actual = ConversionType.FromintToShort;
			assertEquals(expected, actual);		}
		
		int i = 127;
	
		{	Short actual = new Short((short) i);
			Short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromintToShort, "i");
			String expected = "new Short((short) i)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromlongToShort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Short.class, long.class);
			ConversionType actual = ConversionType.FromlongToShort;
			assertEquals(expected, actual);		}
		
		long l = 127;
	
		{	Short actual = new Short((short) l);
			Short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromlongToShort, "l");
			String expected = "new Short((short) l)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromfloatToShort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Short.class, float.class);
			ConversionType actual = ConversionType.FromfloatToShort;
			assertEquals(expected, actual);		}
		
		float f = (float) 127.2;
	
		{	Short actual = new Short((short) f);
			Short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromfloatToShort, "f");
			String expected = "new Short((short) f)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromdoubleToShort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Short.class, double.class);
			ConversionType actual = ConversionType.FromdoubleToShort;
			assertEquals(expected, actual);		}
		
		double d = 127.2;
	
		{	Short actual = new Short((short) d);
			Short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromdoubleToShort, "d");
			String expected = "new Short((short) d)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromcharToShort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Short.class, char.class);
			ConversionType actual = ConversionType.FromcharToShort;
			assertEquals(expected, actual);		}
		
		char c = 'x';
	
		{	Short actual = new Short((short) c);
			Short expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromcharToShort, "c");
			String expected = "new Short((short) c)";
			assertEquals(expected, actual);		}
	}
	
	public void testFrombooleanToShort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Short.class, boolean.class);
			ConversionType actual = ConversionType.FrombooleanToShort;
			assertEquals(expected, actual);		}
		
		boolean b = true;
	
		{	Short actual = new Short(b?(short)1:(short)0);
			Short expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombooleanToShort, "b");
			String expected = "new Short(b?(short)1:(short)0)";
			assertEquals(expected, actual);		}
	}

	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO WRAPPER SHORT
	// -----------------------------------------------------------------------------
	
	public void testFromStringToShort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Short.class, String.class);
			ConversionType actual = ConversionType.FromStringToShort;
			assertEquals(expected, actual);		}
		
		String s = "120";
		
		{	Short actual = new Short(s);
			Short expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromStringToShort, "s");
			String expected = "new Short(s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromByteToShort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Short.class, Byte.class);
			ConversionType actual = ConversionType.FromByteToShort;
			assertEquals(expected, actual);		}
		
		Byte b = 127;
	
		{	Short actual = new Short(b.shortValue());
			Short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromByteToShort, "b");
			String expected = "new Short(b.shortValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromIntegerToShort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Short.class, Integer.class);
			ConversionType actual = ConversionType.FromIntegerToShort;
			assertEquals(expected, actual);		}
		
		Integer i = 127;
	
		{	Short actual = new Short(i.shortValue());
			Short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromIntegerToShort, "i");
			String expected = "new Short(i.shortValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromLongToShort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Short.class, Long.class);
			ConversionType actual = ConversionType.FromLongToShort;
			assertEquals(expected, actual);		}
		
		Long l = 127L;
	
		{	Short actual = new Short(l.shortValue());
			Short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromLongToShort, "l");
			String expected = "new Short(l.shortValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromFloatToShort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Short.class, Float.class);
			ConversionType actual = ConversionType.FromFloatToShort;
			assertEquals(expected, actual);		}
		
		Float f = 127.2F;
	
		{	Short actual = new Short(f.shortValue());
			Short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromFloatToShort, "f");
			String expected = "new Short(f.shortValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromDoubleToShort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Short.class, Double.class);
			ConversionType actual = ConversionType.FromDoubleToShort;
			assertEquals(expected, actual);		}
		
		Double d = 127.2;
	
		{	Short actual = new Short(d.shortValue());
			Short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromDoubleToShort, "d");
			String expected = "new Short(d.shortValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromCharacterToShort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Short.class, Character.class);
			ConversionType actual = ConversionType.FromCharacterToShort;
			assertEquals(expected, actual);		}
		
		Character c = 'x';
	
		{	Short actual = new Short((short)c.charValue());
			Short expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromCharacterToShort, "c");
			String expected = "new Short((short)c.charValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromBooleanToShort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Short.class, Boolean.class);
			ConversionType actual = ConversionType.FromBooleanToShort;
			assertEquals(expected, actual);		}
		
		Boolean b = true;
	
		{	Short actual = new Short(b.booleanValue()?(short)1:(short)0);
			Short expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromBooleanToShort, "b");
			String expected = "new Short(b.booleanValue()?(short)1:(short)0)";
			assertEquals(expected, actual);		}
	}
	
	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO PRIMITIVE SHORT
	// -----------------------------------------------------------------------------
	
	public void testFrombyteToshort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(short.class, byte.class);
			ConversionType actual = ConversionType.FrombyteToshort;
			assertEquals(expected, actual);		}
		
		byte b = 127;
	
		{	short actual = (short) b;
			short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombyteToshort, "b");
			String expected = "(short) b";
			assertEquals(expected, actual);		}
	}
	
	public void testFromintToshort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(short.class, int.class);
			ConversionType actual = ConversionType.FromintToshort;
			assertEquals(expected, actual);		}
		
		int i = 127;
	
		{	short actual = (short) i;
			short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromintToshort, "i");
			String expected = "(short) i";
			assertEquals(expected, actual);		}
	}
	
	public void testFromlongToshort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(short.class, long.class);
			ConversionType actual = ConversionType.FromlongToshort;
			assertEquals(expected, actual);		}
		
		long l = 127;
	
		{	short actual = (short) l;
			short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromlongToshort, "l");
			String expected = "(short) l";
			assertEquals(expected, actual);		}
	}
	
	public void testFromfloatToshort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(short.class, float.class);
			ConversionType actual = ConversionType.FromfloatToshort;
			assertEquals(expected, actual);		}
		
		float f = (float) 127.2;
	
		{	short actual = (short) f;
			short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromfloatToshort, "f");
			String expected = "(short) f";
			assertEquals(expected, actual);		}
	}
	
	public void testFromdoubleToshort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(short.class, double.class);
			ConversionType actual = ConversionType.FromdoubleToshort;
			assertEquals(expected, actual);		}
		
		double d = 127.2;
	
		{	short actual = (short) d;
			short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromdoubleToshort, "d");
			String expected = "(short) d";
			assertEquals(expected, actual);		}
	}
	
	public void testFromcharToshort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(short.class, char.class);
			ConversionType actual = ConversionType.FromcharToshort;
			assertEquals(expected, actual);		}
		
		char c = 'x';
	
		{	short actual = (short) c;
			short expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromcharToshort, "c");
			String expected = "(short) c";
			assertEquals(expected, actual);		}
	}
	
	public void testFrombooleanToshort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(short.class, boolean.class);
			ConversionType actual = ConversionType.FrombooleanToshort;
			assertEquals(expected, actual);		}
		
		boolean b = true;
	
		{	short actual = b?(short)1:(short)0;
			short expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombooleanToshort, "b");
			String expected = "b?(short)1:(short)0";
			assertEquals(expected, actual);		}
	}

	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO PRIMITIVE SHORT
	// -----------------------------------------------------------------------------
	
	public void testFromStringToshort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(short.class, String.class);
			ConversionType actual = ConversionType.FromStringToshort;
			assertEquals(expected, actual);		}
		
		String s = "120";
		
		{	short actual = Short.parseShort(s);
			short expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromStringToshort, "s");
			String expected = "Short.parseShort(s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromByteToshort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(short.class, Byte.class);
			ConversionType actual = ConversionType.FromByteToshort;
			assertEquals(expected, actual);		}
		
		Byte s = 127;
	
		{	short actual = s.shortValue();
			short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromByteToshort, "b");
			String expected = "b.shortValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromIntegerToshort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(short.class, Integer.class);
			ConversionType actual = ConversionType.FromIntegerToshort;
			assertEquals(expected, actual);		}
		
		Integer i = 127;
	
		{	short actual = i.shortValue();
			short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromIntegerToshort, "i");
			String expected = "i.shortValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromLongToshort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(short.class, Long.class);
			ConversionType actual = ConversionType.FromLongToshort;
			assertEquals(expected, actual);		}
		
		Long l = 127L;
	
		{	short actual = l.shortValue();
			short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromLongToshort, "l");
			String expected = "l.shortValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromFloatToshort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(short.class, Float.class);
			ConversionType actual = ConversionType.FromFloatToshort;
			assertEquals(expected, actual);		}
		
		Float f = 127.2F;
	
		{	short actual = f.shortValue();
			short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromFloatToshort, "f");
			String expected = "f.shortValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromDoubleToshort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(short.class, Double.class);
			ConversionType actual = ConversionType.FromDoubleToshort;
			assertEquals(expected, actual);		}
		
		Double d = 127.2;
	
		{	short actual = d.shortValue();
			short expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromDoubleToshort, "d");
			String expected = "d.shortValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromCharacterToshort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(short.class, Character.class);
			ConversionType actual = ConversionType.FromCharacterToshort;
			assertEquals(expected, actual);		}
		
		Character c = 'x';
	
		{	short actual = (short) c.charValue();
			short expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromCharacterToshort, "c");
			String expected = "(short) c.charValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromBooleanToshort(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(short.class, Boolean.class);
			ConversionType actual = ConversionType.FromBooleanToshort;
			assertEquals(expected, actual);		}
		
		Boolean b = true;
	
		{	short actual = b.booleanValue()?(short)1:(short)0;
			short expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromBooleanToshort, "b");
			String expected = "b.booleanValue()?(short)1:(short)0";
			assertEquals(expected, actual);		}
	}
}
