package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.HashSet;
import java.util.Set;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedArray;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedListArrayD;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedListArrayS;
import com.googlecode.jmapper.integrationtest.operations.bean.TargetArray;

public class MappedListArrayMockDS implements IMockDS<MappedListArrayD, MappedListArrayS> {

	public IObjDS<MappedListArrayD, MappedListArrayS> AllAll() {
		return new ObjDS<MappedListArrayD, MappedListArrayS>(getDAll(), AllAllOutput(), getSAll());
	}

	public IObjDS<MappedListArrayD, MappedListArrayS> AllValued() {
		return new ObjDS<MappedListArrayD, MappedListArrayS>(getDAll(), AllValuedOutput(), getSValued());
	}

	public IObjDS<MappedListArrayD, MappedListArrayS> ValuedNull() {
		return new ObjDS<MappedListArrayD, MappedListArrayS>(getDValued(), ValuedNullOutput(), getSNull());
	}

	public IObjDS<MappedListArrayD, MappedListArrayS> ValuedAll() {
		return new ObjDS<MappedListArrayD, MappedListArrayS>(getDValued(), ValuedAllOutput(), getSAll());
	}

	public IObjDS<MappedListArrayD, MappedListArrayS> ValuedValued() {
		return new ObjDS<MappedListArrayD, MappedListArrayS>(getDValued(), ValuedValuedOutput(), getSValued());
	}

	public IObjDS<MappedListArrayD, MappedListArrayS> NullValued() {
		return new ObjDS<MappedListArrayD, MappedListArrayS>(getDNull(), NullValuedOutput(), getSValued());
	}

	public IObjDS<MappedListArrayD, MappedListArrayS> NullInputObject() {
		return new ObjDS<MappedListArrayD, MappedListArrayS>(getDAll(), null, getSAll());
	}

	/************************************ INPUT METHODS ************************************/
	private MappedListArrayD getDAll(){
		return new MappedListArrayD(set(new TargetArray("Destination")));
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
	private MappedListArrayD getDNull(){
		return new MappedListArrayD(null);
	}
	private MappedListArrayS getSNull(){
		return new MappedListArrayS(null);
	}
	
	/************************************ OUTPUT METHODS ************************************/
	public MappedListArrayD AllAllOutput(){
		return new MappedListArrayD(set(new TargetArray("Destination"),new TargetArray("Source")));
	}
	public MappedListArrayD AllValuedOutput(){
		return new MappedListArrayD(set(new TargetArray("Destination")));
	}
	public MappedListArrayD ValuedNullOutput(){
		return new MappedListArrayD(null);
	}
	public MappedListArrayD ValuedAllOutput(){
		return new MappedListArrayD(set(new TargetArray("Source")));
	}
	public MappedListArrayD ValuedValuedOutput(){
		return new MappedListArrayD(new HashSet<TargetArray>());
	}
	public MappedListArrayD NullValuedOutput(){
		return new MappedListArrayD(new HashSet<TargetArray>());
	}

	private <T> Set<T> set(T... items){
		HashSet<T> set = new HashSet<T>();
		for (T t : items)set.add(t);
		return set;
	}
}
