package com.googlecode.jmapper.bean;

import java.util.Date;

public class DynamicD2 {

	private String id;
	private Integer quantity;
	private Date purchase;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Date getPurchase() {
		return purchase;
	}
	public void setPurchase(Date purchase) {
		this.purchase = purchase;
	}
	
	public DynamicD2() {}

	public DynamicD2(String id, Integer quantity, Date purchase) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.purchase = purchase;
	}
	@Override
	public String toString() {
		return "DynamicD2:\n id = " + id + "\n quantity = " + quantity + "\n purchase = " + purchase;
	}
	
	
}
