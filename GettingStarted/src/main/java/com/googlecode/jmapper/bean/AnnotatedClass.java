package com.googlecode.jmapper.bean;
import com.googlecode.jmapper.annotations.JMap;


public class AnnotatedClass {

@JMap(value="field1", attributes={"field1Class1", "field1Class2", "field1Class3"}, classes={Class1.class, Class2.class, Class3.class})
	private String field1;
@JMap(value="field2", attributes={"field2Class1", "field2Class2", "field2Class3"}, classes={Class1.class, Class2.class, Class3.class})
	private String field2;
@JMap(value="field3", attributes={"field3Class1", "field3Class2", "field3Class3"}, classes={Class1.class, Class2.class, Class3.class})
	private String field3;
	
	// getter and setter...
	
	
	public AnnotatedClass() {}
	
	public AnnotatedClass(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}

	@Override
	public String toString() {
		return "AnnotatedClass [field1=" + field1 + ", field2=" + field2
				+ ", field3=" + field3 + "]";
	}
	
}
