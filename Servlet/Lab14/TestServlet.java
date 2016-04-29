package com.jlcindia.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class TestServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		Writer out = res.getWriter();
		out.write("<h1><br>ID : "+sess.getId());
		out.write("<br> isNew(): "+sess.isNew());
	}
}
