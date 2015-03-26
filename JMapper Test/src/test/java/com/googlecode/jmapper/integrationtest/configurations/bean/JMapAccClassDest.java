package com.googlecode.jmapper.integrationtest.configurations.bean;

import com.googlecode.jmapper.annotations.JGlobalMap;
import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapAccessor;
import com.googlecode.jmapper.annotations.JMapAccessors;

@JMapAccessors({
	@JMapAccessor(name="dField2",get="getDestField2",set="setDestField2"),
	@JMapAccessor(name="sField1",get="getSSField1"),
	@JMapAccessor(name="sField2",get="IGNORATO_PERCHE_DEFINITO_NELLA_CLASSE_STESSA")
})
@JGlobalMap(value="sField1",attributes={"dField1"})
public class JMapAccClassDest {
	
	@JMapAccessors({
		@JMapAccessor(get="getDestField1",set="setDestField1"),
		@JMapAccessor(name="sField1",get="IGNORATO")		
	})
	private String dField1;
	@JMap("sField2")
	private String dField2;
	
	public JMapAccClassDest() {}
	
	public JMapAccClassDest(String dField1, String dField2) {
		super();
		this.dField1 = dField1;
		this.dField2 = dField2;
	}
	public String getDestField1() {
		return dField1;
	}
	public void setDestField1(String dField1) {
		this.dField1 = dField1;
	}
	public String getDestField2() {
		return dField2;
	}
	public void setDestField2(String dField2) {
		this.dField2 = dField2;
	}
}
