package com.googlecode.jmapper.integrationtest.operations.bean;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.util.Arrays;

public class ArrayConversionD {
	
	private String[] dString;
	private Integer[] dInteger;
	private Double[] dCharacter;
	
	public ArrayConversionD() {}

	/**
	 * @param dString
	 * @param dInteger
	 * @param dCharacter
	 */
	public ArrayConversionD(String[] dString, Integer[] dInteger,
			Double[] dCharacter) {
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

	public Double[] getDCharacter() {
		return dCharacter;
	}

	public void setDCharacter(Double[] dCharacter) {
		this.dCharacter = dCharacter;
	}

	@Override
	public String toString() {
		return newLine+"ArrayConversionD [dString=" + Arrays.toString(dString)
				+ ", dInteger=" + Arrays.toString(dInteger) + ", dCharacter="
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
		ArrayConversionD other = (ArrayConversionD) obj;
		if (!Arrays.equals(dCharacter, other.dCharacter))
			return false;
		if (!Arrays.equals(dInteger, other.dInteger))
			return false;
		if (!Arrays.equals(dString, other.dString))
			return false;
		return true;
	}
		
	
}
