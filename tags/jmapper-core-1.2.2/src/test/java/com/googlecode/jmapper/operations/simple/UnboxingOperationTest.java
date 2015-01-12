package com.googlecode.jmapper.operations.simple;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import com.googlecode.jmapper.bean.SimpleClass;
import com.googlecode.jmapper.operations.AOperation;

import java.lang.reflect.Field;

import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.operations.simple.BasicOperation;

public class UnboxingOperationTest extends AOperation<BasicOperation> {

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aIntField");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aIntegerField");
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
		expected = "   destination.setAIntField(source.getAIntegerField().intValue());"+newLine;
		write();
		verify();
	}

	@Override
	protected void AllValued() {
		expected = "   if(source.getAIntegerField()!=null){"+
		 newLine + "   destination.setAIntField(source.getAIntegerField().intValue());"+
		 newLine + "   }" + newLine;
		write();
		verify();
	}

	@Override
	protected void ValuedAll() {
		expected = "   destination.setAIntField(source.getAIntegerField().intValue());"+newLine;
		write();
		verify();
	}

	@Override
	protected void ValuedValued() {
		expected = "   if(source.getAIntegerField()!=null){"+
		 newLine + "   destination.setAIntField(source.getAIntegerField().intValue());"+
		 newLine + "   }" + newLine;
		write();
		verify();
	}

	@Override
	protected void ValuedNull() {
		expected = newLine;
		write();
		verify();
	}

	@Override
	protected void NullValued() {
		expected = newLine;
		write();
		verify();
	}

}
