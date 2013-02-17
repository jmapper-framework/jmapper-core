package com.googlecode.jmapper.integrationtest.operations.bean;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.util.Map;
import java.util.Set;

public class TargetObject {

	private int intD;
	private String strD;
	private Set<String> listD;
	private Map<String, String> sortedMapD;
	
	public int getIntD() {
		return intD;
	}
	public void setIntD(int intD) {
		this.intD = intD;
	}
	public String getStrD() {
		return strD;
	}
	public void setStrD(String strD) {
		this.strD = strD;
	}
	public Set<String> getListD() {
		return listD;
	}
	public void setListD(Set<String> listD) {
		this.listD = listD;
	}
	public Map<String, String> getSortedMapD() {
		return sortedMapD;
	}
	public void setSortedMapD(Map<String, String> sortedMapD) {
		this.sortedMapD = sortedMapD;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + intD;
		result = prime * result + ((listD == null) ? 0 : listD.hashCode());
		result = prime * result
				+ ((sortedMapD == null) ? 0 : sortedMapD.hashCode());
		result = prime * result + ((strD == null) ? 0 : strD.hashCode());
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
		TargetObject other = (TargetObject) obj;
		if (intD != other.intD)
			return false;
		if (listD == null) {
			if (other.listD != null)
				return false;
		} else if (!listD.equals(other.listD))
			return false;
		if (sortedMapD == null) {
			if (other.sortedMapD != null)
				return false;
		} else if (!sortedMapD.equals(other.sortedMapD))
			return false;
		if (strD == null) {
			if (other.strD != null)
				return false;
		} else if (!strD.equals(other.strD))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TargetObject:"+newLine+"intD=" + intD + newLine + " strD=" + strD + newLine + " listD="
				+ listD + newLine + " sortedMapD=" + sortedMapD;
	}
	/**
	 * @param intD
	 * @param strD
	 * @param listD
	 * @param sortedMapD
	 */
	public TargetObject(int intD, String strD, Set<String> listD,
			Map<String, String> sortedMapD) {
		super();
		this.intD = intD;
		this.strD = strD;
		this.listD = listD;
		this.sortedMapD = sortedMapD;
	}
	
	public TargetObject() {}
}
