package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab47 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		CustomerDAO cdao = (CustomerDAO)ctx.getBean("cdao");
		
	
		//	Add customer
			CustomerTO cto = new CustomerTO(3009, "asd", "t@jlc", "Blore", 555555);
			cdao.addCustomer(cto);
			System.out.println("customer Added........");
			
		//	update customer
			CustomerTO cto1 = new CustomerTO(101, "xyz", "x@jlc", "Blore", 22222);
			cdao.updateCustomer(cto1);
			System.out.println("customer Updated........");
			
		//	delete customer
			cdao.deleteCustomer(107);
			System.out.println("customer Deleted........");
		
		
		
	//	get customers by cid
		System.out.println("customers by cid...................");
		CustomerTO cto2 = cdao.getCustomerByCid(101);
		System.out.println(cto2);
	
	//	get All customers
		System.out.println("All customers...................");
		List<CustomerTO> list = cdao.getAllCustomers();
		for(CustomerTO ct : list)
			System.out.println(ct);
				
	}
}
