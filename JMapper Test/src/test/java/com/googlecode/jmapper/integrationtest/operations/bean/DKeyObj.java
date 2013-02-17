package com.googlecode.jmapper.integrationtest.operations.bean;

public class DKeyObj {

	private Integer dField;

	public Integer getDField() {
		return dField;
	}

	public void setDField(Integer dField) {
		this.dField = dField;
	}
	
	public DKeyObj() {}

	/**
	 * @param dField
	 */
	public DKeyObj(Integer dField) {
		super();
		this.dField = dField;
	}

	@Override
	public String toString() {
		return "DKeyObj->dField=" + dField;
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
		DKeyObj other = (DKeyObj) obj;
		if (dField == null) {
			if (other.dField != null)
				return false;
		} else if (!dField.equals(other.dField))
			return false;
		return true;
	}
	
	
}
