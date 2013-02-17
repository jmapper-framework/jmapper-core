package com.googlecode.jmapper.integrationtest.conversions.bean;

public class SExplicitConversion {

	private Integer field;

	public Integer getField() {
		return field;
	}

	public void setField(Integer field) {
		this.field = field;
	}
	
	public SExplicitConversion() {}

	public SExplicitConversion(Integer field) {
		this.field = field;
	}
	
	
}
