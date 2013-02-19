package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayListConversionD;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayListConversionS;

public class ArrayListConversionMockDS implements IMockDS<ArrayListConversionD, ArrayListConversionS> {

	public IObjDS<ArrayListConversionD, ArrayListConversionS> AllAll() {
		return new ObjDS<ArrayListConversionD, ArrayListConversionS>(getDAll(), AllAllOutput(), getSAll());
	}

	public IObjDS<ArrayListConversionD, ArrayListConversionS> AllValued() {
		return new ObjDS<ArrayListConversionD, ArrayListConversionS>(getDAll(), AllValuedOutput(), getSValued());
	}

	public IObjDS<ArrayListConversionD, ArrayListConversionS> ValuedNull() {
		return new ObjDS<ArrayListConversionD, ArrayListConversionS>(getDValued(), ValuedNullOutput(), getSNull());
	}

	public IObjDS<ArrayListConversionD, ArrayListConversionS> ValuedAll() {
		return new ObjDS<ArrayListConversionD, ArrayListConversionS>(getDValued(), ValuedAllOutput(), getSAll());
	}

	public IObjDS<ArrayListConversionD, ArrayListConversionS> ValuedValued() {
		return new ObjDS<ArrayListConversionD, ArrayListConversionS>(getDValued(), ValuedValuedOutput(), getSValued());
	}

	public IObjDS<ArrayListConversionD, ArrayListConversionS> NullValued() {
		return new ObjDS<ArrayListConversionD, ArrayListConversionS>(getDNull(), NullValuedOutput(), getSValued());
	}

	public IObjDS<ArrayListConversionD, ArrayListConversionS> NullInputObject() {
		return new ObjDS<ArrayListConversionD, ArrayListConversionS>(getDAll(), null, getSAll());
	}

	/************************************ INPUT METHODS ************************************/
	private ArrayListConversionD getDAll(){
		return new ArrayListConversionD(new String[]{"3"},new int[]{3},new char[]{'D'});
	}
	private ArrayListConversionS getSAll(){
		return new ArrayListConversionS(list(5L),list(5),list("Source"));
	}
	private ArrayListConversionD getDValued(){
		return new ArrayListConversionD(new String[]{"3"},null,new char[]{'D'});
	}
	private ArrayListConversionS getSValued(){
		return new ArrayListConversionS(null,list(5),list("Source"));
	}
	private ArrayListConversionD getDNull(){
		return new ArrayListConversionD(new String[]{"3"},new int[]{3},null);
	}
	private ArrayListConversionS getSNull(){
		return new ArrayListConversionS(null,list(5),list("Source"));
	}
	
	/************************************ OUTPUT METHODS ************************************/
	public ArrayListConversionD AllAllOutput(){
		return new ArrayListConversionD(new String[]{"3","5"},new int[]{3,5},new char[]{'D','S'});
	}
	public ArrayListConversionD AllValuedOutput(){
		return new ArrayListConversionD(new String[]{"3"},new int[]{3,5},new char[]{'D','S'});
	}
	public ArrayListConversionD ValuedNullOutput(){
		return new ArrayListConversionD(null,null,new char[]{'D'});
	}
	public ArrayListConversionD ValuedAllOutput(){
		return new ArrayListConversionD(new String[]{"3","5"},null,new char[]{'D','S'});
	}
	public ArrayListConversionD ValuedValuedOutput(){
		return new ArrayListConversionD(new String[]{"3"},null,new char[]{'D','S'});
	}
	public ArrayListConversionD NullValuedOutput(){
		return new ArrayListConversionD(new String[]{"3"},new int[]{3},new char[]{'S'});
	}

	private <T> List<T> list(T... items){
		ArrayList<T> list = new ArrayList<T>();
		for (T t : items)list.add(t);
		return list;
	}
}
