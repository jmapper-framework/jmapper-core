package com.googlecode.jmapper.operations.recursive;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import java.lang.reflect.Field;
import java.util.HashMap;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.enums.OperationType;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoMapOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class MappedMapOperation2Test extends AOperation<MappedMapOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aDMappedMap2");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aSMappedMap2");
	}

	@Override
	protected MappedMapOperation getOperationIstance() {
		return new MappedMapOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoMapOperation().setKeyInstructionType  (OperationType.OBJECT)
				 					 .setValueInstructionType(OperationType.BASIC_INSTRUCTION)
				 					 .setValueConversionType(ConversionType.ABSENT);
	}
	
	@Override
	protected void setUp() {
		super.setUp();
		operation.setDestinationClass(HashMap.class);
	}
	

	@Override
	protected void AllAll() {
		
		expected = "   if(source.getASMappedMap2()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination$i = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASMappedMap2().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$i = (com.googlecode.jmapper.bean.TargetObject) entryItem$i.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$i = (java.lang.String) entryItem$i.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$i = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   destinationKeyObj$i.setField(sourceKeyObj$i.getField());"+
		 newLine + 
		 newLine + "   mapOfDestination$i.put(destinationKeyObj$i, sourceValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setADMappedMap2(mapOfDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setADMappedMap2(null);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(destination.getADMappedMap2()!=null){"+
		 newLine + "   if(source.getASMappedMap2()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination$z = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASMappedMap2().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$i = (com.googlecode.jmapper.bean.TargetObject) entryItem$i.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$i = (java.lang.String) entryItem$i.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$i = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   destinationKeyObj$i.setField(sourceKeyObj$i.getField());"+
		 newLine + 
		 newLine + "   mapOfDestination$z.put(destinationKeyObj$i, sourceValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getADMappedMap2().putAll(mapOfDestination$z);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setADMappedMap2(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getASMappedMap2()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination$z = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$y = source.getASMappedMap2().entrySet().toArray();"+
		 newLine + "   for(int index$y = mapOfSource$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   java.util.Map.Entry entryItem$y = (java.util.Map.Entry) mapOfSource$y[index$y];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$y = (com.googlecode.jmapper.bean.TargetObject) entryItem$y.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$y = (java.lang.String) entryItem$y.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$y = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   destinationKeyObj$y.setField(sourceKeyObj$y.getField());"+
		 newLine + 
		 newLine + "   mapOfDestination$z.put(destinationKeyObj$y, sourceValueObj$y);"+
		 newLine + "   }"+
		 newLine + "   destination.setADMappedMap2(mapOfDestination$z);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setADMappedMap2(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void AllValued() {
		
		expected = "   if(source.getASMappedMap2()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination$i = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASMappedMap2().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$i = (com.googlecode.jmapper.bean.TargetObject) entryItem$i.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$i = (java.lang.String) entryItem$i.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$i = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   if(sourceKeyObj$i.getField()!=null){"+
		 newLine + "   destinationKeyObj$i.setField(sourceKeyObj$i.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   mapOfDestination$i.put(destinationKeyObj$i, sourceValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setADMappedMap2(mapOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getASMappedMap2()!=null){"+
		 newLine + "   if(destination.getADMappedMap2()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination$z = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASMappedMap2().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$i = (com.googlecode.jmapper.bean.TargetObject) entryItem$i.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$i = (java.lang.String) entryItem$i.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$i = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   if(sourceKeyObj$i.getField()!=null){"+
		 newLine + "   destinationKeyObj$i.setField(sourceKeyObj$i.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   mapOfDestination$z.put(destinationKeyObj$i, sourceValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getADMappedMap2().putAll(mapOfDestination$z);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   java.util.HashMap mapOfDestination$z = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$y = source.getASMappedMap2().entrySet().toArray();"+
		 newLine + "   for(int index$y = mapOfSource$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   java.util.Map.Entry entryItem$y = (java.util.Map.Entry) mapOfSource$y[index$y];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$y = (com.googlecode.jmapper.bean.TargetObject) entryItem$y.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$y = (java.lang.String) entryItem$y.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$y = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   if(sourceKeyObj$y.getField()!=null){"+
		 newLine + "   destinationKeyObj$y.setField(sourceKeyObj$y.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   mapOfDestination$z.put(destinationKeyObj$y, sourceValueObj$y);"+
		 newLine + "   }"+
		 newLine + "   destination.setADMappedMap2(mapOfDestination$z);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void ValuedAll() {
		
		expected = "   if(destination.getADMappedMap2()!=null){"+
		 newLine + "   if(source.getASMappedMap2()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination$i = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASMappedMap2().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$i = (com.googlecode.jmapper.bean.TargetObject) entryItem$i.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$i = (java.lang.String) entryItem$i.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$i = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   destinationKeyObj$i.setField(sourceKeyObj$i.getField());"+
		 newLine + 
		 newLine + "   mapOfDestination$i.put(destinationKeyObj$i, sourceValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getADMappedMap2().putAll(mapOfDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setADMappedMap2(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedValued() {

		expected = "   if(destination.getADMappedMap2()!=null){"+
		 newLine + "   if(source.getASMappedMap2()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination$i = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASMappedMap2().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$i = (com.googlecode.jmapper.bean.TargetObject) entryItem$i.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$i = (java.lang.String) entryItem$i.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$i = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   if(sourceKeyObj$i.getField()!=null){"+
		 newLine + "   destinationKeyObj$i.setField(sourceKeyObj$i.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   mapOfDestination$i.put(destinationKeyObj$i, sourceValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getADMappedMap2().putAll(mapOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getADMappedMap2()!=null){"+
	     newLine + "   if(source.getASMappedMap2()==null){"+
	     newLine + "   destination.setADMappedMap2(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}

	@Override
	protected void NullValued() {

		expected = "   if(destination.getADMappedMap2()==null){"+
		 newLine + "   if(source.getASMappedMap2()!=null){"+
		 newLine + "   java.util.HashMap mapOfDestination$i = new java.util.HashMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASMappedMap2().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject sourceKeyObj$i = (com.googlecode.jmapper.bean.TargetObject) entryItem$i.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$i = (java.lang.String) entryItem$i.getValue();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject destinationKeyObj$i = new com.googlecode.jmapper.bean.MappedObject();"+
		 newLine + "   if(sourceKeyObj$i.getField()!=null){"+
		 newLine + "   destinationKeyObj$i.setField(sourceKeyObj$i.getField());"+
		 newLine + "   }"+
		 newLine + 
		 newLine + "   mapOfDestination$i.put(destinationKeyObj$i, sourceValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setADMappedMap2(mapOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}		
}