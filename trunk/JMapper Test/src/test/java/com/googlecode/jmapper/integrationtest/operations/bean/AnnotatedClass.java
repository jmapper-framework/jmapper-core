package com.googlecode.jmapper.integrationtest.operations.bean;
import com.googlecode.jmapper.annotations.JMap;



public class AnnotatedClass {

    @JMap(	attributes={"field1Class1","field1Class2","field1Class3"}, 
    		classes={Class1.class,Class2.class,Class3.class})
	private String field1;
    @JMap(  attributes={"field2Class1","field2Class2","field2Class3"}, classes={Class1.class,Class2.class,Class3.class})
	private String field2;
    @JMap(attributes={"field3Class1","field3Class2","field3Class3"}, classes={Class1.class,Class2.class,Class3.class})
	private String field3;
	
	// getter and setter...
	
	
	public AnnotatedClass() {}
	
	public AnnotatedClass(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}

	@Override
	public String toString() {
		return "AnnotatedClass [field1=" + field1 + ", field2=" + field2
				+ ", field3=" + field3 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((field1 == null) ? 0 : field1.hashCode());
		result = prime * result + ((field2 == null) ? 0 : field2.hashCode());
		result = prime * result + ((field3 == null) ? 0 : field3.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnnotatedClass other = (AnnotatedClass) obj;
		if (field1 == null) {
			if (other.field1 != null)
				return false;
		} else if (!field1.equals(other.field1))
			return false;
		if (field2 == null) {
			if (other.field2 != null)
				return false;
		} else if (!field2.equals(other.field2))
			return false;
		if (field3 == null) {
			if (other.field3 != null)
				return false;
		} else if (!field3.equals(other.field3))
			return false;
		return true;
	}
	
	
}
