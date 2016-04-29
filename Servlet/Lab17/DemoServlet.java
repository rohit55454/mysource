package com.jlcindia.servlets;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class DemoServlet extends HttpServlet{
	@Override
	public void init(ServletConfig sc) throws ServletException {
		System.out.println("*** demoServlet---init()  ***");
		String ci = sc.getInitParameter("city");
		System.out.println(ci);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("*** demoServlet---service()  ***");
		String nm = req.getParameter("name");
		String em = req.getParameter("email");
		String ip = req.getRemoteAddr();
		
		String msg = "<h1>Hello "+nm+"<br>";
		msg = msg+" ur email id is : "+em+"<br>";
		msg = msg+" ur sending request from IP : "+ip;
		req.setAttribute("MSG", msg);
		PrintWriter out = res.getWriter();
		out.println(msg);
	}
	public void destroy(){
		System.out.println("*** demoServlet---destroy()  ***");
	}
}
