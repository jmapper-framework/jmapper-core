package com.googlecode.jmapper.integrationtest.application;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;

import com.googlecode.jmapper.IMapper;
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.integrationtest.application.bean.Class1;
import com.googlecode.jmapper.integrationtest.application.bean.Class3;
import com.googlecode.jmapper.integrationtest.operations.bean.AnnotatedClass;
import com.googlecode.jmapper.integrationtest.operations.bean.BeanD;
import com.googlecode.jmapper.integrationtest.operations.bean.BeanD2;
import com.googlecode.jmapper.integrationtest.operations.bean.BeanD3;
import com.googlecode.jmapper.integrationtest.operations.bean.BeanS;
import com.googlecode.jmapper.integrationtest.operations.bean.BeanS2;
import com.googlecode.jmapper.integrationtest.operations.bean.UndefinedD;
import com.googlecode.jmapper.integrationtest.operations.bean.UndefinedS;
import com.googlecode.jmapper.util.FilesManager;
import com.googlecode.jmapper.util.GeneralUtility;

public class JMapperExceptionTest extends TestCase {

	ByteArrayOutputStream log;
	
	@Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		log = new ByteArrayOutputStream();  
		Logger.getLogger(JMapper.class).addAppender(new WriterAppender(new SimpleLayout(), log));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testConstructorParameters() throws IOException{
		
	    
		Class<?> nullClass = null;
		Class<?> anInterface = IMapper.class;
		
		/********************** NULL CLASSES AS INPUT ****************************/
		log.reset();
		new JMapper(nullClass, BeanS.class);
		assertEquals("ERROR - NullMappedClassException: Destination Class can not be null"+newLine, log.toString());
		
		log.reset();
		new JMapper(BeanD.class, nullClass);
		assertEquals("ERROR - NullMappedClassException: Source Class can not be null"+newLine, log.toString());
				
		/********************** INTERFACE CLASSES AS INPUT ***********************/
		log.reset();
		new JMapper(anInterface, BeanS.class);
		assertEquals("ERROR - IllegalArgumentException: Destination Class can not be an interface"+newLine, log.toString());

		log.reset();
		new JMapper(BeanD.class, anInterface);
		assertEquals("ERROR - IllegalArgumentException: Source Class can not be an interface"+newLine,log.toString());

		/******** THE CLASS BEAND HASN'T EMPTY CONSTRUCTOR ***********************/
		log.reset();
		new JMapper(BeanD.class, BeanS.class);
		assertEquals("ERROR - MalformedBeanException: the class: BeanD hasn't empty constructor"+newLine,log.toString());

		/******** THE CLASSES BEAND2 AND BEANS AREN'T CONFIGURED *****************/
		log.reset();
		new JMapper(BeanD2.class, BeanS.class);
		assertEquals("ERROR - MappingNotFoundException: the classes: BeanD2 and BeanS aren't configured"+newLine,log.toString());

		/******** THE CLASS IS NOT CONFIGURED ************************************/
		log.reset();
		new JMapper(BeanD2.class, BeanS.class,ChooseConfig.DESTINATION);
		assertEquals("ERROR - MappingNotFoundException: BeanD2 isn't configured"+newLine,log.toString());

		log.reset();
		new JMapper(BeanD2.class, BeanS.class,ChooseConfig.SOURCE);
		assertEquals("ERROR - MappingNotFoundException: BeanS isn't configured"+newLine,log.toString());

		/******** UNDEFINED OPERATIONS *******************************************/
		log.reset();
		new JMapper(UndefinedD.class, UndefinedS.class,ChooseConfig.DESTINATION);
		assertEquals("ERROR - UndefinedMappingException: it was not possible to map the mapped sb field of the UndefinedD Class with the date field of UndefinedS Class, please check the configuration"+newLine, log.toString());

		log.reset();
		new JMapper<BeanD3, BeanS2>(BeanD3.class, BeanS2.class);
		assertEquals("ERROR - UndefinedMappingException: it was not possible to map the mapped field field of the BeanD3 Class with the field field of BeanS2 Class, please check the configuration"+newLine, log.toString());
		
		log.reset();
		new JMapper<AnnotatedClass,BeanS>(AnnotatedClass.class,BeanS.class);
		assertEquals("ERROR - AbsentRelationshipException: there isn't relationship between AnnotatedClass Class and BeanS Class"+newLine, log.toString());
		
		log.reset();
		new JMapper<Class1, Class3>(Class1.class,Class3.class);
		assertEquals("ERROR - AbsentRelationshipException: there isn't relationship between Class1 Class and Class3 Class"+newLine, log.toString());

		/******** CHECK XML CONFIGURATION ****************************************/
		log.reset();
		
		String xmlPath = "file:" + GeneralUtility.fileSeparator + FilesManager.searchFile("testJmapper.xml").getCanonicalPath();
		
		new JMapper<BeanD2,BeanS>(BeanD2.class, BeanS.class, xmlPath);
		assertEquals("ERROR - MappingNotFoundException: the classes: BeanD2 and BeanS aren't configured, verify " + xmlPath + " mapping file"+newLine, log.toString());
		
		log.reset();
		new JMapper<BeanD2,BeanS>(BeanD2.class, BeanS.class,ChooseConfig.DESTINATION,xmlPath);
		assertEquals("ERROR - MappingNotFoundException: BeanD2 isn't configured, verify " + xmlPath + " mapping file"+newLine, log.toString());
	}
}
