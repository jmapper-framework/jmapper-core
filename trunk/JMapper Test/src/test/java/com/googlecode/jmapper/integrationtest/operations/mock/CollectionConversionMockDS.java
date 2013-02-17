package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;

import com.googlecode.jmapper.integrationtest.mock.ACollectionMock;
import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.CollectionConversionD;
import com.googlecode.jmapper.integrationtest.operations.bean.CollectionConversionS;

public class CollectionConversionMockDS extends ACollectionMock implements IMockDS<CollectionConversionD, CollectionConversionS> {

	public IObjDS<CollectionConversionD, CollectionConversionS> AllAll() {
		return new ObjDS<CollectionConversionD, CollectionConversionS>(getDAll(), AllAllOutput(), getSAll());
	}

	public IObjDS<CollectionConversionD, CollectionConversionS> AllValued() {
		return new ObjDS<CollectionConversionD, CollectionConversionS>(getDAll(), AllValuedOutput(), getSValued());
	}

	public IObjDS<CollectionConversionD, CollectionConversionS> ValuedNull() {
		return new ObjDS<CollectionConversionD, CollectionConversionS>(getDValued(), ValuedNullOutput(), getSValued());
	}

	public IObjDS<CollectionConversionD, CollectionConversionS> ValuedAll() {
		return new ObjDS<CollectionConversionD, CollectionConversionS>(getDValued(), ValuedAllOutput(), getSAll());
	}

	public IObjDS<CollectionConversionD, CollectionConversionS> ValuedValued() {
		return new ObjDS<CollectionConversionD, CollectionConversionS>(getDValued(), ValuedValuedOutput(), getSValued());
	}

	public IObjDS<CollectionConversionD, CollectionConversionS> NullValued() {
		return new ObjDS<CollectionConversionD, CollectionConversionS>(getDValued(), NullValuedOutput(), getSValued());
	}

	public IObjDS<CollectionConversionD, CollectionConversionS> NullInputObject() {
		return new ObjDS<CollectionConversionD, CollectionConversionS>(getDAll(), null, getSAll());
	}

	private CollectionConversionD getDAll(){
		return new CollectionConversionD(add(new ArrayList<String>(),"2","1"), 
										 add(new ArrayList<Integer>(),4,3));
	}
	
	private CollectionConversionD getDValued(){
		return new CollectionConversionD(null,add(new ArrayList<Integer>(),4,3));
	}
	
	private CollectionConversionS getSAll(){
		return new CollectionConversionS(add(new ArrayList<Integer>(),10,20), 
										 add(new ArrayList<String>(),"30","40"));
	}

	private CollectionConversionS getSValued(){
		return new CollectionConversionS(null,add(new ArrayList<String>(),"30","40"));
	}
	
	private CollectionConversionD AllAllOutput(){
		return new CollectionConversionD(add(new ArrayList<String>(),"2","1","20","10"),
										 add(new ArrayList<Integer>(),4,3,40,30));
	}
	private CollectionConversionD AllValuedOutput(){
		return new CollectionConversionD(add(new ArrayList<String>(),"2","1"),
				add(new ArrayList<Integer>(),4,3,40,30));
	}
	private CollectionConversionD ValuedNullOutput(){
		return new CollectionConversionD(null,
										 add(new ArrayList<Integer>(),4,3));
	}
	private CollectionConversionD ValuedAllOutput(){
		return new CollectionConversionD(null,
										 add(new ArrayList<Integer>(),4,3,40,30));
	}
	private CollectionConversionD ValuedValuedOutput(){
		return new CollectionConversionD(null,
				 						 add(new ArrayList<Integer>(),4,3,40,30));
}
	private CollectionConversionD NullValuedOutput(){
		return new CollectionConversionD(null,
										 add(new ArrayList<Integer>(),4,3));
	}
}
