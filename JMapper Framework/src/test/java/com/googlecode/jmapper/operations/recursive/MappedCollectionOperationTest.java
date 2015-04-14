package com.googlecode.jmapper.operations.recursive;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import java.lang.reflect.Field;
import java.util.ArrayList;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class MappedCollectionOperationTest extends AOperation<MappedCollectionOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aTargetList");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aMappedSet");
	}

	@Override
	protected MappedCollectionOperation getOperationIstance() {
		return new MappedCollectionOperation();
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
		
		expected = "   if(source.getAMappedSet()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$i = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index$i = 0;index$i<collectionOfSource$i.length;index$i++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine + 
		 newLine + "   collectionOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetList(collectionOfDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setATargetList(null);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(destination.getATargetList()!=null){"+
		 newLine + "   if(source.getAMappedSet()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$i = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index$i = 0;index$i<collectionOfSource$i.length;index$i++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine + 
		 newLine + "   collectionOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getATargetList().addAll(collectionOfDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setATargetList(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getAMappedSet()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination$y = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$y = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index$y = 0;index$y<collectionOfSource$y.length;index$y++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$y = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$y[index$y];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$y = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   objectOfDestination$y.setField(objectOfSoure$y.getField());"+
		 newLine + 
		 newLine + "   collectionOfDestination$y.add(objectOfDestination$y);"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetList(collectionOfDestination$y);"+
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
		
		expected = "   if(source.getAMappedSet()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$i = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index$i = 0;index$i<collectionOfSource$i.length;index$i++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure$i.getField()!=null){"+
		 newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   collectionOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetList(collectionOfDestination$i);"+
		 newLine + 		 
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getAMappedSet()!=null){"+
		 newLine + "   if(destination.getATargetList()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$i = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index$i = 0;index$i<collectionOfSource$i.length;index$i++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure$i.getField()!=null){"+
		 newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   collectionOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getATargetList().addAll(collectionOfDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   java.util.ArrayList collectionOfDestination$y = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$y = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index$y = 0;index$y<collectionOfSource$y.length;index$y++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$y = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$y[index$y];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$y = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure$y.getField()!=null){"+
		 newLine + "   objectOfDestination$y.setField(objectOfSoure$y.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   collectionOfDestination$y.add(objectOfDestination$y);"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetList(collectionOfDestination$y);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void ValuedAll() {
		
		expected = "   if(destination.getATargetList()!=null){"+
		 newLine + "   if(source.getAMappedSet()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$i = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index$i = 0;index$i<collectionOfSource$i.length;index$i++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine + 
		 newLine + "   collectionOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getATargetList().addAll(collectionOfDestination$i);"+
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
		 newLine + "   if(source.getAMappedSet()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$i = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index$i = 0;index$i<collectionOfSource$i.length;index$i++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure$i.getField()!=null){"+
		 newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   collectionOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getATargetList().addAll(collectionOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getATargetList()!=null){"+
	     newLine + "   if(source.getAMappedSet()==null){"+
	     newLine + "   destination.setATargetList(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}

	@Override
	protected void NullValued() {

		expected = "   if(destination.getATargetList()==null){"+
		 newLine + "   if(source.getAMappedSet()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$i = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index$i = 0;index$i<collectionOfSource$i.length;index$i++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure$i.getField()!=null){"+
		 newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   collectionOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetList(collectionOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}	
}