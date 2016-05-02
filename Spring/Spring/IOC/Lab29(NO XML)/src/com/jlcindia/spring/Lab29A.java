package com.jlcindia.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lab29A {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(HelloConfig.class, HaiConfig.class);
		System.out.println("now spring container is ready");
		
		Hello h = (Hello)ctx.getBean(Hello.class);
		h.show();
		
		Hai hai = (Hai)ctx.getBean(Hai.class);
		hai.show();
		
	}
	
	
}
