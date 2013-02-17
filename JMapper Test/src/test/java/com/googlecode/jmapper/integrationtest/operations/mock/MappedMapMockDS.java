package com.googlecode.jmapper.integrationtest.operations.mock;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.googlecode.jmapper.integrationtest.mock.AMapMock;
import com.googlecode.jmapper.integrationtest.mock.IMockDS;
import com.googlecode.jmapper.integrationtest.mock.IObjDS;
import com.googlecode.jmapper.integrationtest.mock.ObjDS;
import com.googlecode.jmapper.integrationtest.operations.bean.DKeyObj;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedMapD;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedMapS;
import com.googlecode.jmapper.integrationtest.operations.bean.SKeyObj;

public class MappedMapMockDS extends AMapMock implements IMockDS<MappedMapD, MappedMapS> {

	public IObjDS<MappedMapD, MappedMapS> AllAll() {
		return new ObjDS<MappedMapD, MappedMapS>(getDAll(), AllAllOutput(), getSAll());
	}

	public IObjDS<MappedMapD, MappedMapS> AllValued() {
		return new ObjDS<MappedMapD, MappedMapS>(getDAll(), AllValuedOutput(), getSValued());
	}

	public IObjDS<MappedMapD, MappedMapS> ValuedNull() {
		return new ObjDS<MappedMapD, MappedMapS>(getDValued(), ValuedNullOutput(), getSNull());
	}

	public IObjDS<MappedMapD, MappedMapS> ValuedAll() {
		return new ObjDS<MappedMapD, MappedMapS>(getDValued(), ValuedAllOutput(), getSAll());
	}

	public IObjDS<MappedMapD, MappedMapS> ValuedValued() {
		return new ObjDS<MappedMapD, MappedMapS>(getDValued(), ValuedValuedOutput(), getSValued());
	}

	public IObjDS<MappedMapD, MappedMapS> NullValued() {
		return new ObjDS<MappedMapD, MappedMapS>(getDNull(), NullValuedOutput(), getSValued());
	}

	public IObjDS<MappedMapD, MappedMapS> NullInputObject() {
		return new ObjDS<MappedMapD, MappedMapS>(getDAll(), null, getSAll());
	}

	/************************************ INPUT METHODS ************************************/
	private MappedMapD getDAll(){
		return new MappedMapD(put(new HashMap<DKeyObj, String>(), 
							      new DKeyObj[]{new DKeyObj(7327)}, 
							      new String[]{"7327"}));
	}
	private MappedMapS getSAll(){
		return new MappedMapS(put(new LinkedHashMap<SKeyObj, Integer>(),
								  new SKeyObj[]{new SKeyObj("50053")},
								  new Integer[]{50053}));
	}
	private MappedMapD getDValued(){
		return new MappedMapD(put(new HashMap<DKeyObj, String>(), 
							      new DKeyObj[]{new DKeyObj(7327)}, 
							      new String[]{"7327"}));
	}
	private MappedMapS getSValued(){
		return new MappedMapS(put(new LinkedHashMap<SKeyObj, Integer>(),
								  new SKeyObj[]{new SKeyObj("50053")},
								  new Integer[]{50053}));
	}
	private MappedMapD getDNull(){
		return new MappedMapD(null);
	}
	private MappedMapS getSNull(){
		return new MappedMapS(null);
	}
	
	/************************************ OUTPUT METHODS ************************************/
	public MappedMapD AllAllOutput(){
		return new MappedMapD(put(new HashMap<DKeyObj, String>(), 
			      new DKeyObj[]{new DKeyObj(7327),new DKeyObj(50053)}, 
			      new String[]{"7327","50053"}));
	}
	public MappedMapD AllValuedOutput(){
		return new MappedMapD(put(new HashMap<DKeyObj, String>(), 
			      new DKeyObj[]{new DKeyObj(7327),new DKeyObj(50053)}, 
			      new String[]{"7327","50053"}));
	}
	public MappedMapD ValuedNullOutput(){
		return new MappedMapD(null);
	}
	public MappedMapD ValuedAllOutput(){
		return new MappedMapD(put(new HashMap<DKeyObj, String>(), 
			      new DKeyObj[]{new DKeyObj(7327),new DKeyObj(50053)}, 
			      new String[]{"7327","50053"}));
	}
	public MappedMapD ValuedValuedOutput(){
		return new MappedMapD(put(new HashMap<DKeyObj, String>(), 
			      new DKeyObj[]{new DKeyObj(7327),new DKeyObj(50053)}, 
			      new String[]{"7327","50053"}));
	}
	public MappedMapD NullValuedOutput(){
		return new MappedMapD(put(new HashMap<DKeyObj, String>(), 
			      new DKeyObj[]{new DKeyObj(50053)}, 
			      new String[]{"50053"}));
	}

}
