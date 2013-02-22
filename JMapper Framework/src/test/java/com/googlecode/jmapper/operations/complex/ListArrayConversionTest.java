package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;
import java.util.ArrayList;

import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class ListArrayConversionTest extends AOperation<ListArrayOperation> {

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aSetInteger");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("StringArray");
	}

	@Override
	protected ListArrayOperation getOperationIstance() {
		return new ListArrayOperation();
	}

	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.FromStringToInteger);
	}

	@Override
	protected void setUp() {
		super.setUp();
		operation.setDestinationClass(ArrayList.class);
	}

	@Override
	protected void AllAll() {
		
		expected = "   if(source.getStringArray()!=null){"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   java.lang.String[] collectionOfSource$i = source.getStringArray();"+
		 newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.String objectOfSource$i = (java.lang.String) collectionOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer objectOfDestination$i = new Integer(objectOfSource$i);"+
		 newLine + "   listArrayOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setASetInteger(listArrayOfDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setASetInteger(null);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();

		expected = "   if(destination.getASetInteger()!=null){"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   java.lang.String[] collectionOfSource$i = source.getStringArray();"+
		 newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.String objectOfSource$i = (java.lang.String) collectionOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer objectOfDestination$i = new Integer(objectOfSource$i);"+
		 newLine + "   listArrayOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getASetInteger().addAll(listArrayOfDestination$i);"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setASetInteger(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$y = new java.util.ArrayList();"+
		 newLine + "   java.lang.String[] collectionOfSource$y = source.getStringArray();"+
		 newLine + "   for(int index$y = collectionOfSource$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   java.lang.String objectOfSource$y = (java.lang.String) collectionOfSource$y[index$y];"+
		 newLine + "   java.lang.Integer objectOfDestination$y = new Integer(objectOfSource$y);"+
		 newLine + "   listArrayOfDestination$y.add(objectOfDestination$y);"+
		 newLine + "   }"+
		 newLine + "   destination.setASetInteger(listArrayOfDestination$y);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setASetInteger(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void AllValued() {
		
		expected = "   if(source.getStringArray()!=null){"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   java.lang.String[] collectionOfSource$i = source.getStringArray();"+
		 newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.String objectOfSource$i = (java.lang.String) collectionOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer objectOfDestination$i = new Integer(objectOfSource$i);"+
		 newLine + "   listArrayOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setASetInteger(listArrayOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getStringArray()!=null){"+
		 newLine + "   if(destination.getASetInteger()!=null){"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   java.lang.String[] collectionOfSource$i = source.getStringArray();"+
		 newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.String objectOfSource$i = (java.lang.String) collectionOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer objectOfDestination$i = new Integer(objectOfSource$i);"+
		 newLine + "   listArrayOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getASetInteger().addAll(listArrayOfDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$y = new java.util.ArrayList();"+
		 newLine + "   java.lang.String[] collectionOfSource$y = source.getStringArray();"+
		 newLine + "   for(int index$y = collectionOfSource$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   java.lang.String objectOfSource$y = (java.lang.String) collectionOfSource$y[index$y];"+
		 newLine + "   java.lang.Integer objectOfDestination$y = new Integer(objectOfSource$y);"+
		 newLine + "   listArrayOfDestination$y.add(objectOfDestination$y);"+
		 newLine + "   }"+
		 newLine + "   destination.setASetInteger(listArrayOfDestination$y);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void ValuedAll() {
		
		expected = "   if(destination.getASetInteger()!=null){"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   java.lang.String[] collectionOfSource$i = source.getStringArray();"+
		 newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.String objectOfSource$i = (java.lang.String) collectionOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer objectOfDestination$i = new Integer(objectOfSource$i);"+
		 newLine + "   listArrayOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getASetInteger().addAll(listArrayOfDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setASetInteger(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void ValuedValued() {

		expected = "   if(destination.getASetInteger()!=null){"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   java.lang.String[] collectionOfSource$i = source.getStringArray();"+
		 newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.String objectOfSource$i = (java.lang.String) collectionOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer objectOfDestination$i = new Integer(objectOfSource$i);"+
		 newLine + "   listArrayOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getASetInteger().addAll(listArrayOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getASetInteger()!=null){"+
		 newLine + "   if(source.getStringArray()==null){"+
		 newLine + "   destination.setASetInteger(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void NullValued() {

		expected = "   if(destination.getASetInteger()==null){"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   java.lang.String[] collectionOfSource$i = source.getStringArray();"+
		 newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.String objectOfSource$i = (java.lang.String) collectionOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer objectOfDestination$i = new Integer(objectOfSource$i);"+
		 newLine + "   listArrayOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setASetInteger(listArrayOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}	

}
