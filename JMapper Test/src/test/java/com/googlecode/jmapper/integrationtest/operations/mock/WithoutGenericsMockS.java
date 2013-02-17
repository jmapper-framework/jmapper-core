package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

import com.googlecode.jmapper.integrationtest.mock.AObjectMock;
import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.Obj;
import com.googlecode.jmapper.integrationtest.operations.bean.WithoutGenericsD;
import com.googlecode.jmapper.integrationtest.operations.bean.WithoutGenericsS;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class WithoutGenericsMockS extends AObjectMock implements IMockS<WithoutGenericsD, WithoutGenericsS> {

	public IObjS<WithoutGenericsD, WithoutGenericsS> AllAll() {
		return new ObjS<WithoutGenericsD, WithoutGenericsS>(getDAll(), getSAll());
	}

	public IObjS<WithoutGenericsD, WithoutGenericsS> AllValued() {
		return new ObjS<WithoutGenericsD, WithoutGenericsS>(getDValued(), getSValued());
	}

	public IObjS<WithoutGenericsD, WithoutGenericsS> AllNull() {
		return new ObjS<WithoutGenericsD, WithoutGenericsS>(null, getSAll());
	}

	private WithoutGenericsD getDAll(){
		return new WithoutGenericsD("source",
									 add(new ArrayList(),new Obj("1", "2", "3")),
									 put(new HashMap(),new Obj("1", "2", "3")));
	}
	
	private WithoutGenericsS getSAll(){
		return new WithoutGenericsS("source",
									 add(new HashSet(),new Obj("1", "2", "3")),
									 put(new TreeMap(),new Obj("1", "2", "3")));
	}
	
	private WithoutGenericsD getDValued(){
		return new WithoutGenericsD("source",
									 null,
									 put(new HashMap(),new Obj("s1", "s2", "s3")));
	}
	
	private WithoutGenericsS getSValued(){
		return new WithoutGenericsS("source",
									 null,
									 put(new TreeMap(),new Obj("s1", "s2", "s3")));
	}
}