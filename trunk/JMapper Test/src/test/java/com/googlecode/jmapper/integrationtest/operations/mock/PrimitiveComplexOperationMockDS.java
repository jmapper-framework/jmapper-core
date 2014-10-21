package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.HashMap;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.PrimitiveComplexOperationD;
import com.googlecode.jmapper.integrationtest.operations.bean.PrimitiveComplexOperationS;

public class PrimitiveComplexOperationMockDS implements IMockDS<PrimitiveComplexOperationD, PrimitiveComplexOperationS> {

	public IObjDS<PrimitiveComplexOperationD, PrimitiveComplexOperationS> AllAll() {
		return new ObjDS<PrimitiveComplexOperationD, PrimitiveComplexOperationS>(getDAll(), AllAllOutput(), getSAll());
	}

	public IObjDS<PrimitiveComplexOperationD, PrimitiveComplexOperationS> AllValued() {
		return new ObjDS<PrimitiveComplexOperationD, PrimitiveComplexOperationS>(getDAll(), AllValuedOutput(), getSValued());
	}

	public IObjDS<PrimitiveComplexOperationD, PrimitiveComplexOperationS> ValuedNull() {
		return new ObjDS<PrimitiveComplexOperationD, PrimitiveComplexOperationS>(getDValued(), ValuedNullOutput(), getSNull());
	}

	public IObjDS<PrimitiveComplexOperationD, PrimitiveComplexOperationS> ValuedAll() {
		return new ObjDS<PrimitiveComplexOperationD, PrimitiveComplexOperationS>(getDValued(), ValuedAllOutput(), getSNull());
	}

	public IObjDS<PrimitiveComplexOperationD, PrimitiveComplexOperationS> ValuedValued() {
		return new ObjDS<PrimitiveComplexOperationD, PrimitiveComplexOperationS>(getDValued(), ValuedValuedOutput(), getSValued());
	}

	public IObjDS<PrimitiveComplexOperationD, PrimitiveComplexOperationS> NullValued() {
		return new ObjDS<PrimitiveComplexOperationD, PrimitiveComplexOperationS>(getDNull(), NullValuedOutput(), getSValued());
	}

	public IObjDS<PrimitiveComplexOperationD, PrimitiveComplexOperationS> NullInputObject() {
		return new ObjDS<PrimitiveComplexOperationD, PrimitiveComplexOperationS>(getDAll(), null, getSAll());
	}

	/************************************ INPUT METHODS ************************************/
	
	private HashMap<String,Object> map = new HashMap<String,Object>(){{put("longField",2L);}};
	
	private PrimitiveComplexOperationD getDAll(){
		return new PrimitiveComplexOperationD(1L);
	}
	private PrimitiveComplexOperationS getSAll(){
		return new PrimitiveComplexOperationS(map);
	}
	private PrimitiveComplexOperationD getDValued(){
		return new PrimitiveComplexOperationD(1L);
	}
	private PrimitiveComplexOperationS getSValued(){
		return new PrimitiveComplexOperationS(map);
	}
	private PrimitiveComplexOperationD getDNull(){
		return new PrimitiveComplexOperationD(1L);
	}
	private PrimitiveComplexOperationS getSNull(){
		return new PrimitiveComplexOperationS(null);
	}
	
	/************************************ OUTPUT METHODS ************************************/
	public PrimitiveComplexOperationD AllAllOutput(){
		return new PrimitiveComplexOperationD(2L);
	}
	public PrimitiveComplexOperationD AllValuedOutput(){
		return new PrimitiveComplexOperationD(2L);
	}
	public PrimitiveComplexOperationD ValuedNullOutput(){
		return new PrimitiveComplexOperationD(1L);
	}
	public PrimitiveComplexOperationD ValuedAllOutput(){
		return new PrimitiveComplexOperationD(1L);
	}
	public PrimitiveComplexOperationD ValuedValuedOutput(){
		return new PrimitiveComplexOperationD(2L);
	}
	public PrimitiveComplexOperationD NullValuedOutput(){
		return new PrimitiveComplexOperationD(1L);
	}

}
