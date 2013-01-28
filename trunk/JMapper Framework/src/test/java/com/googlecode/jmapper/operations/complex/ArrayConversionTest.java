package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.ClassesManager.getFieldValue;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;

import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.complex.ArrayOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.operations.AOperation;

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
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] arrayOfSource"+i+" = source.getStringArray();"+
	 	 newLine + "   java.lang.Integer[] arrayOfDestination"+i+" = new java.lang.Integer[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.String objectOfSoure"+i+" = (java.lang.String) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer objectOfDestination"+i+" = new Integer(objectOfSoure"+i+");"+
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   destination.setIntegerArray(arrayOfDestination"+i+");"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setIntegerArray(null);"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getIntegerArray()!=null){"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] arrayOfSource"+i+" = source.getStringArray();"+
		 newLine + "   java.lang.Integer[] arrayOfDestination"+i+" = new java.lang.Integer[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.String objectOfSoure"+i+" = (java.lang.String) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer objectOfDestination"+i+" = new Integer(objectOfSoure"+i+");"+
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   java.lang.Integer[] dep"+i+" = destination.getIntegerArray();"+
		 newLine + "   java.lang.Integer[] newDestination"+i+" = new java.lang.Integer[dep"+i+".length + arrayOfDestination"+i+".length];"+
		 newLine + "   int counter"+i+" = 0;"+
		 newLine + "   for(int index"+i+" = dep"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = dep"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   for(int index"+i+" = arrayOfDestination"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = arrayOfDestination"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   destination.setIntegerArray(newDestination"+i+++");"+
	 	 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setIntegerArray(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] arrayOfSource"+i+" = source.getStringArray();"+
		 newLine + "   java.lang.Integer[] arrayOfDestination"+i+" = new java.lang.Integer[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.String objectOfSoure"+i+" = (java.lang.String) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer objectOfDestination"+i+" = new Integer(objectOfSoure"+i+");"+
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   destination.setIntegerArray(arrayOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setIntegerArray(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void AllValued() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] arrayOfSource"+i+" = source.getStringArray();"+
		 newLine + "   java.lang.Integer[] arrayOfDestination"+i+" = new java.lang.Integer[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.String objectOfSoure"+i+" = (java.lang.String) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer objectOfDestination"+i+" = new Integer(objectOfSoure"+i+");"+
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   destination.setIntegerArray(arrayOfDestination"+i+");"+
		 newLine +
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getStringArray()!=null){"+
		 newLine + "   if(destination.getIntegerArray()!=null){"+
		 newLine + "   java.lang.String[] arrayOfSource"+i+" = source.getStringArray();"+
		 newLine + "   java.lang.Integer[] arrayOfDestination"+i+" = new java.lang.Integer[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.String objectOfSoure"+i+" = (java.lang.String) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer objectOfDestination"+i+" = new Integer(objectOfSoure"+i+");"+
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   java.lang.Integer[] dep"+i+" = destination.getIntegerArray();"+
		 newLine + "   java.lang.Integer[] newDestination"+i+" = new java.lang.Integer[dep"+i+".length + arrayOfDestination"+i+".length];"+
		 newLine + "   int counter"+i+" = 0;"+
		 newLine + "   for(int index"+i+" = dep"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = dep"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   for(int index"+i+" = arrayOfDestination"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = arrayOfDestination"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   destination.setIntegerArray(newDestination"+i+++");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   java.lang.String[] arrayOfSource"+i+" = source.getStringArray();"+
		 newLine + "   java.lang.Integer[] arrayOfDestination"+i+" = new java.lang.Integer[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.String objectOfSoure"+i+" = (java.lang.String) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer objectOfDestination"+i+" = new Integer(objectOfSoure"+i+");"+
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   destination.setIntegerArray(arrayOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void ValuedAll() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getIntegerArray()!=null){"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] arrayOfSource"+i+" = source.getStringArray();"+
		 newLine + "   java.lang.Integer[] arrayOfDestination"+i+" = new java.lang.Integer[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.String objectOfSoure"+i+" = (java.lang.String) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer objectOfDestination"+i+" = new Integer(objectOfSoure"+i+");"+
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   java.lang.Integer[] dep"+i+" = destination.getIntegerArray();"+
		 newLine + "   java.lang.Integer[] newDestination"+i+" = new java.lang.Integer[dep"+i+".length + arrayOfDestination"+i+".length];"+
		 newLine + "   int counter"+i+" = 0;"+
		 newLine + "   for(int index"+i+" = dep"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = dep"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   for(int index"+i+" = arrayOfDestination"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = arrayOfDestination"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   destination.setIntegerArray(newDestination"+i+");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setIntegerArray(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getIntegerArray()!=null){"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] arrayOfSource"+i+" = source.getStringArray();"+
		 newLine + "   java.lang.Integer[] arrayOfDestination"+i+" = new java.lang.Integer[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.String objectOfSoure"+i+" = (java.lang.String) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer objectOfDestination"+i+" = new Integer(objectOfSoure"+i+");"+
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   java.lang.Integer[] dep"+i+" = destination.getIntegerArray();"+
		 newLine + "   java.lang.Integer[] newDestination"+i+" = new java.lang.Integer[dep"+i+".length + arrayOfDestination"+i+".length];"+
		 newLine + "   int counter"+i+" = 0;"+
		 newLine + "   for(int index"+i+" = dep"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = dep"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   for(int index"+i+" = arrayOfDestination"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = arrayOfDestination"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   destination.setIntegerArray(newDestination"+i+");"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getIntegerArray()!=null){"+
	     newLine + "   if(source.getStringArray()==null){"+
	     newLine + "   destination.setIntegerArray(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}

	@Override
	protected void NullValued() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getIntegerArray()==null){"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] arrayOfSource"+i+" = source.getStringArray();"+
		 newLine + "   java.lang.Integer[] arrayOfDestination"+i+" = new java.lang.Integer[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.String objectOfSoure"+i+" = (java.lang.String) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer objectOfDestination"+i+" = new Integer(objectOfSoure"+i+");"+
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   destination.setIntegerArray(arrayOfDestination"+i+");"+
		 newLine +
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}

}
