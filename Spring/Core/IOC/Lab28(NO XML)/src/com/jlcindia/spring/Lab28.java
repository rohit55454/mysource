package com.jlcindia.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lab28 {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JLCConfig.class);
		System.out.println("now spring container is ready");
		Hello h1 = (Hello)ctx.getBean(Hello.class);
		h1.show();
		
		Hello h2 = (Hello)ctx.getBean("hello");
		h2.show();
		
		System.out.println(h1==h2);
		
		Hai hai1 = (Hai)ctx.getBean(Hai.class);
		hai1.show();
		
		Hai hai2 = (Hai)ctx.getBean("hai");
		hai2.show();
		
		System.out.println(hai1==hai2);
	}
	
	
}
