package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import java.lang.reflect.Field;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class ArrayListConversionTest extends AOperation<ArrayListOperation> {

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
		return new InfoOperation().setConversionType(ConversionType.FromIntegerToString);
	}

	@Override
	protected void AllAll() {
		
		expected = "   if(source.getASetInteger()!=null){"+
		 newLine + "   Object[] sourceArray$i = source.getASetInteger().toArray();"+
		 newLine + "   java.lang.String[] arrayListOfDestination$i = new java.lang.String[sourceArray$i.length];"+
		 newLine + "   for(int index$i = sourceArray$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.Integer sourceItem$i = (java.lang.Integer) sourceArray$i[index$i];"+
		 newLine + "   java.lang.String destinationItem$i = sourceItem$i.toString();"+
		 newLine + "   arrayListOfDestination$i[index$i] = destinationItem$i;"+
		 newLine + "   }"+
		 newLine + "   destination.setStringArray(arrayListOfDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setStringArray(null);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();

		expected = "   if(destination.getStringArray()!=null){"+
		 newLine + "   if(source.getASetInteger()!=null){"+
		 newLine + "   Object[] sourceArray$i = source.getASetInteger().toArray();"+
		 newLine + "   java.lang.String[] arrayListOfDestination$i = new java.lang.String[sourceArray$i.length];"+
		 newLine + "   for(int index$i = sourceArray$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.Integer sourceItem$i = (java.lang.Integer) sourceArray$i[index$i];"+
		 newLine + "   java.lang.String destinationItem$i = sourceItem$i.toString();"+
		 newLine + "   arrayListOfDestination$i[index$i] = destinationItem$i;"+
		 newLine + "   }"+
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
		 newLine + "   Object[] sourceArray$y = source.getASetInteger().toArray();"+
		 newLine + "   java.lang.String[] arrayListOfDestination$y = new java.lang.String[sourceArray$y.length];"+
		 newLine + "   for(int index$y = sourceArray$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   java.lang.Integer sourceItem$y = (java.lang.Integer) sourceArray$y[index$y];"+
		 newLine + "   java.lang.String destinationItem$y = sourceItem$y.toString();"+
		 newLine + "   arrayListOfDestination$y[index$y] = destinationItem$y;"+
		 newLine + "   }"+
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
		 newLine + "   Object[] sourceArray$i = source.getASetInteger().toArray();"+
		 newLine + "   java.lang.String[] arrayListOfDestination$i = new java.lang.String[sourceArray$i.length];"+
		 newLine + "   for(int index$i = sourceArray$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.Integer sourceItem$i = (java.lang.Integer) sourceArray$i[index$i];"+
		 newLine + "   java.lang.String destinationItem$i = sourceItem$i.toString();"+
		 newLine + "   arrayListOfDestination$i[index$i] = destinationItem$i;"+
		 newLine + "   }"+
		 newLine + "   destination.setStringArray(arrayListOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();

		expected = "   if(source.getASetInteger()!=null){"+
		 newLine + "   if(destination.getStringArray()!=null){"+
		 newLine + "   Object[] sourceArray$i = source.getASetInteger().toArray();"+
		 newLine + "   java.lang.String[] arrayListOfDestination$i = new java.lang.String[sourceArray$i.length];"+
		 newLine + "   for(int index$i = sourceArray$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.Integer sourceItem$i = (java.lang.Integer) sourceArray$i[index$i];"+
		 newLine + "   java.lang.String destinationItem$i = sourceItem$i.toString();"+
		 newLine + "   arrayListOfDestination$i[index$i] = destinationItem$i;"+
		 newLine + "   }"+
		 newLine + "   java.lang.String[] dep$i = destination.getStringArray();"+
		 newLine + "   java.lang.String[] newDestination$i = (java.lang.String[])java.util.Arrays.copyOf(dep$i, dep$i.length + arrayListOfDestination$i.length);"+
		 newLine + "   System.arraycopy(arrayListOfDestination$i, 0, newDestination$i, dep$i.length, arrayListOfDestination$i.length);"+
		 newLine + "   destination.setStringArray(newDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   Object[] sourceArray$y = source.getASetInteger().toArray();"+
		 newLine + "   java.lang.String[] arrayListOfDestination$y = new java.lang.String[sourceArray$y.length];"+
		 newLine + "   for(int index$y = sourceArray$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   java.lang.Integer sourceItem$y = (java.lang.Integer) sourceArray$y[index$y];"+
		 newLine + "   java.lang.String destinationItem$y = sourceItem$y.toString();"+
		 newLine + "   arrayListOfDestination$y[index$y] = destinationItem$y;"+
		 newLine + "   }"+
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
		 newLine + "   Object[] sourceArray$i = source.getASetInteger().toArray();"+
		 newLine + "   java.lang.String[] arrayListOfDestination$i = new java.lang.String[sourceArray$i.length];"+
		 newLine + "   for(int index$i = sourceArray$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.Integer sourceItem$i = (java.lang.Integer) sourceArray$i[index$i];"+
		 newLine + "   java.lang.String destinationItem$i = sourceItem$i.toString();"+
		 newLine + "   arrayListOfDestination$i[index$i] = destinationItem$i;"+
		 newLine + "   }"+
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
		 newLine + "   Object[] sourceArray$i = source.getASetInteger().toArray();"+
		 newLine + "   java.lang.String[] arrayListOfDestination$i = new java.lang.String[sourceArray$i.length];"+
		 newLine + "   for(int index$i = sourceArray$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.Integer sourceItem$i = (java.lang.Integer) sourceArray$i[index$i];"+
		 newLine + "   java.lang.String destinationItem$i = sourceItem$i.toString();"+
		 newLine + "   arrayListOfDestination$i[index$i] = destinationItem$i;"+
		 newLine + "   }"+
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
		 newLine + "   Object[] sourceArray$i = source.getASetInteger().toArray();"+
		 newLine + "   java.lang.String[] arrayListOfDestination$i = new java.lang.String[sourceArray$i.length];"+
		 newLine + "   for(int index$i = sourceArray$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.Integer sourceItem$i = (java.lang.Integer) sourceArray$i[index$i];"+
		 newLine + "   java.lang.String destinationItem$i = sourceItem$i.toString();"+
		 newLine + "   arrayListOfDestination$i[index$i] = destinationItem$i;"+
		 newLine + "   }"+
		 newLine + "   destination.setStringArray(arrayListOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}	
}
