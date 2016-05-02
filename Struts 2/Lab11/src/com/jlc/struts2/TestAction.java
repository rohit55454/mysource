package com.jlc.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	private String userId, emailId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	public String test() throws Exception{
		System.out.println(userId);
		System.out.println(emailId);
		if(userId.equals("sd")){
			//throw new Exception();
			Thread.sleep(500);
		}
		return "success";
	}
}
