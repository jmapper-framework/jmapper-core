package com.googlecode.jmapper.conversions.implicit;

import com.googlecode.jmapper.conversions.implicit.ConversionHandler;
import com.googlecode.jmapper.enums.ConversionType;

import junit.framework.TestCase;

public class ConversionsToLongTest extends TestCase {

	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO WRAPPER LONG
	// -----------------------------------------------------------------------------
	
	public void testFrombyteToLong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Long.class, byte.class);
			ConversionType actual = ConversionType.FrombyteToLong;
			assertEquals(expected, actual);		}
		
		byte b = 127;
	
		{	Long actual = new Long((long) b);
			Long expected = 127L;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombyteToLong, "b");
			String expected = "new Long((long) b)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromshortToLong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Long.class, short.class);
			ConversionType actual = ConversionType.FromshortToLong;
			assertEquals(expected, actual);		}
		
		short s = 127;
	
		{	Long actual = new Long((long) s);
			Long expected = 127L;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromshortToLong, "s");
			String expected = "new Long((long) s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromintToLong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Long.class, int.class);
			ConversionType actual = ConversionType.FromintToLong;
			assertEquals(expected, actual);		}
		
		int i = 127;
	
		{	Long actual = new Long((long) i);
			Long expected = 127L;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromintToLong, "i");
			String expected = "new Long((long) i)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromfloatToLong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Long.class, float.class);
			ConversionType actual = ConversionType.FromfloatToLong;
			assertEquals(expected, actual);		}
		
		float f = (float) 127.2;
	
		{	Long actual = new Long((long) f);
			Long expected = 127L;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromfloatToLong, "f");
			String expected = "new Long((long) f)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromdoubleToLong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Long.class, double.class);
			ConversionType actual = ConversionType.FromdoubleToLong;
			assertEquals(expected, actual);		}
		
		double d = 127.2;
	
		{	Long actual = new Long((long) d);
			Long expected = 127L;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromdoubleToLong, "d");
			String expected = "new Long((long) d)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromcharToLong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Long.class, char.class);
			ConversionType actual = ConversionType.FromcharToLong;
			assertEquals(expected, actual);		}
		
		char c = 'x';
	
		{	Long actual = new Long((long) c);
			Long expected = 120L;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromcharToLong, "c");
			String expected = "new Long((long) c)";
			assertEquals(expected, actual);		}
	}
	
	public void testFrombooleanToLong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Long.class, boolean.class);
			ConversionType actual = ConversionType.FrombooleanToLong;
			assertEquals(expected, actual);		}
		
		boolean b = true;
	
		{	Long actual = new Long(b?1L:0L);
			Long expected = 1L;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombooleanToLong, "b");
			String expected = "new Long(b?1L:0L)";
			assertEquals(expected, actual);		}
	}

	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO WRAPPER LONG
	// -----------------------------------------------------------------------------
	
	public void testFromStringToLong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Long.class, String.class);
			ConversionType actual = ConversionType.FromStringToLong;
			assertEquals(expected, actual);		}
		
		String s = "120";
		
		{	Long actual = new Long(s);
			Long expected = 120L;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromStringToLong, "s");
			String expected = "new Long(s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromByteToLong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Long.class, Byte.class);
			ConversionType actual = ConversionType.FromByteToLong;
			assertEquals(expected, actual);		}
		
		Byte b = 127;
	
		{	Long actual = new Long(b.longValue());
			Long expected = 127L;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromByteToLong, "b");
			String expected = "new Long(b.longValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromShortToLong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Long.class, Short.class);
			ConversionType actual = ConversionType.FromShortToLong;
			assertEquals(expected, actual);		}
		
		Short s = 127;
	
		{	Long actual = new Long(s.longValue());
			Long expected = 127L;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromShortToLong, "s");
			String expected = "new Long(s.longValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromIntegerToLong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Long.class, Integer.class);
			ConversionType actual = ConversionType.FromIntegerToLong;
			assertEquals(expected, actual);		}
		
		Integer i = 127;
	
		{	Long actual = new Long(i.longValue());
			Long expected = 127L;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromIntegerToLong, "i");
			String expected = "new Long(i.longValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromFloatToLong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Long.class, Float.class);
			ConversionType actual = ConversionType.FromFloatToLong;
			assertEquals(expected, actual);		}
		
		Float f = 127.2F;
	
		{	Long actual = new Long(f.longValue());
			Long expected = 127L;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromFloatToLong, "f");
			String expected = "new Long(f.longValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromDoubleToLong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Long.class, Double.class);
			ConversionType actual = ConversionType.FromDoubleToLong;
			assertEquals(expected, actual);		}
		
		Double d = 127.2;
	
		{	Long actual = new Long(d.longValue());
			Long expected = 127L;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromDoubleToLong, "d");
			String expected = "new Long(d.longValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromCharacterToLong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Long.class, Character.class);
			ConversionType actual = ConversionType.FromCharacterToLong;
			assertEquals(expected, actual);		}
		
		Character c = 'x';
	
		{	Long actual = new Long((long)c.charValue());
			Long expected = 120L;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromCharacterToLong, "c");
			String expected = "new Long((long) c.charValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromBooleanToLong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Long.class, Boolean.class);
			ConversionType actual = ConversionType.FromBooleanToLong;
			assertEquals(expected, actual);		}
		
		Boolean b = true;
	
		{	Long actual = new Long(b.booleanValue()?1L:0L);
			Long expected = 1L;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromBooleanToLong, "b");
			String expected = "new Long(b.booleanValue()?1L:0L)";
			assertEquals(expected, actual);		}
	}
	
	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO PRIMITIVE LONG
	// -----------------------------------------------------------------------------
	
	public void testFrombyteTolong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(long.class, byte.class);
			ConversionType actual = ConversionType.FrombyteTolong;
			assertEquals(expected, actual);		}
		
		byte b = 127;
	
		{	long actual = (long) b;
			long expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombyteTolong, "b");
			String expected = "(long) b";
			assertEquals(expected, actual);		}
	}
	
	public void testFromshortTolong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(long.class, short.class);
			ConversionType actual = ConversionType.FromshortTolong;
			assertEquals(expected, actual);		}
		
		short s = 127;
	
		{	long actual = (long) s;
			long expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromshortTolong, "s");
			String expected = "(long) s";
			assertEquals(expected, actual);		}
	}
	
	public void testFromintTolong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(long.class, int.class);
			ConversionType actual = ConversionType.FromintTolong;
			assertEquals(expected, actual);		}
		
		int i = 127;
	
		{	long actual = (long) i;
			long expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromintTolong, "i");
			String expected = "(long) i";
			assertEquals(expected, actual);		}
	}
	
	public void testFromfloatTolong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(long.class, float.class);
			ConversionType actual = ConversionType.FromfloatTolong;
			assertEquals(expected, actual);		}
		
		float f = (float) 127.2;
	
		{	long actual = (long) f;
			long expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromfloatTolong, "f");
			String expected = "(long) f";
			assertEquals(expected, actual);		}
	}
	
	public void testFromdoubleTolong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(long.class, double.class);
			ConversionType actual = ConversionType.FromdoubleTolong;
			assertEquals(expected, actual);		}
		
		double d = 127.2;
	
		{	long actual = (long) d;
			long expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromdoubleTolong, "d");
			String expected = "(long) d";
			assertEquals(expected, actual);		}
	}
	
	public void testFromcharTolong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(long.class, char.class);
			ConversionType actual = ConversionType.FromcharTolong;
			assertEquals(expected, actual);		}
		
		char c = 'x';
	
		{	long actual = (long) c;
			long expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromcharTolong, "c");
			String expected = "(long) c";
			assertEquals(expected, actual);		}
	}
	
	public void testFrombooleanTolong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(long.class, boolean.class);
			ConversionType actual = ConversionType.FrombooleanTolong;
			assertEquals(expected, actual);		}
		
		boolean b = true;
	
		{	long actual = b?1L:0L;
			long expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombooleanTolong, "b");
			String expected = "b?1L:0L";
			assertEquals(expected, actual);		}
	}

	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO PRIMITIVE LONG
	// -----------------------------------------------------------------------------
	
	public void testFromStringTolong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(long.class, String.class);
			ConversionType actual = ConversionType.FromStringTolong;
			assertEquals(expected, actual);		}
		
		String s = "120";
		
		{	long actual = Long.parseLong(s);
			long expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromStringTolong, "s");
			String expected = "Long.parseLong(s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromByteTolong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(long.class, Byte.class);
			ConversionType actual = ConversionType.FromByteTolong;
			assertEquals(expected, actual);		}
		
		Byte s = 127;
	
		{	long actual = s.longValue();
			long expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromByteTolong, "b");
			String expected = "b.longValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromShortTolong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(long.class, Short.class);
			ConversionType actual = ConversionType.FromShortTolong;
			assertEquals(expected, actual);		}
		
		Short s = 127;
	
		{	long actual = s.longValue();
			long expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromShortTolong, "s");
			String expected = "s.longValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromIntegerTolong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(long.class, Integer.class);
			ConversionType actual = ConversionType.FromIntegerTolong;
			assertEquals(expected, actual);		}
		
		Integer i = 127;
	
		{	long actual = i.longValue();
			long expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromIntegerTolong, "i");
			String expected = "i.longValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromFloatTolong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(long.class, Float.class);
			ConversionType actual = ConversionType.FromFloatTolong;
			assertEquals(expected, actual);		}
		
		Float f = 127.2F;
	
		{	long actual = f.longValue();
			long expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromFloatTolong, "f");
			String expected = "f.longValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromDoubleTolong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(long.class, Double.class);
			ConversionType actual = ConversionType.FromDoubleTolong;
			assertEquals(expected, actual);		}
		
		Double d = 127.2;
	
		{	long actual = d.longValue();
			long expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromDoubleTolong, "d");
			String expected = "d.longValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromCharacterTolong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(long.class, Character.class);
			ConversionType actual = ConversionType.FromCharacterTolong;
			assertEquals(expected, actual);		}
		
		Character c = 'x';
	
		{	long actual = (long) c.charValue();
			long expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromCharacterTolong, "c");
			String expected = "(long) c.charValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromBooleanTolong(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(long.class, Boolean.class);
			ConversionType actual = ConversionType.FromBooleanTolong;
			assertEquals(expected, actual);		}
		
		Boolean b = true;
	
		{	long actual = b.booleanValue()?1L:0L;
			long expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromBooleanTolong, "b");
			String expected = "b.booleanValue()?1L:0L";
			assertEquals(expected, actual);		}
	}
}
