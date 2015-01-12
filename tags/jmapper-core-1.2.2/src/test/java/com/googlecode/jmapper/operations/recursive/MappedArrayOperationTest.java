package com.googlecode.jmapper.operations.recursive;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import java.lang.reflect.Field;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class MappedArrayOperationTest extends AOperation<MappedArrayOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aTargetArray");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aMappedArray");
	}

	@Override
	protected MappedArrayOperation getOperationIstance() {
		return new MappedArrayOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation();
	}
	
	@Override
	protected void AllAll() {
		
		expected = "   if(source.getAMappedArray()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource$i = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination$i = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource$i.length];"+
		 newLine + "   for(int index$i = arrayOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine +
		 newLine + "   arrayOfDestination$i[index$i] = objectOfDestination$i;"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(arrayOfDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setATargetArray(null);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(destination.getATargetArray()!=null){"+
		 newLine + "   if(source.getAMappedArray()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource$i = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination$i = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource$i.length];"+
		 newLine + "   for(int index$i = arrayOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine +
		 newLine + "   arrayOfDestination$i[index$i] = objectOfDestination$i;"+
		 newLine + "   }"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] dep$i = destination.getATargetArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] newDestination$i = new com.googlecode.jmapper.bean.TargetObject[dep$i.length + arrayOfDestination$i.length];"+
		 newLine + "   int counter$i = 0;"+
		 newLine + "   for(int index$i = dep$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   newDestination$i[counter$i++] = dep$i[index$i];"+
		 newLine + "   }"+
		 newLine + "   for(int index$i = arrayOfDestination$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   newDestination$i[counter$i++] = arrayOfDestination$i[index$i];"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(newDestination$i);"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setATargetArray(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getAMappedArray()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource$y = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination$y = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource$y.length];"+
		 newLine + "   for(int index$y = arrayOfSource$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$y = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource$y[index$y];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$y = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   objectOfDestination$y.setField(objectOfSoure$y.getField());"+
		 newLine +
		 newLine + "   arrayOfDestination$y[index$y] = objectOfDestination$y;"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(arrayOfDestination$y);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setATargetArray(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void AllValued() {
		
		expected = "   if(source.getAMappedArray()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource$i = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination$i = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource$i.length];"+
		 newLine + "   for(int index$i = arrayOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure$i.getField()!=null){"+
		 newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine + "   }"+
		 newLine +
		 newLine + "   arrayOfDestination$i[index$i] = objectOfDestination$i;"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(arrayOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getAMappedArray()!=null){"+
		 newLine + "   if(destination.getATargetArray()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource$i = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination$i = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource$i.length];"+
		 newLine + "   for(int index$i = arrayOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure$i.getField()!=null){"+
		 newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine + "   }"+
		 newLine +
		 newLine + "   arrayOfDestination$i[index$i] = objectOfDestination$i;"+
		 newLine + "   }"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] dep$i = destination.getATargetArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] newDestination$i = new com.googlecode.jmapper.bean.TargetObject[dep$i.length + arrayOfDestination$i.length];"+
		 newLine + "   int counter$i = 0;"+
		 newLine + "   for(int index$i = dep$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   newDestination$i[counter$i++] = dep$i[index$i];"+
		 newLine + "   }"+
		 newLine + "   for(int index$i = arrayOfDestination$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   newDestination$i[counter$i++] = arrayOfDestination$i[index$i];"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(newDestination$i);"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource$y = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination$y = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource$y.length];"+
		 newLine + "   for(int index$y = arrayOfSource$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$y = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource$y[index$y];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$y = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure$y.getField()!=null){"+
		 newLine + "   objectOfDestination$y.setField(objectOfSoure$y.getField());"+
		 newLine + "   }"+
		 newLine +
		 newLine + "   arrayOfDestination$y[index$y] = objectOfDestination$y;"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(arrayOfDestination$y);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void ValuedAll() {

		expected = "   if(destination.getATargetArray()!=null){"+
		 newLine + "   if(source.getAMappedArray()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource$i = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination$i = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource$i.length];"+
		 newLine + "   for(int index$i = arrayOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine +
		 newLine + "   arrayOfDestination$i[index$i] = objectOfDestination$i;"+
		 newLine + "   }"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] dep$i = destination.getATargetArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] newDestination$i = new com.googlecode.jmapper.bean.TargetObject[dep$i.length + arrayOfDestination$i.length];"+
		 newLine + "   int counter$i = 0;"+
		 newLine + "   for(int index$i = dep$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   newDestination$i[counter$i++] = dep$i[index$i];"+
		 newLine + "   }"+
		 newLine + "   for(int index$i = arrayOfDestination$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   newDestination$i[counter$i++] = arrayOfDestination$i[index$i];"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(newDestination$i);"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setATargetArray(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedValued() {

		expected = "   if(destination.getATargetArray()!=null){"+
		 newLine + "   if(source.getAMappedArray()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource$i = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination$i = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource$i.length];"+
		 newLine + "   for(int index$i = arrayOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure$i.getField()!=null){"+
		 newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine + "   }"+
		 newLine +
		 newLine + "   arrayOfDestination$i[index$i] = objectOfDestination$i;"+
		 newLine + "   }"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] dep$i = destination.getATargetArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] newDestination$i = new com.googlecode.jmapper.bean.TargetObject[dep$i.length + arrayOfDestination$i.length];"+
		 newLine + "   int counter$i = 0;"+
		 newLine + "   for(int index$i = dep$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   newDestination$i[counter$i++] = dep$i[index$i];"+
		 newLine + "   }"+
		 newLine + "   for(int index$i = arrayOfDestination$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   newDestination$i[counter$i++] = arrayOfDestination$i[index$i];"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(newDestination$i);"+
		 newLine +
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getATargetArray()!=null){"+
	     newLine + "   if(source.getAMappedArray()==null){"+
	     newLine + "   destination.setATargetArray(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}

	@Override
	protected void NullValued() {
		
		expected = "   if(destination.getATargetArray()==null){"+
		 newLine + "   if(source.getAMappedArray()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource$i = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination$i = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource$i.length];"+
		 newLine + "   for(int index$i = arrayOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure$i.getField()!=null){"+
		 newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine + "   }"+
		 newLine +
		 newLine + "   arrayOfDestination$i[index$i] = objectOfDestination$i;"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(arrayOfDestination$i);"+
		 newLine +
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}

}
