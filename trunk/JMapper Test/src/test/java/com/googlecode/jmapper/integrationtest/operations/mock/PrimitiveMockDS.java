package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.PrimitiveD;
import com.googlecode.jmapper.integrationtest.operations.bean.PrimitiveS;

public class PrimitiveMockDS implements IMockDS<PrimitiveD,PrimitiveS> {

	public IObjDS<PrimitiveD,PrimitiveS> AllAll() {
		return new ObjDS<PrimitiveD,PrimitiveS>(getDestinationValued2(), destinationEqualToSourceFull(), sourceFull());
	}

	public IObjDS<PrimitiveD,PrimitiveS> AllValued() {
		return new ObjDS<PrimitiveD,PrimitiveS>(getDestinationValued3(), destinationEqualToSourceFull(), sourceValued());
	}

	public IObjDS<PrimitiveD,PrimitiveS> ValuedNull() {
		return new ObjDS<PrimitiveD,PrimitiveS>(getDestinationValued3(), getDestinationValued2(), sourceValued());
	}

	public IObjDS<PrimitiveD,PrimitiveS> ValuedAll() {
		return new ObjDS<PrimitiveD,PrimitiveS>(getDestinationValued4(), getDestinationValued3(), sourceFull());
	}

	public IObjDS<PrimitiveD,PrimitiveS> ValuedValued() {
		return new ObjDS<PrimitiveD,PrimitiveS>(getDestinationValued4(), getDestinationValued3(), getSourceValued3());
	}

	public IObjDS<PrimitiveD,PrimitiveS> NullValued() {
		return new ObjDS<PrimitiveD,PrimitiveS>(getDestinationValued2(), destinationEqualToSourceValued(), sourceValued());
	}
	public IObjDS<PrimitiveD, PrimitiveS> NullInputObject() {
		return new ObjDS<PrimitiveD,PrimitiveS>(new PrimitiveD(),null,new PrimitiveS());
	}

	private byte byteM = 0;
	private short shortM = 0;
	private int intM = 0;
	private long longM = 0;
	private float floatM = 0;
	private double doubleM = 0;
	private char charM = 'c';
	private boolean booleanM = true;
	private Byte wByteM = byteM;
	private Short wShortM = shortM;
	private Integer wIntegerM = intM;
	private Long wLongM = longM;
	private Float wFloatM = floatM;
	private Double wDoubleM = doubleM;
	private Character wCharacterM = charM;
	private Boolean wBooleanM = booleanM;
	private String wStringM = "str";
	
	public PrimitiveS getSourceValued2(){
		return new PrimitiveS(byteM,shortM,intM,longM,floatM,doubleM,charM,booleanM,null,null,null,null,null,null,null,null,null);
	}
	public PrimitiveD getDestinationValued2(){
		return new PrimitiveD(byteM,shortM,intM,longM,floatM,doubleM,charM,booleanM,null,null,null,null,null,null,null,null,null);
	}
	public PrimitiveS getSourceValued3(){
		return new PrimitiveS(byteM,shortM,intM,longM,floatM,doubleM,charM,booleanM,null,null,wIntegerM,null,wFloatM,null,wCharacterM,null,wStringM);
	}
	public PrimitiveD getDestinationValued3(){
		return new PrimitiveD(byteM,shortM,intM,longM,floatM,doubleM,charM,booleanM,null,null,wIntegerM,null,wFloatM,null,wCharacterM,null,wStringM);
	}
	public PrimitiveD getDestinationValued4(){
		return new PrimitiveD(byteM,shortM,intM,longM,floatM,doubleM,charM,booleanM,null,null,1000,null,(float) 10.2,null,'X',null,"prova");
	}
	public PrimitiveS sourceFull() {
		return new PrimitiveS(byteM,shortM,intM,longM,floatM,doubleM,charM,booleanM,wByteM,wShortM,wIntegerM,wLongM,wFloatM,wDoubleM,wCharacterM,wBooleanM,wStringM);
	}
	public PrimitiveD destinationEqualToSourceFull() {
		return new PrimitiveD(byteM,shortM,intM,longM,floatM,doubleM,charM,booleanM,wByteM,wShortM,wIntegerM,wLongM,wFloatM,wDoubleM,wCharacterM,wBooleanM,wStringM);
	}
	public PrimitiveS sourceValued() {
		return new PrimitiveS(byteM,shortM,intM,longM,floatM,doubleM,charM,booleanM,wByteM,wShortM,null,wLongM,null,wDoubleM,null,wBooleanM,null);
	}
	public PrimitiveD destinationEqualToSourceValued() {
		return new PrimitiveD(byteM,shortM,intM,longM,floatM,doubleM,charM,booleanM,wByteM,wShortM,null,wLongM,null,wDoubleM,null,wBooleanM,null);
	}

}
