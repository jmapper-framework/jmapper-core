package com.googlecode.jmapper.bean;

public class Class3 {

	private String field1Class3;
	private String field2Class3;
	private String field3Class3;
	
	public Class3() {}
	
	public Class3(String field1Class3, String field2Class3, String field3Class3) {
		super();
		this.field1Class3 = field1Class3;
		this.field2Class3 = field2Class3;
		this.field3Class3 = field3Class3;
	}

	public String getField1Class3() {
		return field1Class3;
	}
	public void setField1Class3(String field1Class3) {
		this.field1Class3 = field1Class3;
	}
	public String getField2Class3() {
		return field2Class3;
	}
	public void setField2Class3(String field2Class3) {
		this.field2Class3 = field2Class3;
	}
	public String getField3Class3() {
		return field3Class3;
	}
	public void setField3Class3(String field3Class3) {
		this.field3Class3 = field3Class3;
	}

	@Override
	public String toString() {
		return "Class3 [field1Class3=" + field1Class3 + ", field2Class3="
				+ field2Class3 + ", field3Class3=" + field3Class3 + "]";
	}
	
	
}
