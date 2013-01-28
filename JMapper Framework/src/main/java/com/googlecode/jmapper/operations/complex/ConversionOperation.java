package com.googlecode.jmapper.operations.complex;

import com.googlecode.jmapper.operations.recursive.ARecursiveOperation;

public class ConversionOperation extends ARecursiveOperation {

	@Override
	protected StringBuilder existingField() {
		return applyExplicitConversion();
	}

	@Override
	protected StringBuilder fieldToCreate() {
		return applyExplicitConversion();
	}

}
