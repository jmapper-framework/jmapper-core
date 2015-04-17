package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import java.lang.reflect.Field;
import java.util.TreeMap;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.AOperation;
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
		
		expected = "   if(source.getAMap()!=null){"+
		 newLine + "   java.util.TreeMap complexMap$i = new java.util.TreeMap();"+
		 newLine + "   complexMap$i.putAll(source.getAMap());"+
		 newLine + "   destination.setASortedMap(complexMap$i);"+
		 newLine + "   }else{"+
		 newLine + "   destination.setASortedMap(null);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(destination.getASortedMap()!=null){"+
		 newLine + "   if(source.getAMap()!=null){"+
		 newLine + "   destination.getASortedMap().putAll(source.getAMap());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setASortedMap(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getAMap()!=null){"+
		 newLine + "   java.util.TreeMap complexMap$y = new java.util.TreeMap();"+
		 newLine + "   complexMap$y.putAll(source.getAMap());"+
		 newLine + "   destination.setASortedMap(complexMap$y);"+
		 newLine + "   }else{"+
		 newLine + "   destination.setASortedMap(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void AllValued() {
		
		
		
		expected = "   if(source.getAMap()!=null){"+
		 newLine + "   java.util.TreeMap complexMap$i = new java.util.TreeMap();"+
		 newLine + "   complexMap$i.putAll(source.getAMap());"+
		 newLine + "   destination.setASortedMap(complexMap$i);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getAMap()!=null){"+
		 newLine + "   if(destination.getASortedMap()!=null){"+
		 newLine + "   destination.getASortedMap().putAll(source.getAMap());"+
		 newLine + "   }else{"+
		 newLine + "   java.util.TreeMap complexMap$y = new java.util.TreeMap();"+
		 newLine + "   complexMap$y.putAll(source.getAMap());"+
		 newLine + "   destination.setASortedMap(complexMap$y);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
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
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedValued() {

		expected = "   if(destination.getASortedMap()!=null){"+
		 newLine + "   if(source.getAMap()!=null){"+
		 newLine + "   destination.getASortedMap().putAll(source.getAMap());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getASortedMap()!=null){"+
	     newLine + "   if(source.getAMap()==null){"+
	     newLine + "   destination.setASortedMap(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}

	@Override
	protected void NullValued() {

		expected = "   if(destination.getASortedMap()==null){"+
		 newLine + "   if(source.getAMap()!=null){"+
		 newLine + "   java.util.TreeMap complexMap$i = new java.util.TreeMap();"+
		 newLine + "   complexMap$i.putAll(source.getAMap());"+
		 newLine + "   destination.setASortedMap(complexMap$i);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}	
		
}