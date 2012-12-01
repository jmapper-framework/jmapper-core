package it.avutils.jmapper.operations.complex;

import it.avutils.jmapper.operations.recursive.ARecursiveOperation;

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
