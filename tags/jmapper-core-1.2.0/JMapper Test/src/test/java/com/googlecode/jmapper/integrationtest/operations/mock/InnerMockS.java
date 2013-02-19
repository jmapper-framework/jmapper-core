package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.InnerD;
import com.googlecode.jmapper.integrationtest.operations.bean.InnerS;

public class InnerMockS implements IMockS<InnerD, InnerS> {

	public IObjS<InnerD, InnerS> AllAll() {
		return new ObjS<InnerD, InnerS>(AllD(), AllS());
	}

	public IObjS<InnerD, InnerS> AllValued() {
		return new ObjS<InnerD, InnerS>(ValuedD(), ValuedS());
	}

	public IObjS<InnerD, InnerS> AllNull() {
		return new ObjS<InnerD, InnerS>(null, AllS());
	}

	public InnerS AllS(){
		return new InnerS(new InnerS.Class("field", "field2", "field3"));
	}
	
	public InnerD AllD(){
		return new InnerD(new InnerD.Class("field", "field2", "field3"));
	}
	
	public InnerS ValuedS(){
		return new InnerS(new InnerS.Class("field", null, "field3"));
	}
	
	public InnerD ValuedD(){
		return new InnerD(new InnerD.Class("field", null, "field3"));
	}
}
