package com.googlecode.jmapper.integrationtest.mock;

import com.googlecode.jmapper.integrationtest.mock.IObjDS;


public class ObjDS<D,S> implements IObjDS<D,S> {

	private D inputDestination;
	private D outputDestination;
	private S source;
	
	public S source() {
		return source;
	}

	public D inputDestination() {
		return inputDestination;
	}

	public D outputDestination() {
		return outputDestination;
	}

	/**
	 * @param inputDestination
	 * @param outputDestination
	 * @param source
	 */
	public ObjDS(D inputDestination, D outputDestination, S source) {
		this.inputDestination = inputDestination;
		this.outputDestination = outputDestination;
		this.source = source;
	}

//	/**
//	 * @param inputDestination
//	 * @param source
//	 */
//	public ObjDS(D inputDestination, S source) {
//		super();
//		this.inputDestination = inputDestination;
//		this.source = source;
//	}

	
}
