package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.AObjectMock;
import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedObject;
import com.googlecode.jmapper.integrationtest.operations.bean.ObjectD;
import com.googlecode.jmapper.integrationtest.operations.bean.ObjectS;
import com.googlecode.jmapper.integrationtest.operations.bean.TargetObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ObjectMockDS extends AObjectMock implements IMockDS<ObjectD, ObjectS>{

	public IObjDS<ObjectD, ObjectS> AllAll() {
		
		return new ObjDS<ObjectD, ObjectS>(getD(),AllAllOutputD(),getS());
	}

	public IObjDS<ObjectD, ObjectS> AllValued() {
		
		return new ObjDS<ObjectD, ObjectS>(getD(),AllValuedOutputD(),getS());
	}

	public IObjDS<ObjectD, ObjectS> ValuedNull() {
		
		return new ObjDS<ObjectD, ObjectS>(getD(),ValuedNullOutputD(),getS());
	}

	public IObjDS<ObjectD, ObjectS> ValuedAll() {
		
		return new ObjDS<ObjectD, ObjectS>(getD(),ValuedAllOutputD(),getS());
	}

	public IObjDS<ObjectD, ObjectS> ValuedValued() {
		
		return new ObjDS<ObjectD, ObjectS>(getD(),ValuedValuedOutputD(),getS());
	}

	public IObjDS<ObjectD, ObjectS> NullValued() {
		
		return new ObjDS<ObjectD, ObjectS>(getD(),NullValuedOutputD(),getS());
	}

	public IObjDS<ObjectD, ObjectS> NullInputObject() {
		
		return new ObjDS<ObjectD, ObjectS>(getD(),null,getS());
	}

	private int intD = 2;
	private int intS = 3;
	private String strD = "Destination";
	private String strS = "Source";
	
	private ObjectD getD(){
		return new ObjectD(new TargetObject(
				intD, 
				null, 
				add(new HashSet<String>(), strD), 
				put(new HashMap<String, String>(), strD)));
	}
	private ObjectS getS(){
		return new ObjectS(new MappedObject(
			 	intS, 
				strS, 
				add(new ArrayList<String>(), strS), 
				null));
	}
	
	/**************************** ALL ALL *******************************/
	public ObjectD AllAllOutputD(){
		return new ObjectD(new TargetObject(
				intS, 
				strS, 
				add(new HashSet<String>(), strD,strS), 
				null));
	}
	/**************************** ALL VALUED ****************************/
	public ObjectD AllValuedOutputD(){
		return new ObjectD(new TargetObject(
				intS, 
				strS, 
				add(new HashSet<String>(), strD,strS), 
				put(new HashMap<String, String>(), strD)));
	}
	/**************************** VALUED NULL ***************************/
	public ObjectD ValuedNullOutputD(){
		return new ObjectD(new TargetObject(
				intD, 
				null, 
				add(new HashSet<String>(), strD), 
				put(new HashMap<String, String>(), strD)));
	}
	/**************************** VALUED ALL ****************************/
	public ObjectD ValuedAllOutputD(){
		return new ObjectD(new TargetObject(
				intS, 
				null, 
				add(new HashSet<String>(), strD,strS), 
				null));
	}
	/**************************** VALUED VALUED *************************/
	public ObjectD ValuedValuedOutputD(){
		return new ObjectD(new TargetObject(
				intS, 
				null, 
				add(new HashSet<String>(), strD,strS), 
				put(new HashMap<String, String>(), strD)));
	}
	/**************************** NULL VALUED ***************************/
	public ObjectD NullValuedOutputD(){
		return new ObjectD(new TargetObject(
				intD, 
				null, 
				add(new HashSet<String>(), strD), 
				put(new HashMap<String, String>(), strD)));
	}
	
}
