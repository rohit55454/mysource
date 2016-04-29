package com.jlcindia.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		System.out.println("service of test servlet");
		String unm = req.getParameter("uname");
		String pwd = req.getParameter("password");
		Writer out= res.getWriter();
		out.write("<h1>Hi, Welcome to JLC");
		
		String page="";
		boolean check=true;
		if(unm==null || unm.trim().isEmpty()){
			page="/WEB-INF/required.html";
			check=false;
			RequestDispatcher rd = req.getRequestDispatcher(page);
			rd.forward(req, res);
		}else if(pwd==null || pwd.trim().isEmpty()){
			page="/WEB-INF/required.html";
			check=false;
			RequestDispatcher rd = req.getRequestDispatcher(page);
			rd.forward(req, res);
		}
		if(check){
			if(unm.equals(pwd)){
				page="/WEB-INF/home.html";
				RequestDispatcher rd = req.getRequestDispatcher(page);
				rd.forward(req, res);
			}else{
				page="/WEB-INF/error.html";
				RequestDispatcher rd = req.getRequestDispatcher(page);
				rd.forward(req, res);
			}
		}
		out.write("<again welcome to Home>");
		System.out.println("**********Service completed**********");
		
		
	}
}
