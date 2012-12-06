package it.avutils.jmapper.bean;

import it.avutils.jmapper.annotations.JMap;

public class MappedObject {

	@JMap
	private String field;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	public MappedObject() {}
}
