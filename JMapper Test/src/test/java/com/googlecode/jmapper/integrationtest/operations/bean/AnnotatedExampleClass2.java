package com.googlecode.jmapper.integrationtest.operations.bean;
import com.googlecode.jmapper.annotations.JGlobalMap;


@JGlobalMap(value="globalMapping", classes={Class1.class, Class2.class, Class3.class}, excluded={"field2"})
public class AnnotatedExampleClass2 {

	  private String field1;
	  private String field2;
	  private String field3;
	
	public AnnotatedExampleClass2() {}
	
	public AnnotatedExampleClass2(String field1, String field2, String field3) {
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
		return "AnnotatedExampleClass [field1=" + field1 + ", field2=" + field2
				+ ", field3=" + field3 + "]";
	}
	
@JGlobalMap
	public static class Inner {
		
		private String innerField;

		public String getInnerField() {
			return innerField;
		}

		public void setInnerField(String innerField) {
			this.innerField = innerField;
		}

		@Override
		public String toString() {
			return "Inner [innerField=" + innerField + "]";
		}
		
		public Inner() {}

		public Inner(String innerField) {
			super();
			this.innerField = innerField;
		}
		
		
	}
}
