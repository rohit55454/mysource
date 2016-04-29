package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab6A {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			
		//	1. Adding the student
			Student stu = new Student("sri", "Blore", "Enabled", 15000.0);
			Integer it = (Integer)session.save(stu);
			System.out.println(it.intValue());
			
		//	2. Adding the current Student
			CurrentStudent cstu = new CurrentStudent("vas", "Blore", "enabled", 20000.0, 15000.0, "6:30 PM", "BTM");
			it = (Integer)session.save(cstu);
			System.out.println(it.intValue());
			
		//	3. Adding the old Student
			OldStudent ostu = new OldStudent("aa", "Blore", "enabled", 15000.0, "sdsoft", "aa@sd.com", 9.0);
			it = (Integer)session.save(ostu);
			System.out.println(it.intValue());
			
		//	4 . Adding WeekDay Student
			WeekdayStudent wdstu = new WeekdayStudent("bb", "Blore", "enabled", 15000, 20000, "6 pm", "MHA", "m.sc.", "80", 2010);
			it = (Integer)session.save(wdstu);
			System.out.println(it.intValue());
			
		//	5 . Adding Weekend Student
			WeekendStudent wstu = new WeekendStudent("cc", "Blore", "enabled", 15000, 20000, "6 pm", "MHA", "sdsoft", "cc@sd.com", 2010);
			it = (Integer)session.save(wstu);
			System.out.println(it.intValue());
			
			tx.commit();
			session.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)
				tx.rollback();
		}
	}
}
