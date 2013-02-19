package com.googlecode.jmapper.integrationtest.conversions.bean;


public class ObjThirdD {

	private String fieldThirdD;

	public String getFieldThirdD() {
		return fieldThirdD;
	}

	public void setFieldThirdD(String fieldThirdD) {
		this.fieldThirdD = fieldThirdD;
	}

	@Override
	public String toString() {
		return "ObjThirdD [fieldThirdD=" + fieldThirdD + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fieldThirdD == null) ? 0 : fieldThirdD.hashCode());
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
		ObjThirdD other = (ObjThirdD) obj;
		if (fieldThirdD == null) {
			if (other.fieldThirdD != null)
				return false;
		} else if (!fieldThirdD.equals(other.fieldThirdD))
			return false;
		return true;
	}

	/**
	 * @param fieldThirdD
	 */
	public ObjThirdD(String fieldThirdD) {
		super();
		this.fieldThirdD = fieldThirdD;
	}
	
	public ObjThirdD() {}
}
