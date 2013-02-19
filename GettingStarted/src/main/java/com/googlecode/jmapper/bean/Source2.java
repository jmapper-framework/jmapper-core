package com.googlecode.jmapper.bean;

import com.googlecode.jmapper.annotations.JMap;

public class Source2 {

	@JMap
	private String id;
	@JMap("destinationField")
	private String sourceField;
	private String other;
	
	// getter and setter...
	
	
	
	public Source2(String id, String sourceField, String other) {
		super();
		this.id = id;
		this.sourceField = sourceField;
		this.other = other;
	}

	public Source2() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSourceField() {
		return sourceField;
	}
	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return "Source2 [id=" + id + ", sourceField=" + sourceField + ", other="
				+ other + "]";
	}
	
	
}
