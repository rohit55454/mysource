package com.hibernate;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab15B {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Customer cust = (Customer)session.load(Customer.class, 1);
			System.out.println("*******customer info*******");
			System.out.println(cust.getFirstName()+"\t"+cust.getLastName()+"\t"+cust.getEmail()+"\t"+cust.getPhone());
			
			System.out.println("*******Requests info*******");
			Collection<Request> col = cust.getRequests();
			for(Request req : col)
				System.out.println(req.getReqId()+"\t"+req.getReqDate()+"\t"+req.getDescription()+"\t"+req.getStatus());
			
			tx.commit();
			session.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)	tx.rollback();
		}
	}
}
