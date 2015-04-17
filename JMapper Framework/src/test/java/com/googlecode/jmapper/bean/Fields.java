package com.googlecode.jmapper.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.googlecode.jmapper.annotations.JGlobalMap;

@JGlobalMap(classes={Fields.class},attributes={"aByte"})
public class Fields {

	
	/* primitive types */
	byte aByte;
	short aShort;
	int anInt;
	long aLong;
	float aFloat;
	double aDouble;
	char aChar;
	boolean aBoolean;
	
	public static String[] primitiveTypes ={"aByte","aShort","anInt","aLong","aFloat","aDouble","aChar","aBoolean"};
	
	/* wrapper types */
	Byte aWByte;
	Short aWShort;
	Integer anWInt;
	Long aWLong;
	Float aWFloat;
	Double aWDouble;
	Character aWChar;
	Boolean aWBoolean;
	String aString;
	
	public static String[] wrapperTypes ={"aWByte","aWShort","anWInt","aWLong","aWFloat","aWDouble","aWChar","aWBoolean","aString"};
	
	//-------------------------------------------------------
	//						COLLECTION
	//-------------------------------------------------------
	
	/* interfaces */
	List<?> aList;
	Set<?> aSet;
	SortedSet<?> aSortedSet;
	Queue<?> aQueue;
	
	public static String[] collectionTypes ={"aList","aSet","aSortedSet","aQueue"};
	
	/* relative implementations */
	ArrayList<?> aArrayList;
	HashSet<?> aHashSet;
	TreeSet<?> aTreeSet;
	LinkedList<?> aLinkedList;
	
	public static String[] implCollectionTypes  = {"aArrayList","aHashSet","aTreeSet","aLinkedList"};
	public static String[] diffImplCollectionTypes = {"aLinkedList","aTreeSet","aHashSet","aArrayList"};
	
	/* others collections */
	@SuppressWarnings("rawtypes")
	List list;
	List<MappedObject> aMappedList;
	ArrayList<ExtendsMappedObject> aExtendsMappedList;
	List<String> aList2;
	ArrayList<Long> aArrayList2;
	HashSet<String> aHashSet3;
	LinkedList<Integer> aLinkedList3;
	TreeSet<Character> aTreeSet3;
	HashSet<Number> aHashSet4;
	ArrayList<Set<String>> aALHS;
	TreeSet<HashSet<String>> aTSHS;
	
	public static String[] collections = {"aList2","aArrayList2","aTreeSet3","aLinkedList3","aALHS","aMappedList"};
	public static String[] collections2 = {"aLinkedList3","aHashSet3","aArrayList2","aList2","aTSHS","aExtendsMappedList"};
	
	/* lists with mapped items and target items */
	TreeSet<MappedObject> aTreeSet2;
	LinkedList<TargetObject> aLinkedList2;
	
	public static String[] mappedCollections = {"aTreeSet2"};
	public static String[] targetCollections = {"aLinkedList2"};
	
	//-------------------------------------------------------
	//						MAP
	//-------------------------------------------------------

	/* interfaces */
	Map<String, Integer> aMap;
	SortedMap<Integer, String> aSortedMap;
	
	public static String[] mapTypes ={"aMap","aSortedMap"};
	
	/* relative implementations */
	HashMap<String, String> aHashMap;
	TreeMap<String, String> aTreeMap;
	
	public static String[] implMapTypes ={"aHashMap","aTreeMap"};
	public static String[] diffImplMapTypes ={"aTreeMap","aHashMap"};
	
	/* others maps */
	HashMap<Integer, String> aHashMap2;
	TreeMap<String, Integer> aTreeMap2;
	HashMap<List<Integer>, Map<String,String>> aHashMap3;
	TreeMap<ArrayList<Integer>, HashMap<String,String>> aTreeMap3;
	HashMap<List<Integer>,List<Integer>> aHashMap4;
	TreeMap<ArrayList<Integer>, ArrayList<Integer>> aTreeMap4;
	
	public static String[] maps = {"aHashMap2","aHashMap3","aHashMap4"};
	public static String[] maps2 = {"aTreeMap2","aTreeMap3","aTreeMap4"};
	
	/* maps with mapped items and target items */
	HashMap<MappedObject,TargetObject> aHashMapMapped;
	TreeMap<TargetObject,MappedObject> aTreeMapMapped;
	
	public static String[] mappedMaps = {"aHashMapMapped"};
	public static String[] targetMaps = {"aTreeMapMapped"};

	//-------------------------------------------------------
	//						ARRAY
	//-------------------------------------------------------
	
	/* arrays */
	Object[] objArray;
	MappedObject[] mappedArray;
	
	public static String[] arrayTypes = {"objArray","mappedArray"};
	
	/* relative specializations */
	String[] strArray;
	ExtendsMappedObject[] extendsMappedArray;
	
	public static String[] implArrayTypes = {"strArray","extendsMappedArray"};
	
	/* arrays with mapped items and target items */
	TargetObject[] targetArray;
	
	/* others */
	int[] intArray;
	Integer[] integerArray;
	
	public static String[] mappedArrays = {"mappedArray"};
	public static String[] targetArrays = {"targetArray"};
	
	//-------------------------------------------------------
	//						OBJECT
	//-------------------------------------------------------
	
	/* objects */
	MappedObject mappedObject;
	ExtendsMappedObject extendsMappedObject;
	
	public static String mappedObj = "mappedObject";
	public static String extendsMappedObj = "extendsMappedObject";
	
	TargetObject targetObject;
	
	public static String targetObj = "targetObject";
	
}
