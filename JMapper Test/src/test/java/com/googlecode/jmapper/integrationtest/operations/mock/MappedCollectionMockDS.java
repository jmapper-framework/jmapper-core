package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.googlecode.jmapper.integrationtest.mock.AObjectMock;
import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedCollectionD;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedCollectionS;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedObject;
import com.googlecode.jmapper.integrationtest.operations.bean.TargetObject;

public class MappedCollectionMockDS extends AObjectMock implements IMockDS<MappedCollectionD, MappedCollectionS> {

	public IObjDS<MappedCollectionD, MappedCollectionS> AllAll() {
		return new ObjDS<MappedCollectionD, MappedCollectionS>(getD(),AllAllOutputD(),getS());
	}

	public IObjDS<MappedCollectionD, MappedCollectionS> AllValued() {
		return new ObjDS<MappedCollectionD, MappedCollectionS>(new MappedCollectionD(),AllValuedOutputD(),getS());
	}

	public IObjDS<MappedCollectionD, MappedCollectionS> ValuedNull() {
		return new ObjDS<MappedCollectionD, MappedCollectionS>(getD(),ValuedNullOutputD(),getS());
	}

	public IObjDS<MappedCollectionD, MappedCollectionS> ValuedAll() {
		return new ObjDS<MappedCollectionD, MappedCollectionS>(getD(),ValuedAllOutputD(),getS());
	}

	public IObjDS<MappedCollectionD, MappedCollectionS> ValuedValued() {
		return new ObjDS<MappedCollectionD, MappedCollectionS>(getD(),ValuedValuedOutputD(),getS());
	}

	public IObjDS<MappedCollectionD, MappedCollectionS> NullValued() {
		return new ObjDS<MappedCollectionD, MappedCollectionS>(new MappedCollectionD(),NullValuedOutputD(),getS());
	}

	public IObjDS<MappedCollectionD, MappedCollectionS> NullInputObject() {
		return new ObjDS<MappedCollectionD, MappedCollectionS>(getD(),null,getS());
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
	
	private MappedCollectionD getD(){
		return new MappedCollectionD(add(new ArrayList<TargetObject>(), getTargetObject()));
	}
	
	private MappedCollectionS getS(){
		return new MappedCollectionS(add(new HashSet<MappedObject>(), getMappedObject()));
	}
	/**************************** ALL ALL *******************************/
	public MappedCollectionD AllAllOutputD(){
		return new MappedCollectionD(
				add(new ArrayList<TargetObject>(),
					getTargetObject(),
				    new TargetObject(intS, 
				    				 strS, 
									 add(new HashSet<String>(), strS), 
									 null)
				));
	}
	/**************************** ALL VALUED ****************************/
	public MappedCollectionD AllValuedOutputD(){
		return new MappedCollectionD(
				add(new ArrayList<TargetObject>(),
					new TargetObject(intS, 
				    				 strS, 
									 add(new HashSet<String>(), strS), 
									 null)
				));
	}
	/**************************** VALUED NULL ***************************/
	public MappedCollectionD ValuedNullOutputD(){
		return new MappedCollectionD(add(new ArrayList<TargetObject>(), getTargetObject()));
	}
	/**************************** VALUED ALL ****************************/
	public MappedCollectionD ValuedAllOutputD(){
		return new MappedCollectionD(
				add(new ArrayList<TargetObject>(),
					getTargetObject(),
				    new TargetObject(intS, 
				    				 strS, 
									 add(new HashSet<String>(), strS), 
									 null)
				));
	}
	/**************************** VALUED VALUED *************************/
	public MappedCollectionD ValuedValuedOutputD(){
		return new MappedCollectionD(
				add(new ArrayList<TargetObject>(),
					getTargetObject(),
				    new TargetObject(intS, 
				    				 strS, 
									 add(new HashSet<String>(), strS), 
									 null)
				));
	}
	/**************************** NULL VALUED ***************************/
	public MappedCollectionD NullValuedOutputD(){
		return new MappedCollectionD(
				add(new ArrayList<TargetObject>(),
					new TargetObject(intS, 
				    				 strS, 
									 add(new HashSet<String>(), strS), 
									 null)
				));
	}
	
}
