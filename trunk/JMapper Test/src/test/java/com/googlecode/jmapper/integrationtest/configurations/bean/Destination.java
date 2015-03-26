package com.googlecode.jmapper.integrationtest.configurations.bean;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapAccessor;
import com.googlecode.jmapper.annotations.JMapAccessors;

public class Destination {

	@JMap("srcField1")
	@JMapAccessors({
		@JMapAccessor(name="srcField1",set="setField1",get="nonLoLegge"),
		@JMapAccessor(get="getField1")
	})
	private String destField1;
	
	@JMap("srcField2")
	@JMapAccessor(name="destField2",get="getField2",set="setField2")
	private String destField2;

	public Destination() {}
	
	public Destination(String destField1, String destField2) {
		super();
		this.destField1 = destField1;
		this.destField2 = destField2;
	}

	public String getField1() {
		return destField1;
	}

	public void setDestField1(String destField1) {
		this.destField1 = destField1;
	}

	public String getField2() {
		return destField2;
	}

	public void setField2(String destField2) {
		this.destField2 = destField2;
	}
	
	
	
}
