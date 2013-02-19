package com.googlecode.jmapper.bean;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.googlecode.jmapper.annotations.JMapConversion;

public class StaticS {

	private String startDate;
	private String endDate;
	
	@JMapConversion
	public java.util.Date toDate(String source) throws ParseException{
		return new SimpleDateFormat("dd/MM/yyyy").parse(source);
	}
	
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	
	/**
	 * @param startDate
	 * @param endDate
	 */
	public StaticS(String startDate, String endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	
}
