package com.googlecode.jmapper.integrationtest.mock;

public interface IObjDS<D,S> {

	public S source();
	
	public D inputDestination();
	
	public D outputDestination();
}
