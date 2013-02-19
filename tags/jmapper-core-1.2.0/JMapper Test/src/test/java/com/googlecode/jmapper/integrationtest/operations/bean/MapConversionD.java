package com.googlecode.jmapper.integrationtest.operations.bean;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.util.Map;
import java.util.SortedMap;

public class MapConversionD {
	
	
	private Map<String, Integer> destinationMap;
	private SortedMap<Integer, String> destinationMap2;
	
	/**
	 * @param destinationMap
	 * @param destinationMap2
	 */
	public MapConversionD(Map<String, Integer> destinationMap,
			SortedMap<Integer, String> destinationMap2) {
		super();
		this.destinationMap = destinationMap;
		this.destinationMap2 = destinationMap2;
	}


	public Map<String, Integer> getDestinationMap() {
		return destinationMap;
	}


	public void setDestinationMap(Map<String, Integer> destinationMap) {
		this.destinationMap = destinationMap;
	}


	public SortedMap<Integer, String> getDestinationMap2() {
		return destinationMap2;
	}


	public void setDestinationMap2(SortedMap<Integer, String> destinationMap2) {
		this.destinationMap2 = destinationMap2;
	}


	public MapConversionD() {}


	@Override
	public String toString() {
		return "MapConversionD:"+newLine+" map=" + destinationMap
				+ ", map2=" + destinationMap2 + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((destinationMap == null) ? 0 : destinationMap.hashCode());
		result = prime * result
				+ ((destinationMap2 == null) ? 0 : destinationMap2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)	return true;
		if (obj == null)	return false;
		if (getClass() != obj.getClass())	return false;
		MapConversionD other = (MapConversionD) obj;
		if (destinationMap == null) {
			if (other.destinationMap != null)	return false;
		} else 
			if(!this.destinationMap.equals(other.destinationMap))
			return false;
		if (destinationMap2 == null) {
			if (other.destinationMap2 != null)
				return false;
		} else
			if(!this.destinationMap2.equals(other.destinationMap2))
			return false;
		return true;
	}
}
