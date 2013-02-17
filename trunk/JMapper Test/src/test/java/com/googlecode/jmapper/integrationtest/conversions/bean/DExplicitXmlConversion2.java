package com.googlecode.jmapper.integrationtest.conversions.bean;

import com.googlecode.jmapper.annotations.JMap;

public class DExplicitXmlConversion2 {
	
	@JMap("sField")
	private Integer dField;
	public DExplicitXmlConversion2() {}
	
	public DExplicitXmlConversion2(Integer dField) {
		super();
		this.dField = dField;
	}
	public Integer getDField() {
		return dField;
	}
	public void setDField(Integer dField) {
		this.dField = dField;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dField == null) ? 0 : dField.hashCode());
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
		DExplicitXmlConversion2 other = (DExplicitXmlConversion2) obj;
		if (dField == null) {
			if (other.dField != null)
				return false;
		} else if (!dField.equals(other.dField))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DExplicitXmlConversion2 [dField=" + dField + "]";
	}
	
	
}
