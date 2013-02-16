package com.googlecode.jmapper.bean;

import com.googlecode.jmapper.annotations.JMapConversion;


public class SimpleClass {

	String aField;
	int aIntField;
	Integer aIntegerField;
	String aStringField;

	@JMapConversion(from={"aField"},to={"aField"})
	public String conversion(String str){
		return str + " converted";
	}
}
