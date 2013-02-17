package com.googlecode.jmapper.integrationtest.operations.bean;


public class InnerD {

	private Class field;
	
		public static class Class {
			private String field;
			private String field2;
			private String field3;
	
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

			@Override
			public String toString() {
				return "Class [field=" + field + ", field2=" + field2
						+ ", field3=" + field3 + "]";
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result
						+ ((field == null) ? 0 : field.hashCode());
				result = prime * result
						+ ((field2 == null) ? 0 : field2.hashCode());
				result = prime * result
						+ ((field3 == null) ? 0 : field3.hashCode());
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
				Class other = (Class) obj;
				if (field == null) {
					if (other.field != null)
						return false;
				} else if (!field.equals(other.field))
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
		
	public Class getField() {
		return field;
	}


	public void setField(Class field) {
		this.field = field;
	}

	public InnerD() {}


	/**
	 * @param field
	 */
	public InnerD(Class field) {
		super();
		this.field = field;
	}


	@Override
	public String toString() {
		return "InnerD [field=" + field + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((field == null) ? 0 : field.hashCode());
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
		InnerD other = (InnerD) obj;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		return true;
	}

	
}
