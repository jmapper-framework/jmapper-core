package com.googlecode.jmapper.integrationtest.application.bean;


public class Class3 {
	
	private String sourceField1;
	private String sourceField2;
	private String sourceField3;
	
	
	
	/**
	 * @param sourceField1
	 * @param sourceField2
	 * @param sourceField3
	 */
	public Class3(String sourceField1, String sourceField2, String sourceField3) {
		super();
		this.sourceField1 = sourceField1;
		this.sourceField2 = sourceField2;
		this.sourceField3 = sourceField3;
	}
	public String getSourceField1() {
		return sourceField1;
	}
	public void setSourceField1(String sourceField1) {
		this.sourceField1 = sourceField1;
	}
	public String getSourceField2() {
		return sourceField2;
	}
	public void setSourceField2(String sourceField2) {
		this.sourceField2 = sourceField2;
	}
	public String getSourceField3() {
		return sourceField3;
	}
	public void setSourceField3(String sourceField3) {
		this.sourceField3 = sourceField3;
	}

	public Class3() {}
	@Override
	public String toString() {
		return "Class3 [sourceField1=" + sourceField1 + ", sourceField2="
				+ sourceField2 + ", sourceField3=" + sourceField3 + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sourceField1 == null) ? 0 : sourceField1.hashCode());
		result = prime * result
				+ ((sourceField2 == null) ? 0 : sourceField2.hashCode());
		result = prime * result
				+ ((sourceField3 == null) ? 0 : sourceField3.hashCode());
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
		Class3 other = (Class3) obj;
		if (sourceField1 == null) {
			if (other.sourceField1 != null)
				return false;
		} else if (!sourceField1.equals(other.sourceField1))
			return false;
		if (sourceField2 == null) {
			if (other.sourceField2 != null)
				return false;
		} else if (!sourceField2.equals(other.sourceField2))
			return false;
		if (sourceField3 == null) {
			if (other.sourceField3 != null)
				return false;
		} else if (!sourceField3.equals(other.sourceField3))
			return false;
		return true;
	}
	
	
}
