package com.googlecode.jmapper.integrationtest.conversions.bean;


public class DExplicitXmlConversion {

	private String dField;
	private String dField2;
	private String dField3;
	
	public DExplicitXmlConversion() {}
	
	/**
	 * @param dField
	 * @param dField2
	 * @param dField3
	 */
	public DExplicitXmlConversion(String dField, String dField2, String dField3) {
		super();
		this.dField = dField;
		this.dField2 = dField2;
		this.dField3 = dField3;
	}
	public String getDField() {
		return dField;
	}
	public void setDField(String dField) {
		this.dField = dField;
	}
	public String getDField2() {
		return dField2;
	}
	public void setDField2(String dField2) {
		this.dField2 = dField2;
	}
	public String getDField3() {
		return dField3;
	}
	public void setDField3(String dField3) {
		this.dField3 = dField3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dField == null) ? 0 : dField.hashCode());
		result = prime * result + ((dField2 == null) ? 0 : dField2.hashCode());
		result = prime * result + ((dField3 == null) ? 0 : dField3.hashCode());
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
		DExplicitXmlConversion other = (DExplicitXmlConversion) obj;
		if (dField == null) {
			if (other.dField != null)
				return false;
		} else if (!dField.equals(other.dField))
			return false;
		if (dField2 == null) {
			if (other.dField2 != null)
				return false;
		} else if (!dField2.equals(other.dField2))
			return false;
		if (dField3 == null) {
			if (other.dField3 != null)
				return false;
		} else if (!dField3.equals(other.dField3))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DExplicitXmlConversion: dField(" + dField + ") dField2(" + dField2 + ") dField3(" + dField3 + ")";
	}
	
	
	
	
	
}
