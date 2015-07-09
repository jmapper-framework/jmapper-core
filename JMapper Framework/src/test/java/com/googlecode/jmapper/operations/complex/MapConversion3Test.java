package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import java.lang.reflect.Field;
import java.util.TreeMap;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.enums.OperationType;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoMapOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class MapConversion3Test extends AOperation<MapOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aDConversionMap2");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aSConversionMap2");
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
									 .setValueConversionType (ConversionType.ABSENT)
									 .setConversionType		 (ConversionType.DEFINED);
	}
	
	@Override
	protected void setUp() {
		super.setUp();
		operation.setDestinationClass(TreeMap.class);
	}
	

	@Override
	protected void AllAll() {
		
		expected = "   if(source.getASConversionMap2()!=null){"+
		 newLine + "   java.util.TreeMap mapOfDestination$i = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASConversionMap2().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer sourceKeyObj$i = (java.lang.Integer) entryItem$i.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$i = (java.lang.String) entryItem$i.getValue();"+
		 newLine + "   java.lang.String destinationKeyObj$i = sourceKeyObj$i.toString();"+
		 newLine + "   mapOfDestination$i.put(destinationKeyObj$i, sourceValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setADConversionMap2(mapOfDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setADConversionMap2(null);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(destination.getADConversionMap2()!=null){"+
		 newLine + "   if(source.getASConversionMap2()!=null){"+
		 newLine + "   java.util.TreeMap mapOfDestination$z = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASConversionMap2().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer sourceKeyObj$i = (java.lang.Integer) entryItem$i.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$i = (java.lang.String) entryItem$i.getValue();"+
		 newLine + "   java.lang.String destinationKeyObj$i = sourceKeyObj$i.toString();"+
		 newLine + "   mapOfDestination$z.put(destinationKeyObj$i, sourceValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getADConversionMap2().putAll(mapOfDestination$z);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setADConversionMap2(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getASConversionMap2()!=null){"+
		 newLine + "   java.util.TreeMap mapOfDestination$z = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource$y = source.getASConversionMap2().entrySet().toArray();"+
		 newLine + "   for(int index$y = mapOfSource$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   java.util.Map.Entry entryItem$y = (java.util.Map.Entry) mapOfSource$y[index$y];"+
		 newLine + "   java.lang.Integer sourceKeyObj$y = (java.lang.Integer) entryItem$y.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$y = (java.lang.String) entryItem$y.getValue();"+
		 newLine + "   java.lang.String destinationKeyObj$y = sourceKeyObj$y.toString();"+
		 newLine + "   mapOfDestination$z.put(destinationKeyObj$y, sourceValueObj$y);"+
		 newLine + "   }"+
		 newLine + "   destination.setADConversionMap2(mapOfDestination$z);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setADConversionMap2(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void AllValued() {
		
		expected = "   if(source.getASConversionMap2()!=null){"+
		 newLine + "   java.util.TreeMap mapOfDestination$i = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASConversionMap2().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer sourceKeyObj$i = (java.lang.Integer) entryItem$i.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$i = (java.lang.String) entryItem$i.getValue();"+
		 newLine + "   java.lang.String destinationKeyObj$i = sourceKeyObj$i.toString();"+
		 newLine + "   mapOfDestination$i.put(destinationKeyObj$i, sourceValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setADConversionMap2(mapOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getASConversionMap2()!=null){"+
		 newLine + "   if(destination.getADConversionMap2()!=null){"+
		 newLine + "   java.util.TreeMap mapOfDestination$z = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASConversionMap2().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer sourceKeyObj$i = (java.lang.Integer) entryItem$i.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$i = (java.lang.String) entryItem$i.getValue();"+
		 newLine + "   java.lang.String destinationKeyObj$i = sourceKeyObj$i.toString();"+
		 newLine + "   mapOfDestination$z.put(destinationKeyObj$i, sourceValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getADConversionMap2().putAll(mapOfDestination$z);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   java.util.TreeMap mapOfDestination$z = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource$y = source.getASConversionMap2().entrySet().toArray();"+
		 newLine + "   for(int index$y = mapOfSource$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   java.util.Map.Entry entryItem$y = (java.util.Map.Entry) mapOfSource$y[index$y];"+
		 newLine + "   java.lang.Integer sourceKeyObj$y = (java.lang.Integer) entryItem$y.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$y = (java.lang.String) entryItem$y.getValue();"+
		 newLine + "   java.lang.String destinationKeyObj$y = sourceKeyObj$y.toString();"+
		 newLine + "   mapOfDestination$z.put(destinationKeyObj$y, sourceValueObj$y);"+
		 newLine + "   }"+
		 newLine + "   destination.setADConversionMap2(mapOfDestination$z);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void ValuedAll() {
		
		expected = "   if(destination.getADConversionMap2()!=null){"+
		 newLine + "   if(source.getASConversionMap2()!=null){"+
		 newLine + "   java.util.TreeMap mapOfDestination$i = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASConversionMap2().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer sourceKeyObj$i = (java.lang.Integer) entryItem$i.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$i = (java.lang.String) entryItem$i.getValue();"+
		 newLine + "   java.lang.String destinationKeyObj$i = sourceKeyObj$i.toString();"+
		 newLine + "   mapOfDestination$i.put(destinationKeyObj$i, sourceValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getADConversionMap2().putAll(mapOfDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setADConversionMap2(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedValued() {
		
		expected = "   if(destination.getADConversionMap2()!=null){"+
		 newLine + "   if(source.getASConversionMap2()!=null){"+
		 newLine + "   java.util.TreeMap mapOfDestination$i = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASConversionMap2().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer sourceKeyObj$i = (java.lang.Integer) entryItem$i.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$i = (java.lang.String) entryItem$i.getValue();"+
		 newLine + "   java.lang.String destinationKeyObj$i = sourceKeyObj$i.toString();"+
		 newLine + "   mapOfDestination$i.put(destinationKeyObj$i, sourceValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getADConversionMap2().putAll(mapOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getADConversionMap2()!=null){"+
	     newLine + "   if(source.getASConversionMap2()==null){"+
	     newLine + "   destination.setADConversionMap2(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}

	@Override
	protected void NullValued() {

		expected = "   if(destination.getADConversionMap2()==null){"+
		 newLine + "   if(source.getASConversionMap2()!=null){"+
		 newLine + "   java.util.TreeMap mapOfDestination$i = new java.util.TreeMap();"+
		 newLine + "   Object[] mapOfSource$i = source.getASConversionMap2().entrySet().toArray();"+
		 newLine + "   for(int index$i = mapOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.util.Map.Entry entryItem$i = (java.util.Map.Entry) mapOfSource$i[index$i];"+
		 newLine + "   java.lang.Integer sourceKeyObj$i = (java.lang.Integer) entryItem$i.getKey();"+
		 newLine + "   java.lang.String sourceValueObj$i = (java.lang.String) entryItem$i.getValue();"+
		 newLine + "   java.lang.String destinationKeyObj$i = sourceKeyObj$i.toString();"+
		 newLine + "   mapOfDestination$i.put(destinationKeyObj$i, sourceValueObj$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setADConversionMap2(mapOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}		
}