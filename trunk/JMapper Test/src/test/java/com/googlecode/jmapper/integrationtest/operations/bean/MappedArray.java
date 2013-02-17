package com.googlecode.jmapper.integrationtest.operations.bean;

import com.googlecode.jmapper.annotations.JMap;

public class MappedArray {

	@JMap
	private String field;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "MappedArray [field=" + field + "]";
	}
	
	public MappedArray() {
		
	}

	public MappedArray(String field) {
		super();
		this.field = field;
	}
	
}
