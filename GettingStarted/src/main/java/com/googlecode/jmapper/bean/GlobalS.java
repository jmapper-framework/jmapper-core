package com.googlecode.jmapper.bean;

import java.util.Date;
import java.util.List;

public class GlobalS {

	private List<String> authors;
	private Date releaseDate;
	private String releaseVersion;
	private String other;
	
	public GlobalS() {}
	
	public GlobalS(List<String> authors, Date releaseDate, String releaseVersion,
			String other) {
		super();
		this.authors = authors;
		this.releaseDate = releaseDate;
		this.releaseVersion = releaseVersion;
		this.other = other;
	}

	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getReleaseVersion() {
		return releaseVersion;
	}
	public void setReleaseVersion(String releaseVersion) {
		this.releaseVersion = releaseVersion;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	
	
}
