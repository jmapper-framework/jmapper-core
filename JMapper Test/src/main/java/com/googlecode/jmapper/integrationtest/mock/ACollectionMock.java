package com.googlecode.jmapper.integrationtest.mock;

import java.util.Collection;

public abstract class ACollectionMock {

	protected <T extends Collection<E>,E> T  add(T collection,E...elements ){
		for (E element : elements)	collection.add(element);
		return collection;
	}
}
