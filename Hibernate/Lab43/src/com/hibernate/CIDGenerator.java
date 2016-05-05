package com.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CIDGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SessionImplementor si, Object obj) throws HibernateException {
		
		String sid = "C-001";
		try{
			Session s = (Session)si;
			Transaction tx = s.getTransaction();
			Query q1 = s.createQuery("from customer cust");
			int size = q1.list().size();
			
			if(size != 0){
				Query query = s.createQuery("select max(cust.cid) from Customer cust");
				List list = query.list();
				System.out.println(list.size());
				Object o = list.get(0);
				System.out.println(o);
				String id = "";
				id = o.toString();
				String p2 = id.substring(2);
				int x = Integer.parseInt(p2);
				x = x+1;
				if(x <= 9){
					sid = "C-00"+x;
				}else if (x <= 99) {
					sid = "C-0"+x;
				}else if (x <= 999) {
					sid = "C-"+x;
				}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return sid;
	}
	
	
	
}
