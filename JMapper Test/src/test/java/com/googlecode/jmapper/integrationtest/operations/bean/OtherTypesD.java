package com.googlecode.jmapper.integrationtest.operations.bean;

import com.googlecode.jmapper.enums.ChooseConfig;

public class OtherTypesD {

	ChooseConfig config;
	Exception exception;
	
	public OtherTypesD() {}
	
	public OtherTypesD(ChooseConfig config, Exception exception) {
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
	public void setException(Exception exception) {
		this.exception = exception;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((config == null) ? 0 : config.hashCode());
		result = prime * result
				+ ((exception == null) ? 0 : exception.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OtherTypesD other = (OtherTypesD) obj;
		if (config != other.config)
			return false;
		if (exception == null) {
			if (other.exception != null)
				return false;
		} else if (!exception.getClass().equals(other.exception.getClass()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OtherTypesD [config=" + config + ", exception=" + exception
				+ "]";
	}
	
	
}
