package com.googlecode.jmapper.integrationtest.others.bean;


public class SrcAvoidSet {
	
	private StringBuilder field;

	private StringBuilder field2;
	
	public SrcAvoidSet(StringBuilder field, StringBuilder field2) {
		super();
		this.field = field;
		this.field2 = field2;
	}

	public StringBuilder getField2() {
		return field2;
	}

	public void setField2(StringBuilder field2) {
		this.field2 = field2;
	}

	public StringBuilder getField() {
		return field;
	}

	public void setField(StringBuilder field) {
		this.field = field;
	}
}
