package com.googlecode.jmapper.integrationtest.operations.bean;


import java.util.Arrays;

import com.googlecode.jmapper.annotations.JMap;

public class MappedArrayS {

	@JMap("targetArray")
	private MappedArray[] mappedArray;

	public MappedArray[] getMappedArray() {
		return mappedArray;
	}

	public void setMappedArray(MappedArray[] mappedArray) {
		this.mappedArray = mappedArray;
	}
	
	public MappedArrayS() {}

	/**
	 * @param mappedArray
	 */
	public MappedArrayS(MappedArray[] mappedArray) {
		super();
		this.mappedArray = mappedArray;
	}

	@Override
	public String toString() {
		return "MappedArrayS [mappedArray=" + Arrays.toString(mappedArray)
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(mappedArray);
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
		MappedArrayS other = (MappedArrayS) obj;
		if (!Arrays.equals(mappedArray, other.mappedArray))
			return false;
		return true;
	}
	
	
}
