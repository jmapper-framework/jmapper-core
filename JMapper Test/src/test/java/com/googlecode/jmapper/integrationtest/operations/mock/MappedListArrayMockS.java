package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedArray;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedListArrayD;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedListArrayS;
import com.googlecode.jmapper.integrationtest.operations.bean.TargetArray;

import java.util.HashSet;
import java.util.Set;

public class MappedListArrayMockS implements IMockS<MappedListArrayD, MappedListArrayS> {

	public IObjS<MappedListArrayD, MappedListArrayS> AllAll() {
		return new ObjS<MappedListArrayD, MappedListArrayS>(getDAll(), getSAll());
	}

	public IObjS<MappedListArrayD, MappedListArrayS> AllValued() {
		return new ObjS<MappedListArrayD, MappedListArrayS>(getDValued(), getSValued());
	}

	public IObjS<MappedListArrayD, MappedListArrayS> AllNull() {
		return new ObjS<MappedListArrayD, MappedListArrayS>(null, getSAll());
	}

	private MappedListArrayD getDAll(){
		return new MappedListArrayD(set(new TargetArray("Source")));
	}
	
	private MappedListArrayS getSAll(){
		return new MappedListArrayS(new MappedArray[]{new MappedArray("Source")});
	}
	
	private MappedListArrayD getDValued(){
		return new MappedListArrayD(new HashSet<TargetArray>());
	}
	
	private MappedListArrayS getSValued(){
		return new MappedListArrayS(new MappedArray[]{});
	}
	
	private <T> Set<T> set(T... items){
		HashSet<T> set = new HashSet<T>();
		for (T t : items)set.add(t);
		return set;
	}
}