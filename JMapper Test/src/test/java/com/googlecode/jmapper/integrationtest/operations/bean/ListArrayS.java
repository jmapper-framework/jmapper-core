package com.googlecode.jmapper.integrationtest.operations.bean;


import java.util.Arrays;
import java.util.Date;

import com.googlecode.jmapper.annotations.JMap;

public class ListArrayS {
	
	@JMap("stringList")private String[] stringArray;
	@JMap("integerList")private Integer[] integerArray;
	@JMap("dateList")private Date[] dateArray;
	
	
	@Override
	public String toString() {
		return "ListArrayS [stringArray=" + Arrays.toString(stringArray)
				+ ", integerArray=" + Arrays.toString(integerArray)
				+ ", dateArray=" + Arrays.toString(dateArray) + "]";
	}


	/**
	 * @param stringArray
	 * @param integerArray
	 * @param dateArray
	 */
	public ListArrayS(String[] stringArray, Integer[] integerArray,
			Date[] dateArray) {
		super();
		this.stringArray = stringArray;
		this.integerArray = integerArray;
		this.dateArray = dateArray;
	}


	public String[] getStringArray() {
		return stringArray;
	}


	public void setStringArray(String[] stringArray) {
		this.stringArray = stringArray;
	}


	public Integer[] getIntegerArray() {
		return integerArray;
	}


	public void setIntegerArray(Integer[] integerArray) {
		this.integerArray = integerArray;
	}


	public Date[] getDateArray() {
		return dateArray;
	}


	public void setDateArray(Date[] dateArray) {
		this.dateArray = dateArray;
	}


	public ListArrayS() {}
		
}