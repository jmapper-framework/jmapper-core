package com.googlecode.jmapper.bean;

import java.util.Properties;

import com.googlecode.jmapper.annotations.JMapConversion;
import com.googlecode.jmapper.annotations.JMapConversion.Type;

public class GlobalS {

private Properties properties;
	
	@JMapConversion(from={"properties"},type=Type.DYNAMIC)
	public static String conversion(){
		return "return ((String) ${source}.get(\"${destination.name}\")) + \" ANNOTATION\";";
	}
	
	public Properties getProperties() {
		return properties;
	}

	public GlobalS() {}

	public GlobalS(Properties properties) {
		super();
		this.properties = properties;
	}

}
