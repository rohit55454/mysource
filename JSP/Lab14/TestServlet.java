package com.jlc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String fnm = req.getParameter("fname");
		String eml = req.getParameter("email");
		boolean er = false;
		String page="index.jsp";
		
		if(fnm==null || fnm.trim().length()==0){
			req.setAttribute("fname", "Name is required");
			er=true;
		}
		
		if(eml==null || eml.trim().length()==0){
			req.setAttribute("email", "email is required");
			er=true;
		}
		if(!er){
			page="home.jsp";
			req.getRequestDispatcher(page).forward(req, res);
		}
	}
}
