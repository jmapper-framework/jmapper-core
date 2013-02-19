package com.googlecode.jmapper.integrationtest.application.bean;

import com.googlecode.jmapper.annotations.JMap;

public class ChildConversion2 extends ParentConversion2{

	@JMap	private String specificField1;
	@JMap	private String specificField2;
	
	public String getSpecificField1() {
		return specificField1;
	}
	public void setSpecificField1(String specificField1) {
		this.specificField1 = specificField1;
	}
	public String getSpecificField2() {
		return specificField2;
	}
	public void setSpecificField2(String specificField2) {
		this.specificField2 = specificField2;
	}
	
	public ChildConversion2() {}
	/**
	 * @param specificField1
	 * @param specificField2
	 */
	public ChildConversion2(String specificField1, String specificField2,String common1, String common2) {
		super(common1,common2);
		this.specificField1 = specificField1;
		this.specificField2 = specificField2;
	}
	@Override
	public String toString() {
		return "ChildConversion [specificField1=" + specificField1 + ", specificField2="
				+ specificField2 + ", getCommonField1()=" + getCommonField1()
				+ ", getCommonField2()=" + getCommonField2() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((specificField1 == null) ? 0 : specificField1.hashCode());
		result = prime * result
				+ ((specificField2 == null) ? 0 : specificField2.hashCode());
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
		ChildConversion2 other = (ChildConversion2) obj;
		if (specificField1 == null) {
			if (other.specificField1 != null)
				return false;
		} else if (!specificField1.equals(other.specificField1))
			return false;
		if (specificField2 == null) {
			if (other.specificField2 != null)
				return false;
		} else if (!specificField2.equals(other.specificField2))
			return false;
		return true;
	}
	

}
