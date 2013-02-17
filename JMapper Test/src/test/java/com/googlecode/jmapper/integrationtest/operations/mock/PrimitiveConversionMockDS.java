package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.PrimitiveConversionD;
import com.googlecode.jmapper.integrationtest.operations.bean.PrimitiveConversionS;

public class PrimitiveConversionMockDS implements
		IMockDS<PrimitiveConversionD, PrimitiveConversionS> {

	public IObjDS<PrimitiveConversionD, PrimitiveConversionS> AllAll() {
		return new ObjDS<PrimitiveConversionD, PrimitiveConversionS>(getAllD(),AllAllOutput(),getAllS());
	}

	public IObjDS<PrimitiveConversionD, PrimitiveConversionS> AllValued() {
		return new ObjDS<PrimitiveConversionD, PrimitiveConversionS>(getAllD(),AllValuedOutput(),getValuedS());
	}

	public IObjDS<PrimitiveConversionD, PrimitiveConversionS> ValuedNull() {
		return new ObjDS<PrimitiveConversionD, PrimitiveConversionS>(getAllD(),ValuedNullOutput(),getValuedS());
	}

	public IObjDS<PrimitiveConversionD, PrimitiveConversionS> ValuedAll() {
		return new ObjDS<PrimitiveConversionD, PrimitiveConversionS>(getValuedD(),ValuedAllOutput(),getAllS());
	}

	public IObjDS<PrimitiveConversionD, PrimitiveConversionS> ValuedValued() {
		return new ObjDS<PrimitiveConversionD, PrimitiveConversionS>(getValuedD(),ValuedValuedOutput(),getValuedS());
	}

	public IObjDS<PrimitiveConversionD, PrimitiveConversionS> NullValued() {
		return new ObjDS<PrimitiveConversionD, PrimitiveConversionS>(getNullD(),NullValuedOutput(),getAllS());
	}

	public IObjDS<PrimitiveConversionD, PrimitiveConversionS> NullInputObject() {
		return new ObjDS<PrimitiveConversionD, PrimitiveConversionS>(new PrimitiveConversionD(),null,new PrimitiveConversionS());
	}
	
	private PrimitiveConversionD getAllD(){
		return new PrimitiveConversionD("Destination", "Destination", 7357, 7357, "Destination", 7357);
	}
	private PrimitiveConversionD getValuedD(){
		return new PrimitiveConversionD("Destination", null, 7357, null,null, 7357);
	}
	private PrimitiveConversionD getNullD(){
		return new PrimitiveConversionD(null, null, 7357, null,null, 7357);
	}
	private PrimitiveConversionS getAllS(){
		return new PrimitiveConversionS(5, 5, "50023", "50023", 5.5, 5.5);	
	}
	private PrimitiveConversionS getValuedS(){
		return new PrimitiveConversionS(5, null, null, "50023", 5.5, null);	
	}

	private PrimitiveConversionD AllAllOutput(){
		return new PrimitiveConversionD("5", "5", 50023, 50023, "5.5", 5);
	}
	
	private PrimitiveConversionD AllValuedOutput(){
		return new PrimitiveConversionD("5", "Destination", 7357, 50023, "5.5", 7357);
	}
	
	private PrimitiveConversionD ValuedNullOutput(){
		return new PrimitiveConversionD("Destination", null, 7357, 7357, "Destination", 7357);
	}
	
	private PrimitiveConversionD ValuedAllOutput(){
		return new PrimitiveConversionD("5", null, 50023, null, null, 5);
	}
	
	private PrimitiveConversionD ValuedValuedOutput(){
		return new PrimitiveConversionD("5", null, 7357, null, null, 7357);
	}
	
	private PrimitiveConversionD NullValuedOutput(){
		return new PrimitiveConversionD("5", "5", 7357, 50023, "5.5", 7357);
	}
}
