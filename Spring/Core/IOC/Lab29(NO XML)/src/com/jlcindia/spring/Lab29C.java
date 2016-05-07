package com.jlcindia.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lab29C {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.jlcindia.spring");
		ctx.refresh(); 					//	mandatory
		System.out.println("now spring container is ready");
		
		Hello h1 = (Hello)ctx.getBean(Hello.class);
		h1.show();
		
		Hai hai1 = (Hai)ctx.getBean(Hai.class);
		hai1.show();

	}
	
}
