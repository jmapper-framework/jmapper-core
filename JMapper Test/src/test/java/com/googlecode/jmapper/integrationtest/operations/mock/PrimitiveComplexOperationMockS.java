package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.HashMap;

import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.PrimitiveComplexOperationD;
import com.googlecode.jmapper.integrationtest.operations.bean.PrimitiveComplexOperationS;

public class PrimitiveComplexOperationMockS implements IMockS<PrimitiveComplexOperationD, PrimitiveComplexOperationS> {

	public IObjS<PrimitiveComplexOperationD, PrimitiveComplexOperationS> AllAll() {
		return new ObjS<PrimitiveComplexOperationD, PrimitiveComplexOperationS>(getDAll(), getSAll());
	}

	public IObjS<PrimitiveComplexOperationD, PrimitiveComplexOperationS> AllValued() {
		return new ObjS<PrimitiveComplexOperationD, PrimitiveComplexOperationS>(getDValued(), getSValued());
	}

	public IObjS<PrimitiveComplexOperationD, PrimitiveComplexOperationS> AllNull() {
		return new ObjS<PrimitiveComplexOperationD, PrimitiveComplexOperationS>(null, getSAll());
	}

	private HashMap<String,Object> map = new HashMap<String,Object>(){{put("longField",new Long(2));}};
	
	private PrimitiveComplexOperationD getDAll(){
		return new PrimitiveComplexOperationD(2l);
	}
	
	private PrimitiveComplexOperationS getSAll(){
		return new PrimitiveComplexOperationS(map);
	}
	
	private PrimitiveComplexOperationD getDValued(){
		return new PrimitiveComplexOperationD(2l);
	}
	
	private PrimitiveComplexOperationS getSValued(){
		return new PrimitiveComplexOperationS(map);
	}
}