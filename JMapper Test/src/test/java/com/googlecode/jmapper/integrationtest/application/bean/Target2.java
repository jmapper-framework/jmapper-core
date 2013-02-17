package com.googlecode.jmapper.integrationtest.application.bean;

public class Target2 {

	private String commonField1;
	private String commonField2;
	private String specificField3;
	private String specificField4;
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
	public String getSpecificField3() {
		return specificField3;
	}
	public void setSpecificField3(String specificField3) {
		this.specificField3 = specificField3;
	}
	public String getSpecificField4() {
		return specificField4;
	}
	public void setSpecificField4(String specificField4) {
		this.specificField4 = specificField4;
	}
	
	public Target2() {}
	/**
	 * @param commonField1
	 * @param commonField2
	 * @param specificField3
	 * @param specificField4
	 */
	public Target2(String commonField1, String commonField2,
			String specificField3, String specificField4) {
		super();
		this.commonField1 = commonField1;
		this.commonField2 = commonField2;
		this.specificField3 = specificField3;
		this.specificField4 = specificField4;
	}
	@Override
	public String toString() {
		return "Target2 [commonField1=" + commonField1 + ", commonField2="
				+ commonField2 + ", specificField3=" + specificField3
				+ ", specificField4=" + specificField4 + "]";
	}
	
	
	
}
