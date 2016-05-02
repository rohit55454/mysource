package com.jlcindia.struts2;

public class User{
	
	private String sname;
	private String email;
	
	public String getSname() {
		System.out.println("getSname");
		return sname;
	}

	public void setSname(String sname) {
		System.out.println("setSname");
		this.sname = sname;
	}

	public String getEmail() {
		System.out.println("getEmail");
		return email;
	}

	public void setEmail(String email) {
		System.out.println("setEmail");
		this.email = email;
	}

}
