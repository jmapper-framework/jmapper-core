package com.googlecode.jmapper.integrationtest.performance;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.googlecode.jmapper.integrationtest.Performance;
import com.googlecode.jmapper.integrationtest.config.Constants;
import com.googlecode.jmapper.integrationtest.operations.bean.MapD;
import com.googlecode.jmapper.integrationtest.operations.bean.MapS;

public class MapPerformanceTest extends Performance<MapD, MapS> {

	@Override
	protected MapD staticMapping(MapS source) {
	   MapD destination = new MapD();
	   if(source.getAMapS()!=null){
		   destination.setATreeMapD(new TreeMap<String, String>(source.getAMapS()));
	   }
	   if(source.getAHashMapS()!=null){
		   destination.setAMapD(source.getAHashMapS());
	   }
	   if(source.getASortedMapS()!=null){
		   destination.setAHashMapD(new HashMap<String, String>(source.getASortedMapS()));
	   }
	   if(source.getATreeMapS()!=null){
		   destination.setASortedMapD(source.getATreeMapS());
	   }
	   return destination;
	}

	@Override
	protected MapS getSource() {
		return new MapS(put(new HashMap<String,String>(), "aMapS"), 
						put(new HashMap<String,String>(), "aHashMapS"), 
						put(new TreeMap<String,String>(), "aSortedMapS"), 
						put(new TreeMap<String,String>(), "aTreeMapS"));
	}

	@Override
	protected int getInternalWeight() {
		return 10000;
	}

	@Override
	protected String titleOfTest() {
		return Constants.MapPerformanceTest;
	}

	private <T extends Map<E,E>,E> T  put(T map,E...elements ){
		for (E element : elements)	map.put(element,element);
		return map;
	}
	
}
