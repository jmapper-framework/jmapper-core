package com.googlecode.jmapper.integrationtest.operations.bean;

import java.sql.Date;

public class UndefinedS {

	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public UndefinedS() {}

	/**
	 * @param date
	 */
	public UndefinedS(Date date) {
		super();
		this.date = date;
	}

	@Override
	public String toString() {
		return "UndefinedS [date=" + date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		UndefinedS other = (UndefinedS) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}
	
	
}
