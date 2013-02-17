package com.googlecode.jmapper.integrationtest.operations.bean;

public class PrimitiveConversionD {

	private String _stringa;
	private String _stringa2;
	
	private int _int;
	private Integer _integer;
	
	private String _stringa3;
	private int _int2;
	
	public PrimitiveConversionD() {}
	
	@Override
	public String toString() {
		return "PrimitiveConversionD [_stringa=" + _stringa + ", _stringa2="
				+ _stringa2 + ", _int=" + _int + ", _integer=" + _integer
				+ ", _stringa3=" + _stringa3 + ", _int2=" + _int2 + "]";
	}
	/**
	 * @param _stringa
	 * @param _stringa2
	 * @param _int
	 * @param _integer
	 * @param _stringa3
	 * @param _int2
	 */
	public PrimitiveConversionD(String _stringa, String _stringa2, int _int,
			Integer _integer, String _stringa3, int _int2) {
		super();
		this._stringa = _stringa;
		this._stringa2 = _stringa2;
		this._int = _int;
		this._integer = _integer;
		this._stringa3 = _stringa3;
		this._int2 = _int2;
	}
	public String get_stringa() {
		return _stringa;
	}
	public void set_stringa(String _stringa) {
		this._stringa = _stringa;
	}
	public String get_stringa2() {
		return _stringa2;
	}
	public void set_stringa2(String _stringa2) {
		this._stringa2 = _stringa2;
	}
	public int get_int() {
		return _int;
	}
	public void set_int(int _int) {
		this._int = _int;
	}
	public Integer get_integer() {
		return _integer;
	}
	public void set_integer(Integer _integer) {
		this._integer = _integer;
	}
	public String get_stringa3() {
		return _stringa3;
	}
	public void set_stringa3(String _stringa3) {
		this._stringa3 = _stringa3;
	}
	public int get_int2() {
		return _int2;
	}
	public void set_int2(int _int2) {
		this._int2 = _int2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _int;
		result = prime * result + _int2;
		result = prime * result
				+ ((_integer == null) ? 0 : _integer.hashCode());
		result = prime * result
				+ ((_stringa == null) ? 0 : _stringa.hashCode());
		result = prime * result
				+ ((_stringa2 == null) ? 0 : _stringa2.hashCode());
		result = prime * result
				+ ((_stringa3 == null) ? 0 : _stringa3.hashCode());
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
		PrimitiveConversionD other = (PrimitiveConversionD) obj;
		if (_int != other._int)
			return false;
		if (_int2 != other._int2)
			return false;
		if (_integer == null) {
			if (other._integer != null)
				return false;
		} else if (!_integer.equals(other._integer))
			return false;
		if (_stringa == null) {
			if (other._stringa != null)
				return false;
		} else if (!_stringa.equals(other._stringa))
			return false;
		if (_stringa2 == null) {
			if (other._stringa2 != null)
				return false;
		} else if (!_stringa2.equals(other._stringa2))
			return false;
		if (_stringa3 == null) {
			if (other._stringa3 != null)
				return false;
		} else if (!_stringa3.equals(other._stringa3))
			return false;
		return true;
	}
	
	
	
}
