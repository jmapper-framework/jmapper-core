package com.googlecode.jmapper.integrationtest.operations.bean;

import java.util.Set;

public class MappedListArrayD {
	
	private Set<TargetArray> targetSet;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((targetSet == null) ? 0 : targetSet.hashCode());
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
		MappedListArrayD other = (MappedListArrayD) obj;
		if (targetSet == null) {
			if (other.targetSet != null)
				return false;
		} else if (!targetSet.equals(other.targetSet))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "MappedListArrayD [targetSet=" + targetSet + "]";
	}


	/**
	 * @param targetSet
	 */
	public MappedListArrayD(Set<TargetArray> targetSet) {
		super();
		this.targetSet = targetSet;
	}


	public Set<TargetArray> getTargetSet() {
		return targetSet;
	}


	public void setTargetSet(Set<TargetArray> targetSet) {
		this.targetSet = targetSet;
	}


	public MappedListArrayD() {}
		
}
