package com.googlecode.jmapper.bean;

import com.googlecode.jmapper.annotations.JMap;

public class Destination3 {

	@JMap
	private String id;
	@JMap("sourceField")	
	private String destinationField;
	private String other;
	
	// getter and setter...
	
	
	public Destination3() {}
	
	public Destination3(String id, String destinationField, String other) {
		super();
		this.id = id;
		this.destinationField = destinationField;
		this.other = other;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDestinationField() {
		return destinationField;
	}
	public void setDestinationField(String destinationField) {
		this.destinationField = destinationField;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return "Destination3 [id=" + id + ", destinationField="
				+ destinationField + ", other=" + other + "]";
	}
	
}
