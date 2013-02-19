package com.googlecode.jmapper.bean;

import java.util.Arrays;
import java.util.Date;

import com.googlecode.jmapper.annotations.JGlobalMap;

@JGlobalMap(excluded={"other"})
public class GlobalD {

	private String[] authors;
	private Date releaseDate;
	private String releaseVersion;
	private String other;
	
	public String[] getAuthors() {
		return authors;
	}
	public void setAuthors(String[] authors) {
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
	@Override
	public String toString() {
		return "GlobalD [authors=" + Arrays.toString(authors)
				+ ", releaseDate=" + releaseDate + ", releaseVersion="
				+ releaseVersion + ", other=" + other + "]";
	}
	
	

}
