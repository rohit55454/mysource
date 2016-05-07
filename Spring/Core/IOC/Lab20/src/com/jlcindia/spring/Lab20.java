package com.jlcindia.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab20 {
	public static void main(String[] args) {

		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("jlcindia.xml");
	//	AbstractApplicationContext ctx1 = new FileSystemXmlApplicationContext("D:/folder");
		System.out.println("spring container is ready");
		System.out.println("************");
		Hello h = (Hello)ctx.getBean("HELLO");
		h.show();
		System.out.println("************");
		System.out.println("Spring container is going to shutDown");
		ctx.registerShutdownHook();
		
	}
}
