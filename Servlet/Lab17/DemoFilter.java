package com.jlcindia.servlets;

import java.io.*;
import javax.servlet.*;

public class DemoFilter implements Filter{
	@Override
	public void init(FilterConfig fc) throws ServletException {
		System.out.println("***   Demo Filter --- init()   ***");
		String ci = fc.getInitParameter("city");
		System.out.println(ci);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		System.out.println("***   Demo Filter --- doFilter()   before***");
		String nm = req.getParameter("name");
		String em = req.getParameter("email");
		String ip = req.getRemoteAddr();
		System.out.println(nm);
		System.out.println(em);
		System.out.println(ip);
		
		chain.doFilter(req, res);
		
		System.out.println("***   Demo Filter --- doFilter()   after***");
		Object obj = req.getAttribute("MSG");
		System.out.println(obj);
		String msg = obj.toString();
		System.out.println(msg);
	}
	
	@Override
	public void destroy() {
		System.out.println("***   Demo Filter --- destroy() ***");
		
	}
}
