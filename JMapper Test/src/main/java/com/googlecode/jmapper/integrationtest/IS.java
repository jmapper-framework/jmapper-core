package com.googlecode.jmapper.integrationtest;


/**
 * @author Alessandro Vurro
 *
 */
public interface IS {

	/*
	 * 			WITHOUT CONTROL
	 * 
	 * 			MappingType-D		ALL
	 * 			MappingType-S		ALL
	 * */
	public void testAllAllWithoutControl();

	/*
	 * 			MappingType-D		ALL
	 * 			MappingType-S		ALL
	 * */
	public void testAllAll();
	
	/*
	 * 			MappingType-D		ALL
	 * 			MappingType-S		VALUED
	 * */
	public void testAllValued();
	
	/*
	 * 			MappingType-D		ALL
	 * 			MappingType-S		NULL
	 * */
	public void testAllNull();
	
	/*	
	 * 			Destination		NULL
	 * 			Source			NULL
	 * */
	public void testNullInputObject();
}
