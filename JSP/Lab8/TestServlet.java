package com.jlc;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		// 1. Collect Parameters
		String sn = req.getParameter("sname");
		String em = req.getParameter("email");
		String ems[] = req.getParameterValues("email");
		System.out.println(sn);
		System.out.println(em);
		for(String s : ems)
		System.out.println(s);
		
		// 2. Collect headers
		String ho = req.getHeader("host");
		String re = req.getHeader("referer");
		String al = req.getHeader("accept-laguage");
		String ae = req.getHeader("accept-encoding");
		System.out.println(ho);
		System.out.println(re);
		System.out.println(al);
		System.out.println(ae);
		
		// 3. Collect Cookies
		Cookie ck[] = req.getCookies();
		for(Cookie c : ck)
			System.out.println(c+"\t"+c.getName()+"\t"+c.getValue());
		
		Cookie c1 = new Cookie("email", "a@b.com");
		Cookie c2 = new Cookie("phone", "1234556");
		res.addCookie(c1);
		res.addCookie(c2);
		RequestDispatcher rd = req.getRequestDispatcher("show.jsp");
		rd.forward(req, res);
	}
	
}














