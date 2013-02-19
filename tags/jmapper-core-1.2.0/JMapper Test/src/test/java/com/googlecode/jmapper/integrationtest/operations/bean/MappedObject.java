package com.googlecode.jmapper.integrationtest.operations.bean;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.util.List;
import java.util.SortedMap;

import com.googlecode.jmapper.annotations.JMap;

public class MappedObject {

	@JMap("intD")
	private int intS;
	@JMap("strD")
	private String strS;
	@JMap("listD")
	private List<String> listS;
	@JMap("sortedMapD")
	private SortedMap<String, String> sortedMapS;
	
	public int getIntS() {
		return intS;
	}
	public void setIntS(int intS) {
		this.intS = intS;
	}
	public String getStrS() {
		return strS;
	}
	public void setStrS(String strS) {
		this.strS = strS;
	}
	public List<String> getListS() {
		return listS;
	}
	public void setListS(List<String> listS) {
		this.listS = listS;
	}
	public SortedMap<String, String> getSortedMapS() {
		return sortedMapS;
	}
	public void setSortedMapS(SortedMap<String, String> sortedMapS) {
		this.sortedMapS = sortedMapS;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + intS;
		result = prime * result + ((listS == null) ? 0 : listS.hashCode());
		result = prime * result
				+ ((sortedMapS == null) ? 0 : sortedMapS.hashCode());
		result = prime * result + ((strS == null) ? 0 : strS.hashCode());
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
		MappedObject other = (MappedObject) obj;
		if (intS != other.intS)
			return false;
		if (listS == null) {
			if (other.listS != null)
				return false;
		} else if (!listS.equals(other.listS))
			return false;
		if (sortedMapS == null) {
			if (other.sortedMapS != null)
				return false;
		} else if (!sortedMapS.equals(other.sortedMapS))
			return false;
		if (strS == null) {
			if (other.strS != null)
				return false;
		} else if (!strS.equals(other.strS))
			return false;
		return true;
	}
	/**
	 * @param intS
	 * @param strS
	 * @param listS
	 * @param sortedMapS
	 */
	public MappedObject(int intS, String strS, List<String> listS,
			SortedMap<String, String> sortedMapS) {
		super();
		this.intS = intS;
		this.strS = strS;
		this.listS = listS;
		this.sortedMapS = sortedMapS;
	}
	
	public MappedObject() {}
	@Override
	public String toString() {
		return "MappedObject:"+newLine+"intS=" + intS + newLine + " strS=" + strS + newLine + " listS="
				+ listS + newLine + " sortedMapS=" + sortedMapS;
	}
	
	
}
