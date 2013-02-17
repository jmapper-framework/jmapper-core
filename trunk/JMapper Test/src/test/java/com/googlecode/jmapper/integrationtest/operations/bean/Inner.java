package com.googlecode.jmapper.integrationtest.operations.bean;





public class Inner {
	
	 private String field;
	
	
	public String getField() {
		return field;
	}


	public void setField(String field) {
		this.field = field;
	}

	public Inner() {}
	
	public static class Class{
		
		private String innerField;

		public String getInnerField() {
			return innerField;
		}

		public void setInnerField(String field) {
			this.innerField = field;
		}
		
		public Class() {}
		
		
	}
}
