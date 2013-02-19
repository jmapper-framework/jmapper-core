package com.googlecode.jmapper.integrationtest.operations.bean;


import java.util.Set;
import java.util.SortedMap;

import com.googlecode.jmapper.annotations.JMap;
@SuppressWarnings({"rawtypes" })
public class WithoutGenericsS {

	@JMap("dfield")
	private String sfield;
	@JMap("dlist")
	private Set slist;
	@JMap("dmap")
	private SortedMap smap;
public WithoutGenericsS() {}
	/**
	 * @param sfield
	 * @param slist
	 * @param smap
	 */
	public WithoutGenericsS(String sfield, Set slist, SortedMap smap) {
		super();
		this.sfield = sfield;
		this.slist = slist;
		this.smap = smap;
	}

	public String getSfield() {
		return sfield;
	}

	public void setSfield(String sfield) {
		this.sfield = sfield;
	}

	public Set getSlist() {
		return slist;
	}

	public void setSlist(Set slist) {
		this.slist = slist;
	}

	public SortedMap getSmap() {
		return smap;
	}

	public void setSmap(SortedMap smap) {
		this.smap = smap;
	}

	@Override
	public String toString() {
		return "WithoutGenericsS [sfield=" + sfield + ", slist=" + slist
				+ ", smap=" + smap + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sfield == null) ? 0 : sfield.hashCode());
		result = prime * result + ((slist == null) ? 0 : slist.hashCode());
		result = prime * result + ((smap == null) ? 0 : smap.hashCode());
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
		WithoutGenericsS other = (WithoutGenericsS) obj;
		if (sfield == null) {
			if (other.sfield != null)
				return false;
		} else if (!sfield.equals(other.sfield))
			return false;
		if (slist == null) {
			if (other.slist != null)
				return false;
		} else if (!slist.equals(other.slist))
			return false;
		if (smap == null) {
			if (other.smap != null)
				return false;
		} else if (!smap.equals(other.smap))
			return false;
		return true;
	}
	
		
}