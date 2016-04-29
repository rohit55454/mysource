package com.jlc.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jlc.jdbc.UserService;
import com.jlc.to.UserTo;

public class RegisterServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserService us = new UserService();
		System.out.println("RegisterServlet -service()");
		
		String fn = req.getParameter("fname");
		String em = req.getParameter("email");
		String ph = req.getParameter("phone");
		String un = req.getParameter("username");
		String pw = req.getParameter("password");
		
		int uid = us.getNextUserId();
		long ph1 = Long.parseLong(ph);
		UserTo uo = new UserTo(uid, fn, em, ph1, un, pw);
		int x = us.registeruser(uo);
		HttpSession sess = req.getSession();
		String result = "";
		if(x==1){
			sess.setAttribute("UN", un);
			result = "home.jsp";
		}else{
			String msg = "Registration failed.........try Again";
			req.setAttribute("MSG", msg);
			result = "register.jsp";
		}
		RequestDispatcher rd = req.getRequestDispatcher(result);
		rd.forward(req, res);
	}
}
