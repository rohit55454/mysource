package com.jlcindia.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class TestServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Test servlet -> service()");
		System.out.println("Accessing session object");
		HttpSession sess = req.getSession();
		String em = req.getParameter("email");
		ServletContext ctx = getServletContext();
		System.out.println("storing attribute in context");
		ctx.setAttribute("email", em);
		System.out.println("replacing Attribute in context");
		ctx.setAttribute("email", "sri@jlc.com");
		System.out.println("removing attribute in context");
		ctx.removeAttribute("email");
		System.out.println("invalidating session object");
		sess.invalidate();
		
		Writer out = res.getWriter();
		out.write("<h1> Verify the server console");
	}
}
