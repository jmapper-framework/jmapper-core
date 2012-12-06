package it.avutils.jmapper.operations.complex;

import static it.avutils.jmapper.util.ClassesManager.getFieldValue;
import static it.avutils.jmapper.util.GeneralUtility.newLine;
import it.avutils.jmapper.bean.ComplexClass;
import it.avutils.jmapper.enums.ConversionType;
import it.avutils.jmapper.enums.OperationType;
import it.avutils.jmapper.operations.AOperation;
import it.avutils.jmapper.operations.info.InfoMapOperation;
import it.avutils.jmapper.operations.info.InfoOperation;

import java.lang.reflect.Field;
import java.util.TreeMap;

public class MapConversion2Test extends AOperation<MapOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aDConversionMap");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aSConversionMap");
	}

	@Override
	protected MapOperation getOperationIstance() {
		return new MapOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoMapOperation().setKeyInstructionType  (OperationType.BASIC_INSTRUCTION)
									 .setValueInstructionType(OperationType.BASIC_INSTRUCTION)
									 .setKeyConversionType   (ConversionType.FromIntegerToString)
									 .setValueConversionType (ConversionType.FromStringToInteger)
									 .setConversionType		 (ConversionType.DEFINED);
	}
	
	@Override
	protected void setUp() {
		super.setUp();
		operation.setDestinationClass(TreeMap.class);
	}
	

	@Override
	protected void AllAll() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getASConversionMap()!=null){"+
		 newLine + "   java.util.TreeMap mapOfDestination"+i+" = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASConversionMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer sourceKeyObj"+i+" = (java.lang.Integer) entryItem"+i+".getKey();"+
		 newLine + "   java.lang.String sourceValueObj"+i+" = (java.lang.String) entryItem"+i+".getValue();"+
		 newLine + "   java.lang.String destinationKeyObj"+i+" = sourceKeyObj"+i+".toString();"+
		 newLine + "   java.lang.Integer destinationValueObj"+i+" = new Integer(sourceValueObj"+i+");"+
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setADConversionMap(mapOfDestination"+i+");"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setADConversionMap(null);"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getADConversionMap()!=null){"+
		 newLine + "   if(source.getASConversionMap()!=null){"+
		 newLine + "   java.util.TreeMap mapOfDestination"+i+" = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASConversionMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer sourceKeyObj"+i+" = (java.lang.Integer) entryItem"+i+".getKey();"+
		 newLine + "   java.lang.String sourceValueObj"+i+" = (java.lang.String) entryItem"+i+".getValue();"+
		 newLine + "   java.lang.String destinationKeyObj"+i+" = sourceKeyObj"+i+".toString();"+
		 newLine + "   java.lang.Integer destinationValueObj"+i+" = new Integer(sourceValueObj"+i+");"+
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.getADConversionMap().putAll(mapOfDestination"+i+++");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setADConversionMap(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getASConversionMap()!=null){"+
		 newLine + "   java.util.TreeMap mapOfDestination"+i+" = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASConversionMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer sourceKeyObj"+i+" = (java.lang.Integer) entryItem"+i+".getKey();"+
		 newLine + "   java.lang.String sourceValueObj"+i+" = (java.lang.String) entryItem"+i+".getValue();"+
		 newLine + "   java.lang.String destinationKeyObj"+i+" = sourceKeyObj"+i+".toString();"+
		 newLine + "   java.lang.Integer destinationValueObj"+i+" = new Integer(sourceValueObj"+i+");"+
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setADConversionMap(mapOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setADConversionMap(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void AllValued() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getASConversionMap()!=null){"+
		 newLine + "   java.util.TreeMap mapOfDestination"+i+" = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASConversionMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer sourceKeyObj"+i+" = (java.lang.Integer) entryItem"+i+".getKey();"+
		 newLine + "   java.lang.String sourceValueObj"+i+" = (java.lang.String) entryItem"+i+".getValue();"+
		 newLine + "   java.lang.String destinationKeyObj"+i+" = sourceKeyObj"+i+".toString();"+
		 newLine + "   java.lang.Integer destinationValueObj"+i+" = new Integer(sourceValueObj"+i+");"+
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setADConversionMap(mapOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getASConversionMap()!=null){"+
		 newLine + "   if(destination.getADConversionMap()!=null){"+
		 newLine + "   java.util.TreeMap mapOfDestination"+i+" = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASConversionMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer sourceKeyObj"+i+" = (java.lang.Integer) entryItem"+i+".getKey();"+
		 newLine + "   java.lang.String sourceValueObj"+i+" = (java.lang.String) entryItem"+i+".getValue();"+
		 newLine + "   java.lang.String destinationKeyObj"+i+" = sourceKeyObj"+i+".toString();"+
		 newLine + "   java.lang.Integer destinationValueObj"+i+" = new Integer(sourceValueObj"+i+");"+
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.getADConversionMap().putAll(mapOfDestination"+i+++");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   java.util.TreeMap mapOfDestination"+i+" = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASConversionMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer sourceKeyObj"+i+" = (java.lang.Integer) entryItem"+i+".getKey();"+
		 newLine + "   java.lang.String sourceValueObj"+i+" = (java.lang.String) entryItem"+i+".getValue();"+
		 newLine + "   java.lang.String destinationKeyObj"+i+" = sourceKeyObj"+i+".toString();"+
		 newLine + "   java.lang.Integer destinationValueObj"+i+" = new Integer(sourceValueObj"+i+");"+
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setADConversionMap(mapOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void ValuedAll() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getADConversionMap()!=null){"+
		 newLine + "   if(source.getASConversionMap()!=null){"+
		 newLine + "   java.util.TreeMap mapOfDestination"+i+" = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASConversionMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer sourceKeyObj"+i+" = (java.lang.Integer) entryItem"+i+".getKey();"+
		 newLine + "   java.lang.String sourceValueObj"+i+" = (java.lang.String) entryItem"+i+".getValue();"+
		 newLine + "   java.lang.String destinationKeyObj"+i+" = sourceKeyObj"+i+".toString();"+
		 newLine + "   java.lang.Integer destinationValueObj"+i+" = new Integer(sourceValueObj"+i+");"+
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.getADConversionMap().putAll(mapOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setADConversionMap(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getADConversionMap()!=null){"+
		 newLine + "   if(source.getASConversionMap()!=null){"+
		 newLine + "   java.util.TreeMap mapOfDestination"+i+" = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASConversionMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer sourceKeyObj"+i+" = (java.lang.Integer) entryItem"+i+".getKey();"+
		 newLine + "   java.lang.String sourceValueObj"+i+" = (java.lang.String) entryItem"+i+".getValue();"+
		 newLine + "   java.lang.String destinationKeyObj"+i+" = sourceKeyObj"+i+".toString();"+
		 newLine + "   java.lang.Integer destinationValueObj"+i+" = new Integer(sourceValueObj"+i+");"+
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.getADConversionMap().putAll(mapOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getADConversionMap()!=null){"+
	     newLine + "   if(source.getASConversionMap()==null){"+
	     newLine + "   destination.setADConversionMap(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}

	@Override
	protected void NullValued() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getADConversionMap()==null){"+
		 newLine + "   if(source.getASConversionMap()!=null){"+
		 newLine + "   java.util.TreeMap mapOfDestination"+i+" = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource"+i+" = source.getASConversionMap().entrySet().toArray();"+
		 newLine + "   for(int index"+i+" = mapOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.util.Map.Entry entryItem"+i+" = (java.util.Map.Entry) mapOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.Integer sourceKeyObj"+i+" = (java.lang.Integer) entryItem"+i+".getKey();"+
		 newLine + "   java.lang.String sourceValueObj"+i+" = (java.lang.String) entryItem"+i+".getValue();"+
		 newLine + "   java.lang.String destinationKeyObj"+i+" = sourceKeyObj"+i+".toString();"+
		 newLine + "   java.lang.Integer destinationValueObj"+i+" = new Integer(sourceValueObj"+i+");"+
		 newLine + "   mapOfDestination"+i+".put(destinationKeyObj"+i+", destinationValueObj"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setADConversionMap(mapOfDestination"+i+");"+
		 newLine +
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}		
}