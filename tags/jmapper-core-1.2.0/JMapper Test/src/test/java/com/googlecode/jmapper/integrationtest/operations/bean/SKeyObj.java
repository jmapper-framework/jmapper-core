package com.googlecode.jmapper.integrationtest.operations.bean;

import com.googlecode.jmapper.annotations.JMap;

public class SKeyObj {

	@JMap("dField")
	private String sField;

	public String getSField() {
		return sField;
	}

	public void setSField(String sField) {
		this.sField = sField;
	}
	
	public SKeyObj() {}

	/**
	 * @param sField
	 */
	public SKeyObj(String sField) {
		super();
		this.sField = sField;
	}
}
