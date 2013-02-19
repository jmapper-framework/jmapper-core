package com.googlecode.jmapper.integrationtest.operations.bean;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.exceptions.MappingException;

public class OtherTypesS {

	@JMap ChooseConfig config;
	@JMap MappingException exception;
	
	public OtherTypesS() {}
	
	public OtherTypesS(ChooseConfig config, MappingException exception) {
		super();
		this.config = config;
		this.exception = exception;
	}
	
	public ChooseConfig getConfig() {
		return config;
	}
	public void setConfig(ChooseConfig config) {
		this.config = config;
	}
	public Exception getException() {
		return exception;
	}
	public void setException(MappingException exception) {
		this.exception = exception;
	}
}
