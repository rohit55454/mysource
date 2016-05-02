package com.jlcindia.struts2;

import com.opensymphony.xwork2.Action;

public class HaiAction implements Action{
	
	public String execute() throws Exception {
		System.out.println("HaiAction -- execute()");
		return "hai";
	}
}
