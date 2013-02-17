package com.googlecode.jmapper.integrationtest.operations.mock;

import com.googlecode.jmapper.integrationtest.mock.AMapMock;
import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.mock.IObjS;
import com.googlecode.jmapper.integrationtest.mock.ObjS;
import com.googlecode.jmapper.integrationtest.operations.bean.DKeyObj;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedMapD;
import com.googlecode.jmapper.integrationtest.operations.bean.MappedMapS;
import com.googlecode.jmapper.integrationtest.operations.bean.SKeyObj;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MappedMapMockS extends AMapMock implements IMockS<MappedMapD, MappedMapS> {

	public IObjS<MappedMapD, MappedMapS> AllAll() {
		return new ObjS<MappedMapD, MappedMapS>(getDAll(), getSAll());
	}

	public IObjS<MappedMapD, MappedMapS> AllValued() {
		return new ObjS<MappedMapD, MappedMapS>(getDValued(), getSValued());
	}

	public IObjS<MappedMapD, MappedMapS> AllNull() {
		return new ObjS<MappedMapD, MappedMapS>(null, getSAll());
	}

	private MappedMapD getDAll(){
		return new MappedMapD(put(new HashMap<DKeyObj, String>(), new DKeyObj[]{new DKeyObj(2)}, new String[]{"2"}));
	}
	
	private MappedMapS getSAll(){
		return new MappedMapS(put(new LinkedHashMap<SKeyObj, Integer>(),new SKeyObj[]{new SKeyObj("2")},new Integer[]{2}));
	}
	
	private MappedMapD getDValued(){
		return new MappedMapD(put(new HashMap<DKeyObj, String>(), new DKeyObj[]{new DKeyObj(2)}, new String[]{"2"}));
	}
	
	private MappedMapS getSValued(){
		return new MappedMapS(put(new LinkedHashMap<SKeyObj, Integer>(),new SKeyObj[]{new SKeyObj("2")},new Integer[]{2}));
	}
}