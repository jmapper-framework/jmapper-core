package com.googlecode.jmapper;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.RelationalJMapper;
import com.googlecode.jmapper.bean.DynamicD;
import com.googlecode.jmapper.bean.DynamicD2;
import com.googlecode.jmapper.bean.DynamicS;
import com.googlecode.jmapper.bean.DynamicS2;

public class DynamicConversion {

	public static void main(String[] args) throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		
		// FIRST EXAMPLE
		Properties properties = new Properties();
		InputStream stream = DynamicConversion.class.getResourceAsStream("dynamicExample.properties");
		properties.load (stream);
		
		JMapper<DynamicD,DynamicS> mapper = new JMapper<DynamicD,DynamicS>(DynamicD.class, DynamicS.class);
		DynamicD destination = mapper.getDestination(new DynamicS(properties));
		System.out.println(destination);
		
		mapper = new JMapper<DynamicD,DynamicS>(DynamicD.class, DynamicS.class,"xml/dynamicConversion.xml");
		destination = mapper.getDestination(new DynamicS(properties));
		System.out.println("\n"+destination);
		
		// SECOND EXAMPLE
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", "JMapper Framework v.1.1.0");
		map.put("quantity", 10);
		map.put("purchase", new Date());

		RelationalJMapper<DynamicD2> mapper2 = new RelationalJMapper<DynamicD2>(DynamicD2.class,"xml/dynamicConversion.xml");
		
		DynamicS2 source = new DynamicS2(map);
		DynamicD2 manyToOne = mapper2.manyToOne(source);
		System.out.println("\n"+manyToOne);
		
		DynamicS2 empty = new DynamicS2(new HashMap<String, Object>());
		DynamicS2 oneToMany = mapper2.oneToMany(empty,manyToOne);
		System.out.println("\n"+oneToMany);		
	}
}
