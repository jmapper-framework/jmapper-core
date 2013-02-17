package com.googlecode.jmapper.integrationtest.application;

import static com.googlecode.jmapper.util.ClassesManager.retrieveField;

import com.googlecode.jmapper.config.ConfigReader;
import com.googlecode.jmapper.xml.XML;

import com.googlecode.jmapper.integrationtest.operations.bean.AnnConfigClass;
import com.googlecode.jmapper.integrationtest.operations.bean.TargetClass;
import junit.framework.TestCase;

/**
 * Testing of all type of permitted mappings. 
 * <p>See AnnConfigClass present in this package for more information.
 * 
 * @author Alessandro Vurro
 *
 * @see AnnConfigClass
 */
public class ConfigReaderTest extends TestCase {

	
	public void testMappingTypes(){
		
		ConfigReader config = new ConfigReader(AnnConfigClass.class, TargetClass.class, new XML());
		
		String fieldName = config.retrieveTargetFieldName(retrieveField(AnnConfigClass.class,"equalField1"));
		assertEquals("equalField1", fieldName);
			
		fieldName = config.retrieveTargetFieldName(retrieveField(AnnConfigClass.class,"equalField2"));
		assertEquals("equalField2", fieldName);
			
		fieldName = config.retrieveTargetFieldName(retrieveField(AnnConfigClass.class,"confField3"));
		assertEquals("targetField3", fieldName);
		
		fieldName = config.retrieveTargetFieldName(retrieveField(AnnConfigClass.class,"confField4"));
		assertEquals("targetField4", fieldName);
			
		fieldName = config.retrieveTargetFieldName(retrieveField(AnnConfigClass.class,"confField5"));
		assertEquals("targetField5", fieldName);
		
	}
	

}
