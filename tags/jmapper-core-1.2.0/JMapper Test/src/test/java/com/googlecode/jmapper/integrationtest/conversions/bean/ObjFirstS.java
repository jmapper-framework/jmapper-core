package com.googlecode.jmapper.integrationtest.conversions.bean;

import com.googlecode.jmapper.annotations.JMap;

public class ObjFirstS {
	
	@JMap("fieldFirstD")
	private ObjSecondS fieldFirstS;

	public ObjSecondS getFieldFirstS() {
		return fieldFirstS;
	}

	public void setFieldFirstS(ObjSecondS fieldFirstS) {
		this.fieldFirstS = fieldFirstS;
	}

	@Override
	public String toString() {
		return "ObjFirstS [fieldFirstS=" + fieldFirstS + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fieldFirstS == null) ? 0 : fieldFirstS.hashCode());
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
		ObjFirstS other = (ObjFirstS) obj;
		if (fieldFirstS == null) {
			if (other.fieldFirstS != null)
				return false;
		} else if (!fieldFirstS.equals(other.fieldFirstS))
			return false;
		return true;
	}

	/**
	 * @param fieldFirstS
	 */
	public ObjFirstS(ObjSecondS fieldFirstS) {
		super();
		this.fieldFirstS = fieldFirstS;
	}
	
	public ObjFirstS() {}
}
