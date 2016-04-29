package com.hibernate;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class Lab33H {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

	//		H) Display Customers by balance Range
			
			Criteria ct = session.createCriteria(Customer.class);
			ct.add(Restrictions.between("cardBal", 25000.0, 40000.0));
			
			List<Customer> list = ct.list();
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
