package com.googlecode.jmapper.integrationtest.operations.bean;

import java.util.List;

public class CollectionConversionD {
	
	private List<String> destListString;
	private List<Integer> destListInteger;
	
	
	public CollectionConversionD() {}


	/**
	 * @param destListString
	 * @param destListInteger
	 */
	public CollectionConversionD(List<String> destListString,
			List<Integer> destListInteger) {
		super();
		this.destListString = destListString;
		this.destListInteger = destListInteger;
	}


	public List<String> getDestListString() {
		return destListString;
	}


	public void setDestListString(List<String> destListString) {
		this.destListString = destListString;
	}


	public List<Integer> getDestListInteger() {
		return destListInteger;
	}


	public void setDestListInteger(List<Integer> destListInteger) {
		this.destListInteger = destListInteger;
	}


	@Override
	public String toString() {
		return "CollectionConversionD [destListString=" + destListString
				+ ", destListInteger=" + destListInteger + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((destListInteger == null) ? 0 : destListInteger.hashCode());
		result = prime * result
				+ ((destListString == null) ? 0 : destListString.hashCode());
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
		CollectionConversionD other = (CollectionConversionD) obj;
		if (destListInteger == null) {
			if (other.destListInteger != null)
				return false;
		} else if (!destListInteger.equals(other.destListInteger))
			return false;
		if (destListString == null) {
			if (other.destListString != null)
				return false;
		} else if (!destListString.equals(other.destListString))
			return false;
		return true;
	}
	
	
		
}
