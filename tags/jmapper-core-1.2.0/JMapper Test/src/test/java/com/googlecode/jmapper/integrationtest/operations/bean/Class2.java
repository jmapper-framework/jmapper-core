package com.googlecode.jmapper.integrationtest.operations.bean;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((field1Class2 == null) ? 0 : field1Class2.hashCode());
		result = prime * result
				+ ((field2Class2 == null) ? 0 : field2Class2.hashCode());
		result = prime * result
				+ ((field3Class2 == null) ? 0 : field3Class2.hashCode());
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
		Class2 other = (Class2) obj;
		if (field1Class2 == null) {
			if (other.field1Class2 != null)
				return false;
		} else if (!field1Class2.equals(other.field1Class2))
			return false;
		if (field2Class2 == null) {
			if (other.field2Class2 != null)
				return false;
		} else if (!field2Class2.equals(other.field2Class2))
			return false;
		if (field3Class2 == null) {
			if (other.field3Class2 != null)
				return false;
		} else if (!field3Class2.equals(other.field3Class2))
			return false;
		return true;
	}
	
}
