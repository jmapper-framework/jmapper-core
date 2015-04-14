package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

import com.googlecode.jmapper.integrationtest.mock.AObjectMock;
import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedObject;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedSetD;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedSetS;
import com.googlecode.jmapper.integrationtest.operations.bean.TargetObject;

public class MappedSetMockS extends AObjectMock implements IMockS<MappedSetD, MappedSetS> {

	public IObjS<MappedSetD, MappedSetS> AllAll() {
		return new ObjS<MappedSetD, MappedSetS>(AllD(), AllS());
	}

	public IObjS<MappedSetD, MappedSetS> AllValued() {
		return new ObjS<MappedSetD, MappedSetS>(ValuedD(), ValuedS());
	}

	public IObjS<MappedSetD, MappedSetS> AllNull() {
		return new ObjS<MappedSetD, MappedSetS>(null, AllS());
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
	
	private MappedSetD AllD(){
		return new MappedSetD(add(new HashSet<TargetObject>(), AllTargetObject()));
	}
	
	private MappedSetS AllS(){
		return new MappedSetS(add(new HashSet<MappedObject>(), AllMappedObject()));
	}

	private MappedSetD ValuedD(){
		return new MappedSetD(add(new HashSet<TargetObject>(), ValuedTargetObject()));
	}
	
	private MappedSetS ValuedS(){
		return new MappedSetS(add(new HashSet<MappedObject>(), ValuedMappedObject()));
	}
}