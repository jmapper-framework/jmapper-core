package com.googlecode.jmapper.integrationtest.operations.bean;

import java.util.Date;
import java.util.List;

public class ListArrayD {
	
	private List<String> stringList;
	private List<Integer> integerList;
	private List<Date> dateList;
	
	
	/**
	 * @param stringList
	 * @param integerList
	 * @param dateList
	 */
	public ListArrayD(List<String> stringList, List<Integer> integerList,
			List<Date> dateList) {
		super();
		this.stringList = stringList;
		this.integerList = integerList;
		this.dateList = dateList;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateList == null) ? 0 : dateList.hashCode());
		result = prime * result
				+ ((integerList == null) ? 0 : integerList.hashCode());
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
		ListArrayD other = (ListArrayD) obj;
		if (dateList == null) {
			if (other.dateList != null)
				return false;
		} else if (!dateList.equals(other.dateList))
			return false;
		if (integerList == null) {
			if (other.integerList != null)
				return false;
		} else if (!integerList.equals(other.integerList))
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
		return "ListArrayD [stringList=" + stringList + ", integerList="
				+ integerList + ", dateList=" + dateList + "]";
	}


	public List<String> getStringList() {
		return stringList;
	}


	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}


	public List<Integer> getIntegerList() {
		return integerList;
	}


	public void setIntegerList(List<Integer> integerList) {
		this.integerList = integerList;
	}


	public List<Date> getDateList() {
		return dateList;
	}


	public void setDateList(List<Date> dateList) {
		this.dateList = dateList;
	}


	public ListArrayD() {}
		
}
