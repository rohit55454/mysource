package com.jlcindia.servlets;

import javax.servlet.*;

public class MyContextAttributeListener implements ServletContextAttributeListener{
	
	public MyContextAttributeListener(){
		System.out.println("MyContextAttributeListener def. cons");
	}
	
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		String nm = event.getName();
		String val = event.getValue().toString();
		System.out.println("** Attribute Added  ....  "+nm+"\t"+val);
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		String nm = event.getName();
		String val = event.getValue().toString();
		System.out.println("** Attribute Removed  ....  "+nm+"\t"+val);
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		String nm = event.getName();
		String val = event.getValue().toString();
		System.out.println("** Attribute Removed  ....  "+nm+"\t"+val);
	}
	
}
