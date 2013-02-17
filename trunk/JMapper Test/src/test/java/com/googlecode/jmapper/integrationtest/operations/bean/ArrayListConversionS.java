package com.googlecode.jmapper.integrationtest.operations.bean;


import java.util.List;

import com.googlecode.jmapper.annotations.JMap;

public class ArrayListConversionS {
	
	@JMap("stringArray") private List<Long> longList;
	@JMap("intArray") private List<Integer> integerList;
	@JMap("charArray") private List<String> stringList;
	
	
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


	public ArrayListConversionS() {}


	/**
	 * @param longList
	 * @param integerList
	 * @param stringList
	 */
	public ArrayListConversionS(List<Long> longList, List<Integer> integerList,
			List<String> stringList) {
		super();
		this.longList = longList;
		this.integerList = integerList;
		this.stringList = stringList;
	}
		
	
}