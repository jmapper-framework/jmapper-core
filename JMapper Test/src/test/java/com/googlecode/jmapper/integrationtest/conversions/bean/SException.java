package com.googlecode.jmapper.integrationtest.conversions.bean;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapConversion;

public class SException {

	@JMap	private String field;
	
	@JMapConversion public String conversion(String uno, String due, String tre){
		return "";
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "SException [field=" + field + "]";
	}

	/**
	 * @param field
	 */
	public SException(String field) {
		super();
		this.field = field;
	}
	
	
}
