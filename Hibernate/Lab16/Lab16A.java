package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab16A {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Customer cust = new Customer("rohit", "sachan", "rohit@gmail", 9999999); 
			session.save(cust);
			
			Request r1 = new Request("11/3/1234", "hello1", "ok1");
			Request r2 = new Request("22/6/8974", "hello2", "ok2");
			session.save(r1);
			session.save(r2);
			
			r1.setCustomer(cust);
			r2.setCustomer(cust);
			
			tx.commit();
			session.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)	tx.rollback();
		}
	}
	
}
