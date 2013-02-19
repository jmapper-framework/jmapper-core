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
import com.googlecode.jmapper.integrationtest.operations.bean.ObjectD;
import com.googlecode.jmapper.integrationtest.operations.bean.ObjectS;
import com.googlecode.jmapper.integrationtest.operations.bean.TargetObject;

public class ObjectMockS extends AObjectMock implements IMockS<ObjectD, ObjectS>{

	public IObjS<ObjectD, ObjectS> AllAll() {
		return new ObjS<ObjectD, ObjectS>(getAllD(),getAllS());
	}

	public IObjS<ObjectD, ObjectS> AllValued() {
		return new ObjS<ObjectD, ObjectS>(getValuedD(),getValuedS());
	}

	public IObjS<ObjectD, ObjectS> AllNull() {
		return new ObjS<ObjectD, ObjectS>(null,getAllS());
	}

	private int aInt = 10;
	private String aString = "";
	
	private ObjectS getValuedS(){
		return new ObjectS(new MappedObject(
				aInt, 
				null, 
				add(new ArrayList<String>(), aString), 
				null));
	}
	
	private ObjectD getValuedD(){
		return new ObjectD(new TargetObject(
				aInt, 
				null, 
				add(new HashSet<String>(), aString), 
				null));
	}
	private ObjectS getAllS(){
		return new ObjectS(new MappedObject(
				aInt, 
				aString, 
				add(new ArrayList<String>(), aString), 
				put(new TreeMap<String, String>(), aString)));
	}
	
	private ObjectD getAllD(){
		return new ObjectD(new TargetObject(
				aInt, 
				aString, 
				add(new HashSet<String>(), aString), 
				put(new HashMap<String, String>(), aString)));
	}
}
