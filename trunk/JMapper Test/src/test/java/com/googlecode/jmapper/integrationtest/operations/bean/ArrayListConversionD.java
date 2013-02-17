package com.googlecode.jmapper.integrationtest.operations.bean;

import java.util.Arrays;

public class ArrayListConversionD {
	
	private String[] stringArray;
	private int[] intArray;
	private char[] charArray;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(charArray);
		result = prime * result + Arrays.hashCode(intArray);
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
		ArrayListConversionD other = (ArrayListConversionD) obj;
		if (!Arrays.equals(charArray, other.charArray))
			return false;
		if (!Arrays.equals(intArray, other.intArray))
			return false;
		if (!Arrays.equals(stringArray, other.stringArray))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ArrayListConversionD [stringArray="
				+ Arrays.toString(stringArray) + ", intArray="
				+ Arrays.toString(intArray) + ", charArray="
				+ Arrays.toString(charArray) + "]";
	}


	public String[] getStringArray() {
		return stringArray;
	}


	public void setStringArray(String[] stringArray) {
		this.stringArray = stringArray;
	}


	public int[] getIntArray() {
		return intArray;
	}


	public void setIntArray(int[] intArray) {
		this.intArray = intArray;
	}


	public char[] getCharArray() {
		return charArray;
	}


	public void setCharArray(char[] charArray) {
		this.charArray = charArray;
	}


	public ArrayListConversionD() {}


	/**
	 * @param stringArray
	 * @param intArray
	 * @param charArray
	 */
	public ArrayListConversionD(String[] stringArray, int[] intArray,
			char[] charArray) {
		super();
		this.stringArray = stringArray;
		this.intArray = intArray;
		this.charArray = charArray;
	}
		
	
}
