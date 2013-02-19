package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

import com.googlecode.jmapper.integrationtest.mock.ACollectionMock;
import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.CollectionD;
import com.googlecode.jmapper.integrationtest.operations.bean.CollectionS;

public class CollectionMockS extends ACollectionMock implements IMockS<CollectionD, CollectionS> {

	public IObjS<CollectionD, CollectionS> AllAll() {
		return new ObjS<CollectionD, CollectionS>(AllD(), AllS());
	}

	public IObjS<CollectionD, CollectionS> AllValued() {
		return new ObjS<CollectionD, CollectionS>(ValuedD(), ValuedS());
	}

	public IObjS<CollectionD, CollectionS> AllNull() {
		return new ObjS<CollectionD, CollectionS>(null, AllS());
	}

	public CollectionS AllS(){
		return 	new CollectionS(add(new ArrayList<String>(),"aListS"), 
								add(new ArrayList<String>(),"aArrayListS"), 
								add(new HashSet<String>(),"aSetS"), 
								add(new HashSet<String>(),"aHashSetS"), 
								add(new LinkedList<String>(),"aQueueS"), 
								add(new LinkedList<String>(),"aLinkedListS"),
								add(new TreeSet<String>(),"aSortedSetS"),
								add(new TreeSet<String>(),"aTreeSetS"));
	}
	
	public CollectionD AllD(){
		return new CollectionD(add(new HashSet<String>(),"aListS"), 
							   add(new HashSet<String>(),"aArrayListS"),
							   add(new ArrayList<String>(),"aSetS"),
							   add(new ArrayList<String>(),"aHashSetS"),
							   add(new TreeSet<String>(),"aQueueS"),
							   add(new LinkedList<String>(),"aLinkedListS"),
							   add(new LinkedList<String>(),"aSortedSetS"),
							   add(new TreeSet<String>(),"aTreeSetS"));
	}
	
	public CollectionS ValuedS(){
		return new CollectionS(add(new ArrayList<String>(),"aListS"), 
							   add(new ArrayList<String>(),"aArrayListS"), 
							   add(new HashSet<String>(),"aSetS"), 
							   add(new HashSet<String>(),"aHashSetS"), 
							   add(new LinkedList<String>(),"aQueueS"), 
							   null,
							   null,
							   add(new TreeSet<String>(),"aTreeSetS"));
	}
	
	public CollectionD ValuedD(){
		return new CollectionD(add(new HashSet<String>(),"aListS"), 
							   add(new HashSet<String>(),"aArrayListS"),
							   add(new ArrayList<String>(),"aSetS"),
							   add(new ArrayList<String>(),"aHashSetS"),
							   add(new TreeSet<String>(),"aQueueS"),
							   null,
							   null,
							   add(new TreeSet<String>(),"aTreeSetS"));
	}
}
