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
	public byte aByte;
	public short aShort;
	public int anInt;
	public long aLong;
	public float aFloat;
	public double aDouble;
	public char aChar;
	public boolean aBoolean;
	
	public static String[] primitiveTypes ={"aByte","aShort","anInt","aLong","aFloat","aDouble","aChar","aBoolean"};
	
	/* wrapper types */
	public Byte aWByte;
	public Short aWShort;
	public Integer anWInt;
	public Long aWLong;
	public Float aWFloat;
	public Double aWDouble;
	public Character aWChar;
	public Boolean aWBoolean;
	public String aString;
	
	public static String[] wrapperTypes ={"aWByte","aWShort","anWInt","aWLong","aWFloat","aWDouble","aWChar","aWBoolean","aString"};
	
	//-------------------------------------------------------
	//						COLLECTION
	//-------------------------------------------------------
	
	/* interfaces */
	public List<?> aList;
	public Set<?> aSet;
	public SortedSet<?> aSortedSet;
	public Queue<?> aQueue;
	
	public static String[] collectionTypes ={"aList","aSet","aSortedSet","aQueue"};
	
	/* relative implementations */
	public ArrayList<?> aArrayList;
	public HashSet<?> aHashSet;
	public TreeSet<?> aTreeSet;
	public LinkedList<?> aLinkedList;
	
	public static String[] implCollectionTypes  = {"aArrayList","aHashSet","aTreeSet","aLinkedList"};
	public static String[] diffImplCollectionTypes = {"aLinkedList","aTreeSet","aHashSet","aArrayList"};
	
	/* others collections */
	@SuppressWarnings("rawtypes")
	public List list;
	public List<MappedObject> aMappedList;
	public ArrayList<ExtendsMappedObject> aExtendsMappedList;
	public List<String> aList2;
	public ArrayList<Long> aArrayList2;
	public HashSet<String> aHashSet3;
	public LinkedList<Integer> aLinkedList3;
	public TreeSet<Character> aTreeSet3;
	public HashSet<Number> aHashSet4;
	public ArrayList<Set<String>> aALHS;
	public TreeSet<HashSet<String>> aTSHS;
	
	public static String[] collections = {"aList2","aArrayList2","aTreeSet3","aLinkedList3","aALHS","aMappedList"};
	public static String[] collections2 = {"aLinkedList3","aHashSet3","aArrayList2","aList2","aTSHS","aExtendsMappedList"};
	
	/* lists with mapped items and target items */
	public TreeSet<MappedObject> aTreeSet2;
	public LinkedList<TargetObject> aLinkedList2;
	
	public static String[] mappedCollections = {"aTreeSet2"};
	public static String[] targetCollections = {"aLinkedList2"};
	
	//-------------------------------------------------------
	//						MAP
	//-------------------------------------------------------

	/* interfaces */
	public Map<String, Integer> aMap;
	public SortedMap<Integer, String> aSortedMap;
	
	public static String[] mapTypes ={"aMap","aSortedMap"};
	
	/* relative implementations */
	public HashMap<String, String> aHashMap;
	public TreeMap<String, String> aTreeMap;
	
	public static String[] implMapTypes ={"aHashMap","aTreeMap"};
	public static String[] diffImplMapTypes ={"aTreeMap","aHashMap"};
	
	/* others maps */
	public HashMap<Integer, String> aHashMap2;
	public TreeMap<String, Integer> aTreeMap2;
	public HashMap<List<Integer>, Map<String,String>> aHashMap3;
	public TreeMap<ArrayList<Integer>, HashMap<String,String>> aTreeMap3;
	public HashMap<List<Integer>,List<Integer>> aHashMap4;
	public TreeMap<ArrayList<Integer>, ArrayList<Integer>> aTreeMap4;
	
	public static String[] maps = {"aHashMap2","aHashMap3","aHashMap4"};
	public static String[] maps2 = {"aTreeMap2","aTreeMap3","aTreeMap4"};
	
	/* maps with mapped items and target items */
	public HashMap<MappedObject,TargetObject> aHashMapMapped;
	public TreeMap<TargetObject,MappedObject> aTreeMapMapped;
	
	public static String[] mappedMaps = {"aHashMapMapped"};
	public static String[] targetMaps = {"aTreeMapMapped"};

	//-------------------------------------------------------
	//						ARRAY
	//-------------------------------------------------------
	
	/* arrays */
	public Object[] objArray;
	public MappedObject[] mappedArray;
	
	public static String[] arrayTypes = {"objArray","mappedArray"};
	
	/* relative specializations */
	public String[] strArray;
	public ExtendsMappedObject[] extendsMappedArray;
	
	public static String[] implArrayTypes = {"strArray","extendsMappedArray"};
	
	/* arrays with mapped items and target items */
	public TargetObject[] targetArray;
	
	/* others */
	public int[] intArray;
	public Integer[] integerArray;
	
	public static String[] mappedArrays = {"mappedArray"};
	public static String[] targetArrays = {"targetArray"};
	
	//-------------------------------------------------------
	//						OBJECT
	//-------------------------------------------------------
	
	/* objects */
	public MappedObject mappedObject;
	public ExtendsMappedObject extendsMappedObject;
	
	public static String mappedObj = "mappedObject";
	public static String extendsMappedObj = "extendsMappedObject";
	
	public TargetObject targetObject;
	
	public static String targetObj = "targetObject";
	
}
