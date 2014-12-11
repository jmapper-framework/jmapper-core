package com.googlecode.jmapper.integrationtest.others;

import java.io.ByteArrayOutputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.integrationtest.others.bean.Destination;
import com.googlecode.jmapper.integrationtest.others.bean.Source;

import junit.framework.TestCase;

public class BooleanGetTest extends TestCase {
	ByteArrayOutputStream log;
	
	public BooleanGetTest() {
		log = new ByteArrayOutputStream();
		PropertyConfigurator.configure("log4j.properties");
		Logger.getLogger(JMapper.class).addAppender(new WriterAppender(new SimpleLayout(), log));
	}
	public void testBooleanGet(){
		
		JMapper<Destination, Source> mapper = new JMapper<Destination, Source>(Destination.class, Source.class);
		
		Source source = new Source(true);
		Destination destination = mapper.getDestination(source);
		
		assertEquals(source.getBoo(),destination.getBoo());
	}
}
