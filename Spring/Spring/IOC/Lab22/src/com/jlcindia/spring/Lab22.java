package com.jlcindia.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab22 {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("jlcindia.xml");
		TestBean tb = (TestBean)ctx.getBean("test");
		tb.show();
	}
}
