package com.hibernate;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	private int totalQty;
	private double totalCost;
	private Date orderDate;
	private String status;
	@ManyToOne
	@JoinColumn(name="cid", referencedColumnName="cid")
	private Customer customer;
	@OneToOne
	@JoinColumn(name="addid")
	private ShippingAddress address;
	@OneToMany(mappedBy="order")
	private Set<OrderItem> orderitems;
	
	public Order(){}
	public Order(int totalQty, double totalCost, Date orderDate, String status) {
		super();
		this.totalQty = totalQty;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public ShippingAddress getAddress() {
		return address;
	}
	public void setAddress(ShippingAddress address) {
		this.address = address;
	}
	public Set<OrderItem> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(Set<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}
	
	
}
