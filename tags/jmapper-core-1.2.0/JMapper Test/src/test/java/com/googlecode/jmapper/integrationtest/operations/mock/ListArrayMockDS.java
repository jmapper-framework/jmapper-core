package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.ListArrayD;
import com.googlecode.jmapper.integrationtest.operations.bean.ListArrayS;

public class ListArrayMockDS implements IMockDS<ListArrayD, ListArrayS> {

	public IObjDS<ListArrayD, ListArrayS> AllAll() {
		return new ObjDS<ListArrayD, ListArrayS>(getDAll(), AllAllOutput(), getSAll());
	}

	public IObjDS<ListArrayD, ListArrayS> AllValued() {
		return new ObjDS<ListArrayD, ListArrayS>(getDAll(), AllValuedOutput(), getSValued());
	}

	public IObjDS<ListArrayD, ListArrayS> ValuedNull() {
		return new ObjDS<ListArrayD, ListArrayS>(getDValued(), ValuedNullOutput(), getSNull());
	}

	public IObjDS<ListArrayD, ListArrayS> ValuedAll() {
		return new ObjDS<ListArrayD, ListArrayS>(getDValued(), ValuedAllOutput(), getSAll());
	}

	public IObjDS<ListArrayD, ListArrayS> ValuedValued() {
		return new ObjDS<ListArrayD, ListArrayS>(getDValued(), ValuedValuedOutput(), getSValued());
	}

	public IObjDS<ListArrayD, ListArrayS> NullValued() {
		return new ObjDS<ListArrayD, ListArrayS>(getDNull(), NullValuedOutput(), getSValued());
	}

	public IObjDS<ListArrayD, ListArrayS> NullInputObject() {
		return new ObjDS<ListArrayD, ListArrayS>(getDAll(), null, getSAll());
	}

	/************************************ INPUT METHODS ************************************/
	private ListArrayD getDAll(){
		return new ListArrayD(list("D"),list(3),list(new Date(800000000)));
	}
	private ListArrayS getSAll(){
		return new ListArrayS(new String[]{"S"},new Integer[]{5},new Date[]{new Date(500000000)});
	}
	private ListArrayD getDValued(){
		return new ListArrayD(list("D"),list(3),null);
	}
	private ListArrayS getSValued(){
		return new ListArrayS(new String[]{"S"},null,new Date[]{new Date(500000000)});
	}
	private ListArrayD getDNull(){
		return new ListArrayD(list("D"),list(3),null);
	}
	private ListArrayS getSNull(){
		return new ListArrayS(null,new Integer[]{5},new Date[]{new Date(500000000)});
	}
	
	/************************************ OUTPUT METHODS ************************************/
	public ListArrayD AllAllOutput(){
		return new ListArrayD(list("D","S"),list(3,5),list(new Date(800000000),new Date(500000000)));
	}
	public ListArrayD AllValuedOutput(){
		return new ListArrayD(list("D","S"),list(3),list(new Date(800000000),new Date(500000000)));
	}
	public ListArrayD ValuedNullOutput(){
		return new ListArrayD(null,list(3),null);
	}
	public ListArrayD ValuedAllOutput(){
		return new ListArrayD(list("D","S"),list(3,5),null);
	}
	public ListArrayD ValuedValuedOutput(){
		return new ListArrayD(list("D","S"),list(3),null);
	}
	public ListArrayD NullValuedOutput(){
		return new ListArrayD(list("D"),list(3),list(new Date(500000000)));
	}

	private <T> List<T> list(T... items){
		ArrayList<T> list = new ArrayList<T>();
		for (T t : items)list.add(t);
		return list;
	}
}
