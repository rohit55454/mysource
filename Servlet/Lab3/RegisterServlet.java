package com.jlcindia.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
	//	COLLECTING DATA
		String fn = req.getParameter("fname");
		String em = req.getParameter("email");
		String ph = req.getParameter("phone");
		String ge = req.getParameter("gender");
		String ti = req.getParameter("timings");
		String co = req.getParameter("course");
		String cous[] = req.getParameterValues("course");
		String re = req.getParameter("remarks");
	
//		PROCESSING CLIENT DATA
		
		String msg = "ur enquiry has been sumitted.......";
		
		System.out.println("full name : "+fn);
		System.out.println("email : "+em);
		System.out.println("phone : "+ph);
		System.out.println("gender : "+ge);
		System.out.println("timing : "+ti);
		System.out.println("course : "+co);
		System.out.println("all courses : ");
		if(cous!=null)
			for(String s : cous)
				System.out.println(s);
		
		System.out.println("remarks : "+re);
		
		
	//		send responce
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1>my servlet</h1>");
		out.println("<h2>"+ msg +"</h2>");
		out.println("<h2> full name : "+fn);
		out.println("<h2> email id : "+em);
		out.println("<h2> phone no. : "+ph);
		out.println("<h2> gender : "+ge);
		out.println("<h2> timing : "+ti);
		out.println("<h2> course : "+co);
		out.println("<h2> All courses ");
		
		if(cous!=null){
			for(String s : cous)
				out.println("<br/>"+s);
	}
		out.println("remarks : "+re);
	}
}
