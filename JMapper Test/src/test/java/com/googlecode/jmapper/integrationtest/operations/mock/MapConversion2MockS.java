package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import com.googlecode.jmapper.integrationtest.mock.AMapMock;
import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.DKeyObj;
import com.googlecode.jmapper.integrationtest.operations.bean.MapConversion2D;
import com.googlecode.jmapper.integrationtest.operations.bean.MapConversion2S;
import com.googlecode.jmapper.integrationtest.operations.bean.SKeyObj;

public class MapConversion2MockS extends AMapMock implements IMockS<MapConversion2D, MapConversion2S> {

	public IObjS<MapConversion2D, MapConversion2S> AllAll() {
		return new ObjS<MapConversion2D, MapConversion2S>(getDAll(), getSAll());
	}

	public IObjS<MapConversion2D, MapConversion2S> AllValued() {
		return new ObjS<MapConversion2D, MapConversion2S>(getDValued(), getSValued());
	}

	public IObjS<MapConversion2D, MapConversion2S> AllNull() {
		return new ObjS<MapConversion2D, MapConversion2S>(null, getSAll());
	}

	private MapConversion2D getDAll(){
		HashMap<DKeyObj,String> map = new HashMap<DKeyObj, String>();
		map.put(new DKeyObj(5003), "5003");
		return new MapConversion2D(map);
	}
	
	private MapConversion2S getSAll(){
		SortedMap<SKeyObj, String> map = new TreeMap<SKeyObj, String>();
		map.put(new SKeyObj("5003"), "5003");
		return new MapConversion2S(map);
	}
	
	private MapConversion2D getDValued(){
		HashMap<DKeyObj,String> map = new HashMap<DKeyObj, String>();
		map.put(new DKeyObj(5003), null);
		return new MapConversion2D(map);
	}
	
	private MapConversion2S getSValued(){
		SortedMap<SKeyObj, String> map = new TreeMap<SKeyObj, String>();
		map.put(new SKeyObj("5003"), null);
		return new MapConversion2S(map);
	}
}