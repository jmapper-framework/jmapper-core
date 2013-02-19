package com.googlecode.jmapper.integrationtest.operations.bean;


import java.util.Arrays;

import com.googlecode.jmapper.annotations.JMap;

public class MappedListArrayS {
	
	@JMap("targetSet")private MappedArray[] mappedArray;
	
	
	/**
	 * @param mappedArray
	 */
	public MappedListArrayS(MappedArray[] mappedArray) {
		super();
		this.mappedArray = mappedArray;
	}


	@Override
	public String toString() {
		return "MappedListArrayS [mappedArray=" + Arrays.toString(mappedArray)
				+ "]";
	}


	public MappedArray[] getMappedArray() {
		return mappedArray;
	}


	public void setMappedArray(MappedArray[] mappedArray) {
		this.mappedArray = mappedArray;
	}


	public MappedListArrayS() {}
		
}