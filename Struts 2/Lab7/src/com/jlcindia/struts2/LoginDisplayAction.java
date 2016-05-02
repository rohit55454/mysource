package com.jlcindia.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class LoginDisplayAction extends ActionSupport{
	
	private String username = "JLCINDIA";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String execute(){
		return SUCCESS;
	}
	
}
