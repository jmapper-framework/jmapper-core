package com.googlecode.jmapper.integrationtest;


/**
 * @author Alessandro Vurro
 *
 */
public interface IDS {

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
	 * 			MappingType-D		VALUED
	 * 			MappingType-S		NULL
	 * */
	public void testValuedNull();
	
	/*
	 * 			MappingType-D		VALUED
	 * 			MappingType-S		ALL
	 * */	
	public void testValuedAll();
	
	/*
	 * 			MappingType-D		VALUED
	 * 			MappingType-S		VALUED
	 * */	
	public void testValuedValued();
	
	/*
	 * 			MappingType-D		NULL
	 * 			MappingType-S		VALUED
	 * */
	public void testNullValued();
	
	/*	
	 * 			Destination		NULL
	 * 			Source			NULL
	 * */
	public void testNullInputObject();
}
