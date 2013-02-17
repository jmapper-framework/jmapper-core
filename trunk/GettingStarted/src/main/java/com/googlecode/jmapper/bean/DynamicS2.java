package com.googlecode.jmapper.bean;

import java.util.HashMap;

public class DynamicS2 {

	private HashMap<String, Object> map;

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}
	
	public DynamicS2() {}

	/**
	 * @param map
	 */
	public DynamicS2(HashMap<String, Object> map) {
		super();
		this.map = map;
	}

	@Override
	public String toString() {
		return "DynamicS2:\n map = " + map;
	}
	
	
}
