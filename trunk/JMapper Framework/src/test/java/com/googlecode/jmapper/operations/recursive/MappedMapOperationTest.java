package com.googlecode.jmapper.operations.recursive;

import static com.googlecode.jmapper.util.ClassesManager.getFieldValue;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.operations.AOperation;
import java.lang.reflect.Field;
import java.util.HashMap;

import com.googlecode.jmapper.enums.OperationType;
import com.googlecode.jmapper.operations.info.InfoMapOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.operations.recursive.MappedMapOperation;

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
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getASMappedMap()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination"+i+" = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj"+i+" = (com.googlecode.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj"+i+" = (com.googlecode.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj"+i+" = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + 
		 newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   destinationValueObj"+i+".setField(sourceValueObj"+i+".getField());"+
		 newLine + 
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setADMappedMap(mapOfDestination"+i+");"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setADMappedMap(null);"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getADMappedMap()!=null){"+
		 newLine + "   if(source.getASMappedMap()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination"+i+" = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj"+i+" = (com.googlecode.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj"+i+" = (com.googlecode.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj"+i+" = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + 
		 newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   destinationValueObj"+i+".setField(sourceValueObj"+i+".getField());"+
		 newLine + 
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.getADMappedMap().putAll(mapOfDestination"+i+++");"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setADMappedMap(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getASMappedMap()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination"+i+" = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj"+i+" = (com.googlecode.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj"+i+" = (com.googlecode.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj"+i+" = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + 
		 newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   destinationValueObj"+i+".setField(sourceValueObj"+i+".getField());"+
		 newLine + 
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setADMappedMap(mapOfDestination"+i+");"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setADMappedMap(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void AllValued() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getASMappedMap()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination"+i+" = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj"+i+" = (com.googlecode.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj"+i+" = (com.googlecode.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj"+i+" = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   if(sourceKeyObj"+i+".getField()!=null){"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(sourceValueObj"+i+".getField()!=null){"+ 
		 newLine + "   destinationValueObj"+i+".setField(sourceValueObj"+i+".getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setADMappedMap(mapOfDestination"+i+");"+
		 newLine +
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getASMappedMap()!=null){"+
		 newLine + "   if(destination.getADMappedMap()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination"+i+" = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj"+i+" = (com.googlecode.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj"+i+" = (com.googlecode.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj"+i+" = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   if(sourceKeyObj"+i+".getField()!=null){"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + "   }"+ 
		 newLine + 
		 newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(sourceValueObj"+i+".getField()!=null){"+
		 newLine + "   destinationValueObj"+i+".setField(sourceValueObj"+i+".getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.getADMappedMap().putAll(mapOfDestination"+i+++");"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   java.util.HashMap mapOfDestination"+i+" = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj"+i+" = (com.googlecode.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj"+i+" = (com.googlecode.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj"+i+" = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   if(sourceKeyObj"+i+".getField()!=null){"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(sourceValueObj"+i+".getField()!=null){"+
		 newLine + "   destinationValueObj"+i+".setField(sourceValueObj"+i+".getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setADMappedMap(mapOfDestination"+i+");"+
		 newLine +
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void ValuedAll() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getADMappedMap()!=null){"+
		 newLine + "   if(source.getASMappedMap()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination"+i+" = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj"+i+" = (com.googlecode.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj"+i+" = (com.googlecode.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj"+i+" = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + 
		 newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   destinationValueObj"+i+".setField(sourceValueObj"+i+".getField());"+
		 newLine + 
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.getADMappedMap().putAll(mapOfDestination"+i+++");"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setADMappedMap(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getADMappedMap()!=null){"+
		 newLine + "   if(source.getASMappedMap()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination"+i+" = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj"+i+" = (com.googlecode.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj"+i+" = (com.googlecode.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj"+i+" = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   if(sourceKeyObj"+i+".getField()!=null){"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + "   }"+ 
		 newLine + 
		 newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(sourceValueObj"+i+".getField()!=null){"+
		 newLine + "   destinationValueObj"+i+".setField(sourceValueObj"+i+".getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.getADMappedMap().putAll(mapOfDestination"+i+++");"+
		 newLine +
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getADMappedMap()!=null){"+
	     newLine + "   if(source.getASMappedMap()==null){"+
	     newLine + "   destination.setADMappedMap(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}

	@Override
	protected void NullValued() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getADMappedMap()==null){"+
		 newLine + "   if(source.getASMappedMap()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination"+i+" = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASMappedMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj"+i+" = (com.googlecode.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject sourceValueObj"+i+" = (com.googlecode.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj"+i+" = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   if(sourceKeyObj"+i+".getField()!=null){"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + "   }"+ 
		 newLine + 
		 newLine + "   com.googlecode.jmapper.bean.TargetObject destinationValueObj"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(sourceValueObj"+i+".getField()!=null){"+
		 newLine + "   destinationValueObj"+i+".setField(sourceValueObj"+i+".getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setADMappedMap(mapOfDestination"+i+++");"+
		 newLine +
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}		
}