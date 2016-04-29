package com.jlcindia.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

		RequestDispatcher rd1 = req.getRequestDispatcher("header.html");
		rd1.include(req, res);

		RequestDispatcher rd2 = req.getRequestDispatcher("home.html");
		rd2.include(req, res);
		
		RequestDispatcher rd3 = req.getRequestDispatcher("footer.html");
		rd3.include(req, res);
	}
}
