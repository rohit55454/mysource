package com.jlcindia.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
		name="haiServ",
		urlPatterns={"/hai.jlc"},
		initParams={
				@WebInitParam(
						name="email",
						value="haisri@jlc.com"
						)
		}
		)

public class HaiServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("service() of HaiServlet");
		String fn = req.getParameter("fname");
		String ph = req.getParameter("phone");
		
		Writer o = res.getWriter();
		res.setContentType("text/html");
		
		o.write("<h1>********response from HaiServlet********");
		o.write("<br/><h2>reqest parameters");
		o.write("<br/>fname : "+fn);
		o.write("<br/>phone : "+ph);
		
		o.write("<br/>********servlet config parameters********");
		ServletConfig cfg = getServletConfig();
		String em = cfg.getInitParameter("email");
		o.write("<br/>"+cfg);
		o.write("<br/>email : "+em);
		
		o.write("<br/>********Servlet context parameter********");
		ServletContext ctx = cfg.getServletContext();
		String web = ctx.getInitParameter("website");
		o.write("<br/>"+ctx);
		o.write("<br/>Web : "+web);
	}

}
