package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.DKeyObj;
import com.googlecode.jmapper.integrationtest.operations.bean.MapConversion2D;
import com.googlecode.jmapper.integrationtest.operations.bean.MapConversion2S;
import com.googlecode.jmapper.integrationtest.operations.bean.SKeyObj;

public class MapConversion2MockDS implements IMockDS<MapConversion2D, MapConversion2S> {

	public IObjDS<MapConversion2D, MapConversion2S> AllAll() {
		return new ObjDS<MapConversion2D, MapConversion2S>(getDAll(), AllAllOutput(), getSAll());
	}

	public IObjDS<MapConversion2D, MapConversion2S> AllValued() {
		return new ObjDS<MapConversion2D, MapConversion2S>(getDAll(), AllValuedOutput(), getSValued());
	}

	public IObjDS<MapConversion2D, MapConversion2S> ValuedNull() {
		return new ObjDS<MapConversion2D, MapConversion2S>(getDValued(), ValuedNullOutput(), getSNull());
	}

	public IObjDS<MapConversion2D, MapConversion2S> ValuedAll() {
		return new ObjDS<MapConversion2D, MapConversion2S>(getDValued(), ValuedAllOutput(), getSAll());
	}

	public IObjDS<MapConversion2D, MapConversion2S> ValuedValued() {
		return new ObjDS<MapConversion2D, MapConversion2S>(getDValued(), ValuedValuedOutput(), getSValued());
	}

	public IObjDS<MapConversion2D, MapConversion2S> NullValued() {
		return new ObjDS<MapConversion2D, MapConversion2S>(getDNull(), NullValuedOutput(), getSValued());
	}

	public IObjDS<MapConversion2D, MapConversion2S> NullInputObject() {
		return new ObjDS<MapConversion2D, MapConversion2S>(getDAll(), null, getSAll());
	}

	/************************************ INPUT METHODS ************************************/
	private MapConversion2D getDAll(){
		HashMap<DKeyObj,String> map = new HashMap<DKeyObj, String>();
		map.put(new DKeyObj(5327), "5327");
		return new MapConversion2D(map);
	}
	
	private MapConversion2S getSAll(){
		SortedMap<SKeyObj, String> map = new TreeMap<SKeyObj, String>();
		map.put(new SKeyObj("5003"), "5003");
		return new MapConversion2S(map);
	}
	
	private MapConversion2D getDValued(){
		HashMap<DKeyObj,String> map = new HashMap<DKeyObj, String>();
		map.put(new DKeyObj(5327), null);
		return new MapConversion2D(map);
	}
	
	private MapConversion2S getSValued(){
		SortedMap<SKeyObj, String> map = new TreeMap<SKeyObj, String>();
		map.put(new SKeyObj("5003"), null);
		return new MapConversion2S(map);
	}
	private MapConversion2D getDNull(){
		return new MapConversion2D(null);
	}
	private MapConversion2S getSNull(){
		return new MapConversion2S(null);
	}
	
	/************************************ OUTPUT METHODS ************************************/
	public MapConversion2D AllAllOutput(){
		HashMap<DKeyObj,String> map = new HashMap<DKeyObj, String>();
		map.put(new DKeyObj(5003), "5003");
		map.put(new DKeyObj(5327), "5327");
		return new MapConversion2D(map);
	}
	public MapConversion2D AllValuedOutput(){
		HashMap<DKeyObj,String> map = new HashMap<DKeyObj, String>();
		map.put(new DKeyObj(5327), "5327");
		map.put(new DKeyObj(5003),null);
		return new MapConversion2D(map);
	}
	public MapConversion2D ValuedNullOutput(){
		HashMap<DKeyObj,String> map = new HashMap<DKeyObj, String>();
		map.put(new DKeyObj(5327), null);
		return new MapConversion2D(null);
	}
	public MapConversion2D ValuedAllOutput(){
		HashMap<DKeyObj,String> map = new HashMap<DKeyObj, String>();
		map.put(new DKeyObj(5327), null);
		map.put(new DKeyObj(5003),"5003");
		return new MapConversion2D(map);
	}
	public MapConversion2D ValuedValuedOutput(){
		HashMap<DKeyObj,String> map = new HashMap<DKeyObj, String>();
		map.put(new DKeyObj(5327), null);
		map.put(new DKeyObj(5003),null);
		return new MapConversion2D(map);
	}
	public MapConversion2D NullValuedOutput(){
		HashMap<DKeyObj,String> map = new HashMap<DKeyObj, String>();
		map.put(new DKeyObj(5003), null);
		return new MapConversion2D(map);
	}

}
