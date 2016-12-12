package com.googlecode.jmapper.bean;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import com.googlecode.jmapper.annotations.JMapConversion;

public class ComplexClass {

	// used in ArrayOperationTest
	public String[] StringArray;
	public String[] StringArray2;
	
	// used in ArrayConversionTest
	public Integer[] IntegerArray;

	// used in MappedArrayOperationTest
	public TargetObject[] aTargetArray;
	public MappedObject[] aMappedArray;
	
	// used in CollectionOperationTest
	public ArrayList<String> aStringList;
	public ArrayList<String> aStringList2;
	
	// used in CollectionConversionTest
	public List<String> aList;
	public Set<String> aSet;
	
	// used in CollectionConversion2Test
	public List<String> aListString;
	public Set<Integer> aSetInteger;

	// used in MappedCollectionOperationTest
	public List<TargetObject> aTargetList;
	public Set<MappedObject> aMappedSet;
	
	// used in MapOperationTest
	public HashMap<String,String> aSimpleMap;
	public HashMap<String,String> aSimpleMap2;

	// used in MapConversionTest
	public SortedMap<String, String> aSortedMap;
	public Map<String,String> aMap;
	
	// used in MapConversion2Test
	public SortedMap<String, Integer> aDConversionMap;
	public Map<Integer,String> aSConversionMap;
	
	// used in MapConversion2Test
	public SortedMap<String, String> aDConversionMap2;
	public Map<Integer,String> aSConversionMap2;
	
	// used in MappedMapOperationTest
	public Map<MappedObject,TargetObject> aDMappedMap;
	public SortedMap<TargetObject, MappedObject> aSMappedMap;
	
	// used in MappedMapOperationTest
	public Map<MappedObject, String> aDMappedMap2;
	public SortedMap<TargetObject, String> aSMappedMap2;
		
	// used in ObjectOperationTest
	public MappedObject mappedObject;
	public TargetObject targetObject;
	
	@JMapConversion(from={"aStringList2"},to={"aStringList"})
	public ArrayList<String> conversion(ArrayList<String> aStringList2){
		aStringList2.add("conversion applied");
		return aStringList2;
	}
}
