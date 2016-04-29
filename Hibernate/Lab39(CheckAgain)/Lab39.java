package com.hibernate;
import java.util.List;

import org.hibernate.*;

public class Lab39 {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			Query q = session.createQuery("from contact c");
			q.setCacheable(true);
			List<Contact> list = q.list();
			
			for(Contact c : list){
				System.out.println(c);
			}
			System.out.println("*****************");
			
			Query q1 = session.createQuery("from contact c");
			q1.setCacheable(true);
			List<Contact> list1 = q.list();
			
			for(Contact c : list1){
				System.out.println(c);
			}
		
//			Criteria ct = session.createCriteria(Contact.class);
//			ct.setCacheable(true);
//			list = q.list();
//			for(Contact c : list){
//				System.out.println(c);
//			}
			
			tx.commit();
			Thread.currentThread().sleep(2000);
			session.close();
			
		}catch (Exception e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
		}
	}
}
