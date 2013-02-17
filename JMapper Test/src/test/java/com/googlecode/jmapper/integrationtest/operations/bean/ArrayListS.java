package com.googlecode.jmapper.integrationtest.operations.bean;


import java.util.Date;
import java.util.List;

import com.googlecode.jmapper.annotations.JMap;

public class ArrayListS {
	
	@JMap("stringArray") private List<String> stringList;
	@JMap("integerArray") private List<Integer> integerList;
	@JMap("dateArray") private List<Date> dateList;
	
	
	@Override
	public String toString() {
		return "ArrayListS [stringList=" + stringList + ", integerList="
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


	public ArrayListS() {}

	public ArrayListS(List<String> stringList, List<Integer> integerList,
			List<Date> dateList) {
		super();
		this.stringList = stringList;
		this.integerList = integerList;
		this.dateList = dateList;
	}
		
	
}