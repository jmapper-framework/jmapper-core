package com.googlecode.jmapper;

import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.bean.JMapAccessorDest;
import com.googlecode.jmapper.bean.JMapAccessorSrc;

public class JMapAccessor {

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		
		JMapper<JMapAccessorDest,JMapAccessorSrc> mapper = new JMapper<JMapAccessorDest, JMapAccessorSrc>(JMapAccessorDest.class, JMapAccessorSrc.class);
		
		JMapAccessorDest destination = mapper.getDestination(new JMapAccessorSrc("id", "sourceField", "other"));
		
		System.out.println(destination);
		
	}

}
