package com.googlecode.jmapper.operations.recursive;

import java.lang.reflect.Field;

import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

//TODO Completare
public class MappedArrayListOperationTest extends
		AOperation<MappedArrayListOperation> {

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aMappedArray");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aTargetList");
	}

	@Override
	protected MappedArrayListOperation getOperationIstance() {
		return new MappedArrayListOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation();
	}
	
	@Override
	protected void AllAll() {
		write(newInstance);
		System.out.println(actual);

		write(enrichment);
		System.out.println(actual);

	}

	@Override
	protected void AllValued() {
		write(newInstance);
		System.out.println(actual);

		write(enrichment);
		System.out.println(actual);
	}

	@Override
	protected void ValuedAll() {
		write(enrichment);
		System.out.println(actual);

	}

	@Override
	protected void ValuedValued() {
		write(enrichment);
		System.out.println(actual);

	}

	@Override
	protected void ValuedNull() {
		write(enrichment);
		System.out.println(actual);

	}

	@Override
	protected void NullValued() {
		write(enrichment);
		System.out.println(actual);

	}
}
