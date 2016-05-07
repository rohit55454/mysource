package com.spring.transaction.jpa;

import javax.persistence.*;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	@Column(name="accno")
	private int accno;
	
	@Column(name="atype")
	private String atype;
	
	@Column(name="bal")
	private double bal;

	public Account(){}

	public Account(String atype, double bal) {
		super();
		this.atype = atype;
		this.bal = bal;
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
	
}
