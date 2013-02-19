package com.googlecode.jmapper.integrationtest.operations.bean;


import java.util.List;

import com.googlecode.jmapper.annotations.JMap;

public class CollectionConversionS {
	@JMap("destListString")
	private List<Integer> sourceListInteger;
	@JMap("destListInteger")
	private List<String> sourceListString;
	
	public CollectionConversionS() {}

	/**
	 * @param sourceListInteger
	 * @param sourceListString
	 */
	public CollectionConversionS(List<Integer> sourceListInteger,
			List<String> sourceListString) {
		super();
		this.sourceListInteger = sourceListInteger;
		this.sourceListString = sourceListString;
	}

	@Override
	public String toString() {
		return "CollectionConversionS [sourceListInteger=" + sourceListInteger
				+ ", sourceListString=" + sourceListString + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((sourceListInteger == null) ? 0 : sourceListInteger
						.hashCode());
		result = prime
				* result
				+ ((sourceListString == null) ? 0 : sourceListString.hashCode());
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
		CollectionConversionS other = (CollectionConversionS) obj;
		if (sourceListInteger == null) {
			if (other.sourceListInteger != null)
				return false;
		} else if (!sourceListInteger.equals(other.sourceListInteger))
			return false;
		if (sourceListString == null) {
			if (other.sourceListString != null)
				return false;
		} else if (!sourceListString.equals(other.sourceListString))
			return false;
		return true;
	}

	public List<Integer> getSourceListInteger() {
		return sourceListInteger;
	}

	public void setSourceListInteger(List<Integer> sourceListInteger) {
		this.sourceListInteger = sourceListInteger;
	}

	public List<String> getSourceListString() {
		return sourceListString;
	}

	public void setSourceListString(List<String> sourceListString) {
		this.sourceListString = sourceListString;
	}
		
	
}