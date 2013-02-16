package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.ClassesManager.getFieldValue;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.operations.AOperation;

import java.lang.reflect.Field;
import java.util.TreeMap;

import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.complex.MapOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class MapConversionTest extends AOperation<MapOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aSortedMap");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aMap");
	}

	@Override
	protected MapOperation getOperationIstance() {
		return new MapOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.ABSENT);
	}
	
	@Override
	protected void setUp() {
		super.setUp();
		operation.setDestinationClass(TreeMap.class);
	}
	
	@Override
	protected void AllAll() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getAMap()!=null){"+
		 newLine + "   java.util.TreeMap complexMap"+i+" = new java.util.TreeMap();"+
		 newLine + "   complexMap"+i+".putAll(source.getAMap());"+
		 newLine + "   destination.setASortedMap(complexMap"+i+");"+
		 newLine + "   }else{"+
		 newLine + "   destination.setASortedMap(null);"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getASortedMap()!=null){"+
		 newLine + "   if(source.getAMap()!=null){"+
		 newLine + "   destination.getASortedMap().putAll(source.getAMap());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setASortedMap(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getAMap()!=null){"+
		 newLine + "   java.util.TreeMap complexMap"+ ++i+" = new java.util.TreeMap();"+
		 newLine + "   complexMap"+i+".putAll(source.getAMap());"+
		 newLine + "   destination.setASortedMap(complexMap"+i+");"+
		 newLine + "   }else{"+
		 newLine + "   destination.setASortedMap(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void AllValued() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getAMap()!=null){"+
		 newLine + "   java.util.TreeMap complexMap"+i+" = new java.util.TreeMap();"+
		 newLine + "   complexMap"+i+".putAll(source.getAMap());"+
		 newLine + "   destination.setASortedMap(complexMap"+i+");"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getAMap()!=null){"+
		 newLine + "   if(destination.getASortedMap()!=null){"+
		 newLine + "   destination.getASortedMap().putAll(source.getAMap());"+
		 newLine + "   }else{"+
		 newLine + "   java.util.TreeMap complexMap"+ ++i+" = new java.util.TreeMap();"+
		 newLine + "   complexMap"+i+".putAll(source.getAMap());"+
		 newLine + "   destination.setASortedMap(complexMap"+i+");"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void ValuedAll() {
		
		expected = "   if(destination.getASortedMap()!=null){"+
		 newLine + "   if(source.getAMap()!=null){"+
		 newLine + "   destination.getASortedMap().putAll(source.getAMap());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setASortedMap(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {

		expected = "   if(destination.getASortedMap()!=null){"+
		 newLine + "   if(source.getAMap()!=null){"+
		 newLine + "   destination.getASortedMap().putAll(source.getAMap());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getASortedMap()!=null){"+
	     newLine + "   if(source.getAMap()==null){"+
	     newLine + "   destination.setASortedMap(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}

	@Override
	protected void NullValued() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getASortedMap()==null){"+
		 newLine + "   if(source.getAMap()!=null){"+
		 newLine + "   java.util.TreeMap complexMap"+i+" = new java.util.TreeMap();"+
		 newLine + "   complexMap"+i+".putAll(source.getAMap());"+
		 newLine + "   destination.setASortedMap(complexMap"+i+");"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}	
		
}