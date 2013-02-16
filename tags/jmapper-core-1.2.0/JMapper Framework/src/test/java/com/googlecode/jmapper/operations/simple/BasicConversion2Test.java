package com.googlecode.jmapper.operations.simple;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;

import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.operations.simple.BasicOperation;

import com.googlecode.jmapper.bean.SimpleClass;
import com.googlecode.jmapper.operations.AOperation;

public class BasicConversion2Test extends AOperation<BasicOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aIntField");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aStringField");
	}

	@Override
	protected BasicOperation getOperationIstance() {
		return new BasicOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.FromStringToint);
	}
	
	@Override
	protected void AllAll() {
		expected = "   destination.setAIntField(Integer.parseInt(source.getAStringField()));"+newLine;
		actual   = operation.write().toString();
		verify();
	}

	@Override
	protected void AllValued() {
		expected = "   if(source.getAStringField()!=null){"+
		 newLine + "   destination.setAIntField(Integer.parseInt(source.getAStringField()));"+
		 newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();
	}

	@Override
	protected void ValuedAll() {
		expected = "   destination.setAIntField(Integer.parseInt(source.getAStringField()));"+newLine;
		actual	 = operation.write().toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {
		expected = "   if(source.getAStringField()!=null){"+
	     newLine + "   destination.setAIntField(Integer.parseInt(source.getAStringField()));"+
	     newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		expected = newLine;
		actual	 = operation.write().toString();
		verify();		
	}

	@Override
	protected void NullValued() {
		expected = newLine;
		actual	 = operation.write().toString();
		verify();		
	}

}
