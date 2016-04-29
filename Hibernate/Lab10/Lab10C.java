package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab10C {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			
//		3. Adding the old Student
			OldStudent ostu = new OldStudent("aa", "Blore", "enabled", 15000.0, "sdsoft", "aa@sd.com", 9.0);
			ostu.setSid(1);
			session.save(ostu);
			
			tx.commit();
			session.close();		
			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)
				tx.rollback();
		}
	}
}
