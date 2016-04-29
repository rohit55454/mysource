package com.hibernate;
import java.util.List;

import org.hibernate.*;

public class Lab32A {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

	//		A) Display All Customers
			
			String hql = "from Customer cust";
			Query q = session.createQuery(hql);
			List<Customer> list = q.list();
			System.out.println(list.size());
			
			for(Customer cust : list)
				System.out.println(cust);

		/*	String hql = "from Object obj";
			Query q = session.createQuery(hql);*/
			
			
			tx.commit();
			session.close();
			System.out.println("main completed");
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}
}
