package com.googlecode.jmapper;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.bean.GlobalD;
import com.googlecode.jmapper.bean.GlobalS;

public class GlobalMapping {

	public static void main(String[] args) throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		
		Properties properties = new Properties();
		InputStream stream = DynamicConversion.class.getResourceAsStream("dynamicExample.properties");
		properties.load (stream);
				
		JMapper<GlobalD,GlobalS> mapper = new JMapper<GlobalD,GlobalS>(GlobalD.class, GlobalS.class);
		GlobalD destination = mapper.getDestination(new GlobalS(properties));
		System.out.println(destination);
				
		JMapper<GlobalD,GlobalS> mapper2 = new JMapper<GlobalD,GlobalS>(GlobalD.class, GlobalS.class,"xml/globalMapping.xml");
		GlobalD destination2 = mapper2.getDestination(new GlobalS(properties));
		System.out.println(destination2);
	
	}

}
