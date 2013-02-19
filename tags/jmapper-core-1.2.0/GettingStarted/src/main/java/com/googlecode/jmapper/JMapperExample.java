package com.googlecode.jmapper;

import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.bean.Destination;
import com.googlecode.jmapper.bean.Source;
import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.enums.MappingType;
import com.googlecode.jmapper.enums.NullPointerControl;


public class JMapperExample {

	public static void main(String[] args){
		PropertyConfigurator.configure("log4j.properties");
		
		Source      source      = new Source("id", "sourceField", "sourceInfo");
		Destination destination = new Destination("2", "destinationField", "destinationInfo");
		Destination result;
		
		NullPointerControl nullPointerControl = NullPointerControl.ALL;
		MappingType mtSource      = MappingType.ONLY_VALUED_FIELDS;
		MappingType mtDestination = MappingType.ONLY_VALUED_FIELDS;
		
		
		JMapper<Destination,Source> jmapper = new JMapper<Destination,Source>(Destination.class, Source.class,ChooseConfig.DESTINATION,"xml/jmapper.xml");
		
		// demonstrations of getDestination signature
		result = jmapper.getDestination(source);
		System.out.println(result);
		
		jmapper.getDestinationWithoutControl(source);
		System.out.println(result);
		
		result = jmapper.getDestination(source, mtSource);
		System.out.println(result);
		
		result = jmapper.getDestination(source, nullPointerControl, mtSource);
		System.out.println(result);
		
		result = jmapper.getDestination(destination, source);
		System.out.println(result);
		
		result = jmapper.getDestinationWithoutControl(destination, source);
		System.out.println(result);
		
		result = jmapper.getDestination(destination, source, mtDestination, mtSource);
		System.out.println(result);
		
		result = jmapper.getDestination(destination, source, nullPointerControl, mtDestination, mtSource);
		System.out.println(result);
	}
}
