package com.jlcindia.servlets;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class TestServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		Writer out = res.getWriter();
		out.write("<h1><br>ID : "+sess.getId());
		out.write("<br/>is new ??  :  "+sess.isNew());
		out.write("<br/>getCreationTime()  :  "+sess.getCreationTime());
		out.write("<h1><br>getLastAccessedTime : "+sess.getLastAccessedTime());
		out.write("<h1><br>getMaxInactiveInterval : "+sess.getMaxInactiveInterval());
		out.write("<h1><br>getServletContext : "+sess.getServletContext());
	}
}
