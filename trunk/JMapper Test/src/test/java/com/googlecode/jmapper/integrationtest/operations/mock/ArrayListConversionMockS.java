package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayListConversionD;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayListConversionS;

public class ArrayListConversionMockS implements IMockS<ArrayListConversionD, ArrayListConversionS> {

	public IObjS<ArrayListConversionD, ArrayListConversionS> AllAll() {
		return new ObjS<ArrayListConversionD, ArrayListConversionS>(getDAll(), getSAll());
	}

	public IObjS<ArrayListConversionD, ArrayListConversionS> AllValued() {
		return new ObjS<ArrayListConversionD, ArrayListConversionS>(getDValued(), getSValued());
	}

	public IObjS<ArrayListConversionD, ArrayListConversionS> AllNull() {
		return new ObjS<ArrayListConversionD, ArrayListConversionS>(null, getSAll());
	}

	private ArrayListConversionD getDAll(){
		return new ArrayListConversionD(new String[]{"5"},new int[]{5},new char[]{'S'});
	}
	
	private ArrayListConversionS getSAll(){
		return new ArrayListConversionS(list(5L),list(5),list("Source"));
	}
	
	private ArrayListConversionD getDValued(){
		return new ArrayListConversionD(new String[]{"5"},new int[]{5},null);
	}
	
	private ArrayListConversionS getSValued(){
		return new ArrayListConversionS(list(5L),list(5),null);
	}
	
	private <T> List<T> list(T... items){
		ArrayList<T> list = new ArrayList<T>();
		for (T t : items)list.add(t);
		return list;
	}

}