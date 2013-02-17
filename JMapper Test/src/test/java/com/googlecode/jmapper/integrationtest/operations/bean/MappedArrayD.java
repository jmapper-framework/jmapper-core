package com.googlecode.jmapper.integrationtest.operations.bean;

import java.util.Arrays;

public class MappedArrayD {

	private TargetArray[] targetArray;

	public TargetArray[] getTargetArray() {
		return targetArray;
	}

	public void setTargetArray(TargetArray[] targetArray) {
		this.targetArray = targetArray;
	}
	
	public MappedArrayD() {}

	/**
	 * @param targetArray
	 */
	public MappedArrayD(TargetArray[] targetArray) {
		super();
		this.targetArray = targetArray;
	}

	@Override
	public String toString() {
		return "MappedArrayD [targetArray=" + Arrays.toString(targetArray)
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(targetArray);
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
		MappedArrayD other = (MappedArrayD) obj;
		if (!Arrays.equals(targetArray, other.targetArray))
			return false;
		return true;
	}
	
	
}
