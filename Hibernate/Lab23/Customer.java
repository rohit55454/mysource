package com.hibernate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="cutomersss")		//	will create table named cutomersss
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String cname;
	
	@Embedded
	@AttributeOverrides(value={
			@AttributeOverride(name="street",column=
					@Column(name="mystreet")),
			@AttributeOverride(name="city", column=
					@Column(name="mycity"))
	})
		
	public Address address;
	
	public Customer(){}
	
	public Customer(String cname, Address address) {
		this.cname = cname;
		this.address = address;
	}

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
