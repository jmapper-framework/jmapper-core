package com.googlecode.jmapper.integrationtest.application;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import com.googlecode.jmapper.exceptions.JMapperException;
import com.googlecode.jmapper.integrationtest.operations.bean.AnnotatedClass;
import com.googlecode.jmapper.integrationtest.operations.bean.AnnotatedClass2;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedObject;
import com.googlecode.jmapper.integrationtest.operations.bean.Obj;
import com.googlecode.jmapper.integrationtest.operations.bean.TargetClass;

import java.io.ByteArrayOutputStream;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.RelationalJMapper;
import com.googlecode.jmapper.api.enums.MappingType;
import com.googlecode.jmapper.api.enums.NullPointerControl;

public class RelationalJMapperExceptionTest extends TestCase {

	ByteArrayOutputStream log;
	
	public RelationalJMapperExceptionTest() {
		PropertyConfigurator.configure("log4j.properties");
		log = new ByteArrayOutputStream();  
		Logger.getLogger(JMapper.class).addAppender(new WriterAppender(new SimpleLayout(), log));
	}
	
	public void testConstructorParameters(){

		log.reset();
    	try{
    		new RelationalJMapper<TargetClass>(TargetClass.class);
		}catch(JMapperException e){	e.printStackTrace(); }
		assertEquals("ERROR - ClassNotMappedException: the TargetClass Class isn't mapped"+newLine, log.toString());
		
		log.reset();
    	try{
    		new RelationalJMapper<MappedObject>(MappedObject.class);
		}catch(JMapperException e){	e.printStackTrace(); }
		assertEquals("ERROR - MappingErrorException: the mapping configuration, of the intS field beloging to MappedObject Class, doesn't contain classes"+newLine, log.toString());
		
		log.reset();
    	try{
    		new RelationalJMapper<AnnotatedClass2>(AnnotatedClass2.class);
		}catch(JMapperException e){	e.printStackTrace(); }
		assertEquals("", log.toString());
	}
	
	public void testManyToOneMethods(){
		
		RelationalJMapper<AnnotatedClass> mapper = new RelationalJMapper<AnnotatedClass>(AnnotatedClass.class);
		AnnotatedClass expected = null;
		AnnotatedClass actual = null;
		log.reset();
		try{
			actual = mapper.manyToOne(new Obj());
		}catch(JMapperException e){	e.printStackTrace(); }
		assertEquals("ERROR - ClassNotMappedException: the Obj Class isn't mapped in AnnotatedClass Class"+newLine, log.toString());
		assertEquals(expected,actual);
		
		log.reset();
		try{
			actual = mapper.manyToOneWithoutControl(new Obj());
		}catch(JMapperException e){	e.printStackTrace(); }
		assertEquals("ERROR - ClassNotMappedException: the Obj Class isn't mapped in AnnotatedClass Class"+newLine, log.toString());
		assertEquals(expected,actual);
		
		log.reset();
		try{
			actual = mapper.manyToOne(new AnnotatedClass(),new Obj());
		}catch(JMapperException e){	e.printStackTrace(); }
		assertEquals("ERROR - ClassNotMappedException: the Obj Class isn't mapped in AnnotatedClass Class"+newLine, log.toString());
		assertEquals(expected,actual);

		log.reset();
		try{
			actual = mapper.manyToOne(new Obj(),MappingType.ALL_FIELDS);
		}catch(JMapperException e){	e.printStackTrace(); }
		assertEquals("ERROR - ClassNotMappedException: the Obj Class isn't mapped in AnnotatedClass Class"+newLine, log.toString());
		assertEquals(expected,actual);
		
		log.reset();
		try{
			actual = mapper.manyToOne(new Obj(),NullPointerControl.ALL,MappingType.ALL_FIELDS);
		}catch(JMapperException e){	e.printStackTrace(); }
		assertEquals("ERROR - ClassNotMappedException: the Obj Class isn't mapped in AnnotatedClass Class"+newLine, log.toString());
		assertEquals(expected,actual);
		
		log.reset();
		try{
			actual = mapper.manyToOne(new AnnotatedClass(),new Obj(),MappingType.ALL_FIELDS,MappingType.ALL_FIELDS);
		}catch(JMapperException e){	e.printStackTrace(); }
		assertEquals("ERROR - ClassNotMappedException: the Obj Class isn't mapped in AnnotatedClass Class"+newLine, log.toString());
		assertEquals(expected,actual);

		log.reset();
		try{
			actual = mapper.manyToOne(new AnnotatedClass(),new Obj(),NullPointerControl.ALL,MappingType.ALL_FIELDS,MappingType.ALL_FIELDS);
		}catch(JMapperException e){	e.printStackTrace(); }
		assertEquals("ERROR - ClassNotMappedException: the Obj Class isn't mapped in AnnotatedClass Class"+newLine, log.toString());
		assertEquals(expected,actual);
	}
	
	public void testOneToManyMethods(){
		
		RelationalJMapper<AnnotatedClass> mapper = new RelationalJMapper<AnnotatedClass>(AnnotatedClass.class);
		Obj expected = null;
		Obj actual = null;
		log.reset();
		try{
			actual = mapper.oneToMany(Obj.class,new AnnotatedClass());
		}catch(JMapperException e){	e.printStackTrace(); }

		assertEquals("ERROR - ClassNotMappedException: the Obj Class isn't mapped in AnnotatedClass Class"+newLine, log.toString());
		assertEquals(expected,actual);
		
		log.reset();
		try{
			actual = mapper.oneToManyWithoutControl(Obj.class,new AnnotatedClass());
		}catch(JMapperException e){	e.printStackTrace(); }
		assertEquals("ERROR - ClassNotMappedException: the Obj Class isn't mapped in AnnotatedClass Class"+newLine, log.toString());
		assertEquals(expected,actual);
		
		log.reset();
		try{
			actual = mapper.oneToMany(new Obj(),new AnnotatedClass());
		}catch(JMapperException e){	e.printStackTrace(); }
		assertEquals("ERROR - ClassNotMappedException: the Obj Class isn't mapped in AnnotatedClass Class"+newLine, log.toString());
		assertEquals(expected,actual);

		log.reset();
		try{
			actual = mapper.oneToMany(Obj.class,new AnnotatedClass(),MappingType.ALL_FIELDS);
		}catch(JMapperException e){	e.printStackTrace(); }
		assertEquals("ERROR - ClassNotMappedException: the Obj Class isn't mapped in AnnotatedClass Class"+newLine, log.toString());
		assertEquals(expected,actual);
		
		log.reset();
		try{
			actual = mapper.oneToMany(Obj.class,new AnnotatedClass(),NullPointerControl.ALL,MappingType.ALL_FIELDS);
		}catch(JMapperException e){	e.printStackTrace(); }
		assertEquals("ERROR - ClassNotMappedException: the Obj Class isn't mapped in AnnotatedClass Class"+newLine, log.toString());
		assertEquals(expected,actual);
		
		log.reset();
		try{
			actual = mapper.oneToMany(new Obj(),new AnnotatedClass(),MappingType.ALL_FIELDS,MappingType.ALL_FIELDS);
		}catch(JMapperException e){	e.printStackTrace(); }
		assertEquals("ERROR - ClassNotMappedException: the Obj Class isn't mapped in AnnotatedClass Class"+newLine, log.toString());
		assertEquals(expected,actual);

		log.reset();
		try{
			actual = mapper.oneToMany(new Obj(),new AnnotatedClass(),NullPointerControl.ALL,MappingType.ALL_FIELDS,MappingType.ALL_FIELDS);
		}catch(JMapperException e){	e.printStackTrace(); }
		assertEquals("ERROR - ClassNotMappedException: the Obj Class isn't mapped in AnnotatedClass Class"+newLine, log.toString());
		assertEquals(expected,actual);

	}
}
