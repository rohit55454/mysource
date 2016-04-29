package com.jlc.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.jlc.actions.*;

public class JLCControllerServlet extends HttpServlet{
	LoginAction loginAction = null;
	RegisterAction regAction = null;
	ForgotPWAction fPWAction = null;
	JLCBaseAction action = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		loginAction = new LoginAction();
		regAction = new RegisterAction();
		fPWAction = new ForgotPWAction();
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("JLCController Service Proccessing");
		String URI = req.getRequestURI();
		System.out.println("requesting the URI : "+URI);
		if(URI.endsWith("login.jlc"))
			action = loginAction;
		else if(URI.endsWith("register.jlc"))
			action = regAction;
		else if(URI.endsWith("forgotpw.jlc"))
			action = fPWAction;
		
		String result = "";
		
		try{
			result = action.process(req, res);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("resultant resource : "+result);
		RequestDispatcher rd = req.getRequestDispatcher(result);
		rd.forward(req, res);
		System.out.println("JLCControllerServlet Processing Completed");
	}
}
