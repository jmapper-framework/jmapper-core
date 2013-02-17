package com.googlecode.jmapper.integrationtest.performance;

import com.googlecode.jmapper.integrationtest.Performance;
import com.googlecode.jmapper.integrationtest.config.Constants;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayD;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayS;

public class ArrayPerformanceTest extends Performance<ArrayD,ArrayS> {

	@Override
	protected ArrayD staticMapping(ArrayS source) {
		   ArrayD destination = new ArrayD();
		   if(source.getSString()!=null){
			   destination.setDString(source.getSString());
		   }
		   if(source.getSInteger()!=null){
			   destination.setDInteger(source.getSInteger());
		   }
		   if(source.getSCharacter()!=null){
			   destination.setDCharacter(source.getSCharacter());
		   }
		   
		   return destination;

	}

	@Override
	protected ArrayS getSource() {
		return new ArrayS(new String[]{"source"}, new Integer[]{5002},new Character[]{'S'});
	}

	@Override
	protected int getInternalWeight() {
		return 500000;
	}

	@Override
	protected String titleOfTest() {
		return Constants.ArrayPerformanceTest;
	}

	
}
