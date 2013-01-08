package it.avutils.jmapper.operations.complex;

import static it.avutils.jmapper.util.ClassesManager.getFieldValue;
import static it.avutils.jmapper.util.GeneralUtility.newLine;
import it.avutils.jmapper.bean.ComplexClass;
import it.avutils.jmapper.enums.ConversionType;
import it.avutils.jmapper.operations.AOperation;
import it.avutils.jmapper.operations.info.InfoOperation;

import java.lang.reflect.Field;
import java.util.TreeMap;

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