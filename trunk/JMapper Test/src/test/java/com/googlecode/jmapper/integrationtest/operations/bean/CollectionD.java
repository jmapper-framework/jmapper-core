package com.googlecode.jmapper.integrationtest.operations.bean;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class CollectionD {

	private Set<String> aSetD;
	private HashSet<String> aHashSetD;
	private ArrayList<String> aArrayListD;
	private List<String> aListD;
	private SortedSet<String> aSortedSetD;
	private LinkedList<String> aLinkedListD;
	private Queue<String> aQueueD;
	private TreeSet<String> aTreeSetD;
	
	public CollectionD() {}

	/**
	 * @param aSetD
	 * @param aHashSetD
	 * @param aArrayListD
	 * @param aListD
	 * @param aSortedSetD
	 * @param aLinkedListD
	 * @param aQueueD
	 * @param aTreeSetD
	 */
	public CollectionD(Set<String> aSetD, HashSet<String> aHashSetD,
			ArrayList<String> aArrayListD, List<String> aListD,
			SortedSet<String> aSortedSetD, LinkedList<String> aLinkedListD,
			Queue<String> aQueueD, TreeSet<String> aTreeSetD) {
		super();
		this.aSetD = aSetD;
		this.aHashSetD = aHashSetD;
		this.aArrayListD = aArrayListD;
		this.aListD = aListD;
		this.aSortedSetD = aSortedSetD;
		this.aLinkedListD = aLinkedListD;
		this.aQueueD = aQueueD;
		this.aTreeSetD = aTreeSetD;
	}




	public List<String> getAListD() {
		return aListD;
	}

	public void setAListD(List<String> aListD) {
		this.aListD = aListD;
	}

	public ArrayList<String> getAArrayListD() {
		return aArrayListD;
	}

	public void setAArrayListD(ArrayList<String> aArrayListD) {
		this.aArrayListD = aArrayListD;
	}

	public Set<String> getASetD() {
		return aSetD;
	}

	public void setASetD(Set<String> aSetD) {
		this.aSetD = aSetD;
	}

	public HashSet<String> getAHashSetD() {
		return aHashSetD;
	}

	public void setAHashSetD(HashSet<String> aHashSetD) {
		this.aHashSetD = aHashSetD;
	}

	public Queue<String> getAQueueD() {
		return aQueueD;
	}

	public void setAQueueD(Queue<String> aQueueD) {
		this.aQueueD = aQueueD;
	}

	public LinkedList<String> getALinkedListD() {
		return aLinkedListD;
	}

	public void setALinkedListD(LinkedList<String> aLinkedListD) {
		this.aLinkedListD = aLinkedListD;
	}

	public SortedSet<String> getASortedSetD() {
		return aSortedSetD;
	}

	public void setASortedSetD(SortedSet<String> aSortedSetD) {
		this.aSortedSetD = aSortedSetD;
	}

	public TreeSet<String> getATreeSetD() {
		return aTreeSetD;
	}

	public void setATreeSetD(TreeSet<String> aTreeSetD) {
		this.aTreeSetD = aTreeSetD;
	}

	@Override
	public String toString() {
		return "CollectionD:"+newLine+" aSetD=" + aSetD +newLine+" aHashSetD=" + aHashSetD
				+newLine+" aArrayListD=" + aArrayListD + newLine+" aListD=" + aListD
				+ newLine+" aSortedSetD=" + aSortedSetD + newLine+" aLinkedListD="
				+ aLinkedListD + newLine+" aQueueD=" + aQueueD + newLine+" aTreeSetD="
				+ aTreeSetD;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aArrayListD == null) ? 0 : aArrayListD.hashCode());
		result = prime * result
				+ ((aHashSetD == null) ? 0 : aHashSetD.hashCode());
		result = prime * result
				+ ((aLinkedListD == null) ? 0 : aLinkedListD.hashCode());
		result = prime * result + ((aListD == null) ? 0 : aListD.hashCode());
		result = prime * result + ((aQueueD == null) ? 0 : aQueueD.hashCode());
		result = prime * result + ((aSetD == null) ? 0 : aSetD.hashCode());
		result = prime * result
				+ ((aSortedSetD == null) ? 0 : aSortedSetD.hashCode());
		result = prime * result
				+ ((aTreeSetD == null) ? 0 : aTreeSetD.hashCode());
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
		CollectionD other = (CollectionD) obj;
		if (aArrayListD == null) {
			if (other.aArrayListD != null)
				return false;
		} else if (!aArrayListD.equals(other.aArrayListD))
			return false;
		if (aHashSetD == null) {
			if (other.aHashSetD != null)
				return false;
		} else if (!aHashSetD.equals(other.aHashSetD))
			return false;
		if (aLinkedListD == null) {
			if (other.aLinkedListD != null)
				return false;
		} else if (!aLinkedListD.equals(other.aLinkedListD))
			return false;
		if (aListD == null) {
			if (other.aListD != null)
				return false;
		} else if (!aListD.equals(other.aListD))
			return false;
		if (aQueueD == null) {
			if (other.aQueueD != null)
				return false;
		} else if (!aQueueD.equals(other.aQueueD))
			return false;
		if (aSetD == null) {
			if (other.aSetD != null)
				return false;
		} else if (!aSetD.equals(other.aSetD))
			return false;
		if (aSortedSetD == null) {
			if (other.aSortedSetD != null)
				return false;
		} else if (!aSortedSetD.equals(other.aSortedSetD))
			return false;
		if (aTreeSetD == null) {
			if (other.aTreeSetD != null)
				return false;
		} else if (!aTreeSetD.equals(other.aTreeSetD))
			return false;
		return true;
	}
	
	
	
}
