package com.googlecode.jmapper.integrationtest.configurations.bean;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapAccessor;
import com.googlecode.jmapper.annotations.JMapAccessors;

public class JMapAccDest3 {
	
	@JMapAccessors({
		@JMapAccessor(name="field",get="getSrcField",set="setSrcField", classes={JMapAccSrc3.class}),
		@JMapAccessor(get="getDestField",set="setDestField")
	})
	@JMap
	private String field;

	public JMapAccDest3() {}
	
	public JMapAccDest3(String field) {
		super();
		this.field = field;
	}

	public String getDestField() {
		return field;
	}

	public void setDestField(String field) {
		this.field = field;
	}
	
	
}
