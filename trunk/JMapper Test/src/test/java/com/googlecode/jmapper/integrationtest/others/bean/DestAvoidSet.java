package com.googlecode.jmapper.integrationtest.others.bean;

import java.util.ArrayList;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapConversion;
import com.googlecode.jmapper.annotations.JMapConversion.Type;

public class DestAvoidSet {

	@JMap
	private StringBuilder field;

	@JMap
	private ArrayList<String> field2;
	
	public DestAvoidSet() {}
	
	public ArrayList<String> getField2() {
		if(field2 == null) field2 = new ArrayList<String>();
		return field2;
	}

	public StringBuilder getField() {
		if(field == null) field = new StringBuilder();
		return field;
	}

	
	@JMapConversion(from="field",avoidSet=true, type=Type.STATIC)
	public void conversion(StringBuilder dest, StringBuilder src){
		dest.append(src);
	}
	
	@JMapConversion(from="field2",type=Type.DYNAMIC,avoidSet=true)
	public static String conversion2(){
		return "${destination}.add(\"avoidSetDYNAMIC\" + ${source}.toString());";
	}
}
