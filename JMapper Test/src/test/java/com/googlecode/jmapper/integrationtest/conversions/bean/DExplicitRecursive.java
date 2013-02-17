package com.googlecode.jmapper.integrationtest.conversions.bean;

public class DExplicitRecursive {

	private DExplicitConversion dconversion;

	public DExplicitRecursive() {}
	
	/**
	 * @param dconversion
	 */
	public DExplicitRecursive(DExplicitConversion dconversion) {
		super();
		this.dconversion = dconversion;
	}

	public DExplicitConversion getDconversion() {
		return dconversion;
	}

	public void setDconversion(DExplicitConversion dconversion) {
		this.dconversion = dconversion;
	}

	@Override
	public String toString() {
		return dconversion.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dconversion == null) ? 0 : dconversion.hashCode());
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
		DExplicitRecursive other = (DExplicitRecursive) obj;
		if (dconversion == null) {
			if (other.dconversion != null)
				return false;
		} else if (!dconversion.equals(other.dconversion))
			return false;
		return true;
	}
	
	
}
