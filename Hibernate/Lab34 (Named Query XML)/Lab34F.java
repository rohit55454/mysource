package com.hibernate;
import java.util.List;

import org.hibernate.*;

public class Lab34F {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

	//		E) Display Customers with Pagination
			
			String sql = "select * from customers";
			SQLQuery sq = session.createSQLQuery(sql);
			List<Object[]> list = sq.list();
			
			System.out.println();
			System.out.println("***************************************************************************");
			System.out.println("no of results : "+list.size());
			
			
			System.out.println("***************************************************************************");
			System.out.println();
			System.out.println("cid"+"\t"+"cname"+"\t"+"email"+"\t"+"city"+"\t"+"cardType"+" "+"status"+"\t\t"+"cardBal"+"\t "+"cardNo");
			System.out.println("==========================================================================");
			
			for(Object obj[]: list)
				for(Object o : obj)
				System.out.println(obj);

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
