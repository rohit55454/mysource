package com.hibernate;
import java.util.List;

import org.hibernate.*;

public class Lab32L {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

	//		L) Display Customers by cities
			
			String hql = "from Customer cust where cust.city in (:cities)";
			Query q = session.createQuery(hql);
			q.setParameterList("cities", new String[]{"Blore", "Hyd"});

			List<Customer> list = q.list();
			System.out.println(list.size());

			for(Customer cust : list)
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
