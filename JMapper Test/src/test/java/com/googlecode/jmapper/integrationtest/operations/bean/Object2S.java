package com.googlecode.jmapper.integrationtest.operations.bean;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import com.googlecode.jmapper.annotations.JMap;

public class Object2S {
	
	@JMap
	private ExtendedObj obj;
	
	public Object2S() {}

	/**
	 * @param obj
	 */
	public Object2S(ExtendedObj obj) {
		super();
		this.obj = obj;
	}

	@Override
	public String toString() {
		return newLine+"Object2S [obj=" + obj + "]";
	}

	public ExtendedObj getObj() {
		return obj;
	}

	public void setObj(ExtendedObj obj) {
		this.obj = obj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((obj == null) ? 0 : obj.hashCode());
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
		Object2S other = (Object2S) obj;
		if (this.obj == null) {
			if (other.obj != null)
				return false;
		} else if (!this.obj.equals(other.obj))
			return false;
		return true;
	}
	
	
		
}