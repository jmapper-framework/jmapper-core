package com.googlecode.jmapper.integrationtest.application.bean;


public class Sour {

	String name;
	Integer age;
	Integer salary;
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	public Integer getSalary() {
		return salary;
	}
	
	/**
	 * @param name
	 * @param age
	 * @param salary
	 */
	public Sour(String name, Integer age, Integer salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	
}
