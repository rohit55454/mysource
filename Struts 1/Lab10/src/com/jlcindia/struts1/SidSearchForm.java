package com.jlcindia.struts1;

import org.apache.struts.validator.ValidatorForm;

public class SidSearchForm extends ValidatorForm{
	private String sid;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
	
}
