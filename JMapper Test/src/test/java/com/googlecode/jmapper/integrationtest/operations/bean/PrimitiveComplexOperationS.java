package com.googlecode.jmapper.integrationtest.operations.bean;

import java.util.HashMap;
import java.util.Map;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapConversion;
import com.googlecode.jmapper.annotations.JMapConversion.Type;

public class PrimitiveComplexOperationS {
	 
	@JMap("longField")
	private HashMap<String, Object> attributes;

	public PrimitiveComplexOperationS() {}
	
	public PrimitiveComplexOperationS(HashMap<String, Object> attributes) {
		super();
		this.attributes = attributes;
		
	}

	public HashMap<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(HashMap<String, Object> attributes) {
		this.attributes = attributes;
	}

	@JMapConversion(from={"attributes"}, to={"longField"}, type=Type.DYNAMIC)
	public static String dynamicConversion(){
		return 	"Object value = ${source}.get(\"${destination.name}\");"+
				"if (value instanceof java.lang.Long){"+
                     "return (long)((java.lang.Long)value).longValue();}"+
                "if (value instanceof java.lang.Integer){"+
                     "return (long)((java.lang.Integer)value).longValue();}"+
				"return 0L;";
//		return "return ((${destination.type}) ${source}.get(\"${destination.name}\"));";
	
	}
}