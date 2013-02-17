package com.googlecode.jmapper.integrationtest.operations.bean;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import com.googlecode.jmapper.annotations.JMap;
public class ObjectS {

	@JMap("objectD")
	private MappedObject objectS;

	public MappedObject getObjectS() {
		return objectS;
	}

	public void setObjectS(MappedObject objectS) {
		this.objectS = objectS;
	}

	
	@Override
	public String toString() {
		return "ObjectS:"+newLine+"objectS=" + objectS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((objectS == null) ? 0 : objectS.hashCode());
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
		ObjectS other = (ObjectS) obj;
		if (objectS == null) {
			if (other.objectS != null)
				return false;
		} else if (!objectS.equals(other.objectS))
			return false;
		return true;
	}

	/**
	 * @param objectS
	 */
	public ObjectS(MappedObject objectS) {
		super();
		this.objectS = objectS;
	}
	
	public ObjectS() {}
}
