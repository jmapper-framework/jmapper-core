package com.googlecode.jmapper.integrationtest.application.bean;


public class Target1 {

	private String commonField1;
	private String commonField2;
	private String specificField1;
	private String specificField2;
	
	public String getCommonField1() {
		return commonField1;
	}
	public void setCommonField1(String commonField1) {
		this.commonField1 = commonField1;
	}
	public String getCommonField2() {
		return commonField2;
	}
	public void setCommonField2(String commonField2) {
		this.commonField2 = commonField2;
	}
	public String getSpecificField1() {
		return specificField1;
	}
	public void setSpecificField1(String specificField1) {
		this.specificField1 = specificField1;
	}
	public String getSpecificField2() {
		return specificField2;
	}
	public void setSpecificField2(String specificField2) {
		this.specificField2 = specificField2;
	}
	@Override
	public String toString() {
		return "Target1 [commonField1=" + commonField1 + ", commonField2="
				+ commonField2 + ", specificField1=" + specificField1
				+ ", specificField2=" + specificField2 + "]";
	}
	
	public Target1() {}
	
	/**
	 * @param commonField1
	 * @param commonField2
	 * @param specificField1
	 * @param specificField2
	 */
	public Target1(String commonField1, String commonField2,
			String specificField1, String specificField2) {
		super();
		this.commonField1 = commonField1;
		this.commonField2 = commonField2;
		this.specificField1 = specificField1;
		this.specificField2 = specificField2;
	}
	
	
}
