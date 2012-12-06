package it.avutils.jmapper.bean;

import it.avutils.jmapper.annotations.JMapConversion;


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
