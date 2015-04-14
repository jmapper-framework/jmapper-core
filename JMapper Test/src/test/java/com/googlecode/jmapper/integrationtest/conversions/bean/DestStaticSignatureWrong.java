package com.googlecode.jmapper.integrationtest.conversions.bean;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapConversion;
import com.googlecode.jmapper.annotations.JMapConversion.Type;

public class DestStaticSignatureWrong {

	@JMap
	private StringBuilder field;

	@JMap
	private StringBuilder field2;
	
	public DestStaticSignatureWrong() {}
	
	public StringBuilder getField2() {
		return field2;
	}


	public void setField2(StringBuilder field2) {
		this.field2 = field2;
	}


	public StringBuilder getField() {
		return field;
	}

	
	@JMapConversion(from="field",avoidSet=true, type=Type.STATIC)
	public StringBuilder conversion(StringBuilder dest, String src){
		dest = new StringBuilder("avoidSet");
		return dest;
	}
}
