package com.jlcindia.struts1;

import org.apache.struts.validator.ValidatorForm;

public class BidSearchForm extends ValidatorForm{
	private String bid;

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

}
