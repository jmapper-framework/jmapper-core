package com.googlecode.jmapper.integrationtest.operations.bean;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((field1Class3 == null) ? 0 : field1Class3.hashCode());
		result = prime * result
				+ ((field2Class3 == null) ? 0 : field2Class3.hashCode());
		result = prime * result
				+ ((field3Class3 == null) ? 0 : field3Class3.hashCode());
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
		Class3 other = (Class3) obj;
		if (field1Class3 == null) {
			if (other.field1Class3 != null)
				return false;
		} else if (!field1Class3.equals(other.field1Class3))
			return false;
		if (field2Class3 == null) {
			if (other.field2Class3 != null)
				return false;
		} else if (!field2Class3.equals(other.field2Class3))
			return false;
		if (field3Class3 == null) {
			if (other.field3Class3 != null)
				return false;
		} else if (!field3Class3.equals(other.field3Class3))
			return false;
		return true;
	}
	
	
}
