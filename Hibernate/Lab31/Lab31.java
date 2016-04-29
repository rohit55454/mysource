package com.hibernate;


public class Lab31 {
	public static void main(String[] args) {
		
		CustomerDAO cdao = DAOFactory.getCustomerDAO();
		
		//	1. Add Customer
		CustomerTO cto = new CustomerTO("sri", "sri@jlc", 111, "Blore", "Active");
		cdao.addCustomer(cto);
		
		/*//	2. get Customer
		CustomerTO c1 = cdao.getCustomerByCid(2);
		System.out.println(c1.getCid()+"\t"+c1.getCname()+"\t"+c1.getEmail()+"\t"+c1.getPhone()+"\t"+c1.getCity()+"\t"+c1.getStatus());
		
		//	3. delete Customer
		cdao.deleteCustomer(3);
		
		//	4. update Customer
		CustomerTO c2 = cdao.getCustomerByCid(2);
		c2.setCname("rohit");
		c2.setEmail("rohit@jlc");
		cdao.updateCustomer(c2);*/
	}
}
