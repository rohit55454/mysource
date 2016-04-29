package com.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.service.LoginService;

public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String un = req.getParameter("username");
		String pw = req.getParameter("password");
		
		LoginService serv = new LoginService();
		boolean result = serv.validate(un, pw);
		
		if(result){
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, res);
			req.setAttribute("un", un);
			return;
		}
		else{
			res.sendRedirect("login.jsp");
			return;
		}
	}
}
