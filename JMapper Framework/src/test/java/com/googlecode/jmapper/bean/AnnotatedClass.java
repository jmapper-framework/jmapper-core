package com.googlecode.jmapper.bean;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapConversion;

public class AnnotatedClass {

	@JMap(attributes={"","targetField2"},classes={SimpleClass.class,ComplexClass.class})
	String field;
	
	@JMap("targetField1")
	String field2;
	
	@JMapConversion(from={"source"},to={"destination"},type = JMapConversion.Type.STATIC)
	public void get(String source){}
}
