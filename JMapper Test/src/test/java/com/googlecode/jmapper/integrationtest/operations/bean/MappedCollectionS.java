package com.googlecode.jmapper.integrationtest.operations.bean;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.util.Set;

import com.googlecode.jmapper.annotations.JMap;

public class MappedCollectionS {

	@JMap("aTargetList")
	private Set<MappedObject> aMappedSet;

	public Set<MappedObject> getAMappedSet() {
		return aMappedSet;
	}

	public void setAMappedSet(Set<MappedObject> aMappedSet) {
		this.aMappedSet = aMappedSet;
	}

	public MappedCollectionS(Set<MappedObject> aMappedSet) {
		super();
		this.aMappedSet = aMappedSet;
	}
	
	public MappedCollectionS() {}

	@Override
	public String toString() {
		return "MappedCollectionS:"+newLine+"aMappedSet=" + aMappedSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aMappedSet == null) ? 0 : aMappedSet.hashCode());
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
		MappedCollectionS other = (MappedCollectionS) obj;
		if (aMappedSet == null) {
			if (other.aMappedSet != null)
				return false;
		} else if (!aMappedSet.equals(other.aMappedSet))
			return false;
		return true;
	}
	
	
}
