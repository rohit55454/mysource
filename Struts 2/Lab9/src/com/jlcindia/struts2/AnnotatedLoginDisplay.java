package com.jlcindia.struts2;

import org.apache.struts2.config.Result;

import com.opensymphony.xwork2.ActionSupport;

@Result(name="success", value="/login.jsp")
public class AnnotatedLoginDisplay extends ActionSupport{
	
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
