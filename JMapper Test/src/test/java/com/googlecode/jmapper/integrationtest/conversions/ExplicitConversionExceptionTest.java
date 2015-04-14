package com.googlecode.jmapper.integrationtest.conversions;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import com.googlecode.jmapper.exceptions.JMapperException;
import com.googlecode.jmapper.integrationtest.conversions.bean.DException;
import com.googlecode.jmapper.integrationtest.conversions.bean.DestStaticSignatureWrong;
import com.googlecode.jmapper.integrationtest.conversions.bean.ObjFirstD;
import com.googlecode.jmapper.integrationtest.conversions.bean.ObjFirstS;
import com.googlecode.jmapper.integrationtest.conversions.bean.ObjSecondS;
import com.googlecode.jmapper.integrationtest.conversions.bean.ObjThirdS;
import com.googlecode.jmapper.integrationtest.conversions.bean.SException;
import com.googlecode.jmapper.integrationtest.conversions.bean.SrcStaticSignatureWrong;
import com.googlecode.jmapper.integrationtest.operations.bean.BeanS;

import java.io.ByteArrayOutputStream;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;

import com.googlecode.jmapper.JMapper;

public class ExplicitConversionExceptionTest extends TestCase {

	JMapper<DException, SException> mapper;
	ByteArrayOutputStream log;
	@Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		log = new ByteArrayOutputStream();  
		Logger.getLogger(JMapper.class).addAppender(new WriterAppender(new SimpleLayout(), log));
	}
	
	public void testStaticConversionWrongSignature(){
		log.reset();
		try{
			new JMapper<DestStaticSignatureWrong, SrcStaticSignatureWrong>(DestStaticSignatureWrong.class,SrcStaticSignatureWrong.class); 
		}catch(JMapperException e){}
		assertEquals("ERROR - ConversionBodyIllegalCodeException: error in static conversion: probably is an incompatibility of signature, the expected input fields do not match with the real ones, checks the configured class."+newLine, log.toString());
	}
	
	public void testParameterNumber(){
		log.reset();
		try{
			new JMapper<DException, SException>(DException.class, SException.class);
		}catch(JMapperException e){}
		
		assertEquals("ERROR - UndefinedMappingException: it was not possible to map the mapped field field of the DException Class with the field field of SException Class, please check the configuration. More information: in static conversion is allowed to use from one to two parameters, controls the conversion method belonging to the SException class. For more information, see the wiki http://code.google.com/p/jmapper-framework/"+newLine, log.toString());
	}
	
	public void testExplicitConversion2(){
		JMapper<ObjFirstD, ObjFirstS> mapper  = new JMapper<ObjFirstD, ObjFirstS>(ObjFirstD.class, ObjFirstS.class,"conversions/exceptionTest.xml");
		try{
			mapper.getDestination(new ObjFirstS(new ObjSecondS(new ObjThirdS("SOURCE"))));
		}catch (Exception e) {
			assertEquals("com.googlecode.jmapper.exceptions.IllegalCodeException: there is an error present in the conversion method: conversion belong to ObjSecondD Class defined in the conversions/exceptionTest.xml configuration file. Exception thrown: NullPointerException, exception message: null ", e.getMessage());
		}
	}
}
