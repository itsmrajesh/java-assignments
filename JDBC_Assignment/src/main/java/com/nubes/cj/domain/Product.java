package com.nubes.cj.domain;

public class Product {

	private int pid;
	private String pName;
	private double price;
	private double discount;

	public int getpId() {
		return pid;
	}

	public void setpId(int pId) {
		this.pid = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	@Override
	public String toString() {
		return pid+" "+pName+" "+price;
	}

	public Product(int pid, String pName, double price, double discount) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.price = price;
		this.discount = discount;
	}

	public Product(String pName, double price, double discount) {
		super();
		this.pName = pName;
		this.price = price;
		this.discount = discount;
	}
	
	
}
