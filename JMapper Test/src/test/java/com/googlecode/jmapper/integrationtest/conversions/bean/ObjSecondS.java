package com.googlecode.jmapper.integrationtest.conversions.bean;

import com.googlecode.jmapper.annotations.JMap;

public class ObjSecondS {

	@JMap("fieldSecondD")
	private ObjThirdS fieldSecondS;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fieldSecondS == null) ? 0 : fieldSecondS.hashCode());
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
		ObjSecondS other = (ObjSecondS) obj;
		if (fieldSecondS == null) {
			if (other.fieldSecondS != null)
				return false;
		} else if (!fieldSecondS.equals(other.fieldSecondS))
			return false;
		return true;
	}
	public ObjSecondS() {}
	/**
	 * @param fieldSecondS
	 */
	public ObjSecondS(ObjThirdS fieldSecondS) {
		super();
		this.fieldSecondS = fieldSecondS;
	}


	public ObjThirdS getFieldSecondS() {
		return fieldSecondS;
	}


	public void setFieldSecondS(ObjThirdS fieldSecondS) {
		this.fieldSecondS = fieldSecondS;
	}


	@Override
	public String toString() {
		return "ObjSecondS [fieldSecondS=" + fieldSecondS + "]";
	}
	
	
}
