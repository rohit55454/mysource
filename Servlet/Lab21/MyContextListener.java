package com.jlcindia.servlets;

import javax.servlet.*;

public class MyContextListener implements ServletContextListener{

	public MyContextListener(){
		System.out.println("MyContextListener Def cons");
	}
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		ServletContext ctx = event.getServletContext();
		System.out.println("******context destroyed****"+ctx);
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext ctx = event.getServletContext();
		System.out.println("******context initialized****"+ctx);
	}
	
}
