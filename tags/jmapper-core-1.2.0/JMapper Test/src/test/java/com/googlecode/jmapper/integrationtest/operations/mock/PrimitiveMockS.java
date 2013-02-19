package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.PrimitiveD;
import com.googlecode.jmapper.integrationtest.operations.bean.PrimitiveS;

public class PrimitiveMockS implements IMockS<PrimitiveD,PrimitiveS> {

	public IObjS<PrimitiveD,PrimitiveS> AllAll() {
		return new ObjS<PrimitiveD,PrimitiveS>(destinationEqualToSourceFull(), sourceFull());
	}

	public IObjS<PrimitiveD,PrimitiveS> AllValued() {
		return new ObjS<PrimitiveD,PrimitiveS>(destinationEqualToSourceValued(), sourceValued());
	}

	public IObjS<PrimitiveD,PrimitiveS> AllNull() {
		return new ObjS<PrimitiveD,PrimitiveS>(null, sourceFull());
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
	
	private PrimitiveS sourceFull() {
		return new PrimitiveS(byteM,shortM,intM,longM,floatM,doubleM,charM,booleanM,wByteM,wShortM,wIntegerM,wLongM,wFloatM,wDoubleM,wCharacterM,wBooleanM,wStringM);
	}
	private PrimitiveD destinationEqualToSourceFull() {
		return new PrimitiveD(byteM,shortM,intM,longM,floatM,doubleM,charM,booleanM,wByteM,wShortM,wIntegerM,wLongM,wFloatM,wDoubleM,wCharacterM,wBooleanM,wStringM);
	}
	private PrimitiveS sourceValued() {
		return new PrimitiveS(byteM,shortM,intM,longM,floatM,doubleM,charM,booleanM,wByteM,wShortM,null,wLongM,null,wDoubleM,null,wBooleanM,null);
	}
	private PrimitiveD destinationEqualToSourceValued() {
		return new PrimitiveD(byteM,shortM,intM,longM,floatM,doubleM,charM,booleanM,wByteM,wShortM,null,wLongM,null,wDoubleM,null,wBooleanM,null);
	}
	
}
