package com.googlecode.jmapper.integrationtest.mock;

import com.googlecode.jmapper.integrationtest.mock.IObjDS;

public interface IMockDS<D,S> {

	public IObjDS<D,S> AllAll();
	
	public IObjDS<D,S> AllValued();
	
	public IObjDS<D,S> ValuedNull();
	
	public IObjDS<D,S> ValuedAll();
	
	public IObjDS<D,S> ValuedValued();
	
	public IObjDS<D,S> NullValued();
	
	public IObjDS<D,S> NullInputObject();
}
