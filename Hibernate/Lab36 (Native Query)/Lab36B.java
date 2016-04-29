package com.hibernate;
import java.util.List;

import org.hibernate.*;

public class Lab36B {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

	//		B) Display Customers by city
			
			String sql = "select {cust.*} from customers cust where cust.city=?";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("cust", Customer.class);
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
