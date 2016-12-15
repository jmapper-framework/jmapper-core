package com.googlecode.jmapper.bean;

import com.googlecode.jmapper.annotations.JMapConversion;


public class SimpleClass {

	public String aField;
	public int aIntField;
	public Integer aIntegerField;
	public String aStringField;
	public Character aCharacterField;
	
	@JMapConversion(from={"aField"},to={"aField"})
	public String conversion(String str){
		return str + " converted";
	}
}
