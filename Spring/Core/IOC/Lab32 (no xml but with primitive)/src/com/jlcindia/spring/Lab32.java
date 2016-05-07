package com.jlcindia.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lab32 {
	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JlcConfig.class);
		Hello h = (Hello)ctx.getBean("hello");
		h.show();
	}
}
