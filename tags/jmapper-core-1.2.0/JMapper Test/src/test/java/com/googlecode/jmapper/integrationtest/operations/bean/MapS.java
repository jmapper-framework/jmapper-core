package com.googlecode.jmapper.integrationtest.operations.bean;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.googlecode.jmapper.annotations.JMap;

public class MapS {

	@JMap("aTreeMapD")
	private Map<String, String> aMapS;
	@JMap("aMapD")
	private HashMap<String, String> aHashMapS;
	@JMap("aHashMapD")
	private SortedMap<String, String> aSortedMapS;
	@JMap("aSortedMapD")
	private TreeMap<String, String> aTreeMapS;
	
	public MapS() {}
	public Map<String, String> getAMapS() {
		return aMapS;
	}
	public void setAMapS(Map<String, String> aMapS) {
		this.aMapS = aMapS;
	}
	public HashMap<String, String> getAHashMapS() {
		return aHashMapS;
	}
	public void setAHashMapS(HashMap<String, String> aHashMapS) {
		this.aHashMapS = aHashMapS;
	}
	public SortedMap<String, String> getASortedMapS() {
		return aSortedMapS;
	}
	public void setASortedMapS(SortedMap<String, String> aSortedMapS) {
		this.aSortedMapS = aSortedMapS;
	}
	public TreeMap<String, String> getATreeMapS() {
		return aTreeMapS;
	}
	public void setATreeMapS(TreeMap<String, String> aTreeMapS) {
		this.aTreeMapS = aTreeMapS;
	}
	@Override
	public String toString() {
		return "MapS:"+newLine+"aMapS=" + aMapS+newLine+"aHashMapS=" + aHashMapS
				+ ", aSortedMapS=" + aSortedMapS+newLine+"aTreeMapS=" + aTreeMapS;
	}
	/**
	 * @param aMapS
	 * @param aHashMapS
	 * @param aSortedMapS
	 * @param aTreeMapS
	 */
	public MapS(Map<String, String> aMapS, HashMap<String, String> aHashMapS,
			SortedMap<String, String> aSortedMapS,
			TreeMap<String, String> aTreeMapS) {
		super();
		this.aMapS = aMapS;
		this.aHashMapS = aHashMapS;
		this.aSortedMapS = aSortedMapS;
		this.aTreeMapS = aTreeMapS;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aHashMapS == null) ? 0 : aHashMapS.hashCode());
		result = prime * result + ((aMapS == null) ? 0 : aMapS.hashCode());
		result = prime * result
				+ ((aSortedMapS == null) ? 0 : aSortedMapS.hashCode());
		result = prime * result
				+ ((aTreeMapS == null) ? 0 : aTreeMapS.hashCode());
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
		MapS other = (MapS) obj;
		if (aHashMapS == null) {
			if (other.aHashMapS != null)
				return false;
		} else if (!aHashMapS.equals(other.aHashMapS))
			return false;
		if (aMapS == null) {
			if (other.aMapS != null)
				return false;
		} else if (!aMapS.equals(other.aMapS))
			return false;
		if (aSortedMapS == null) {
			if (other.aSortedMapS != null)
				return false;
		} else if (!aSortedMapS.equals(other.aSortedMapS))
			return false;
		if (aTreeMapS == null) {
			if (other.aTreeMapS != null)
				return false;
		} else if (!aTreeMapS.equals(other.aTreeMapS))
			return false;
		return true;
	}
	
	
}
