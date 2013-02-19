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

import com.googlecode.jmapper.annotations.JMap;

public class CollectionS {

	@JMap("aSetD")
	private List<String> aListS;
	@JMap("aHashSetD")
	private ArrayList<String> aArrayListS;
	@JMap("aArrayListD")
	private Set<String> aSetS;
	@JMap("aListD")
	private HashSet<String> aHashSetS;
	@JMap("aSortedSetD")
	private Queue<String> aQueueS;
	@JMap("aLinkedListD")
	private LinkedList<String> aLinkedListS;
	@JMap("aQueueD")
	private SortedSet<String> aSortedSetS;
	@JMap("aTreeSetD")
	private TreeSet<String> aTreeSetS;
	/**
	 * @param aListS
	 * @param aArrayListS
	 * @param aSetS
	 * @param aHashSetS
	 * @param aQueueS
	 * @param aLinkedListS
	 * @param aSortedSetS
	 * @param aTreeSetS
	 */
	public CollectionS(List<String> aListS, ArrayList<String> aArrayListS,
			Set<String> aSetS, HashSet<String> aHashSetS,
			Queue<String> aQueueS, LinkedList<String> aLinkedListS,
			SortedSet<String> aSortedSetS, TreeSet<String> aTreeSetS) {
		super();
		this.aListS = aListS;
		this.aArrayListS = aArrayListS;
		this.aSetS = aSetS;
		this.aHashSetS = aHashSetS;
		this.aQueueS = aQueueS;
		this.aLinkedListS = aLinkedListS;
		this.aSortedSetS = aSortedSetS;
		this.aTreeSetS = aTreeSetS;
	}
	public List<String> getAListS() {
		return aListS;
	}
	public void setAListS(List<String> aListS) {
		this.aListS = aListS;
	}
	public ArrayList<String> getAArrayListS() {
		return aArrayListS;
	}
	public void setAArrayListS(ArrayList<String> aArrayListS) {
		this.aArrayListS = aArrayListS;
	}
	public Set<String> getASetS() {
		return aSetS;
	}
	public void setASetS(Set<String> aSetS) {
		this.aSetS = aSetS;
	}
	public HashSet<String> getAHashSetS() {
		return aHashSetS;
	}
	public void setAHashSetS(HashSet<String> aHashSetS) {
		this.aHashSetS = aHashSetS;
	}
	public Queue<String> getAQueueS() {
		return aQueueS;
	}
	public void setAQueueS(Queue<String> aQueueS) {
		this.aQueueS = aQueueS;
	}
	public LinkedList<String> getALinkedListS() {
		return aLinkedListS;
	}
	public void setALinkedListS(LinkedList<String> aLinkedListS) {
		this.aLinkedListS = aLinkedListS;
	}
	public SortedSet<String> getASortedSetS() {
		return aSortedSetS;
	}
	public void setASortedSetS(SortedSet<String> aSortedSetS) {
		this.aSortedSetS = aSortedSetS;
	}
	public TreeSet<String> getATreeSetS() {
		return aTreeSetS;
	}
	public void setATreeSetS(TreeSet<String> aTreeSetS) {
		this.aTreeSetS = aTreeSetS;
	}
	public CollectionS() {}
	@Override
	public String toString() {
		return "CollectionS"+newLine+"aListS=" + aListS + newLine+" aArrayListS=" + aArrayListS
				+ newLine+" aSetS=" + aSetS + newLine+" aHashSetS=" + aHashSetS
				+ newLine+" aQueueS=" + aQueueS + newLine+" aLinkedListS=" + aLinkedListS
				+ newLine+" aSortedSetS=" + aSortedSetS + newLine+" aTreeSetS=" + aTreeSetS;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aArrayListS == null) ? 0 : aArrayListS.hashCode());
		result = prime * result
				+ ((aHashSetS == null) ? 0 : aHashSetS.hashCode());
		result = prime * result
				+ ((aLinkedListS == null) ? 0 : aLinkedListS.hashCode());
		result = prime * result + ((aListS == null) ? 0 : aListS.hashCode());
		result = prime * result + ((aQueueS == null) ? 0 : aQueueS.hashCode());
		result = prime * result + ((aSetS == null) ? 0 : aSetS.hashCode());
		result = prime * result
				+ ((aSortedSetS == null) ? 0 : aSortedSetS.hashCode());
		result = prime * result
				+ ((aTreeSetS == null) ? 0 : aTreeSetS.hashCode());
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
		CollectionS other = (CollectionS) obj;
		if (aArrayListS == null) {
			if (other.aArrayListS != null)
				return false;
		} else if (!aArrayListS.equals(other.aArrayListS))
			return false;
		if (aHashSetS == null) {
			if (other.aHashSetS != null)
				return false;
		} else if (!aHashSetS.equals(other.aHashSetS))
			return false;
		if (aLinkedListS == null) {
			if (other.aLinkedListS != null)
				return false;
		} else if (!aLinkedListS.equals(other.aLinkedListS))
			return false;
		if (aListS == null) {
			if (other.aListS != null)
				return false;
		} else if (!aListS.equals(other.aListS))
			return false;
		if (aQueueS == null) {
			if (other.aQueueS != null)
				return false;
		} else if (!aQueueS.equals(other.aQueueS))
			return false;
		if (aSetS == null) {
			if (other.aSetS != null)
				return false;
		} else if (!aSetS.equals(other.aSetS))
			return false;
		if (aSortedSetS == null) {
			if (other.aSortedSetS != null)
				return false;
		} else if (!aSortedSetS.equals(other.aSortedSetS))
			return false;
		if (aTreeSetS == null) {
			if (other.aTreeSetS != null)
				return false;
		} else if (!aTreeSetS.equals(other.aTreeSetS))
			return false;
		return true;
	}
	
	
}
