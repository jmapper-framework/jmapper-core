package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;
import java.util.ArrayList;

import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

//TODO Test da completare --> ListArrayConversionTest
public class ListArrayConversionTest extends AOperation<ListArrayOperation> {

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aSetInteger");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("StringArray");
	}

	@Override
	protected ListArrayOperation getOperationIstance() {
		return new ListArrayOperation();
	}

	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.FromStringToInteger);
	}

	@Override
	protected void setUp() {
		super.setUp();
		operation.setDestinationClass(ArrayList.class);
	}

	@Override
	protected void AllAll() {
		
		expected = ""+newLine;
		
		actual   = operation.write(newInstance).toString();
		
//		System.out.println(actual);
//		verify();

		expected = ""+newLine;
		
		actual   = operation.write(enrichment).toString();
		
//		System.out.println("\n\n"+actual);
//		verify();
	}

	@Override
	protected void AllValued() {
		
		expected = ""+newLine;
		
		actual	 = operation.write(newInstance).toString();
		
//		System.out.println(actual);
//		verify();
		
		expected = ""+newLine;
		
		actual	 = operation.write(enrichment).toString();
		
//		System.out.println("\n\n"+actual);
//		verify();
	}

	@Override
	protected void ValuedAll() {
		
		expected = ""+newLine;
		
		actual	 = operation.write(enrichment).toString();
		
//		System.out.println(actual);
//		verify();
	}

	@Override
	protected void ValuedValued() {

		expected = ""+newLine;
		
		actual	 = operation.write(enrichment).toString();

//		System.out.println(actual);
//		verify();
	
	}

	@Override
	protected void ValuedNull() {
		
		expected = ""+newLine;
		
		actual	 = operation.write(enrichment).toString();

//		System.out.println(actual);
//		verify();
	}

	@Override
	protected void NullValued() {

		expected = ""+newLine;
		
		actual	 = operation.write(enrichment).toString();

//		System.out.println(actual);
//		verify();		
	}	

}
