package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab10D {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			
//		4 . Adding WeekDay Student
			WeekdayStudent wdstu = new WeekdayStudent("bb", "Blore", "enabled", 15000, 20000, "6 pm", "MHA", "m.sc.", "80", 2010);
			
			wdstu.setSid(1);
			session.save(wdstu);
			
			tx.commit();
			session.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)
				tx.rollback();
		}
	}
}
