package com.jlcindia.servlets;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.*;

public class MyRequestListener implements ServletRequestListener{

	public MyRequestListener(){
		System.out.println("MyRequestListener def cons");
	}
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("request deatroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("request initialized");
	}
	
}
