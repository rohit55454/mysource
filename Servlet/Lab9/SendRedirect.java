package com.jlcindia.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SendRedirect extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

		String page=req.getParameter("page");
		if(page==null || page.trim().length()==0){

			RequestDispatcher rd = null;
			rd = req.getRequestDispatcher("error.html");
			rd.forward(req, res);
			return;
		}
		
		if(page.startsWith("www")){
			page = "http://"+page;
		}
		res.sendRedirect(page);
	}
}