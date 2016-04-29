package com.hibernate;

import java.util.Map;

//Entity
//PrimaryKeyJoinColumn(name="cid")
public class GoldCustomer extends Customer{
	private long ophone;
	
	//ElementCollection
	//JoinTable(name="refs", joinColumns=
		//JoinColumn(name="cid"))
	private Map<String, String> refs;
	
	private int points;

	public GoldCustomer(){}
	public GoldCustomer(String cname, String email, long phone, long ophone,
			Map<String, String> refs, int points) {
		super(cname, email, phone);
		this.ophone = ophone;
		this.refs = refs;
		this.points = points;
	}
	public long getOphone() {
		return ophone;
	}
	public void setOphone(long ophone) {
		this.ophone = ophone;
	}
	public Map<String, String> getRefs() {
		return refs;
	}
	public void setRefs(Map<String, String> refs) {
		this.refs = refs;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
}
