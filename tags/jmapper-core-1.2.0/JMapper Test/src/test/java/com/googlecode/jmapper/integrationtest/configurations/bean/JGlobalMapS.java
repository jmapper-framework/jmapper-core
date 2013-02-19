package com.googlecode.jmapper.integrationtest.configurations.bean;

public class JGlobalMapS {
	private String field;
	private String field2;
	private String field3;
	
	public JGlobalMapS() {}
	
	public JGlobalMapS(String field, String field2, String field3) {
		super();
		this.field = field;
		this.field2 = field2;
		this.field3 = field3;
	}
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result + ((field2 == null) ? 0 : field2.hashCode());
		result = prime * result + ((field3 == null) ? 0 : field3.hashCode());
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
		JGlobalMapS other = (JGlobalMapS) obj;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (field2 == null) {
			if (other.field2 != null)
				return false;
		} else if (!field2.equals(other.field2))
			return false;
		if (field3 == null) {
			if (other.field3 != null)
				return false;
		} else if (!field3.equals(other.field3))
			return false;
		return true;
	}
}
