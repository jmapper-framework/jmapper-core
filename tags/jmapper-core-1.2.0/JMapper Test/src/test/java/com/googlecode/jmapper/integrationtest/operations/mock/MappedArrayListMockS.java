package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.HashSet;
import java.util.Set;

import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedArray;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedArrayListD;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedArrayListS;
import com.googlecode.jmapper.integrationtest.operations.bean.TargetArray;

public class MappedArrayListMockS implements IMockS<MappedArrayListD, MappedArrayListS> {

	public IObjS<MappedArrayListD, MappedArrayListS> AllAll() {
		return new ObjS<MappedArrayListD, MappedArrayListS>(getDAll(), getSAll());
	}

	public IObjS<MappedArrayListD, MappedArrayListS> AllValued() {
		return new ObjS<MappedArrayListD, MappedArrayListS>(getDValued(), getSValued());
	}

	public IObjS<MappedArrayListD, MappedArrayListS> AllNull() {
		return new ObjS<MappedArrayListD, MappedArrayListS>(null, getSAll());
	}

	private MappedArrayListD getDAll(){
		return new MappedArrayListD(new TargetArray[]{new TargetArray("Source")});
	}
	
	private MappedArrayListS getSAll(){
		return new MappedArrayListS(set(new MappedArray("Source")));
	}
	
	private MappedArrayListD getDValued(){
		return new MappedArrayListD(new TargetArray[]{});
	}
	
	private MappedArrayListS getSValued(){
		return new MappedArrayListS(new HashSet<MappedArray>());
	}
	
	private <T> Set<T> set(T... items){
		HashSet<T> set = new HashSet<T>();
		for (T t : items)set.add(t);
		return set;
	}
}