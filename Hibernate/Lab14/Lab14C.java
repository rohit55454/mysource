package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab14C {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Address add1 = (Address)session.load(Address.class, 1);
			System.out.println(add1.getAid()+"\t"+add1.getCity()+"\t"+add1.getStreet()+"\t"+add1.getState());
			
			Customer cust = add1.getCustomer();
			System.out.println(cust.getFirstName()+"\t"+cust.getLastName()+"\t"+cust.getEmail()+"\t"+cust.getPhone());
			
			
			
			
			tx.commit();
			session.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)	tx.rollback();
		}
	}
}
