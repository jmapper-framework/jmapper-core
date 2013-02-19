package com.googlecode.jmapper.bean;

import com.googlecode.jmapper.annotations.JGlobalMap;

@JGlobalMap("overallCost")
public class GlobalS2 {

	private Double costEmployees;
	private Double costStructure;
	private Double costAdvertising;
	
	public GlobalS2() {}
	
	public GlobalS2(Double costEmployees, Double costStructure,
			Double costAdvertising) {
		super();
		this.costEmployees = costEmployees;
		this.costStructure = costStructure;
		this.costAdvertising = costAdvertising;
	}
	
	public Double getCostEmployees() {
		return costEmployees;
	}
	public void setCostEmployees(Double costEmployees) {
		this.costEmployees = costEmployees;
	}
	public Double getCostStructure() {
		return costStructure;
	}
	public void setCostStructure(Double costStructure) {
		this.costStructure = costStructure;
	}
	public Double getCostAdvertising() {
		return costAdvertising;
	}
	public void setCostAdvertising(Double costAdvertising) {
		this.costAdvertising = costAdvertising;
	}
}
