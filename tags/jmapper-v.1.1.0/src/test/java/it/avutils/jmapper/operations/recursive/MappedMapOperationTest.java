package it.avutils.jmapper.operations.recursive;

import static it.avutils.jmapper.util.ClassesManager.getFieldValue;
import static it.avutils.jmapper.util.GeneralUtility.newLine;
import it.avutils.jmapper.bean.ComplexClass;
import it.avutils.jmapper.enums.OperationType;
import it.avutils.jmapper.operations.AOperation;
import it.avutils.jmapper.operations.info.InfoMapOperation;
import it.avutils.jmapper.operations.info.InfoOperation;
import java.lang.reflect.Field;
import java.util.HashMap;

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
		 newLine + "   it.avutils.jmapper.bean.TargetObject sourceKeyObj"+i+" = (it.avutils.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject sourceValueObj"+i+" = (it.avutils.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject destinationKeyObj"+i+" = new it.avutils.jmapper.bean.MappedObject();"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + 
		 newLine + "   it.avutils.jmapper.bean.TargetObject destinationValueObj"+i+" = new it.avutils.jmapper.bean.TargetObject();"+
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
		 newLine + "   it.avutils.jmapper.bean.TargetObject sourceKeyObj"+i+" = (it.avutils.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject sourceValueObj"+i+" = (it.avutils.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject destinationKeyObj"+i+" = new it.avutils.jmapper.bean.MappedObject();"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + 
		 newLine + "   it.avutils.jmapper.bean.TargetObject destinationValueObj"+i+" = new it.avutils.jmapper.bean.TargetObject();"+
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
		 newLine + "   it.avutils.jmapper.bean.TargetObject sourceKeyObj"+i+" = (it.avutils.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject sourceValueObj"+i+" = (it.avutils.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject destinationKeyObj"+i+" = new it.avutils.jmapper.bean.MappedObject();"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + 
		 newLine + "   it.avutils.jmapper.bean.TargetObject destinationValueObj"+i+" = new it.avutils.jmapper.bean.TargetObject();"+
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
		 newLine + "   it.avutils.jmapper.bean.TargetObject sourceKeyObj"+i+" = (it.avutils.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject sourceValueObj"+i+" = (it.avutils.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject destinationKeyObj"+i+" = new it.avutils.jmapper.bean.MappedObject();"+
		 newLine + "   if(sourceKeyObj"+i+".getField()!=null){"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   it.avutils.jmapper.bean.TargetObject destinationValueObj"+i+" = new it.avutils.jmapper.bean.TargetObject();"+
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
		 newLine + "   it.avutils.jmapper.bean.TargetObject sourceKeyObj"+i+" = (it.avutils.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject sourceValueObj"+i+" = (it.avutils.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject destinationKeyObj"+i+" = new it.avutils.jmapper.bean.MappedObject();"+
		 newLine + "   if(sourceKeyObj"+i+".getField()!=null){"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + "   }"+ 
		 newLine + 
		 newLine + "   it.avutils.jmapper.bean.TargetObject destinationValueObj"+i+" = new it.avutils.jmapper.bean.TargetObject();"+
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
		 newLine + "   it.avutils.jmapper.bean.TargetObject sourceKeyObj"+i+" = (it.avutils.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject sourceValueObj"+i+" = (it.avutils.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject destinationKeyObj"+i+" = new it.avutils.jmapper.bean.MappedObject();"+
		 newLine + "   if(sourceKeyObj"+i+".getField()!=null){"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   it.avutils.jmapper.bean.TargetObject destinationValueObj"+i+" = new it.avutils.jmapper.bean.TargetObject();"+
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
		 newLine + "   it.avutils.jmapper.bean.TargetObject sourceKeyObj"+i+" = (it.avutils.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject sourceValueObj"+i+" = (it.avutils.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject destinationKeyObj"+i+" = new it.avutils.jmapper.bean.MappedObject();"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + 
		 newLine + "   it.avutils.jmapper.bean.TargetObject destinationValueObj"+i+" = new it.avutils.jmapper.bean.TargetObject();"+
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
		 newLine + "   it.avutils.jmapper.bean.TargetObject sourceKeyObj"+i+" = (it.avutils.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject sourceValueObj"+i+" = (it.avutils.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject destinationKeyObj"+i+" = new it.avutils.jmapper.bean.MappedObject();"+
		 newLine + "   if(sourceKeyObj"+i+".getField()!=null){"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + "   }"+ 
		 newLine + 
		 newLine + "   it.avutils.jmapper.bean.TargetObject destinationValueObj"+i+" = new it.avutils.jmapper.bean.TargetObject();"+
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
		 newLine + "   it.avutils.jmapper.bean.TargetObject sourceKeyObj"+i+" = (it.avutils.jmapper.bean.TargetObject) entryItem"+i+".getKey();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject sourceValueObj"+i+" = (it.avutils.jmapper.bean.MappedObject) entryItem"+i+".getValue();"+
		 newLine + "   it.avutils.jmapper.bean.MappedObject destinationKeyObj"+i+" = new it.avutils.jmapper.bean.MappedObject();"+
		 newLine + "   if(sourceKeyObj"+i+".getField()!=null){"+
		 newLine + "   destinationKeyObj"+i+".setField(sourceKeyObj"+i+".getField());"+
		 newLine + "   }"+ 
		 newLine + 
		 newLine + "   it.avutils.jmapper.bean.TargetObject destinationValueObj"+i+" = new it.avutils.jmapper.bean.TargetObject();"+
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