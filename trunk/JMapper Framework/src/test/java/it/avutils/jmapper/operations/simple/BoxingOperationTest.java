package it.avutils.jmapper.operations.simple;

import static it.avutils.jmapper.util.GeneralUtility.newLine;
import it.avutils.jmapper.bean.SimpleClass;
import it.avutils.jmapper.enums.ConversionType;
import it.avutils.jmapper.operations.AOperation;
import it.avutils.jmapper.operations.info.InfoOperation;

import java.lang.reflect.Field;

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
