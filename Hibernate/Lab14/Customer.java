package com.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	@Column(name="cid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int cid;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="aid")
	private Address address;
	
	public Customer(){}
	
	public Customer(String firstname, String lastname, String email, String phone) {
		super();
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.phone = phone;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	
}
