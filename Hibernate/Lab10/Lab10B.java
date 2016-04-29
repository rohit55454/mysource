package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab10B {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			
//		2. Adding the current Student
			CurrentStudent cstu = new CurrentStudent("vas", "Blore", "enabled", 20000.0, 15000.0, "6:30 PM", "BTM");
			cstu.setSid(1);
			session.save(cstu);
			
			tx.commit();
			session.close();
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)
				tx.rollback();
		}
	}
}
