package com.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@WebListener
public class Log4jUtil implements ServletContextListener{
	Logger log = Logger.getLogger(Log4jUtil.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		PropertyConfigurator.configure("D:\\Development\\MyEclipseProjects\\ToolsRelated\\jlc-log4j.properties");
		log.info("Log4j System initialized");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
