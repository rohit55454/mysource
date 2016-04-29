package com.jlcindia.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class RemoveServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Writer out = res.getWriter();
		String bnm = req.getParameter("bname");
		Cookie cs[] = req.getCookies();
		if(cs==null){
			out.write("u r new client");
			HttpSession sess = req.getSession();
		}else{
			boolean found = false;
			for(Cookie c : cs){
				String nm = c.getName();
				String val = c.getValue();
				int ver = c.getVersion();
				
				
				if(nm.equals("JSESSIONID"))	{
					found = true;
					out.write("<h2>"+nm+"\t"+val+"\t"+ver);
				}
				else if(nm.equals(bnm)){
					c.setMaxAge(0);
					res.addCookie(c);
				}else{
					out.write("<h2>"+nm+"\t"+val+"\t"+ver);
				}
				
				if(found)
					out.write("u r old client");
				else{
					out.write("u r new client");
					HttpSession sess = req.getSession();
				}
			}
		}
		out.write("<hr/>");
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req, res);
	}
}
