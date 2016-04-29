package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab14A {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Customer cust = new Customer("sri", "nivas", "sri@jlc", "9877654444");
			session.save(cust);
			
			Address add = new Address("BTM", "Blore", "KA");
			session.save(add);
			cust.setAddress(add);
			
			tx.commit();
			session.close();
			System.out.println("record inserted");
			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)	tx.rollback();
		}
		
	}
}
