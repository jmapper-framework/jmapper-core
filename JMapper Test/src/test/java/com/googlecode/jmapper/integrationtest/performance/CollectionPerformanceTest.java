package com.googlecode.jmapper.integrationtest.performance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

import com.googlecode.jmapper.integrationtest.Performance;
import com.googlecode.jmapper.integrationtest.config.Constants;
import com.googlecode.jmapper.integrationtest.operations.bean.CollectionD;
import com.googlecode.jmapper.integrationtest.operations.bean.CollectionS;

public class CollectionPerformanceTest extends
		Performance<CollectionD, CollectionS> {

	@Override
	protected CollectionD staticMapping(CollectionS source) {
		   CollectionD destination = new CollectionD();
		   if(source.getAListS()!=null){
			   destination.setASetD(new HashSet<String>(source.getAListS()));
		   }
		   if(source.getAArrayListS()!=null){
			   destination.setAHashSetD(new HashSet<String>(source.getAArrayListS()));
		   }
		   if(source.getASetS()!=null){
			   destination.setAArrayListD(new ArrayList<String>(source.getASetS()));
		   }
		   if(source.getAHashSetS()!=null){
			   destination.setAListD(new ArrayList<String>(source.getAHashSetS()));
		   }
		   if(source.getAQueueS()!=null){
			   destination.setASortedSetD(new TreeSet<String>(source.getAQueueS()));
		   }
		   if(source.getALinkedListS()!=null){
			   destination.setALinkedListD(source.getALinkedListS());
		   }
		   if(source.getASortedSetS()!=null){
			   destination.setAQueueD(new LinkedList<String>(source.getASortedSetS()));
		   }
		   if(source.getATreeSetS()!=null){
			   destination.setATreeSetD(source.getATreeSetS());
		   }

		   return destination;

	}

	@Override
	protected CollectionS getSource() {
		return 	new CollectionS(add(new ArrayList<String>(),"aListS"), 
				add(new ArrayList<String>(),"aArrayListS"), 
				add(new HashSet<String>(),"aSetS"), 
				add(new HashSet<String>(),"aHashSetS"), 
				add(new LinkedList<String>(),"aQueueS"), 
				add(new LinkedList<String>(),"aLinkedListS"),
				add(new TreeSet<String>(),"aSortedSetS"),
				add(new TreeSet<String>(),"aTreeSetS"));
	}

	@Override
	protected int getInternalWeight() {
		return 10000;
	}

	@Override
	protected String titleOfTest() {
		return Constants.CollectionPerformanceTest;
	}

	protected <T extends Collection<E>,E> T  add(T collection,E...elements ){
		for (E element : elements)	collection.add(element);
		return collection;
	}
}
