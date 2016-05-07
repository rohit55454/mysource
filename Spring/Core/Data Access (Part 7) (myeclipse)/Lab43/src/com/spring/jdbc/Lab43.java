package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab43 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		CustomerDAO cdao = (CustomerDAO)ctx.getBean("cdao");
		
	//	Add customer
		CustomerTO cto = new CustomerTO(1550, "asd", "t@jlc", "Blore", 555555);
		cdao.addCustomer(cto);
		System.out.println("customer Added........");
		
	//	update customer
		CustomerTO cto1 = new CustomerTO(101, "xyz", "x@jlc", "Blore", 22222);
		cdao.updateCustomer(cto1);
		System.out.println("customer Updated........");
		
	//	delete customer
		cdao.deleteCustomer(107);
		System.out.println("customer Deleted........");
		
	}
}
