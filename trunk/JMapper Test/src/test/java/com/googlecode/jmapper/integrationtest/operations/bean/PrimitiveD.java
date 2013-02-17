package com.googlecode.jmapper.integrationtest.operations.bean;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
public class PrimitiveD {

	private byte byteD;
	private short shortD;
	private int intD;
	private long longD;
	private float floatD;
	private double doubleD;
	private char charD;
	private boolean booleanD;
	private Byte wByteD;
	private Short wShortD;
	private Integer wIntegerD;
	private Long wLongD;
	private Float wFloatD;
	private Double wDoubleD;
	private Character wCharacterD;
	private Boolean wBooleanD;
	private String wStringD;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (booleanD ? 1231 : 1237);
		result = prime * result + byteD;
		result = prime * result + charD;
		long temp;
		temp = Double.doubleToLongBits(doubleD);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(floatD);
		result = prime * result + intD;
		result = prime * result + (int) (longD ^ (longD >>> 32));
		result = prime * result + shortD;
		result = prime * result
				+ ((wBooleanD == null) ? 0 : wBooleanD.hashCode());
		result = prime * result + ((wByteD == null) ? 0 : wByteD.hashCode());
		result = prime * result
				+ ((wCharacterD == null) ? 0 : wCharacterD.hashCode());
		result = prime * result
				+ ((wDoubleD == null) ? 0 : wDoubleD.hashCode());
		result = prime * result + ((wFloatD == null) ? 0 : wFloatD.hashCode());
		result = prime * result
				+ ((wIntegerD == null) ? 0 : wIntegerD.hashCode());
		result = prime * result + ((wLongD == null) ? 0 : wLongD.hashCode());
		result = prime * result + ((wShortD == null) ? 0 : wShortD.hashCode());
		result = prime * result
				+ ((wStringD == null) ? 0 : wStringD.hashCode());
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
		PrimitiveD other = (PrimitiveD) obj;
		if (booleanD != other.booleanD)
			return false;
		if (byteD != other.byteD)
			return false;
		if (charD != other.charD)
			return false;
		if (Double.doubleToLongBits(doubleD) != Double
				.doubleToLongBits(other.doubleD))
			return false;
		if (Float.floatToIntBits(floatD) != Float.floatToIntBits(other.floatD))
			return false;
		if (intD != other.intD)
			return false;
		if (longD != other.longD)
			return false;
		if (shortD != other.shortD)
			return false;
		if (wBooleanD == null) {
			if (other.wBooleanD != null)
				return false;
		} else if (!wBooleanD.equals(other.wBooleanD))
			return false;
		if (wByteD == null) {
			if (other.wByteD != null)
				return false;
		} else if (!wByteD.equals(other.wByteD))
			return false;
		if (wCharacterD == null) {
			if (other.wCharacterD != null)
				return false;
		} else if (!wCharacterD.equals(other.wCharacterD))
			return false;
		if (wDoubleD == null) {
			if (other.wDoubleD != null)
				return false;
		} else if (!wDoubleD.equals(other.wDoubleD))
			return false;
		if (wFloatD == null) {
			if (other.wFloatD != null)
				return false;
		} else if (!wFloatD.equals(other.wFloatD))
			return false;
		if (wIntegerD == null) {
			if (other.wIntegerD != null)
				return false;
		} else if (!wIntegerD.equals(other.wIntegerD))
			return false;
		if (wLongD == null) {
			if (other.wLongD != null)
				return false;
		} else if (!wLongD.equals(other.wLongD))
			return false;
		if (wShortD == null) {
			if (other.wShortD != null)
				return false;
		} else if (!wShortD.equals(other.wShortD))
			return false;
		if (wStringD == null) {
			if (other.wStringD != null)
				return false;
		} else if (!wStringD.equals(other.wStringD))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PrimitiveD:"+newLine+"   byteD=" + byteD + newLine +"   shortD=" + shortD + newLine+"   intD="
				+ intD + newLine+"   longD=" + longD + newLine+"   floatD=" + floatD
				+ newLine+"   doubleD=" + doubleD + newLine+"   charD=" + charD + newLine+"   booleanD="
				+ booleanD + newLine+"   wByteD=" + wByteD + newLine+"   wShortD=" + wShortD
				+ newLine+"   wIntegerD=" + wIntegerD + newLine+"   wLongD=" + wLongD
				+ newLine+"   wFloatD=" + wFloatD + newLine+"   wDoubleD=" + wDoubleD
				+ newLine+"   wCharacterD=" + wCharacterD + newLine+"   wBooleanD=" + wBooleanD
				+ newLine+"   wStringD=" + wStringD;
	}

	public PrimitiveD() {
	}

	/**
	 * @param byteD
	 * @param shortD
	 * @param intD
	 * @param longD
	 * @param floatD
	 * @param doubleD
	 * @param charD
	 * @param booleanD
	 * @param wByteD
	 * @param wShortD
	 * @param wIntegerD
	 * @param wLongD
	 * @param wFloatD
	 * @param wDoubleD
	 * @param wCharacterD
	 * @param wBooleanD
	 * @param wStringD
	 */
	public PrimitiveD(byte byteD, short shortD, int intD, long longD,
			float floatD, double doubleD, char charD, boolean booleanD,
			Byte wByteD, Short wShortD, Integer wIntegerD, Long wLongD,
			Float wFloatD, Double wDoubleD, Character wCharacterD,
			Boolean wBooleanD, String wStringD) {
		super();
		this.byteD = byteD;
		this.shortD = shortD;
		this.intD = intD;
		this.longD = longD;
		this.floatD = floatD;
		this.doubleD = doubleD;
		this.charD = charD;
		this.booleanD = booleanD;
		this.wByteD = wByteD;
		this.wShortD = wShortD;
		this.wIntegerD = wIntegerD;
		this.wLongD = wLongD;
		this.wFloatD = wFloatD;
		this.wDoubleD = wDoubleD;
		this.wCharacterD = wCharacterD;
		this.wBooleanD = wBooleanD;
		this.wStringD = wStringD;
	}

	public byte getByteD() {
		return byteD;
	}

	public void setByteD(byte byteD) {
		this.byteD = byteD;
	}

	public short getShortD() {
		return shortD;
	}

	public void setShortD(short shortD) {
		this.shortD = shortD;
	}

	public int getIntD() {
		return intD;
	}

	public void setIntD(int intD) {
		this.intD = intD;
	}

	public long getLongD() {
		return longD;
	}

	public void setLongD(long longD) {
		this.longD = longD;
	}

	public float getFloatD() {
		return floatD;
	}

	public void setFloatD(float floatD) {
		this.floatD = floatD;
	}

	public double getDoubleD() {
		return doubleD;
	}

	public void setDoubleD(double doubleD) {
		this.doubleD = doubleD;
	}

	public char getCharD() {
		return charD;
	}

	public void setCharD(char charD) {
		this.charD = charD;
	}

	public boolean isBooleanD() {
		return booleanD;
	}

	public void setBooleanD(boolean booleanD) {
		this.booleanD = booleanD;
	}

	public Byte getWByteD() {
		return wByteD;
	}

	public void setWByteD(Byte wByteD) {
		this.wByteD = wByteD;
	}

	public Short getWShortD() {
		return wShortD;
	}

	public void setWShortD(Short wShortD) {
		this.wShortD = wShortD;
	}

	public Integer getWIntegerD() {
		return wIntegerD;
	}

	public void setWIntegerD(Integer wIntegerD) {
		this.wIntegerD = wIntegerD;
	}

	public Long getWLongD() {
		return wLongD;
	}

	public void setWLongD(Long wLongD) {
		this.wLongD = wLongD;
	}

	public Float getWFloatD() {
		return wFloatD;
	}

	public void setWFloatD(Float wFloatD) {
		this.wFloatD = wFloatD;
	}

	public Double getWDoubleD() {
		return wDoubleD;
	}

	public void setWDoubleD(Double wDoubleD) {
		this.wDoubleD = wDoubleD;
	}

	public Character getWCharacterD() {
		return wCharacterD;
	}

	public void setWCharacterD(Character wCharacterD) {
		this.wCharacterD = wCharacterD;
	}

	public Boolean isWBooleanD() {
		return wBooleanD;
	}

	public void setWBooleanD(Boolean wBooleanD) {
		this.wBooleanD = wBooleanD;
	}

	public String getWStringD() {
		return wStringD;
	}

	public void setWStringD(String wStringD) {
		this.wStringD = wStringD;
	}

}
