package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayConversionD;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayConversionS;

public class ArrayConversionMockS implements IMockS<ArrayConversionD, ArrayConversionS> {

	public IObjS<ArrayConversionD, ArrayConversionS> AllAll() {
		return new ObjS<ArrayConversionD, ArrayConversionS>(getDAll(), getSAll());
	}

	public IObjS<ArrayConversionD, ArrayConversionS> AllValued() {
		return new ObjS<ArrayConversionD, ArrayConversionS>(getDValued(), getSValued());
	}

	public IObjS<ArrayConversionD, ArrayConversionS> AllNull() {
		return new ObjS<ArrayConversionD, ArrayConversionS>(null, getSAll());
	}

	private ArrayConversionD getDAll(){
		return new ArrayConversionD(new String[]{"5003"},new Integer[]{5003},new Double[]{2.0});
	}
	
	private ArrayConversionS getSAll(){
		return new ArrayConversionS(new Integer[]{5003},new String[]{"5003"},new int[]{2});
	}
	
	private ArrayConversionD getDValued(){
		return new ArrayConversionD(null,new Integer[]{5003},new Double[]{2.0});
	}
	
	private ArrayConversionS getSValued(){
		return new ArrayConversionS(null,new String[]{"5003"},new int[]{2});
	}
}