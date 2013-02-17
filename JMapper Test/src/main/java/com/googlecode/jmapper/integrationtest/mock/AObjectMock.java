package com.googlecode.jmapper.integrationtest.mock;

import java.util.Collection;
import java.util.Map;

public abstract class AObjectMock {

	protected <T extends Collection<E>,E> T  add(T collection,E...elements ){
		for (E element : elements)	collection.add(element);
		return collection;
	}
	
	protected <T extends Map<E,E>,E> T  put(T map,E...elements ){
		for (E element : elements)	map.put(element,element);
		return map;
	}
}
