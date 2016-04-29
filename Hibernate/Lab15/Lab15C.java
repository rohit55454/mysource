package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab15C {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			Request req = (Request)session.load(Request.class, 1);
			System.out.println("*** request info***");
			System.out.println(req.getReqId()+"\t"+req.getReqDate()+"\t"+req.getDescription()+"\t"+req.getStatus());

		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)	tx.rollback();
		}
	}
}