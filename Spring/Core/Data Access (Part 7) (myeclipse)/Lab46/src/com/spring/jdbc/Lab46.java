package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab46 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		CustomerDAO cdao = (CustomerDAO)ctx.getBean("cdao");
		
	//	Add customer
		CustomerTO cto = new CustomerTO(202, "fgh", "r@jlc", "Che", 123456);
		cdao.addCustomer(cto);
		
		System.out.println("call completed");
		
	}
}
