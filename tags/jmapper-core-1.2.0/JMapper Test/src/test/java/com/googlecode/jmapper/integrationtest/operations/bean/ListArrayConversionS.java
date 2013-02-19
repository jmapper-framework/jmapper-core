package com.googlecode.jmapper.integrationtest.operations.bean;

import java.util.Arrays;

import com.googlecode.jmapper.annotations.JMap;


public class ListArrayConversionS {

	@JMap("longList")private String[] stringArray;
	@JMap("integerList")private int[] intArray;
	@JMap("stringList")private char[] charArray;

	public ListArrayConversionS() {}

	/**
	 * @param stringArray
	 * @param intArray
	 * @param charArray
	 */
	public ListArrayConversionS(String[] stringArray, int[] intArray,
			char[] charArray) {
		super();
		this.stringArray = stringArray;
		this.intArray = intArray;
		this.charArray = charArray;
	}

	@Override
	public String toString() {
		return "ListArrayConversionS [stringArray="
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
		
	
}