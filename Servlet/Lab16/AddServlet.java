package com.jlcindia.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class AddServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Writer out = res.getWriter();
		String bnm = req.getParameter("bname");
		Cookie c1 = new Cookie(bnm, bnm);
		res.addCookie(c1);
		out.write("<html><h2>"+bnm+" : "+bnm);
		Cookie cs[] = req.getCookies();
		if(cs==null){
			out.write("<br><marquee>u r new client</marquee>");
			HttpSession sess = req.getSession();
		}else{
			boolean found = false;
			for(Cookie c : cs){
				String nm = c.getName();
				String val = c.getValue();
				int ver = c.getVersion();
				out.write("<h2>"+nm+"........"+val+"........"+ver);
				
				if(nm.equals("JSESSIONID"))		found = true;
			}
			if(found)
				out.write("<br><marquee>u r old client</marquee>");
			else{
				out.write("<br><marquee>u r new client</marquee>");
				HttpSession sess = req.getSession();
			}
		}
		out.write("<hr>");
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req, res);
	}
}
