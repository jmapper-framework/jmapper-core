package com.googlecode.jmapper.integrationtest.conversions.bean;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapConversion;

public class DExplicitConversion {

	@JMap
	private String field;

	@JMapConversion(from={"field"},to={"field"})
	public String conversion(Integer integer){
		return integer + " explicit converted";
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((field == null) ? 0 : field.hashCode());
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
		DExplicitConversion other = (DExplicitConversion) obj;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return field;
	}


	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	public DExplicitConversion() {}

	public DExplicitConversion(String field) {
		super();
		this.field = field;
	}
	
	
}
