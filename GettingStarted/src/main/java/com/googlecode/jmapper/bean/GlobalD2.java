package com.googlecode.jmapper.bean;

public class GlobalD2 {

	private Double overallCost;

	public GlobalD2() {
	   overallCost = 0D;
	}
	
	public Double getOverallCost() {
		return overallCost;
	}

	public void setOverallCost(Double overallCost) {
		this.overallCost += overallCost;
	}

	@Override
	public String toString() {
		return "GlobalD2 [overallCost=" + overallCost + "]";
	}
}
