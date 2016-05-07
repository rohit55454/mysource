package com.jlcindia.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lab33 {
	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JlcConfig.class);
		System.out.println("now container is ready");
		Hello h = (Hello)ctx.getBean(Hello.class);
		h.show();
		ctx.registerShutdownHook();
	}
}
