package com.googlecode.jmapper.bean;

public class Class1 {

	private String field1Class1;
	private String field2Class1;
	private String field3Class1;
	
	public Class1() {}
	
	public Class1(String field1Class1, String field2Class1, String field3Class1) {
		super();
		this.field1Class1 = field1Class1;
		this.field2Class1 = field2Class1;
		this.field3Class1 = field3Class1;
	}

	public String getField1Class1() {
		return field1Class1;
	}
	public void setField1Class1(String field1Class1) {
		this.field1Class1 = field1Class1;
	}
	public String getField2Class1() {
		return field2Class1;
	}
	public void setField2Class1(String field2Class1) {
		this.field2Class1 = field2Class1;
	}
	public String getField3Class1() {
		return field3Class1;
	}
	public void setField3Class1(String field3Class1) {
		this.field3Class1 = field3Class1;
	}

	@Override
	public String toString() {
		return "Class1 [field1Class1=" + field1Class1 + ", field2Class1="
				+ field2Class1 + ", field3Class1=" + field3Class1 + "]";
	}

}
