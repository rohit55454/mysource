package com.hibernate;
import java.util.List;

import org.hibernate.*;

public class Lab32D {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

	//		D) Display Customers by status
			
			String hql = "from Customer cust where cust.status=?";
			Query q = session.createQuery(hql);
			q.setString(0, "ACTIVE");
			List<Customer> list = q.list();
			System.out.println(list.size());

			for(Customer cust : list)
				System.out.println(cust);

//			Customer cust = (Customer)q.uniqueResult();		// for unique result
//			System.out.println(cust);
			
			tx.commit();
			session.close();
			System.out.println("main completed");
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}
}
