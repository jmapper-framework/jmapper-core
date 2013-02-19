package com.googlecode.jmapper.integrationtest.operations.bean;

import com.googlecode.jmapper.annotations.JMap;

public class UndefinedD {

	@JMap("date")
	private StringBuilder sb;

	
	public StringBuilder getSb() {
		return sb;
	}

	public void setSb(StringBuilder sb) {
		this.sb = sb;
	}

	public UndefinedD() {}

	/**
	 * @param sb
	 */
	public UndefinedD(StringBuilder sb) {
		super();
		this.sb = sb;
	}

	@Override
	public String toString() {
		return "UndefinedD [sb=" + sb + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sb == null) ? 0 : sb.hashCode());
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
		UndefinedD other = (UndefinedD) obj;
		if (sb == null) {
			if (other.sb != null)
				return false;
		} else if (!sb.equals(other.sb))
			return false;
		return true;
	}
	
	
}
