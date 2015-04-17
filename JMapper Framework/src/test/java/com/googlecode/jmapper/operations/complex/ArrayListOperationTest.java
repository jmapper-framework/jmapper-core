package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class ArrayListOperationTest extends AOperation<ArrayListOperation> {

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("StringArray");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aSetInteger");
	}

	@Override
	protected ArrayListOperation getOperationIstance() {
		return new ArrayListOperation();
	}

	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.ABSENT);
	}

	@Override
	protected void AllAll() {
		
		expected = "   if(source.getASetInteger()!=null){"+
		newLine + "   java.lang.String[] arrayListOfDestination$i = (java.lang.String[])source.getASetInteger().toArray(new java.lang.String[source.getASetInteger().size()]);"+
		newLine + "   destination.setStringArray(arrayListOfDestination$i);"+
		newLine + 
		newLine + "   }else{"+
		newLine + "   destination.setStringArray(null);"+
		newLine + "   }"+newLine;
		
		write(newInstance);
		verify();

		expected = "   if(destination.getStringArray()!=null){"+
		 newLine + "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.lang.String[] arrayListOfDestination$i = (java.lang.String[])source.getASetInteger().toArray(new java.lang.String[source.getASetInteger().size()]);"+
		 newLine + "   java.lang.String[] dep$i = destination.getStringArray();"+
		 newLine + "   java.lang.String[] newDestination$i = (java.lang.String[])java.util.Arrays.copyOf(dep$i, dep$i.length + arrayListOfDestination$i.length);"+
		 newLine + "   System.arraycopy(arrayListOfDestination$i, 0, newDestination$i, dep$i.length, arrayListOfDestination$i.length);"+
		 newLine + "   destination.setStringArray(newDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setStringArray(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.lang.String[] arrayListOfDestination$y = (java.lang.String[])source.getASetInteger().toArray(new java.lang.String[source.getASetInteger().size()]);"+
		 newLine + "   destination.setStringArray(arrayListOfDestination$y);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setStringArray(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void AllValued() {
		
		expected = "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.lang.String[] arrayListOfDestination$i = (java.lang.String[])source.getASetInteger().toArray(new java.lang.String[source.getASetInteger().size()]);"+
		 newLine + "   destination.setStringArray(arrayListOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getASetInteger()!=null){"+
		 newLine + "   if(destination.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] arrayListOfDestination$i = (java.lang.String[])source.getASetInteger().toArray(new java.lang.String[source.getASetInteger().size()]);"+
		 newLine + "   java.lang.String[] dep$i = destination.getStringArray();"+
		 newLine + "   java.lang.String[] newDestination$i = (java.lang.String[])java.util.Arrays.copyOf(dep$i, dep$i.length + arrayListOfDestination$i.length);"+
		 newLine + "   System.arraycopy(arrayListOfDestination$i, 0, newDestination$i, dep$i.length, arrayListOfDestination$i.length);"+
		 newLine + "   destination.setStringArray(newDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   java.lang.String[] arrayListOfDestination$y = (java.lang.String[])source.getASetInteger().toArray(new java.lang.String[source.getASetInteger().size()]);"+
		 newLine + "   destination.setStringArray(arrayListOfDestination$y);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void ValuedAll() {
		
		expected = "   if(destination.getStringArray()!=null){"+
		 newLine + "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.lang.String[] arrayListOfDestination$i = (java.lang.String[])source.getASetInteger().toArray(new java.lang.String[source.getASetInteger().size()]);"+
		 newLine + "   java.lang.String[] dep$i = destination.getStringArray();"+
		 newLine + "   java.lang.String[] newDestination$i = (java.lang.String[])java.util.Arrays.copyOf(dep$i, dep$i.length + arrayListOfDestination$i.length);"+
		 newLine + "   System.arraycopy(arrayListOfDestination$i, 0, newDestination$i, dep$i.length, arrayListOfDestination$i.length);"+
		 newLine + "   destination.setStringArray(newDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setStringArray(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void ValuedValued() {

		expected = "   if(destination.getStringArray()!=null){"+
		 newLine + "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.lang.String[] arrayListOfDestination$i = (java.lang.String[])source.getASetInteger().toArray(new java.lang.String[source.getASetInteger().size()]);"+
		 newLine + "   java.lang.String[] dep$i = destination.getStringArray();"+
		 newLine + "   java.lang.String[] newDestination$i = (java.lang.String[])java.util.Arrays.copyOf(dep$i, dep$i.length + arrayListOfDestination$i.length);"+
		 newLine + "   System.arraycopy(arrayListOfDestination$i, 0, newDestination$i, dep$i.length, arrayListOfDestination$i.length);"+
		 newLine + "   destination.setStringArray(newDestination$i);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getStringArray()!=null){"+
		 newLine + "   if(source.getASetInteger()==null){"+
		 newLine + "   destination.setStringArray(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void NullValued() {

		expected = "   if(destination.getStringArray()==null){"+
		 newLine + "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.lang.String[] arrayListOfDestination$i = (java.lang.String[])source.getASetInteger().toArray(new java.lang.String[source.getASetInteger().size()]);"+
		 newLine + "   destination.setStringArray(arrayListOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}	
}
