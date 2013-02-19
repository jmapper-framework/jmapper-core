package com.googlecode.jmapper.integrationtest.operations.bean;


import java.util.LinkedHashMap;

import com.googlecode.jmapper.annotations.JMap;

public class MappedMapS {
	
	public MappedMapS() {}
		
	/**
	 * @param sourceField
	 */
	public MappedMapS(LinkedHashMap<SKeyObj, Integer> sourceField) {
		super();
		this.sourceField = sourceField;
	}

	@JMap("destinationField")
	private LinkedHashMap<SKeyObj, Integer> sourceField;

	public LinkedHashMap<SKeyObj, Integer> getSourceField() {
		return sourceField;
	}

	public void setSourceField(LinkedHashMap<SKeyObj, Integer> sourceField) {
		this.sourceField = sourceField;
	}
	
	
}