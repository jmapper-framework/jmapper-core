package com.googlecode.jmapper.integrationtest.conversions.bean;


import java.util.List;
import java.util.Set;

import com.googlecode.jmapper.annotations.JMapConversion;

public class SExplicitConversion4 {

	private Set<String> sourceList;

	@JMapConversion
	public List<String> conversion(List<String> dest, Set<String> source){
		dest.addAll(source);
		dest.add("CONVERTED");
		return dest;
	}
	
	public Set<String> getSourceList() {
		return sourceList;
	}

	public void setSourceList(Set<String> sourceList) {
		this.sourceList = sourceList;
	}

	@Override
	public String toString() {
		return "SExplicitConversion4 [sourceList=" + sourceList + "]";
	}

	/**
	 * @param sourceList
	 */
	public SExplicitConversion4(Set<String> sourceList) {
		super();
		this.sourceList = sourceList;
	}
	
	public SExplicitConversion4() {}
}
