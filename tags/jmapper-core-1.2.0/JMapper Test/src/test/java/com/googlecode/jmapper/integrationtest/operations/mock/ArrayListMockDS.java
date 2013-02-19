package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayListD;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayListS;

public class ArrayListMockDS implements IMockDS<ArrayListD, ArrayListS> {

	public IObjDS<ArrayListD, ArrayListS> AllAll() {
		return new ObjDS<ArrayListD, ArrayListS>(getDAll(), AllAllOutput(), getSAll());
	}

	public IObjDS<ArrayListD, ArrayListS> AllValued() {
		return new ObjDS<ArrayListD, ArrayListS>(getDAll(), AllValuedOutput(), getSValued());
	}

	public IObjDS<ArrayListD, ArrayListS> ValuedNull() {
		return new ObjDS<ArrayListD, ArrayListS>(getDValued(), ValuedNullOutput(), getSNull());
	}

	public IObjDS<ArrayListD, ArrayListS> ValuedAll() {
		return new ObjDS<ArrayListD, ArrayListS>(getDValued(), ValuedAllOutput(), getSAll());
	}

	public IObjDS<ArrayListD, ArrayListS> ValuedValued() {
		return new ObjDS<ArrayListD, ArrayListS>(getDValued(), ValuedValuedOutput(), getSValued());
	}

	public IObjDS<ArrayListD, ArrayListS> NullValued() {
		return new ObjDS<ArrayListD, ArrayListS>(getDNull(), NullValuedOutput(), getSValued());
	}

	public IObjDS<ArrayListD, ArrayListS> NullInputObject() {
		return new ObjDS<ArrayListD, ArrayListS>(getDAll(), null, getSAll());
	}

	/************************************ INPUT METHODS ************************************/
	private ArrayListD getDAll(){
		return new ArrayListD(new String[]{"D"},new Integer[]{0},new Date[]{new Date(800000000)});
	}
	private ArrayListS getSAll(){
		return new ArrayListS(list("S"),list(5),list(new Date(500000000)));
	}
	private ArrayListD getDValued(){
		return new ArrayListD(new String[]{"D"},null,new Date[]{new Date(800000000)});
	}
	private ArrayListS getSValued(){
		return new ArrayListS(list("S"),list(5),null);
	}
	private ArrayListD getDNull(){
		return new ArrayListD(null,new Integer[]{5},new Date[]{new Date(500000000)});
	}
	private ArrayListS getSNull(){
		return new ArrayListS(list("S"),list(5),null);
	}
	
	/************************************ OUTPUT METHODS ************************************/
	public ArrayListD AllAllOutput(){
		return new ArrayListD(new String[]{"D","S"},new Integer[]{0,5},new Date[]{new Date(800000000),new Date(500000000)});
	}
	public ArrayListD AllValuedOutput(){
		return new ArrayListD(new String[]{"D","S"},new Integer[]{0,5},new Date[]{new Date(800000000)});
	}
	public ArrayListD ValuedNullOutput(){
		return new ArrayListD(new String[]{"D"},null,null);
	}
	public ArrayListD ValuedAllOutput(){
		return new ArrayListD(new String[]{"D","S"},null,new Date[]{new Date(800000000),new Date(500000000)});
	}
	public ArrayListD ValuedValuedOutput(){
		return new ArrayListD(new String[]{"D","S"},null,new Date[]{new Date(800000000)});
	}
	public ArrayListD NullValuedOutput(){
		return new ArrayListD(new String[]{"S"},new Integer[]{5},new Date[]{new Date(500000000)});
	}

	private <T> List<T> list(T... items){
		ArrayList<T> list = new ArrayList<T>();
		for (T t : items)list.add(t);
		return list;
	}
}
