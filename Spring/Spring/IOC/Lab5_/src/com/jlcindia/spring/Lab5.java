package com.jlcindia.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab5 {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("jlcindia.xml");
		System.out.println("spring container is ready");
		System.out.println("************");
		Hello h = (Hello)ctx.getBean("hello");
		h.show();
		
	}
}
