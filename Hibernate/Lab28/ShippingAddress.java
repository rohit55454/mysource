package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ShippingAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addid;
	
	private String street;
	private String city;
	private String state;
	
	@OneToOne
	@JoinColumn(name="addid")
	private Order order;

	public ShippingAddress(){}
	public ShippingAddress(String street, String city, String state) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
	}
	public int getAddid() {
		return addid;
	}
	public void setAddid(int addid) {
		this.addid = addid;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
