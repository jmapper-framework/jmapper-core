package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.HashMap;
import java.util.TreeMap;

import com.googlecode.jmapper.integrationtest.mock.AMapMock;
import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.MapConversionD;
import com.googlecode.jmapper.integrationtest.operations.bean.MapConversionS;

public class MapConversionMockS extends AMapMock implements IMockS<MapConversionD, MapConversionS> {

	public IObjS<MapConversionD, MapConversionS> AllAll() {
		return new ObjS<MapConversionD, MapConversionS>(getDAll(), getSAll());
	}

	public IObjS<MapConversionD, MapConversionS> AllValued() {
		return new ObjS<MapConversionD, MapConversionS>(getDValued(), getSValued());
	}

	public IObjS<MapConversionD, MapConversionS> AllNull() {
		return new ObjS<MapConversionD, MapConversionS>(null, getSAll());
	}

	private MapConversionD getDAll(){
		return new MapConversionD(put(new HashMap<String, Integer>(), new String[]{"1","2"},new Integer[]{5,6}), 
							      put(new TreeMap<Integer, String>(),new Integer[]{7,8},new String[]{"3","4"}));
	}
	
	private MapConversionS getSAll(){
		return new MapConversionS(put(new TreeMap<Integer, String>(),new Integer[]{1,2},new String[]{"5","6"}), 
								  put(new HashMap<String, Integer>(), new String[]{"7","8"},new Integer[]{3,4}));
	}
	
	private MapConversionD getDValued(){
		return new MapConversionD(null, 
								  put(new TreeMap<Integer, String>(),new Integer[]{7,8},new String[]{"3","4"}));
	}
	
	private MapConversionS getSValued(){
		return new MapConversionS(null, 
								  put(new HashMap<String, Integer>(), new String[]{"7","8"},new Integer[]{3,4}));
	}
}