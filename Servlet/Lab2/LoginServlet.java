package com.jlcindia.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name="myLogin", urlPatterns={"/login.jlc"})

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
			msg = " HA HA HA <br/>login Failed";
		}
		
	//	PREPARING THE RESPONCE
		Writer out = res.getWriter();
		out.write(msg);
	}
}
