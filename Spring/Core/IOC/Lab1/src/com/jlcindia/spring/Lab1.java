package com.jlcindia.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab1 {
	public static void main(String[] args) {
	
	//			without IOC
	// ********************************
//		A aobj = new A();
//		aobj.setA(99);
//		aobj.setMsg("Hello guys");
//		
//		B bobj = new B(88, "Hai guys");
//		Hello hello = new Hello(bobj);
//		hello.setAobj(aobj);
//		hello.show();
	
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jlcindia.xml");
	//	ApplicationContext ctx = new ClassPathXmlApplicationContext("jlcindia1.xml");
	//	ApplicationContext ctx = new ClassPathXmlApplicationContext("jlcindia2.xml");
	//	ApplicationContext ctx = new ClassPathXmlApplicationContext("jlcindia3.xml");
	//	ApplicationContext ctx = new ClassPathXmlApplicationContext("jlcindia4.xml");
	//	ApplicationContext ctx = new ClassPathXmlApplicationContext("jlcindia5.xml");
		System.out.println("spring container is ready");
		System.out.println("************");
		Hello h = (Hello)ctx.getBean("hello");
		System.out.println("************");
		h.show();
		
	}
}
