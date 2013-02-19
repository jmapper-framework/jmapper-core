package com.googlecode.jmapper;

import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.bean.Destination;
import com.googlecode.jmapper.bean.Source;
import com.googlecode.jmapper.bean.Source2;
import com.googlecode.jmapper.bean.Source3;


public class ImplicitManyToOne {

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		
		Source  source  = new Source ("id", "sourceField", "other");
		Source2 source2 = new Source2("id2", "sourceField2", "other2");
		Source3 source3 = new Source3("id3", "sourceField3", "other3");
		
		JMapper<Destination,Source> jmapper = new JMapper<Destination,Source>(Destination.class, Source.class);
		Destination destination = jmapper.getDestination(source);
		System.out.println(destination);
		
		JMapper<Destination,Source2> jmapper2 = new JMapper<Destination,Source2>(Destination.class, Source2.class);
		Destination destination2 = jmapper2.getDestination(source2);
		System.out.println(destination2);
		
		JMapper<Destination,Source3> jmapper3 = new JMapper<Destination,Source3>(Destination.class, Source3.class);
		Destination destination3 = jmapper3.getDestination(source3);
		System.out.println(destination3);
		
	}

}
