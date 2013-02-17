package com.googlecode.jmapper.integrationtest.operations.bean;

import com.googlecode.jmapper.annotations.JMap;

public class PrimitiveConversionS {
	@JMap("_stringa")
	private int _int;
	@JMap("_stringa2")
	private Integer _integer;
	@JMap("_int")
	private String _stringa;
	@JMap("_integer")
	private String _stringa2;
	@JMap("_stringa3")
	private Double _double;
	@JMap("_int2")
	private Double _double2;
	
	
	public PrimitiveConversionS() {}
	
	@Override
	public String toString() {
		return "PrimitiveConversionS [_int=" + _int + ", _integer=" + _integer
				+ ", _stringa=" + _stringa + ", _stringa2=" + _stringa2
				+ ", _double=" + _double + ", _double2=" + _double2 + "]";
	}
	/**
	 * @param _int
	 * @param _integer
	 * @param _stringa
	 * @param _stringa2
	 * @param _double
	 * @param _double2
	 */
	public PrimitiveConversionS(int _int, Integer _integer, String _stringa,
			String _stringa2, Double _double, Double _double2) {
		super();
		this._int = _int;
		this._integer = _integer;
		this._stringa = _stringa;
		this._stringa2 = _stringa2;
		this._double = _double;
		this._double2 = _double2;
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
	public Double get_double() {
		return _double;
	}
	public void set_double(Double _double) {
		this._double = _double;
	}
	public Double get_double2() {
		return _double2;
	}
	public void set_double2(Double _double2) {
		this._double2 = _double2;
	}
	
	
}
