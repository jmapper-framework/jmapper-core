package com.googlecode.jmapper.bean;


import java.util.Date;

import com.googlecode.jmapper.annotations.JGlobalMap;

@JGlobalMap
public class StaticD {

	private Date startDate;
	private Date endDate;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public StaticD() {}
	
	@Override
	public String toString() {
		return "StaticD [startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}
	
	
	
}
