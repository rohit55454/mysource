package com.hibernate;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class Lab33G {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

	//		G) Display Customers by city and status and cardType
			
			Criteria ct = session.createCriteria(Customer.class);
			Criterion city = Restrictions.eq("city", "Blore");
			Criterion status = Restrictions.eq("status", "inactive");
			Criterion cardType = Restrictions.eq("cardType", "visa");
			ct.add(Restrictions.and(city, status, cardType));

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
