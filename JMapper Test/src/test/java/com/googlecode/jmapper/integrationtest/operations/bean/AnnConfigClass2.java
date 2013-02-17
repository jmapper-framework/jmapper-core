package com.googlecode.jmapper.integrationtest.operations.bean;

import com.googlecode.jmapper.annotations.JMap;

public class AnnConfigClass2 {

	@JMap("targetField")
	String errorField1;
	
	@JMap(value = "targetField",classes={TargetClass.class})
	String errorField2;
	
	@JMap(attributes={"targetField","other"},classes={TargetClass.class})
	String errorField3;

	@JMap(attributes={"targetField"},classes={BeanD.class})
	String errorField4;
	
	@JMap(attributes={"targetField"},classes={TargetClass.class})
	String errorField5;
	
	@JMap(attributes={"targetField","other","other2"})
	String errorField6;

}
