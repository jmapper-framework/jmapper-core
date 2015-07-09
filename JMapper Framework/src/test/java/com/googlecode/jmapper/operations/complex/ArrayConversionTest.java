package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import java.lang.reflect.Field;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class ArrayConversionTest extends AOperation<ArrayOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("IntegerArray");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("StringArray");
	}

	@Override
	protected ArrayOperation getOperationIstance() {
		return new ArrayOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.FromStringToInteger);
	}
	
	
	@Override
	protected void AllAll() {
				
		expected = "   if(source.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] arrayOfSource$i = source.getStringArray();"+
	 	 newLine + "   java.lang.Integer[] arrayOfDestination$i = new java.lang.Integer[arrayOfSource$i.length];"+
		 newLine + "   for(int index$i = arrayOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.String objectOfSoure$i = (java.lang.String) arrayOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer objectOfDestination$i = new Integer(objectOfSoure$i);"+
		 newLine + "   arrayOfDestination$i[index$i] = objectOfDestination$i;"+
		 newLine + "   }"+
		 newLine + "   destination.setIntegerArray(arrayOfDestination$i);"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setIntegerArray(null);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
				
		expected = "   if(destination.getIntegerArray()!=null){"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] arrayOfSource$i = source.getStringArray();"+
		 newLine + "   java.lang.Integer[] arrayOfDestination$z = new java.lang.Integer[arrayOfSource$i.length];"+
		 newLine + "   for(int index$i = arrayOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.String objectOfSoure$i = (java.lang.String) arrayOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer objectOfDestination$i = new Integer(objectOfSoure$i);"+
		 newLine + "   arrayOfDestination$z[index$i] = objectOfDestination$i;"+
		 newLine + "   }"+
		 newLine + "   java.lang.Integer[] dep$i = destination.getIntegerArray();"+
		 newLine + "   java.lang.Integer[] newDestination$i = (java.lang.Integer[]) java.util.Arrays.copyOf(dep$i, dep$i.length + arrayOfDestination$z.length);"+
		 newLine + "   System.arraycopy(arrayOfDestination$z, 0, newDestination$i, dep$i.length, arrayOfDestination$z.length);"+
		 newLine + "   destination.setIntegerArray(newDestination$i);"+
	 	 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setIntegerArray(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] arrayOfSource$y = source.getStringArray();"+
		 newLine + "   java.lang.Integer[] arrayOfDestination$z = new java.lang.Integer[arrayOfSource$y.length];"+
		 newLine + "   for(int index$y = arrayOfSource$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   java.lang.String objectOfSoure$y = (java.lang.String) arrayOfSource$y[index$y];"+
		 newLine + "   java.lang.Integer objectOfDestination$y = new Integer(objectOfSoure$y);"+
		 newLine + "   arrayOfDestination$z[index$y] = objectOfDestination$y;"+
		 newLine + "   }"+
		 newLine + "   destination.setIntegerArray(arrayOfDestination$z);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setIntegerArray(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void AllValued() {
		
		expected = "   if(source.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] arrayOfSource$i = source.getStringArray();"+
		 newLine + "   java.lang.Integer[] arrayOfDestination$i = new java.lang.Integer[arrayOfSource$i.length];"+
		 newLine + "   for(int index$i = arrayOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.String objectOfSoure$i = (java.lang.String) arrayOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer objectOfDestination$i = new Integer(objectOfSoure$i);"+
		 newLine + "   arrayOfDestination$i[index$i] = objectOfDestination$i;"+
		 newLine + "   }"+
		 newLine + "   destination.setIntegerArray(arrayOfDestination$i);"+
		 newLine +
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getStringArray()!=null){"+
		 newLine + "   if(destination.getIntegerArray()!=null){"+
		 newLine + "   java.lang.String[] arrayOfSource$i = source.getStringArray();"+
		 newLine + "   java.lang.Integer[] arrayOfDestination$z = new java.lang.Integer[arrayOfSource$i.length];"+
		 newLine + "   for(int index$i = arrayOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.String objectOfSoure$i = (java.lang.String) arrayOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer objectOfDestination$i = new Integer(objectOfSoure$i);"+
		 newLine + "   arrayOfDestination$z[index$i] = objectOfDestination$i;"+
		 newLine + "   }"+
		 newLine + "   java.lang.Integer[] dep$i = destination.getIntegerArray();"+
		 newLine + "   java.lang.Integer[] newDestination$i = (java.lang.Integer[]) java.util.Arrays.copyOf(dep$i, dep$i.length + arrayOfDestination$z.length);"+
		 newLine + "   System.arraycopy(arrayOfDestination$z, 0, newDestination$i, dep$i.length, arrayOfDestination$z.length);"+
		 newLine + "   destination.setIntegerArray(newDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   java.lang.String[] arrayOfSource$y = source.getStringArray();"+
		 newLine + "   java.lang.Integer[] arrayOfDestination$z = new java.lang.Integer[arrayOfSource$y.length];"+
		 newLine + "   for(int index$y = arrayOfSource$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   java.lang.String objectOfSoure$y = (java.lang.String) arrayOfSource$y[index$y];"+
		 newLine + "   java.lang.Integer objectOfDestination$y = new Integer(objectOfSoure$y);"+
		 newLine + "   arrayOfDestination$z[index$y] = objectOfDestination$y;"+
		 newLine + "   }"+
		 newLine + "   destination.setIntegerArray(arrayOfDestination$z);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void ValuedAll() {

		expected = "   if(destination.getIntegerArray()!=null){"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] arrayOfSource$i = source.getStringArray();"+
		 newLine + "   java.lang.Integer[] arrayOfDestination$i = new java.lang.Integer[arrayOfSource$i.length];"+
		 newLine + "   for(int index$i = arrayOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.String objectOfSoure$i = (java.lang.String) arrayOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer objectOfDestination$i = new Integer(objectOfSoure$i);"+
		 newLine + "   arrayOfDestination$i[index$i] = objectOfDestination$i;"+
		 newLine + "   }"+
		 newLine + "   java.lang.Integer[] dep$i = destination.getIntegerArray();"+
		 newLine + "   java.lang.Integer[] newDestination$i = (java.lang.Integer[]) java.util.Arrays.copyOf(dep$i, dep$i.length + arrayOfDestination$i.length);"+
		 newLine + "   System.arraycopy(arrayOfDestination$i, 0, newDestination$i, dep$i.length, arrayOfDestination$i.length);"+
		 newLine + "   destination.setIntegerArray(newDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setIntegerArray(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedValued() {

		expected = "   if(destination.getIntegerArray()!=null){"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] arrayOfSource$i = source.getStringArray();"+
		 newLine + "   java.lang.Integer[] arrayOfDestination$i = new java.lang.Integer[arrayOfSource$i.length];"+
		 newLine + "   for(int index$i = arrayOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.String objectOfSoure$i = (java.lang.String) arrayOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer objectOfDestination$i = new Integer(objectOfSoure$i);"+
		 newLine + "   arrayOfDestination$i[index$i] = objectOfDestination$i;"+
		 newLine + "   }"+
		 newLine + "   java.lang.Integer[] dep$i = destination.getIntegerArray();"+
		 newLine + "   java.lang.Integer[] newDestination$i = (java.lang.Integer[]) java.util.Arrays.copyOf(dep$i, dep$i.length + arrayOfDestination$i.length);"+
		 newLine + "   System.arraycopy(arrayOfDestination$i, 0, newDestination$i, dep$i.length, arrayOfDestination$i.length);"+
		 newLine + "   destination.setIntegerArray(newDestination$i);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getIntegerArray()!=null){"+
	     newLine + "   if(source.getStringArray()==null){"+
	     newLine + "   destination.setIntegerArray(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}

	@Override
	protected void NullValued() {
		
		expected = "   if(destination.getIntegerArray()==null){"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] arrayOfSource$i = source.getStringArray();"+
		 newLine + "   java.lang.Integer[] arrayOfDestination$i = new java.lang.Integer[arrayOfSource$i.length];"+
		 newLine + "   for(int index$i = arrayOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.String objectOfSoure$i = (java.lang.String) arrayOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer objectOfDestination$i = new Integer(objectOfSoure$i);"+
		 newLine + "   arrayOfDestination$i[index$i] = objectOfDestination$i;"+
		 newLine + "   }"+
		 newLine + "   destination.setIntegerArray(arrayOfDestination$i);"+
		 newLine +
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}
}