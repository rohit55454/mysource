package com.jlc.servlets;

import java.io.*;
import com.jlc.jdbc.UserService;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		UserService us = new UserService();
		System.out.println("Login Action Service");
		String un = req.getParameter("username");
		String pw = req.getParameter("password");
		
		int x = us.verifyUser(un, pw);
		HttpSession sess = req.getSession();
		String result="";
		if(x==1){
			sess.setAttribute("UN", un);
			result = "home.jsp";
		}else{
			String msg = "Invalid Username or Password";
			req.setAttribute("MSG", msg);
			result = "index.jsp";
		}
		RequestDispatcher rd = req.getRequestDispatcher(result);
		rd.forward(req, res);
	}
}
