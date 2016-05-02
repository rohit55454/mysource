package com.struts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JlcControllerServlet extends HttpServlet{
	LoginAction loginAction = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		loginAction = new LoginAction();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)	throws ServletException, IOException {
		//	1. collect incoming request URI
		String uri = req.getRequestURI();
		String page = "";
		
		//	2. invoke appropriate Action
		if(uri.endsWith("LoginSubmit.jlc")){
			page = loginAction.execute(req, res);
		}
		
		// 3. forward to resultant page
		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, res);
	}
}
