package it.avutils.jmapper.operations.complex;

import static it.avutils.jmapper.util.GeneralUtility.newLine;
import it.avutils.jmapper.bean.ComplexClass;
import it.avutils.jmapper.enums.ConversionType;
import it.avutils.jmapper.operations.AOperation;
import it.avutils.jmapper.operations.info.InfoOperation;

import java.lang.reflect.Field;
import java.util.HashMap;

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
		
		actual   = operation.write(newInstance).toString();
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
		
		actual   = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void AllValued() {
		
		expected = "   if(source.getASimpleMap2()!=null){"+
		 newLine + "   destination.setASimpleMap(source.getASimpleMap2());"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(newInstance).toString();
		verify();
		
		expected = "   if(source.getASimpleMap2()!=null){"+
		 newLine + "   if(destination.getASimpleMap()!=null){"+
		 newLine + "   destination.getASimpleMap().putAll(source.getASimpleMap2());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setASimpleMap(source.getASimpleMap2());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
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
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {

		expected = "   if(destination.getASimpleMap()!=null){"+
		 newLine + "   if(source.getASimpleMap2()!=null){"+
		 newLine + "   destination.getASimpleMap().putAll(source.getASimpleMap2());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getASimpleMap()!=null){"+
	     newLine + "   if(source.getASimpleMap2()==null){"+
	     newLine + "   destination.setASimpleMap(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}

	@Override
	protected void NullValued() {

		expected = "   if(destination.getASimpleMap()==null){"+
		 newLine + "   if(source.getASimpleMap2()!=null){"+
		 newLine + "   destination.setASimpleMap(source.getASimpleMap2());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}	
	
}