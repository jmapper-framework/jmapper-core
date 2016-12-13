package com.googlecode.jmapper.bean;

import com.googlecode.jmapper.annotations.JMap;

public class MappedObject2 {
	@JMap("fiel")
	private String field;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
}
