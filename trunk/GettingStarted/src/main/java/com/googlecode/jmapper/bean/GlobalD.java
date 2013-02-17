package com.googlecode.jmapper.bean;

import com.googlecode.jmapper.annotations.JGlobalMap;

@JGlobalMap("properties")
public class GlobalD {

	private String author;
	private String framework;
	private String version;
	private String label;
	
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
	
	public GlobalD() {}
	@Override
	public String toString() {
		return "DynamicD:\n author = " + author + "\n framework = " + framework
				+ "\n version = " + version + "\n label = " + label;
	}
	

}
