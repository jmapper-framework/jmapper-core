package com.googlecode.jmapper.operations.recursive;

import static com.googlecode.jmapper.util.ClassesManager.getFieldValue;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.operations.AOperation;
import java.lang.reflect.Field;
import java.util.ArrayList;

import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.operations.recursive.MappedCollectionOperation;

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
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getAMappedSet()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine + 
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetList(collectionOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setATargetList(null);"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getATargetList()!=null){"+
		 newLine + "   if(source.getAMappedSet()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine + 
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.getATargetList().addAll(collectionOfDestination"+i+++");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setATargetList(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getAMappedSet()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine + 
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetList(collectionOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setATargetList(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void AllValued() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getAMappedSet()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure"+i+".getField()!=null){"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetList(collectionOfDestination"+i+");"+
		 newLine + 		 
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		 
		expected = "   if(source.getAMappedSet()!=null){"+
		 newLine + "   if(destination.getATargetList()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure"+i+".getField()!=null){"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.getATargetList().addAll(collectionOfDestination"+i+++");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure"+i+".getField()!=null){"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetList(collectionOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void ValuedAll() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getATargetList()!=null){"+
		 newLine + "   if(source.getAMappedSet()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine + 
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.getATargetList().addAll(collectionOfDestination"+i+++");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setATargetList(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getATargetList()!=null){"+
		 newLine + "   if(source.getAMappedSet()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure"+i+".getField()!=null){"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.getATargetList().addAll(collectionOfDestination"+i+++");"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getATargetList()!=null){"+
	     newLine + "   if(source.getAMappedSet()==null){"+
	     newLine + "   destination.setATargetList(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}

	@Override
	protected void NullValued() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getATargetList()==null){"+
		 newLine + "   if(source.getAMappedSet()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getAMappedSet().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure"+i+".getField()!=null){"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetList(collectionOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}	
}