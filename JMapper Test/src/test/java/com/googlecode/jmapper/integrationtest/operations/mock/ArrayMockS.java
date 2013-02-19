package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayD;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayS;

public class ArrayMockS implements IMockS<ArrayD, ArrayS> {

	public IObjS<ArrayD, ArrayS> AllAll() {
		return new ObjS<ArrayD, ArrayS>(getDAll(), getSAll());
	}

	public IObjS<ArrayD, ArrayS> AllValued() {
		return new ObjS<ArrayD, ArrayS>(getDValued(), getSValued());
	}

	public IObjS<ArrayD, ArrayS> AllNull() {
		return new ObjS<ArrayD, ArrayS>(null, getSAll());
	}

	private ArrayD getDAll(){
		return new ArrayD(new String[]{"source"}, new Integer[]{5002},new Character[]{'S'});
	}
	
	private ArrayS getSAll(){
		return new ArrayS(new String[]{"source"}, new Integer[]{5002},new Character[]{'S'});
	}
	
	private ArrayD getDValued(){
		return new ArrayD(null, new Integer[]{5002},new Character[]{'S'});
	}
	
	private ArrayS getSValued(){
		return new ArrayS(null, new Integer[]{5002},new Character[]{'S'});
	}
}