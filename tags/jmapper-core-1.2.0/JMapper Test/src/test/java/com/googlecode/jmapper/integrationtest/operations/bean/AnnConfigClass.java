package com.googlecode.jmapper.integrationtest.operations.bean;

import com.googlecode.jmapper.annotations.JMap;

public class AnnConfigClass {

	@JMap
	String equalField1;
	
	@JMap(classes={TargetClass.class})
	String equalField2;
	
	@JMap(value="targetField3",classes={TargetClass.class})
	String confField3;
	
	@JMap(attributes={"targetField4"},classes={TargetClass.class})
	String confField4;
	
	@JMap(attributes={"targetField5"})
	String confField5;

	public String getEqualField1() {
		return equalField1;
	}

	public void setEqualField1(String equalField1) {
		this.equalField1 = equalField1;
	}

	public String getEqualField2() {
		return equalField2;
	}

	public void setEqualField2(String equalField2) {
		this.equalField2 = equalField2;
	}

	public String getConfField3() {
		return confField3;
	}

	public void setConfField3(String confField3) {
		this.confField3 = confField3;
	}

	public String getConfField4() {
		return confField4;
	}

	public void setConfField4(String confField4) {
		this.confField4 = confField4;
	}

	public String getConfField5() {
		return confField5;
	}

	public void setConfField5(String confField5) {
		this.confField5 = confField5;
	}
	
	
	public AnnConfigClass() {}
		
}
