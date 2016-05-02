package com.spring.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

@SuppressWarnings("deprecation")

public class LoginController extends SimpleFormController{

	public ModelAndView onSubmit(Object command, BindException errors) throws ServletException{
		System.out.println("onSubmit().......");
		User user = (User)command;
		String un = user.getUsername();
		String pw = user.getPassword();
		String view = "";
		
		if(un.equals(pw))	view = getSuccessView();
		else				view = getFormView();
		
		return new ModelAndView(view, "user", user);
	}
	
	public Object formBackingObject(HttpServletRequest request) throws ServletException{
		System.out.println("formBackingObject().....");
		User user  = new User();
		user.setUsername("rohit");
		
		return user;
	}
	
}
