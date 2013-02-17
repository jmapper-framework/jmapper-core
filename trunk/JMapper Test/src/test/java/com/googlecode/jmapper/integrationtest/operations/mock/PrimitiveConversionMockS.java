package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.PrimitiveConversionD;
import com.googlecode.jmapper.integrationtest.operations.bean.PrimitiveConversionS;

public class PrimitiveConversionMockS implements
		IMockS<PrimitiveConversionD, PrimitiveConversionS> {

	public IObjS<PrimitiveConversionD, PrimitiveConversionS> AllAll() {
		return new ObjS<PrimitiveConversionD, PrimitiveConversionS>(getAllD(),getAllS());
	}

	public IObjS<PrimitiveConversionD, PrimitiveConversionS> AllValued() {
		return new ObjS<PrimitiveConversionD, PrimitiveConversionS>(getValuedD(),getValuedS());
	}

	public IObjS<PrimitiveConversionD, PrimitiveConversionS> AllNull() {
		return new ObjS<PrimitiveConversionD, PrimitiveConversionS>(null,getAllS());
	}

	private PrimitiveConversionD getAllD(){
		return new PrimitiveConversionD("2", "2", 2, 2, "2.2", 2);
	}
	private PrimitiveConversionD getValuedD(){
		return new PrimitiveConversionD("2", "2", 0, 2, "2.2", 0);
	}
	private PrimitiveConversionS getAllS(){
		return new PrimitiveConversionS(2, 2, "2", "2", 2.2, 2.2);	
	}
	private PrimitiveConversionS getValuedS(){
		return new PrimitiveConversionS(2, 2, null, "2", 2.2, null);	
	}
}
