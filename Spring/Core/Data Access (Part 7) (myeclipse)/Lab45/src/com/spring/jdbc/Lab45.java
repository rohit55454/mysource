package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab45 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		CustomerDAO cdao = (CustomerDAO)ctx.getBean("cdao");
		
	//	Add customer
		CustomerTO cto = new CustomerTO(1733, "fgh", "r@jlc", "Che", 123456);
		cdao.addCustomer(cto);
		
	//	Get All Customers
		System.out.println("get All Customers");
		List<CustomerTO> list = cdao.getAllCustomers();
		for(CustomerTO ct : list)
			System.out.println(ct);
		
	}
}
