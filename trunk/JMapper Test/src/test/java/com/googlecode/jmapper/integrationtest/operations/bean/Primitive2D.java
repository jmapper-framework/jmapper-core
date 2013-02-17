package com.googlecode.jmapper.integrationtest.operations.bean;

public class Primitive2D {

	private int intD;
	private float floatD;
	private boolean booleanD;
	private Integer integerWD;
	private Float floatWD;
	private Boolean booleanWD;
	
	public Primitive2D() {}
	
	public Primitive2D(int intD, float floatD, boolean booleanD,
			Integer integerWD, Float floatWD, Boolean booleanWD) {
		super();
		this.intD = intD;
		this.floatD = floatD;
		this.booleanD = booleanD;
		this.integerWD = integerWD;
		this.floatWD = floatWD;
		this.booleanWD = booleanWD;
	}

	public int getIntD() {
		return intD;
	}
	public void setIntD(int intD) {
		this.intD = intD;
	}
	public float getFloatD() {
		return floatD;
	}
	public void setFloatD(float floatD) {
		this.floatD = floatD;
	}
	public boolean isBooleanD() {
		return booleanD;
	}
	public void setBooleanD(boolean booleanD) {
		this.booleanD = booleanD;
	}
	public Integer getIntegerWD() {
		return integerWD;
	}
	public void setIntegerWD(Integer integerWD) {
		this.integerWD = integerWD;
	}
	public Float getFloatWD() {
		return floatWD;
	}
	public void setFloatWD(Float floatWD) {
		this.floatWD = floatWD;
	}
	public Boolean isBooleanWD() {
		return booleanWD;
	}
	public void setBooleanWD(Boolean booleanWD) {
		this.booleanWD = booleanWD;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (booleanD ? 1231 : 1237);
		result = prime * result
				+ ((booleanWD == null) ? 0 : booleanWD.hashCode());
		result = prime * result + Float.floatToIntBits(floatD);
		result = prime * result + ((floatWD == null) ? 0 : floatWD.hashCode());
		result = prime * result + intD;
		result = prime * result
				+ ((integerWD == null) ? 0 : integerWD.hashCode());
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
		Primitive2D other = (Primitive2D) obj;
		if (booleanD != other.booleanD)
			return false;
		if (booleanWD == null) {
			if (other.booleanWD != null)
				return false;
		} else if (!booleanWD.equals(other.booleanWD))
			return false;
		if (Float.floatToIntBits(floatD) != Float.floatToIntBits(other.floatD))
			return false;
		if (floatWD == null) {
			if (other.floatWD != null)
				return false;
		} else if (!floatWD.equals(other.floatWD))
			return false;
		if (intD != other.intD)
			return false;
		if (integerWD == null) {
			if (other.integerWD != null)
				return false;
		} else if (!integerWD.equals(other.integerWD))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Primitive2D [intD=" + intD + ", floatD=" + floatD
				+ ", booleanD=" + booleanD + ", integerWD=" + integerWD
				+ ", floatWD=" + floatWD + ", booleanWD=" + booleanWD + "]";
	}
	
	
}
