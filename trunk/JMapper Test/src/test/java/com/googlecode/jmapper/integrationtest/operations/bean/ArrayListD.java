package com.googlecode.jmapper.integrationtest.operations.bean;

import java.util.Arrays;
import java.util.Date;

public class ArrayListD {
	
	private String[] stringArray;
	private Integer[] integerArray;
	private Date[] dateArray;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(dateArray);
		result = prime * result + Arrays.hashCode(integerArray);
		result = prime * result + Arrays.hashCode(stringArray);
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
		ArrayListD other = (ArrayListD) obj;
		if (!Arrays.equals(dateArray, other.dateArray))
			return false;
		if (!Arrays.equals(integerArray, other.integerArray))
			return false;
		if (!Arrays.equals(stringArray, other.stringArray))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ArrayListD [stringArray=" + Arrays.toString(stringArray)
				+ ", integerArray=" + Arrays.toString(integerArray)
				+ ", dateArray=" + Arrays.toString(dateArray) + "]";
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

	public ArrayListD() {}

	public ArrayListD(String[] stringArray, Integer[] integerArray,
			Date[] dateArray) {
		super();
		this.stringArray = stringArray;
		this.integerArray = integerArray;
		this.dateArray = dateArray;
	}
		
	
}
