package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.ListArrayConversionD;
import com.googlecode.jmapper.integrationtest.operations.bean.ListArrayConversionS;

public class ListArrayConversionMockS implements IMockS<ListArrayConversionD, ListArrayConversionS> {

	public IObjS<ListArrayConversionD, ListArrayConversionS> AllAll() {
		return new ObjS<ListArrayConversionD, ListArrayConversionS>(getDAll(), getSAll());
	}

	public IObjS<ListArrayConversionD, ListArrayConversionS> AllValued() {
		return new ObjS<ListArrayConversionD, ListArrayConversionS>(getDValued(), getSValued());
	}

	public IObjS<ListArrayConversionD, ListArrayConversionS> AllNull() {
		return new ObjS<ListArrayConversionD, ListArrayConversionS>(null, getSAll());
	}

	private ListArrayConversionD getDAll(){
		return new ListArrayConversionD(list(5L),list(5),list("S"));
	}
	
	private ListArrayConversionS getSAll(){
		return new ListArrayConversionS(new String[]{"5"},new int[]{5},new char[]{'S'});
	}
	
	private ListArrayConversionD getDValued(){
		return new ListArrayConversionD(list(5L),list(5),null);
	}
	
	private ListArrayConversionS getSValued(){
		return new ListArrayConversionS(new String[]{"5"},new int[]{5},null);
	}
	
	private <T> List<T> list(T... items){
		ArrayList<T> list = new ArrayList<T>();
		for (T t : items)list.add(t);
		return list;
	}
	
}