package com.googlecode.jmapper.integrationtest.application.bean;

import com.googlecode.jmapper.annotations.JMap;

public class Child2 extends Parent {

	@JMap	private String specificField3;
	@JMap	private String specificField4;
	
	public String getSpecificField3() {
		return specificField3;
	}
	public void setSpecificField3(String specificField3) {
		this.specificField3 = specificField3;
	}
	public String getSpecificField4() {
		return specificField4;
	}
	public void setSpecificField4(String specificField4) {
		this.specificField4 = specificField4;
	}
	
	public Child2() {}
	
	/**
	 * @param specificField3
	 * @param specificField4
	 */
	public Child2(String specificField3, String specificField4) {
		super();
		this.specificField3 = specificField3;
		this.specificField4 = specificField4;
	}
	
	
	@Override
	public String toString() {
		return "Child2 [specificField3=" + specificField3 + ", specificField4="
				+ specificField4 + ", getCommonField1()=" + getCommonField1()
				+ ", getCommonField2()=" + getCommonField2() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((specificField3 == null) ? 0 : specificField3.hashCode());
		result = prime * result
				+ ((specificField4 == null) ? 0 : specificField4.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Child2 other = (Child2) obj;
		if (specificField3 == null) {
			if (other.specificField3 != null)
				return false;
		} else if (!specificField3.equals(other.specificField3))
			return false;
		if (specificField4 == null) {
			if (other.specificField4 != null)
				return false;
		} else if (!specificField4.equals(other.specificField4))
			return false;
		return true;
	}
	
	
}
