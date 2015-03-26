package com.googlecode.jmapper.integrationtest.conversions;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.io.ByteArrayOutputStream;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.exceptions.JMapperException;
import com.googlecode.jmapper.integrationtest.conversions.bean.DExplicitDynamicConversion;
import com.googlecode.jmapper.integrationtest.conversions.bean.SExplicitDynamicConversion;
import com.googlecode.jmapper.integrationtest.conversions.bean.SExplicitDynamicConversion2;
import com.googlecode.jmapper.integrationtest.conversions.bean.SExplicitDynamicConversion3;

public class ExplicitDynamicConversionTest extends TestCase{

	JMapper<DExplicitDynamicConversion, SExplicitDynamicConversion> mapper;
	ByteArrayOutputStream log;
    @Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		log = new ByteArrayOutputStream();  
		Logger.getLogger(JMapper.class).addAppender(new WriterAppender(new SimpleLayout(), log));
	}
	
    public void testJavaConversion(){
    	mapper  = new JMapper<DExplicitDynamicConversion, SExplicitDynamicConversion>(DExplicitDynamicConversion.class, SExplicitDynamicConversion.class,ChooseConfig.SOURCE);
		DExplicitDynamicConversion destination = mapper.getDestination(new SExplicitDynamicConversion("INPUT1","INPUT2","INPUT3","INPUT4"));
		assertEquals("DExplicitDynamicConversion: "+
		             "destination(empty INPUT1 converted) destination2(empty INPUT2 converted) "+
				     "destination3(destination3 source3) destination4(destination4 source4)",destination.toString());
		destination = mapper.getDestination(new DExplicitDynamicConversion("DFIELD1","DFIELD2","DFIELD3","DFIELD4"), new SExplicitDynamicConversion("SFIELD1","SFIELD2","SFIELD3","SFIELD4"));
		assertEquals("DExplicitDynamicConversion: "+
		             "destination(DFIELD1 SFIELD1 converted) destination2(DFIELD2 SFIELD2 converted) "+
				     "destination3(destination3 source3) destination4(destination4 source4)", destination.toString());
	}
	
    public void testXmlConversion(){
    	mapper  = new JMapper<DExplicitDynamicConversion, SExplicitDynamicConversion>(DExplicitDynamicConversion.class, SExplicitDynamicConversion.class,ChooseConfig.SOURCE,"conversions/dynamicConversionTest.xml");
		DExplicitDynamicConversion destination = mapper.getDestination(new SExplicitDynamicConversion("INPUT1","INPUT2","INPUT3","INPUT4"));
		assertEquals("DExplicitDynamicConversion: "+
		             "destination(null + INPUT1) destination2(null + INPUT2) "+
				     "destination3(destination3 + source3) destination4(destination4 source4)",destination.toString());
		destination = mapper.getDestination(new DExplicitDynamicConversion("DFIELD1","DFIELD2","DFIELD3","DFIELD4"), new SExplicitDynamicConversion("SFIELD1","SFIELD2","SFIELD3","SFIELD4"));
		assertEquals("DExplicitDynamicConversion: "+
		             "destination(DFIELD1 + SFIELD1) destination2(DFIELD2 + SFIELD2) "+
				     "destination3(destination3 + source3) destination4(destination4 source4)", destination.toString());
	}
    
    public void testJavaConversionException(){
    	log.reset();
    	
    	JMapper<DExplicitDynamicConversion, SExplicitDynamicConversion3>  mapper  = 
    	new JMapper<DExplicitDynamicConversion, SExplicitDynamicConversion3>(DExplicitDynamicConversion.class, SExplicitDynamicConversion3.class,ChooseConfig.SOURCE);
    	try{
    		mapper.getDestination(new SExplicitDynamicConversion3(null,null,null,null));
		}catch(JMapperException e){}
    	assertEquals("ERROR - IllegalCodeException: there is an error present in the conversion method: nullConversion belong to SExplicitDynamicConversion3 Class. Exception thrown: NullPointerException, exception message: null "+newLine, log.toString());
	}
	
    public void testXmlConversionExcepetion(){
    	log.reset();
    	
    	JMapper<DExplicitDynamicConversion, SExplicitDynamicConversion3>  mapper  = 
    	new JMapper<DExplicitDynamicConversion, SExplicitDynamicConversion3>(DExplicitDynamicConversion.class, SExplicitDynamicConversion3.class,ChooseConfig.SOURCE,"conversions/dynamicConversionTest3.xml");
    	try{
    		mapper.getDestination(new SExplicitDynamicConversion3(null,null,null,null));
		}catch(JMapperException e){}
		assertEquals("ERROR - IllegalCodeException: there is an error present in the conversion method: firstConversion belong to SExplicitDynamicConversion3 Class defined in the conversions/dynamicConversionTest3.xml configuration file. Exception thrown: NullPointerException, exception message: null "+newLine, log.toString());
	}
    
    public void testJavaConversionBodyIllegalCodeException(){
    	log.reset();
    	try{
    		new JMapper<DExplicitDynamicConversion, SExplicitDynamicConversion2>(DExplicitDynamicConversion.class, SExplicitDynamicConversion2.class);
		}catch(JMapperException e){}
    	
    	assertEquals("ERROR - ConversionBodyIllegalCodeException: the conversion method contains illegal code, check the conversion code belonging to the SExplicitDynamicConversion2 class. Additional information: by javassist.bytecode.BadBytecode: SExplicitDynamicConversion2$FROMsource2TOdestination2 ()Ljava/lang/String; in comgooglecodejmapperintegrationtestconversionsbeanDExplicitDynamicConversioncomgooglecodejmapperintegrationtestconversionsbeanSExplicitDynamicConversion2: conflict: *top* and java.lang.String"+newLine, log.toString());
    }
    
    public void testXmlDConversionBodyIllegalCodeException(){
    	log.reset();
    	try{
    		new JMapper<DExplicitDynamicConversion, SExplicitDynamicConversion2>(DExplicitDynamicConversion.class, SExplicitDynamicConversion2.class,"conversions/dynamicConversionTest2.xml");
		}catch(JMapperException e){}
    	
    	assertEquals("ERROR - ConversionBodyIllegalCodeException: the firstConversion method contains illegal code, check the conversion code belonging to the SExplicitDynamicConversion2 class. Additional information: by javassist.bytecode.BadBytecode: SExplicitDynamicConversion2$FROMsource2TOdestination2 ()Ljava/lang/String; in comgooglecodejmapperintegrationtestconversionsbeanDExplicitDynamicConversioncomgooglecodejmapperintegrationtestconversionsbeanSExplicitDynamicConversion2dynamicConversionTest2xml: conflict: *top* and java.lang.String"+newLine, log.toString());
    }
    
    
}
