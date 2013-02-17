package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedArray;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedArrayD;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedArrayS;
import com.googlecode.jmapper.integrationtest.operations.bean.TargetArray;

public class MappedArrayMockDS implements IMockDS<MappedArrayD, MappedArrayS> {

	public IObjDS<MappedArrayD, MappedArrayS> AllAll() {
		return new ObjDS<MappedArrayD, MappedArrayS>(new MappedArrayD(),AllD(),AllS());
	}

	public IObjDS<MappedArrayD, MappedArrayS> AllValued() {
		return new ObjDS<MappedArrayD, MappedArrayS>(new MappedArrayD(),AllD(),AllS());
	}

	public IObjDS<MappedArrayD, MappedArrayS> ValuedNull() {
		return new ObjDS<MappedArrayD, MappedArrayS>(AllD(),new MappedArrayD(),new MappedArrayS());
	}

	public IObjDS<MappedArrayD, MappedArrayS> ValuedAll() {
		return new ObjDS<MappedArrayD, MappedArrayS>(new MappedArrayD(),new MappedArrayD(),AllS());
	}

	public IObjDS<MappedArrayD, MappedArrayS> ValuedValued() {
		return new ObjDS<MappedArrayD, MappedArrayS>(ValuedD(),ValuedValuedOuputD(),AllS());
	}

	public IObjDS<MappedArrayD, MappedArrayS> NullValued() {
		return new ObjDS<MappedArrayD, MappedArrayS>(new MappedArrayD(),AllD(),AllS());
	}

	public IObjDS<MappedArrayD, MappedArrayS> NullInputObject() {
		return new ObjDS<MappedArrayD, MappedArrayS>(AllD(),null,AllS());
	}

	private MappedArrayD AllD(){
		return new MappedArrayD(new TargetArray[]{new TargetArray("fieldS")});
	}
	private MappedArrayD ValuedD(){
		return new MappedArrayD(new TargetArray[]{new TargetArray("fieldD")});
	}
	
	private MappedArrayD ValuedValuedOuputD(){
		return new MappedArrayD(new TargetArray[]{new TargetArray("fieldD"),new TargetArray("fieldS")});
	}
	private MappedArrayS AllS(){
		return new MappedArrayS(new MappedArray[]{new MappedArray("fieldS")});
	}
}
