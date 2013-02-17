package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

import com.googlecode.jmapper.integrationtest.mock.AObjectMock;
import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.Obj;
import com.googlecode.jmapper.integrationtest.operations.bean.WithoutGenericsD;
import com.googlecode.jmapper.integrationtest.operations.bean.WithoutGenericsS;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class WithoutGenericsMockDS extends AObjectMock implements IMockDS<WithoutGenericsD, WithoutGenericsS> {

	public IObjDS<WithoutGenericsD, WithoutGenericsS> AllAll() {
		return new ObjDS<WithoutGenericsD, WithoutGenericsS>(getDAll(), AllAllOutput(), getSAll());
	}

	public IObjDS<WithoutGenericsD, WithoutGenericsS> AllValued() {
		return new ObjDS<WithoutGenericsD, WithoutGenericsS>(getDAll(), AllValuedOutput(), getSValued());
	}

	public IObjDS<WithoutGenericsD, WithoutGenericsS> ValuedNull() {
		return new ObjDS<WithoutGenericsD, WithoutGenericsS>(getDValued(), ValuedNullOutput(), getSNull());
	}

	public IObjDS<WithoutGenericsD, WithoutGenericsS> ValuedAll() {
		return new ObjDS<WithoutGenericsD, WithoutGenericsS>(getDValued(), ValuedAllOutput(), getSAll());
	}

	public IObjDS<WithoutGenericsD, WithoutGenericsS> ValuedValued() {
		return new ObjDS<WithoutGenericsD, WithoutGenericsS>(getDValued(), ValuedValuedOutput(), getSValued());
	}

	public IObjDS<WithoutGenericsD, WithoutGenericsS> NullValued() {
		return new ObjDS<WithoutGenericsD, WithoutGenericsS>(getDNull(), NullValuedOutput(), getSValued());
	}

	public IObjDS<WithoutGenericsD, WithoutGenericsS> NullInputObject() {
		return new ObjDS<WithoutGenericsD, WithoutGenericsS>(getDAll(), null, getSAll());
	}

	/************************************ INPUT METHODS ************************************/
	private WithoutGenericsD getDAll(){
		return new WithoutGenericsD("destination",
									 add(new ArrayList(),new Obj("d1", "d2", "d3")),
									 put(new HashMap(),new Obj("d1", "d2", "d3")));
	}
	private WithoutGenericsS getSAll(){
		return new WithoutGenericsS("source",
									 add(new HashSet(),new Obj("s1", "s2", "s3")),
									 put(new TreeMap(),new Obj("s1", "s2", "s3")));
	}
	private WithoutGenericsD getDValued(){
		return new WithoutGenericsD("destination",
									 null,
									 put(new HashMap(),new Obj("d1", "d2", "d3")));
	}
	private WithoutGenericsS getSValued(){
		return new WithoutGenericsS("source",
									 add(new HashSet(),new Obj("s1", "s2", "s3")),
									 null);
	}
	private WithoutGenericsD getDNull(){
		return new WithoutGenericsD(null,
									 add(new ArrayList(),new Obj("d1", "d2", "d3")),
									 put(new HashMap(),new Obj("d1", "d2", "d3")));
	}
	private WithoutGenericsS getSNull(){
		return new WithoutGenericsS("source",
									 add(new HashSet(),new Obj("s1", "s2", "s3")),
									 null);
	}
	
	/************************************ OUTPUT METHODS ************************************/
	
	public WithoutGenericsD AllAllOutput(){
		return new WithoutGenericsD("source",
				 add(new ArrayList(),new Obj("d1", "d2", "d3"),new Obj("s1", "s2", "s3")),
				 put(new HashMap(),new Obj("d1", "d2", "d3"),new Obj("s1", "s2", "s3")));
	}
	public WithoutGenericsD AllValuedOutput(){
		return new WithoutGenericsD("source",
				 add(new ArrayList(),new Obj("d1", "d2", "d3"),new Obj("s1", "s2", "s3")),
				 put(new HashMap(),new Obj("d1", "d2", "d3")));
	}
	public WithoutGenericsD ValuedNullOutput(){
		return new WithoutGenericsD("destination",
				 null,
				 null);
	}
	public WithoutGenericsD ValuedAllOutput(){
		return new WithoutGenericsD("source",
				 null,
				 put(new HashMap(),new Obj("d1", "d2", "d3"),new Obj("s1", "s2", "s3")));
	}
	public WithoutGenericsD ValuedValuedOutput(){
		return new WithoutGenericsD("source",
				 null,
				 put(new HashMap(),new Obj("d1", "d2", "d3")));
	}
	public WithoutGenericsD NullValuedOutput(){
		return new WithoutGenericsD("source",
				 add(new ArrayList(),new Obj("d1", "d2", "d3")),
				 put(new HashMap(),new Obj("d1", "d2", "d3")));
	}

}
