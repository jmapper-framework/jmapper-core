package com.googlecode.jmapper.bean;

import com.googlecode.jmapper.annotations.JMapAccessor;

public class JMapAccessorSrc {
	@JMapAccessor(get="ID")
	private String id;
	@JMapAccessor(get="getSrcField")
	private String sourceField;
	private String other;
	
	// getter and setter...
	
	public JMapAccessorSrc(String id, String sourceField, String other) {
		super();
		this.id = id;
		this.sourceField = sourceField;
		this.other = other;
	}

	public JMapAccessorSrc() {}
	
	public String ID() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSrcField() {
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
		return "Source [id=" + id + ", sourceField=" + sourceField + ", other="
				+ other + "]";
	}
	
	
}
