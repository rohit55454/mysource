package com.hibernate;
import java.util.List;

import org.hibernate.*;

public class Lab32I {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

	//		I) Display Customers by balance Range and city
			
			String hql = "from Customer cust where cust.cardBal between ? and ? and cust.city=?";
			Query q = session.createQuery(hql);
			q.setDouble(0, 25000.0);
			q.setParameter(1, 30000.0);
			q.setParameter(2, "Blore");

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
