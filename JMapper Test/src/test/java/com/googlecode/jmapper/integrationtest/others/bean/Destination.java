package com.googlecode.jmapper.integrationtest.others.bean;

import com.googlecode.jmapper.annotations.JMap;

public class Destination {

	@JMap
	private Boolean boo;

	public Boolean getBoo() {
		return boo;
	}

	public void setBoo(Boolean boo) {
		this.boo = boo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boo == null) ? 0 : boo.hashCode());
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
		Destination other = (Destination) obj;
		if (boo == null) {
			if (other.boo != null)
				return false;
		} else if (!boo.equals(other.boo))
			return false;
		return true;
	}
	
	
}
