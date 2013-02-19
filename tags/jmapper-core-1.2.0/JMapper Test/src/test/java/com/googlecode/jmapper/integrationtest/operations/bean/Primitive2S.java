package com.googlecode.jmapper.integrationtest.operations.bean;

import com.googlecode.jmapper.annotations.JMap;


public class Primitive2S {
	@JMap("integerWD")	private int intS;
	@JMap("floatWD")	private float floatS;
	@JMap("booleanWD")	private boolean booleanS;
	@JMap("intD")		private Integer integerWS;
	@JMap("floatD")		private Float floatWS;
	@JMap("booleanD")	private Boolean booleanWS;
	
		public Primitive2S(int intS, float floatS, boolean booleanS,
				Integer integerWS, Float floatWS, Boolean booleanWS) {
		super();
		this.intS = intS;
		this.floatS = floatS;
		this.booleanS = booleanS;
		this.integerWS = integerWS;
		this.floatWS = floatWS;
		this.booleanWS = booleanWS;
	}

	public int getIntS() {
		return intS;
	}
	public void setIntS(int intS) {
		this.intS = intS;
	}
	public float getFloatS() {
		return floatS;
	}
	public void setFloatS(float floatS) {
		this.floatS = floatS;
	}
	public boolean isBooleanS() {
		return booleanS;
	}
	public void setBooleanS(boolean booleanS) {
		this.booleanS = booleanS;
	}
	public Integer getIntegerWS() {
		return integerWS;
	}
	public void setIntegerWS(Integer integerWS) {
		this.integerWS = integerWS;
	}
	public Float getFloatWS() {
		return floatWS;
	}
	public void setFloatWS(Float floatWS) {
		this.floatWS = floatWS;
	}
	public Boolean isBooleanWS() {
		return booleanWS;
	}
	public void setBooleanWS(Boolean booleanWS) {
		this.booleanWS = booleanWS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (booleanS ? 1231 : 1237);
		result = prime * result
				+ ((booleanWS == null) ? 0 : booleanWS.hashCode());
		result = prime * result + Float.floatToIntBits(floatS);
		result = prime * result + ((floatWS == null) ? 0 : floatWS.hashCode());
		result = prime * result + intS;
		result = prime * result
				+ ((integerWS == null) ? 0 : integerWS.hashCode());
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
		Primitive2S other = (Primitive2S) obj;
		if (booleanS != other.booleanS)
			return false;
		if (booleanWS == null) {
			if (other.booleanWS != null)
				return false;
		} else if (!booleanWS.equals(other.booleanWS))
			return false;
		if (Float.floatToIntBits(floatS) != Float.floatToIntBits(other.floatS))
			return false;
		if (floatWS == null) {
			if (other.floatWS != null)
				return false;
		} else if (!floatWS.equals(other.floatWS))
			return false;
		if (intS != other.intS)
			return false;
		if (integerWS == null) {
			if (other.integerWS != null)
				return false;
		} else if (!integerWS.equals(other.integerWS))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Primitive2S [intS=" + intS + ", floatS=" + floatS
				+ ", booleanS=" + booleanS + ", integerWS=" + integerWS
				+ ", floatWS=" + floatWS + ", booleanWS=" + booleanWS + "]";
	}
}
