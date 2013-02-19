package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayD;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayS;

public class ArrayMockDS implements IMockDS<ArrayD, ArrayS> {

	public IObjDS<ArrayD, ArrayS> AllAll() {
		return new ObjDS<ArrayD, ArrayS>(getDAll(), AllAllOutput(), getSAll());
	}

	public IObjDS<ArrayD, ArrayS> AllValued() {
		return new ObjDS<ArrayD, ArrayS>(getDAll(), AllValuedOutput(), getSValued());
	}

	public IObjDS<ArrayD, ArrayS> ValuedNull() {
		return new ObjDS<ArrayD, ArrayS>(getDValued(), ValuedNullOutput(), getSNull());
	}

	public IObjDS<ArrayD, ArrayS> ValuedAll() {
		return new ObjDS<ArrayD, ArrayS>(getDValued(), ValuedAllOutput(), getSAll());
	}

	public IObjDS<ArrayD, ArrayS> ValuedValued() {
		return new ObjDS<ArrayD, ArrayS>(getDValued(), ValuedValuedOutput(), getSValued());
	}

	public IObjDS<ArrayD, ArrayS> NullValued() {
		return new ObjDS<ArrayD, ArrayS>(getDNull(), NullValuedOutput(), getSValued());
	}

	public IObjDS<ArrayD, ArrayS> NullInputObject() {
		return new ObjDS<ArrayD, ArrayS>(getDAll(), null, getSAll());
	}

	/************************************ INPUT METHODS ************************************/
	private ArrayD getDAll(){
		return new ArrayD(new String[]{"dest"}, new Integer[]{7357},new Character[]{'D'});
	}
	private ArrayS getSAll(){
		return new ArrayS(new String[]{"source"}, new Integer[]{5002},new Character[]{'S'});
	}
	private ArrayD getDValued(){
		return new ArrayD(null, new Integer[]{7357},new Character[]{'D'});
	}
	private ArrayS getSValued(){
		return new ArrayS(new String[]{"source"}, new Integer[]{5002},null);
	}
	private ArrayD getDNull(){
		return new ArrayD(new String[]{"dest"}, null,new Character[]{'D'});
	}
	private ArrayS getSNull(){
		return new ArrayS(new String[]{"source"}, new Integer[]{5002},null);
	}
	
	/************************************ OUTPUT METHODS ************************************/
	public ArrayD AllAllOutput(){
		return new ArrayD(new String[]{"dest","source"}, new Integer[]{7357,5002},new Character[]{'D','S'});
	}
	public ArrayD AllValuedOutput(){
		return new ArrayD(new String[]{"dest","source"}, new Integer[]{7357,5002},new Character[]{'D'});
	}
	public ArrayD ValuedNullOutput(){
		return new ArrayD(null, new Integer[]{7357},null);
	}
	public ArrayD ValuedAllOutput(){
		return new ArrayD(null, new Integer[]{7357,5002},new Character[]{'D','S'});
	}
	public ArrayD ValuedValuedOutput(){
		return new ArrayD(null, new Integer[]{7357,5002},new Character[]{'D'});
	}
	public ArrayD NullValuedOutput(){
		return new ArrayD(new String[]{"dest"}, new Integer[]{5002},new Character[]{'D'});
	}

}
