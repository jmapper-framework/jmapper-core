package com.googlecode.jmapper.integrationtest.conversions.bean;

import com.googlecode.jmapper.annotations.JMapConversion;

public class SExplicitConversion3 {

	private String sfield;
	
	
	public void setSfield(String sfield) {
		this.sfield = sfield;
	}

	public String getSfield() {
		return sfield;
	}
	
	@JMapConversion (from = {"sfield"},to={"field1","field2","field3"})
//	@JMapConversion (from = {"sfield"})			It's equal
	public String conversion (String destination, String source){
		return destination + source +" converted";
	}

	
	public SExplicitConversion3(String sfield) {
		super();
		this.sfield = sfield;
	}

	public SExplicitConversion3() {}
	
	
	
}