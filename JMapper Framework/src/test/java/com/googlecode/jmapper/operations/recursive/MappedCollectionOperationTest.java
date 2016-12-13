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
	protected void allAll() {
		
		expected = "   if(source.getAMappedSet()!=null){"+
		 newLine + "   Object[] collectionOfSource$i = source.getAMappedSet().toArray();"+
		 newLine + "   int sourceLength$i = collectionOfSource$i.length;"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList(sourceLength$i);"+
		 newLine + "   for(int index$i = 0;index$i<sourceLength$i;index$i++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = null;" +
   	     newLine + "   if(super.getDestinationFactory()!=null){" +
   	     newLine + "   objectOfDestination$i = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
	     newLine + "   }else{" +
   	     newLine + "   objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();" +
	     newLine + "   }" + 
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
		 newLine + "   Object[] collectionOfSource$i = source.getAMappedSet().toArray();"+
		 newLine + "   int sourceLength$i = collectionOfSource$i.length;"+
		 newLine + "   java.util.ArrayList collectionOfDestination$z = new java.util.ArrayList(sourceLength$i);"+
		 newLine + "   for(int index$i = 0;index$i<sourceLength$i;index$i++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = null;" +
   	     newLine + "   if(super.getDestinationFactory()!=null){" +
   	     newLine + "   objectOfDestination$i = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
	     newLine + "   }else{" +
   	     newLine + "   objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();" +
	     newLine + "   }" + 
		 newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine + 
		 newLine + "   collectionOfDestination$z.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getATargetList().addAll(collectionOfDestination$z);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setATargetList(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getAMappedSet()!=null){"+
		 newLine + "   Object[] collectionOfSource$y = source.getAMappedSet().toArray();"+
		 newLine + "   int sourceLength$y = collectionOfSource$y.length;"+
		 newLine + "   java.util.ArrayList collectionOfDestination$z = new java.util.ArrayList(sourceLength$y);"+
		 newLine + "   for(int index$y = 0;index$y<sourceLength$y;index$y++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$y = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$y[index$y];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$y = null;" +
   	     newLine + "   if(super.getDestinationFactory()!=null){" +
   	     newLine + "   objectOfDestination$y = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
	     newLine + "   }else{" +
   	     newLine + "   objectOfDestination$y = new com.googlecode.jmapper.bean.TargetObject();" +
	     newLine + "   }" + 
		 newLine + "   objectOfDestination$y.setField(objectOfSoure$y.getField());"+
		 newLine + 
		 newLine + "   collectionOfDestination$z.add(objectOfDestination$y);"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetList(collectionOfDestination$z);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setATargetList(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void allValued() {
		
		expected = "   if(source.getAMappedSet()!=null){"+
		 newLine + "   Object[] collectionOfSource$i = source.getAMappedSet().toArray();"+
		 newLine + "   int sourceLength$i = collectionOfSource$i.length;"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList(sourceLength$i);"+
		 newLine + "   for(int index$i = 0;index$i<sourceLength$i;index$i++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = null;" +
   	     newLine + "   if(super.getDestinationFactory()!=null){" +
   	     newLine + "   objectOfDestination$i = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
	     newLine + "   }else{" +
   	     newLine + "   objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();" +
	     newLine + "   }" + 
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
		 newLine + "   Object[] collectionOfSource$i = source.getAMappedSet().toArray();"+
		 newLine + "   int sourceLength$i = collectionOfSource$i.length;"+
		 newLine + "   java.util.ArrayList collectionOfDestination$z = new java.util.ArrayList(sourceLength$i);"+
		 newLine + "   for(int index$i = 0;index$i<sourceLength$i;index$i++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = null;" +
   	     newLine + "   if(super.getDestinationFactory()!=null){" +
   	     newLine + "   objectOfDestination$i = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
	     newLine + "   }else{" +
   	     newLine + "   objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();" +
	     newLine + "   }" + 
		 newLine + "   if(objectOfSoure$i.getField()!=null){"+
		 newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   collectionOfDestination$z.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getATargetList().addAll(collectionOfDestination$z);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   Object[] collectionOfSource$y = source.getAMappedSet().toArray();"+
		 newLine + "   int sourceLength$y = collectionOfSource$y.length;"+
		 newLine + "   java.util.ArrayList collectionOfDestination$z = new java.util.ArrayList(sourceLength$y);"+
		 newLine + "   for(int index$y = 0;index$y<sourceLength$y;index$y++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$y = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$y[index$y];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$y = null;" +
   	     newLine + "   if(super.getDestinationFactory()!=null){" +
   	     newLine + "   objectOfDestination$y = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
	     newLine + "   }else{" +
   	     newLine + "   objectOfDestination$y = new com.googlecode.jmapper.bean.TargetObject();" +
	     newLine + "   }" + 
		 newLine + "   if(objectOfSoure$y.getField()!=null){"+
		 newLine + "   objectOfDestination$y.setField(objectOfSoure$y.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   collectionOfDestination$z.add(objectOfDestination$y);"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetList(collectionOfDestination$z);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void valuedAll() {
		
		expected = "   if(destination.getATargetList()!=null){"+
		 newLine + "   if(source.getAMappedSet()!=null){"+
		 newLine + "   Object[] collectionOfSource$i = source.getAMappedSet().toArray();"+
		 newLine + "   int sourceLength$i = collectionOfSource$i.length;"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList(sourceLength$i);"+
		 newLine + "   for(int index$i = 0;index$i<sourceLength$i;index$i++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = null;" +
   	     newLine + "   if(super.getDestinationFactory()!=null){" +
   	     newLine + "   objectOfDestination$i = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
	     newLine + "   }else{" +
   	     newLine + "   objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();" +
	     newLine + "   }" + 
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
	protected void valuedValued() {

		expected = "   if(destination.getATargetList()!=null){"+
		 newLine + "   if(source.getAMappedSet()!=null){"+
		 newLine + "   Object[] collectionOfSource$i = source.getAMappedSet().toArray();"+
		 newLine + "   int sourceLength$i = collectionOfSource$i.length;"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList(sourceLength$i);"+
		 newLine + "   for(int index$i = 0;index$i<sourceLength$i;index$i++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = null;" +
   	     newLine + "   if(super.getDestinationFactory()!=null){" +
   	     newLine + "   objectOfDestination$i = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
	     newLine + "   }else{" +
   	     newLine + "   objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();" +
	     newLine + "   }" + 
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
	protected void valuedNull() {
		
		expected = "   if(destination.getATargetList()!=null){"+
	     newLine + "   if(source.getAMappedSet()==null){"+
	     newLine + "   destination.setATargetList(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}

	@Override
	protected void nullValued() {

		expected = "   if(destination.getATargetList()==null){"+
		 newLine + "   if(source.getAMappedSet()!=null){"+
		 newLine + "   Object[] collectionOfSource$i = source.getAMappedSet().toArray();"+
		 newLine + "   int sourceLength$i = collectionOfSource$i.length;"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList(sourceLength$i);"+
		 newLine + "   for(int index$i = 0;index$i<sourceLength$i;index$i++){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure$i = (com.googlecode.jmapper.bean.MappedObject) collectionOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination$i = null;" +
   	     newLine + "   if(super.getDestinationFactory()!=null){" +
   	     newLine + "   objectOfDestination$i = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
	     newLine + "   }else{" +
   	     newLine + "   objectOfDestination$i = new com.googlecode.jmapper.bean.TargetObject();" +
	     newLine + "   }" + 
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