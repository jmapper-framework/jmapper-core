package com.googlecode.jmapper.integrationtest.operations.bean;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.util.List;

public class MappedCollectionD {

	private List<TargetObject> aTargetList;

	public MappedCollectionD(List<TargetObject> aTargetList) {
		super();
		this.aTargetList = aTargetList;
	}

	public MappedCollectionD() {}
	
	public List<TargetObject> getATargetList() {
		return aTargetList;
	}

	public void setATargetList(List<TargetObject> aTargetList) {
		this.aTargetList = aTargetList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aTargetList == null) ? 0 : aTargetList.hashCode());
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
		MappedCollectionD other = (MappedCollectionD) obj;
		if (aTargetList == null) {
			if (other.aTargetList != null)
				return false;
		} else if (!aTargetList.equals(other.aTargetList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MappedCollectionD:"+newLine+"aTargetList=" + aTargetList;
	}
	
	
}
