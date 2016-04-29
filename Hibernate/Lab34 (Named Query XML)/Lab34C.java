package com.hibernate;
import java.util.List;

import org.hibernate.*;

public class Lab34C {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

	//		C) Display Customers by email
			
			Query query = session.getNamedQuery("CustomersByEmail");
			query.setString(0, "aa@jlc");
			List<Customer> list = query.list();
			
			System.out.println();
			System.out.println("***************************************************************************");
			System.out.println("no of results : "+list.size());
			
			
			System.out.println("***************************************************************************");
			System.out.println();
			System.out.println("cid"+"\t"+"cname"+"\t"+"email"+"\t"+"city"+"\t"+"cardType"+" "+"status"+"\t\t"+"cardBal"+"\t "+"cardNo");
			System.out.println("==========================================================================");
			
			
			for(Customer cust : list)
				System.out.println(cust);

			tx.commit();
			session.close();
			System.out.println("==========================================================================");
			System.out.println("main completed");
			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}
}
