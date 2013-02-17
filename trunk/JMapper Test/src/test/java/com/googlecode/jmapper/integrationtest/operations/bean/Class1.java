package com.googlecode.jmapper.integrationtest.operations.bean;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((field1Class1 == null) ? 0 : field1Class1.hashCode());
		result = prime * result
				+ ((field2Class1 == null) ? 0 : field2Class1.hashCode());
		result = prime * result
				+ ((field3Class1 == null) ? 0 : field3Class1.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Class1 other = (Class1) obj;
		if (field1Class1 == null) {
			if (other.field1Class1 != null)
				return false;
		} else if (!field1Class1.equals(other.field1Class1))
			return false;
		if (field2Class1 == null) {
			if (other.field2Class1 != null)
				return false;
		} else if (!field2Class1.equals(other.field2Class1))
			return false;
		if (field3Class1 == null) {
			if (other.field3Class1 != null)
				return false;
		} else if (!field3Class1.equals(other.field3Class1))
			return false;
		return true;
	}

	
}
