package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.HashMap;
import java.util.TreeMap;

import com.googlecode.jmapper.integrationtest.mock.AMapMock;
import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.MapD;
import com.googlecode.jmapper.integrationtest.operations.bean.MapS;

public class MapMockDS extends AMapMock implements IMockDS<MapD, MapS> {

	public IObjDS<MapD, MapS> AllAll() {
		return new ObjDS<MapD, MapS>(getD(), AllAllOutputD(), getS());
	}

	public IObjDS<MapD, MapS> AllValued() {
		return new ObjDS<MapD, MapS>(getD(), AllValuedOutputD(), getS());
	}

	public IObjDS<MapD, MapS> ValuedNull() {
		return new ObjDS<MapD, MapS>(getD(), ValuedNullOutputD(), getS());
		
	}

	public IObjDS<MapD, MapS> ValuedAll() {
		return new ObjDS<MapD, MapS>(getD(), ValuedAllOutputD(), getS());
		
	}

	public IObjDS<MapD, MapS> ValuedValued() {
		return new ObjDS<MapD, MapS>(getD(), ValuedValuedOutputD(), getS());
		
	}

	public IObjDS<MapD, MapS> NullValued() {
		return new ObjDS<MapD, MapS>(getD(), NullValuedOutputD(), getS());
	}

	public IObjDS<MapD, MapS> NullInputObject() {
		return new ObjDS<MapD, MapS>(getD(),null, getS());
		
	}

	private MapD getD(){
		return new MapD(null, 
						put(new HashMap<String, String>(), "aHashMapD"), 
						put(new TreeMap<String, String>(), "aSortedMapD"), 
						put(new TreeMap<String, String>(), "aTreeMapD"));
	}
	
	private MapS getS(){
		return new MapS(put(new HashMap<String, String>(), "aMapS"), 
						put(new HashMap<String, String>(), "aHashMapS"), 
						put(new TreeMap<String, String>(), "aSortedMapS"), 
						null);
	}
	/**************************** ALL ALL *******************************/
	public MapD AllAllOutputD(){
		return new MapD(put(new HashMap<String, String>(), "aHashMapS"), 
						put(new HashMap<String, String>(), "aHashMapD","aSortedMapS"), 
						null, 
						put(new TreeMap<String, String>(), "aTreeMapD","aMapS"));
	}
	/**************************** ALL VALUED ****************************/
	public MapD AllValuedOutputD(){
		return new MapD(put(new HashMap<String, String>(), "aHashMapS"), 
						put(new HashMap<String, String>(), "aHashMapD","aSortedMapS"), 
						put(new TreeMap<String, String>(), "aSortedMapD"), 
						put(new TreeMap<String, String>(), "aTreeMapD","aMapS"));
	}
	/**************************** VALUED NULL ***************************/
	public MapD ValuedNullOutputD(){
		return new MapD(null, 
						put(new HashMap<String, String>(), "aHashMapD"), 
						null, 
						put(new TreeMap<String, String>(), "aTreeMapD"));
	}
	/**************************** VALUED ALL ****************************/
	public MapD ValuedAllOutputD(){
		return new MapD(null, 
						put(new HashMap<String, String>(), "aHashMapD","aSortedMapS"), 
						null, 
						put(new TreeMap<String, String>(), "aTreeMapD","aMapS"));
	}
	/**************************** VALUED VALUED *************************/
	public MapD ValuedValuedOutputD(){
		return new MapD(null, 
						put(new HashMap<String, String>(), "aHashMapD","aSortedMapS"), 
						put(new TreeMap<String, String>(), "aSortedMapD"), 
						put(new TreeMap<String, String>(), "aTreeMapD","aMapS"));
	}
	/**************************** NULL VALUED ***************************/
	public MapD NullValuedOutputD(){
		return new MapD(put(new HashMap<String, String>(), "aHashMapS"),
						put(new HashMap<String, String>(), "aHashMapD"), 
						put(new TreeMap<String, String>(), "aSortedMapD"), 
						put(new TreeMap<String, String>(), "aTreeMapD"));
	}
}
