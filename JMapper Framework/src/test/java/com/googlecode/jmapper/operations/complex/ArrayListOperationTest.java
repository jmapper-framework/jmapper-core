package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

//TODO Test da completare --> ArrayListOperationTest
public class ArrayListOperationTest extends AOperation<ArrayListOperation> {

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("StringArray");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aSetInteger");
	}

	@Override
	protected ArrayListOperation getOperationIstance() {
		return new ArrayListOperation();
	}

	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.ABSENT);
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
