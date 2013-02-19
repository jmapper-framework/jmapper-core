package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.Primitive2D;
import com.googlecode.jmapper.integrationtest.operations.bean.Primitive2S;

public class Primitive2MockDS implements IMockDS<Primitive2D, Primitive2S>{

	public IObjDS<Primitive2D, Primitive2S> AllAll() {
		return new ObjDS<Primitive2D, Primitive2S>(AllD(),AllAllOutputD(),AllS());
	}
	
	public IObjDS<Primitive2D, Primitive2S> AllValued() {
		return new ObjDS<Primitive2D, Primitive2S>(ValuedD(),AllValuedOuputD(),ValuedS());
	}

	public IObjDS<Primitive2D, Primitive2S> ValuedNull() {
		return new ObjDS<Primitive2D, Primitive2S>(ValuedD(),AllValuedOuputD(),ValuedS());
	}
	
	public IObjDS<Primitive2D, Primitive2S> ValuedAll() {
		return new ObjDS<Primitive2D, Primitive2S>(AllD(),AllAllOutputD(),AllS());
	}

	public IObjDS<Primitive2D, Primitive2S> ValuedValued() {
		return new ObjDS<Primitive2D, Primitive2S>(ValuedD(),AllValuedOuputD(),ValuedS());
	}

	public IObjDS<Primitive2D, Primitive2S> NullValued() {
		return new ObjDS<Primitive2D, Primitive2S>(ValuedD(),AllValuedOuputD(),ValuedS());
	}

	public IObjDS<Primitive2D, Primitive2S> NullInputObject() {
		return new ObjDS<Primitive2D, Primitive2S>(ValuedD(),null,ValuedS());
	}
	
	private Primitive2S AllS(){				return new Primitive2S(8, 8, true, 8, (float)8, true);	}
	private Primitive2D AllD(){				return new Primitive2D(2, 2, false, 3, (float)4, false);}
	private Primitive2S ValuedS(){			return new Primitive2S(8, 8, true, 8, null, null);		}
	private Primitive2D ValuedD(){			return new Primitive2D(8, 0, false, 8, (float)8, true);	}
	private Primitive2D AllAllOutputD(){	return new Primitive2D(8, 8, true, 8, (float)8, true);	}
	private Primitive2D AllValuedOuputD(){	return new Primitive2D(8, 0, false, 8, (float)8, true);	}
}
