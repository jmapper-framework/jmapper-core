package com.googlecode.jmapper.integrationtest.operations.bean;

import java.util.Arrays;

import com.googlecode.jmapper.annotations.JMap;


public class ArrayConversionS {
	
	@JMap("dString")
	private Integer[] sInteger;
	@JMap("dInteger")
	private String[] sString;
	@JMap("dCharacter")
	private int[] sInt;
	
	public ArrayConversionS() {}

	/**
	 * @param sInteger
	 * @param sString
	 * @param sInt
	 */
	public ArrayConversionS(Integer[] sInteger, String[] sString, int[] sInt) {
		super();
		this.sInteger = sInteger;
		this.sString = sString;
		this.sInt = sInt;
	}

	public Integer[] getSInteger() {
		return sInteger;
	}

	public void setSInteger(Integer[] sInteger) {
		this.sInteger = sInteger;
	}

	public String[] getSString() {
		return sString;
	}

	public void setSString(String[] sString) {
		this.sString = sString;
	}

	public int[] getSInt() {
		return sInt;
	}

	public void setSInt(int[] sInt) {
		this.sInt = sInt;
	}

	@Override
	public String toString() {
		return "ArrayConversionS [sInteger=" + Arrays.toString(sInteger)
				+ ", sString=" + Arrays.toString(sString) + ", sInt="
				+ Arrays.toString(sInt) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(sInt);
		result = prime * result + Arrays.hashCode(sInteger);
		result = prime * result + Arrays.hashCode(sString);
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
		ArrayConversionS other = (ArrayConversionS) obj;
		if (!Arrays.equals(sInt, other.sInt))
			return false;
		if (!Arrays.equals(sInteger, other.sInteger))
			return false;
		if (!Arrays.equals(sString, other.sString))
			return false;
		return true;
	}
	
	
	
	
}