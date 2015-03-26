package com.googlecode.jmapper.integrationtest.configurations.bean;

public class JMapAccSrc {

	private String sField1;
	private String sField2;
	
	public JMapAccSrc() {}
	
	public JMapAccSrc(String sField1, String sField2) {
		super();
		this.sField1 = sField1;
		this.sField2 = sField2;
	}


	public String getsField1() {
		return sField1;
	}
	public void setSField1(String sField1) {
		this.sField1 = sField1;
	}
	public String getSField2() {
		return sField2;
	}
	public void setSsField2(String sField2) {
		this.sField2 = sField2;
	}
	
	
}
