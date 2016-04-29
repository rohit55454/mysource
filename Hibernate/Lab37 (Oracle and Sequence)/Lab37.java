package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab37 {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();


			Contact c1 = new Contact("fn", "ln", "a@jlc", "12-12-2012", "active", 123456);
			Contact c2 = new Contact("fn2", "ln2", "b@jlc", "1-1-1111", "inactive", 111111);
			session.save(c1);
			session.save(c2);
			
			tx.commit();
			session.close();
			System.out.println("==========================================================================");
			System.out.println("main completed");
			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}
}
