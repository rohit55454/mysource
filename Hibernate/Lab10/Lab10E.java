package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab10E {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			
//		5 . Adding Weekend Student
			WeekendStudent wstu = new WeekendStudent("cc", "Blore", "enabled", 15000, 20000, "6 pm", "MHA", "sdsoft", "cc@sd.com", 2010);
			wstu.setSid(1);
			session.save(wstu);
			
			tx.commit();
			session.close();		
			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)
				tx.rollback();
		}
	}
}
