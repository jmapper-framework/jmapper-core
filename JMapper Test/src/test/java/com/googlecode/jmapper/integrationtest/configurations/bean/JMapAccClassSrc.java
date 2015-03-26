package com.googlecode.jmapper.integrationtest.configurations.bean;

import com.googlecode.jmapper.annotations.JMapAccessor;

public class JMapAccClassSrc {
	
	private String sField1;
	
	@JMapAccessor(get="getSSField2")
	private String sField2;
	
	public JMapAccClassSrc() {}
	
	public JMapAccClassSrc(String sField1, String sField2) {
		super();
		this.sField1 = sField1;
		this.sField2 = sField2;
	}


	public String getSSField1() {
		return sField1;
	}
	public void setSField1(String sField1) {
		this.sField1 = sField1;
	}
	public String getSSField2() {
		return sField2;
	}
	public void setSsField2(String sField2) {
		this.sField2 = sField2;
	}
	
	
}
