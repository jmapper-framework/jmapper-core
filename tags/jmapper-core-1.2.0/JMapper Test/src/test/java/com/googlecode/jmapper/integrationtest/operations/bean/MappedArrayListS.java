package com.googlecode.jmapper.integrationtest.operations.bean;


import java.util.Set;

import com.googlecode.jmapper.annotations.JMap;

public class MappedArrayListS {
	
	@JMap("targetArray")private Set<MappedArray> mappedSet;
	
	public MappedArrayListS() {}

	/**
	 * @param mappedSet
	 */
	public MappedArrayListS(Set<MappedArray> mappedSet) {
		super();
		this.mappedSet = mappedSet;
	}

	@Override
	public String toString() {
		return "MappedArrayListS [mappedSet=" + mappedSet + "]";
	}

	public Set<MappedArray> getMappedSet() {
		return mappedSet;
	}

	public void setMappedSet(Set<MappedArray> mappedSet) {
		this.mappedSet = mappedSet;
	}
	
	
}