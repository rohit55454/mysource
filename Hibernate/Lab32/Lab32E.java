package com.hibernate;
import java.util.List;

import org.hibernate.*;

public class Lab32E {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

	//		E) Display Customers by email
			
			String hql = "from Customer cust where cust.email=?";
			Query q = session.createQuery(hql);
			q.setString(0, "sri@jlc");

			Customer cust = (Customer)q.uniqueResult();		// for unique result
			System.out.println(cust);

			tx.commit();
			session.close();
			System.out.println("main completed");
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}
}
