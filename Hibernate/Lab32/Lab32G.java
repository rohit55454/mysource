package com.hibernate;
import java.util.List;

import org.hibernate.*;

public class Lab32G {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

	//		G) Display Customers by city and status and cardType
			
			String hql = "from Customer cust where cust.city=? and cust.status=? and cust.cardType=?";
			Query q = session.createQuery(hql);
			q.setString(0, "Blore");
			q.setParameter(1, "ACTIVE");
			q.setParameter(2, "visa");

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
