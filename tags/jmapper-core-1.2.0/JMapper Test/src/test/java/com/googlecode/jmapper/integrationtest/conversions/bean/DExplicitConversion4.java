package com.googlecode.jmapper.integrationtest.conversions.bean;


import java.util.List;

import com.googlecode.jmapper.annotations.JMap;

public class DExplicitConversion4 {

	@JMap("sourceList")
	private List<String> destList;

	public List<String> getDestList() {
		return destList;
	}

	public void setDestList(List<String> destList) {
		this.destList = destList;
	}

	/**
	 * @param destList
	 */
	public DExplicitConversion4(List<String> destList) {
		super();
		this.destList = destList;
	}
	
	public DExplicitConversion4() {}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((destList == null) ? 0 : destList.hashCode());
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
		DExplicitConversion4 other = (DExplicitConversion4) obj;
		if (destList == null) {
			if (other.destList != null)
				return false;
		} else if (!destList.equals(other.destList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DExplicitConversion4 [destList=" + destList + "]";
	}
	
	
}
