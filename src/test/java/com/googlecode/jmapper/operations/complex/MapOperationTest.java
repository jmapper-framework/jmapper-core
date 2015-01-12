package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.operations.AOperation;

import java.lang.reflect.Field;
import java.util.HashMap;

import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.complex.MapOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class MapOperationTest extends AOperation<MapOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aSimpleMap");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aSimpleMap2");
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
		operation.setDestinationClass(HashMap.class);
	}
	
	@Override
	protected void AllAll() {
		
		expected = "   if(source.getASimpleMap2()!=null){"+
		 newLine + "   destination.setASimpleMap(source.getASimpleMap2());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setASimpleMap(null);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(destination.getASimpleMap()!=null){"+
		 newLine + "   if(source.getASimpleMap2()!=null){"+
		 newLine + "   destination.getASimpleMap().putAll(source.getASimpleMap2());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setASimpleMap(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getASimpleMap2()!=null){"+
		 newLine + "   destination.setASimpleMap(source.getASimpleMap2());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setASimpleMap(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void AllValued() {
		
		expected = "   if(source.getASimpleMap2()!=null){"+
		 newLine + "   destination.setASimpleMap(source.getASimpleMap2());"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getASimpleMap2()!=null){"+
		 newLine + "   if(destination.getASimpleMap()!=null){"+
		 newLine + "   destination.getASimpleMap().putAll(source.getASimpleMap2());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setASimpleMap(source.getASimpleMap2());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void ValuedAll() {
		
		expected = "   if(destination.getASimpleMap()!=null){"+
		 newLine + "   if(source.getASimpleMap2()!=null){"+
		 newLine + "   destination.getASimpleMap().putAll(source.getASimpleMap2());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setASimpleMap(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedValued() {

		expected = "   if(destination.getASimpleMap()!=null){"+
		 newLine + "   if(source.getASimpleMap2()!=null){"+
		 newLine + "   destination.getASimpleMap().putAll(source.getASimpleMap2());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getASimpleMap()!=null){"+
	     newLine + "   if(source.getASimpleMap2()==null){"+
	     newLine + "   destination.setASimpleMap(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}

	@Override
	protected void NullValued() {

		expected = "   if(destination.getASimpleMap()==null){"+
		 newLine + "   if(source.getASimpleMap2()!=null){"+
		 newLine + "   destination.setASimpleMap(source.getASimpleMap2());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}	
	
}