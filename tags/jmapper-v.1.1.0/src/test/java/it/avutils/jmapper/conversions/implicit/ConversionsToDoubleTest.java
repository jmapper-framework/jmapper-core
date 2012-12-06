package it.avutils.jmapper.conversions.implicit;

import it.avutils.jmapper.conversions.implicit.ConversionHandler;
import it.avutils.jmapper.conversions.implicit.analyzer.ConversionAnalyzer;
import it.avutils.jmapper.enums.ConversionType;
import junit.framework.TestCase;

public class ConversionsToDoubleTest extends TestCase {

	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO WRAPPER DOUBLE
	// -----------------------------------------------------------------------------
	
	public void testFrombyteToDouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Double.class, byte.class);
			ConversionType actual = ConversionType.FrombyteToDouble;
			assertEquals(expected, actual);		}
		
		byte b = 127;
	
		{	Double actual = new Double((double) b);
			Double expected = 127D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombyteToDouble, "b");
			String expected = "new Double((double) b)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromshortToDouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Double.class, short.class);
			ConversionType actual = ConversionType.FromshortToDouble;
			assertEquals(expected, actual);		}
		
		short s = 127;
	
		{	Double actual = new Double((double) s);
			Double expected = 127D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromshortToDouble, "s");
			String expected = "new Double((double) s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromintToDouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Double.class, int.class);
			ConversionType actual = ConversionType.FromintToDouble;
			assertEquals(expected, actual);		}
		
		int i = 127;
	
		{	Double actual = new Double((double) i);
			Double expected = 127D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromintToDouble, "i");
			String expected = "new Double((double) i)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromlongToDouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Double.class, long.class);
			ConversionType actual = ConversionType.FromlongToDouble;
			assertEquals(expected, actual);		}
		
		long l = 127L;
	
		{	Double actual = new Double((double) l);
			Double expected = 127D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromlongToDouble, "l");
			String expected = "new Double((double) l)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromfloatToDouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Double.class, float.class);
			ConversionType actual = ConversionType.FromfloatToDouble;
			assertEquals(expected, actual);		}
		
		float f = 127F;
	
		{	Double actual = new Double((double) f);
			Double expected = 127D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromfloatToDouble, "f");
			String expected = "new Double((double) f)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromcharToDouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Double.class, char.class);
			ConversionType actual = ConversionType.FromcharToDouble;
			assertEquals(expected, actual);		}
		
		char c = 'x';
	
		{	Double actual = new Double((double) c);
			Double expected = 120D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromcharToDouble, "c");
			String expected = "new Double((double) c)";
			assertEquals(expected, actual);		}
	}
	
	public void testFrombooleanToDouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Double.class, boolean.class);
			ConversionType actual = ConversionType.FrombooleanToDouble;
			assertEquals(expected, actual);		}
		
		boolean b = true;
	
		{	Double actual = new Double(b?1D:0D);
			Double expected = 1D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombooleanToDouble, "b");
			String expected = "new Double(b?1D:0D)";
			assertEquals(expected, actual);		}
	}

	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO WRAPPER DOUBLE
	// -----------------------------------------------------------------------------
	
	public void testFromStringToDouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Double.class, String.class);
			ConversionType actual = ConversionType.FromStringToDouble;
			assertEquals(expected, actual);		}
		
		String s = "120";
		
		{	Double actual = new Double(s);
			Double expected = 120D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromStringToDouble, "s");
			String expected = "new Double(s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromByteToDouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Double.class, Byte.class);
			ConversionType actual = ConversionType.FromByteToDouble;
			assertEquals(expected, actual);		}
		
		Byte b = 127;
	
		{	Double actual = new Double(b.doubleValue());
			Double expected = 127D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromByteToDouble, "b");
			String expected = "new Double(b.doubleValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromShortToDouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Double.class, Short.class);
			ConversionType actual = ConversionType.FromShortToDouble;
			assertEquals(expected, actual);		}
		
		Short s = 127;
	
		{	Double actual = new Double(s.doubleValue());
			Double expected = 127D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromShortToDouble, "s");
			String expected = "new Double(s.doubleValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromIntegerToDouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Double.class, Integer.class);
			ConversionType actual = ConversionType.FromIntegerToDouble;
			assertEquals(expected, actual);		}
		
		Integer i = 127;
	
		{	Double actual = new Double(i.doubleValue());
			Double expected = 127D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromIntegerToDouble, "i");
			String expected = "new Double(i.doubleValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromLongToDouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Double.class, Long.class);
			ConversionType actual = ConversionType.FromLongToDouble;
			assertEquals(expected, actual);		}
		
		Long l = 127L;
	
		{	Double actual = new Double(l.doubleValue());
			Double expected = 127D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromLongToDouble, "l");
			String expected = "new Double(l.doubleValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromFloatToDouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Double.class, Float.class);
			ConversionType actual = ConversionType.FromFloatToDouble;
			assertEquals(expected, actual);		}
		
		Float f = 127F;
	
		{	Double actual = new Double(f.doubleValue());
			Double expected = 127D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromFloatToDouble, "f");
			String expected = "new Double(f.doubleValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromCharacterToDouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Double.class, Character.class);
			ConversionType actual = ConversionType.FromCharacterToDouble;
			assertEquals(expected, actual);		}
		
		Character c = 'x';
	
		{	Double actual = new Double((double)c.charValue());
			Double expected = 120D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromCharacterToDouble, "c");
			String expected = "new Double((double) c.charValue())";
			assertEquals(expected, actual);		}
	}
	
	public void testFromBooleanToDouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(Double.class, Boolean.class);
			ConversionType actual = ConversionType.FromBooleanToDouble;
			assertEquals(expected, actual);		}
		
		Boolean b = true;
	
		{	Double actual = new Double(b.booleanValue()?1D:0D);
			Double expected = 1D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromBooleanToDouble, "b");
			String expected = "new Double(b.booleanValue()?1D:0D)";
			assertEquals(expected, actual);		}
	}
	
	// -----------------------------------------------------------------------------
	// FROM PRIMITIVE TYPES TO PRIMITIVE DOUBLE
	// -----------------------------------------------------------------------------
	
	public void testFrombyteTodouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(double.class, byte.class);
			ConversionType actual = ConversionType.FrombyteTodouble;
			assertEquals(expected, actual);		}
		
		byte b = 127;
	
		{	double actual = (double) b;
			double expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombyteTodouble, "b");
			String expected = "(double) b";
			assertEquals(expected, actual);		}
	}
	
	public void testFromshortTodouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(double.class, short.class);
			ConversionType actual = ConversionType.FromshortTodouble;
			assertEquals(expected, actual);		}
		
		short s = 127;
	
		{	double actual = (double) s;
			double expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromshortTodouble, "s");
			String expected = "(double) s";
			assertEquals(expected, actual);		}
	}
	
	public void testFromintTodouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(double.class, int.class);
			ConversionType actual = ConversionType.FromintTodouble;
			assertEquals(expected, actual);		}
		
		int i = 127;
	
		{	double actual = (double) i;
			double expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromintTodouble, "i");
			String expected = "(double) i";
			assertEquals(expected, actual);		}
	}
	
	public void testFromlongTodouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(double.class, long.class);
			ConversionType actual = ConversionType.FromlongTodouble;
			assertEquals(expected, actual);		}
		
		long l = 127L;
	
		{	double actual = (double) l;
			double expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromlongTodouble, "l");
			String expected = "(double) l";
			assertEquals(expected, actual);		}
	}
	
	public void testFromfloatTodouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(double.class, float.class);
			ConversionType actual = ConversionType.FromfloatTodouble;
			assertEquals(expected, actual);		}
		
		float d = 127F;
	
		{	double actual = (double) d;
			double expected = 127D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromfloatTodouble, "f");
			String expected = "(double) f";
			assertEquals(expected, actual);		}
	}
	
	public void testFromcharTodouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(double.class, char.class);
			ConversionType actual = ConversionType.FromcharTodouble;
			assertEquals(expected, actual);		}
		
		char c = 'x';
	
		{	double actual = (double) c;
			double expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromcharTodouble, "c");
			String expected = "(double) c";
			assertEquals(expected, actual);		}
	}
	
	public void testFrombooleanTodouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(double.class, boolean.class);
			ConversionType actual = ConversionType.FrombooleanTodouble;
			assertEquals(expected, actual);		}
		
		boolean b = true;
	
		{	double actual = b?1D:0D;
			double expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FrombooleanTodouble, "b");
			String expected = "b?1D:0D";
			assertEquals(expected, actual);		}
	}

	// -----------------------------------------------------------------------------
	// FROM WRAPPER TYPES TO PRIMITIVE DOUBLE
	// -----------------------------------------------------------------------------
	
	public void testFromStringTodouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(double.class, String.class);
			ConversionType actual = ConversionType.FromStringTodouble;
			assertEquals(expected, actual);		}
		
		String s = "120";
		
		{	double actual = Double.parseDouble(s);
			double expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromStringTodouble, "s");
			String expected = "Double.parseDouble(s)";
			assertEquals(expected, actual);		}
	}
	
	public void testFromByteTodouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(double.class, Byte.class);
			ConversionType actual = ConversionType.FromByteTodouble;
			assertEquals(expected, actual);		}
		
		Byte s = 127;
	
		{	double actual = s.doubleValue();
			double expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromByteTodouble, "b");
			String expected = "b.doubleValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromShortTodouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(double.class, Short.class);
			ConversionType actual = ConversionType.FromShortTodouble;
			assertEquals(expected, actual);		}
		
		Short s = 127;
	
		{	double actual = s.doubleValue();
			double expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromShortTodouble, "s");
			String expected = "s.doubleValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromIntegerTodouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(double.class, Integer.class);
			ConversionType actual = ConversionType.FromIntegerTodouble;
			assertEquals(expected, actual);		}
		
		Integer i = 127;
	
		{	double actual = i.doubleValue();
			double expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromIntegerTodouble, "i");
			String expected = "i.doubleValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromLongTodouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(double.class, Long.class);
			ConversionType actual = ConversionType.FromLongTodouble;
			assertEquals(expected, actual);		}
		
		Long l = 127L;
	
		{	double actual = l.doubleValue();
			double expected = 127;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromLongTodouble, "l");
			String expected = "l.doubleValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromFloatTodouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(double.class, Float.class);
			ConversionType actual = ConversionType.FromFloatTodouble;
			assertEquals(expected, actual);		}
		
		Float f = 127F;
	
		{	double actual = f.doubleValue();
			double expected = 127D;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromFloatTodouble, "f");
			String expected = "f.doubleValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromCharacterTodouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(double.class, Character.class);
			ConversionType actual = ConversionType.FromCharacterTodouble;
			assertEquals(expected, actual);		}
		
		Character c = 'x';
	
		{	double actual = (double) c.charValue();
			double expected = 120;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromCharacterTodouble, "c");
			String expected = "(double) c.charValue()";
			assertEquals(expected, actual);		}
	}
	
	public void testFromBooleanTodouble(){

		{	ConversionType expected = ConversionAnalyzer.getConversionType(double.class, Boolean.class);
			ConversionType actual = ConversionType.FromBooleanTodouble;
			assertEquals(expected, actual);		}
		
		Boolean b = true;
	
		{	double actual = b.booleanValue()?1D:0D;
			double expected = 1;
			assertEquals(expected, actual);		}
		
		{	String actual = ConversionHandler.getConversion(ConversionType.FromBooleanTodouble, "b");
			String expected = "b.booleanValue()?1D:0D";
			assertEquals(expected, actual);		}
	}
}
