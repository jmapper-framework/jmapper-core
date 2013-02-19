package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.ExtendedObj;
import com.googlecode.jmapper.integrationtest.operations.bean.Obj;
import com.googlecode.jmapper.integrationtest.operations.bean.Object2D;
import com.googlecode.jmapper.integrationtest.operations.bean.Object2S;

public class Object2MockS implements IMockS<Object2D, Object2S> {

	public IObjS<Object2D, Object2S> AllAll() {
		return new ObjS<Object2D, Object2S>(getDAll(), getSAll());
	}

	public IObjS<Object2D, Object2S> AllValued() {
		return new ObjS<Object2D, Object2S>(getDValued(), getSValued());
	}

	public IObjS<Object2D, Object2S> AllNull() {
		return new ObjS<Object2D, Object2S>(null, getSAll());
	}

	private Object2D getDAll(){
		return new Object2D(new Obj("source", "source2", "source3"));
	}
	
	private Object2S getSAll(){
		return new Object2S(new ExtendedObj("source", "source2", "source3"));
	}
	
	private Object2D getDValued(){
		return new Object2D(new Obj("source", null, "source3"));
	}
	
	private Object2S getSValued(){
		return new Object2S(new ExtendedObj("source", null, "source3"));
	}
}