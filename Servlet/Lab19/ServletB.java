package com.jlcindia.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletB extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("B service started");
		RequestDispatcher rd = req.getRequestDispatcher("c.jlc");
		rd.forward(req, res);
		System.out.println("B service finished");
	}
}