package com.struts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction {
	public String execute(HttpServletRequest req, HttpServletResponse res)	throws ServletException, IOException {
		String page = "login.jsp";
		boolean validate = true;
		
		//	1. collect the request data
		String un = req.getParameter("username");
		String pw = req.getParameter("password");
		
		//	2. validate input data
		if(un==null || un.trim().isEmpty()){
			req.setAttribute("UN_ERR", "username is mandatory");
			validate = false;
		}
		if(pw==null || pw.trim().isEmpty()){
			req.setAttribute("PW_ERR", "password is mandatory");
			validate = false;
		}
		
		//	3. Interact with model
		if(validate){
			boolean valid = un.equals(pw);
			if(valid){
				page="home.jsp";
				req.setAttribute("UN", un);
			}else{
				req.setAttribute("EMSG", "invalid username or Password");
			}
		}
		
		return page;
	}
}
