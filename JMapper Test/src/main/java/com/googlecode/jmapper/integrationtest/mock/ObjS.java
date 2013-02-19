package com.googlecode.jmapper.integrationtest.mock;

import com.googlecode.jmapper.integrationtest.mock.IObjS;


public class ObjS<D,S> implements IObjS<D,S> {

	private D outputDestination;
	private S source;
	
	public D outputDestination() {
		return outputDestination;
	}
	
	public S source() {
		return source;
	}

	/**
	 * @param source
	 * @param outputDestination
	 */
	public ObjS(D outputDestination, S source) {
		super();
		this.outputDestination = outputDestination;
		this.source = source;
	}

	
}
