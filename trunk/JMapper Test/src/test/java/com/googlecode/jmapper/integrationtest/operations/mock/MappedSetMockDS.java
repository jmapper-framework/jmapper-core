package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.googlecode.jmapper.integrationtest.mock.AObjectMock;
import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedObject;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedSetD;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedSetS;
import com.googlecode.jmapper.integrationtest.operations.bean.TargetObject;

public class MappedSetMockDS extends AObjectMock implements IMockDS<MappedSetD, MappedSetS> {

	public IObjDS<MappedSetD, MappedSetS> AllAll() {
		return new ObjDS<MappedSetD, MappedSetS>(getD(),AllAllOutputD(),getS());
	}

	public IObjDS<MappedSetD, MappedSetS> AllValued() {
		return new ObjDS<MappedSetD, MappedSetS>(new MappedSetD(),AllValuedOutputD(),getS());
	}

	public IObjDS<MappedSetD, MappedSetS> ValuedNull() {
		return new ObjDS<MappedSetD, MappedSetS>(getD(),ValuedNullOutputD(),getS());
	}

	public IObjDS<MappedSetD, MappedSetS> ValuedAll() {
		return new ObjDS<MappedSetD, MappedSetS>(getD(),ValuedAllOutputD(),getS());
	}

	public IObjDS<MappedSetD, MappedSetS> ValuedValued() {
		return new ObjDS<MappedSetD, MappedSetS>(getD(),ValuedValuedOutputD(),getS());
	}

	public IObjDS<MappedSetD, MappedSetS> NullValued() {
		return new ObjDS<MappedSetD, MappedSetS>(new MappedSetD(),NullValuedOutputD(),getS());
	}

	public IObjDS<MappedSetD, MappedSetS> NullInputObject() {
		return new ObjDS<MappedSetD, MappedSetS>(getD(),null,getS());
	}

	private int intD = 2;
	private int intS = 3;
	private String strD = "Destination";
	private String strS = "Source";
	
	private TargetObject getTargetObject(){
		return new TargetObject(intD, null, 
								add(new HashSet<String>(), strD), 
								put(new HashMap<String, String>(), strD));
	}
	
	private MappedObject getMappedObject(){
		return new MappedObject(intS, strS, 
								add(new ArrayList<String>(), strS), 
								null);
	}
	
	private MappedSetD getD(){
		return new MappedSetD(add(new HashSet<TargetObject>(), getTargetObject()));
	}
	
	private MappedSetS getS(){
		return new MappedSetS(add(new HashSet<MappedObject>(), getMappedObject()));
	}
	/**************************** ALL ALL *******************************/
	public MappedSetD AllAllOutputD(){
		return new MappedSetD(
				add(new HashSet<TargetObject>(),
					getTargetObject(),
				    new TargetObject(intS, 
				    				 strS, 
									 add(new HashSet<String>(), strS), 
									 null)
				));
	}
	/**************************** ALL VALUED ****************************/
	public MappedSetD AllValuedOutputD(){
		return new MappedSetD(
				add(new HashSet<TargetObject>(),
					new TargetObject(intS, 
				    				 strS, 
									 add(new HashSet<String>(), strS), 
									 null)
				));
	}
	/**************************** VALUED NULL ***************************/
	public MappedSetD ValuedNullOutputD(){
		return new MappedSetD(add(new HashSet<TargetObject>(), getTargetObject()));
	}
	/**************************** VALUED ALL ****************************/
	public MappedSetD ValuedAllOutputD(){
		return new MappedSetD(
				add(new HashSet<TargetObject>(),
					getTargetObject(),
				    new TargetObject(intS, 
				    				 strS, 
									 add(new HashSet<String>(), strS), 
									 null)
				));
	}
	/**************************** VALUED VALUED *************************/
	public MappedSetD ValuedValuedOutputD(){
		return new MappedSetD(
				add(new HashSet<TargetObject>(),
					getTargetObject(),
				    new TargetObject(intS, 
				    				 strS, 
									 add(new HashSet<String>(), strS), 
									 null)
				));
	}
	/**************************** NULL VALUED ***************************/
	public MappedSetD NullValuedOutputD(){
		return new MappedSetD(
				add(new HashSet<TargetObject>(),
					new TargetObject(intS, 
				    				 strS, 
									 add(new HashSet<String>(), strS), 
									 null)
				));
	}
	
}
