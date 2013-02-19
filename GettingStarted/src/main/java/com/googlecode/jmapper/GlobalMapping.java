package com.googlecode.jmapper;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.bean.GlobalD;
import com.googlecode.jmapper.bean.GlobalD2;
import com.googlecode.jmapper.bean.GlobalS;
import com.googlecode.jmapper.bean.GlobalS2;

public class GlobalMapping {

	public static void main(String[] args){
		PropertyConfigurator.configure("log4j.properties");
		
		// FIRST EXAMPLE
		List<String> authors = new ArrayList<String>();
		authors.add("Alessandro Vurro");
		authors.add("Federico De Felici");
		
		JMapper<GlobalD,GlobalS> mapper = new JMapper<GlobalD,GlobalS>(GlobalD.class, GlobalS.class);
		GlobalD destination = mapper.getDestination(new GlobalS(authors,new GregorianCalendar(2013, 1, 16).getTime(), "1.2.0","other"));
		System.out.println(destination);
				
		mapper = new JMapper<GlobalD,GlobalS>(GlobalD.class, GlobalS.class,"xml/globalMapping.xml");
		destination = mapper.getDestination(new GlobalS(authors,new GregorianCalendar(2013, 1, 16).getTime(), "1.2.0","other"));
		System.out.println(destination);
		
		// SECOND EXAMPLE
		JMapper<GlobalD2,GlobalS2> mapper2 = new JMapper<GlobalD2,GlobalS2>(GlobalD2.class, GlobalS2.class);
		GlobalD2 destination2 = mapper2.getDestination(new GlobalS2(154080.80D,24000D,12570.20D));
		System.out.println(destination2);
		
		mapper2 = new JMapper<GlobalD2,GlobalS2>(GlobalD2.class, GlobalS2.class,"xml/globalMapping.xml");
		destination2 = mapper2.getDestination(new GlobalS2(154080.80D,24000D,12570.20D));
		System.out.println(destination2);
	}

}
