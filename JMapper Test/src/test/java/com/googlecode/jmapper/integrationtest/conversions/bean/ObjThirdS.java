package com.googlecode.jmapper.integrationtest.conversions.bean;

public class ObjThirdS {

	private String fieldThirdS;

	public String getFieldThirdS() {
		return fieldThirdS;
	}

	public void setFieldThirdS(String fieldThirdS) {
		this.fieldThirdS = fieldThirdS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fieldThirdS == null) ? 0 : fieldThirdS.hashCode());
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
		ObjThirdS other = (ObjThirdS) obj;
		if (fieldThirdS == null) {
			if (other.fieldThirdS != null)
				return false;
		} else if (!fieldThirdS.equals(other.fieldThirdS))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ObjThirdS [fieldThirdS=" + fieldThirdS + "]";
	}

	/**
	 * @param fieldThirdS
	 */
	public ObjThirdS(String fieldThirdS) {
		super();
		this.fieldThirdS = fieldThirdS;
	}
	
	public ObjThirdS() {}
	
}
