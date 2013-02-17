package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.ACollectionMock;
import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.CollectionD;
import com.googlecode.jmapper.integrationtest.operations.bean.CollectionS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class CollectionMockDS extends ACollectionMock implements IMockDS<CollectionD, CollectionS> {

	public IObjDS<CollectionD, CollectionS> AllAll() {
		return new ObjDS<CollectionD, CollectionS>(getD(),AllAllOutputD(),getS());
	}

	public IObjDS<CollectionD, CollectionS> AllValued() {
		return new ObjDS<CollectionD, CollectionS>(getD(),AllValuedOutputD(),getS());
	}

	public IObjDS<CollectionD, CollectionS> ValuedNull() {
		return new ObjDS<CollectionD, CollectionS>(getD(),ValuedNullOutputD(),getS());
	}

	public IObjDS<CollectionD, CollectionS> ValuedAll() {
		return new ObjDS<CollectionD, CollectionS>(getD(),ValuedAllOutputD(),getS());
	}

	public IObjDS<CollectionD, CollectionS> ValuedValued() {
		return new ObjDS<CollectionD, CollectionS>(getD(),ValuedValuedOutputD(),getS());
	}

	public IObjDS<CollectionD, CollectionS> NullValued() {
		return new ObjDS<CollectionD, CollectionS>(getD(),NullValuedOutputD(),getS());
	}

	public IObjDS<CollectionD, CollectionS> NullInputObject() {
		return new ObjDS<CollectionD, CollectionS>(getD(),null,getS());
	}
	
	/**************************** ALL ALL *******************************/
	public CollectionD AllAllOutputD(){
		return new CollectionD(	null, 
							   	add(new HashSet<String>(),"aHashSetD","aArrayListS"),
							   	add(new ArrayList<String>(),"aSetS"),
							   	add(new ArrayList<String>(),"aListD","aHashSetS"),
							   	add(new TreeSet<String>(),"aSortedSetD","aQueueS"),
							   	add(new LinkedList<String>(),"aLinkedListS"),
							   	null,
							   	add(new TreeSet<String>(),"aTreeSetS"));
	}

	/**************************** ALL VALUED ****************************/
	public CollectionD AllValuedOutputD(){
		return new CollectionD(add(new HashSet<String>(),"aSetD"), 
							   add(new HashSet<String>(),"aArrayListS","aHashSetD"),
							   add(new ArrayList<String>(),"aSetS"),
							   add(new ArrayList<String>(),"aListD","aHashSetS"),
							   add(new TreeSet<String>(),"aSortedSetD","aQueueS"),
							   add(new LinkedList<String>(),"aLinkedListS"),
							   add(new LinkedList<String>(),"aQueueD"),
							   add(new TreeSet<String>(),"aTreeSetS"));
	}
	/**************************** VALUED NULL ****************************/
	public CollectionD ValuedNullOutputD(){
		return new CollectionD(	null, 
								add(new HashSet<String>(),"aHashSetD"),
								null,
								add(new ArrayList<String>(),"aListD"),
								add(new TreeSet<String>(),"aSortedSetD"),
								null,
								null,
								null);
	}
	/**************************** VALUED ALL ****************************/
	public CollectionD ValuedAllOutputD(){
		return new CollectionD(	null, 
								add(new HashSet<String>(),"aHashSetD","aArrayListS"),
								null,
								add(new ArrayList<String>(),"aListD","aHashSetS"),
								add(new TreeSet<String>(),"aSortedSetD","aQueueS"),
								null,
								null,
								null);
	}
	/**************************** VALUED VALUED *************************/
	public CollectionD ValuedValuedOutputD(){
		return new CollectionD(	add(new HashSet<String>(),"aSetD"), 
							   	add(new HashSet<String>(),"aHashSetD","aArrayListS"),
							   	null,
							   	add(new ArrayList<String>(),"aListD","aHashSetS"),
							   	add(new TreeSet<String>(),"aSortedSetD","aQueueS"),
							   	null,
							   	add(new LinkedList<String>(),"aQueueD"),
							   	null);
	}
	/**************************** NULL VALUED ***************************/
	public CollectionD NullValuedOutputD(){
		return new CollectionD(	add(new HashSet<String>(),"aSetD"), 
								add(new HashSet<String>(),"aHashSetD"),
								add(new ArrayList<String>(),"aSetS"),
								add(new ArrayList<String>(),"aListD"),
								add(new TreeSet<String>(),"aSortedSetD"),
								add(new LinkedList<String>(),"aLinkedListS"),
								add(new LinkedList<String>(),"aQueueD"),
								add(new TreeSet<String>(),"aTreeSetS"));
	}
	/*******************GETD AND GETS METHODS ***************************/
	private CollectionD getD(){
		return new CollectionD(	add(new HashSet<String>(),"aSetD"), 
				   				add(new HashSet<String>(),"aHashSetD"),
				   				null,
				   				add(new ArrayList<String>(),"aListD"),
				   				add(new TreeSet<String>(),"aSortedSetD"),
				   				null,
				   				add(new LinkedList<String>(),"aQueueD"),
				   				null);
	}
	
	private CollectionS getS(){
		return 	new CollectionS(null, 
								add(new ArrayList<String>(),"aArrayListS"), 
								add(new HashSet<String>(),"aSetS"), 
								add(new HashSet<String>(),"aHashSetS"), 
								add(new LinkedList<String>(),"aQueueS"), 
								add(new LinkedList<String>(),"aLinkedListS"),
								null,
								add(new TreeSet<String>(),"aTreeSetS"));
	}
	
}
