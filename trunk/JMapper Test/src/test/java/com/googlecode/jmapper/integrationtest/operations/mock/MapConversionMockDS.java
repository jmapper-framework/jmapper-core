package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.HashMap;
import java.util.TreeMap;

import com.googlecode.jmapper.integrationtest.mock.AMapMock;
import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.MapConversionD;
import com.googlecode.jmapper.integrationtest.operations.bean.MapConversionS;

public class MapConversionMockDS extends AMapMock implements IMockDS<MapConversionD, MapConversionS> {

	public IObjDS<MapConversionD, MapConversionS> AllAll() {
		return new ObjDS<MapConversionD, MapConversionS>(getDAll(), AllAllOutput(), getSAll());
	}

	public IObjDS<MapConversionD, MapConversionS> AllValued() {
		return new ObjDS<MapConversionD, MapConversionS>(getDAll(), AllValuedOutput(), getSValued());
	}

	public IObjDS<MapConversionD, MapConversionS> ValuedNull() {
		return new ObjDS<MapConversionD, MapConversionS>(getDValued(), ValuedNullOutput(), getSNull());
	}

	public IObjDS<MapConversionD, MapConversionS> ValuedAll() {
		return new ObjDS<MapConversionD, MapConversionS>(getDValued(), ValuedAllOutput(), getSAll());
	}

	public IObjDS<MapConversionD, MapConversionS> ValuedValued() {
		return new ObjDS<MapConversionD, MapConversionS>(getDValued(), ValuedValuedOutput(), getSValued());
	}

	public IObjDS<MapConversionD, MapConversionS> NullValued() {
		return new ObjDS<MapConversionD, MapConversionS>(getDNull(), NullValuedOutput(), getSValued());
	}

	public IObjDS<MapConversionD, MapConversionS> NullInputObject() {
		return new ObjDS<MapConversionD, MapConversionS>(getDAll(), null, getSAll());
	}
	
	
	/************************************ INPUT METHODS ************************************/
	private MapConversionD getDAll(){
		return new MapConversionD(put(new HashMap<String, Integer>(), new String[]{"10","20"},new Integer[]{50,60}), 
							      put(new TreeMap<Integer, String>(),new Integer[]{70,80},new String[]{"30","40"}));
	}
	private MapConversionS getSAll(){
		return new MapConversionS(put(new TreeMap<Integer, String>(),new Integer[]{1,2},new String[]{"5","6"}), 
								  put(new HashMap<String, Integer>(), new String[]{"7","8"},new Integer[]{3,4}));
	}
	private MapConversionD getDValued(){
		return new MapConversionD(null, 
								  put(new TreeMap<Integer, String>(),new Integer[]{70,80},new String[]{"30","40"}));
	}
	private MapConversionS getSValued(){
		return new MapConversionS(null, 
								  put(new HashMap<String, Integer>(), new String[]{"7","8"},new Integer[]{3,4}));
	}
	private MapConversionD getDNull(){
		return new MapConversionD(put(new HashMap<String, Integer>(), new String[]{"10","20"},new Integer[]{50,60}), 
								  null);
	}
	private MapConversionS getSNull(){
		return new MapConversionS(put(new TreeMap<Integer, String>(),new Integer[]{1,2},new String[]{"5","6"}),  
								  null);
	}

	/************************************ OUTPUT METHODS ************************************/
	public MapConversionD AllAllOutput(){
		return new MapConversionD(put(new HashMap<String, Integer>(), new String[]{"10","20","1","2"},new Integer[]{50,60,5,6}), 
			      				  put(new TreeMap<Integer, String>(),new Integer[]{7,8,70,80},new String[]{"3","4","30","40"}));
	}
	public MapConversionD AllValuedOutput(){
		return new MapConversionD(put(new HashMap<String, Integer>(), new String[]{"10","20"},new Integer[]{50,60}), 
								  put(new TreeMap<Integer, String>(),new Integer[]{7,8,70,80},new String[]{"3","4","30","40"}));
	}
	public MapConversionD ValuedNullOutput(){
		return new MapConversionD(null,null);
	}
	public MapConversionD ValuedAllOutput(){
		return new MapConversionD(null, 
								  put(new TreeMap<Integer, String>(),new Integer[]{7,8,70,80},new String[]{"3","4","30","40"}));
	}
	public MapConversionD ValuedValuedOutput(){
		return new MapConversionD(null, 
				  				  put(new TreeMap<Integer, String>(),new Integer[]{7,8,70,80},new String[]{"3","4","30","40"}));
	}
	public MapConversionD NullValuedOutput(){
		return new MapConversionD(put(new HashMap<String, Integer>(), new String[]{"10","20"},new Integer[]{50,60}), 
			      				  put(new TreeMap<Integer, String>(),new Integer[]{7,8},new String[]{"3","4"}));
	}
}
