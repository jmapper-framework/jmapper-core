package com.googlecode.jmapper.integrationtest.operations.bean;


import java.util.Map;
import java.util.SortedMap;

import com.googlecode.jmapper.annotations.JMap;

public class MapConversionS {
	
	@JMap("destinationMap")
	private SortedMap<Integer, String> sourceMap;
	@JMap("destinationMap2")
	private Map<String, Integer> sourceMap2;
	
	public MapConversionS() {}

	/**
	 * @param sourceMap
	 * @param sourceMap2
	 */
	public MapConversionS(SortedMap<Integer, String> sourceMap,
			Map<String, Integer> sourceMap2) {
		super();
		this.sourceMap = sourceMap;
		this.sourceMap2 = sourceMap2;
	}

	@Override
	public String toString() {
		return "MapConversionS [sourceMap=" + sourceMap + ", sourceMap2="
				+ sourceMap2 + "]";
	}

	public SortedMap<Integer, String> getSourceMap() {
		return sourceMap;
	}

	public void setSourceMap(SortedMap<Integer, String> sourceMap) {
		this.sourceMap = sourceMap;
	}

	public Map<String, Integer> getSourceMap2() {
		return sourceMap2;
	}

	public void setSourceMap2(Map<String, Integer> sourceMap2) {
		this.sourceMap2 = sourceMap2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sourceMap == null) ? 0 : sourceMap.hashCode());
		result = prime * result
				+ ((sourceMap2 == null) ? 0 : sourceMap2.hashCode());
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
		MapConversionS other = (MapConversionS) obj;
		if (sourceMap == null) {
			if (other.sourceMap != null)
				return false;
		} else if (!sourceMap.equals(other.sourceMap))
			return false;
		if (sourceMap2 == null) {
			if (other.sourceMap2 != null)
				return false;
		} else if (!sourceMap2.equals(other.sourceMap2))
			return false;
		return true;
	}
	
	
		
}