package com.googlecode.jmapper.integrationtest.others.bean;

public class Source {

	private Boolean boo;

	public Source(Boolean boo) {
		this.boo = boo;
	}

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
		Source other = (Source) obj;
		if (boo == null) {
			if (other.boo != null)
				return false;
		} else if (!boo.equals(other.boo))
			return false;
		return true;
	}
	
	
}
