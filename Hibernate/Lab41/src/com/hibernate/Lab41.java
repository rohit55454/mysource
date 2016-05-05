package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab41 {
	
	public static void main(String[] args) {
		
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			Customer cust = new Customer("rohit", "a@b.in", 9999);
			Integer it = (Integer)session.save(cust);
			System.out.println(it.intValue());
			
			tx.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
}
