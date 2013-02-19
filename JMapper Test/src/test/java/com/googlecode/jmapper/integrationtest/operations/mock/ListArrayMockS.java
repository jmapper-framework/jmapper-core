package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.ListArrayD;
import com.googlecode.jmapper.integrationtest.operations.bean.ListArrayS;

public class ListArrayMockS implements IMockS<ListArrayD, ListArrayS> {

	public IObjS<ListArrayD, ListArrayS> AllAll() {
		return new ObjS<ListArrayD, ListArrayS>(getDAll(), getSAll());
	}

	public IObjS<ListArrayD, ListArrayS> AllValued() {
		return new ObjS<ListArrayD, ListArrayS>(getDValued(), getSValued());
	}

	public IObjS<ListArrayD, ListArrayS> AllNull() {
		return new ObjS<ListArrayD, ListArrayS>(null, getSAll());
	}

	private ListArrayD getDAll(){
		return new ListArrayD(list("S"),list(5),list(new Date(500000000)));
	}
	
	private ListArrayS getSAll(){
		return new ListArrayS(new String[]{"S"},new Integer[]{5},new Date[]{new Date(500000000)});
	}
	
	private ListArrayD getDValued(){
		return new ListArrayD(list("S"),list(5),null);
	}
	
	private ListArrayS getSValued(){
		return new ListArrayS(new String[]{"S"},new Integer[]{5},null);
	}
	
	private <T> List<T> list(T... items){
		ArrayList<T> list = new ArrayList<T>();
		for (T t : items)list.add(t);
		return list;
	}
}