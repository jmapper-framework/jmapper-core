package it.avutils.jmapper.bean;

import it.avutils.jmapper.annotations.JMap;

public class MappedObject2 {
	@JMap("fiel")
	private String field;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	public MappedObject2() {}
}
