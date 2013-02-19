package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;

import com.googlecode.jmapper.integrationtest.mock.ACollectionMock;
import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.CollectionConversionD;
import com.googlecode.jmapper.integrationtest.operations.bean.CollectionConversionS;

public class CollectionConversionMockS extends ACollectionMock implements IMockS<CollectionConversionD, CollectionConversionS> {

	public IObjS<CollectionConversionD, CollectionConversionS> AllAll() {
		return new ObjS<CollectionConversionD, CollectionConversionS>(getDAll(), getSAll());
	}

	public IObjS<CollectionConversionD, CollectionConversionS> AllValued() {
		return new ObjS<CollectionConversionD, CollectionConversionS>(getDAll(), getSAll());
	}

	public IObjS<CollectionConversionD, CollectionConversionS> AllNull() {
		return new ObjS<CollectionConversionD, CollectionConversionS>(null, getSAll());
	}

	private CollectionConversionD getDAll(){
		return new CollectionConversionD(add(new ArrayList<String>(),"2","1"), 
										 add(new ArrayList<Integer>(),4,3));
	}
	
	private CollectionConversionS getSAll(){
		return new CollectionConversionS(add(new ArrayList<Integer>(),1,2), 
										 add(new ArrayList<String>(),"3","4"));
	}
}