package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.HashMap;
import java.util.TreeMap;

import com.googlecode.jmapper.integrationtest.mock.AMapMock;
import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.MapD;
import com.googlecode.jmapper.integrationtest.operations.bean.MapS;

public class MapMockS extends AMapMock implements IMockS<MapD, MapS> {

	public IObjS<MapD, MapS> AllAll() {
		return new ObjS<MapD,MapS>(AllD(),AllS());
	}

	public IObjS<MapD, MapS> AllValued() {
		return new ObjS<MapD,MapS>(ValuedD(),ValuedS());
	}

	public IObjS<MapD, MapS> AllNull() {
		return new ObjS<MapD,MapS>(null,AllS());
	}

	public MapS AllS(){
		return new MapS(put(new HashMap<String,String>(), "aMapS"), 
						put(new HashMap<String,String>(), "aHashMapS"), 
						put(new TreeMap<String,String>(), "aSortedMapS"), 
						put(new TreeMap<String,String>(), "aTreeMapS"));
	}
	
	public MapD AllD(){
		return new MapD(put(new HashMap<String,String>(), "aHashMapS"), 
					    put(new HashMap<String,String>(), "aSortedMapS"), 
						put(new TreeMap<String,String>(), "aTreeMapS"), 
						put(new TreeMap<String,String>(), "aMapS"));
	}
	
	public MapS ValuedS(){
		return new MapS(put(new HashMap<String,String>(), "aMapS"), 
				 		put(new HashMap<String,String>(), "aHashMapS"), 
					 	null,
					 	null);
	}
	
	public MapD ValuedD(){
		return new MapD(put(new HashMap<String,String>(), "aHashMapS"), 
					    null,
					    null, 
					    put(new TreeMap<String,String>(), "aMapS"));
	}
}
