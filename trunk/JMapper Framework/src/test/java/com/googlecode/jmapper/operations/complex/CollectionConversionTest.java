package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.ClassesManager.getFieldValue;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;
import java.util.ArrayList;

import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.complex.CollectionOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.operations.AOperation;

public class CollectionConversionTest extends AOperation<CollectionOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aList");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aSet");
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
	protected void AllAll() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getASet()!=null){"+
		 newLine + "   java.util.ArrayList complexCollection"+i+" = new java.util.ArrayList(source.getASet());"+
		 newLine + "   destination.setAList(complexCollection"+i+");"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAList(null);"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getAList()!=null){"+
		 newLine + "   if(source.getASet()!=null){"+
		 newLine + "   destination.getAList().addAll(source.getASet());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAList(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getASet()!=null){"+
		 newLine + "   java.util.ArrayList complexCollection"+ ++i+" = new java.util.ArrayList(source.getASet());"+
		 newLine + "   destination.setAList(complexCollection"+i+");"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAList(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void AllValued() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getASet()!=null){"+
		 newLine + "   java.util.ArrayList complexCollection"+i+" = new java.util.ArrayList(source.getASet());"+
		 newLine + "   destination.setAList(complexCollection"+i+");"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getASet()!=null){"+
		 newLine + "   if(destination.getAList()!=null){"+
		 newLine + "   destination.getAList().addAll(source.getASet());"+
		 newLine + "   }else{"+
		 newLine + "   java.util.ArrayList complexCollection"+ ++i+" = new java.util.ArrayList(source.getASet());"+
		 newLine + "   destination.setAList(complexCollection"+i+");"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void ValuedAll() {
		
		expected = "   if(destination.getAList()!=null){"+
		 newLine + "   if(source.getASet()!=null){"+
		 newLine + "   destination.getAList().addAll(source.getASet());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAList(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {

		expected = "   if(destination.getAList()!=null){"+
		 newLine + "   if(source.getASet()!=null){"+
		 newLine + "   destination.getAList().addAll(source.getASet());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getAList()!=null){"+
	     newLine + "   if(source.getASet()==null){"+
	     newLine + "   destination.setAList(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}

	@Override
	protected void NullValued() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getAList()==null){"+
		 newLine + "   if(source.getASet()!=null){"+
		 newLine + "   java.util.ArrayList complexCollection"+i+" = new java.util.ArrayList(source.getASet());"+
		 newLine + "   destination.setAList(complexCollection"+i+");"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}

}
