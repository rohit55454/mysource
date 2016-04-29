package com.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab3A {
	public static void main(String[] args) {
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			String cous[] = {"java", "jdbc", "jsp"};
			
			List<String> ems = new ArrayList<>();
			ems.add("aa@jlc");
			ems.add("bb@jlc");
			ems.add("cc@jlc");
			
			List<Integer> maks = new ArrayList<Integer>();
			maks.add(new Integer(100));
			maks.add(new Integer(99));
			maks.add(new Integer(100));
			
			Set<Long> phs = new HashSet<>();
			phs.add(new Long(111));
			phs.add(new Long(222));
			phs.add(new Long(333));
			
			Map<String, Long> refs = new HashMap<>();
			refs.put("aa", new Long(111));
			refs.put("aa", new Long(222));
			refs.put("aa", new Long(333));
			
			Student stu = new Student("sri", "10-10-10", "M.sc.", cous, ems, maks,phs, refs);
			session.save(stu);
			tx.commit();
			session.close();
			
			System.out.println("record inserted");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
