package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		Saloon mySaloon = (Saloon)ctx.getBean("mySaloon");
		mySaloon.openSaloon();
		System.out.println("*******************************");
		Saloon proxySaloon = (Saloon)ctx.getBean("proxySaloon");
		proxySaloon.openSaloon();
	
	}
}

/*
 * This is called AOP using proxy. Although MySaloon class was not changed and we managed
 *  to report when a saloon method is called.
 *  
 *  This is how to  manage Transaction without modifying the existing code.
 * 
 */
