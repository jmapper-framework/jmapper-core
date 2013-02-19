package com.googlecode.jmapper.integrationtest.operations.bean;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;
public class ObjectD {

	private TargetObject objectD;

	public TargetObject getObjectD() {
		return objectD;
	}

	public void setObjectD(TargetObject objectD) {
		this.objectD = objectD;
	}

	@Override
	public String toString() {
		return "ObjectD:"+newLine+"objectD=" + objectD;
	}
	
	public ObjectD() {}

	/**
	 * @param objectD
	 */
	public ObjectD(TargetObject objectD) {
		super();
		this.objectD = objectD;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((objectD == null) ? 0 : objectD.hashCode());
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
		ObjectD other = (ObjectD) obj;
		if (objectD == null) {
			if (other.objectD != null)
				return false;
		} else if (!objectD.equals(other.objectD))
			return false;
		return true;
	}
	
	
}
