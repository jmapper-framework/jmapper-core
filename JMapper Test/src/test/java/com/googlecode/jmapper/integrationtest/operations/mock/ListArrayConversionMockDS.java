package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.ListArrayConversionD;
import com.googlecode.jmapper.integrationtest.operations.bean.ListArrayConversionS;

public class ListArrayConversionMockDS implements IMockDS<ListArrayConversionD, ListArrayConversionS> {

	public IObjDS<ListArrayConversionD, ListArrayConversionS> AllAll() {
		return new ObjDS<ListArrayConversionD, ListArrayConversionS>(getDAll(), AllAllOutput(), getSAll());
	}

	public IObjDS<ListArrayConversionD, ListArrayConversionS> AllValued() {
		return new ObjDS<ListArrayConversionD, ListArrayConversionS>(getDAll(), AllValuedOutput(), getSValued());
	}

	public IObjDS<ListArrayConversionD, ListArrayConversionS> ValuedNull() {
		return new ObjDS<ListArrayConversionD, ListArrayConversionS>(getDValued(), ValuedNullOutput(), getSNull());
	}

	public IObjDS<ListArrayConversionD, ListArrayConversionS> ValuedAll() {
		return new ObjDS<ListArrayConversionD, ListArrayConversionS>(getDValued(), ValuedAllOutput(), getSAll());
	}

	public IObjDS<ListArrayConversionD, ListArrayConversionS> ValuedValued() {
		return new ObjDS<ListArrayConversionD, ListArrayConversionS>(getDValued(), ValuedValuedOutput(), getSValued());
	}

	public IObjDS<ListArrayConversionD, ListArrayConversionS> NullValued() {
		return new ObjDS<ListArrayConversionD, ListArrayConversionS>(getDNull(), NullValuedOutput(), getSValued());
	}

	public IObjDS<ListArrayConversionD, ListArrayConversionS> NullInputObject() {
		return new ObjDS<ListArrayConversionD, ListArrayConversionS>(getDAll(), null, getSAll());
	}

	/************************************ INPUT METHODS ************************************/
	private ListArrayConversionD getDAll(){
		return new ListArrayConversionD(list(3L),list(3),list("Destination"));
	}
	private ListArrayConversionS getSAll(){
		return new ListArrayConversionS(new String[]{"5"},new int[]{5},new char[]{'S'});
	}
	private ListArrayConversionD getDValued(){
		return new ListArrayConversionD(null,list(3),list("Destination"));
	}
	private ListArrayConversionS getSValued(){
		return new ListArrayConversionS(new String[]{"5"},null,new char[]{'S'});
	}
	private ListArrayConversionD getDNull(){
		return new ListArrayConversionD(null,list(3),list("Destination"));
	}
	private ListArrayConversionS getSNull(){
		return new ListArrayConversionS(new String[]{"5"},new int[]{5},null);
	}
	
	/************************************ OUTPUT METHODS ************************************/
	public ListArrayConversionD AllAllOutput(){
		return new ListArrayConversionD(list(3L,5L),list(3,5),list("Destination","S"));
	}
	public ListArrayConversionD AllValuedOutput(){
		return new ListArrayConversionD(list(3L,5L),list(3),list("Destination","S"));
	}
	public ListArrayConversionD ValuedNullOutput(){
		return new ListArrayConversionD(null,list(3),null);
	}
	public ListArrayConversionD ValuedAllOutput(){
		return new ListArrayConversionD(null,list(3,5),list("Destination","S"));
	}
	public ListArrayConversionD ValuedValuedOutput(){
		return new ListArrayConversionD(null,list(3),list("Destination","S"));
	}
	public ListArrayConversionD NullValuedOutput(){
		return new ListArrayConversionD(list(5L),list(3),list("Destination"));
	}

	private <T> List<T> list(T... items){
		ArrayList<T> list = new ArrayList<T>();
		for (T t : items)list.add(t);
		return list;
	}
}
