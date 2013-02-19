package com.googlecode.jmapper.integrationtest.operations.bean;

import com.googlecode.jmapper.annotations.JMap;

public class InnerS {

	@JMap	Class field;
	
	public static class Class {
		
		@JMap	private String field;
		@JMap	private String field2;
		@JMap	private String field3;
		
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

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}
		
		public Class() {}

		/**
		 * @param field
		 * @param field2
		 * @param field3
		 */
		public Class(String field, String field2, String field3) {
			super();
			this.field = field;
			this.field2 = field2;
			this.field3 = field3;
		}
		
		
	}

	public Class getField() {
		return field;
	}

	public void setField(Class field) {
		this.field = field;
	}
	
	public InnerS() {}

	/**
	 * @param field
	 */
	public InnerS(Class field) {
		super();
		this.field = field;
	}
	
	
}
