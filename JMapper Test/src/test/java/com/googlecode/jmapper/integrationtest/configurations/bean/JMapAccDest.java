package com.googlecode.jmapper.integrationtest.configurations.bean;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapAccessor;

public class JMapAccDest {

	@JMap("sField1")
	@JMapAccessor(get="getDestField",set="setDestField1")
	private String dField1;
	@JMap("sField2")
	@JMapAccessor(get="getDestField2",set="setDestField2")
	private String dField2;
	
	public JMapAccDest() {}
	
	public JMapAccDest(String dField1, String dField2) {
		super();
		this.dField1 = dField1;
		this.dField2 = dField2;
	}
	public String getDestField1() {
		return dField1;
	}
	public void setDestField1(String dField1) {
		this.dField1 = dField1;
	}
	public String getDestField2() {
		return dField2;
	}
	public void setDestField2(String dField2) {
		this.dField2 = dField2;
	}
	
	
}
