package com.hibernate;
import java.util.List;

import org.hibernate.*;

public class Lab32N {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

	//		N) Display Customers by city with Pagination
			
			String hql = "from Customer cust where cust.city=?";
			Query q = session.createQuery(hql);
			
			q.setString(0, "Blore");
			q.setFirstResult(0);
			q.setMaxResults(2);

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
