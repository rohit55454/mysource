package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab7B {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			
			Student st = (Student)session.load(Student.class, 1);
			System.out.println(st);
			tx.commit();
			session.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)	tx.rollback();
		}
	}
}
