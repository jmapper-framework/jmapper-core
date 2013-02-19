package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayListD;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayListS;

public class ArrayListMockS implements IMockS<ArrayListD, ArrayListS> {

	public IObjS<ArrayListD, ArrayListS> AllAll() {
		return new ObjS<ArrayListD, ArrayListS>(getDAll(), getSAll());
	}

	public IObjS<ArrayListD, ArrayListS> AllValued() {
		return new ObjS<ArrayListD, ArrayListS>(getDValued(), getSValued());
	}

	public IObjS<ArrayListD, ArrayListS> AllNull() {
		return new ObjS<ArrayListD, ArrayListS>(null, getSAll());
	}

	private ArrayListD getDAll(){
		return new ArrayListD(new String[]{"S"},new Integer[]{5},new Date[]{new Date(500000000)});
	}
	
	private ArrayListS getSAll(){
		return new ArrayListS(list("S"),list(5),list(new Date(500000000)));
	}
	
	private ArrayListD getDValued(){
		return new ArrayListD(new String[]{"S"},new Integer[]{5},null);
	}
	
	private ArrayListS getSValued(){
		return new ArrayListS(list("S"),list(5),null);
	}
	
	private <T> List<T> list(T... items){
		ArrayList<T> list = new ArrayList<T>();
		for (T t : items)list.add(t);
		return list;
	}
	
}