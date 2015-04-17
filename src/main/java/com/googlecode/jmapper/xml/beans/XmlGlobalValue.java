package com.googlecode.jmapper.xml.beans;

import static com.googlecode.jmapper.config.Constants.DEFAULT_ACCESSOR_VALUE;

import com.googlecode.jmapper.xml.SimplyAttribute;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class XmlGlobalValue {
	/** name attribute of attribute node */
	@XStreamAsAttribute
	public String name;
	/** get attribute */
	@XStreamAsAttribute
	public String get;
	/** set attribute */
	@XStreamAsAttribute
	public String set;
	
	public XmlGlobalValue() {}
	
	public XmlGlobalValue(String name) {
		this.name = name;
	}
	
	
	public XmlGlobalValue(String name, String get, String set) {
		super();
		this.name = name;
		this.get = get;
		this.set = set;
	}


	public XmlGlobalValue(SimplyAttribute attribute) {
		name = attribute.getName();
		get = attribute.getGet();
		set = attribute.getSet();
	}

	@Override
	public String toString() {
		
		String result = "<value name =\""+name+"\"";
		if(get != null && !DEFAULT_ACCESSOR_VALUE.equals(get))
			result+=" get =\""+get+"\"";
		
		if(set != null && !DEFAULT_ACCESSOR_VALUE.equals(set))
			result+=" set =\""+set+"\"";
		
		return result+=" />";
	}
}
