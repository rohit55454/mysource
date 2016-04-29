package com.hibernate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class Lab33E {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

	//		E) Display Customers by email
			
			Criteria ct = session.createCriteria(Customer.class);
			ct.add(Restrictions.eq("email", "aa@jlc"));

			Customer cust = (Customer)ct.uniqueResult();		// for unique result
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
