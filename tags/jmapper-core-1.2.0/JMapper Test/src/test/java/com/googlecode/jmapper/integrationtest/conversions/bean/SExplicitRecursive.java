package com.googlecode.jmapper.integrationtest.conversions.bean;

import com.googlecode.jmapper.annotations.JMap;

public class SExplicitRecursive {

	@JMap("dconversion")
	private SExplicitConversion sconversion;

	public SExplicitConversion getSconversion() {
		return sconversion;
	}

	public void setSconversion(SExplicitConversion sconversion) {
		this.sconversion = sconversion;
	}

	public SExplicitRecursive() {}
	
	/**
	 * @param sconversion
	 */
	public SExplicitRecursive(SExplicitConversion sconversion) {
		super();
		this.sconversion = sconversion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sconversion == null) ? 0 : sconversion.hashCode());
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
		SExplicitRecursive other = (SExplicitRecursive) obj;
		if (sconversion == null) {
			if (other.sconversion != null)
				return false;
		} else if (!sconversion.equals(other.sconversion))
			return false;
		return true;
	}
	
	
}
