package com.googlecode.jmapper.integrationtest.operations;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.exceptions.MappingException;
import com.googlecode.jmapper.integrationtest.operations.bean.OtherTypesD;
import com.googlecode.jmapper.integrationtest.operations.bean.OtherTypesS;

import junit.framework.TestCase;

public class OtherTypesTest extends TestCase {

	JMapper<OtherTypesD, OtherTypesS> mapper;
	
	@Override
	protected void setUp() throws Exception {
		mapper = new JMapper<OtherTypesD, OtherTypesS>(OtherTypesD.class, OtherTypesS.class);
	}
	
	public void testMapping(){
		
		OtherTypesS source = new OtherTypesS(ChooseConfig.SOURCE, new MappingException("mappingException"));
		OtherTypesD destination = mapper.getDestination(source);
		assertEquals(ChooseConfig.SOURCE, destination.getConfig());
		assertEquals(MappingException.class, destination.getException().getClass());
	}
}
