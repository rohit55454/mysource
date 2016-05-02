package com.jlcindia.struts2;

import java.util.Date;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.UrlValidator;

@Results({
	@Result(name="success", value="/home.jsp"),
	@Result(name="failed", value="/test.jsp"),
	@Result(name="input", value="/test.jsp")
})

public class AnnotatedTest extends ActionSupport{
	private String name;
	private int age;
	private double fee;
	private Date dob;
	private String email, web;
	
	@RequiredStringValidator(message="jlc", key="error.nm.required")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@IntRangeFieldValidator(message="jlc", key="error.age.range", min="18", max="28")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@DoubleRangeFieldValidator(message="jlc", key="error.fee.range", minExclusive="100.50", maxExclusive="500.50")
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	
	@RequiredFieldValidator(message="jlc", key="error.dob.required")
	@DateRangeFieldValidator(message="jlc", key="error.dob.range", min="01/01/80", max="01/01/90")
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@RequiredStringValidator(message="jlc", key="error.email.required")
	@EmailValidator(message="jlc", key="error.email.valid")
	@CustomValidator(type="myemail", fieldName="email", message="jlc", key="error.email.domain")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@RequiredStringValidator(message="jlc", key="error.url.required")
	@UrlValidator(message="jlc", key="error.url.valid")
	@CustomValidator(type="myurl", fieldName="web", message="jlc", key="error.url.domain")
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	
	
	public String execute() throws Exception{
		System.out.println(name);
		System.out.println(age);
		System.out.println(fee);
		System.out.println(dob);
		System.out.println(email);
		System.out.println(web);
		return "success";
	}
}
