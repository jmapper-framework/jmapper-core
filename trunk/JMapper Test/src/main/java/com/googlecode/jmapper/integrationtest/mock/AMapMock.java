package com.googlecode.jmapper.integrationtest.mock;

import java.util.Map;

public abstract class AMapMock {

	protected <T extends Map<E,E>,E> T  put(T map,E...elements ){
		for (E element : elements)	map.put(element,element);
		return map;
	}
	
	protected <T extends Map<K,V>,K,V> T  put(T map,K[] keys,V[] values ){
		for (int i = 0;i<keys.length;i++) map.put(keys[i],values[i]);
		return map;
	}
}
