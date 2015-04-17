package com.googlecode.jmapper.operations.recursive;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;
import java.util.ArrayList;

import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class MappedListArrayOperationTest extends
		AOperation<MappedListArrayOperation> {

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aTargetList");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aMappedArray");
	}

	@Override
	protected MappedListArrayOperation getOperationIstance() {
		return new MappedListArrayOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation();
	}
	
	@Override
	protected void setUp() {
		super.setUp();
		operation.setDestinationClass(ArrayList.class);
	}
	
	@Override
	protected void AllAll() {
		
		expected = "   if(source.getAMappedArray()!=null){"+
		newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] collectionOfSource$i = source.getAMappedArray();"+
		newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = collectionOfSource$i[index$i];"+
		newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		newLine + 
		newLine + "   listArrayOfDestination$i.add(objectOfDestination$i);"+
		newLine + "   }"+
		newLine + "   destination.setATargetList(listArrayOfDestination$i);"+
		newLine + 
		newLine + "   }else{"+
		newLine + "   destination.setATargetList(null);"+
		newLine + "   }"+newLine;
						
			write(newInstance);
			verify();

		expected = "   if(destination.getATargetList()!=null){"+
		newLine + "   if(source.getAMappedArray()!=null){"+
		newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] collectionOfSource$i = source.getAMappedArray();"+
		newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = collectionOfSource$i[index$i];"+
		newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		newLine + 
		newLine + "   listArrayOfDestination$i.add(objectOfDestination$i);"+
		newLine + "   }"+
		newLine + "   destination.getATargetList().addAll(listArrayOfDestination$i);"+
		newLine + 
		newLine + "   }else{"+
		newLine + "   destination.setATargetList(null);"+
		newLine + "   }"+
		newLine + "   }else{"+
		newLine + "   if(source.getAMappedArray()!=null){"+
		newLine + "   java.util.ArrayList listArrayOfDestination$y = new java.util.ArrayList();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] collectionOfSource$y = source.getAMappedArray();"+
		newLine + "   for(int index$y = collectionOfSource$y.length-1;index$y >=0;index$y--){"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$y = collectionOfSource$y[index$y];"+
		newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$y = new com.googlecode.jmapper.bean.TargetObject();"+
		newLine + "   objectOfDestination$y.setField(objectOfSoure$y.getField());"+
		newLine + 
		newLine + "   listArrayOfDestination$y.add(objectOfDestination$y);"+
		newLine + "   }"+
		newLine + "   destination.setATargetList(listArrayOfDestination$y);"+
		newLine + 
		newLine + "   }else{"+
		newLine + "   destination.setATargetList(null);"+
		newLine + "   }"+
		newLine + "   }"+newLine;
				
			write(enrichment);
			verify();
	}

	@Override
	protected void AllValued() {
		
		expected = "   if(source.getAMappedArray()!=null){"+
		newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] collectionOfSource$i = source.getAMappedArray();"+
		newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = collectionOfSource$i[index$i];"+
		newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		newLine + "   if(objectOfSoure$i.getField()!=null){"+
		newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		newLine + "   }"+
		newLine + 
		newLine + "   listArrayOfDestination$i.add(objectOfDestination$i);"+
		newLine + "   }"+
		newLine + "   destination.setATargetList(listArrayOfDestination$i);"+
		newLine + 
		newLine + "   }"+newLine;
		
			write(newInstance);
			verify();
		
		expected = "   if(source.getAMappedArray()!=null){"+
		newLine + "   if(destination.getATargetList()!=null){"+
		newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] collectionOfSource$i = source.getAMappedArray();"+
		newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = collectionOfSource$i[index$i];"+
		newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		newLine + "   if(objectOfSoure$i.getField()!=null){"+
		newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		newLine + "   }"+
		newLine + 
		newLine + "   listArrayOfDestination$i.add(objectOfDestination$i);"+
		newLine + "   }"+
		newLine + "   destination.getATargetList().addAll(listArrayOfDestination$i);"+
		newLine + 
		newLine + "   }else{"+
		newLine + "   java.util.ArrayList listArrayOfDestination$y = new java.util.ArrayList();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] collectionOfSource$y = source.getAMappedArray();"+
		newLine + "   for(int index$y = collectionOfSource$y.length-1;index$y >=0;index$y--){"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$y = collectionOfSource$y[index$y];"+
		newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$y = new com.googlecode.jmapper.bean.TargetObject();"+
		newLine + "   if(objectOfSoure$y.getField()!=null){"+
		newLine + "   objectOfDestination$y.setField(objectOfSoure$y.getField());"+
		newLine + "   }"+
		newLine + 
		newLine + "   listArrayOfDestination$y.add(objectOfDestination$y);"+
		newLine + "   }"+
		newLine + "   destination.setATargetList(listArrayOfDestination$y);"+
		newLine + 
		newLine + "   }"+
		newLine + "   }"+newLine;
		
			write(enrichment);
			verify();
	}

	@Override
	protected void ValuedAll() {
		
		expected = "   if(destination.getATargetList()!=null){"+
		newLine + "   if(source.getAMappedArray()!=null){"+
		newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] collectionOfSource$i = source.getAMappedArray();"+
		newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = collectionOfSource$i[index$i];"+
		newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		newLine + 
		newLine + "   listArrayOfDestination$i.add(objectOfDestination$i);"+
		newLine + "   }"+
		newLine + "   destination.getATargetList().addAll(listArrayOfDestination$i);"+
		newLine + 
		newLine + "   }else{"+
		newLine + "   destination.setATargetList(null);"+
		newLine + "   }"+
		newLine + "   }"+newLine;
		
			write(enrichment);
			verify();
	}

	@Override
	protected void ValuedValued() {
		
		expected = "   if(destination.getATargetList()!=null){"+
		newLine + "   if(source.getAMappedArray()!=null){"+
		newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] collectionOfSource$i = source.getAMappedArray();"+
		newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = collectionOfSource$i[index$i];"+
		newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		newLine + "   if(objectOfSoure$i.getField()!=null){"+
		newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		newLine + "   }"+
		newLine + 
		newLine + "   listArrayOfDestination$i.add(objectOfDestination$i);"+
		newLine + "   }"+
		newLine + "   destination.getATargetList().addAll(listArrayOfDestination$i);"+
		newLine + 
		newLine + "   }"+
		newLine + "   }"+newLine;
		
			write(enrichment);
			verify();
		
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getATargetList()!=null){"+
		newLine + "   if(source.getAMappedArray()==null){"+
		newLine + "   destination.setATargetList(null);"+
		newLine + "   }"+
		newLine + "   }"+newLine;
		
			write(enrichment);
			verify();
		
	}

	@Override
	protected void NullValued() {
		
		expected = "   if(destination.getATargetList()==null){"+
		newLine + "   if(source.getAMappedArray()!=null){"+
		newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] collectionOfSource$i = source.getAMappedArray();"+
		newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = collectionOfSource$i[index$i];"+
		newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		newLine + "   if(objectOfSoure$i.getField()!=null){"+
		newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		newLine + "   }"+
		newLine + 
		newLine + "   listArrayOfDestination$i.add(objectOfDestination$i);"+
		newLine + "   }"+
		newLine + "   destination.setATargetList(listArrayOfDestination$i);"+
		newLine + 
		newLine + "   }"+
		newLine + "   }"+newLine;
		write(enrichment);
		verify();
	}
}
