package com.googlecode.jmapper.integrationtest.configurations;

import java.io.ByteArrayOutputStream;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.integrationtest.configurations.bean.Destination;
import com.googlecode.jmapper.integrationtest.configurations.bean.JMapAccClassDest;
import com.googlecode.jmapper.integrationtest.configurations.bean.JMapAccClassSrc;
import com.googlecode.jmapper.integrationtest.configurations.bean.JMapAccDest;
import com.googlecode.jmapper.integrationtest.configurations.bean.JMapAccDest2;
import com.googlecode.jmapper.integrationtest.configurations.bean.JMapAccDest3;
import com.googlecode.jmapper.integrationtest.configurations.bean.JMapAccSrc;
import com.googlecode.jmapper.integrationtest.configurations.bean.JMapAccSrc2;
import com.googlecode.jmapper.integrationtest.configurations.bean.JMapAccSrc3;
import com.googlecode.jmapper.integrationtest.configurations.bean.Source;

public class JMapAccessorTest extends TestCase {

	ByteArrayOutputStream log;
	@Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		log = new ByteArrayOutputStream();  
		Logger.getLogger(JMapper.class).addAppender(new WriterAppender(new SimpleLayout(), log));
	}

	
	/**
	 *  Test su accessor implicito (senza name)
	 *  Test su accessor esplicito (con name)
	 *  Test su accessor del target
	 */
	public void testBasicJMapAccessorUse(){
		
		JMapper<Destination, Source> mapper = new JMapper<Destination, Source>(Destination.class, Source.class, ChooseConfig.DESTINATION);
		Destination destination = mapper.getDestination(new Source("sourceF1", "sourceF2"));
		assertEquals(destination.getField1(), "sourceF1");
		assertEquals(destination.getField2(), "sourceF2");
		
		mapper = new JMapper<Destination, Source>(Destination.class, Source.class, ChooseConfig.SOURCE);
		destination = mapper.getDestination(new Source("sourceF1", "sourceF2"));
		assertEquals(destination.getField1(), "sourceF1");
		assertEquals(destination.getField2(), "sourceF2");
	}
	
	/**
	 *  Test su accessor globale
	 *  Test su accessor sia globale che su campo ( quello su campo viene ignorato )
	 *  Test su accessor del target
	 *  Test su accessor dell'attributo locale
	 */
	public void testGlobalJMapAccessorUse(){
		
		JMapper<JMapAccClassDest, JMapAccClassSrc> mapper = new JMapper<JMapAccClassDest, JMapAccClassSrc>(JMapAccClassDest.class, JMapAccClassSrc.class, ChooseConfig.DESTINATION);
		JMapAccClassDest destination = mapper.getDestination(new JMapAccClassSrc("sourceF1", "sourceF2"));
		assertEquals(destination.getDestField1(), "sourceF1");
		assertEquals(destination.getDestField2(), "sourceF2");
		
		mapper = new JMapper<JMapAccClassDest, JMapAccClassSrc>(JMapAccClassDest.class, JMapAccClassSrc.class, ChooseConfig.SOURCE);
		destination = mapper.getDestination(new JMapAccClassSrc("sourceF1", "sourceF2"));
		assertEquals(destination.getDestField1(), "sourceF1");
		assertEquals(destination.getDestField2(), "sourceF2");
	}
	
	/**
	 * Test su accessor definiti sul campo stesso
	 * Test su accessor definiti per il target (con caso di utilizzo e non)
	 */
	public void testJMapAccessorXmlUse(){
		JMapper<JMapAccDest2, JMapAccSrc2> mapper = new JMapper<JMapAccDest2, JMapAccSrc2>(JMapAccDest2.class, JMapAccSrc2.class,ChooseConfig.DESTINATION,"configurations/accessors.xml");
		JMapAccDest2 destination = mapper.getDestination(new JMapAccSrc2("sourceF1", "sourceF2"));
		assertEquals(destination.getDestField1(), "sourceF1");
		assertEquals(destination.getDestField2(), "sourceF2");
		
		mapper = new JMapper<JMapAccDest2, JMapAccSrc2>(JMapAccDest2.class, JMapAccSrc2.class,ChooseConfig.DESTINATION,"configurations/accessors2.xml");
		destination = mapper.getDestination(new JMapAccSrc2("sourceF1", "sourceF2"));
		assertEquals(destination.getDestField1(), "sourceF1");
		assertEquals(destination.getDestField2(), "sourceF2");
	}
	
	/**
	 * Test su campo mappato e campo target con stesso nome
	 */
	public void testComplexJMapAccessorUse(){
		
		JMapper<JMapAccDest3, JMapAccSrc3> mapper = new JMapper<JMapAccDest3, JMapAccSrc3>(JMapAccDest3.class, JMapAccSrc3.class, ChooseConfig.DESTINATION);
		JMapAccDest3 destination = mapper.getDestination(new JMapAccSrc3("sourceF1"));
		assertEquals(destination.getDestField(), "sourceF1");
		
	}
	/**
	 * Test sul messaggio di errore in caso di metodo custom errato
	 */
	public void testJMapAccessorError(){
		try{
			new JMapper<JMapAccDest, JMapAccSrc>(JMapAccDest.class, JMapAccSrc.class);
		}catch(Exception e){
			assertEquals("com.googlecode.jmapper.exceptions.MalformedBeanException: The custom get method with the name \"getDestField\" doesn't exists in JMapAccDest Class, checks the relative accessor configuration.", e.getMessage());
		}
		
	}
}
