package com.googlecode.jmapper.integrationtest.operations.bean;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings({"rawtypes" })
public class WithoutGenericsD {
	private String dfield;
	
	private ArrayList dlist;
	
	private HashMap dmap;
	
	public WithoutGenericsD() {}
	
	/**
	 * @param dfield
	 * @param dlist
	 * @param dmap
	 */
	public WithoutGenericsD(String dfield, ArrayList dlist, HashMap dmap) {
		super();
		this.dfield = dfield;
		this.dlist = dlist;
		this.dmap = dmap;
	}

	public String getDfield() {
		return dfield;
	}

	public void setDfield(String dfield) {
		this.dfield = dfield;
	}

	public ArrayList getDlist() {
		return dlist;
	}

	public void setDlist(ArrayList dlist) {
		this.dlist = dlist;
	}

	public HashMap getDmap() {
		return dmap;
	}

	public void setDmap(HashMap dmap) {
		this.dmap = dmap;
	}

	@Override
	public String toString() {
		return newLine+"WithoutGenericsD [dfield=" + dfield + ", dlist=" + dlist
				+ ", dmap=" + dmap + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dfield == null) ? 0 : dfield.hashCode());
		result = prime * result + ((dlist == null) ? 0 : dlist.hashCode());
		result = prime * result + ((dmap == null) ? 0 : dmap.hashCode());
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
		WithoutGenericsD other = (WithoutGenericsD) obj;
		if (dfield == null) {
			if (other.dfield != null)
				return false;
		} else if (!dfield.equals(other.dfield))
			return false;
		if (dlist == null) {
			if (other.dlist != null)
				return false;
		} else if (!dlist.equals(other.dlist))
			return false;
		if (dmap == null) {
			if (other.dmap != null)
				return false;
		} else if (!dmap.equals(other.dmap))
			return false;
		return true;
	}
	
	
}
