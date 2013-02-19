package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.HashSet;
import java.util.Set;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedArray;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedArrayListD;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedArrayListS;
import com.googlecode.jmapper.integrationtest.operations.bean.TargetArray;

public class MappedArrayListMockDS implements IMockDS<MappedArrayListD, MappedArrayListS> {

	public IObjDS<MappedArrayListD, MappedArrayListS> AllAll() {
		return new ObjDS<MappedArrayListD, MappedArrayListS>(getDAll(), AllAllOutput(), getSAll());
	}

	public IObjDS<MappedArrayListD, MappedArrayListS> AllValued() {
		return new ObjDS<MappedArrayListD, MappedArrayListS>(getDAll(), AllValuedOutput(), getSValued());
	}

	public IObjDS<MappedArrayListD, MappedArrayListS> ValuedNull() {
		return new ObjDS<MappedArrayListD, MappedArrayListS>(getDValued(), ValuedNullOutput(), getSNull());
	}

	public IObjDS<MappedArrayListD, MappedArrayListS> ValuedAll() {
		return new ObjDS<MappedArrayListD, MappedArrayListS>(getDValued(), ValuedAllOutput(), getSAll());
	}

	public IObjDS<MappedArrayListD, MappedArrayListS> ValuedValued() {
		return new ObjDS<MappedArrayListD, MappedArrayListS>(getDValued(), ValuedValuedOutput(), getSValued());
	}

	public IObjDS<MappedArrayListD, MappedArrayListS> NullValued() {
		return new ObjDS<MappedArrayListD, MappedArrayListS>(getDNull(), NullValuedOutput(), getSValued());
	}

	public IObjDS<MappedArrayListD, MappedArrayListS> NullInputObject() {
		return new ObjDS<MappedArrayListD, MappedArrayListS>(getDAll(), null, getSAll());
	}

	/************************************ INPUT METHODS ************************************/
	private MappedArrayListD getDAll(){
		return new MappedArrayListD(new TargetArray[]{new TargetArray("Destination")});
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
	private MappedArrayListD getDNull(){
		return new MappedArrayListD(null);
	}
	private MappedArrayListS getSNull(){
		return new MappedArrayListS(null);
	}
	
	/************************************ OUTPUT METHODS ************************************/
	public MappedArrayListD AllAllOutput(){
		return new MappedArrayListD(new TargetArray[]{new TargetArray("Destination"),new TargetArray("Source")});
	}
	public MappedArrayListD AllValuedOutput(){
		return new MappedArrayListD(new TargetArray[]{new TargetArray("Destination")});
	}
	public MappedArrayListD ValuedNullOutput(){
		return new MappedArrayListD(null);
	}
	public MappedArrayListD ValuedAllOutput(){
		return new MappedArrayListD(new TargetArray[]{new TargetArray("Source")});
	}
	public MappedArrayListD ValuedValuedOutput(){
		return new MappedArrayListD(new TargetArray[]{});
	}
	public MappedArrayListD NullValuedOutput(){
		return new MappedArrayListD(new TargetArray[]{});
	}
	
	private <T> Set<T> set(T... items){
		HashSet<T> set = new HashSet<T>();
		for (T t : items)set.add(t);
		return set;
	}

}
