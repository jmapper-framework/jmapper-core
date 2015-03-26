package com.googlecode.jmapper.integrationtest.configurations.bean;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapAccessor;

public class Source {

	
	@JMap("destField1")
	@JMapAccessor(get="getField1")
	private String srcField1;
	
	@JMap("destField2")
	@JMapAccessor(name="srcField2",set="setField2")
	private String srcField2;

	public Source() {}
	
	
	public Source(String srcField1, String srcField2) {
		super();
		this.srcField1 = srcField1;
		this.srcField2 = srcField2;
	}


	public String getField1() {
		return srcField1;
	}

	public void setField1(String srcField1) {
		this.srcField1 = srcField1;
	}

	public String getSrcField2() {
		return srcField2;
	}

	public void setField2(String srcField2) {
		this.srcField2 = srcField2;
	}
	
	
}
