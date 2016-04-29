package com.hibernate;
import org.hibernate.*;

public class Lab21A {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Customer cust = new Customer("sri", "sri@jlc.com", 1234);
			session.save(cust);
			tx.commit();
			session.close();
			System.out.println("record inserted");
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}
}
