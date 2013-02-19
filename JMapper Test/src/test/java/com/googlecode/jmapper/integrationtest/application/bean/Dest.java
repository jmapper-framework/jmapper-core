package com.googlecode.jmapper.integrationtest.application.bean;

import com.googlecode.jmapper.annotations.JMap;

public class Dest {

	@JMap String name;
	@JMap Integer age;
	@JMap Integer salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	public Dest() {}
	/**
	 * @param name
	 * @param age
	 * @param salary
	 */
	public Dest(String name, Integer age, Integer salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Dest [name=" + name + ", age=" + age + ", salary=" + salary
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
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
		Dest other = (Dest) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}
	
	
}
