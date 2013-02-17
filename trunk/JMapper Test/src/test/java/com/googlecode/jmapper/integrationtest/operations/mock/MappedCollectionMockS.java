package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

import com.googlecode.jmapper.integrationtest.mock.AObjectMock;
import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedCollectionD;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedCollectionS;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedObject;
import com.googlecode.jmapper.integrationtest.operations.bean.TargetObject;

public class MappedCollectionMockS extends AObjectMock implements IMockS<MappedCollectionD, MappedCollectionS> {

	public IObjS<MappedCollectionD, MappedCollectionS> AllAll() {
		return new ObjS<MappedCollectionD, MappedCollectionS>(AllD(), AllS());
	}

	public IObjS<MappedCollectionD, MappedCollectionS> AllValued() {
		return new ObjS<MappedCollectionD, MappedCollectionS>(ValuedD(), ValuedS());
	}

	public IObjS<MappedCollectionD, MappedCollectionS> AllNull() {
		return new ObjS<MappedCollectionD, MappedCollectionS>(null, AllS());
	}

	private int intS = 3;
	private String strS = "Source";
	
	private TargetObject AllTargetObject(){
		return new TargetObject(intS, strS, 
								add(new HashSet<String>(), strS), 
								put(new HashMap<String, String>(), strS));
	}
	
	private MappedObject AllMappedObject(){
		return new MappedObject(intS, strS, 
								add(new ArrayList<String>(), strS), 
								put(new TreeMap<String, String>(), strS));
	}

	private TargetObject ValuedTargetObject(){
		return new TargetObject(intS, null, 
								add(new HashSet<String>(), strS), 
								put(new HashMap<String, String>(), strS));
	}
	
	private MappedObject ValuedMappedObject(){
		return new MappedObject(intS, null, 
								add(new ArrayList<String>(), strS), 
								put(new TreeMap<String, String>(), strS));
	}
	
	private MappedCollectionD AllD(){
		return new MappedCollectionD(add(new ArrayList<TargetObject>(), AllTargetObject()));
	}
	
	private MappedCollectionS AllS(){
		return new MappedCollectionS(add(new HashSet<MappedObject>(), AllMappedObject()));
	}

	private MappedCollectionD ValuedD(){
		return new MappedCollectionD(add(new ArrayList<TargetObject>(), ValuedTargetObject()));
	}
	
	private MappedCollectionS ValuedS(){
		return new MappedCollectionS(add(new HashSet<MappedObject>(), ValuedMappedObject()));
	}
}
