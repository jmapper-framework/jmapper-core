package com.googlecode.jmapper.integrationtest.conversions.bean;

import com.googlecode.jmapper.annotations.JMapConversion;

public class ObjSecondD {

	private ObjThirdD fieldSecondD;

	public ObjThirdD getFieldSecondD() {
		return fieldSecondD;
	}

	public void setFieldSecondD(ObjThirdD fieldSecondD) {
		this.fieldSecondD = fieldSecondD;
	}

	@JMapConversion
	public ObjThirdD conversion(ObjThirdD objd, ObjThirdS objs){
		return new ObjThirdD(objd.getFieldThirdD() + " ANNOTATION " + objs.getFieldThirdS());
	}
	
	@Override
	public String toString() {
		return "ObjSecondD [fieldSecondD=" + fieldSecondD + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fieldSecondD == null) ? 0 : fieldSecondD.hashCode());
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
		ObjSecondD other = (ObjSecondD) obj;
		if (fieldSecondD == null) {
			if (other.fieldSecondD != null)
				return false;
		} else if (!fieldSecondD.equals(other.fieldSecondD))
			return false;
		return true;
	}

	/**
	 * @param fieldSecondD
	 */
	public ObjSecondD(ObjThirdD fieldSecondD) {
		super();
		this.fieldSecondD = fieldSecondD;
	}
	
	public ObjSecondD() {}
}
