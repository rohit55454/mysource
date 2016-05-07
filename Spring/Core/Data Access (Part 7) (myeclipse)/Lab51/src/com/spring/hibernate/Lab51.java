package com.spring.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab51 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		HibernateCustomerDAO cdao = (HibernateCustomerDAO)ctx.getBean("cdao");
		
		CustomerTO cto = new CustomerTO("rohit", "a@jlc", "Blore", 111111);
		cdao.addCustomer(cto);
		System.out.println("added.........check ur database....");
		
			
	}
}
