package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.ExtendedObj;
import com.googlecode.jmapper.integrationtest.operations.bean.Obj;
import com.googlecode.jmapper.integrationtest.operations.bean.Object2D;
import com.googlecode.jmapper.integrationtest.operations.bean.Object2S;

public class Object2MockDS implements IMockDS<Object2D, Object2S> {

	public IObjDS<Object2D, Object2S> AllAll() {
		return new ObjDS<Object2D, Object2S>(getDAll(), AllAllOutput(), getSAll());
	}

	public IObjDS<Object2D, Object2S> AllValued() {
		return new ObjDS<Object2D, Object2S>(getDAll(), AllValuedOutput(), getSValued());
	}

	public IObjDS<Object2D, Object2S> ValuedNull() {
		return new ObjDS<Object2D, Object2S>(getDValued(), ValuedNullOutput(), getSNull());
	}

	public IObjDS<Object2D, Object2S> ValuedAll() {
		return new ObjDS<Object2D, Object2S>(getDValued(), ValuedAllOutput(), getSAll());
	}

	public IObjDS<Object2D, Object2S> ValuedValued() {
		return new ObjDS<Object2D, Object2S>(getDValued(), ValuedValuedOutput(), getSValued());
	}

	public IObjDS<Object2D, Object2S> NullValued() {
		return new ObjDS<Object2D, Object2S>(getDNull(), NullValuedOutput(), getSValued());
	}

	public IObjDS<Object2D, Object2S> NullInputObject() {
		return new ObjDS<Object2D, Object2S>(getDAll(), null, getSAll());
	}

	/************************************ INPUT METHODS ************************************/
	private Object2D getDAll(){
		return new Object2D(new Obj("destination", "destination2", "destination3"));
	}
	private Object2S getSAll(){
		return new Object2S(new ExtendedObj("source", "source2", "source3"));
	}
	private Object2D getDValued(){
		return new Object2D(new Obj("destination", "destination2", null));
	}
	private Object2S getSValued(){
		return new Object2S(new ExtendedObj("source", null, "source3"));
	}
	private Object2D getDNull(){
		return new Object2D(null);
	}
	private Object2S getSNull(){
		return new Object2S(null);
	}
	
	/************************************ OUTPUT METHODS ************************************/
	public Object2D AllAllOutput(){
		return new Object2D(new Obj("source", "source2", "source3"));
	}
	public Object2D AllValuedOutput(){
		return new Object2D(new Obj("source", "destination2", "source3"));
	}
	public Object2D ValuedNullOutput(){
		return new Object2D();
	}
	public Object2D ValuedAllOutput(){
		return new Object2D(new Obj("source", "source2", null));
	}
	public Object2D ValuedValuedOutput(){
		return new Object2D(new Obj("source", "destination2", null));
	}
	public Object2D NullValuedOutput(){
		return new Object2D(new Obj("source", null, "source3"));
	}

}
