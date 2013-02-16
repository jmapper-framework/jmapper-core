package com.googlecode.jmapper.operations.simple;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import com.googlecode.jmapper.bean.SimpleClass;
import com.googlecode.jmapper.operations.AOperation;

import java.lang.reflect.Field;

import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.operations.simple.BasicOperation;

public class BoxingOperationTest extends AOperation<BasicOperation> {

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aIntegerField");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aIntField");
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
		expected = "   destination.setAIntegerField(new java.lang.Integer(source.getAIntField()));"+newLine;
		actual   = operation.write().toString();
		verify();
	}

	@Override
	protected void AllValued() {
		expected = "   destination.setAIntegerField(new java.lang.Integer(source.getAIntField()));"+newLine;
		actual   = operation.write().toString();
		verify();
	}

	@Override
	protected void ValuedAll() {
		expected = "   if(destination.getAIntegerField()!=null){"+
		 newLine + "   destination.setAIntegerField(new java.lang.Integer(source.getAIntField()));"+
		 newLine + "   }" + newLine;
		actual = operation.write().toString();
		verify();
	}

	@Override
	protected void ValuedValued() {
		expected = "   if(destination.getAIntegerField()!=null){"+
		 newLine + "   destination.setAIntegerField(new java.lang.Integer(source.getAIntField()));"+
		 newLine + "   }" + newLine;
		actual = operation.write().toString();
		verify();
	}

	@Override
	protected void ValuedNull() {
		expected = newLine;
		actual = operation.write().toString();
		verify();
	}

	@Override
	protected void NullValued() {
		expected = "   if(destination.getAIntegerField()==null){"+
		 newLine + "   destination.setAIntegerField(new java.lang.Integer(source.getAIntField()));"+
		 newLine + "   }" + newLine;
		actual = operation.write().toString();
		verify();
	}

}
