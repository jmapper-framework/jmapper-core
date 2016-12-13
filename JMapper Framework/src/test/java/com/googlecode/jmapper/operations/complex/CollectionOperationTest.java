package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;
import java.util.ArrayList;

import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.complex.CollectionOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.operations.AOperation;

public class CollectionOperationTest extends AOperation<CollectionOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aStringList");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aStringList2");
	}

	@Override
	protected CollectionOperation getOperationIstance() {
		return new CollectionOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.ABSENT);
	}
	
	@Override
	protected void setUp() {
		super.setUp();
		operation.setDestinationClass(ArrayList.class);
	}
	
	@Override
	protected void allAll() {
		
		expected = "   if(source.getAStringList2()!=null){"+
		 newLine + "   destination.setAStringList(source.getAStringList2());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAStringList(null);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(destination.getAStringList()!=null){"+
		 newLine + "   if(source.getAStringList2()!=null){"+
		 newLine + "   destination.getAStringList().addAll(source.getAStringList2());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAStringList(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getAStringList2()!=null){"+
		 newLine + "   destination.setAStringList(source.getAStringList2());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAStringList(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void allValued() {
		
		expected = "   if(source.getAStringList2()!=null){"+
		 newLine + "   destination.setAStringList(source.getAStringList2());"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getAStringList2()!=null){"+
		 newLine + "   if(destination.getAStringList()!=null){"+
		 newLine + "   destination.getAStringList().addAll(source.getAStringList2());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAStringList(source.getAStringList2());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void valuedAll() {
		
		expected = "   if(destination.getAStringList()!=null){"+
		 newLine + "   if(source.getAStringList2()!=null){"+
		 newLine + "   destination.getAStringList().addAll(source.getAStringList2());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAStringList(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void valuedValued() {

		expected = "   if(destination.getAStringList()!=null){"+
		 newLine + "   if(source.getAStringList2()!=null){"+
		 newLine + "   destination.getAStringList().addAll(source.getAStringList2());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void valuedNull() {
		
		expected = "   if(destination.getAStringList()!=null){"+
	     newLine + "   if(source.getAStringList2()==null){"+
	     newLine + "   destination.setAStringList(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}

	@Override
	protected void nullValued() {

		expected = "   if(destination.getAStringList()==null){"+
		 newLine + "   if(source.getAStringList2()!=null){"+
		 newLine + "   destination.setAStringList(source.getAStringList2());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}	
}