package com.hibernate;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab18B {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Student cust = (Student)session.load(Student.class, 1);
			System.out.println("*******Student info*******");
			System.out.println(cust.getSname()+"\t"+cust.getEmail()+"\t"+cust.getPhone()+"\t"+cust.getSid());
			
			System.out.println("*******Requests info*******");
			Collection<Course> col = cust.getCourses();
			for(Course req : col)
				System.out.println(req.getCname()+"\t"+req.getCost()+"\t"+req.getCid()+"\t"+req.getDuration());
			
			
			tx.commit();
			session.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)	tx.rollback();
		}
	}
}
