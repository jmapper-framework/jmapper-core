package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import java.lang.reflect.Field;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class ArrayOperationTest extends AOperation<ArrayOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("StringArray");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("StringArray2");
	}

	@Override
	protected ArrayOperation getOperationIstance() {
		return new ArrayOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.ABSENT);
	}
	
	@Override
	protected void allAll() {
		
		expected = "   if(source.getStringArray2()!=null){"+
		 newLine + "   destination.setStringArray(source.getStringArray2());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setStringArray(null);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(destination.getStringArray()!=null){"+
		 newLine + "   if(source.getStringArray2()!=null){"+
		 newLine + "   java.lang.String[] dep$i = destination.getStringArray();"+
		 newLine + "   java.lang.String[] newDestination$i = (java.lang.String[]) java.util.Arrays.copyOf(dep$i, dep$i.length + source.getStringArray2().length);"+
		 newLine + "   System.arraycopy(source.getStringArray2(), 0, newDestination$i, dep$i.length, source.getStringArray2().length);"+
		 newLine + "   destination.setStringArray(newDestination$i);"+
		 newLine + "   }else{"+
		 newLine + "   destination.setStringArray(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getStringArray2()!=null){"+
		 newLine + "   destination.setStringArray(source.getStringArray2());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setStringArray(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void allValued() {
		
		expected = "   if(source.getStringArray2()!=null){"+
		 newLine + "   destination.setStringArray(source.getStringArray2());"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getStringArray2()!=null){"+
		 newLine + "   if(destination.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] dep$i = destination.getStringArray();"+
		 newLine + "   java.lang.String[] newDestination$i = (java.lang.String[]) java.util.Arrays.copyOf(dep$i, dep$i.length + source.getStringArray2().length);"+
		 newLine + "   System.arraycopy(source.getStringArray2(), 0, newDestination$i, dep$i.length, source.getStringArray2().length);"+
		 newLine + "   destination.setStringArray(newDestination$i);"+
		 newLine + "   }else{"+
		 newLine + "   destination.setStringArray(source.getStringArray2());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void valuedAll() {

		expected = "   if(destination.getStringArray()!=null){"+
		 newLine + "   if(source.getStringArray2()!=null){"+
		 newLine + "   java.lang.String[] dep$i = destination.getStringArray();"+
		 newLine + "   java.lang.String[] newDestination$i = (java.lang.String[]) java.util.Arrays.copyOf(dep$i, dep$i.length + source.getStringArray2().length);"+
		 newLine + "   System.arraycopy(source.getStringArray2(), 0, newDestination$i, dep$i.length, source.getStringArray2().length);"+
		 newLine + "   destination.setStringArray(newDestination$i);"+
		 newLine + "   }else{"+
		 newLine + "   destination.setStringArray(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void valuedValued() {

		expected = "   if(destination.getStringArray()!=null){"+
		 newLine + "   if(source.getStringArray2()!=null){"+
		 newLine + "   java.lang.String[] dep$i = destination.getStringArray();"+
		 newLine + "   java.lang.String[] newDestination$i = (java.lang.String[]) java.util.Arrays.copyOf(dep$i, dep$i.length + source.getStringArray2().length);"+
		 newLine + "   System.arraycopy(source.getStringArray2(), 0, newDestination$i, dep$i.length, source.getStringArray2().length);"+
		 newLine + "   destination.setStringArray(newDestination$i);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void valuedNull() {
		
		expected = "   if(destination.getStringArray()!=null){"+
	     newLine + "   if(source.getStringArray2()==null){"+
	     newLine + "   destination.setStringArray(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}

	@Override
	protected void nullValued() {
		
		expected = "   if(destination.getStringArray()==null){"+
		 newLine + "   if(source.getStringArray2()!=null){"+
		 newLine + "   destination.setStringArray(source.getStringArray2());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}

}
