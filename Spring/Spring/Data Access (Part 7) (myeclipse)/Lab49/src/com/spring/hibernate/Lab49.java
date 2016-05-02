package com.spring.hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab49 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		HibernateCustomerDAO cdao = (HibernateCustomerDAO)ctx.getBean("cdao");
		
//	
//		//	Add customer
//			CustomerTO cto = new CustomerTO(509, "asd", "t@jlc", "Blore", 555555);
//			cdao.addCustomer(cto);
//			System.out.println("customer Added........");
//			
//		//	update customer
//			CustomerTO cto1 = new CustomerTO(101, "xyz", "x@jlc", "Blore", 222220);
//			cdao.updateCustomer(cto1);
//			System.out.println("customer Updated........");
//			
//		//	delete customer
//			cdao.deleteCustomer(1037);
//			System.out.println("customer Deleted........");
//		
//		//	get customers by cid
//			System.out.println("customers by cid...................");
//			CustomerTO cto2 = cdao.getCustomerByCid(101);
//			System.out.println(cto2);
//		
		//	get All customers
			System.out.println("All customers...................");
			List<CustomerTO> list = cdao.getAllCustomers();
			for(CustomerTO ct : list)
				System.out.println(ct);
			
		//	get customers by email
			System.out.println("get customers by email");
			CustomerTO cto = cdao.getCustomerByEmail("z@jkl");
			System.out.println(cto);
			
		//	get customers by city
			System.out.println("get customers by city");
			list = cdao.getCustomerByCity("Blore");
			
			for(CustomerTO c : list)
				System.out.println(c);
			
		//	get customer Count
			System.out.println("get coustomer count");
			int count = cdao.getCustomerCount();
			System.out.println(count);
			
		//	get Customer city by email
			System.out.println("get Customer city by email");
			String ci = cdao.getCustomerCityByEmail("z@jkl");
			System.out.println(ci);
			
		//	get Customer phone by email
			System.out.println("get Customer phone by email");
			String ph = cdao.getCustomerCityByEmail("z@jkl");
			System.out.println(ph);
			
			
	}
}
