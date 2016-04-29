package com.jlcindia.listener;

import javax.servlet.*;

public class MyContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Context destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("context initialized");
		ServletContext ctx = event.getServletContext();
		ctx.setAttribute("TV", 0);
		ctx.setAttribute("TA", 0);
	}
	
}
