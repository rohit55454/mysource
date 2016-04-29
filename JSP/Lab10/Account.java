package com.jlc.beans;

public class Account {
	private int accno;
	private String atype;
	private double bal;
	private Address address;
	public Account(int accno, String atype, double bal, Address address) {
		super();
		this.accno = accno;
		this.atype = atype;
		this.bal = bal;
		this.address = address;
	}
	public Account() {
		super();
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
