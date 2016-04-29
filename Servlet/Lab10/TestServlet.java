package com.jlcindia.servlets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TestServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Request Parameter
		String un = req.getParameter("uname");
		String pw = req.getParameter("password");
		
		// Display Request Parameter
		PrintWriter out = res.getWriter();
		out.println("<h1> username : "+un);
		out.println("<h1> password : "+pw);
		out.println("<hr>");
		out.println("request Headers");
		
		// Request headers
		Enumeration e = req.getHeaderNames();
		while(e.hasMoreElements()){
			String hn = e.nextElement().toString();
			String hv = req.getHeader(hn);
			out.println("<br/>"+hn+" : "+hv);
		}
		out.println("<hr>");
		out.println("Locale info");
		
		// Locales supported by browser
		out.println("<br> : req.getLocale() : "+req.getLocale());

		out.println("<hr>");
		out.println("Other info");
		
		// Other info from request
		out.println("<br/> Method "+"\t\t"+req.getMethod());
		out.println("<br/> getRequestURI"+"\t\t"+req.getRequestURI());
		out.println("<br/> getRequestURL"+"\t\t"+req.getRequestURL());
		out.println("<br/> getProtocol"+"\t\t"+req.getProtocol());
		out.println("<br/> getContentLength"+"\t\t"+req.getContentLength());
		out.println("<br/> getContentType"+"\t\t"+req.getContentType());
		out.println("<br/> getRemoteAddr"+"\t\t"+req.getRemoteAddr());
		out.println("<br/> getRemotePort"+"\t\t"+req.getRemotePort());
		out.println("<br/> getRemoteHost"+"\t\t"+req.getRemoteHost());
		out.println("<br/> getServerPort"+"\t\t"+req.getServerPort());
		out.println("<br/> getServerName"+"\t\t"+req.getServerName());
		out.println("<br/> getQueryString"+"\t\t"+req.getQueryString());
		out.println("<br/> getServletPath"+"\t\t"+req.getServletPath());
		out.println("<br/> getContextPath"+"\t\t"+req.getContextPath());
	}
}
