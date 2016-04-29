package com.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab17A {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Student s1 = new Student("sri", "Sri@jlc", 999999);
			Student s2 = new Student("abc", "abc@jlc", 111111);
			Student s3 = new Student("xyz", "xyz@jlc", 222222);
			session.save(s1);
			session.save(s2);
			session.save(s3);
			
			Course c1 = new Course("java", new Integer(5), 20000);
			Course c2 = new Course("jsp", new Integer(2), 10000);
			Course c3 = new Course("jdbc", new Integer(3), 150000);
			session.save(c1);
			session.save(c2);
			session.save(c3);
			
			Set<Course> cs1 = new HashSet<Course>();
			cs1.add(c1);
			cs1.add(c2);
			s1.setCourses(cs1);
			Set<Course> cs2 = new HashSet<Course>();
			cs2.add(c3);
			cs2.add(c2);
			s2.setCourses(cs2);
			Set<Course> cs3 = new HashSet<Course>();
			cs3.add(c1);
			cs3.add(c3);
			s3.setCourses(cs3);
			
			
			tx.commit();
			session.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)	tx.rollback();
		}
	}
	
}
