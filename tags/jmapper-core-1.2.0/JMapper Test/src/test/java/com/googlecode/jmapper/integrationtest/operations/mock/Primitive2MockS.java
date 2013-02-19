package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.Primitive2D;
import com.googlecode.jmapper.integrationtest.operations.bean.Primitive2S;

public class Primitive2MockS implements IMockS<Primitive2D, Primitive2S>{

	public IObjS<Primitive2D, Primitive2S> AllAll() {
		return new ObjS<Primitive2D, Primitive2S>(getAllD(), getAllS());
	}

	public IObjS<Primitive2D, Primitive2S> AllValued() {
		return new ObjS<Primitive2D, Primitive2S>(getValuedD(), getValuedS());
	}

	public IObjS<Primitive2D, Primitive2S> AllNull() {
		return new ObjS<Primitive2D, Primitive2S>(null, getValuedS());
	}

	private Primitive2S getAllS(){
		return new Primitive2S(8, 8, true, 8, (float)8, true);
	}
	
	private Primitive2D getAllD(){
		return new Primitive2D(8, 8, true, 8, (float)8, true);
	}
	
	private Primitive2S getValuedS(){
		return new Primitive2S(8, 8, true, 8, null, null);
	}
	
	private Primitive2D getValuedD(){
		return new Primitive2D(8, 0, false, 8, (float)8, true);
	}
	
}
