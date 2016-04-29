package com.jlcindia.listener;

import javax.servlet.*;
import javax.servlet.http.*;

public class MySessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession sess = event.getSession();
		ServletContext ctx = sess.getServletContext();
		int tv = (Integer)ctx.getAttribute("TV");
		tv++;
		ctx.setAttribute("TV", tv);
		int ta = (Integer)ctx.getAttribute("TA");
		ta++;
		ctx.setAttribute("TA", ta);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession sess = event.getSession();
		ServletContext ctx = sess.getServletContext();
		int ta = (Integer)ctx.getAttribute("TA");
		ta--;
		ctx.setAttribute("TA", ta);
	}

}
