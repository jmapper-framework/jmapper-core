package com.googlecode.jmapper;

import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.bean.StaticD;
import com.googlecode.jmapper.bean.StaticS;


public class StaticConversion {

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		
		// ANNOTATION
		JMapper<StaticD, StaticS> mapper = new JMapper<StaticD, StaticS>(StaticD.class, StaticS.class);
		StaticD destination = mapper.getDestination(new StaticS("10/01/2012", "10/01/2013"));
		System.out.println(destination);
		
		// XML
		mapper = new JMapper<StaticD, StaticS>(StaticD.class, StaticS.class,"xml/staticConversion.xml");
		destination = mapper.getDestination(new StaticS("10/01/2013", "10/01/2014"));
		System.out.println(destination);
	}
}
