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
	String[] StringArray;
	String[] StringArray2;
	
	// used in ArrayConversionTest
	Integer[] IntegerArray;

	// used in MappedArrayOperationTest
	TargetObject[] aTargetArray;
	MappedObject[] aMappedArray;
	
	// used in CollectionOperationTest
	ArrayList<String> aStringList;
	ArrayList<String> aStringList2;
	
	// used in CollectionConversionTest
	List<String> aList;
	Set<String> aSet;
	
	// used in CollectionConversion2Test
	List<String> aListString;
	Set<Integer> aSetInteger;

	// used in MappedCollectionOperationTest
	List<TargetObject> aTargetList;
	Set<MappedObject> aMappedSet;
	
	// used in MapOperationTest
	HashMap<String,String> aSimpleMap;
	HashMap<String,String> aSimpleMap2;

	// used in MapConversionTest
	SortedMap<String, String> aSortedMap;
	Map<String,String> aMap;
	
	// used in MapConversion2Test
	SortedMap<String, Integer> aDConversionMap;
	Map<Integer,String> aSConversionMap;
	
	// used in MapConversion2Test
	SortedMap<String, String> aDConversionMap2;
	Map<Integer,String> aSConversionMap2;
	
	// used in MappedMapOperationTest
	Map<MappedObject,TargetObject> aDMappedMap;
	SortedMap<TargetObject, MappedObject> aSMappedMap;
	
	// used in MappedMapOperationTest
	Map<MappedObject, String> aDMappedMap2;
	SortedMap<TargetObject, String> aSMappedMap2;
		
	// used in ObjectOperationTest
	MappedObject mappedObject;
	TargetObject targetObject;
	
	@JMapConversion(from={"aStringList2"},to={"aStringList"})
	public ArrayList<String> conversion(ArrayList<String> aStringList2){
		aStringList2.add("conversion applied");
		return aStringList2;
	}
}
