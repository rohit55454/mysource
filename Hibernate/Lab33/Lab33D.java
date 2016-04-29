package com.hibernate;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

public class Lab33D {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

	//		D) Display Customers by status
			
			Criteria ct = session.createCriteria(Customer.class);
			ct.add(Restrictions.eq("status", "active"));

			List<Customer> list = ct.list();
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
