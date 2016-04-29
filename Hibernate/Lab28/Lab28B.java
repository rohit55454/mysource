package com.hibernate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab28B {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			CreditCard cc1 = new CreditCard(111, "Visa", 1111, new Date());
			session.save(cc1);
			
			SilverCustomer c1= new SilverCustomer("aa", "aa@jlc", 0000, "Blore", 10, "a@jlc");
			c1.setCcard(cc1);
			session.save(c1);
			
			Map<String, String> refs = new HashMap<>();
			refs.put("AA", "11");
			refs.put("BB", "22");
			
			CreditCard cc2 = new CreditCard(222, "Amex", 2222, new Date());
			session.save(cc2);
			
			GoldCustomer c2 = new GoldCustomer("qq", "qq@jlc", 7777, 6666, refs, 100);
			c2.setCcard(cc2);
			session.save(c2);
			
			tx.commit();
			session.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)	tx.rollback();
		}
	}
}
