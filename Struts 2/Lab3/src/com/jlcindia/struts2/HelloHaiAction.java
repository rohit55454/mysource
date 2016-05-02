package com.jlcindia.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class HelloHaiAction extends ActionSupport{
	
	public String execute() throws Exception {
		System.out.println("HelloHaiAction -- execute()");
		return "hellohai";
	}
}
