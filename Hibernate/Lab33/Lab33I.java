package com.hibernate;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class Lab33I {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

	//		I) Display Customers by balance Range and city
			
			Criteria ct = session.createCriteria(Customer.class);
			Criterion balance =  Restrictions.between("cardBal", 25000.0, 30000.0);
			Criterion city = Restrictions.eq("city", "Blore");
			ct.add(Restrictions.and(balance, city));

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
