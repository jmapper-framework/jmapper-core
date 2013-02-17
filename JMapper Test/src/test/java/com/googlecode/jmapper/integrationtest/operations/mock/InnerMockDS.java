package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.InnerD;
import com.googlecode.jmapper.integrationtest.operations.bean.InnerS;

public class InnerMockDS implements IMockDS<InnerD, InnerS>{

	public IObjDS<InnerD, InnerS> AllAll() {
		return new ObjDS<InnerD, InnerS>(AllD(),AllAllOutputD(),AllS());
	}

	public IObjDS<InnerD, InnerS> AllValued() {
		return new ObjDS<InnerD, InnerS>(AllD(),AllValuedOutputD(),ValuedS());
	}

	public IObjDS<InnerD, InnerS> ValuedNull() {
		return new ObjDS<InnerD, InnerS>(ValuedD(),ValuedNullOutputD(),ValuedS());
	}

	public IObjDS<InnerD, InnerS> ValuedAll() {
		return new ObjDS<InnerD, InnerS>(ValuedD(),ValuedAllOutputD(),AllS());
	}

	public IObjDS<InnerD, InnerS> ValuedValued() {
		return new ObjDS<InnerD, InnerS>(ValuedD(),ValuedValuedOutputD(),ValuedS());
	}

	public IObjDS<InnerD, InnerS> NullValued() {
		return new ObjDS<InnerD, InnerS>(new InnerD(),NullValuedOutputD(),ValuedS());
	}

	public IObjDS<InnerD, InnerS> NullInputObject() {
		return new ObjDS<InnerD, InnerS>(ValuedD(),null,ValuedS());
	}

	/**************************** ALL ALL *******************************/
	public InnerD AllAllOutputD(){
		return new InnerD(new InnerD.Class("fieldS", "field2S", "field3S"));
	}
	
	/**************************** ALL VALUED ****************************/
	public InnerD AllValuedOutputD(){
		return new InnerD(new InnerD.Class("fieldS", "field2D", "field3S"));
	}
	
	/**************************** VALUED NULL ***************************/
	public InnerD ValuedNullOutputD(){
		return new InnerD(new InnerD.Class(null, "field2D", "field3D"));
	}
	
	/**************************** VALUED ALL ****************************/
	public InnerD ValuedAllOutputD(){
		return new InnerD(new InnerD.Class(null, "field2S", "field3S"));
	}
	
	/**************************** VALUED VALUED *************************/
	public InnerD ValuedValuedOutputD(){
		return new InnerD(new InnerD.Class(null, "field2D", "field3S"));
	}
	
	/**************************** NULL VALUED ***************************/
	public InnerD NullValuedOutputD(){
		return new InnerD(new InnerD.Class("fieldS", null, "field3S"));
	}
	
	/*******************GETD AND GETS METHODS ***************************/
	public InnerS AllS(){
		return new InnerS(new InnerS.Class("fieldS", "field2S", "field3S"));
	}
	
	public InnerD AllD(){
		return new InnerD(new InnerD.Class("fieldD", "field2D", "field3D"));
	}
	
	public InnerS ValuedS(){
		return new InnerS(new InnerS.Class("fieldS", null, "field3S"));
	}
	
	public InnerD ValuedD(){
		return new InnerD(new InnerD.Class(null, "field2D", "field3D"));
	}
	
	
}
