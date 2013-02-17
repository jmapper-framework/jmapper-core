package com.googlecode.jmapper.integrationtest.conversions.bean;

public class ObjFirstD {

	private ObjSecondD fieldFirstD;

	public ObjSecondD getFieldFirstD() {
		return fieldFirstD;
	}

	public void setFieldFirstD(ObjSecondD fieldFirstD) {
		this.fieldFirstD = fieldFirstD;
	}

	@Override
	public String toString() {
		return "ObjFirstD [fieldFirstD=" + fieldFirstD + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fieldFirstD == null) ? 0 : fieldFirstD.hashCode());
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
		ObjFirstD other = (ObjFirstD) obj;
		if (fieldFirstD == null) {
			if (other.fieldFirstD != null)
				return false;
		} else if (!fieldFirstD.equals(other.fieldFirstD))
			return false;
		return true;
	}

	/**
	 * @param fieldFirstD
	 */
	public ObjFirstD(ObjSecondD fieldFirstD) {
		super();
		this.fieldFirstD = fieldFirstD;
	}
	
	public ObjFirstD() {}
}
