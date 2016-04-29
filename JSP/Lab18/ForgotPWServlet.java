package com.jlc.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlc.jdbc.UserService;

public class ForgotPWServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserService us = new UserService();
		String em = req.getParameter("email");
		String pw = us.getPasswordByEmail(em);
		
		String result ="";
		if(pw!=null){
			result = "pwstatus.jsp";
			req.setAttribute("PASSWORD", pw);
		}else{
			String msg = "Invalid Email- try Again";
			req.setAttribute("MSG", msg);
			result = "forgotpw.jsp";
		}
		RequestDispatcher rd = req.getRequestDispatcher(result);
		rd.forward(req, res);
	}
}
