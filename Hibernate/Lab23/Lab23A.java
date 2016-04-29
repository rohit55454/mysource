package com.hibernate;
import org.hibernate.*;

public class Lab23A {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Address add = new Address("BTM", "Blore");
			Customer cust = new Customer("sri", add);
			session.save(cust);
			tx.commit();
			session.close();
			System.out.println("record inserted");
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}
}
