package com.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab29A {
	
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			List<String> qualis = new ArrayList<>();
			qualis.add("M.sc.");
			qualis.add("MCA");
			qualis.add("M.Tech.");
			Set<String> exps = new HashSet<>();
			exps.add("Sun");
			exps.add("IBM");
			exps.add("Oracle");
			Author a1 = new Author("sri", "sri@jlc", 99999, new Date(), qualis, exps);
			Author a2 = new Author("vas", "vas@jlc", 11111, new Date(), qualis, exps);
			session.save(a1);
			session.save(a2);
			
			Book b1 = new Book("Java", 1000, 1, "JLC");
			Book b2 = new Book("JDBC", 2000, 2, "JLC");
			Book b3 = new Book("JSP", 3000, 3, "JLC");
			session.save(b1);
			session.save(b2);
			session.save(b3);
			
			Set<Author> as1 = new HashSet<>();
			as1.add(a1);
			Set<Author> as2 = new HashSet<>();
			as2.add(a1);
			as2.add(a2);
			
			b1.setAuthors(as1);
			b2.setAuthors(as2);
			b3.setAuthors(as2);
			
			session.save(b1);
			session.save(b2);
			session.save(b3);
			
			tx.commit();
			session.close();
			System.out.println("Record inserted");
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)	tx.rollback();
		}
	}
}
