package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedArray;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedArrayD;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedArrayS;
import com.googlecode.jmapper.integrationtest.operations.bean.TargetArray;

public class MappedArrayMockS implements IMockS<MappedArrayD, MappedArrayS> {

	public IObjS<MappedArrayD, MappedArrayS> AllAll() {
		return new ObjS<MappedArrayD, MappedArrayS>(AllD(),AllS());
	}

	public IObjS<MappedArrayD, MappedArrayS> AllValued() {
		return new ObjS<MappedArrayD, MappedArrayS>(new MappedArrayD(),new MappedArrayS());
	}

	public IObjS<MappedArrayD, MappedArrayS> AllNull() {
		return new ObjS<MappedArrayD, MappedArrayS>(null,AllS());
	}

	private MappedArrayD AllD(){
		return new MappedArrayD(new TargetArray[]{new TargetArray("field")});
	}
	
	private MappedArrayS AllS(){
		return new MappedArrayS(new MappedArray[]{new MappedArray("field")});
	}
}
