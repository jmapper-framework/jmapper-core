package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayConversionD;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayConversionS;

public class ArrayConversionMockDS implements IMockDS<ArrayConversionD, ArrayConversionS> {

	public IObjDS<ArrayConversionD, ArrayConversionS> AllAll() {
		return new ObjDS<ArrayConversionD, ArrayConversionS>(getDAll(), AllAllOutput(), getSAll());
	}

	public IObjDS<ArrayConversionD, ArrayConversionS> AllValued() {
		return new ObjDS<ArrayConversionD, ArrayConversionS>(getDAll(), AllValuedOutput(), getSValued());
	}

	public IObjDS<ArrayConversionD, ArrayConversionS> ValuedNull() {
		return new ObjDS<ArrayConversionD, ArrayConversionS>(getDValued(), ValuedNullOutput(), getSNull());
	}

	public IObjDS<ArrayConversionD, ArrayConversionS> ValuedAll() {
		return new ObjDS<ArrayConversionD, ArrayConversionS>(getDValued(), ValuedAllOutput(), getSAll());
	}

	public IObjDS<ArrayConversionD, ArrayConversionS> ValuedValued() {
		return new ObjDS<ArrayConversionD, ArrayConversionS>(getDValued(), ValuedValuedOutput(), getSValued());
	}

	public IObjDS<ArrayConversionD, ArrayConversionS> NullValued() {
		return new ObjDS<ArrayConversionD, ArrayConversionS>(getDNull(), NullValuedOutput(), getSValued());
	}

	public IObjDS<ArrayConversionD, ArrayConversionS> NullInputObject() {
		return new ObjDS<ArrayConversionD, ArrayConversionS>(getDAll(), null, getSAll());
	}

	/************************************ INPUT METHODS ************************************/
	private ArrayConversionD getDAll(){
		return new ArrayConversionD(new String[]{"5327"},new Integer[]{5327},new Double[]{5327.0});
	}
	private ArrayConversionS getSAll(){
		return new ArrayConversionS(new Integer[]{5003},new String[]{"5003"},new int[]{5003});
	}
	private ArrayConversionD getDValued(){
		return new ArrayConversionD(null,new Integer[]{5327},new Double[]{5327.0});
	}
	private ArrayConversionS getSValued(){
		return new ArrayConversionS(null,new String[]{"5003"},null);
	}
	private ArrayConversionD getDNull(){
		return new ArrayConversionD(new String[]{"5327"},null,new Double[]{5327.0});
	}
	private ArrayConversionS getSNull(){
		return new ArrayConversionS(new Integer[]{5003},null,new int[]{5003});
	}
	
	/************************************ OUTPUT METHODS ************************************/
	public ArrayConversionD AllAllOutput(){
		return new ArrayConversionD(new String[]{"5327","5003"},new Integer[]{5327,5003},new Double[]{5327.0,5003.0});
	}
	public ArrayConversionD AllValuedOutput(){
		return new ArrayConversionD(new String[]{"5327"},new Integer[]{5327,5003},new Double[]{5327.0});
	}
	public ArrayConversionD ValuedNullOutput(){
		return new ArrayConversionD(null,null,new Double[]{5327.0});
	}
	public ArrayConversionD ValuedAllOutput(){
		return new ArrayConversionD(null,new Integer[]{5327,5003},new Double[]{5327.0,5003.0});
	}
	public ArrayConversionD ValuedValuedOutput(){
		return new ArrayConversionD(null,new Integer[]{5327,5003},new Double[]{5327.0});
	}
	public ArrayConversionD NullValuedOutput(){
		return new ArrayConversionD(new String[]{"5327"},new Integer[]{5003},new Double[]{5327.0});
	}

}
