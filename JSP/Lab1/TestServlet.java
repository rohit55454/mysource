package com.jlcindia.jsp;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String fnm = req.getParameter("fname");
		Date dt = new Date();
		
		if(fnm == null || fnm.trim().length()==0)
			fnm = "Guest";
		
		String msg = "<h1>Hello "+fnm +" <br>You have sent request on "+dt;
		res.setContentType("text/html");
		res.getWriter().write(msg);
	}
}
