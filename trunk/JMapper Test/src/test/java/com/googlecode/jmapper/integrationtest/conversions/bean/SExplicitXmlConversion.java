package com.googlecode.jmapper.integrationtest.conversions.bean;


public class SExplicitXmlConversion {

	private Integer sField;
	private Integer sField2;
	private String sField3;
	
	
	/**
	 * @param sField
	 * @param sField2
	 * @param sField3
	 */
	public SExplicitXmlConversion(Integer sField, int sField2, String sField3) {
		super();
		this.sField = sField;
		this.sField2 = sField2;
		this.sField3 = sField3;
	}
	public Integer getSField() {
		return sField;
	}
	public Integer getSField2() {
		return sField2;
	}
	public String getSField3() {
		return sField3;
	}
	@Override
	public String toString() {
		return "SExplicitXmlConversion [sField=" + sField + ", sField2="
				+ sField2 + ", sField3=" + sField3 + "]";
	}
	
	
}
