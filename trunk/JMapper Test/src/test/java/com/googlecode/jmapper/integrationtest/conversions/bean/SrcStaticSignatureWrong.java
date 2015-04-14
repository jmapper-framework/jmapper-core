package com.googlecode.jmapper.integrationtest.conversions.bean;


public class SrcStaticSignatureWrong {
	
	private StringBuilder field;

	private StringBuilder field2;
	
	public SrcStaticSignatureWrong(StringBuilder field, StringBuilder field2) {
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
