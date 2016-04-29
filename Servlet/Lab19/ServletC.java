package com.jlcindia.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletC extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("C service started");
		Writer out = res.getWriter();
		out.write("<h2><br>Check Server Console");
		System.out.println("C service finished");
	}
}