package com.googlecode.jmapper.integrationtest.operations.bean;


import java.util.Arrays;

import com.googlecode.jmapper.annotations.JMap;

public class ArrayS {
	
	@JMap("dString")
	private String[] sString;
	@JMap("dInteger")
	private Integer[] sInteger;
	@JMap("dCharacter")
	private Character[] sCharacter;
	
	public ArrayS() {}

	/**
	 * @param sString
	 * @param sInteger
	 * @param sCharacter
	 */
	public ArrayS(String[] sString, Integer[] sInteger, Character[] sCharacter) {
		super();
		this.sString = sString;
		this.sInteger = sInteger;
		this.sCharacter = sCharacter;
	}

	public String[] getSString() {
		return sString;
	}

	public void setSString(String[] sString) {
		this.sString = sString;
	}

	public Integer[] getSInteger() {
		return sInteger;
	}

	public void setSInteger(Integer[] sInteger) {
		this.sInteger = sInteger;
	}

	public Character[] getSCharacter() {
		return sCharacter;
	}

	public void setSCharacter(Character[] sCharacter) {
		this.sCharacter = sCharacter;
	}

	@Override
	public String toString() {
		return "ArrayS [sString=" + Arrays.toString(sString) + ", sInteger="
				+ Arrays.toString(sInteger) + ", sCharacter="
				+ Arrays.toString(sCharacter) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(sCharacter);
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
		ArrayS other = (ArrayS) obj;
		if (!Arrays.equals(sCharacter, other.sCharacter))
			return false;
		if (!Arrays.equals(sInteger, other.sInteger))
			return false;
		if (!Arrays.equals(sString, other.sString))
			return false;
		return true;
	}
		
	
}