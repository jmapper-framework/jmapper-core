package com.googlecode.jmapper.integrationtest.performance;

import com.googlecode.jmapper.integrationtest.Performance;
import com.googlecode.jmapper.integrationtest.config.Constants;
import com.googlecode.jmapper.integrationtest.operations.bean.MapConversionD;
import com.googlecode.jmapper.integrationtest.operations.bean.MapConversionS;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapConversionPerformanceTest extends Performance<MapConversionD, MapConversionS> {


	@Override
	protected MapConversionD staticMapping(MapConversionS source) {
		   MapConversionD destination = new MapConversionD();
		   if(source.getSourceMap()!=null){
			   HashMap<String,Integer> destinationMap = new HashMap<String,Integer>();
			   for (Entry<Integer, String> sourcePair : source.getSourceMap().entrySet()) {
				   destinationMap.put(sourcePair.getKey().toString(), new Integer(sourcePair.getValue()));
			   }
			   destination.setDestinationMap(destinationMap);
		   }
		   if(source.getSourceMap2()!=null){
			   TreeMap<Integer,String> destinationMap = new TreeMap<Integer,String>();
			   for (Entry<String, Integer> sourcePair : source.getSourceMap2().entrySet()) {
				   destinationMap.put(new Integer(sourcePair.getKey()), sourcePair.getValue().toString());
			   }
			   destination.setDestinationMap2(destinationMap);
		   }		   
		   return destination;
	}

	@Override
	protected MapConversionS getSource() {
		return new MapConversionS(put(new TreeMap<Integer, String>(),new Integer[]{1,2},new String[]{"5","6"}), 
				  put(new HashMap<String, Integer>(), new String[]{"7","8"},new Integer[]{3,4}));
	}

	@Override
	protected int getInternalWeight() {
		return 10000;
	}

	@Override
	protected String titleOfTest() {
		return Constants.MapConversionPerformanceTest;
	}
	
	private <T extends Map<K,V>,K,V> T  put(T map,K[] keys,V[] values ){
		for (int i = 0;i<keys.length;i++) map.put(keys[i],values[i]);
		return map;
	}
}
