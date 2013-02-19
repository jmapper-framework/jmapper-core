package com.googlecode.jmapper.integrationtest.application.bean;

import com.googlecode.jmapper.annotations.JMap;

public class Class1 {

	@JMap(classes={Class2.class})
	 String field;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "Class1 [field=" + field + "]";
	}
	
	public Class1() {}

	public Class1(String field) {
		super();
		this.field = field;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((field == null) ? 0 : field.hashCode());
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
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		return true;
	}
	
	
}
