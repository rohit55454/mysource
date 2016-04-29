package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Request {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer reqId;
	private String ReqDate;
	private String description;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="mycid", referencedColumnName="cid")
	private Customer customer;
	
	public Request(){}
	public Request(String reqDate, String description, String status) {
		super();
		ReqDate = reqDate;
		this.description = description;
		this.status = status;
	}
	public Integer getReqId() {
		return reqId;
	}
	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}
	public String getReqDate() {
		return ReqDate;
	}
	public void setReqDate(String reqDate) {
		ReqDate = reqDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
}
