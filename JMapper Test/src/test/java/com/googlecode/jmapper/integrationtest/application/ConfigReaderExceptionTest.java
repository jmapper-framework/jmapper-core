package com.googlecode.jmapper.integrationtest.application;

import com.googlecode.jmapper.config.ConfigReader;
import com.googlecode.jmapper.config.Constants;
import com.googlecode.jmapper.config.MSG;
import com.googlecode.jmapper.exceptions.MappingErrorException;
import com.googlecode.jmapper.xml.XML;

import com.googlecode.jmapper.integrationtest.operations.bean.AnnConfigClass2;
import com.googlecode.jmapper.integrationtest.operations.bean.TargetClass;
import junit.framework.TestCase;

public class ConfigReaderExceptionTest extends TestCase {

	public void testExceptions(){
		
		ConfigReader config = new ConfigReader(AnnConfigClass2.class, TargetClass.class, new XML());
		
		/* IN CASO DI VALUE ERRATO
		 * incorrect configuration of the field {0} in {1} class: the field {2} doesn't exist in {3} class */
		try {
			config.retrieveTargetFieldName(AnnConfigClass2.class.getDeclaredField("errorField1"));
		}catch (Exception e) {
			assertEquals(MappingErrorException.class,e.getClass());
			assertEquals(MSG.INSTANCE.message(Constants.mappingErrorException4,"errorField1","AnnConfigClass2", "targetField","TargetClass"),e.getMessage());
		}
		
		/* IN CASO DI VALUE ERRATO CON CLASSES CORRETTO
		 * incorrect configuration of the field {0} in {1} class: the field {2} doesn't exist in {3} class */
		try {
			config.retrieveTargetFieldName(AnnConfigClass2.class.getDeclaredField("errorField2"));
		}catch (Exception e) {
			assertEquals(MappingErrorException.class,e.getClass());
			assertEquals(MSG.INSTANCE.message(Constants.mappingErrorException4,"errorField2","AnnConfigClass2", "targetField","TargetClass"),e.getMessage());
		}
		
		/* IN CASO DI ATRIBUTES ERRATO CON CLASSES CORRETTO
		 * incorrect configuration of the field {0} in {1} class: the field {2} doesn't exist in {3} class */
		try {
			config.retrieveTargetFieldName(AnnConfigClass2.class.getDeclaredField("errorField5"));
		}catch (Exception e) {
			assertEquals(MappingErrorException.class,e.getClass());
			assertEquals(MSG.INSTANCE.message(Constants.mappingErrorException4,"errorField5","AnnConfigClass2", "targetField","TargetClass"),e.getMessage());
		}

		/* IN CASO DI LUNGHEZZA DIVERSA TRA ATTRIBUTES E CLASSES
		 * configuration error in {0} field of {1} class: the length of the parameters, Classes and Attributes, aren't equal */
		try {
			config.retrieveTargetFieldName(AnnConfigClass2.class.getDeclaredField("errorField3"));
		}catch (Exception e) {
			assertEquals(MappingErrorException.class,e.getClass());
			assertEquals(MSG.INSTANCE.message(Constants.mappingErrorException2length,"errorField3","AnnConfigClass2"),e.getMessage());
		}

		/* IN CASO DI CLASSI INESISTENTI IN CLASSES
		 * incorrect configuration of the field {0} in {1} class: the {2} class doesn't exist in Classes parameter */
		try {
			config.retrieveTargetFieldName(AnnConfigClass2.class.getDeclaredField("errorField4"));
		}catch (Exception e) {
			assertEquals(MappingErrorException.class,e.getClass());
			assertEquals(MSG.INSTANCE.message(Constants.mappingErrorException3,"errorField4","AnnConfigClass2","TargetClass"),e.getMessage());
		}
		
		/* IN CASO DI ATTRIBUTES ERRATO
		 * configuration error in {0} field of {1} class */
		try {
			config.retrieveTargetFieldName(AnnConfigClass2.class.getDeclaredField("errorField6"));
		}catch (Exception e) {
			assertEquals(MappingErrorException.class,e.getClass());
			assertEquals(MSG.INSTANCE.message(Constants.mappingErrorException2,"errorField6","AnnConfigClass2","TargetClass"),e.getMessage());
		}
	}
}
