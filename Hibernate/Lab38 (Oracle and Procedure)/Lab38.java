package com.hibernate;
import java.util.List;

import org.hibernate.*;

public class Lab38 {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			System.out.println("1. All Contacts");
			Query q1 = session.getNamedQuery("getAllJLCContacts_sp");
			List<Contact> clist1 = q1.list();
			for(Contact c : clist1)
				System.out.println(c.getContactId()+"\t"+c.getFirstName()+"\t"+c.getLastName()+"\t"+c.getEmail()+"\t"+c.getPhone()+"\t"+c.getStatus());
			
			System.out.println("************************************");
			
			System.out.println("2. Active Contacts");
			Query q2 = session.getNamedQuery("getAllActiveJLCContacts_sp");
			q2 = q2.setString("st", "inactive");
			List<Contact> clist2 = q2.list();
			for(Contact c : clist2)
				System.out.println(c.getContactId()+"\t"+c.getFirstName()+"\t"+c.getLastName()+"\t"+c.getEmail()+"\t"+c.getPhone()+"\t"+c.getStatus());
			
			
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
