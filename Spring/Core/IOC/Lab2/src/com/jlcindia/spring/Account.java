package com.jlcindia.spring;

public class Account {
	private int accNo;
	private String aType;
	private double bal;
	
	private Account(){
		System.out.println("Account---D.C.");
	}
	
	
	public int getAccNo() {
		return accNo;
	}


	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}


	public String getaType() {
		return aType;
	}


	public void setaType(String aType) {
		this.aType = aType;
	}


	public double getBal() {
		return bal;
	}


	public void setBal(double bal) {
		this.bal = bal;
	}


	public String toString() {
		return accNo+"\t"+aType+"\t"+bal;
	}
}
