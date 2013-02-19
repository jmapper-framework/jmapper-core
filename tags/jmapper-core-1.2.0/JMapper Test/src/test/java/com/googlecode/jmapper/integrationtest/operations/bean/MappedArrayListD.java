package com.googlecode.jmapper.integrationtest.operations.bean;

import java.util.Arrays;

public class MappedArrayListD {
	
	private TargetArray[] targetArray;

	public TargetArray[] getTargetArray() {
		return targetArray;
	}


	public void setTargetArray(TargetArray[] targetArray) {
		this.targetArray = targetArray;
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
		MappedArrayListD other = (MappedArrayListD) obj;
		if (!Arrays.equals(targetArray, other.targetArray))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "MappedArrayListD [targetArray=" + Arrays.toString(targetArray)
				+ "]";
	}


	/**
	 * @param targetArray
	 */
	public MappedArrayListD(TargetArray[] mappedArray) {
		super();
		this.targetArray = mappedArray;
	}


	public MappedArrayListD() {}
		
}
