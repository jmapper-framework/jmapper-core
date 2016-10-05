package com.googlecode.jmapper.operations.recursive;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import java.lang.reflect.Field;
import java.util.HashMap;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.enums.OperationType;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoMapOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class MappedMapOperationTest extends AOperation<MappedMapOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aDMappedMap");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aSMappedMap");
	}

	@Override
	protected MappedMapOperation getOperationIstance() {
		return new MappedMapOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoMapOperation().setKeyInstructionType  (OperationType.OBJECT)
									 .setValueInstructionType(OperationType.OBJECT);
	}
	
	@Override
	protected void setUp() {
		super.setUp();
		operation.setDestinationClass(HashMap.class);
	}
	

	@Override
	protected void AllAll() {
		
		expected = "   if(source.getASMappedMap()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination$i = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$i = (com.googlecode.jmapper.bean.TargetObject) entryItem$i.getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj$i = (com.googlecode.jmapper.bean.MappedObject) entryItem$i.getValue();"+
newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$i = null;" +
newLine + "   if(super.getDestinationFactory()!=null){" +
newLine + "   destinationKeyObj$i = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
newLine + "   }else{" +
newLine + "   destinationKeyObj$i = new com.googlecode.jmapper.bean.MappedObject();" +
newLine + "   }" + 
		 newLine + "   destinationKeyObj$i.setField(sourceKeyObj$i.getField());"+
		 newLine + 
newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj$i = null;" +
newLine + "   if(super.getDestinationFactory()!=null){" +
newLine + "   destinationValueObj$i = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
newLine + "   }else{" +
newLine + "   destinationValueObj$i = new com.googlecode.jmapper.bean.TargetObject();" +
newLine + "   }" + 
		 newLine + "   destinationValueObj$i.setField(sourceValueObj$i.getField());"+
		 newLine + 
		 newLine + "   mapOfDestination$i.put(destinationKeyObj$i, destinationValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setADMappedMap(mapOfDestination$i);"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setADMappedMap(null);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(destination.getADMappedMap()!=null){"+
		 newLine + "   if(source.getASMappedMap()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination$z = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$i = (com.googlecode.jmapper.bean.TargetObject) entryItem$i.getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj$i = (com.googlecode.jmapper.bean.MappedObject) entryItem$i.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$i = null;" +
		 newLine + "   if(super.getDestinationFactory()!=null){" +
		 newLine + "   destinationKeyObj$i = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
		 newLine + "   }else{" +
		 newLine + "   destinationKeyObj$i = new com.googlecode.jmapper.bean.MappedObject();" +
		 newLine + "   }" + 
newLine + "   destinationKeyObj$i.setField(sourceKeyObj$i.getField());"+
		 newLine + 
newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj$i = null;" +
newLine + "   if(super.getDestinationFactory()!=null){" +
newLine + "   destinationValueObj$i = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
newLine + "   }else{" +
newLine + "   destinationValueObj$i = new com.googlecode.jmapper.bean.TargetObject();" +
newLine + "   }" + 
newLine + "   destinationValueObj$i.setField(sourceValueObj$i.getField());"+
		 newLine + 
		 newLine + "   mapOfDestination$z.put(destinationKeyObj$i, destinationValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getADMappedMap().putAll(mapOfDestination$z);"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setADMappedMap(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getASMappedMap()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination$z = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$y = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index$y = mapOfSource$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   java.util.Map.Entry entryItem$y = (java.util.Map.Entry) mapOfSource$y[index$y];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$y = (com.googlecode.jmapper.bean.TargetObject) entryItem$y.getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj$y = (com.googlecode.jmapper.bean.MappedObject) entryItem$y.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$y = null;" +
		 newLine + "   if(super.getDestinationFactory()!=null){" +
		 newLine + "   destinationKeyObj$y = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
		 newLine + "   }else{" +
		 newLine + "   destinationKeyObj$y = new com.googlecode.jmapper.bean.MappedObject();" +
		 newLine + "   }" + 
newLine + "   destinationKeyObj$y.setField(sourceKeyObj$y.getField());"+
		 newLine + 
newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj$y = null;" +
newLine + "   if(super.getDestinationFactory()!=null){" +
newLine + "   destinationValueObj$y = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
newLine + "   }else{" +
newLine + "   destinationValueObj$y = new com.googlecode.jmapper.bean.TargetObject();" +
newLine + "   }" + 
newLine + "   destinationValueObj$y.setField(sourceValueObj$y.getField());"+
		 newLine + 
		 newLine + "   mapOfDestination$z.put(destinationKeyObj$y, destinationValueObj$y);"+
		 newLine + "   }"+
		 newLine + "   destination.setADMappedMap(mapOfDestination$z);"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setADMappedMap(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void AllValued() {
		
		expected = "   if(source.getASMappedMap()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination$i = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$i = (com.googlecode.jmapper.bean.TargetObject) entryItem$i.getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj$i = (com.googlecode.jmapper.bean.MappedObject) entryItem$i.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$i = null;" +
		 newLine + "   if(super.getDestinationFactory()!=null){" +
		 newLine + "   destinationKeyObj$i = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
		 newLine + "   }else{" +
		 newLine + "   destinationKeyObj$i = new com.googlecode.jmapper.bean.MappedObject();" +
		 newLine + "   }" + 

		 newLine + "   if(sourceKeyObj$i.getField()!=null){"+
		 newLine + "   destinationKeyObj$i.setField(sourceKeyObj$i.getField());"+
		 newLine + "   }"+
		 newLine + 
newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj$i = null;" +
newLine + "   if(super.getDestinationFactory()!=null){" +
newLine + "   destinationValueObj$i = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
newLine + "   }else{" +
newLine + "   destinationValueObj$i = new com.googlecode.jmapper.bean.TargetObject();" +
newLine + "   }" + 
newLine + "   if(sourceValueObj$i.getField()!=null){"+ 
		 newLine + "   destinationValueObj$i.setField(sourceValueObj$i.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   mapOfDestination$i.put(destinationKeyObj$i, destinationValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setADMappedMap(mapOfDestination$i);"+
		 newLine +
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getASMappedMap()!=null){"+
		 newLine + "   if(destination.getADMappedMap()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination$z = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$i = (com.googlecode.jmapper.bean.TargetObject) entryItem$i.getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj$i = (com.googlecode.jmapper.bean.MappedObject) entryItem$i.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$i = null;" +
		 newLine + "   if(super.getDestinationFactory()!=null){" +
		 newLine + "   destinationKeyObj$i = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
		 newLine + "   }else{" +
		 newLine + "   destinationKeyObj$i = new com.googlecode.jmapper.bean.MappedObject();" +
		 newLine + "   }" + 
		 newLine + "   if(sourceKeyObj$i.getField()!=null){"+
		 newLine + "   destinationKeyObj$i.setField(sourceKeyObj$i.getField());"+
		 newLine + "   }"+ 
		 newLine + 
	newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj$i = null;" +
newLine + "   if(super.getDestinationFactory()!=null){" +
newLine + "   destinationValueObj$i = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
newLine + "   }else{" +
newLine + "   destinationValueObj$i = new com.googlecode.jmapper.bean.TargetObject();" +
newLine + "   }" + 
newLine + "   if(sourceValueObj$i.getField()!=null){"+
		 newLine + "   destinationValueObj$i.setField(sourceValueObj$i.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   mapOfDestination$z.put(destinationKeyObj$i, destinationValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getADMappedMap().putAll(mapOfDestination$z);"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   java.util.HashMap mapOfDestination$z = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$y = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index$y = mapOfSource$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   java.util.Map.Entry entryItem$y = (java.util.Map.Entry) mapOfSource$y[index$y];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$y = (com.googlecode.jmapper.bean.TargetObject) entryItem$y.getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj$y = (com.googlecode.jmapper.bean.MappedObject) entryItem$y.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$y = null;" +
		 newLine + "   if(super.getDestinationFactory()!=null){" +
		 newLine + "   destinationKeyObj$y = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
		 newLine + "   }else{" +
		 newLine + "   destinationKeyObj$y = new com.googlecode.jmapper.bean.MappedObject();" +
		 newLine + "   }" + 
newLine + "   if(sourceKeyObj$y.getField()!=null){"+
		 newLine + "   destinationKeyObj$y.setField(sourceKeyObj$y.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj$y = null;" +
newLine + "   if(super.getDestinationFactory()!=null){" +
newLine + "   destinationValueObj$y = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
newLine + "   }else{" +
newLine + "   destinationValueObj$y = new com.googlecode.jmapper.bean.TargetObject();" +
newLine + "   }" + 
newLine + "   if(sourceValueObj$y.getField()!=null){"+
		 newLine + "   destinationValueObj$y.setField(sourceValueObj$y.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   mapOfDestination$z.put(destinationKeyObj$y, destinationValueObj$y);"+
		 newLine + "   }"+
		 newLine + "   destination.setADMappedMap(mapOfDestination$z);"+
		 newLine +
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void ValuedAll() {
		
		expected = "   if(destination.getADMappedMap()!=null){"+
		 newLine + "   if(source.getASMappedMap()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination$i = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$i = (com.googlecode.jmapper.bean.TargetObject) entryItem$i.getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj$i = (com.googlecode.jmapper.bean.MappedObject) entryItem$i.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$i = null;" +
		 newLine + "   if(super.getDestinationFactory()!=null){" +
		 newLine + "   destinationKeyObj$i = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
		 newLine + "   }else{" +
		 newLine + "   destinationKeyObj$i = new com.googlecode.jmapper.bean.MappedObject();" +
		 newLine + "   }" + 
		 newLine + "   destinationKeyObj$i.setField(sourceKeyObj$i.getField());"+
		 newLine + 
newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj$i = null;" +
newLine + "   if(super.getDestinationFactory()!=null){" +
newLine + "   destinationValueObj$i = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
newLine + "   }else{" +
newLine + "   destinationValueObj$i = new com.googlecode.jmapper.bean.TargetObject();" +
newLine + "   }" + 
newLine + "   destinationValueObj$i.setField(sourceValueObj$i.getField());"+
		 newLine + 
		 newLine + "   mapOfDestination$i.put(destinationKeyObj$i, destinationValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getADMappedMap().putAll(mapOfDestination$i);"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setADMappedMap(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedValued() {

		expected = "   if(destination.getADMappedMap()!=null){"+
		 newLine + "   if(source.getASMappedMap()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination$i = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$i = (com.googlecode.jmapper.bean.TargetObject) entryItem$i.getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj$i = (com.googlecode.jmapper.bean.MappedObject) entryItem$i.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$i = null;" +
		 newLine + "   if(super.getDestinationFactory()!=null){" +
		 newLine + "   destinationKeyObj$i = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
		 newLine + "   }else{" +
		 newLine + "   destinationKeyObj$i = new com.googlecode.jmapper.bean.MappedObject();" +
		 newLine + "   }" + 
newLine + "   if(sourceKeyObj$i.getField()!=null){"+
		 newLine + "   destinationKeyObj$i.setField(sourceKeyObj$i.getField());"+
		 newLine + "   }"+ 
		 newLine + 
newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj$i = null;" +
newLine + "   if(super.getDestinationFactory()!=null){" +
newLine + "   destinationValueObj$i = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
newLine + "   }else{" +
newLine + "   destinationValueObj$i = new com.googlecode.jmapper.bean.TargetObject();" +
newLine + "   }" + 
newLine + "   if(sourceValueObj$i.getField()!=null){"+
		 newLine + "   destinationValueObj$i.setField(sourceValueObj$i.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   mapOfDestination$i.put(destinationKeyObj$i, destinationValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getADMappedMap().putAll(mapOfDestination$i);"+
		 newLine +
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getADMappedMap()!=null){"+
	     newLine + "   if(source.getASMappedMap()==null){"+
	     newLine + "   destination.setADMappedMap(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}

	@Override
	protected void NullValued() {

		expected = "   if(destination.getADMappedMap()==null){"+
		 newLine + "   if(source.getASMappedMap()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination$i = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$i = (com.googlecode.jmapper.bean.TargetObject) entryItem$i.getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj$i = (com.googlecode.jmapper.bean.MappedObject) entryItem$i.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$i = null;" +
		 newLine + "   if(super.getDestinationFactory()!=null){" +
		 newLine + "   destinationKeyObj$i = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
		 newLine + "   }else{" +
		 newLine + "   destinationKeyObj$i = new com.googlecode.jmapper.bean.MappedObject();" +
		 newLine + "   }" + 
newLine + "   if(sourceKeyObj$i.getField()!=null){"+
		 newLine + "   destinationKeyObj$i.setField(sourceKeyObj$i.getField());"+
		 newLine + "   }"+ 
		 newLine + 
newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj$i = null;" +
newLine + "   if(super.getDestinationFactory()!=null){" +
newLine + "   destinationValueObj$i = (com.googlecode.jmapper.bean.TargetObject) super.getDestinationFactory().make();" +
newLine + "   }else{" +
newLine + "   destinationValueObj$i = new com.googlecode.jmapper.bean.TargetObject();" +
newLine + "   }" + 
newLine + "   if(sourceValueObj$i.getField()!=null){"+
		 newLine + "   destinationValueObj$i.setField(sourceValueObj$i.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   mapOfDestination$i.put(destinationKeyObj$i, destinationValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setADMappedMap(mapOfDestination$i);"+
		 newLine +
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}		
}