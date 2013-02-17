package com.googlecode.jmapper.integrationtest.mock;

import com.googlecode.jmapper.integrationtest.mock.IObjS;

public interface IMockS<D,S> {

	public IObjS<D,S> AllAll();
	
	public IObjS<D,S> AllValued();
	
	public IObjS<D,S> AllNull();
}
