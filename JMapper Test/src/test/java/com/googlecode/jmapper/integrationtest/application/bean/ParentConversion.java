package com.googlecode.jmapper.integrationtest.application.bean;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapConversion;

public class ParentConversion {

	@JMap	private String commonField1;
	@JMap	private String commonField2;
	
	@JMapConversion(from={"commonField1"})
	public String conversion(String source){
		return source + " ANNOTATED CONVERSION";
	}
	
	public String getCommonField1() {
		return commonField1;
	}
	public void setCommonField1(String commonField1) {
		this.commonField1 = commonField1;
	}
	public String getCommonField2() {
		return commonField2;
	}
	public void setCommonField2(String commonField2) {
		this.commonField2 = commonField2;
	}
	
	public ParentConversion() {}
	/**
	 * @param commonField1
	 * @param commonField2
	 */
	public ParentConversion(String commonField1, String commonField2) {
		super();
		this.commonField1 = commonField1;
		this.commonField2 = commonField2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commonField1 == null) ? 0 : commonField1.hashCode());
		result = prime * result
				+ ((commonField2 == null) ? 0 : commonField2.hashCode());
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
		ParentConversion other = (ParentConversion) obj;
		if (commonField1 == null) {
			if (other.commonField1 != null)
				return false;
		} else if (!commonField1.equals(other.commonField1))
			return false;
		if (commonField2 == null) {
			if (other.commonField2 != null)
				return false;
		} else if (!commonField2.equals(other.commonField2))
			return false;
		return true;
	}
	
}
