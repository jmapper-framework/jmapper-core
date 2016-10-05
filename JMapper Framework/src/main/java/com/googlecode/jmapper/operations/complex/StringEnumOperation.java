package com.googlecode.jmapper.operations.complex;

public class StringEnumOperation extends AComplexOperation {

	@Override
	protected StringBuilder existingField() {
		return sharedMapping();
	}

	@Override
	protected StringBuilder fieldToCreate() {
		return sharedMapping();
	}

	private StringBuilder sharedMapping(){
		return write(setDestination(getSource().append(".toString()")));
	}

}
