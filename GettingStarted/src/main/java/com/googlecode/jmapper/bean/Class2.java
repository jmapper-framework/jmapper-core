package com.googlecode.jmapper.bean;

public class Class2 {

	private String field1Class2;
	private String field2Class2;
	private String field3Class2;
	
	public Class2() {}
	
	public Class2(String field1Class2, String field2Class2, String field3Class2) {
		super();
		this.field1Class2 = field1Class2;
		this.field2Class2 = field2Class2;
		this.field3Class2 = field3Class2;
	}

	public String getField1Class2() {
		return field1Class2;
	}
	public void setField1Class2(String field1Class2) {
		this.field1Class2 = field1Class2;
	}
	public String getField2Class2() {
		return field2Class2;
	}
	public void setField2Class2(String field2Class2) {
		this.field2Class2 = field2Class2;
	}
	public String getField3Class2() {
		return field3Class2;
	}
	public void setField3Class2(String field3Class2) {
		this.field3Class2 = field3Class2;
	}

	@Override
	public String toString() {
		return "Class2 [field1Class2=" + field1Class2 + ", field2Class2="
				+ field2Class2 + ", field3Class2=" + field3Class2 + "]";
	}
	
}
