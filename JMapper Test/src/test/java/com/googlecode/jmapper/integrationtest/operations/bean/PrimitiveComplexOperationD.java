package com.googlecode.jmapper.integrationtest.operations.bean;

public class PrimitiveComplexOperationD {
	
	private long longField;

	public PrimitiveComplexOperationD() {}
	
	public PrimitiveComplexOperationD(long longField) {
		super();
		this.longField = longField;
	}

	public long getLongField() {
		return longField;
	}

	public void setLongField(long longField) {
		this.longField = longField;
	}

	@Override
	public String toString() {
		return "PrimitiveComplexOperationD [longField=" + longField + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (longField ^ (longField >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrimitiveComplexOperationD other = (PrimitiveComplexOperationD) obj;
		if (longField != other.longField)
			return false;
		return true;
	}

	
	
}
