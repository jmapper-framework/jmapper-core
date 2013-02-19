package com.googlecode.jmapper.integrationtest.conversions.bean;

import com.googlecode.jmapper.annotations.JMapConversion;
import com.googlecode.jmapper.annotations.JMapConversion.Type;

public class SExplicitXmlConversion2 {

	private Integer sField;
	
	public SExplicitXmlConversion2() {}
	
	public SExplicitXmlConversion2(Integer sField) {
		super();
		this.sField = sField;
	}
	
	public Integer getSField() {
		return sField;
	}
	public void setDField(Integer sField) {
		this.sField = sField;
	}
	
	@JMapConversion(from={"sField"},to={"dField"},type=Type.STATIC)
	public Integer secondConversion(Integer dest, Integer source){
		if(dest != null)return dest + source + 100;
		return source + 2000;
	}
}
