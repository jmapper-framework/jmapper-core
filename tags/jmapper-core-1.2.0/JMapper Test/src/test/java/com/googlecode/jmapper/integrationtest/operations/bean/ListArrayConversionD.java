package com.googlecode.jmapper.integrationtest.operations.bean;

import java.util.List;

public class ListArrayConversionD {
	
	private List<Long> longList;
	private List<Integer> integerList;
	private List<String> stringList;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((integerList == null) ? 0 : integerList.hashCode());
		result = prime * result
				+ ((longList == null) ? 0 : longList.hashCode());
		result = prime * result
				+ ((stringList == null) ? 0 : stringList.hashCode());
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
		ListArrayConversionD other = (ListArrayConversionD) obj;
		if (integerList == null) {
			if (other.integerList != null)
				return false;
		} else if (!integerList.equals(other.integerList))
			return false;
		if (longList == null) {
			if (other.longList != null)
				return false;
		} else if (!longList.equals(other.longList))
			return false;
		if (stringList == null) {
			if (other.stringList != null)
				return false;
		} else if (!stringList.equals(other.stringList))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ListArrayConversionD [longList=" + longList + ", integerList="
				+ integerList + ", stringList=" + stringList + "]";
	}


	/**
	 * @param longList
	 * @param integerList
	 * @param stringList
	 */
	public ListArrayConversionD(List<Long> longList, List<Integer> integerList,
			List<String> stringList) {
		super();
		this.longList = longList;
		this.integerList = integerList;
		this.stringList = stringList;
	}


	public List<Long> getLongList() {
		return longList;
	}


	public void setLongList(List<Long> longList) {
		this.longList = longList;
	}


	public List<Integer> getIntegerList() {
		return integerList;
	}


	public void setIntegerList(List<Integer> integerList) {
		this.integerList = integerList;
	}


	public List<String> getStringList() {
		return stringList;
	}


	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}


	public ListArrayConversionD() {}
		
}
