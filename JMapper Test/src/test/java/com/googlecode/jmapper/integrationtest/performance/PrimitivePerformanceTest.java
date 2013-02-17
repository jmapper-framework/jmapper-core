package com.googlecode.jmapper.integrationtest.performance;

import com.googlecode.jmapper.integrationtest.Performance;
import com.googlecode.jmapper.integrationtest.config.Constants;
import com.googlecode.jmapper.integrationtest.operations.bean.PrimitiveD;
import com.googlecode.jmapper.integrationtest.operations.bean.PrimitiveS;

public class PrimitivePerformanceTest extends Performance<PrimitiveD,PrimitiveS> {

	@Override
	protected PrimitiveD staticMapping(PrimitiveS source) {
		   PrimitiveD destination = new PrimitiveD();
		   destination.setByteD(source.getByteD());
		   destination.setShortD(source.getShortD());
		   destination.setIntD(source.getIntD());
		   destination.setLongD(source.getLongD());
		   destination.setFloatD(source.getFloatD());
		   destination.setDoubleD(source.getDoubleD());
		   destination.setCharD(source.getCharD());
		   destination.setBooleanD(source.isBooleanD());
		   destination.setWByteD(source.getWByteD());
		   destination.setWShortD(source.getWShortD());
		   destination.setWIntegerD(source.getWIntegerD());
		   destination.setWLongD(source.getWLongD());
		   destination.setWFloatD(source.getWFloatD());
		   destination.setWDoubleD(source.getWDoubleD());
		   destination.setWCharacterD(source.getWCharacterD());
		   destination.setWBooleanD(source.isWBooleanD());
		   destination.setWStringD(source.getWStringD());

		   return destination;
	}

	@Override
	protected PrimitiveS getSource() {
		return new PrimitiveS(byteM,shortM,intM,longM,floatM,doubleM,charM,booleanM,wByteM,wShortM,wIntegerM,wLongM,wFloatM,wDoubleM,wCharacterM,wBooleanM,wStringM);
	}

	@Override
	protected int getInternalWeight() {
		return 500000;
	}

	private  byte byteM = 0;
	private  short shortM = 0;
	private  int intM = 0;
	private  long longM = 0;
	private  float floatM = 0;
	private  double doubleM = 0;
	private  char charM = 'c';
	private  boolean booleanM = true;
	private  Byte wByteM = byteM;
	private  Short wShortM = shortM;
	private  Integer wIntegerM = intM;
	private  Long wLongM = longM;
	private  Float wFloatM = floatM;
	private  Double wDoubleM = doubleM;
	private  Character wCharacterM = charM;
	private  Boolean wBooleanM = booleanM;
	private  String wStringM = "str";
	@Override
	protected String titleOfTest() {
		return Constants.PrimitivePerformanceTest;
	}

}
