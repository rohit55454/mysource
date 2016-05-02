package com.jlcindia.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class AddStudentSubmitAction extends ActionSupport{
	private String sname, email, phone;

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public void validate() {
		System.out.println("AddStudentSubmitAction--validate().......");
	/*	
		if(sname==null || sname.length()==0)
			addActionError("name is mandatory");
		if(email==null || email.length()==0)
			addActionError("email is mandatory");
		if(phone==null || phone.length()==0)
			addActionError("phone is mandatory");
	 */

		if(sname==null || sname.length()==0)
			addFieldError("sname",getText("errors.sname.required"));
		if(email==null || email.length()==0)
			addFieldError("email",getText("errors.email.required"));
		if(phone==null || phone.length()==0)
			addFieldError("phone",getText("errors.phone.required"));
	}
	
	public String execute() throws Exception{
			System.out.println("AddStudentSubmitAction--execute()");
			System.out.println(sname);
			System.out.println(email);
			System.out.println(phone);
			return "success";
		}
		

}
