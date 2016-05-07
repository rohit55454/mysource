package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab44 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		CustomerDAO cdao = (CustomerDAO)ctx.getBean("cdao");
		
	//	get customers by cid
		System.out.println("customers by cid...................");
		CustomerTO cto = cdao.getCustomerByCid(101);
		System.out.println(cto);
	
	//	get All customers
		System.out.println("All customers...................");
		List<CustomerTO> list = cdao.getAllCustomers();
		for(CustomerTO ct : list)
			System.out.println(ct);
		
	//	get customers by email
		System.out.println("by email...................");
		cto = cdao.getCustomerByEmail("x@jlc");
		System.out.println(cto);
		
	//	get customers by city
		System.out.println("by city...................");
		list = cdao.getCustomerByCity("Blore");
		for(CustomerTO ct : list)
			System.out.println(ct);
		
		
	//	get customer count
		System.out.println("Total count of customers...................");
		int count = cdao.getCustomersCount();
		System.out.println(count);
		
	//	get customer city by email
		
	//	get customer phone by email
		System.out.println("customer phone by email...................");
		Long ph = cdao.getCustomerPhoneByEmail("x@jlc");
		System.out.println(ph);
		
	}
}
