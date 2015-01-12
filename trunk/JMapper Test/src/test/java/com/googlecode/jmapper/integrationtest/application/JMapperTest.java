package com.googlecode.jmapper.integrationtest.application;

import junit.framework.TestCase;

import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.enums.MappingType;
import com.googlecode.jmapper.api.enums.NullPointerControl;
import com.googlecode.jmapper.integrationtest.application.bean.Child1;
import com.googlecode.jmapper.integrationtest.application.bean.Child2;
import com.googlecode.jmapper.integrationtest.application.bean.ChildConversion;
import com.googlecode.jmapper.integrationtest.application.bean.ChildConversion2;
import com.googlecode.jmapper.integrationtest.application.bean.Class2;
import com.googlecode.jmapper.integrationtest.application.bean.Class3;
import com.googlecode.jmapper.integrationtest.application.bean.Dest;
import com.googlecode.jmapper.integrationtest.application.bean.Sour;
import com.googlecode.jmapper.integrationtest.application.bean.Target1;
import com.googlecode.jmapper.integrationtest.application.bean.Target2;

public class JMapperTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public void testEnumerationsUsage(){
		
		JMapper<Dest,Sour> mapper = new JMapper<Dest, Sour>(Dest.class, Sour.class);
		
		Dest destination = new Dest("empty", null, 26000);
		Sour source = new Sour("alessandro", 27, null);
		
		Dest result = mapper.getDestination(destination, source, MappingType.ALL_FIELDS, MappingType.ONLY_VALUED_FIELDS);
		
		assertEquals("Dest [name=alessandro, age=27, salary=26000]", result.toString());
		
		result = mapper.getDestination(new Dest("empty", null, 26000), source, MappingType.ONLY_NULL_FIELDS, MappingType.ALL_FIELDS);
		
		assertEquals("Dest [name=empty, age=27, salary=26000]", result.toString());
		
		source = null;
		
		Dest dest = mapper.getDestination(source, NullPointerControl.SOURCE, MappingType.ALL_FIELDS);
		
		assertNull(dest);
	}
	
	public void testAttributes(){
		
		JMapper<Class3, Class2> mapper = new JMapper<Class3, Class2>(Class3.class, Class2.class);
		Class3 actual = mapper.getDestination(new Class2("field"));
		assertEquals("Class3 [sourceField1=null, sourceField2=null, sourceField3=field]", actual.toString());
		
	}
	
	public void testAnnotationInheritance(){
	
		JMapper<Child1, Target1> mapper = new JMapper<Child1, Target1>(Child1.class, Target1.class);
		Child1 destination = mapper.getDestination(new Target1("commonTargetField1", "commonTargetField2", "specificTargetField1", "specificTargetField2"));
		assertEquals("Child1 [specificField1=specificTargetField1, specificField2=specificTargetField2, getCommonField1()=commonTargetField1, getCommonField2()=commonTargetField2]", destination.toString());
		
		JMapper<Child2, Target2> mapperChild2 = new JMapper<Child2, Target2>(Child2.class, Target2.class);
		Child2 child2 = mapperChild2.getDestination(new Target2("commonTargetField1", "commonTargetField2", "specificTargetField3", "specificTargetField4"));
		assertEquals("Child2 [specificField3=specificTargetField3, specificField4=specificTargetField4, getCommonField1()=commonTargetField1, getCommonField2()=commonTargetField2]", child2.toString());
		
		JMapper<Target1, Child1> mapper2 = new JMapper<Target1, Child1>(Target1.class, Child1.class);
		Target1 target1 = mapper2.getDestination(destination);
		assertEquals("Target1 [commonField1=commonTargetField1, commonField2=commonTargetField2, specificField1=specificTargetField1, specificField2=specificTargetField2]", target1.toString());
		
		JMapper<Target2, Child2> mapperTarget2 = new JMapper<Target2, Child2>(Target2.class, Child2.class);
		Target2 target2 = mapperTarget2.getDestination(child2);
		assertEquals("Target2 [commonField1=commonTargetField1, commonField2=commonTargetField2, specificField3=specificTargetField3, specificField4=specificTargetField4]", target2.toString());
		
	}
	
	public void testXMLInheritance(){
		
		JMapper<Child1, Target1> mapper = new JMapper<Child1, Target1>(Child1.class, Target1.class,"inheritance.xml");
		Child1 destination = mapper.getDestination(new Target1("commonTargetField1", "commonTargetField2", "specificTargetField1", "specificTargetField2"));
		assertEquals("Child1 [specificField1=specificTargetField1, specificField2=specificTargetField2, getCommonField1()=commonTargetField1, getCommonField2()=commonTargetField2]", destination.toString());
		
		JMapper<Child2, Target2> mapperChild2 = new JMapper<Child2, Target2>(Child2.class, Target2.class,"inheritance.xml");
		Child2 child2 = mapperChild2.getDestination(new Target2("commonTargetField1", "commonTargetField2", "specificTargetField3", "specificTargetField4"));
		assertEquals("Child2 [specificField3=specificTargetField3, specificField4=specificTargetField4, getCommonField1()=commonTargetField1, getCommonField2()=commonTargetField2]", child2.toString());
		
		JMapper<Target1, Child1> mapper2 = new JMapper<Target1, Child1>(Target1.class, Child1.class,"inheritance.xml");
		Target1 target1 = mapper2.getDestination(destination);
		assertEquals("Target1 [commonField1=commonTargetField1, commonField2=commonTargetField2, specificField1=specificTargetField1, specificField2=specificTargetField2]", target1.toString());
		
		JMapper<Target2, Child2> mapperTarget2 = new JMapper<Target2, Child2>(Target2.class, Child2.class,"inheritance.xml");
		Target2 target2 = mapperTarget2.getDestination(child2);
		assertEquals("Target2 [commonField1=commonTargetField1, commonField2=commonTargetField2, specificField3=specificTargetField3, specificField4=specificTargetField4]", target2.toString());
		
	}
	
	public void testStaticConversionInheritance(){
		
		JMapper<ChildConversion, Target1> mapper = new JMapper<ChildConversion, Target1>(ChildConversion.class, Target1.class);
		ChildConversion destination = mapper.getDestination(new Target1("commonTargetField1", "commonTargetField2", "specificTargetField1", "specificTargetField2"));
		assertEquals("ChildConversion [specificField1=specificTargetField1, specificField2=specificTargetField2, getCommonField1()=commonTargetField1 ANNOTATED CONVERSION, getCommonField2()=commonTargetField2]", destination.toString());
		
		JMapper<Target1, ChildConversion> mapper2 = new JMapper<Target1, ChildConversion>(Target1.class, ChildConversion.class);
		Target1 target1 = mapper2.getDestination(new ChildConversion("specificField1", "specificField2", "common1", "common2"));
		assertEquals("Target1 [commonField1=common1 ANNOTATED CONVERSION, commonField2=common2, specificField1=specificField1, specificField2=specificField2]", target1.toString());
		
		JMapper<ChildConversion, Target1> mapper3 = new JMapper<ChildConversion, Target1>(ChildConversion.class, Target1.class,"inheritance2.xml");
		ChildConversion destination2 = mapper3.getDestination(new Target1("commonTargetField1", "commonTargetField2", "specificTargetField1", "specificTargetField2"));
		assertEquals("ChildConversion [specificField1=specificTargetField1 XML CONVERSION2, specificField2=specificTargetField2 XML CONVERSION Child, getCommonField1()=commonTargetField1 XML CONVERSION common, getCommonField2()=commonTargetField2]", destination2.toString());
		
		JMapper<Target1, ChildConversion> mapper4 = new JMapper<Target1, ChildConversion>(Target1.class, ChildConversion.class,"inheritance2.xml");
		Target1 target2 = mapper4.getDestination(new ChildConversion("specificField1", "specificField2", "common1", "common2"));
		assertEquals("Target1 [commonField1=common1 XML CONVERSION common, commonField2=common2, specificField1=specificField1 XML CONVERSION2, specificField2=specificField2 XML CONVERSION Child]", target2.toString());
		
	}
	
	public void testDynamicConversionInheritance(){
		
		JMapper<ChildConversion2, Target1> mapper = new JMapper<ChildConversion2, Target1>(ChildConversion2.class, Target1.class);
		ChildConversion2 destination = mapper.getDestination(new Target1("commonTargetField1", "commonTargetField2", "specificTargetField1", "specificTargetField2"));
		assertEquals("ChildConversion [specificField1=specificTargetField1, specificField2=specificTargetField2, getCommonField1()=commonField1  = commonTargetField1 (commonField1 value) ANNOTATED CONVERSION, getCommonField2()=commonTargetField2]", destination.toString());
		
		JMapper<ChildConversion2, Target1> mapper2 = new JMapper<ChildConversion2, Target1>(ChildConversion2.class, Target1.class,"inheritanceDynamic.xml");
		ChildConversion2 destination2 = mapper2.getDestination(new Target1("commonTargetField1", "commonTargetField2", "specificTargetField1", "specificTargetField2"));
		assertEquals("ChildConversion [specificField1=specificTargetField1 XML DYNAMIC CONVERSION, specificField2=specificTargetField2 XML DYNAMIC CONVERSION Child, getCommonField1()=commonTargetField1 XML DYNAMIC CONVERSION, getCommonField2()=commonTargetField2]", destination2.toString());
		
	}
}
