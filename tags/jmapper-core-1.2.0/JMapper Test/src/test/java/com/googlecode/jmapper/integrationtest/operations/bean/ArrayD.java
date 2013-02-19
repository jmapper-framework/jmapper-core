package com.googlecode.jmapper.integrationtest.operations.bean;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.util.Arrays;

public class ArrayD {
	
	private String[] dString;
	private Integer[] dInteger;
	private Character[] dCharacter;
	
	public ArrayD() {}

	/**
	 * @param dString
	 * @param dInteger
	 * @param dCharacter
	 */
	public ArrayD(String[] dString, Integer[] dInteger, Character[] dCharacter) {
		super();
		this.dString = dString;
		this.dInteger = dInteger;
		this.dCharacter = dCharacter;
	}

	public String[] getDString() {
		return dString;
	}

	public void setDString(String[] dString) {
		this.dString = dString;
	}

	public Integer[] getDInteger() {
		return dInteger;
	}

	public void setDInteger(Integer[] dInteger) {
		this.dInteger = dInteger;
	}

	public Character[] getDCharacter() {
		return dCharacter;
	}

	public void setDCharacter(Character[] dCharacter) {
		this.dCharacter = dCharacter;
	}

	@Override
	public String toString() {
		return newLine+"ArrayD [dString=" + Arrays.toString(dString) + ", dInteger="
				+ Arrays.toString(dInteger) + ", dCharacter="
				+ Arrays.toString(dCharacter) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(dCharacter);
		result = prime * result + Arrays.hashCode(dInteger);
		result = prime * result + Arrays.hashCode(dString);
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
		ArrayD other = (ArrayD) obj;
		if (!Arrays.equals(dCharacter, other.dCharacter))
			return false;
		if (!Arrays.equals(dInteger, other.dInteger))
			return false;
		if (!Arrays.equals(dString, other.dString))
			return false;
		return true;
	}
	
	
}
