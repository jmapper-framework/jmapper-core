package com.googlecode.jmapper.integrationtest.conversions.bean;

import com.googlecode.jmapper.annotations.JMap;

public class DExplicitConversion2 {

	
	@JMap("sfield") private String field1;
	@JMap("sfield")	private String field2;
	@JMap("sfield") private String field3;
	
	
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
		return "DExplicitConversion2 [field1=" + field1 + ", field2=" + field2
				+ ", field3=" + field3 + "]";
	}
	/**
	 * @param field1
	 * @param field2
	 * @param field3
	 */
	public DExplicitConversion2(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	
	public DExplicitConversion2() {}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((field1 == null) ? 0 : field1.hashCode());
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
		DExplicitConversion2 other = (DExplicitConversion2) obj;
		if (field1 == null) {
			if (other.field1 != null)
				return false;
		} else if (!field1.equals(other.field1))
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
