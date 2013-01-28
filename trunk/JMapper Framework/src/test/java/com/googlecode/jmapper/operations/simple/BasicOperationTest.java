package com.googlecode.jmapper.operations.simple;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;

import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.operations.simple.BasicOperation;

import com.googlecode.jmapper.bean.SimpleClass;
import com.googlecode.jmapper.operations.AOperation;

public class BasicOperationTest extends AOperation<BasicOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aField");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aField");
	}

	@Override
	protected BasicOperation getOperationIstance() {
		return new BasicOperation();
	}

	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.ABSENT);
	}
	
	@Override
	protected void AllAll() {
		expected = "   destination.setAField(source.getAField());"+newLine;
		actual   = operation.write().toString();
		verify();
	}

	@Override
	protected void AllValued() {
		expected = "   if(source.getAField()!=null){"+
		 newLine + "   destination.setAField(source.getAField());"+
		 newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();
	}

	@Override
	protected void ValuedAll() {
		expected = "   if(destination.getAField()!=null){"+
		 newLine + "   destination.setAField(source.getAField());"+
	     newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {
		expected = "   if(destination.getAField()!=null){"+
	     newLine + "   if(source.getAField()!=null){"+
	     newLine + "   destination.setAField(source.getAField());"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		expected = "   if(destination.getAField()!=null){"+
	     newLine + "   if(source.getAField()==null){"+
	     newLine + "   destination.setAField(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();		
	}

	@Override
	protected void NullValued() {
		expected = "   if(destination.getAField()==null){"+
		 newLine + "   if(source.getAField()!=null){"+
		 newLine + "   destination.setAField(source.getAField());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();		
	}

}
