package com.jlcindia.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
	//	COLLECTING DATA
		String unm = req.getParameter("username");
		String pwd = req.getParameter("password");
		String msg = "";
		
	//	VERIFYING CLIENT DATA
		if(unm.equals(pwd)){
			msg = "<h1>Login SUCCESS !!!!!!</h1>";
		}else {
			msg = "login Failed";
		}
		
	//	PREPARING THE RESPONSE
		Writer out = res.getWriter();
		out.write(msg);
	}
}
