package com.spring.jdbc;

public class CustomerTO {
	private int cid;
	private String cname, email, city;
	private long phone;
	
	public CustomerTO(){}
	
	public CustomerTO(int cid, String cname, String email, String city,
			long phone) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.email = email;
		this.city = city;
		this.phone = phone;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "CustomerTO [cid=" + cid + ", cname=" + cname + ", email="
				+ email + ", city=" + city + ", phone=" + phone + "]";
	}
	
	
}
