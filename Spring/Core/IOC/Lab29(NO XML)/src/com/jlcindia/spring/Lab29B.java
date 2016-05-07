package com.jlcindia.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lab29B {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(HelloConfig.class);
		ctx.register(HaiConfig.class);
		ctx.refresh();						//	mandatory
		
		System.out.println("now spring container is ready");

		Hello h1 = (Hello)ctx.getBean(Hello.class);
		h1.show();
		
		Hai hai1 = (Hai)ctx.getBean(Hai.class);
		hai1.show();
		
	}
	
	
}
