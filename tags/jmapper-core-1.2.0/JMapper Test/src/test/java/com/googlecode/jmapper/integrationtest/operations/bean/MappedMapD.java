package com.googlecode.jmapper.integrationtest.operations.bean;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.util.HashMap;
import java.util.Map.Entry;

public class MappedMapD {
	
	public MappedMapD() {}
		
	/**
	 * @param destinationField
	 */
	public MappedMapD(HashMap<DKeyObj, String> destinationField) {
		super();
		this.destinationField = destinationField;
	}

	private HashMap<DKeyObj, String> destinationField;

	public HashMap<DKeyObj, String> getDestinationField() {
		return destinationField;
	}

	public void setDestinationField(HashMap<DKeyObj, String> destinationField) {
		this.destinationField = destinationField;
	}

	@Override
	public String toString() {
		String result = newLine+"MappedMapD:"+newLine;
		for (Entry<DKeyObj, String> it : destinationField.entrySet()) 
			result+="key("+it.getKey()+") value("+it.getValue()+")"+newLine;
		
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((destinationField == null) ? 0 : destinationField.hashCode());
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
		MappedMapD other = (MappedMapD) obj;
		if (destinationField == null) {
			if (other.destinationField != null)
				return false;
		} else if (!destinationField.equals(other.destinationField))
			return false;
		return true;
	}
	
	
}
