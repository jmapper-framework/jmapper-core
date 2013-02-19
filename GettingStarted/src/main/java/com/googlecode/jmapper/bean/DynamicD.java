package com.googlecode.jmapper.bean;

import com.googlecode.jmapper.annotations.JMap;

public class DynamicD {

	@JMap("properties") private String author;
	@JMap("properties") private String framework;
	@JMap("properties") private String version;
	@JMap("properties") private String label;
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getFramework() {
		return framework;
	}
	public void setFramework(String framework) {
		this.framework = framework;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public DynamicD() {}
	@Override
	public String toString() {
		return "DynamicD:\n author = " + author + "\n framework = " + framework
				+ "\n version = " + version + "\n label = " + label;
	}
	
	
}
