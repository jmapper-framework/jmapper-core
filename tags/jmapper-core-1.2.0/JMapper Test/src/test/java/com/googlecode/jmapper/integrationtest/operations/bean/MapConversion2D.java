package com.googlecode.jmapper.integrationtest.operations.bean;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.util.Map;

public class MapConversion2D {
	
	private Map<DKeyObj, String> dField;
		
	public MapConversion2D() {}

	/**
	 * @param dField
	 */
	public MapConversion2D(Map<DKeyObj, String> dField) {
		super();
		this.dField = dField;
	}

	public Map<DKeyObj, String> getDField() {
		return dField;
	}

	public void setDField(Map<DKeyObj, String> dField) {
		this.dField = dField;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dField == null) ? 0 : dField.hashCode());
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
		MapConversion2D other = (MapConversion2D) obj;
		if (dField == null) {
			if (other.dField != null)
				return false;
		} else if (!dField.equals(other.dField))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return newLine+"MapConversion2D [dField=" + dField + "]";
	}
	
	
}
