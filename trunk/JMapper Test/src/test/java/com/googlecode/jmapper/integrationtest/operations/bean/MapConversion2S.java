package com.googlecode.jmapper.integrationtest.operations.bean;


import java.util.SortedMap;

import com.googlecode.jmapper.annotations.JMap;

public class MapConversion2S {
	
	@JMap("dField")
	private SortedMap<SKeyObj, String> sField;
	
	
	public SortedMap<SKeyObj, String> getSField() {
		return sField;
	}

	public void setSField(SortedMap<SKeyObj, String> sField) {
		this.sField = sField;
	}

	/**
	 * @param sField
	 */
	public MapConversion2S(SortedMap<SKeyObj, String> sField) {
		super();
		this.sField = sField;
	}


	
	public MapConversion2S() {}

	@Override
	public String toString() {
		return "MapConversion2S [sField=" + sField + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sField == null) ? 0 : sField.hashCode());
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
		MapConversion2S other = (MapConversion2S) obj;
		if (sField == null) {
			if (other.sField != null)
				return false;
		} else if (!sField.equals(other.sField))
			return false;
		return true;
	}
	
	
		
}