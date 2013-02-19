package com.googlecode.jmapper.integrationtest.operations.bean;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapD {

	private Map<String, String> aMapD;
	private HashMap<String, String> aHashMapD;
	private SortedMap<String, String> aSortedMapD;
	private TreeMap<String, String> aTreeMapD;
	
	public MapD() {}
	public Map<String, String> getAMapD() {
		return aMapD;
	}
	public void setAMapD(Map<String, String> aMapD) {
		this.aMapD = aMapD;
	}
	public HashMap<String, String> getAHashMapD() {
		return aHashMapD;
	}
	public void setAHashMapD(HashMap<String, String> aHashMapD) {
		this.aHashMapD = aHashMapD;
	}
	public SortedMap<String, String> getASortedMapD() {
		return aSortedMapD;
	}
	public void setASortedMapD(SortedMap<String, String> aSortedMapD) {
		this.aSortedMapD = aSortedMapD;
	}
	public TreeMap<String, String> getATreeMapD() {
		return aTreeMapD;
	}
	public void setATreeMapD(TreeMap<String, String> aTreeMapD) {
		this.aTreeMapD = aTreeMapD;
	}
	/**
	 * @param aMapD
	 * @param aHashMapD
	 * @param aSortedMapD
	 * @param aTreeMapD
	 */
	public MapD(Map<String, String> aMapD, HashMap<String, String> aHashMapD,
			SortedMap<String, String> aSortedMapD,
			TreeMap<String, String> aTreeMapD) {
		super();
		this.aMapD = aMapD;
		this.aHashMapD = aHashMapD;
		this.aSortedMapD = aSortedMapD;
		this.aTreeMapD = aTreeMapD;
	}
	@Override
	public String toString() {
		return "MapD:"+newLine+"aMapD=" + aMapD+newLine+"aHashMapD=" + aHashMapD
				+ ", aSortedMapD=" + aSortedMapD+newLine+"aTreeMapD=" + aTreeMapD;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aHashMapD == null) ? 0 : aHashMapD.hashCode());
		result = prime * result + ((aMapD == null) ? 0 : aMapD.hashCode());
		result = prime * result
				+ ((aSortedMapD == null) ? 0 : aSortedMapD.hashCode());
		result = prime * result
				+ ((aTreeMapD == null) ? 0 : aTreeMapD.hashCode());
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
		MapD other = (MapD) obj;
		if (aHashMapD == null) {
			if (other.aHashMapD != null)
				return false;
		} else if (!aHashMapD.equals(other.aHashMapD))
			return false;
		if (aMapD == null) {
			if (other.aMapD != null)
				return false;
		} else if (!aMapD.equals(other.aMapD))
			return false;
		if (aSortedMapD == null) {
			if (other.aSortedMapD != null)
				return false;
		} else if (!aSortedMapD.equals(other.aSortedMapD))
			return false;
		if (aTreeMapD == null) {
			if (other.aTreeMapD != null)
				return false;
		} else if (!aTreeMapD.equals(other.aTreeMapD))
			return false;
		return true;
	}
	
	
}
