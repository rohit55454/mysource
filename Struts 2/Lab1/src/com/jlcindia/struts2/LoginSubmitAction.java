package com.jlcindia.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class LoginSubmitAction extends ActionSupport{
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public void validate() {
		System.out.println("validate()........");
		if(username==null || username.length()==0)
			addFieldError("username", "Username is required");
		if(password==null || password.length()==0)
			addFieldError("password", "Password is required");
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("execute() of LoginSubmit.........");
		String result = "";
		if(username.equals(password))
			result = "success";
		else{
			result = "failed";
			addActionError("Invalid username OR Password");
		}
		return result;
	}
}
