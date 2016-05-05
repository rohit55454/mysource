package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab42 {
	
	public static void main(String[] args) {
		
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			Customer cust = new Customer("C-101", "rohit", "a@b.in", 9999);
			String custId = session.save(cust).toString();
			System.out.println(custId);
			session.flush();
			tx.commit();
			
			tx = session.beginTransaction();
			Customer cu = (Customer)session.load(Customer.class, "4028f081545e3aa401545e3aa6d70000");
			System.out.println(cu.getCid()+"..."+cu.getCname()+"..."+cu.getEmail()+"..."+cu.getPhone());
			
			tx.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
}
