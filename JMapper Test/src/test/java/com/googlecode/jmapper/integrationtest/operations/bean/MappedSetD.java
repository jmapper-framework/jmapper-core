package com.googlecode.jmapper.integrationtest.operations.bean;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.util.Set;

public class MappedSetD {
	
	private Set<TargetObject> aTargetList;

	public MappedSetD(Set<TargetObject> aTargetList) {
		super();
		this.aTargetList = aTargetList;
	}

	public MappedSetD() {}
	
	public Set<TargetObject> getATargetList() {
		return aTargetList;
	}

	public void setATargetList(Set<TargetObject> aTargetList) {
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
		MappedSetD other = (MappedSetD) obj;
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
