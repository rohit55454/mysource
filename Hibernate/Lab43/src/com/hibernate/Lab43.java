package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab43 {
	
	public static void main(String[] args) {
		
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			Customer cust = new Customer("rohit", "a@b.in", 9999);
			String custId = session.save(cust).toString();
			System.out.println(custId);
			
			tx.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
}
