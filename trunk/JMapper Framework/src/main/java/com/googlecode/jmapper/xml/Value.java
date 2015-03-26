package com.googlecode.jmapper.xml;

import com.googlecode.jmapper.xml.beans.XmlValueName;

public class Value {

	private String name;
	private String get;
	private String set;
	
	public Value(XmlValueName value) {
		this.name = value.name;
		this.get = value.get;
		this.set = value.set;
	}
	
	public Value(String name) {
		super();
		this.name = name;
	}

	public Value(String name, String get, String set) {
		super();
		this.name = name;
		this.get = get;
		this.set = set;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGet() {
		return get;
	}
	public void setGet(String get) {
		this.get = get;
	}
	public String getSet() {
		return set;
	}
	public void setSet(String set) {
		this.set = set;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((get == null) ? 0 : get.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((set == null) ? 0 : set.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Value other = (Value) obj;
		if (get == null) {
			if (other.get != null)
				return false;
		} else if (!get.equals(other.get))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (set == null) {
			if (other.set != null)
				return false;
		} else if (!set.equals(other.set))
			return false;
		return true;
	}
	
	
}
