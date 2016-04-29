package com.hibernate;
import java.util.List;

import org.hibernate.*;

public class Lab34B {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

	//		B) Display Customers by city
			
			Query query = session.getNamedQuery("CustomersByCity");
			query.setString(0, "Blore");
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
