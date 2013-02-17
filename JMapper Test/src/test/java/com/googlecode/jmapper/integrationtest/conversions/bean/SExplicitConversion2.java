package com.googlecode.jmapper.integrationtest.conversions.bean;

import com.googlecode.jmapper.annotations.JMapConversion;

public class SExplicitConversion2 {

	private String sfield;
	private String sfield2;
	
	public void setSfield(String sfield) {
		this.sfield = sfield;
	}

	public String getSfield() {
		return sfield;
	}
	
	
	public String getSfield2() {
		return sfield2;
	}

	public void setSfield2(String sfield2) {
		this.sfield2 = sfield2;
	}

	@JMapConversion (from = {"sfield"},to={"field1","field2"})
//	@JMapConversion (from = {"sfield"})			It's equal
	public String conversion (String source){
		return source +" converted";
	}

	@JMapConversion (from = {"sfield2"},to={"field1","field2"})
	public String conversion2(String source){
		return source +" converted";
	}
	
	public SExplicitConversion2(String sfield) {
		super();
		this.sfield = sfield;
	}

	public SExplicitConversion2() {}
	
	
	
}
